package com.algoworks.algalog.domain.service;

import com.algoworks.algalog.domain.exception.NegocioException;
import com.algoworks.algalog.domain.model.Entrega;
import com.algoworks.algalog.domain.model.StatusEntrega;
import com.algoworks.algalog.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class FinalizacaoEntregaService {

    private BuscaEntregaService buscaEntregaService;
    private EntregaRepository entregaRepository;
    @Transactional
    public void finalizar(Long entregaId){
        Entrega entrega = buscaEntregaService.buscar(entregaId);
        entrega.finalizar();

        entregaRepository.save(entrega);
    }
}
