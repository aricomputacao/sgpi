package br.com.sgpi.logistica.dominio.service;

import br.com.sgpi.logistica.dominio.enumeration.StatusEntregador;
import br.com.sgpi.logistica.dominio.enumeration.StatusPedido;
import br.com.sgpi.logistica.dominio.model.dto.PedidoDto;
import br.com.sgpi.logistica.dominio.model.entity.Entregador;
import br.com.sgpi.logistica.dominio.model.entity.Item;
import br.com.sgpi.logistica.dominio.model.entity.Pedido;
import br.com.sgpi.logistica.dominio.model.mapper.PedidoMapper;
import br.com.sgpi.logistica.dominio.repository.EntregadorRepository;
import br.com.sgpi.logistica.dominio.repository.ItemPedidoRepository;
import br.com.sgpi.logistica.dominio.repository.PedidoRepository;
import br.com.sgpi.logistica.dominio.util.validators.Criacao;
import br.com.sgpi.logistica.infra.exception.RegraDeNegocioException;
import br.com.sgpi.logistica.util.Util;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static jakarta.validation.Validation.buildDefaultValidatorFactory;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@Log4j2
class PedidoServiceTest {

    @InjectMocks
    private PedidoService pedidoService;

    @Mock
    private PedidoRepository pedidoRepository;

    @Mock
    private ItemPedidoRepository itemPedidoRepository;

    @Mock
    private EntregadorRepository entregadorRepository;

    @Mock
    private PedidoMapper pedidoMapper;

    @Mock
    private Pedido pedido;

    @Mock
    private PedidoDto pedidoDto;

    @Mock
    private Validator validator;

