```markdown
# 🧾 uso-dto

Este projeto foi desenvolvido com o objetivo de praticar boas práticas no uso de **DTOs (Data Transfer Objects)** com **Java + Spring Boot**, evitando o envio direto de entidades JPA para o front-end. Isso ajuda a proteger a estrutura do banco de dados e manter o código mais seguro, limpo e escalável.

## 🚀 Tecnologias utilizadas

- Java 17
- Spring Boot 3
- Spring Data JPA
- Jakarta Validation
- Lombok
- H2 (ou outro banco configurável)
- Maven

## 🛠️ Funcionalidades

- Transações bancárias simuladas:
  - Depósito
  - Saque
- Validação de saldo disponível
- Retorno de dados via DTO
- Conversão entre Entidade e DTO no Service
- Formatação de data e hora
- Uso de Enum para tipos de transação

## 📁 Estrutura do Projeto

```
br.com.api.banco
├── controller
│   └── ContaController.java
├── dto
│   └── ValidarTransacaoDTO.java
├── enums
│   └── TipoTransacao.java
├── model
│   └── Conta.java
├── repository
│   └── ContaRepository.java
├── service
│   └── ContaService.java
```

## 📌 Exemplo de uso

### Requisição POST para `/transacao/deposito`

```json
{
  "nome": "Maria",
  "saldoConta": 1000.00,
  "tipoTransacao": "DEPOSITO",
  "valor": 200.00,
  "horaTransacao": "2025-04-24T10:00:00"
}
```

### Retorno

```json
{
  "nome": "Maria",
  "saldoConta": 1200.00,
  "tipoTransacao": "DEPOSITO",
  "valor": 200.00,
  "horaTransacao": "2025/04/24 10:00:00"
}
```

## 🧪 Como rodar localmente

1. Clone o projeto:
   ```bash
   git clone https://github.com/MSouza27/uso-dto.git
   cd uso-dto
   ```

2. Abra no IntelliJ ou outra IDE com suporte a Maven

3. Configure o `application.properties` para o banco de sua preferência ou use H2 para testes locais

4. Rode a aplicação com:
   ```bash
   mvn spring-boot:run
   ```

5. Teste os endpoints com Postman ou Insomnia.

## 🙋‍♂️ Autor

Feito com dedicação por **Marcelo Souza** 👨‍💻  
📫 Conecte-se comigo no [LinkedIn](www.linkedin.com/in/magno-souza-dos-santos)

---

## 📢 Contribuição

Contribuições são muito bem-vindas! Se você quiser melhorar algo ou sugerir novas práticas, fique à vontade para abrir um PR ou uma issue.

## ⭐ Dê uma estrela

Se este projeto te ajudou, deixe uma ⭐ no repositório para apoiar!

```
