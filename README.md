# Global Solution 2 - Domain Driven Design - Java

## Integrantes:
- Pedro Henrique Mendes dos Santos (RM555332)
- Kayky Silva Stiliano (RM555148)

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
### Cria Paciente
```bash
curl -X POST http://localhost:8080/api/pacientes \
-H "Content-Type: application/json" \
-d '{
    "nome":"João",
    "email":"joao@example.com",
    "dataNascimento":"1990-05-10"
}'
```

### Criar Registro Diário
```bash
curl -X POST http://localhost:8080/api/registros \
-H "Content-Type: application/json" \
-d '{
    "pacienteId":1,
    "dataRegistro":"2025-01-01",
    "nivelHumor":4,
    "observacoes":"Dia bom"
}'
```