    @BeforeEach
    void setUp() {
        // Inicializa um Validator real, baseado na implementação padrão
        ValidatorFactory factory = buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Nested
    class ManterPedido {

        @Test
        void naoDeveCadastrarUmPedidoComEntradaNoPassado() throws Exception {
            //arrange
            Pedido pedido = Util.gerarPedidoComDataInvalida();
            // Act
            Set<ConstraintViolation<Pedido>> violacoes = validator.validate(pedido, Criacao.class);

            // Assert
            Assertions.assertFalse(violacoes.isEmpty(), "A validação deveria falhar para dataEntrada no passado");
            Assertions.assertTrue(
                    violacoes.stream().anyMatch(v -> "dataEntrada".equals(v.getPropertyPath().toString())),
                    "A violação esperada deveria ser no campo 'dataEntrada'"
            );
        }

        @Test
        void deveCriarPedido() {
            // Arrange
            PedidoDto pedidoDto = new PedidoDto();
            Pedido pedido = new Pedido();
            pedido.setItens(List.of(Item.builder().build()));
            pedido.setEntregador(new Entregador());

            when(pedidoMapper.dtoToEntity(pedidoDto)).thenReturn(pedido);
            when(pedidoMapper.entityToDto(any(Pedido.class))).thenReturn(pedidoDto);

            // Act
            PedidoDto resultado = pedidoService.criarPedido(pedidoDto);

            // Assert
            assertEquals(pedidoDto, resultado);
            verify(itemPedidoRepository).saveAll(pedido.getItens());
            verify(pedidoRepository).save(pedido);
            verify(pedidoMapper).entityToDto(pedido);
        }

        @Test
        void deveAtualizarStatusDoPedido() {
            // Arrange
            Long id = 1L;
            Pedido pedido = new Pedido();
            StatusPedido novoStatus = StatusPedido.CANCELADO;
            PedidoDto pedidoDto = new PedidoDto();

            when(pedidoRepository.porIdComItens(id)).thenReturn(pedido);
            when(pedidoMapper.entityToDto(pedido)).thenReturn(pedidoDto);

            // Act
            PedidoDto resultado = pedidoService.atualizaStatus(id, novoStatus);

            // Assert
            assertEquals(pedidoDto, resultado);
            assertEquals(novoStatus, pedido.getStatus());
            verify(pedidoRepository).atualizaStatus(novoStatus, pedido);
        }

        @Test
        void deveLancarExcecaoAoTentarAlocarPedidoComEntregadorInativo() {
            // Arrange
            Long idPedido = 1L;
            Long idEntregador = 2L;
            Pedido pedido = new Pedido();
            Entregador entregador = new Entregador();
            entregador.setStatusEntregador(StatusEntregador.DESATIVADO);

            when(pedidoRepository.findById(idPedido)).thenReturn(Optional.of(pedido));
            when(entregadorRepository.findById(idEntregador)).thenReturn(Optional.of(entregador));

            // Act & Assert
            assertThrows(RegraDeNegocioException.class,
                    () -> pedidoService.alocarPedido(idPedido, idEntregador));
        }


        @Test
        void deveEntregarPedidoComSucesso() {
            // Arrange
            Long id = 1L;
            Pedido pedidoMock = Util.gerarPedidoComEntregador();

            when(pedidoRepository.porIdComItens(id)).thenReturn(pedidoMock);
            when(pedidoMapper.entityToDto(pedidoMock)).thenReturn(new PedidoDto());

            // Act
            PedidoDto resultado = pedidoService.entregarPedido(id);

            // Assert
            assertNotNull(resultado);
            assertEquals(StatusPedido.ENTREGUE, pedidoMock.getStatus());
            assertNotNull(pedidoMock.getDataEntrega());

        }


        @Test
        void deveLancarExcecaoQuandoPedidoNaoExistir() {
            // Arrange
            when(pedidoRepository.porIdComItens(1L)).thenReturn(null);

            // Act & Assert
            RegraDeNegocioException exception = assertThrows(
                    RegraDeNegocioException.class,
                    () -> pedidoService.entregarPedido(1L)
            );

            assertEquals("Pedido com id: 1 não encontrado.", exception.getMessage());
        }

        @Test
        void deveLancarExcecaoQuandoPedidoNaoTiverEntregadorVinculado() {
            // Arrange

            pedido.setId(1L);
            pedido.setStatus(StatusPedido.PRONTO);
            when(pedido.isPedidoSemEntregadorVinculado()).thenReturn(true);

            when(pedidoRepository.porIdComItens(1L)).thenReturn(pedido);

            // Act & Assert
            RegraDeNegocioException exception = assertThrows(
                    RegraDeNegocioException.class,
                    () -> pedidoService.entregarPedido(1L)
            );

            assertEquals("Pedido com id: 1 sem entregador vinvulado.", exception.getMessage());
        }

        @Test
        void deveLancarExcecaoQuandoPedidoJaEstiverEntregue() {
            // Arrange
            Pedido pedidoMock = Util.gerarPedidoComEntregador();
            pedidoMock.setStatus(StatusPedido.ENTREGUE);

            when(pedidoRepository.porIdComItens(1L)).thenReturn(pedidoMock);

            // Act & Assert
            RegraDeNegocioException exception = assertThrows(
                    RegraDeNegocioException.class,
                    () -> pedidoService.entregarPedido(1L)
            );

            assertEquals("Pedido com id 1 já consta como entregue.", exception.getMessage());
        }

    }

    @Nested
    class ConsultarPedido {


        @Test
        void deveConsultarTodosOsPedidos() {
            // Arrange
            List<Pedido> pedidos = List.of(new Pedido(), new Pedido());
            List<PedidoDto> pedidosDto = List.of(new PedidoDto(), new PedidoDto());

            when(pedidoRepository.findAll()).thenReturn(pedidos);
            when(pedidoMapper.entityToDto(any(Pedido.class))).thenReturn(new PedidoDto());

            // Act
            List<PedidoDto> resultado = pedidoService.obterTodos();

            // Assert
            assertEquals(pedidosDto.size(), resultado.size());
            verify(pedidoRepository).findAll();
            verify(pedidoMapper, times(pedidos.size())).entityToDto(any(Pedido.class));
        }


        @Test
        void deveRetornarPedidoPorId() {
            // Arrange
            Long id = 1L;
            Pedido pedido = new Pedido();
            PedidoDto pedidoDto = new PedidoDto();

            when(pedidoRepository.findById(id)).thenReturn(Optional.of(pedido));
            when(pedidoMapper.entityToDto(pedido)).thenReturn(pedidoDto);

            // Act
            PedidoDto resultado = pedidoService.obterPorId(id);

            // Assert
            assertEquals(pedidoDto, resultado);
            verify(pedidoRepository).findById(id);
            verify(pedidoMapper).entityToDto(pedido);
        }

    }
    public boolean checarExceptionNomeCampo(String nomeCampo, Pedido pedido) {
        for (ConstraintViolation<Pedido> violation : validator.validate(pedido)) {
            if (violation.getPropertyPath().toString().equals(nomeCampo)) {
                return true;
            }
        }
        return false;
    }
}
