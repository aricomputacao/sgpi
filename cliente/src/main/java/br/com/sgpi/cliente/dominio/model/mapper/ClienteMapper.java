package br.com.sgpi.cliente.dominio.model.mapper;

import br.com.sgpi.cliente.dominio.model.dto.ClienteDto;
import br.com.sgpi.cliente.dominio.model.entity.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper
public interface ClienteMapper {
    Cliente dtoToEntity(ClienteDto dto);

    ClienteDto entityToDto(Cliente entity);

    List<ClienteDto> toDtoList(List<Cliente> mesas);

    void updateEntityFromDto(ClienteDto dto, @MappingTarget Cliente entity);
}
