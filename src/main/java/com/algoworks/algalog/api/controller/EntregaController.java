package com.algoworks.algalog.api.controller;

import com.algoworks.algalog.api.assembler.EntregaAssembler;
import com.algoworks.algalog.api.model.DestinatarioModel;
import com.algoworks.algalog.api.model.EntregaModel;
import com.algoworks.algalog.api.model.input.EntregaInput;
import com.algoworks.algalog.domain.model.Entrega;
import com.algoworks.algalog.domain.repository.EntregaRepository;
import com.algoworks.algalog.domain.service.FinalizacaoEntregaService;
import com.algoworks.algalog.domain.service.SolicitacaoEntregaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
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
    private EntregaAssembler entregaAssembler;
    private FinalizacaoEntregaService finalizacaoEntregaService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EntregaModel solicitar(@Valid  @RequestBody EntregaInput entregaInput){
            Entrega novaEntrega = entregaAssembler.toEntity(entregaInput);
            Entrega entregaSolicitada = solicitacaoEntregaService.solicitar(novaEntrega);
            return  entregaAssembler.toModel(entregaSolicitada);
    }
    @PutMapping("/{entregaId}/finalizacao")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void finalizar(@PathVariable Long entregaId){
         finalizacaoEntregaService.finalizar((entregaId));
    }

    @GetMapping
    public List<EntregaModel> listar(){
        return   entregaAssembler.toCollectionModel(entregaRepository.findAll());
    }
    @GetMapping("/{entregaId}")
    public ResponseEntity<EntregaModel> buscar(@PathVariable Long entregaId) {
        return entregaRepository.findById(entregaId).map(entrega -> ResponseEntity.ok(entregaAssembler.toModel(entrega)))
                .orElse(ResponseEntity.notFound().build());
    }
    }
