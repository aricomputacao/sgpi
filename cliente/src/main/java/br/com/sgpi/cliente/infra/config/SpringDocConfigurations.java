package br.com.sgpi.cliente.infra.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfigurations {

//    http://localhost:8080/v3/api-docs
//    http://localhost:8080/swagger-ui/index.html
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()

                .info(new Info()
                        .title("Clientes API")
                        .description("Plataforma Eletrônica de Registro de Clientes")
                        .contact(new Contact()
                                .name("Time Backend")
                                .email("backend@petlife.med"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://petlife/api/licenca")))

                ;
    }
}
