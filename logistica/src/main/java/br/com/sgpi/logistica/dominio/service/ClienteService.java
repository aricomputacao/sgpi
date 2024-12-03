package br.com.sgpi.logistica.dominio.service;

import br.com.sgpi.logistica.dominio.enumeration.StatusPedido;
import br.com.sgpi.logistica.dominio.model.dto.PedidoDto;
import br.com.sgpi.logistica.infra.config.AmqpConfiguration;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@AllArgsConstructor
@Slf4j
public class ClienteService {

    private final PedidoService service;
    private final RabbitTemplate rabbitTemplate;

    public void alocarPedido(@PathVariable Long idPedido, @PathVariable Long idEntregador) {
        PedidoDto pedidoDto = service.alocarPedido(idPedido, idEntregador);
        if (StatusPedido.SAIU_PARA_ENTREGA.equals(pedidoDto.getStatus())) {
            rabbitTemplate.convertAndSend(AmqpConfiguration.ALOCAR_EXCHANGE, "", pedidoDto);
        }
    }

    public void entregarPedido(@PathVariable @NotNull Long id) {
        PedidoDto pedidoDto = service.entregarPedido(id);
        if (StatusPedido.ENTREGUE.equals(pedidoDto.getStatus())) {
            rabbitTemplate.convertAndSend(AmqpConfiguration.ENTREGA_EXCHANGE, "", pedidoDto);
        }
    }

}
