package br.com.sgpi.logistica.dominio.model.mapper;

import br.com.sgpi.logistica.dominio.model.dto.EntregadorDto;
import br.com.sgpi.logistica.dominio.model.entity.Entregador;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface EntregadorMapper {

    Entregador dtoToEntity(EntregadorDto dto);

    EntregadorDto entityToDto(Entregador entity);

    List<EntregadorDto> toDtoList(List<Entregador> mesas);
}
