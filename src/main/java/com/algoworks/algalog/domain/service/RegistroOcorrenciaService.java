package com.algoworks.algalog.domain.service;

import com.algoworks.algalog.domain.exception.NegocioException;
import com.algoworks.algalog.domain.model.Entrega;
import com.algoworks.algalog.domain.model.Ocorrencia;
import com.algoworks.algalog.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class RegistroOcorrenciaService {
    private EntregaRepository entregaRepository;

    @Transactional
    public Ocorrencia registrar(Long entregaId, String descricao){
        Entrega entrega = entregaRepository.findById(entregaId)
                .orElseThrow(() -> new NegocioException("Entrega não encontrada"));
        return  entrega.adicionarOcorrencia(descricao);
    }
}
