package br.com.sgpi.pedido.dominio.model.mapper;


import br.com.sgpi.pedido.dominio.model.dto.PedidoRequestDto;
import br.com.sgpi.pedido.dominio.model.dto.PedidoResponseDto;
import br.com.sgpi.pedido.dominio.model.entity.Pedido;
import org.mapstruct.Mapper;

@Mapper
public interface PedidoMapper {

    Pedido dtoToEntity(PedidoRequestDto dto);

    PedidoRequestDto entityToDto(Pedido entity);

    PedidoResponseDto entityToDtoResponse(Pedido entity);

}
