# SGPI - Sistema de Gestão de Processos Integrados

## Introdução

O **SGPI** é uma 🌀 aplicação modular para gestão integrada de processos, abrangendo múltiplos domínios como clientes, logística, pedidos e produtos. A arquitetura é baseada em microserviços, com módulos independentes para cada funcionalidade, permitindo escalabilidade e manutenção simplificada.

## Tabela de Conteúdos

- [Introdução](#introdução)
- [Tabela de Conteúdos](#tabela-de-conteúdos)
- [Instalação](#instalação)
- [Uso](#uso)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Funcionalidades](#funcionalidades)
- [Dependências](#dependências)
- [Configuração](#configuração)
- [Testes](#testes)
- [Contribuidores](#contribuidores)
- [Licença](#licença)

## Instalação

1. Certifique-se de ter o **Java 17** ou superior instalado.
2. Instale o **Maven** 🛠️ para gerenciar as dependências.
3. Clone este repositório:
   ```bash
   git clone https://github.com/aricomputacao/sgpi.git
   ```
4. Navegue até o diretório raiz do projeto:
   ```bash
   cd sgpi-main
   ```
5. Compile o projeto:
   ```bash
   mvn clean install
   ```

## Uso

1. Inicie cada módulo individualmente executando o comando:
   ```bash
   mvn spring-boot:run
   ```
   **Exemplo para o módulo `cliente`:**
   ```bash
   cd cliente
   mvn spring-boot:run
   ```

2. O módulo `gateway` atua como ponto de entrada para a comunicação entre os módulos.

3. Acesse a documentação Swagger para cada módulo em:
   - **Cliente**: `http://localhost:<PORTA_CLIENTE>/swagger-ui.html`
   - **Logística**: `http://localhost:<PORTA_LOGISTICA>/swagger-ui.html`
   - **Pedidos**: `http://localhost:<PORTA_PEDIDOS>/swagger-ui.html`
   - **Produtos**: `http://localhost:<PORTA_PRODUTOS>/swagger-ui.html`

## Estrutura do Projeto

- **cliente/**: 👤 Gerenciamento de clientes e seus pedidos.
- **gateway/**: 🚪 Gateway API para comunicação entre módulos.
- **logistica/**: 🚚 Gerenciamento de entregadores e logística de pedidos.
- **pedido/**: 📦 Controle de pedidos e itens.
- **produto/**: 🛒 Gerenciamento de produtos e catálogos.
- **server/**: 🌐 Configuração e gerenciamento do servidor central.

Cada módulo segue a convenção padrão de projetos Java:

- `src/main/java`: Código-fonte principal.
- `src/main/resources`: Arquivos de configuração e recursos.
- `src/test/java`: Testes unitários e de integração.

## Funcionalidades

- **Cliente**:
  - 📇 Cadastro e gestão de clientes.
  - 🕒 Histórico de pedidos por cliente.
- **Logística**:
  - 👷 Atribuição de entregadores.
  - 🔍 Rastreamento de entregas.
- **Pedidos**:
  - 📝 Criação, atualização e rastreamento de pedidos.
- **Produtos**:
  - 🧾 Gerenciamento de catálogo de produtos.
  - 📦 Integração com estoque.

## Dependências

As principais dependências do projeto incluem:

- **Spring Boot**: 🚀 Framework para desenvolvimento Java.
- **Hibernate**: ⚙️ Mapeamento Objeto-Relacional (ORM).
- **Spring Data JPA**: 📊 Abstração para acesso a dados.
- **Lombok**: ✂️ Redução de boilerplate em Java.
- **Swagger/OpenAPI**: 📜 Documentação automática da API.
- **RabbitMQ**: 📡 Mensageria para comunicação entre microserviços.

## Configuração

1. Configure os arquivos `application.properties` para cada módulo com as credenciais do banco de dados e demais configurações:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/sgpi
   spring.datasource.username=usuario
   spring.datasource.password=senha
   ```

2. Configure o RabbitMQ no arquivo de propriedades:
   ```properties
   spring.rabbitmq.host=localhost
   spring.rabbitmq.port=5672
   spring.rabbitmq.username=guest
   spring.rabbitmq.password=guest
   ```

3. Execute o script `schema.sql` disponível em cada módulo para criar as tabelas no banco de dados.

## Testes

- 🧪 Testes unitários e de integração estão localizados em `src/test/java` para cada módulo.
- Para executar os testes:
  ```bash
  mvn test
  ```

## Contribuidores

<table>
  <tr>
   <td align="center"><a href="https://github.com/aricomputacao" target="blank"><img src="https://avatars.githubusercontent.com/aricomputacao" alt="aricomputacao" width="50" /></a><br>@aricomputacao</td>
   <td align="center"><a href="https://github.com/edipojoseoliveira" target="blank"><img src="https://avatars.githubusercontent.com/edipojoseoliveira" alt="edipojoseoliveira" width="50" /></a><br>@edipojoseoliveira</td>
   <td align="center"><a href="https://github.com/Gabrielzc88" target="blank"><img src="https://avatars.githubusercontent.com/Gabrielzc88" alt="Gabrielzc88" width="50" /></a><br>@Gabrielzc88</td>
   <td align="center"><a href="https://github.com/nicolasrds" target="blank"><img src="https://avatars.githubusercontent.com/nicolasrds" alt="nicolasrds" width="50" /></a><br>@nicolasrds</td>
   <td align="center"><a href="https://github.com/yurialves23" target="blank"><img src="https://avatars.githubusercontent.com/yurialves23" alt="yurialves23" width="50" /></a><br>@yurialves23</td>
  </tr>
</table>

## Licença

Este projeto está licenciado sob a [Licença MIT](LICENSE).
