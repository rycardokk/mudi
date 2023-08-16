package br.com.alura.mudi.controller;

import br.com.alura.mudi.dto.RequisicaoNovoPedido;
import br.com.alura.mudi.model.Pedido;
import br.com.alura.mudi.model.UserModel;
import br.com.alura.mudi.repository.PedidoRepository;
import br.com.alura.mudi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("pedido")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    //@Autowired
    //private UserRepository userRepository;

    @GetMapping("formulario")
    public String formulario(RequisicaoNovoPedido req){
        return "pedido/formulario";
    }

    @PostMapping("novo")
    public String novo(RequisicaoNovoPedido req, BindingResult result){
        if (result.hasErrors()){
            return "pedido/formulario";
        }

        //String username = SecurityContextHolder.getContext().getAuthentication().getName();
       // Optional<UserModel> user = userRepository.findByUsername(username);
        Pedido pedido = req.toPedido();
       // pedido.setUser(user);
        pedidoRepository.save(pedido);
        return "redirect:/home";
    }
}
