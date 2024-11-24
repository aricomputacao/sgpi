package br.com.sgpi.logistica.dominio.model.mapper;


import br.com.sgpi.logistica.dominio.model.dto.PedidoDto;
import br.com.sgpi.logistica.dominio.model.entity.Pedido;
import org.mapstruct.Mapper;

@Mapper
public interface PedidoMapper {

    Pedido dtoToEntity(PedidoDto dto);

    PedidoDto entityToDto(Pedido entity);

}
