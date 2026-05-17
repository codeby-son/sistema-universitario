# Sistema Universitário - Spring Boot

Projeto acadêmico desenvolvido com Spring Boot, Thymeleaf e PostgreSQL para gerenciamento de alunos, matérias e turmas.

---

## Tecnologias Utilizadas

- Eclipse IDE
- Java
- Spring Boot
- Spring Data JPA
- Thymeleaf
- PostgreSQL
- Maven
- HTML/CSS

---

## Funcionalidades

### Alunos
- Cadastro de alunos
- Consulta de aluno por matrícula
- Listagem de alunos cadastrados

### Matérias
- Cadastro de matérias
- Consulta de matérias

### Turmas
- Cadastro de turmas
- Associação entre turma e matéria

### Matrículas
- Matrícula de alunos em turmas
- Lançamento de notas
- Cálculo de média
- Verificação de aprovação

---

## Estrutura do Projeto

```text
src/main/java/com/example/demo
├── controller
├── model
├── repository
└── service
```

# Banco de Dados

O projeto utiliza PostgreSQL.

Configuração no application.properties
spring.datasource.url=jdbc:postgresql://localhost:5432/sistemaUniversitario
spring.datasource.username=postgres
spring.datasource.password=suaSenha

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# Como Executar o Projeto

## 1. Clonar o repositório
git clone https://github.com/seu-usuario/sistema-universitario.git

## 2. Abrir no Eclipse
Importe o projeto como:
- Maven Project

## 3. Criar o banco PostgreSQL
- CREATE DATABASE sistemaUniversitario;

## 4. Configurar o application.properties
Adicione:
- usuário do PostgreSQL
- senha do PostgreSQL

## 5. Executar
Rodar a classe:

- ProjetoUniversidadeApplication
- Rotas do Sistema
- Alunos
- /alunos
- /alunos/salvar
- /alunos/buscar

