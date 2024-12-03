package br.com.sgpi.cliente.apllication.amqp;

import br.com.sgpi.cliente.dominio.model.dto.PedidoDto;
import br.com.sgpi.cliente.infra.config.AmqpConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ClienteListener {

    @RabbitListener(queues = {AmqpConfiguration.CLIENTE_QUEUE, AmqpConfiguration.ALOCAR_QUEUE, AmqpConfiguration.ENTREGA_QUEUE})
    public void recebeMensagemPedido(@Payload PedidoDto pedidoDto) {
      log.info("================= Recebendo pedido: {}", pedidoDto.toString());
      log.info("================= Enviar email para: {}", pedidoDto.getEmailCliente());
    }

}
