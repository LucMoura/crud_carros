# CRUD de Carros

Este é um projeto Spring Boot para gerenciar um catálogo de carros, permitindo operações CRUD (Criar, Ler, Atualizar, Excluir) com validações no front-end e back-end.

## Funcionalidades

- **Cadastro de Carros**: Permite o cadastro de novos carros com as informações de modelo, marca, ano, preço, descrição, motor e quantidade.
- **Edição de Carros**: Permite editar as informações de um carro já cadastrado.
- **Exclusão de Carros**: Permite excluir um carro do catálogo.
- **Validações**: Validações são realizadas tanto no front-end quanto no back-end para garantir que os dados inseridos sejam válidos.
- **Exibição de Carros**: Exibe uma lista de carros cadastrados no banco de dados.

## Tecnologias Utilizadas

- **Spring Boot**: Framework principal para construção da aplicação.
- **Thymeleaf**: Engine de templates para renderizar as páginas HTML.
- **Spring Data JPA**: Para integração com o banco de dados e operações CRUD.
- **Jakarta Validation (javax.validation)**: Para validações de campos de entrada no DTO.
- **H2 Database (ou outro banco de sua escolha)**: Banco de dados para armazenar as informações dos carros.

## Configuração do Projeto

1. Clone este repositório:

```bash
git clone https://github.com/seu-usuario/crud-carros.git
````
2. Entre no diretório do projeto:
`````bash
cd crud-carros
``````
3. Se necessário, configure as credenciais do banco de dados no arquivo application.properties:   
````bash
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto=update
spring.thymeleaf.prefix=classpath:/templates/
````

4. Compile e execute o projeto
 ````bash
mvn spring-boot:run
````
# Estrutura do Projeto

- **com.spring.crud_carros.controllers**: Controladores que gerenciam as requisições HTTP e interagem com os serviços.
- **com.spring.crud_carros.models**: Contém o DTO `ProdutoDTO` e a entidade `Produto`.
- **com.spring.crud_carros.repositories**: Interface que estende `JpaRepository` para operações de CRUD no banco de dados.
- **com.spring.crud_carros.services**: Contém a lógica de negócios e manipulação de dados.
- **resources/templates**: Contém os templates HTML usados pelo Thymeleaf.

# Como Usar

1. Acesse a página principal onde são listados os carros cadastrados.
2. Clique em "Adicionar Carro" para cadastrar um novo carro, preenchendo os campos obrigatórios.
3. Para editar ou excluir um carro, clique nas opções correspondentes ao lado de cada item na lista.
4. A validação de campos será feita automaticamente, e você será informado se algum campo obrigatório estiver vazio ou inválido.

# Contribuição

1. Faça um fork deste repositório.
2. Crie uma branch para a sua feature:

    ```bash
    git checkout -b feature/nome-da-feature
    ```

3. Faça commit das suas alterações:

    ```bash
    git commit -am 'Adiciona nova feature'
    ```

4. Envie sua branch:

    ```bash
    git push origin feature/nome-da-feature
    ```

5. Abra um Pull Request.

