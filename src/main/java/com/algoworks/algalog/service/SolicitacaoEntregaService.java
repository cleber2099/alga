package com.algoworks.algalog.service;

import com.algoworks.algalog.model.Entrega;
import com.algoworks.algalog.model.StatusEntrega;
import com.algoworks.algalog.repository.EntregaRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class SolicitacaoEntregaService {
    private EntregaRepository entregaRepository;

    @Transactional
    public Entrega solicitar(Entrega entrega){
        entrega.setStatus(StatusEntrega.PENDENTE);
        entrega.setDataPedido(LocalDateTime.now());
        return  entregaRepository.save(entrega);
    }

}
