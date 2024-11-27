package br.com.sgpi.logistica.dominio.util.schedulers;

import br.com.sgpi.logistica.apllication.http.ClienteClient;
import br.com.sgpi.logistica.dominio.enumeration.StatusPedido;
import br.com.sgpi.logistica.dominio.model.entity.Pedido;
import br.com.sgpi.logistica.dominio.repository.PedidoRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@AllArgsConstructor
@Slf4j
public class TarefaAgendada {

    private final PedidoRepository pedidoRepository;
    private final ClienteClient clienteClient;

    // Executa a cada 30 segundos
    @Scheduled(fixedRate = 30000)
    public void executarTarefaComFrequenciaFixa() {

        List<Pedido> lista = pedidoRepository.findAllByStatusIn(Arrays
                .asList(StatusPedido.ALOCADO_SEM_COMUNICACAO, StatusPedido.ENTREGUE_SEM_COMUNICACAO));

        lista.forEach(pedido -> {
            try {
                log.info("Comunicando pedido: {} com Status: {}", pedido.getId(), pedido.getStatus());
                switch (pedido.getStatus()) {
                    case ALOCADO_SEM_COMUNICACAO:
                        clienteClient.comunicarSaida(pedido.getCpfCliente());
                        pedido.setStatus(StatusPedido.SAIU_PARA_ENTREGA);
                        break;
                    case ENTREGUE_SEM_COMUNICACAO:
                        clienteClient.comunicarEntrega(pedido.getCpfCliente());
                        pedido.setStatus(StatusPedido.ENTREGUE);
                        break;
                    default:
                        break;
                }
                pedidoRepository.save(pedido);
            } catch (Exception e) {
                 log.error(e.getMessage(), e);
            }
        });
    }

}
