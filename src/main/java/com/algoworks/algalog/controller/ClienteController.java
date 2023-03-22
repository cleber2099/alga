package com.algoworks.algalog.controller;

import com.algoworks.algalog.repository.ClienteRepository;
import com.algoworks.algalog.model.Cliente;
import com.mysql.cj.xdevapi.Client;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    ClienteRepository clienteRepository;

    @GetMapping
    public List<Cliente> listar() {
       return clienteRepository.findAll();
    }

    @GetMapping("/{clienteId}")
    public ResponseEntity<Cliente> buscar (@PathVariable Long clienteId){
         Optional<Cliente> cliente= clienteRepository.findById(clienteId);
        if (cliente.isPresent()){
            return ResponseEntity.ok(cliente.get());
        }
        return  ResponseEntity.notFound().build();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public  Cliente adicionar(@RequestBody Cliente cliente){
        return clienteRepository.save(cliente);
    }
    @PutMapping("/{clientId}")
    public  ResponseEntity<Cliente> atualizar(@PathVariable Long clienteId,
                                              @RequestBody Cliente cliente){
        if (!clienteRepository.existsById(clienteId)){
            return  ResponseEntity.notFound().build();
        }
        cliente.setId(clienteId);
        cliente= clienteRepository.save(cliente);
        return  ResponseEntity.ok(cliente);
    }


}

