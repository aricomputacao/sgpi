package br.com.sgpi.logistica.dominio.service;

import br.com.sgpi.logistica.dominio.model.dto.EntregadorDto;
import br.com.sgpi.logistica.dominio.model.entity.Entregador;
import br.com.sgpi.logistica.dominio.model.mapper.EntregadorMapper;
import br.com.sgpi.logistica.dominio.repository.EntregadorRepository;
import br.com.sgpi.logistica.infra.exception.RegraDeNegocioException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class EntregadorService {

    private final EntregadorRepository entregadorRepository;
    private final EntregadorMapper entregadorMapper;

    public EntregadorDto salvar(EntregadorDto entregadorDto) {
        Entregador entregador = entregadorMapper.dtoToEntity(entregadorDto);
        entregador = entregadorRepository.save(entregador);
        log.info("Salvando entregador: {}", entregador);
        return entregadorMapper.entityToDto(entregador);
    }

    public Page<EntregadorDto> consultarTodos(Pageable pageable) {
        return entregadorRepository
                .findAll(pageable)
                .map(entregadorMapper::entityToDto);
    }

    public void desativar(@NotNull Long id) {
        Optional<Entregador> entregador = entregadorRepository.findById(id);
        if (!entregador.isPresent()) {
            throw new RegraDeNegocioException("Entregador com id "+id+" não encontrado" );
        }
        entregador.get().desativar();
        entregadorRepository.save(entregador.get());
    }
}
