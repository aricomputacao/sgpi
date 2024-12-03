package br.com.sgpi.cliente.infra.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmqpConfiguration {
    public static final String PEDIDO_EXCHANGE = "pedido.ex";
    public static final String PEDIDO_QUEUE = "pedido";
    public static final String CLIENTE_QUEUE = "cliente";
    public static final String ALOCAR_QUEUE = "alocar";
    public static final String ENTREGA_QUEUE = "entrega";

    // Configura um conversor de mensagens que utiliza JSON para serializar/deserializar objetos.
    @Bean
    public Jackson2JsonMessageConverter messageConverter(){
        return  new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory, Jackson2JsonMessageConverter messageConverter){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter);
        return  rabbitTemplate;
    }

    @Bean
    public Queue filaPedido() {
        return QueueBuilder
                .nonDurable(PEDIDO_QUEUE)
                .build();
    }

    @Bean
    public Queue filaCliente() {
        return QueueBuilder
                .nonDurable(CLIENTE_QUEUE)
                .build();
    }

    @Bean
    public FanoutExchange pedidoFanoutExchange() {
        return ExchangeBuilder
                .fanoutExchange(PEDIDO_EXCHANGE)
                .build();
    }

    @Bean
    public Binding bindPedido() {
        return BindingBuilder
                .bind(filaPedido())
                .to(pedidoFanoutExchange());
    }

    @Bean
    public Binding bindCliente() {
        return BindingBuilder
                .bind(filaCliente())
                .to(pedidoFanoutExchange());
    }

    @Bean
    public RabbitAdmin criaRabbitAdmin(ConnectionFactory conexao) {
        return new RabbitAdmin(conexao);
    }

    @Bean
    public ApplicationListener<ApplicationReadyEvent> inicializaAdmin(RabbitAdmin rabbitAdmin){
        return event -> rabbitAdmin.initialize();
    }
}
