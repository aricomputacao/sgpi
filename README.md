<p align="center">
    <img src="https://raw.githubusercontent.com/PKief/vscode-material-icon-theme/ec559a9f6bfd399b82bb44393651661b08aaf7ba/icons/folder-markdown-open.svg" align="center" width="30%">
</p>
<p align="center"><h1 align="center">SGPI</h1></p>
<p align="center">
	<em>Empower Your Projects with sgpi: Elevating Security, Reliability, and Efficiency!</em>
</p>
<p align="center">
	<img src="https://img.shields.io/github/license/aricomputacao/sgpi?style=default&logo=opensourceinitiative&logoColor=white&color=0080ff" alt="license">
	<img src="https://img.shields.io/github/last-commit/aricomputacao/sgpi?style=default&logo=git&logoColor=white&color=0080ff" alt="last-commit">
	<img src="https://img.shields.io/github/languages/top/aricomputacao/sgpi?style=default&color=0080ff" alt="repo-top-language">
	<img src="https://img.shields.io/github/languages/count/aricomputacao/sgpi?style=default&color=0080ff" alt="repo-language-count">
</p>
<p align="center"><!-- default option, no dependency badges. -->
</p>
<p align="center">
	<!-- default option, no dependency badges. -->
</p>
<br>

##  Table of Contents

