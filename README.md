# Global Solution 2 - Domain Driven Design - Java

## Integrantes:
- Pedro Henrique Mendes dos Santos (RM555332)
- Kayky Silva Stiliano (RM555148) ;;

# Mental Health API

API REST desenvolvida para registro e acompanhamento de indicadores de saúde mental, como humor diário e histórico emocional de pacientes.
O projeto utiliza Spring Boot, Spring Data JPA, H2 Database, ModelMapper, validação com Jakarta Validation e uma camada estruturada com DTOs, Services, Controllers e Mappers personalizados.

## Resumo da Solução

A solução implementada propõe uma API simples e eficiente para monitoramento diário da saúde mental, permitindo que aplicações clientes (mobile, web ou dashboards) registrem, consultem e analisem informações emocionais de pacientes.

Principais pontos:
- Registro diário de humor (escala de 1 a 5)
- Histórico emocional por paciente
- CRUD completo de pacientes e registros
- Dados iniciais populados via `data.sql`
- Arquitetura organizada e extensível
- Mappers personalizados para evitar problemas comuns de serialização
- Documentação clara e endpoints estruturados

Essa solução pode servir como base para:
- Aplicações de acompanhamento terapêutico
- Sistemas de apoio psicológico
- Projetos acadêmicos
- Dashboards de métricas emocionais

## Tecnologias Utilizadas
- Java 17+
- Spring Boot 3+
- Spring Web
- Spring Data JPA
- H2 Database (modo memória)
- ModelMapper
- Jakarta Validation
- Maven

## Como Executar o Projeto
### 1. Clonar o repositório
```bash
git clone https://github.com/pehenmendes/Global-Solution-2---Domain-Driven-Design---Java
cd mental-health-api
```

### 2. Rodar com Maven
```bash
mvn clean install
mvn spring-boot:run
```

API disponível em: `http://localhost:8080/api`

## Endpoints Principais
### Pacientes
| Método | Endpoint            | Descrição          |
| ------ | ------------------- | ------------------ |
| GET    | /api/pacientes      | Lista todos        |
| GET    | /api/pacientes/{id} | Busca por ID       |
| POST   | /api/pacientes      | Cria novo paciente |
| PUT    | /api/pacientes/{id} | Atualiza paciente  |
| DELETE | /api/pacientes/{id} | Remove paciente    |

---

### Registros Diários
| Método | Endpoint                     | Descrição                      |
| ------ | ---------------------------- | ------------------------------ |
| GET    | /api/registros               | Lista todos                    |
| GET    | /api/registros/{id}          | Busca por ID                   |
| GET    | /api/registros/paciente/{id} | Lista registros de um paciente |
| POST   | /api/registros               | Cria novo registro             |
| PUT    | /api/registros/{id}          | Atualiza registro              |
| DELETE | /api/registros/{id}          | Remove registro                |


## Exemplos de cURL
### 1. PACIENTE — CRUD COMPLETO
#### 1.1 Criar Paciente (POST /api/pacientes)
```bash
curl -X POST http://localhost:8080/api/pacientes \
-H "Content-Type: application/json" \
-d '{
    "nome":"João",
    "email":"joao@example.com",
    "dataNascimento":"1990-05-10"
}'
```

#### 1.2 Listar Todos (GET /api/pacientes)
```bash
curl -X GET http://localhost:8080/api/pacientes
```

#### 1.3 Buscar por ID (GET /api/pacientes/{id})
```bash
curl -X GET http://localhost:8080/api/pacientes/1
```

#### 1.4 Atualizar Paciente (PUT /api/pacientes/{id})
```bash
curl -X PUT http://localhost:8080/api/pacientes/6 \
-H "Content-Type: application/json" \
-d '{
  "nome": "Ricardo M. Moreira",
  "email": "ricardo.m.moreira@example.com",
  "dataNascimento": "1991-06-22"
}'
```

#### 1.5 Deletar Paciente (DELETE /api/pacientes/{id})
```bash
curl -X DELETE http://localhost:8080/api/pacientes/1
```

### 2. REGISTRO DIÁRIO — CRUD COMPLETO

#### 2.1 Criar Registro Diário (POST /api/registros)
```bash
curl -X POST http://localhost:8080/api/registros \
-H "Content-Type: application/json" \
-d '{
  "pacienteId": 6,
  "dataRegistro": "2025-01-05",
  "nivelHumor": 4,
  "observacoes": "Dormiu bem e teve um dia tranquilo."
}'
```

#### 2.2 Listar Todos os Registros (GET /api/registros)
```bash
curl -X GET http://localhost:8080/api/registros
```

#### 2.3 Buscar Registro por ID (GET /api/registros/{id})
```bash
curl -X GET http://localhost:8080/api/registros/3
```

#### 2.4 Atualizar Registro Diário (PUT /api/registros/{id})
```bash
curl -X PUT http://localhost:8080/api/registros/16 \
-H "Content-Type: application/json" \
-d '{
  "pacienteId": 6,
  "dataRegistro": "2025-01-05",
  "nivelHumor": 5,
  "observacoes": "Melhorou muito após uma boa noite de sono."
}'
```

#### 2.5 Deletar Registro Diário (DELETE /api/registros/{id})
```bash
curl -X DELETE http://localhost:8080/api/registros/1
```

### 3. Endpoints adicionais
#### Listar registros por paciente (GET /api/registros/paciente/{pacienteId})
```bash
curl -X GET http://localhost:8080/api/registros/paciente/1
```
