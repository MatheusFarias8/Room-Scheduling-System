# Room Scheduling System API

API REST para gerenciamento de agendamentos de salas.

Este projeto foi desenvolvido como parte de um **desafio técnico para processo seletivo**, com foco em:

- Organização em camadas bem definidas

- Separação clara de responsabilidades

- Aplicação de regras de negócio reais

- Tratamento consistente de exceções

- Código limpo e manutenível


O objetivo foi demonstrar domínio de arquitetura backend, validações de domínio e boas práticas no ecossistema Java.

---

## 🚀 Tecnologias

- ☕ Spring Boot

- 🛢 H2 Database

- 🔄 MapStruct

- 📦 Maven

---

## 📂 Estrutura do Projeto

```
com.unichristus.room_scheduling_system
│
├── config
├── controllers
├── domain
│   ├── dtos
│   ├── enums
│   └── models
├── exceptions
├── mappers
├── mock
├── repositories
├── services
└── RoomSchedulingSystemApplication
```

### Organização

- **controllers** → Camada de entrada HTTP

- **services** → Centralização das regras de negócio

- **repositories** → Persistência com JPA

- **domain** → Entidades, DTOs e enums

- **mappers** → Conversão automática com MapStruct

- **exceptions** → Tratamento global de erros

- **mock** → Inicialização de dados fixos


A estrutura prioriza legibilidade, manutenção e evolução futura do sistema.

---
## 🛢 Banco de Dados

A aplicação utiliza **H2 em memória**, permitindo execução simples sem dependências externas.

Console disponível em:
```
http://localhost:8080/h2-console
```

---

## 🧪 Mock de Salas

As salas são carregadas automaticamente no startup da aplicação através de um **Mock Loader**, garantindo:

- Ambiente pronto para testes

- Padronização dos dados

- Simulação de cenário real

---

## ⚠️ Tratamento Global de Exceções

A API utiliza um `GlobalExceptionHandler` para padronização das respostas de erro e maior previsibilidade na comunicação com o cliente.

Exceções tratadas incluem:

- SalaIndisponivelException

- DataAgendamentoInvalidaException

- EntidadeNaoEncontradaException

- MethodArgumentNotValidException


---

## 🧠 Regras de Negócio Implementadas

O sistema aplica validações típicas de um cenário corporativo real:

- ❌ Não é permitido agendar em **datas passadas**

- ❌ Não é permitido agendar para período superior a **1 ano no futuro**

- ❌ Não é permitido agendar salas **já ocupadas no mesmo horário**

- ❌ Não é permitido agendar salas com status:

    - INATIVA

    - EM_MANUTENCAO

- ❌ A sala deve existir para que o agendamento seja realizado


Essas regras são centralizadas na camada de serviço, garantindo integridade e previsibilidade do domínio.

---

## 👨‍💻 Autor

Matheus Farias  
Desafio técnico – Backend Java