package br.com.sgpi.logistica.util;

import br.com.sgpi.logistica.dominio.enumeration.StatusEntregador;
import br.com.sgpi.logistica.dominio.enumeration.StatusPedido;
import br.com.sgpi.logistica.dominio.enumeration.Veiculo;
import br.com.sgpi.logistica.dominio.model.dto.EntregadorDto;
import br.com.sgpi.logistica.dominio.model.dto.ItemDto;
import br.com.sgpi.logistica.dominio.model.dto.PedidoDto;
import br.com.sgpi.logistica.dominio.model.entity.Entregador;
import br.com.sgpi.logistica.dominio.model.entity.Item;
import br.com.sgpi.logistica.dominio.model.entity.Pedido;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class Util {

    public static Entregador gerarEntregador() {
        return Entregador.builder()
                .nome("Carlos")
                .statusEntregador(StatusEntregador.DISPONIVEL)
                .veiculo(Veiculo.CARRO)
                .latitude(BigDecimal.ZERO)
                .longitude(BigDecimal.ZERO).build();
    }

    public static EntregadorDto gerarEntregadorDto() {
        return EntregadorDto.builder()
                .nome("Carlos")
                .statusEntregador(StatusEntregador.DISPONIVEL)
                .veiculo(Veiculo.CARRO)
                .latitude(BigDecimal.ZERO)
                .longitude(BigDecimal.ZERO).build();
    }
    public static EntregadorDto gerarEntregadorDtoInvalido() {
        return EntregadorDto.builder()
                .nome(null)
                .statusEntregador(StatusEntregador.DISPONIVEL)
                .veiculo(Veiculo.CARRO)
                .latitude(BigDecimal.ZERO)
                .longitude(BigDecimal.ZERO).build();
    }

    public static Pedido gerarPedido() {
        Item itemPedido1 = Item.builder()
                .descricao("Produto a")
                .quantidade(5)
                .build();
        Item itemPedido2 = Item.builder()
                .descricao("Produto b")
                .quantidade(5)
                .build();
        List<Item> itens = Arrays.asList(itemPedido1, itemPedido2);

        return Pedido.builder()
                .dataEntrada(LocalDateTime.now())
                .status(StatusPedido.PRONTO)
                .itens(itens)
                .enderecoDestino("Rua do destino, Fortaleza-CE")
                .build();
    }

    public static PedidoDto gerarPedidoDto() {
        ItemDto itemPedido1 = ItemDto.builder()
                .descricao("Produto a")
                .quantidade(5)
                .build();
        ItemDto itemPedido2 = ItemDto.builder()
                .descricao("Produto b")
                .quantidade(5)
                .build();
        List<ItemDto> itens = Arrays.asList(itemPedido1, itemPedido2);

        return PedidoDto.builder()
                .dataEntrada(LocalDateTime.now())
                .itens(itens)
                .enderecoDestino("Rua do destino, Fortaleza-CE")
                .build();
    }

    public static Pedido gerarPedidoComDataInvalida() {
        Item itemPedido1 = Item.builder()
                .descricao("Produto a")
                .quantidade(5)
                .build();
        Item itemPedido2 = Item.builder()
                .descricao("Produto b")
                .quantidade(5)
                .build();
        List<Item> itens = Arrays.asList(itemPedido1, itemPedido2);

        return Pedido.builder()
                .dataEntrada(LocalDateTime.now().minusMinutes(6))
                .status(StatusPedido.PRONTO)
                .itens(itens)
                .enderecoDestino("Rua do destino, Fortaleza-CE")
                .build();
    }
}
