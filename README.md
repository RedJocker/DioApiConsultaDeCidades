<h1> Construindo uma API Rest de consulta de cidades do Brasil do zero até a produção </h1>

Neste projeto foi desenvolvido uma API Rest que faz consulta a um banco de dados com informações sobre países do globo e
de estados e cidades do Brasil.  
É possível também realizar o cálculo da distância entre duas cidades tanto em milhas quanto em metros.  


O projeto foi ao final deployado no heroku com o seguinte link:

https://dio-consulta-de-cidades.herokuapp.com

e possui os seguintes endpoints:

    - GET /countries
        - lista paginada de todos os países
        - parâmetros aceitos 
            - size (tamanho da página)
            - page (página requisitada)
            - sort (ordenar pelo parametro requisitado)
        - ex: 
            - https://dio-consulta-de-cidades.herokuapp.com/countries?size=10&page=2&sort=name,asc
            
    - GET /countries/{id}
        - retorna informações do país com o número de id informado 
        - ex:
            - https://dio-consulta-de-cidades.herokuapp.com/countries/2
    
    - GET /states
        - lista paginada de todos os estados
        - parâmetros aceitos 
            - size (tamanho da página)
            - page (página requisitada)
            - sort (ordenar pelo parâmetro requisitado)
        - ex: 
            - https://dio-consulta-de-cidades.herokuapp.com/states?size=5&page=2&sort=uf,desc
                
    - GET /cities
        - lista paginada de todos as cidades
            - parâmetros aceitos 
                - size (tamanho da página)
                - page (página requisitada)
                - sort (ordenar pelo parâmetro requisitado)
            - ex: 
                - https://dio-consulta-de-cidades.herokuapp.com/cities?size=50&page=30&sort=id,asc
                
    - GET /cities/{id}
        - retorna informações da cidade com o número de id informado 
            - ex:
                - https://dio-consulta-de-cidades.herokuapp.com/cities/420
    
    - GET /distances/by-points
        - retorna distância em milhas entre duas cidades
            - parâmetros necessários
                - from (id da cidade de partida)
                - to (id da cidade de chegada)
        - ex: 
            - https://dio-consulta-de-cidades.herokuapp.com/distances/by-points?from=50&to=1000
    
    - GET /distances/by-cube
            - retorna distância em metros entre duas cidades
                - parâmetros necessários
                    - from (id da cidade de partida)
                    - to (id da cidade de chegada)
            - ex: 
                - https://dio-consulta-de-cidades.herokuapp.com/distances/by-cube?from=50&to=1000
            
    
    
As informações do passo a passo da construção do projeto se encontram no READ-ME_Project-Log.md.   
As informações do arquivo citado estão em sintonia com o log de commits e trazem mais detalhes para estes