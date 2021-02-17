Projeto desenvolvido como forma de avaliação técnica para DBC Company.

Para execução:
- É necessário a utilização de alguma IDE, Maven instalado e "annotation processing" ativado.
- Ao abrir o projeto execute a classe AssembleiaDbcApplication.java

Do projeto:

- Informações Técnicas
  - Java 11
  - SpringBoot Framework 2.4.2
  - Maven 3.6.3
  - Banco de dados H2
  - JUnit e Mockito para testes unitários
  - Swagger UI para documentação

- Features implementadas.
  - Cadastrar uma nova pauta
  - Cadastrar uma nova assembléia
  - Cadastrar um novo associado
  - Cadastrar um novo voto
  - Validação de CPF
  - Validação de associado cadastrado na base
  - Buscar um associado por CPF
  - Buscar uma pauta por ID
  
- Serviços
  Ao acessar "http://localhost:8081/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config", terás acesso a todas as features implementadas citadas acima.
  
  Para fazer uma requisição GET ou POST diretamente nos serviços utilizando PostMan:
  - Pautas - http://localhost:8081/v1/api/pautas
  - Assembleias - http://localhost:8081/v1/api/assembleias
  - Associado - http://localhost:8081/v1/api/associados
  - Votos - http://localhost:8081/v1/api/votos
  
  
  
- Fluxo para execução de cadastros
  - Cadastrar uma nova Pauta
  - Cadastrar uma nova assembléia com o id da pauta criada anteriormente
  - Cadastrar um novo associado 
  - Cadastrar um voto com o id do associado e id da assembleia.

  
- Testes unitários
  - Todos os testes unitários estão com 100% de cobertura
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
