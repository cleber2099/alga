package com.algoworks.algalog.controller;

import domain.model.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ClienteController {
    @GetMapping("/clientes")
    public List<Cliente> listar() {
        Cliente cliente1 = new Cliente();
        cliente1.setId(1L);
        cliente1.setNome("joao");
        cliente1.setTelefone("81 99999 9999");
        cliente1.setEmail("joaodascouves@.gmail");

        Cliente cliente2 = new Cliente();
        cliente2.setId(2L);
        cliente2.setNome("maria");
        cliente2.setTelefone("81 88888 9999");
        cliente2.setEmail("maria@.gmail");
        return Arrays.asList(cliente1,cliente2);
    }
}

