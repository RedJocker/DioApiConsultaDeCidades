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

- implementação de endpoint GET /states
    - inclusão de dependência hibernate-types
        - ensina hibernate a incluir json no postgres entre outros tipos
    - escrita da entity State
        - relacionamento many to one State -> Country
        - uso da dependência adicionada para transformar json.array de ddd em list
    - escrita do repository StateRepository
    - escrita do service StateService
    - escrita do endpoint GET /states no resource StateResource
        - uso do recurso de paginação

- implementação do endpoint GET /cities
    - mudança no build.gradle
        - mudar o postgres de runtimeOnly para implementation
            - possibilita uso de tipos do postgres
    - escrita da customType PointType
        - vai facilitar o uso dos dados de geolocalização
        - utiliza PgPoint do postgres
    - escrita da entity City
        - fazendo uso da PointType
    - escrita do repository CityRepository
    - escrita do service CityService
    - escrita do endpoint GET /countries no resource CountryResource

- implementação do endpoint GET /cities/{id}
    - adição do novo endpoint no CityResource
    - adição do CityService.findByID()
    - adição da exception CityIdNotFoundException
    - adição da exceptionHandler CityExceptionHandler
    
- implementação dos endpoints GET /distances/by-cube e GET /distances/by-points
    - extensão da CityRepository
        - query findGeolocationById
        - query distanceByCube
        - query distanceByPoints
    - extensão da CityService
        - distanceByPoints
        - distanceByCube
    - escrita do DistanceService
    - escrita do DistanceResource com os novos endpoints

- deploy no heroku
    - addon postgres adicionado no heroku
    - database do heroku populado manualmente pelo console do heroku
    - criado application-heroku.properties
        - cria perfil de produção
        - configura a conexão com o banco de dados do heroku
    - criado Procfile
        - configura a run no heroku para rodar com o perfil de produção
    
    
    