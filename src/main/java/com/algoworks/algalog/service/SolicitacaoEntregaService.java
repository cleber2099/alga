package com.algoworks.algalog.service;

import com.algoworks.algalog.exception.NegocioException;
import com.algoworks.algalog.model.Cliente;
import com.algoworks.algalog.model.Entrega;
import com.algoworks.algalog.model.StatusEntrega;
import com.algoworks.algalog.repository.ClienteRepository;
import com.algoworks.algalog.repository.EntregaRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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
        entrega.setDataPedido(LocalDateTime.now());
        return  entregaRepository.save(entrega);
    }

}
