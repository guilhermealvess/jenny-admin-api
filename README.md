## Jenny Admin API - WIP

Esta aplicação tem como objetivo prover uma sistema de gerenciamento e controle na administação de uma loja virtual real (Jenny Joias).

Neste Projeto temos a API que provem os dados para as lambdas de rotina e para o aplicativo mobile do usuário.

Neste projeto contemplará toda documentação, desenho da arquitetura e design utilizado.

## Stack

A stack escolhida é composta por:

- Kotlin  com framework Micronaut + GraalVM (native-image) e servidor gRPC.
- Postgres como banco relacional + JPA Hibernate como ORM de acesso + Flyway como ferramenta de migration.
- Cloud Provider utilizamos AWS e alguns serviços como ECS, S3, SQS, Lambda Function e RDS.

- Para as lambdas utilizaremos a linguagem Python com Pandas para manipular CSVs.

- Como interface de usuário utilizaremos Flutter no desenvolvimento de aplicativos mobile hibrídos comunicando com esta API.

## Design

Escolhemos como design o Clean Architecture que flexibiliza a troca de componentes da aplicação sem alteração no core de domínio, onde o futuro de ferramentas a serem utilizadas ainda é bem incerto.
