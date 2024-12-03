package br.com.sgpi.cliente.dominio.service;

import br.com.sgpi.cliente.dominio.model.dto.ClienteDto;
import br.com.sgpi.cliente.dominio.model.entity.Cliente;
import br.com.sgpi.cliente.dominio.model.mapper.ClienteMapper;
import br.com.sgpi.cliente.dominio.repository.ClienteRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class ClienteService {

    private ClienteRepository clienteRepository;
    private ClienteMapper clienteMapper;

    public Page<ClienteDto> consultarTodos(Pageable pageable) {
        return clienteRepository
                .findAll(pageable)
                .map(clienteMapper::entityToDto);
    }

    public ClienteDto cadastrarCliente(ClienteDto clienteDto) {
        Cliente cliente = clienteMapper.dtoToEntity(clienteDto);
        cliente = clienteRepository.save(cliente);
        log.info("Salvando cliente: {}", cliente.getId());
        return clienteMapper.entityToDto(cliente);
    }

    public ClienteDto consultarUmCliente(Integer clienteId) {
        Cliente cliente = clienteRepository
                .findById(clienteId)
                .orElseThrow(EntityExistsException::new);
        return clienteMapper.entityToDto(cliente);
    }

    public ClienteDto consultarUmCliente(String cpf) {
        Cliente cliente = (Cliente) clienteRepository
                .findByCpf(cpf)
                .orElseThrow(EntityExistsException::new);
        return clienteMapper.entityToDto(cliente);
    }

    public Cliente atualizarCliente(ClienteDto clienteDto) {
        Cliente clienteExistente = clienteRepository
                .findById(clienteDto.id())
                .orElseThrow(EntityNotFoundException::new);
        clienteMapper.updateEntityFromDto(clienteDto, clienteExistente);
        return clienteRepository.save(clienteExistente);
    }

    public void exluirCliente(Integer clienteId) {
        Cliente clienteExistente = clienteRepository
                .findById(clienteId)
                .orElseThrow(EntityNotFoundException::new);

        clienteRepository.delete(clienteExistente);
    }
}
