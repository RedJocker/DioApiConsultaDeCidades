<h1> Construindo uma API Rest de consulta de cidades do Brasil do zero até a produção </h1>

- passos iniciais:
    - projeto iniciado no spring initializer com SpringWeb, SpringJpaData e PostgreSqlDriver
    - escrito docker-compose para facilitar o uso do postgres containerizado
    - escrito init-database.sh para facilitar inicialização dos dados no postgres
    - init-database executado para popular o database
    - escrito system.properties para futuramente avisar heroku sobre o uso do java11

- implementação do endpoint GET /countries (countries.resources.CountryResource.countries())
    - escrita da entity Country
    - escrita do repository CountryRepository
    - escrita do service CountryService
    - escrita do endpoint GET /countries no resource CountryResource
    
- mudança do endpoint GET /countries para retornar conteúdo paginado
    - mudança no CountryResource.countries() e mudança respectiva no CountryService
    - adição de propriedades no application.properties para ativar modo verboso da consulta no sql
        - spring.jpa.show-sql=true
        - spring.jpa.properties.hibernate.format_sql=true
        
- implementação do endpoint GET /countries/{id} (countries.resources.CountryResource.getOne())
    - adição do novo endpoint no CountryResource
    - adição do CountryService.findByID()
    - adição da exception CountryIdNotFoundException
    - adição da exceptionHandler CountryExceptionHandler