- [ Overview](#-overview)
- [ Features](#-features)
- [ Project Structure](#-project-structure)
  - [ Project Index](#-project-index)
- [ Getting Started](#-getting-started)
  - [ Prerequisites](#-prerequisites)
  - [ Installation](#-installation)
  - [ Usage](#-usage)
  - [ Testing](#-testing)
- [ Project Roadmap](#-project-roadmap)
- [ Contributing](#-contributing)
- [ License](#-license)
- [ Acknowledgments](#-acknowledgments)

---

##  Overview

**SGPI Project Overview:

SGPI (Service Gateway Proxy Infrastructure) streamlines service discovery and coordination in microservices architectures. Key features include Eureka server setup for seamless communication, Apache Maven Wrapper for correct distribution installation, and SHA-256 validation for enhanced security. Ideal for teams managing complex microservices environments seeking reliability and efficiency.

---

##  Features

|      | Feature         | Summary       |
| :--- | :---:           | :---          |
| ⚙️  | **Architecture**  | <ul><li>Enables Eureka server functionality for service discovery and registration within the project architecture.</li><li>Facilitates seamless communication and coordination among microservices by providing a centralized registry for service instances.</li></ul> |
| 🔩 | **Code Quality**  | <ul><li>Consistent use of Apache Maven Wrapper for managing project builds and dependencies.</li><li>Validation of Maven distribution SHA-256 sum for enhanced security and reliability.</li><li>Includes Spring Boot testing for verifying server application functionality.</li></ul> |
| 📄 | **Documentation** | <ul><li>Comprehensive documentation in Java with a focus on server and product modules.</li><li>Details on Maven Wrapper setup, distribution URL determination, and SHA-256 sum validation.</li><li>Database schema definition for the 'produto' module.</li></ul> |
| 🔌 | **Integrations**  | <ul><li>Facilitates Eureka server functionality for service discovery and registration.</li><li>Supports seamless communication and coordination among microservices.</li></ul> |
| 🧩 | **Modularity**    | <ul><li>Organized into server and product modules for clear separation of concerns.</li><li>Utilizes Maven Wrapper for consistent build and dependency management.</li></ul> |
| 🧪 | **Testing**       | <ul><li>Includes Spring Boot testing for verifying server application functionality.</li></ul> |
| ⚡️  | **Performance**   | <ul><li>Optimized performance through efficient service discovery and registration using Eureka server functionality.</li></ul> |
| 🛡️ | **Security**      | <ul><li>Validation of Maven distribution SHA-256 sum for enhanced security and reliability.</li><li>Supports optional SHA-256 validation for downloaded Maven distributions.</li></ul> |
| 📦 | **Dependencies**  | <ul><li>Dependencies include SQL, Java, and Apache Maven.</li></ul> |

---

##  Project Structure

```sh
└── sgpi/
    ├── README.md
    ├── cliente
    │   ├── .gitattributes
    │   ├── .gitignore
    │   ├── .mvn
    │   ├── mvnw
    │   ├── mvnw.cmd
    │   ├── pom.xml
    │   └── src
    ├── gateway
    │   ├── .gitattributes
    │   ├── .gitignore
    │   ├── .mvn
    │   ├── mvnw
    │   ├── mvnw.cmd
    │   ├── pom.xml
    │   └── src
    ├── logistica
    │   ├── .gitattributes
    │   ├── .gitignore
    │   ├── .mvn
    │   ├── mvnw
    │   ├── mvnw.cmd
    │   ├── pom.xml
    │   └── src
    ├── pedido
    │   ├── .gitattributes
    │   ├── .gitignore
    │   ├── .mvn
    │   ├── mvnw
    │   ├── mvnw.cmd
    │   ├── pom.xml
    │   └── src
    ├── pom.xml
    ├── produto
    │   ├── .gitattributes
    │   ├── .gitignore
    │   ├── .mvn
    │   ├── mvnw
    │   ├── mvnw.cmd
    │   ├── pom.xml
    │   └── src
    └── server
        ├── .gitattributes
        ├── .gitignore
        ├── .mvn
        ├── mvnw
        ├── mvnw.cmd
        ├── pom.xml
        └── src
```


###  Project Index
<details open>
	<summary><b><code>SGPI/</code></b></summary>
	<details> <!-- __root__ Submodule -->
		<summary><b>__root__</b></summary>
		<blockquote>
			<table>
			</table>
		</blockquote>
	</details>
	<details> <!-- server Submodule -->
		<summary><b>server</b></summary>
		<blockquote>
			<table>
			<tr>
				<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/server/mvnw.cmd'>mvnw.cmd</a></b></td>
				<td>- Facilitates downloading and installing Apache Maven, ensuring project builds use the correct Maven distribution<br>- Handles setting up the environment variables and configuring the Maven home directory based on the specified distribution URL<br>- Validates the Maven distribution SHA-256 sum if provided, enhancing project security and reliability.</td>
			</tr>
			<tr>
				<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/server/mvnw'>mvnw</a></b></td>
				<td>- Facilitates Apache Maven Wrapper setup by downloading and installing Maven distributions<br>- Determines distribution URL, validates SHA-256 sum, and handles unzipping<br>- Automatically configures MAVEN_HOME based on the downloaded distribution<br>- Executable for managing Maven commands within the project.</td>
			</tr>
			</table>
			<details>
				<summary><b>src</b></summary>
				<blockquote>
					<details>
						<summary><b>main</b></summary>
						<blockquote>
							<details>
								<summary><b>java</b></summary>
								<blockquote>
									<details>
										<summary><b>br</b></summary>
										<blockquote>
											<details>
												<summary><b>com</b></summary>
												<blockquote>
													<details>
														<summary><b>sgpi</b></summary>
														<blockquote>
															<details>
																<summary><b>server</b></summary>
																<blockquote>
																	<table>
																	<tr>
																		<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/server/src/main/java/br/com/sgpi/server/ServerApplication.java'>ServerApplication.java</a></b></td>
																		<td>- Enables Eureka server functionality for service discovery and registration within the project architecture<br>- Facilitates seamless communication and coordination among microservices by providing a centralized registry for service instances.</td>
																	</tr>
																	</table>
																</blockquote>
															</details>
														</blockquote>
													</details>
												</blockquote>
											</details>
										</blockquote>
									</details>
								</blockquote>
							</details>
						</blockquote>
					</details>
					<details>
						<summary><b>test</b></summary>
						<blockquote>
							<details>
								<summary><b>java</b></summary>
								<blockquote>
									<details>
										<summary><b>br</b></summary>
										<blockquote>
											<details>
												<summary><b>com</b></summary>
												<blockquote>
													<details>
														<summary><b>sgpi</b></summary>
														<blockquote>
															<details>
																<summary><b>server</b></summary>
																<blockquote>
																	<table>
																	<tr>
																		<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/server/src/test/java/br/com/sgpi/server/ServerApplicationTests.java'>ServerApplicationTests.java</a></b></td>
																		<td>Verifies server application functionality through Spring Boot testing.</td>
																	</tr>
																	</table>
																</blockquote>
															</details>
														</blockquote>
													</details>
												</blockquote>
											</details>
										</blockquote>
									</details>
								</blockquote>
							</details>
						</blockquote>
					</details>
				</blockquote>
			</details>
		</blockquote>
	</details>
	<details> <!-- produto Submodule -->
		<summary><b>produto</b></summary>
		<blockquote>
			<table>
			<tr>
				<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/produto/mvnw.cmd'>mvnw.cmd</a></b></td>
				<td>- Facilitates downloading and installing Apache Maven, ensuring project builds use the correct Maven distribution<br>- Handles setting up the environment variables and managing the Maven home directory based on the specified distribution URL<br>- Supports optional SHA-256 validation for the downloaded Maven distribution.</td>
			</tr>
			<tr>
				<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/produto/mvnw'>mvnw</a></b></td>
				<td>- The provided code file in `produto/mvnw` serves as a script for managing Apache Maven Wrapper startup<br>- It facilitates the download, installation, and execution of Apache Maven, ensuring the project's build and dependency management processes are streamlined and consistent across environments.</td>
			</tr>
			</table>
			<details>
				<summary><b>src</b></summary>
				<blockquote>
					<details>
						<summary><b>main</b></summary>
						<blockquote>
							<details>
								<summary><b>resources</b></summary>
								<blockquote>
									<table>
									<tr>
										<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/produto/src/main/resources/schema.sql'>schema.sql</a></b></td>
										<td>Defines the database schema for the 'produto' module, ensuring its existence within the project architecture.</td>
									</tr>
									</table>
								</blockquote>
							</details>
							<details>
								<summary><b>java</b></summary>
								<blockquote>
									<details>
										<summary><b>br</b></summary>
										<blockquote>
											<details>
												<summary><b>com</b></summary>
												<blockquote>
													<details>
														<summary><b>sgpi</b></summary>
														<blockquote>
															<details>
																<summary><b>produto</b></summary>
																<blockquote>
																	<table>
																	<tr>
																		<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/produto/src/main/java/br/com/sgpi/produto/ProdutoApplication.java'>ProdutoApplication.java</a></b></td>
																		<td>- Initiates the Produto API, enabling service discovery, Feign clients, and scheduling<br>- Utilizes Spring Boot for application setup and OpenAPI for API documentation<br>- Supports data web serialization and provides a centralized entry point for the product management system.</td>
																	</tr>
																	</table>
																	<details>
																		<summary><b>application</b></summary>
																		<blockquote>
																			<details>
																				<summary><b>util</b></summary>
																				<blockquote>
																					<table>
																					<tr>
																						<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/produto/src/main/java/br/com/sgpi/produto/application/util/Util.java'>Util.java</a></b></td>
																						<td>Facilitates file validation, temporary storage, and batch job execution for product import within the project architecture.</td>
																					</tr>
																					</table>
																				</blockquote>
																			</details>
																			<details>
																				<summary><b>controller</b></summary>
																				<blockquote>
																					<table>
																					<tr>
																						<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/produto/src/main/java/br/com/sgpi/produto/application/controller/ProdutoController.java'>ProdutoController.java</a></b></td>
																						<td>- Handles CRUD operations and file import for products in the API<br>- Retrieves, creates, updates, and deletes products<br>- Allows checking product existence, importing data from files, and adjusting stock levels<br>- Utilizes Spring Batch for file processing and validation<br>- Maintains transactional integrity for data modifications.</td>
																					</tr>
																					</table>
																				</blockquote>
																			</details>
																		</blockquote>
																	</details>
																	<details>
																		<summary><b>infra</b></summary>
																		<blockquote>
																			<details>
																				<summary><b>exception</b></summary>
																				<blockquote>
																					<table>
																					<tr>
																						<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/produto/src/main/java/br/com/sgpi/produto/infra/exception/ProdutoExceptionHandler.java'>ProdutoExceptionHandler.java</a></b></td>
																						<td>- Handles various exceptions in the product infrastructure layer, providing custom error messages based on the type of exception encountered<br>- The `ProdutoExceptionHandler` class centralizes error handling logic for different scenarios, ensuring consistent error responses throughout the application.</td>
																					</tr>
																					<tr>
																						<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/produto/src/main/java/br/com/sgpi/produto/infra/exception/RegraDeNegocioException.java'>RegraDeNegocioException.java</a></b></td>
																						<td>Defines a custom exception class to handle business rule violations within the product infrastructure of the project.</td>
																					</tr>
																					</table>
																				</blockquote>
																			</details>
																			<details>
																				<summary><b>util</b></summary>
																				<blockquote>
																					<table>
																					<tr>
																						<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/produto/src/main/java/br/com/sgpi/produto/infra/util/MessageService.java'>MessageService.java</a></b></td>
																						<td>Enables retrieval of localized messages for the product module using Spring's message source.</td>
																					</tr>
																					</table>
																				</blockquote>
																			</details>
																			<details>
																				<summary><b>config</b></summary>
																				<blockquote>
																					<table>
																					<tr>
																						<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/produto/src/main/java/br/com/sgpi/produto/infra/config/BatchConfiguration.java'>BatchConfiguration.java</a></b></td>
																						<td>- Defines batch processing for importing products from a file<br>- Configures job and step components, reading product data from a CSV file and writing to a database using Spring Batch<br>- The file path is provided as a job parameter for processing.</td>
																					</tr>
																					</table>
																				</blockquote>
																			</details>
																		</blockquote>
																	</details>
																	<details>
																		<summary><b>dominio</b></summary>
																		<blockquote>
																			<details>
																				<summary><b>model</b></summary>
																				<blockquote>
																					<details>
																						<summary><b>entity</b></summary>
																						<blockquote>
																							<table>
																							<tr>
																								<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/produto/src/main/java/br/com/sgpi/produto/dominio/model/entity/Produto.java'>Produto.java</a></b></td>
																								<td>- Defines a data model for products with attributes like name, description, price, and stock quantity<br>- Includes a method to decrease stock based on a specified quantity<br>- The entity is mapped to a database table for persistence.</td>
																							</tr>
																							</table>
																						</blockquote>
																					</details>
																					<details>
																						<summary><b>dto</b></summary>
																						<blockquote>
																							<table>
																							<tr>
																								<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/produto/src/main/java/br/com/sgpi/produto/dominio/model/dto/ProdutoResponseDTO.java'>ProdutoResponseDTO.java</a></b></td>
																								<td>Converts product entity data into a response DTO for the project's domain model.</td>
																							</tr>
																							<tr>
																								<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/produto/src/main/java/br/com/sgpi/produto/dominio/model/dto/ProdutoRequestDTO.java'>ProdutoRequestDTO.java</a></b></td>
																								<td>- Defines a data transfer object for creating a new product, ensuring required fields are present and valid<br>- Converts the DTO to a product entity for storage in the system.</td>
																							</tr>
																							</table>
																						</blockquote>
																					</details>
																				</blockquote>
																			</details>
																			<details>
																				<summary><b>service</b></summary>
																				<blockquote>
																					<table>
																					<tr>
																						<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/produto/src/main/java/br/com/sgpi/produto/dominio/service/ProdutoService.java'>ProdutoService.java</a></b></td>
																						<td>- Manages product data operations such as listing, retrieving, saving, updating, and deleting products<br>- Validates file structure for bulk product uploads<br>- Checks product existence and reduces stock quantity<br>- Handles exceptions for missing or invalid data.</td>
																					</tr>
																					</table>
																				</blockquote>
																			</details>
																			<details>
																				<summary><b>repository</b></summary>
																				<blockquote>
																					<table>
																					<tr>
																						<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/produto/src/main/java/br/com/sgpi/produto/dominio/repository/ProdutoRepository.java'>ProdutoRepository.java</a></b></td>
																						<td>Manages persistence for products in the domain, utilizing Spring Data JPA repository.</td>
																					</tr>
																					</table>
																				</blockquote>
																			</details>
																		</blockquote>
																	</details>
																</blockquote>
															</details>
														</blockquote>
													</details>
												</blockquote>
											</details>
										</blockquote>
									</details>
								</blockquote>
							</details>
						</blockquote>
					</details>
					<details>
						<summary><b>test</b></summary>
						<blockquote>
							<details>
								<summary><b>java</b></summary>
								<blockquote>
									<details>
										<summary><b>br</b></summary>
										<blockquote>
											<details>
												<summary><b>com</b></summary>
												<blockquote>
													<details>
														<summary><b>sgpi</b></summary>
														<blockquote>
															<details>
																<summary><b>produto</b></summary>
																<blockquote>
																	<table>
																	<tr>
																		<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/produto/src/test/java/br/com/sgpi/produto/ProdutoApplicationTests.java'>ProdutoApplicationTests.java</a></b></td>
																		<td>Verifies the context loading in the project's product module.</td>
																	</tr>
																	</table>
																</blockquote>
															</details>
														</blockquote>
													</details>
												</blockquote>
											</details>
										</blockquote>
									</details>
								</blockquote>
							</details>
						</blockquote>
					</details>
				</blockquote>
			</details>
		</blockquote>
	</details>
	<details> <!-- cliente Submodule -->
		<summary><b>cliente</b></summary>
		<blockquote>
			<table>
			<tr>
				<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/cliente/mvnw.cmd'>mvnw.cmd</a></b></td>
				<td>- Facilitates downloading and installing Apache Maven, ensuring the project's build tool is set up correctly<br>- Handles Maven distribution retrieval, validation, and installation, optimizing the development environment for seamless project building and management.</td>
			</tr>
			<tr>
				<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/cliente/mvnw'>mvnw</a></b></td>
				<td>- Facilitates Apache Maven Wrapper setup and execution<br>- Parses Maven distribution properties, downloads and installs Maven if not found, and handles platform-specific configurations<br>- Ensures Maven distribution integrity through SHA-256 validation<br>- Supports optional environment variables for customization<br>- Enables seamless Maven usage within the project structure.</td>
			</tr>
			</table>
			<details>
				<summary><b>src</b></summary>
				<blockquote>
					<details>
						<summary><b>main</b></summary>
						<blockquote>
							<details>
								<summary><b>resources</b></summary>
								<blockquote>
									<table>
									<tr>
										<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/cliente/src/main/resources/schema.sql'>schema.sql</a></b></td>
										<td>Defines the database schema for the 'cliente' module within the project, ensuring its existence before any operations.</td>
									</tr>
									</table>
								</blockquote>
							</details>
							<details>
								<summary><b>java</b></summary>
								<blockquote>
									<details>
										<summary><b>br</b></summary>
										<blockquote>
											<details>
												<summary><b>com</b></summary>
												<blockquote>
													<details>
														<summary><b>sgpi</b></summary>
														<blockquote>
															<details>
																<summary><b>cliente</b></summary>
																<blockquote>
																	<table>
																	<tr>
																		<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/cliente/src/main/java/br/com/sgpi/cliente/ClienteApplication.java'>ClienteApplication.java</a></b></td>
																		<td>- The code in ClienteApplication.java initializes and runs the Cliente API service<br>- It leverages Spring Boot for application setup, Spring Cloud for service discovery, and Feign for declarative REST client integration<br>- Additionally, it utilizes OpenAPI annotations for API documentation.</td>
																	</tr>
																	</table>
																	<details>
																		<summary><b>infra</b></summary>
																		<blockquote>
																			<details>
																				<summary><b>exception</b></summary>
																				<blockquote>
																					<table>
																					<tr>
																						<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/cliente/src/main/java/br/com/sgpi/cliente/infra/exception/ClienteExceptionHandler.java'>ClienteExceptionHandler.java</a></b></td>
																						<td>- Handles various exceptions in the client module, providing custom error messages based on the type of exception encountered<br>- This centralized exception handling ensures consistent error responses across the application, enhancing user experience and simplifying maintenance.</td>
																					</tr>
																					<tr>
																						<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/cliente/src/main/java/br/com/sgpi/cliente/infra/exception/RegraDeNegocioException.java'>RegraDeNegocioException.java</a></b></td>
																						<td>Defines a custom exception class to handle business rule violations within the project's client module.</td>
																					</tr>
																					</table>
																				</blockquote>
																			</details>
																			<details>
																				<summary><b>util</b></summary>
																				<blockquote>
																					<table>
																					<tr>
																						<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/cliente/src/main/java/br/com/sgpi/cliente/infra/util/MessageService.java'>MessageService.java</a></b></td>
																						<td>- Enables retrieval of localized messages for the application by utilizing a message source with configurable settings<br>- The `MessageService` class provides a method to fetch messages based on a given key, supporting internationalization and localization within the project architecture.</td>
																					</tr>
																					</table>
																				</blockquote>
																			</details>
																			<details>
																				<summary><b>config</b></summary>
																				<blockquote>
																					<table>
																					<tr>
																						<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/cliente/src/main/java/br/com/sgpi/cliente/infra/config/MapperConfig.java'>MapperConfig.java</a></b></td>
																						<td>Defines and configures a mapper bean for client entities, facilitating object-to-object mapping within the project's architecture.</td>
																					</tr>
																					<tr>
																						<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/cliente/src/main/java/br/com/sgpi/cliente/infra/config/AmqpConfiguration.java'>AmqpConfiguration.java</a></b></td>
																						<td>- Defines AMQP configuration for messaging in the project, including message converters, queues, exchanges, and bindings<br>- Initializes RabbitAdmin on application startup for managing RabbitMQ resources efficiently.</td>
																					</tr>
																					<tr>
																						<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/cliente/src/main/java/br/com/sgpi/cliente/infra/config/SpringDocConfigurations.java'>SpringDocConfigurations.java</a></b></td>
																						<td>- Defines OpenAPI configurations for the Clientes API, specifying title, description, contact info, and license details<br>- This file sets up the documentation structure for the API, including endpoints and metadata, facilitating API exploration and understanding for developers using the platform.</td>
																					</tr>
																					</table>
																				</blockquote>
																			</details>
																		</blockquote>
																	</details>
																	<details>
																		<summary><b>apllication</b></summary>
																		<blockquote>
																			<details>
																				<summary><b>util</b></summary>
																				<blockquote>
																					<table>
																					<tr>
																						<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/cliente/src/main/java/br/com/sgpi/cliente/apllication/util/UriUtil.java'>UriUtil.java</a></b></td>
																						<td>Generates URIs with IDs for current requests using Spring's ServletUriComponentsBuilder.</td>
																					</tr>
																					</table>
																				</blockquote>
																			</details>
																			<details>
																				<summary><b>amqp</b></summary>
																				<blockquote>
																					<table>
																					<tr>
																						<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/cliente/src/main/java/br/com/sgpi/cliente/apllication/amqp/ClienteListener.java'>ClienteListener.java</a></b></td>
																						<td>- Handles incoming messages from multiple queues, processing and logging order details, and sending emails to clients<br>- This component is crucial for the system's event-driven architecture, ensuring seamless communication between different parts of the application.</td>
																					</tr>
																					</table>
																				</blockquote>
																			</details>
																			<details>
																				<summary><b>controller</b></summary>
																				<blockquote>
																					<table>
																					<tr>
																						<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/cliente/src/main/java/br/com/sgpi/cliente/apllication/controller/ClienteController.java'>ClienteController.java</a></b></td>
																						<td>- Manages client data through RESTful endpoints, allowing operations such as retrieving, creating, updating, and deleting client information<br>- Utilizes DTOs, entities, mappers, and services to handle client-related operations efficiently.</td>
																					</tr>
																					</table>
																				</blockquote>
																			</details>
																		</blockquote>
																	</details>
																	<details>
																		<summary><b>dominio</b></summary>
																		<blockquote>
																			<details>
																				<summary><b>model</b></summary>
																				<blockquote>
																					<details>
																						<summary><b>entity</b></summary>
																						<blockquote>
																							<table>
																							<tr>
																								<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/cliente/src/main/java/br/com/sgpi/cliente/dominio/model/entity/Cliente.java'>Cliente.java</a></b></td>
																								<td>- Defines the entity structure for the 'Cliente' model in the project, including attributes like name, email, phone, CPF, address, and location details<br>- This file sets up the database table schema and validation constraints for storing and managing client information within the application.</td>
																							</tr>
																							</table>
																						</blockquote>
																					</details>
																					<details>
																						<summary><b>dto</b></summary>
																						<blockquote>
																							<table>
																							<tr>
																								<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/cliente/src/main/java/br/com/sgpi/cliente/dominio/model/dto/PedidoDto.java'>PedidoDto.java</a></b></td>
																								<td>- Defines a data transfer object for orders in the client domain, capturing essential details like order ID, timestamp, status, items, and customer information<br>- This class plays a crucial role in facilitating communication and data exchange related to orders within the project's architecture.</td>
																							</tr>
																							<tr>
																								<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/cliente/src/main/java/br/com/sgpi/cliente/dominio/model/dto/ItemDto.java'>ItemDto.java</a></b></td>
																								<td>- Defines a data transfer object (DTO) for items within the client domain, encapsulating product details like ID, quantity, price, and description<br>- This DTO class facilitates seamless communication between different layers of the project, enhancing data exchange efficiency and clarity.</td>
																							</tr>
																							<tr>
																								<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/cliente/src/main/java/br/com/sgpi/cliente/dominio/model/dto/ClienteDto.java'>ClienteDto.java</a></b></td>
																								<td>- Defines a data transfer object for a client entity, encapsulating essential client details like name, email, and address<br>- This file ensures standardized data representation for client-related operations within the project architecture.</td>
																							</tr>
																							</table>
																						</blockquote>
																					</details>
																					<details>
																						<summary><b>mapper</b></summary>
																						<blockquote>
																							<table>
																							<tr>
																								<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/cliente/src/main/java/br/com/sgpi/cliente/dominio/model/mapper/ClienteMapper.java'>ClienteMapper.java</a></b></td>
																								<td>- The `ClienteMapper` in the provided code file facilitates the conversion between data transfer objects (DTOs) and entity objects for the `Cliente` domain model<br>- It plays a crucial role in maintaining the separation of concerns within the codebase architecture by handling the mapping logic between different representations of the `Cliente` entity.</td>
																							</tr>
																							</table>
																						</blockquote>
																					</details>
																				</blockquote>
																			</details>
																			<details>
																				<summary><b>service</b></summary>
																				<blockquote>
																					<table>
																					<tr>
																						<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/cliente/src/main/java/br/com/sgpi/cliente/dominio/service/ClienteService.java'>ClienteService.java</a></b></td>
																						<td>- Manages client data operations: retrieving all clients, adding a new client, fetching a single client by ID or CPF, updating client details, and deleting a client<br>- Uses a repository to interact with the database and a mapper for data conversion<br>- Logs client actions for tracking.</td>
																					</tr>
																					</table>
																				</blockquote>
																			</details>
																			<details>
																				<summary><b>repository</b></summary>
																				<blockquote>
																					<table>
																					<tr>
																						<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/cliente/src/main/java/br/com/sgpi/cliente/dominio/repository/ClienteRepository.java'>ClienteRepository.java</a></b></td>
																						<td>Enables querying and retrieving client data by CPF in the project's domain.</td>
																					</tr>
																					</table>
																				</blockquote>
																			</details>
																			<details>
																				<summary><b>enumeration</b></summary>
																				<blockquote>
																					<table>
																					<tr>
																						<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/cliente/src/main/java/br/com/sgpi/cliente/dominio/enumeration/StatusPedido.java'>StatusPedido.java</a></b></td>
																						<td>- Defines order status options for the e-commerce system, facilitating tracking and management of customer orders<br>- The enum class encapsulates various order states such as 'REALIZADO' and 'ENTREGUE,' enhancing order processing and fulfillment functionalities within the project architecture.</td>
																					</tr>
																					</table>
																				</blockquote>
																			</details>
																		</blockquote>
																	</details>
																</blockquote>
															</details>
														</blockquote>
													</details>
												</blockquote>
											</details>
										</blockquote>
									</details>
								</blockquote>
							</details>
						</blockquote>
					</details>
					<details>
						<summary><b>test</b></summary>
						<blockquote>
							<details>
								<summary><b>java</b></summary>
								<blockquote>
									<details>
										<summary><b>br</b></summary>
										<blockquote>
											<details>
												<summary><b>com</b></summary>
												<blockquote>
													<details>
														<summary><b>sgpi</b></summary>
														<blockquote>
															<details>
																<summary><b>cliente</b></summary>
																<blockquote>
																	<table>
																	<tr>
																		<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/cliente/src/test/java/br/com/sgpi/cliente/ClienteApplicationTests.java'>ClienteApplicationTests.java</a></b></td>
																		<td>- Verifies the successful loading of the application context in the Cliente module<br>- This test ensures that the necessary dependencies and configurations are correctly set up for the Cliente application to run smoothly within the project architecture.</td>
																	</tr>
																	</table>
																</blockquote>
															</details>
														</blockquote>
													</details>
												</blockquote>
											</details>
										</blockquote>
									</details>
								</blockquote>
							</details>
						</blockquote>
					</details>
				</blockquote>
			</details>
		</blockquote>
	</details>
	<details> <!-- logistica Submodule -->
		<summary><b>logistica</b></summary>
		<blockquote>
			<table>
			<tr>
				<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/logistica/mvnw.cmd'>mvnw.cmd</a></b></td>
				<td>- Facilitates downloading and installing Apache Maven, ensuring the project's build tool is set up correctly<br>- Handles Maven distribution retrieval, validation, and installation, optimizing the development environment for seamless project building and management.</td>
			</tr>
			<tr>
				<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/logistica/mvnw'>mvnw</a></b></td>
				<td>- Facilitates Apache Maven Wrapper setup and execution, handling downloading, installation, and validation of Maven distributions<br>- Parses configuration properties to determine distribution details and manages the Maven environment<br>- Supports optional environment variables for customization<br>- Ensures a seamless Maven setup process for the project.</td>
			</tr>
			</table>
			<details>
				<summary><b>src</b></summary>
				<blockquote>
					<details>
						<summary><b>main</b></summary>
						<blockquote>
							<details>
								<summary><b>resources</b></summary>
								<blockquote>
									<table>
									<tr>
										<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/logistica/src/main/resources/schema.sql'>schema.sql</a></b></td>
										<td>Defines the database schema for the 'logistica' project, ensuring its existence before creating tables.</td>
									</tr>
									</table>
								</blockquote>
							</details>
							<details>
								<summary><b>java</b></summary>
								<blockquote>
									<details>
										<summary><b>br</b></summary>
										<blockquote>
											<details>
												<summary><b>com</b></summary>
												<blockquote>
													<details>
														<summary><b>sgpi</b></summary>
														<blockquote>
															<details>
																<summary><b>logistica</b></summary>
																<blockquote>
																	<table>
																	<tr>
																		<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/logistica/src/main/java/br/com/sgpi/logistica/LogisticaApplication.java'>LogisticaApplication.java</a></b></td>
																		<td>- Initiate the Logística API service by enabling Spring Boot features for web support, service discovery, Feign clients, and scheduling<br>- The application runs the service using Spring's SpringApplication.</td>
																	</tr>
																	</table>
																	<details>
																		<summary><b>infra</b></summary>
																		<blockquote>
																			<details>
																				<summary><b>exception</b></summary>
																				<blockquote>
																					<table>
																					<tr>
																						<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/logistica/src/main/java/br/com/sgpi/logistica/infra/exception/RegraDeNegocioException.java'>RegraDeNegocioException.java</a></b></td>
																						<td>Defines a custom exception class to handle business rule violations within the logistics module of the project.</td>
																					</tr>
																					<tr>
																						<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/logistica/src/main/java/br/com/sgpi/logistica/infra/exception/LogisticaExceptionHandler.java'>LogisticaExceptionHandler.java</a></b></td>
																						<td>- Handles various exceptions in the Logistica module, providing custom error messages based on the type of exception encountered<br>- The LogisticaExceptionHandler class centralizes error handling logic for different scenarios, ensuring consistent and informative responses to client requests.</td>
																					</tr>
																					</table>
																				</blockquote>
																			</details>
																			<details>
																				<summary><b>util</b></summary>
																				<blockquote>
																					<table>
																					<tr>
																						<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/logistica/src/main/java/br/com/sgpi/logistica/infra/util/MessageService.java'>MessageService.java</a></b></td>
																						<td>Enables retrieval of localized messages using Spring's ReloadableResourceBundleMessageSource based on the current locale.</td>
																					</tr>
																					</table>
																				</blockquote>
																			</details>
																			<details>
																				<summary><b>config</b></summary>
																				<blockquote>
																					<table>
																					<tr>
																						<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/logistica/src/main/java/br/com/sgpi/logistica/infra/config/MapperConfig.java'>MapperConfig.java</a></b></td>
																						<td>- Configures and provides mappers for entities in the logistics domain, facilitating object-to-object mapping<br>- The MapperConfig file sets up mappings for Entregador, Pedido, and ItemPedido entities using MapStruct, enhancing data transformation capabilities within the project's architecture.</td>
																					</tr>
																					<tr>
																						<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/logistica/src/main/java/br/com/sgpi/logistica/infra/config/AmqpConfiguration.java'>AmqpConfiguration.java</a></b></td>
																						<td>- Defines AMQP configuration for messaging in the project, including exchanges, queues, and bindings<br>- Utilizes RabbitMQ for message handling<br>- Implements JSON message conversion and initializes RabbitAdmin on application startup<br>- Facilitates communication between different parts of the system using fanout exchanges.</td>
																					</tr>
																					</table>
																				</blockquote>
																			</details>
																		</blockquote>
																	</details>
																	<details>
																		<summary><b>apllication</b></summary>
																		<blockquote>
																			<details>
																				<summary><b>util</b></summary>
																				<blockquote>
																					<table>
																					<tr>
																						<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/logistica/src/main/java/br/com/sgpi/logistica/apllication/util/UriUtil.java'>UriUtil.java</a></b></td>
																						<td>Generates URIs with IDs for current requests using Spring's ServletUriComponentsBuilder, aiding in dynamic resource creation and navigation within the project's logistics application.</td>
																					</tr>
																					</table>
																				</blockquote>
																			</details>
																			<details>
																				<summary><b>amqp</b></summary>
																				<blockquote>
																					<table>
																					<tr>
																						<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/logistica/src/main/java/br/com/sgpi/logistica/apllication/amqp/PedidoListener.java'>PedidoListener.java</a></b></td>
																						<td>- The `PedidoListener` class in the provided codebase listens for incoming messages related to orders and triggers the creation of a new order in the system<br>- This component plays a crucial role in the project's architecture by facilitating real-time order processing through message queuing.</td>
																					</tr>
																					</table>
																				</blockquote>
																			</details>
																			<details>
																				<summary><b>controller</b></summary>
																				<blockquote>
																					<table>
																					<tr>
																						<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/logistica/src/main/java/br/com/sgpi/logistica/apllication/controller/PedidoController.java'>PedidoController.java</a></b></td>
																						<td>- Manages order requests, updates status, and allocates deliveries<br>- Handles creation, retrieval, and modification of orders<br>- Integrates with client services for order allocation and delivery.</td>
																					</tr>
																					<tr>
																						<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/logistica/src/main/java/br/com/sgpi/logistica/apllication/controller/EntregadorController.java'>EntregadorController.java</a></b></td>
																						<td>- Manages Entregador data through RESTful endpoints, handling creation, retrieval, and deactivation operations<br>- Utilizes EntregadorService for business logic and EntregadorMapper for data mapping<br>- Implements Swagger annotations for API documentation.</td>
																					</tr>
																					</table>
																				</blockquote>
																			</details>
																		</blockquote>
																	</details>
																	<details>
																		<summary><b>dominio</b></summary>
																		<blockquote>
																			<details>
																				<summary><b>model</b></summary>
																				<blockquote>
																					<details>
																						<summary><b>entity</b></summary>
																						<blockquote>
																							<table>
																							<tr>
																								<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/logistica/src/main/java/br/com/sgpi/logistica/dominio/model/entity/Entregador.java'>Entregador.java</a></b></td>
																								<td>- Defines the entity structure for delivery personnel in the logistics domain<br>- Captures essential attributes like name, vehicle type, status, and location coordinates<br>- Includes methods to deactivate and check if the personnel is active.</td>
																							</tr>
																							<tr>
																								<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/logistica/src/main/java/br/com/sgpi/logistica/dominio/model/entity/Pedido.java'>Pedido.java</a></b></td>
																								<td>- Defines the structure of a 'Pedido' entity in the project, representing an order with various attributes like customer details, delivery status, and items<br>- It includes validation rules, relationships with other entities, and methods to check delivery status and associated delivery personnel.</td>
																							</tr>
																							<tr>
																								<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/logistica/src/main/java/br/com/sgpi/logistica/dominio/model/entity/Item.java'>Item.java</a></b></td>
																								<td>- Defines an entity for items in the logistics domain, including attributes like quantity and description<br>- This code file plays a crucial role in modeling and persisting item data in the database within the logistics module of the project.</td>
																							</tr>
																							</table>
																						</blockquote>
																					</details>
																					<details>
																						<summary><b>dto</b></summary>
																						<blockquote>
																							<table>
																							<tr>
																								<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/logistica/src/main/java/br/com/sgpi/logistica/dominio/model/dto/EntregadorDto.java'>EntregadorDto.java</a></b></td>
																								<td>- Defines a data transfer object for delivery personnel, capturing essential attributes like name, vehicle type, and location coordinates<br>- This class plays a crucial role in facilitating communication between different parts of the logistics domain model within the project architecture.</td>
																							</tr>
																							<tr>
																								<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/logistica/src/main/java/br/com/sgpi/logistica/dominio/model/dto/PedidoDto.java'>PedidoDto.java</a></b></td>
																								<td>- Defines a data transfer object for representing a delivery order in the logistics domain<br>- It encapsulates essential details such as order ID, delivery status, customer information, and delivery items<br>- This class plays a crucial role in facilitating communication and data exchange within the logistics system.</td>
																							</tr>
																							<tr>
																								<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/logistica/src/main/java/br/com/sgpi/logistica/dominio/model/dto/ItemDto.java'>ItemDto.java</a></b></td>
																								<td>- Defines a data transfer object (DTO) for items in the logistics domain<br>- It encapsulates essential item details like ID, quantity, and description<br>- The DTO ensures data integrity by enforcing validation constraints<br>- This class plays a crucial role in facilitating communication between different layers of the project.</td>
																							</tr>
																							</table>
																						</blockquote>
																					</details>
																					<details>
																						<summary><b>mapper</b></summary>
																						<blockquote>
																							<table>
																							<tr>
																								<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/logistica/src/main/java/br/com/sgpi/logistica/dominio/model/mapper/EntregadorMapper.java'>EntregadorMapper.java</a></b></td>
																								<td>Transforms Entregador objects to and from EntregadorDto objects, facilitating data transfer between layers in the logistica module.</td>
																							</tr>
																							<tr>
																								<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/logistica/src/main/java/br/com/sgpi/logistica/dominio/model/mapper/ItemPedidoMapper.java'>ItemPedidoMapper.java</a></b></td>
																								<td>Maps Item objects to ItemDto objects and vice versa within the logistics domain model.</td>
																							</tr>
																							<tr>
																								<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/logistica/src/main/java/br/com/sgpi/logistica/dominio/model/mapper/PedidoMapper.java'>PedidoMapper.java</a></b></td>
																								<td>Converts Pedido objects to PedidoDto objects and vice versa, facilitating data transfer between the domain model and DTOs in the logistics module.</td>
																							</tr>
																							</table>
																						</blockquote>
																					</details>
																				</blockquote>
																			</details>
																			<details>
																				<summary><b>service</b></summary>
																				<blockquote>
																					<table>
																					<tr>
																						<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/logistica/src/main/java/br/com/sgpi/logistica/dominio/service/EntregadorService.java'>EntregadorService.java</a></b></td>
																						<td>- Manages delivery personnel data, including saving, retrieving, and deactivating records<br>- Utilizes a repository for data storage and a mapper for conversion between DTOs and entities<br>- Implements logging for tracking operations.</td>
																					</tr>
																					<tr>
																						<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/logistica/src/main/java/br/com/sgpi/logistica/dominio/service/PedidoService.java'>PedidoService.java</a></b></td>
																						<td>- Manages and processes orders within the logistics domain, including creating, updating, allocating, and delivering orders<br>- Handles order status updates, item management, and communication with clients and delivery personnel<br>- Ensures efficient order flow and tracking through the system.</td>
																					</tr>
																					<tr>
																						<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/logistica/src/main/java/br/com/sgpi/logistica/dominio/service/ClienteService.java'>ClienteService.java</a></b></td>
																						<td>- Manages client orders and deliveries by allocating and sending out orders for delivery<br>- Utilizes RabbitMQ for communication and Resilience4j for circuit breaking<br>- Key functionalities include allocating orders to delivery personnel and marking orders as delivered.</td>
																					</tr>
																					</table>
																				</blockquote>
																			</details>
																			<details>
																				<summary><b>repository</b></summary>
																				<blockquote>
																					<table>
																					<tr>
																						<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/logistica/src/main/java/br/com/sgpi/logistica/dominio/repository/ItemPedidoRepository.java'>ItemPedidoRepository.java</a></b></td>
																						<td>Manages persistence for order items in the logistics domain, utilizing Spring Data JPA.</td>
																					</tr>
																					<tr>
																						<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/logistica/src/main/java/br/com/sgpi/logistica/dominio/repository/PedidoRepository.java'>PedidoRepository.java</a></b></td>
																						<td>- Defines repository operations for managing orders in the logistics domain, including updating order status and assigning delivery personnel<br>- Implements methods for updating order status and linking delivery personnel, as well as fetching orders with associated items and filtering orders by status.</td>
																					</tr>
																					<tr>
																						<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/logistica/src/main/java/br/com/sgpi/logistica/dominio/repository/EntregadorRepository.java'>EntregadorRepository.java</a></b></td>
																						<td>Manages persistence for delivery personnel entities within the logistics domain, utilizing Spring Data JPA repositories.</td>
																					</tr>
																					</table>
																				</blockquote>
																			</details>
																			<details>
																				<summary><b>util</b></summary>
																				<blockquote>
																					<details>
																						<summary><b>validators</b></summary>
																						<blockquote>
																							<table>
																							<tr>
																								<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/logistica/src/main/java/br/com/sgpi/logistica/dominio/util/validators/Criacao.java'>Criacao.java</a></b></td>
																								<td>Defines a contract for creation-related operations within the logistics domain.</td>
																							</tr>
																							<tr>
																								<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/logistica/src/main/java/br/com/sgpi/logistica/dominio/util/validators/PresentValidator.java'>PresentValidator.java</a></b></td>
																								<td>- Validates if a given date and time is within a 5-minute range from the current date and time<br>- This ensures timely data input for the logistics domain in the project architecture.</td>
																							</tr>
																							<tr>
																								<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/logistica/src/main/java/br/com/sgpi/logistica/dominio/util/validators/CampoNaoPermitido.java'>CampoNaoPermitido.java</a></b></td>
																								<td>- Defines a custom validation annotation `CampoNaoPermitido` to restrict certain fields in the logistics domain<br>- This annotation is used to enforce constraints on specific fields within the project's validation framework.</td>
																							</tr>
																							<tr>
																								<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/logistica/src/main/java/br/com/sgpi/logistica/dominio/util/validators/Present.java'>Present.java</a></b></td>
																								<td>- Validates the presence of current data in the system by defining a custom annotation<br>- This annotation is used to ensure that a specific field or method contains data relevant to the present moment.</td>
																							</tr>
																							<tr>
																								<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/logistica/src/main/java/br/com/sgpi/logistica/dominio/util/validators/CampoNaoPermitidoValidator.java'>CampoNaoPermitidoValidator.java</a></b></td>
																								<td>Validates if a field is null, ensuring compliance with specified constraints in the logistics domain.</td>
																							</tr>
																							</table>
																						</blockquote>
																					</details>
																					<details>
																						<summary><b>schedulers</b></summary>
																						<blockquote>
																							<table>
																							<tr>
																								<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/logistica/src/main/java/br/com/sgpi/logistica/dominio/util/schedulers/TarefaAgendada.java'>TarefaAgendada.java</a></b></td>
																								<td>- Scheduled task in `TarefaAgendada.java` processes orders with specific statuses, communicating with clients and updating order status accordingly<br>- It retrieves orders, allocates or delivers them, and saves updates using repository services<br>- This component plays a crucial role in managing order fulfillment within the logistics domain of the project.</td>
																							</tr>
																							</table>
																						</blockquote>
																					</details>
																				</blockquote>
																			</details>
																			<details>
																				<summary><b>enumeration</b></summary>
																				<blockquote>
																					<table>
																					<tr>
																						<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/logistica/src/main/java/br/com/sgpi/logistica/dominio/enumeration/Veiculo.java'>Veiculo.java</a></b></td>
																						<td>Defines vehicle types for logistical operations within the project architecture.</td>
																					</tr>
																					<tr>
																						<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/logistica/src/main/java/br/com/sgpi/logistica/dominio/enumeration/StatusEntregador.java'>StatusEntregador.java</a></b></td>
																						<td>- Defines delivery status options for couriers in the logistics domain, facilitating tracking and management of their availability<br>- This enumeration class plays a crucial role in representing the states of couriers within the system, enabling efficient monitoring and allocation of delivery resources.</td>
																					</tr>
																					<tr>
																						<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/logistica/src/main/java/br/com/sgpi/logistica/dominio/enumeration/StatusPedido.java'>StatusPedido.java</a></b></td>
																						<td>Defines status options for logistics orders in the project's domain.</td>
																					</tr>
																					</table>
																				</blockquote>
																			</details>
																		</blockquote>
																	</details>
																</blockquote>
															</details>
														</blockquote>
													</details>
												</blockquote>
											</details>
										</blockquote>
									</details>
								</blockquote>
							</details>
						</blockquote>
					</details>
					<details>
						<summary><b>test</b></summary>
						<blockquote>
							<details>
								<summary><b>resources</b></summary>
								<blockquote>
									<table>
									<tr>
										<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/logistica/src/test/resources/data_pedido.sql'>data_pedido.sql</a></b></td>
										<td>Populate test data for orders and items in the database to facilitate testing and validation of the logistics system.</td>
									</tr>
									<tr>
										<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/logistica/src/test/resources/schema.sql'>schema.sql</a></b></td>
										<td>Defines the database schema for the 'logistica' project, ensuring its existence before use.</td>
									</tr>
									<tr>
										<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/logistica/src/test/resources/clean.sql'>clean.sql</a></b></td>
										<td>Clears all delivery-related data from the database to ensure a clean slate for testing and development.</td>
									</tr>
									<tr>
										<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/logistica/src/test/resources/data_entregador.sql'>data_entregador.sql</a></b></td>
										<td>Populate the database with sample delivery driver data for testing purposes.</td>
									</tr>
									</table>
								</blockquote>
							</details>
							<details>
								<summary><b>java</b></summary>
								<blockquote>
									<details>
										<summary><b>br</b></summary>
										<blockquote>
											<details>
												<summary><b>com</b></summary>
												<blockquote>
													<details>
														<summary><b>sgpi</b></summary>
														<blockquote>
															<details>
																<summary><b>logistica</b></summary>
																<blockquote>
																	<table>
																	<tr>
																		<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/logistica/src/test/java/br/com/sgpi/logistica/LogisticaApplicationTests.java'>LogisticaApplicationTests.java</a></b></td>
																		<td>Verifies the context loading in the Logistica application through testing.</td>
																	</tr>
																	</table>
																	<details>
																		<summary><b>util</b></summary>
																		<blockquote>
																			<table>
																			<tr>
																				<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/logistica/src/test/java/br/com/sgpi/logistica/util/DadosErroValidacao.java'>DadosErroValidacao.java</a></b></td>
																				<td>- Defines validation error data structure for the logistics module, encapsulating field, user message, and developer message<br>- This record class aids in handling and communicating validation errors within the project architecture.</td>
																			</tr>
																			<tr>
																				<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/logistica/src/test/java/br/com/sgpi/logistica/util/Util.java'>Util.java</a></b></td>
																				<td>- Generates mock data for Entregador and Pedido entities to facilitate testing scenarios within the logistics domain<br>- The Util class provides methods to create instances with valid and invalid data, aiding in the development and testing of features related to delivery and order management.</td>
																			</tr>
																			<tr>
																				<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/logistica/src/test/java/br/com/sgpi/logistica/util/DadosErro.java'>DadosErro.java</a></b></td>
																				<td>- Defines a data structure for error details in the logistics module, encapsulating user-friendly and developer-specific error messages<br>- This record class aids in standardizing error handling across the project, enhancing clarity and consistency in error reporting within the system.</td>
																			</tr>
																			</table>
																		</blockquote>
																	</details>
																	<details>
																		<summary><b>apllication</b></summary>
																		<blockquote>
																			<details>
																				<summary><b>controller</b></summary>
																				<blockquote>
																					<table>
																					<tr>
																						<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/logistica/src/test/java/br/com/sgpi/logistica/apllication/controller/EntregadorControllerTest.java'>EntregadorControllerTest.java</a></b></td>
																						<td>- Tests the delivery functionality of the EntregadorController by verifying the successful retrieval of delivery information and the proper registration of a new delivery<br>- Additionally, it ensures that invalid delivery data triggers the appropriate error response.</td>
																					</tr>
																					</table>
																				</blockquote>
																			</details>
																		</blockquote>
																	</details>
																	<details>
																		<summary><b>dominio</b></summary>
																		<blockquote>
																			<details>
																				<summary><b>service</b></summary>
																				<blockquote>
																					<table>
																					<tr>
																						<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/logistica/src/test/java/br/com/sgpi/logistica/dominio/service/EntregadorServiceTest.java'>EntregadorServiceTest.java</a></b></td>
																						<td>- Tests the functionality of registering and deactivating delivery personnel, ensuring proper validation and exception handling<br>- Additionally, verifies the retrieval of a list of delivery personnel with corresponding DTOs.</td>
																					</tr>
																					<tr>
																						<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/logistica/src/test/java/br/com/sgpi/logistica/dominio/service/EntregadorServiceIT.java'>EntregadorServiceIT.java</a></b></td>
																						<td>- Manages delivery service operations, including creating, deactivating, and retrieving delivery personnel from the database<br>- Ensures proper handling of exceptions and data integrity<br>- Supports testing through database setup and validation.</td>
																					</tr>
																					<tr>
																						<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/logistica/src/test/java/br/com/sgpi/logistica/dominio/service/PedidoServiceIT.java'>PedidoServiceIT.java</a></b></td>
																						<td>- Implements integration tests for the PedidoService class, ensuring correct functionality of creating, updating, and allocating orders<br>- Validates order status updates, delivery allocation, and exception handling scenarios<br>- The tests cover key business logic for managing orders and delivery processes within the logistics domain.</td>
																					</tr>
																					<tr>
																						<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/logistica/src/test/java/br/com/sgpi/logistica/dominio/service/PedidoServiceTest.java'>PedidoServiceTest.java</a></b></td>
																						<td>- Test suite for the `PedidoService` class validates order creation, status updates, and delivery handling<br>- It ensures proper validation, item allocation, and exception handling for orders<br>- The tests cover scenarios like past date entry, inactive delivery personnel, successful delivery, and order status checks.</td>
																					</tr>
																					</table>
																				</blockquote>
																			</details>
																			<details>
																				<summary><b>repository</b></summary>
																				<blockquote>
																					<table>
																					<tr>
																						<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/logistica/src/test/java/br/com/sgpi/logistica/dominio/repository/PedidoRepositoryTest.java'>PedidoRepositoryTest.java</a></b></td>
																						<td>- Tests the functionality of the PedidoRepository by verifying the ability to register and retrieve orders<br>- The test suite ensures that orders can be saved and queried correctly, validating the core repository operations within the logistics domain of the project.</td>
																					</tr>
																					<tr>
																						<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/logistica/src/test/java/br/com/sgpi/logistica/dominio/repository/EntregadorRepositoryIT.java'>EntregadorRepositoryIT.java</a></b></td>
																						<td>- Tests the functionality of creating, deactivating, and querying delivery personnel in the system<br>- Validates the ability to create a delivery personnel record, deactivate it, and retrieve delivery personnel information from the repository<br>- This file ensures the proper functioning of delivery personnel management within the project architecture.</td>
																					</tr>
																					<tr>
																						<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/logistica/src/test/java/br/com/sgpi/logistica/dominio/repository/PedidoRepositoryIT.java'>PedidoRepositoryIT.java</a></b></td>
																						<td>- Implements integration tests for the PedidoRepository to ensure proper functionality of creating, retrieving, and querying orders within the logistics domain<br>- The tests cover scenarios such as creating a table, registering a new order, and querying existing orders, validating data integrity and consistency.</td>
																					</tr>
																					<tr>
																						<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/logistica/src/test/java/br/com/sgpi/logistica/dominio/repository/EntregadorRepositoryTest.java'>EntregadorRepositoryTest.java</a></b></td>
																						<td>- Tests the registration and deactivation of delivery drivers, as well as the retrieval of driver information<br>- It ensures proper saving, deactivation, and retrieval of driver entities, validating their attributes and statuses.</td>
																					</tr>
																					</table>
																				</blockquote>
																			</details>
																		</blockquote>
																	</details>
																</blockquote>
															</details>
														</blockquote>
													</details>
												</blockquote>
											</details>
										</blockquote>
									</details>
								</blockquote>
							</details>
						</blockquote>
					</details>
				</blockquote>
			</details>
		</blockquote>
	</details>
	<details> <!-- pedido Submodule -->
		<summary><b>pedido</b></summary>
		<blockquote>
			<table>
			<tr>
				<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/pedido/mvnw.cmd'>mvnw.cmd</a></b></td>
				<td>- Facilitates downloading and installing Apache Maven, ensuring the correct distribution version and SHA-256 validation<br>- Handles setting up the Maven environment variables and paths for seamless project builds.</td>
			</tr>
			<tr>
				<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/pedido/mvnw'>mvnw</a></b></td>
				<td>- Facilitates Apache Maven Wrapper setup and execution, ensuring correct Maven distribution download and installation<br>- Handles optional environment variables for customization, such as JAVA_HOME and MVNW_REPOURL<br>- Verifies SHA-256 checksum for security<br>- Automatically downloads, validates, and installs Maven if not found, optimizing project build processes.</td>
			</tr>
			</table>
			<details>
				<summary><b>src</b></summary>
				<blockquote>
					<details>
						<summary><b>main</b></summary>
						<blockquote>
							<details>
								<summary><b>resources</b></summary>
								<blockquote>
									<table>
									<tr>
										<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/pedido/src/main/resources/schema.sql'>schema.sql</a></b></td>
										<td>- Defines the database schema for the 'pedido' module within the project, ensuring its existence before any operations<br>- This file plays a crucial role in setting up the necessary structure for managing data related to orders, streamlining database operations for the entire codebase architecture.</td>
									</tr>
									</table>
								</blockquote>
							</details>
							<details>
								<summary><b>java</b></summary>
								<blockquote>
									<details>
										<summary><b>br</b></summary>
										<blockquote>
											<details>
												<summary><b>com</b></summary>
												<blockquote>
													<details>
														<summary><b>sgpi</b></summary>
														<blockquote>
															<details>
																<summary><b>pedido</b></summary>
																<blockquote>
																	<table>
																	<tr>
																		<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/pedido/src/main/java/br/com/sgpi/pedido/PedidoApplication.java'>PedidoApplication.java</a></b></td>
																		<td>- Initiates the Pedido application, enabling Spring Boot features like data web support, scheduling, and Feign clients<br>- Integrates with service discovery and provides OpenAPI documentation for the Pedido API.</td>
																	</tr>
																	</table>
																	<details>
																		<summary><b>infra</b></summary>
																		<blockquote>
																			<details>
																				<summary><b>exception</b></summary>
																				<blockquote>
																					<table>
																					<tr>
																						<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/pedido/src/main/java/br/com/sgpi/pedido/infra/exception/RegraDeNegocioException.java'>RegraDeNegocioException.java</a></b></td>
																						<td>Defines a custom exception class to handle business rule violations within the order management module of the project.</td>
																					</tr>
																					<tr>
																						<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/pedido/src/main/java/br/com/sgpi/pedido/infra/exception/PedidoExceptionHandler.java'>PedidoExceptionHandler.java</a></b></td>
																						<td>- Handles various exceptions in the Pedido module, providing custom error messages for different scenarios like entity not found, validation errors, data integrity violations, and more<br>- The PedidoExceptionHandler class ensures proper error handling and response generation for different types of exceptions in the application.</td>
																					</tr>
																					</table>
																				</blockquote>
																			</details>
																			<details>
																				<summary><b>util</b></summary>
																				<blockquote>
																					<table>
																					<tr>
																						<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/pedido/src/main/java/br/com/sgpi/pedido/infra/util/MessageService.java'>MessageService.java</a></b></td>
																						<td>- MessageService.java provides a centralized way to retrieve localized messages for the project<br>- It encapsulates the logic for fetching messages from resource bundles based on the current locale, enhancing the application's internationalization capabilities.</td>
																					</tr>
																					</table>
																				</blockquote>
																			</details>
																			<details>
																				<summary><b>config</b></summary>
																				<blockquote>
																					<table>
																					<tr>
																						<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/pedido/src/main/java/br/com/sgpi/pedido/infra/config/MapperConfig.java'>MapperConfig.java</a></b></td>
																						<td>Defines mapper beans for Pedido and ItemPedido to facilitate object mapping within the project's architecture.</td>
																					</tr>
																					<tr>
																						<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/pedido/src/main/java/br/com/sgpi/pedido/infra/config/AmqpConfiguration.java'>AmqpConfiguration.java</a></b></td>
																						<td>- Defines AMQP configuration for messaging in the project, including message serialization, queues, exchanges, and bindings<br>- Initializes RabbitMQ components for handling messages between different parts of the system.</td>
																					</tr>
																					</table>
																				</blockquote>
																			</details>
																		</blockquote>
																	</details>
																	<details>
																		<summary><b>apllication</b></summary>
																		<blockquote>
																			<details>
																				<summary><b>http</b></summary>
																				<blockquote>
																					<table>
																					<tr>
																						<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/pedido/src/main/java/br/com/sgpi/pedido/apllication/http/ProdutoClient.java'>ProdutoClient.java</a></b></td>
																						<td>- Enables communication with the 'produto-ms' service to check product existence, retrieve product details, and update stock levels<br>- This interface defines methods for querying product information and managing inventory, facilitating seamless integration with the external product service within the project architecture.</td>
																					</tr>
																					<tr>
																						<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/pedido/src/main/java/br/com/sgpi/pedido/apllication/http/ClienteClient.java'>ClienteClient.java</a></b></td>
																						<td>Enables communication with the 'cliente-ms' service to retrieve client information based on their CPF.</td>
																					</tr>
																					</table>
																				</blockquote>
																			</details>
																			<details>
																				<summary><b>util</b></summary>
																				<blockquote>
																					<table>
																					<tr>
																						<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/pedido/src/main/java/br/com/sgpi/pedido/apllication/util/UriUtil.java'>UriUtil.java</a></b></td>
																						<td>Generates a URI with an ID for the current request using Spring's ServletUriComponentsBuilder in the pedido application.</td>
																					</tr>
																					</table>
																				</blockquote>
																			</details>
																			<details>
																				<summary><b>controller</b></summary>
																				<blockquote>
																					<table>
																					<tr>
																						<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/pedido/src/main/java/br/com/sgpi/pedido/apllication/controller/PedidoController.java'>PedidoController.java</a></b></td>
																						<td>- Manages and exposes endpoints for handling orders within the API, including listing all orders, retrieving a specific order by ID, creating a new order, updating order status, and approving payment for an order<br>- The controller interacts with the PedidoService to perform these operations, contributing to the overall functionality of the order management system.</td>
																					</tr>
																					</table>
																				</blockquote>
																			</details>
																		</blockquote>
																	</details>
																	<details>
																		<summary><b>dominio</b></summary>
																		<blockquote>
																			<details>
																				<summary><b>model</b></summary>
																				<blockquote>
																					<details>
																						<summary><b>entity</b></summary>
																						<blockquote>
																							<table>
																							<tr>
																								<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/pedido/src/main/java/br/com/sgpi/pedido/dominio/model/entity/Pedido.java'>Pedido.java</a></b></td>
																								<td>- Defines the structure of a Pedido entity, representing an order in the system<br>- It includes details such as order timestamp, status, customer information, and order items<br>- The entity also handles pre-saving logic and populating customer data.</td>
																							</tr>
																							<tr>
																								<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/pedido/src/main/java/br/com/sgpi/pedido/dominio/model/entity/Item.java'>Item.java</a></b></td>
																								<td>- Defines an entity representing an item in the order system, storing details like quantity, description, price, and product status<br>- Includes methods to populate item data from a product and check if the product is validated.</td>
																							</tr>
																							</table>
																						</blockquote>
																					</details>
																					<details>
																						<summary><b>dto</b></summary>
																						<blockquote>
																							<table>
																							<tr>
																								<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/pedido/src/main/java/br/com/sgpi/pedido/dominio/model/dto/PedidoRequestDto.java'>PedidoRequestDto.java</a></b></td>
																								<td>- Define the structure for creating a DTO object that represents a request for a new order in the system<br>- The `PedidoRequestDto` class contains a list of items and the customer's CPF, ensuring data validity through annotations<br>- This file plays a crucial role in handling incoming order requests within the project's domain model.</td>
																							</tr>
																							<tr>
																								<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/pedido/src/main/java/br/com/sgpi/pedido/dominio/model/dto/ItemDto.java'>ItemDto.java</a></b></td>
																								<td>Define and validate data structure for order items in the domain model.</td>
																							</tr>
																							<tr>
																								<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/pedido/src/main/java/br/com/sgpi/pedido/dominio/model/dto/ProdutoDto.java'>ProdutoDto.java</a></b></td>
																								<td>- Defines a data transfer object for products with essential attributes like ID, name, price, and status<br>- Includes methods to create a product with a validated status and check if the status is valid<br>- This class plays a crucial role in representing product information within the project's domain model.</td>
																							</tr>
																							<tr>
																								<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/pedido/src/main/java/br/com/sgpi/pedido/dominio/model/dto/ClienteDto.java'>ClienteDto.java</a></b></td>
																								<td>- Define a data transfer object for client information, including fields for name, email, phone, address, and integration status<br>- The object enforces validation rules for each field, ensuring data integrity within the system.</td>
																							</tr>
																							<tr>
																								<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/pedido/src/main/java/br/com/sgpi/pedido/dominio/model/dto/PedidoResponseDto.java'>PedidoResponseDto.java</a></b></td>
																								<td>- Defines a data transfer object for representing a response to a pedido request<br>- It encapsulates essential details such as id, timestamp, status, items, client information, and address<br>- This class plays a crucial role in facilitating communication between different layers of the application by providing a structured format for transmitting pedido response data.</td>
																							</tr>
																							</table>
																						</blockquote>
																					</details>
																					<details>
																						<summary><b>mapper</b></summary>
																						<blockquote>
																							<table>
																							<tr>
																								<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/pedido/src/main/java/br/com/sgpi/pedido/dominio/model/mapper/ItemPedidoMapper.java'>ItemPedidoMapper.java</a></b></td>
																								<td>Transforms Item objects to and from ItemDto objects, facilitating data exchange between the domain model and DTOs in the pedido module.</td>
																							</tr>
																							<tr>
																								<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/pedido/src/main/java/br/com/sgpi/pedido/dominio/model/mapper/PedidoMapper.java'>PedidoMapper.java</a></b></td>
																								<td>Converts Pedido objects between different data transfer object formats for seamless communication within the SGPI project.</td>
																							</tr>
																							</table>
																						</blockquote>
																					</details>
																				</blockquote>
																			</details>
																			<details>
																				<summary><b>service</b></summary>
																				<blockquote>
																					<table>
																					<tr>
																						<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/pedido/src/main/java/br/com/sgpi/pedido/dominio/service/PedidoService.java'>PedidoService.java</a></b></td>
																						<td>- Manages and processes orders within the system, including creating, updating status, and approving payments<br>- Validates stock availability, integrates client data, and sends orders to queues if criteria are met<br>- Facilitates seamless order handling and ensures accurate stock management and client integration.</td>
																					</tr>
																					<tr>
																						<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/pedido/src/main/java/br/com/sgpi/pedido/dominio/service/ProdutoService.java'>ProdutoService.java</a></b></td>
																						<td>- Handles product operations by interacting with external services, ensuring resilience through circuit breakers<br>- Retrieves and updates product information, falling back gracefully in case of failures<br>- Maintains product status validation and inventory management functionalities within the application architecture.</td>
																					</tr>
																					<tr>
																						<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/pedido/src/main/java/br/com/sgpi/pedido/dominio/service/ClienteService.java'>ClienteService.java</a></b></td>
																						<td>- Implements a service to consult client information, integrating with an external client service<br>- Uses circuit breaker pattern for resilience<br>- Logs warnings and provides a fallback method in case of failure.</td>
																					</tr>
																					</table>
																				</blockquote>
																			</details>
																			<details>
																				<summary><b>repository</b></summary>
																				<blockquote>
																					<table>
																					<tr>
																						<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/pedido/src/main/java/br/com/sgpi/pedido/dominio/repository/PedidoRepository.java'>PedidoRepository.java</a></b></td>
																						<td>- Defines repository methods for updating and querying Pedido entities in the database<br>- Includes operations to update Pedido status and fetch Pedido with associated items<br>- Facilitates querying for Pedidos with specific criteria, such as invalid inventory or unlinked clients.</td>
																					</tr>
																					<tr>
																						<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/pedido/src/main/java/br/com/sgpi/pedido/dominio/repository/ItemRepository.java'>ItemRepository.java</a></b></td>
																						<td>Manages persistence for items in the order domain, utilizing Spring Data JPA repositories.</td>
																					</tr>
																					</table>
																				</blockquote>
																			</details>
																			<details>
																				<summary><b>util</b></summary>
																				<blockquote>
																					<details>
																						<summary><b>validators</b></summary>
																						<blockquote>
																							<table>
																							<tr>
																								<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/pedido/src/main/java/br/com/sgpi/pedido/dominio/util/validators/Criacao.java'>Criacao.java</a></b></td>
																								<td>Defines creation validation rules for the domain entities in the pedido module, ensuring data integrity and consistency.</td>
																							</tr>
																							<tr>
																								<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/pedido/src/main/java/br/com/sgpi/pedido/dominio/util/validators/PresentValidator.java'>PresentValidator.java</a></b></td>
																								<td>Validates the proximity of a given date and time to the current moment within a 5-minute window.</td>
																							</tr>
																							<tr>
																								<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/pedido/src/main/java/br/com/sgpi/pedido/dominio/util/validators/CampoNaoPermitido.java'>CampoNaoPermitido.java</a></b></td>
																								<td>Defines a custom annotation to mark fields not allowed in requests, enhancing validation capabilities within the project's domain.</td>
																							</tr>
																							<tr>
																								<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/pedido/src/main/java/br/com/sgpi/pedido/dominio/util/validators/Present.java'>Present.java</a></b></td>
																								<td>Validates the presence of a date in the current time frame within the project's domain.</td>
																							</tr>
																							<tr>
																								<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/pedido/src/main/java/br/com/sgpi/pedido/dominio/util/validators/CampoNaoPermitidoValidator.java'>CampoNaoPermitidoValidator.java</a></b></td>
																								<td>- Validates if a field is not allowed to have a value by checking if it's null<br>- This validator ensures that specific fields remain empty as required by the business logic, contributing to data integrity and consistency within the application.</td>
																							</tr>
																							</table>
																						</blockquote>
																					</details>
																					<details>
																						<summary><b>schedulers</b></summary>
																						<blockquote>
																							<table>
																							<tr>
																								<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/pedido/src/main/java/br/com/sgpi/pedido/dominio/util/schedulers/TarefaAgendada.java'>TarefaAgendada.java</a></b></td>
																								<td>- Scheduled task in `TarefaAgendada.java` processes pending orders by validating stock, integrating clients, and communicating with them if needed<br>- It ensures stock availability, updates order status, and communicates with clients as necessary, enhancing order processing efficiency.</td>
																							</tr>
																							</table>
																						</blockquote>
																					</details>
																				</blockquote>
																			</details>
																			<details>
																				<summary><b>enumeration</b></summary>
																				<blockquote>
																					<table>
																					<tr>
																						<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/pedido/src/main/java/br/com/sgpi/pedido/dominio/enumeration/StatusPedido.java'>StatusPedido.java</a></b></td>
																						<td>Defines various status options for orders within the domain, such as 'REALIZADO' and 'ENTREGUE,' enhancing clarity and organization in tracking order progress.</td>
																					</tr>
																					<tr>
																						<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/pedido/src/main/java/br/com/sgpi/pedido/dominio/enumeration/StatusProduto.java'>StatusProduto.java</a></b></td>
																						<td>Define product validation states for the order domain in the project.</td>
																					</tr>
																					</table>
																				</blockquote>
																			</details>
																		</blockquote>
																	</details>
																</blockquote>
															</details>
														</blockquote>
													</details>
												</blockquote>
											</details>
										</blockquote>
									</details>
								</blockquote>
							</details>
						</blockquote>
					</details>
					<details>
						<summary><b>test</b></summary>
						<blockquote>
							<details>
								<summary><b>java</b></summary>
								<blockquote>
									<details>
										<summary><b>br</b></summary>
										<blockquote>
											<details>
												<summary><b>com</b></summary>
												<blockquote>
													<details>
														<summary><b>sgpi</b></summary>
														<blockquote>
															<details>
																<summary><b>pedido</b></summary>
																<blockquote>
																	<table>
																	<tr>
																		<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/pedido/src/test/java/br/com/sgpi/pedido/PedidoApplicationTests.java'>PedidoApplicationTests.java</a></b></td>
																		<td>Verify the application context loads successfully by running tests in the PedidoApplicationTests file.</td>
																	</tr>
																	</table>
																</blockquote>
															</details>
														</blockquote>
													</details>
												</blockquote>
											</details>
										</blockquote>
									</details>
								</blockquote>
							</details>
						</blockquote>
					</details>
				</blockquote>
			</details>
		</blockquote>
	</details>
	<details> <!-- gateway Submodule -->
		<summary><b>gateway</b></summary>
		<blockquote>
			<table>
			<tr>
				<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/gateway/mvnw.cmd'>mvnw.cmd</a></b></td>
				<td>- Facilitates downloading and installing Apache Maven, ensuring the correct distribution version and SHA-256 validation<br>- Handles setting up the Maven environment variables and paths for seamless project builds.</td>
			</tr>
			<tr>
				<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/gateway/mvnw'>mvnw</a></b></td>
				<td>- Facilitates Apache Maven Wrapper setup and execution, ensuring correct Maven distribution download and installation<br>- Handles environment variables for configuration and supports optional SHA-256 validation<br>- Automatically manages Maven home directory creation and cleanup, enhancing project build and dependency management.</td>
			</tr>
			</table>
			<details>
				<summary><b>src</b></summary>
				<blockquote>
					<details>
						<summary><b>main</b></summary>
						<blockquote>
							<details>
								<summary><b>java</b></summary>
								<blockquote>
									<details>
										<summary><b>br</b></summary>
										<blockquote>
											<details>
												<summary><b>com</b></summary>
												<blockquote>
													<details>
														<summary><b>sgpi</b></summary>
														<blockquote>
															<details>
																<summary><b>gateway</b></summary>
																<blockquote>
																	<table>
																	<tr>
																		<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/gateway/src/main/java/br/com/sgpi/gateway/GatewayApplication.java'>GatewayApplication.java</a></b></td>
																		<td>- Defines custom routing for the API Gateway using RouteLocatorBuilder to set routes and associated filters<br>- Configures routes for "cliente-ms" and "logistica-ms" services, stripping the first path segment and directing requests to respective service instances<br>- Enables dynamic routing and load balancing for microservices communication.</td>
																	</tr>
																	</table>
																</blockquote>
															</details>
														</blockquote>
													</details>
												</blockquote>
											</details>
										</blockquote>
									</details>
								</blockquote>
							</details>
						</blockquote>
					</details>
					<details>
						<summary><b>test</b></summary>
						<blockquote>
							<details>
								<summary><b>java</b></summary>
								<blockquote>
									<details>
										<summary><b>br</b></summary>
										<blockquote>
											<details>
												<summary><b>com</b></summary>
												<blockquote>
													<details>
														<summary><b>sgpi</b></summary>
														<blockquote>
															<details>
																<summary><b>gateway</b></summary>
																<blockquote>
																	<table>
																	<tr>
																		<td><b><a href='https://github.com/aricomputacao/sgpi/blob/master/gateway/src/test/java/br/com/sgpi/gateway/GatewayApplicationTests.java'>GatewayApplicationTests.java</a></b></td>
																		<td>- Tests the context loading functionality of the GatewayApplication in the project structure<br>- This file ensures that the application can start up successfully and the necessary dependencies are properly configured for the gateway module.</td>
																	</tr>
																	</table>
																</blockquote>
															</details>
														</blockquote>
													</details>
												</blockquote>
											</details>
										</blockquote>
									</details>
								</blockquote>
							</details>
						</blockquote>
					</details>
				</blockquote>
			</details>
		</blockquote>
	</details>
</details>

---
##  Getting Started

###  Prerequisites

Before getting started with sgpi, ensure your runtime environment meets the following requirements:

- **Programming Language:** Java


###  Installation

Install sgpi using one of the following methods:

**Build from source:**

1. Clone the sgpi repository:
```sh
❯ git clone https://github.com/aricomputacao/sgpi
```

2. Navigate to the project directory:
```sh
❯ cd sgpi
```

3. Install the project dependencies:

echo 'INSERT-INSTALL-COMMAND-HERE'



###  Usage
Run sgpi using the following command:
echo 'INSERT-RUN-COMMAND-HERE'

###  Testing
Run the test suite using the following command:
echo 'INSERT-TEST-COMMAND-HERE'

---
##  Project Roadmap

- [X] **`Task 1`**: <strike>Implement feature one.</strike>
- [ ] **`Task 2`**: Implement feature two.
- [ ] **`Task 3`**: Implement feature three.

---

##  Contributing

- **💬 [Join the Discussions](https://github.com/aricomputacao/sgpi/discussions)**: Share your insights, provide feedback, or ask questions.
- **🐛 [Report Issues](https://github.com/aricomputacao/sgpi/issues)**: Submit bugs found or log feature requests for the `sgpi` project.
- **💡 [Submit Pull Requests](https://github.com/aricomputacao/sgpi/blob/main/CONTRIBUTING.md)**: Review open PRs, and submit your own PRs.

<details closed>
<summary>Contributing Guidelines</summary>

1. **Fork the Repository**: Start by forking the project repository to your github account.
2. **Clone Locally**: Clone the forked repository to your local machine using a git client.
   ```sh
   git clone https://github.com/aricomputacao/sgpi
   ```
3. **Create a New Branch**: Always work on a new branch, giving it a descriptive name.
   ```sh
   git checkout -b new-feature-x
   ```
4. **Make Your Changes**: Develop and test your changes locally.
5. **Commit Your Changes**: Commit with a clear message describing your updates.
   ```sh
   git commit -m 'Implemented new feature x.'
   ```
6. **Push to github**: Push the changes to your forked repository.
   ```sh
   git push origin new-feature-x
   ```
7. **Submit a Pull Request**: Create a PR against the original project repository. Clearly describe the changes and their motivations.
8. **Review**: Once your PR is reviewed and approved, it will be merged into the main branch. Congratulations on your contribution!
</details>

<details closed>
<summary>Contributor Graph</summary>
<br>
<p align="left">
   <a href="https://github.com{/aricomputacao/sgpi/}graphs/contributors">
      <img src="https://contrib.rocks/image?repo=aricomputacao/sgpi">
   </a>
</p>
</details>

---

##  License

This project is protected under the [SELECT-A-LICENSE](https://choosealicense.com/licenses) License. For more details, refer to the [LICENSE](https://choosealicense.com/licenses/) file.

---

##  Acknowledgments

- List any resources, contributors, inspiration, etc. here.

---