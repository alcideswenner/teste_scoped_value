# ScopedValue

Este é um exemplo de aplicação Spring Boot que demonstra o uso da nova feature introduzida no Java 21 chamada `ScopedValue`. Esta versão é uma melhoria em relação ao tradicional `ThreadLocal`, proporcionando uma maneira mais segura e flexível de armazenar valores associados ao escopo de uma determinada execução.

## Sobre o Projeto

Este projeto inclui um controlador (`ScopedValueTeste`) em um aplicativo Spring Boot. O objetivo é obter o endereço IP do cliente de uma solicitação HTTP e armazená-lo usando a classe `ScopedValue`. Esta classe permite que o valor associado a um escopo específico seja acessado em diferentes partes do código sem a necessidade de passar explicitamente o valor como parâmetro.

## Requisitos

- Java 21 ou superior
- Spring Boot (dependências gerenciadas pelo Spring Initializer ou Maven/Gradle)

## Executando o Projeto

1. Clone o repositório ou baixe o código-fonte.
2. Abra o projeto em sua IDE favorita.
3. Execute a aplicação Spring Boot.

## Como Testar

Após iniciar a aplicação, você pode acessar o endpoint `/` através de um navegador ou ferramenta de API. O controlador `ScopedValueTeste` tentará obter o endereço IP do cliente da solicitação HTTP, levando em consideração possíveis cabeçalhos usados por proxies. O endereço IP será então armazenado usando a classe `ScopedValue` e retornado na resposta.

## Observações

Certifique-se de ter o Java 21 ou superior instalado em sua máquina para aproveitar a funcionalidade da `ScopedValue`. Esta melhoria em relação ao `ThreadLocal` proporciona uma abordagem mais segura para armazenar valores em escopos específicos, especialmente em ambientes concorrentes.

## Referências

- [Java 21 Release Notes](https://openjdk.java.net/projects/jdk/21/release-notes#JEP-429)
- [Spring Boot](https://spring.io/projects/spring-boot)

Este projeto é um exemplo didático e pode ser adaptado para cenários específicos ou integrado a projetos existentes. Sinta-se à vontade para explorar e experimentar com a funcionalidade da `ScopedValue` em suas próprias aplicações Java.
