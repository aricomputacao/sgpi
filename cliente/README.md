# Cliente - SGPI

## Introdução

O módulo **Cliente** é responsável por gerenciamento de clientes e seus pedidos. Ele faz parte do sistema integrado **SGPI**.

## Instalação

1. Certifique-se de ter o **Java 11** ou superior instalado.
2. Instale o **Maven** para gerenciar as dependências.
3. Navegue até o diretório do módulo `cliente`:
   ```bash
   cd cliente
   ```
4. Compile e inicie o módulo:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

## Documentação da API

A documentação Swagger para este módulo está disponível em:
- **Swagger UI**: `http://localhost:<PORTA_CLIENTE>/swagger-ui.html`

## Estrutura do Projeto

- **src/main/java**: Código-fonte principal.
- **src/main/resources**: Arquivos de configuração e recursos.
- **src/test/java**: Testes unitários e de integração.

## Funcionalidades

- Funcionalidades principais relacionadas a **Cliente**.
- Integração com outros módulos do sistema.

## Configuração

1. Configure o arquivo `application.properties` com as credenciais do banco de dados e outras configurações:
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

## Testes

- Testes unitários e de integração estão localizados em `src/test/java`.
- Para executar os testes:
   ```bash
   mvn test
   ```

## Contribuidores

- [Seu Nome Aqui](mailto:seuemail@exemplo.com)
- Contribua enviando pull requests ou reportando problemas.

## Licença

Este módulo faz parte do projeto SGPI e está licenciado sob a [Licença MIT](../LICENSE).