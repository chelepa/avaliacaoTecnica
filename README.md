# Installation

Para a inicialização da aplicação e necessario realizar algumas configurações

1. #### Clonar este repositorio

2. #### Banco de Dados MySql

    Subir uma banco local Mysql, se preferir no projeto existe um docker.yml de uma imagem MySql
    
    ```bash
    docker-compose up -d
    ```
    
    Após subir o banco de dados validar a porta, usuario, senha do banco e editar no arquivo **application.yml**
    
    ***OBS***: Não é necessario realizar a criação do banco e nem das tabelas pois foi adicionado no projeto uma biblioteca
    chamada **flyway** que é responsavel pelo versionamento do banco de dados.

# URLs Importantes

1. ####[Swagger](http://localhost:8080/swagger-ui/index.html#/)
    ```
     Por padrão a aplicação esta subindo na porta 8080 por esse motivo todas as URL do 
       Swagger estaram setadas na porta citada acima.
    ```
2. ####[Actuator](http://localhost:8080/actuator)

   1. ####[Flyway Migration](http://localhost:8080/actuator/flyway) todas as migration executadas com status
   2. ####[Actuator health](http://localhost:8080/actuator/health) responsavel por mostrar o status da aplicação


# Exemplo

### Associado [CRUD]
   1. Cadastro de Novo Associado:
      ```
      /V1/associate ['POST']
      {
         "cpf": "03300121000",
         "name": "Claudimir Chelepa"
      }
      ```
   2. Buscar Todos os Associado Cadastrados na aplicação:
      ```
      /v1/associate ['GET']
      ```
   3. Buscar o Associado Cadastrados pelo CPF:
      ```
      /v1/associate/{CPF} ['GET']
      ```
   4. Remover o Associado Cadastrados pelo CPF:
      ```
      /v1/associate/{CPF} ['DELETE']
      ```
   5. Atualizar o Associado Cadastrados pelo CPF:
      ```
      /v1/associate/{CPF} ['PATCH']
      {
        "name": "string"
      }
      ```
   6. Buscar os Votos pelo CPF do Associado:
      ```
      End Point Responsavel por buscar todos os votos ja contabilizados nas Pautas assim como 
      o id da Pauta
      ```
      ```
      /v1/associate/vote/{CPF} ['GET']
      ```
### Guidelines [CRUD]
  1. Cadastro de uma Nova Pauta:
     ```
     Nesse End Point das tres informações solicitadas no POST somente duas são obrigatorias
     o campo chamado 'runtime' podera ser passado com algum valor ou podera não existir nesse payload
     com isso se esse campo em especifico não for passado o sistema ira setar a pauta com duração de 
     um minuto
     ```
     ```
     /V1/guidelines ['POST']
     {
       "name": "string",
       "description": "string",
       "runtime": 0
     }
     ```
  2. Buscar todas as Pautas cadastradas:
     ```
     /V1/guidelines ['GET']
     ```
  3. Buscar as Pautas cadastradas por id:
     ```
     /V1/guidelines/{id} ['GET']
     ```
  4. Remover a Pauta Cadastrada pelo Id:
     ```
     Para realizar a remoção dessa pauta so sera possivel se a pauta esta com status de criação
     ```
     ```
     /V1/guidelines/{id} ['DELETE']
     ```
  5. Atualizar a Pauta cadsatrada pelo Id:
     ```
        Para realizar a atualização de uma pauta so podera ser alterado os campos, name, description 
     e runtime, mas so é possivel atualizar se a mesma não estiver com status de execução e nem status 
     de enceramento.
     ```
     ```
     /V1/guidelines/{id} ['PATCH']
     {
        "name": "string",
        "description": "string",
        "runtime": 0
     }
     ```
  6. Inicializar Uma Pauta cadsatrada pelo Id:
     ```
     End Point Responsavel pela inicialização da Pauta com esse end Point sera cadastrada a start_date e
     end_date da pauta, apartir desse ponto o scheduler vai ficar monitorando para quando a data de
     expiração for inferior a data atual setar a status de encerado e contabilizar os votos
     ```
     ```
     /V1/guidelines/start/{id} ['POST']
     ```
### Voting
  1. Cadastro de votos:
     ```
        End Point responsavel pelo cadastro do voto, passando o cof do associado e o id da Pauta, o voto
     devera ser somente Sim ou Não caso for outro voto ira retornar um erro
     ```
     ```
     /V1/voting/{cpf}/{id} ['POST']
     
     {
        "vote": "string"
     }
     ```