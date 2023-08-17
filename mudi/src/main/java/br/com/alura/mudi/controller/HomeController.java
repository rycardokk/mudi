package br.com.alura.mudi.controller;

import br.com.alura.mudi.model.Pedido;
import br.com.alura.mudi.enums.StatusPedido;
import br.com.alura.mudi.repository.PedidoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private PedidoRepository repository;

    @GetMapping()
    public String home(Model model) {

        Sort sort = Sort.by("dataDaEntrega").descending();
        PageRequest paginacao = PageRequest.of(0,4,sort);
        List<Pedido> pedidos = repository.findByStatus(StatusPedido.ENTREGUE, paginacao);
        model.addAttribute("pedidos", pedidos);
        return "home";
    }

}

