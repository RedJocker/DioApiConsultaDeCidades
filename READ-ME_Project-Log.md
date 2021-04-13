* Construindo uma API Rest de consulta de cidades do Brasil do zero até a produção

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