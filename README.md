# API JWT Token - sboot-token-ministerio-recomeco

## Visão Geral

Esta é uma API JWT Token desenvolvida em Java 20 e Spring Boot 3, que utiliza o MySQL versão 8.0 para autenticação e autorização de usuários. A API oferece dois principais endpoints: `v1/api/ministerio-recomeco/token/login` para autenticação de usuários e `v1/api/ministerio-recomeco/token/register` para registro de novos usuários.

## Requisitos

- Java 20
- Spring Boot 3
- MySQL 8.0
- Maven (Versão Atual)
- Git

## Configuração

Antes de executar a API, é necessário configurar o banco de dados MySQL. Certifique-se de criar um banco de dados e configurar as credenciais no arquivo `application.properties`.

```properties
# src/main/resources/application.properties

# Configurações do Banco de Dados
spring.datasource.url=jdbc:mysql://localhost:3306/seu_banco_de_dados
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```

## Build e Execução

Para construir e executar a API, siga os seguintes passos:

1. Clone o repositório:

```bash
git clone https://github.com/seu-usuario/sboot-token-ministerio-recomeco.git
cd sboot-token-ministerio-recomeco
```

2. Construa o projeto usando o Maven:

```bash
mvn clean install
```

3. Inicie o aplicativo Spring Boot:

```bash
mvn spring-boot:run
```

O aplicativo estará disponível em `http://localhost:8080`.

## Endpoints

### 1. Login

- **URL**: `/v1/api/ministerio-recomeco/token/login`
- **Método HTTP**: POST
- **Descrição**: Autentica um usuário e gera um token JWT.
- **Corpo da Requisição**:

```json
{
  "username": "seu_usuario",
  "password": "sua_senha"
}
```

- **Resposta de Sucesso**:

```json
{
  "token": "seu_token_jwt"
}
```

### 2. Registro

- **URL**: `/v1/api/ministerio-recomeco/token/register`
- **Método HTTP**: POST
- **Descrição**: Registra um novo usuário.
- **Corpo da Requisição**:

```json
{
  "username": "novo_usuario",
  "password": "nova_senha"
}
```

- **Resposta de Sucesso**:

```json
{
  "message": "Usuário registrado com sucesso."
}
```

## Autenticação com JWT

Para acessar endpoints protegidos, inclua o token JWT na cabeçalho da requisição:

```http
Authorization: Bearer seu_token_jwt
```

## Exemplo de Uso

Você pode usar ferramentas como `curl` ou Postman para testar os endpoints da API.

```bash
# Exemplo de login
curl -X POST http://localhost:8080/v1/api/ministerio-recomeco/token/login -d '{"username":"seu_usuario", "password":"sua_senha"}'

# Exemplo de registro
curl -X POST http://localhost:8080/v1/api/ministerio-recomeco/token/register -d '{"username":"novo_usuario", "password":"nova_senha"}' -H "Content-Type: application/json"
```
