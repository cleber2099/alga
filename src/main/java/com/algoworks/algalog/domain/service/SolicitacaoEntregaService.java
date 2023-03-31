package com.algoworks.algalog.domain.service;

import com.algoworks.algalog.domain.model.Cliente;
import com.algoworks.algalog.domain.model.Entrega;
import com.algoworks.algalog.domain.model.StatusEntrega;
import com.algoworks.algalog.domain.repository.EntregaRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@AllArgsConstructor
@Service
public class SolicitacaoEntregaService {

    private CatalogoClienteService catalogoClienteService;
    private EntregaRepository entregaRepository;

    @Transactional
    public Entrega solicitar(Entrega entrega){
        Cliente cliente = catalogoClienteService.buscar(entrega.getCliente().getId());
        entrega.setCliente(cliente);
        entrega.setStatus(StatusEntrega.PENDENTE);
        entrega.setDataPedido(OffsetDateTime.now());
        return  entregaRepository.save(entrega);
    }

}
