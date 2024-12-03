# SGPI - Sistema de Gestão de Processos Integrados

## Introdução

O **SGPI** é uma aplicação modular para gestão integrada de processos, abrangendo múltiplos domínios como clientes, logística, pedidos e produtos. A arquitetura é baseada em microserviços, com módulos independentes para cada funcionalidade, permitindo escalabilidade e manutenção simplificada.

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

1. Certifique-se de ter o **Java 11** ou superior instalado.
2. Instale o **Maven** para gerenciar as dependências.
3. Clone este repositório:
   ```bash
   git clone <URL_DO_REPOSITORIO>
4. Navegue até o diretório raiz do projeto:
	```bash
	cd sgpi-main
5. Compile o projeto:
	```bash
    mvn clean install

## Uso

    Inicie cada módulo individualmente executando o comando:

mvn spring-boot:run

Exemplo para o módulo cliente:

    cd cliente
    mvn spring-boot:run

    O módulo gateway atua como ponto de entrada para a comunicação entre os módulos.

    Acesse a documentação Swagger para cada módulo em:
        Cliente: http://localhost:<PORTA_CLIENTE>/swagger-ui.html
        Logística: http://localhost:<PORTA_LOGISTICA>/swagger-ui.html
        Pedidos: http://localhost:<PORTA_PEDIDOS>/swagger-ui.html
        Produtos: http://localhost:<PORTA_PRODUTOS>/swagger-ui.html

## Estrutura do Projeto

    cliente/: Gerenciamento de clientes e seus pedidos.
    gateway/: Gateway API para comunicação entre módulos.
    logistica/: Gerenciamento de entregadores e logística de pedidos.
    pedido/: Controle de pedidos e itens.
    produto/: Gerenciamento de produtos e catálogos.
    server/: Configuração e gerenciamento do servidor central.

Cada módulo segue a convenção padrão de projetos Java:

    src/main/java: Código-fonte principal.
    src/main/resources: Arquivos de configuração e recursos.
    src/test/java: Testes unitários e de integração.

## Funcionalidades

    Cliente:
        Cadastro e gestão de clientes.
        Histórico de pedidos por cliente.
    Logística:
        Atribuição de entregadores.
        Rastreamento de entregas.
    Pedidos:
        Criação, atualização e rastreamento de pedidos.
    Produtos:
        Gerenciamento de catálogo de produtos.
        Integração com estoque.

## Dependências

As principais dependências do projeto incluem:

    Spring Boot: Framework para desenvolvimento Java.
    Hibernate: Mapeamento Objeto-Relacional (ORM).
    Spring Data JPA: Abstração para acesso a dados.
    Lombok: Redução de boilerplate em Java.
    Swagger/OpenAPI: Documentação automática da API.
    RabbitMQ: Mensageria para comunicação entre microserviços.

## Configuração

    Configure os arquivos application.properties para cada módulo com as credenciais do banco de dados e demais configurações:

spring.datasource.url=jdbc:mysql://localhost:3306/sgpi
spring.datasource.username=usuario
spring.datasource.password=senha

Configure o RabbitMQ no arquivo de propriedades:

    spring.rabbitmq.host=localhost
    spring.rabbitmq.port=5672
    spring.rabbitmq.username=guest
    spring.rabbitmq.password=guest

    Execute o script schema.sql disponível em cada módulo para criar as tabelas no banco de dados.

## Testes

    Testes unitários e de integração estão localizados em src/test/java para cada módulo.
    Para executar os testes:

    mvn test

## Contribuidores

    Seu Nome Aqui
    Contribua enviando pull requests ou reportando problemas.

## Licença

Este projeto está licenciado sob a Licença MIT.