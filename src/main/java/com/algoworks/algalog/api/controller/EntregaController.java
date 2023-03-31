package com.algoworks.algalog.api.controller;

import com.algoworks.algalog.api.model.DestinatarioModel;
import com.algoworks.algalog.api.model.EntregaModel;
import com.algoworks.algalog.domain.model.Entrega;
import com.algoworks.algalog.domain.repository.EntregaRepository;
import com.algoworks.algalog.domain.service.SolicitacaoEntregaService;
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
    public ResponseEntity<EntregaModel> buscar(@PathVariable Long entregaId) {
        return entregaRepository.findById(entregaId)
                .map(entrega -> {
                    EntregaModel entregaModel = new EntregaModel();
                    entregaModel.setId(entrega.getId());
                    entregaModel.setNomeCliente(entrega.getCliente().getNome());
                    entregaModel.setDestinatario(new DestinatarioModel());
                    entregaModel.getDestinatario().setNome(entrega.getDestinatario().getNome());
                    entregaModel.getDestinatario().setLogradouro(entrega.getDestinatario().getLogradouro());
                    entregaModel.getDestinatario().setNumero(entrega.getDestinatario().getComplemento());
                    entregaModel.getDestinatario().setBairro(entrega.getDestinatario().getBairro());
                    entregaModel.setTaxa(entrega.getTaxa());
                    entregaModel.setStatus(entrega.getStatus());
                    entregaModel.setDataPedido(entrega.getDataPedido());
                    entregaModel.setDataFinalizacao(entrega.getDataFinalizacao());

                    return ResponseEntity.ok(entregaModel);

                }).orElse(ResponseEntity.notFound().build());

    }
    }
