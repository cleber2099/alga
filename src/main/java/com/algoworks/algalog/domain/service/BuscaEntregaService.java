package com.algoworks.algalog.domain.service;

import com.algoworks.algalog.domain.exception.NegocioException;
import com.algoworks.algalog.domain.model.Entrega;
import com.algoworks.algalog.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BuscaEntregaService {
    private EntregaRepository entregaRepository;
        public Entrega buscar(Long entregaId){
            return entregaRepository.findById(entregaId)
                    .orElseThrow(() -> new NegocioException("Entrega não encontrada"));
        }
}
