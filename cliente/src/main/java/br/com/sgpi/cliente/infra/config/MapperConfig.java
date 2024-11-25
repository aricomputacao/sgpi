package br.com.sgpi.cliente.infra.config;

import br.com.sgpi.cliente.dominio.model.mapper.ClienteMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public ClienteMapper clienteMapper() {
        return Mappers.getMapper(ClienteMapper.class);
    }

}