package br.com.alura.mudi.controller;

import br.com.alura.mudi.model.Pedido;
import br.com.alura.mudi.repository.PedidoRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private PedidoRepository repository;

    @GetMapping("/home")
    public String home(Model model) {
        List<Pedido> pedidos = repository.findAll();
        model.addAttribute("pedidos", pedidos);
        return "home";
    }
}

