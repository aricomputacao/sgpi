package br.com.sgpi.logistica.infra.config;

import br.com.sgpi.logistica.dominio.model.mapper.EntregadorMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public EntregadorMapper entregadorMapper() {
        return Mappers.getMapper(EntregadorMapper.class);
    }


}