package br.com.sgpi.logistica.apllication.amqp;

import br.com.sgpi.logistica.dominio.model.dto.PedidoDto;
import br.com.sgpi.logistica.dominio.service.PedidoService;
import br.com.sgpi.logistica.infra.config.AmqpConfiguration;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class PedidoListener {

    private final PedidoService pedidoService;

    @RabbitListener(queues = AmqpConfiguration.PEDIDO_QUEUE)
    public void recebeMensagemPedido(@Payload PedidoDto pedidoDto) {
        pedidoService.criarPedido(pedidoDto);
    }
}
