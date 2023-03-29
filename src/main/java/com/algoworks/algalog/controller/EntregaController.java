package com.algoworks.algalog.controller;

import com.algoworks.algalog.model.Entrega;
import com.algoworks.algalog.repository.EntregaRepository;
import com.algoworks.algalog.service.SolicitacaoEntregaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
public class EntregaController {

    private EntregaRepository entregaRepository;
    private SolicitacaoEntregaService solicitacaoEntregaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Entrega solicitar(@Valid  @RequestBody Entrega entrega){
        return solicitacaoEntregaService.solicitar(entrega);
    }
    @GetMapping
    public List<Entrega> listar(){
    return   entregaRepository.findAll();
    }
    @GetMapping("/{entregaId}")
    public ResponseEntity<Entrega> buscar(@PathVariable Long entregaId){
        Optional<Entrega> entrega = entregaRepository.findById(entregaId);
        if (entrega.isPresent()){
            return ResponseEntity.ok(entrega.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    }
