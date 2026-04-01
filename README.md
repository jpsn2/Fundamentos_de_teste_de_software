# Testes Automatizados – Scholarship Eligibility Evaluator

## Descrição

Este projeto tem como objetivo aplicar conceitos de testes de software por meio da criação de uma suíte de testes automatizados para o sistema *Scholarship Eligibility Evaluator*.

O sistema avalia se um candidato está apto a receber uma bolsa, podendo retornar os seguintes resultados:

* APPROVED
* REJECTED
* MANUAL_REVIEW

---

## Tecnologias utilizadas

* Java
* JUnit
* Maven

---

## Como executar os testes

### Opção 1 – Usando Maven (requer Maven instalado)

Na raiz do projeto, execute:

```
mvn test
```

---

### Opção 2 – Usando Maven Wrapper (não precisa instalar Maven)

No Windows:

```
.\mvnw test
```

No Linux/Mac:

```
./mvnw test
```

---

## Estrutura dos testes

A suíte de testes cobre diferentes cenários do sistema, incluindo:

* Casos de aprovação (APPROVED)
* Casos de rejeição (REJECTED) com diferentes motivos
* Casos de revisão manual (MANUAL_REVIEW)
* Entradas inválidas
* Valores de limite

Os testes foram desenvolvidos utilizando técnicas funcionais e estruturais, buscando validar tanto o comportamento esperado quanto diferentes caminhos do código.

---

## Observações

* Os testes podem ser executados diretamente pela linha de comando ou pela IDE (como IntelliJ).
* O foco do projeto é a validação do sistema por meio de testes, sem alteração da lógica original.
