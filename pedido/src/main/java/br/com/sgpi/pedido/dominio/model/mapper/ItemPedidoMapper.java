package br.com.sgpi.pedido.dominio.model.mapper;

import br.com.sgpi.pedido.dominio.model.dto.ItemDto;
import br.com.sgpi.pedido.dominio.model.entity.Item;
import org.mapstruct.Mapper;

@Mapper
public interface ItemPedidoMapper {
    Item dtoToEntity(ItemDto dto);

    ItemDto entityToDto(Item entity);

}
