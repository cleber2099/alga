package com.algoworks.algalog.service;

import com.algoworks.algalog.model.Entrega;
import com.algoworks.algalog.repository.EntregaRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class SilicitacaoEntregaService {
    private EntregaRepository entregaRepository;

    @Transactional
    public Entrega solicitar(Entrega entrega){}

}
