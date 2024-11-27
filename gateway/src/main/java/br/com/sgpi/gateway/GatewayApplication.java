package br.com.sgpi.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApplication {


    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    // Método que configura o roteamento personalizado para o API Gateway.
    // Ele usa o RouteLocatorBuilder para definir rotas e seus filtros associados.
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                // Define uma rota com o identificador "cliente-ms".
                .route("cliente-ms", r -> r
                        // O padrão de caminho para essa rota é "/api/**".
                        .path("/api/**")
                        // Filtro: Remove o primeiro segmento do caminho na requisição ("/api").
                        .filters(f -> f.stripPrefix(1))
                        // Define o destino da rota usando a URI "lb://CLIENTE-MS".
                        // "lb://" indica que o Spring usará o LoadBalancer (balanceador de carga)
                        // para localizar instâncias do serviço "CLIENTE-MS".
                        .uri("lb://CLIENTE-MS"))

                // Define outra rota com o identificador "logistica-ms".
                .route("logistica-ms", r -> r
                        // O padrão de caminho para essa rota também é "/api/**".
                        .path("/api/**")
                        // Filtro: Remove o primeiro segmento do caminho na requisição ("/api").
                        .filters(f -> f.stripPrefix(1))
                        // Define o destino da rota usando a URI "lb://LOGISTICA-MS".
                        // "LOGISTICA-MS" é o nome do serviço no serviço de descoberta (por exemplo, Eureka).
                        .uri("lb://LOGISTICA-MS"))

                // Constrói e retorna o RouteLocator com as rotas configuradas.
                .build();
    }

}
