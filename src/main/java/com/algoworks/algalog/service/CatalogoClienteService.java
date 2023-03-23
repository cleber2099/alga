package com.algoworks.algalog.service;

import com.algoworks.algalog.exception.NegocioException;
import com.algoworks.algalog.model.Cliente;
import com.algoworks.algalog.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class CatalogoClienteService {
    private ClienteRepository clienteRepository;

    @Transactional
    public Cliente salvar(Cliente cliente) {
        boolean emailEmUso =clienteRepository.findByEmail(cliente.getEmail())
                .stream()
                .anyMatch(clienteExistente -> !clienteExistente.equals(cliente));
        if(emailEmUso){
            throw  new NegocioException("já existe um cliente cadastrado com este e-mail");
        }
        return clienteRepository.save(cliente);

    }
    @Transactional
    public void excluir(Long clientId){
        clienteRepository.deleteById(clientId);
    }

}
