package com.algoworks.algalog.controller;

import com.algoworks.algalog.repository.ClienteRepository;
import com.algoworks.algalog.model.Cliente;
import com.mysql.cj.xdevapi.Client;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
public class ClienteController {
    @Autowired
    ClienteRepository clienteRepository;

    @GetMapping  ("/clientes")
    public List<Cliente> listar() {
       return clienteRepository.findByNome("ele");
    }

    @GetMapping("/clientes/{clienteId}")
    public ResponseEntity<Cliente> buscar (@PathVariable Long clienteId){
         Optional<Cliente> cliente= clienteRepository.findById(clienteId);
        if (cliente.isPresent()){
            return ResponseEntity.ok(cliente.get());
        }
        return  ResponseEntity.notFound().build();
    }

}

