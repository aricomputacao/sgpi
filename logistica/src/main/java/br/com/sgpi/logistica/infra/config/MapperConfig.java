package br.com.sgpi.logistica.infra.config;

import br.com.sgpi.logistica.dominio.model.mapper.EntregadorMapper;
import br.com.sgpi.logistica.dominio.model.mapper.ItemPedidoMapper;
import br.com.sgpi.logistica.dominio.model.mapper.PedidoMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public EntregadorMapper entregadorMapper() {
        return Mappers.getMapper(EntregadorMapper.class);
    }

    @Bean
    public PedidoMapper pedidoMapper() {
        return Mappers.getMapper(PedidoMapper.class);
    }

    @Bean
    public ItemPedidoMapper itemPedidoMapper() {
        return Mappers.getMapper(ItemPedidoMapper.class);
    }


}