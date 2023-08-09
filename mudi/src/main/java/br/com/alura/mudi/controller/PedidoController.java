package br.com.alura.mudi.controller;

import br.com.alura.mudi.dto.RequisicaoNovoPedido;
import br.com.alura.mudi.model.Pedido;
import br.com.alura.mudi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("pedido")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping("formulario")
    public String formulario(RequisicaoNovoPedido req){
        return "pedido/formulario";
    }

    @PostMapping("novo")
    public String novo(RequisicaoNovoPedido req, BindingResult result){
        if (result.hasErrors()){
            return "pedido/formulario";
        }

        Pedido pedido = req.toPedido();
        pedidoRepository.save(pedido);
        return "redirect:/home";
    }
}
