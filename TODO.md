## View
### Menu
* [x] Limpar a tela
* [x] O sistema deve permitir que o usuário digite na mesma linha, ao lado da pergunta
* [x] Tratamento de valor numérico (não aceitar string em int)

### Cadastro Veiculo
* [x] Limpa a tela
* [x] Tratamento do valor de tipo (precisa ser 1 ou 2)
  * [x] Moto: Perguntar se tem partida elétrica
    * [x] Caso foi 1, vai ser adicionado true, e 2 será false
  * [x] Carro: Perguntar número de portas
* [x] Tratamento de valor numérico (não aceitar string em int)
* [x] O sistema deve permitir que o usuário digite na mesma linha, ao lado da pergunta
* [x] Aparecer a mensagem que foi cadastrado com sucesso.
* [x] Colocar exceção caso retornada pelo service (try-catch).
* [x] Mensagem de "Pressione enter para continuar", e colocar na:
  * [x] Adição com sucesso
  * [x] Depois de exceção

### Listar
* [X] Chamar o método de listar todos para retornar a frota
* [X] Ler a coleção de frota
  * [X] Para cada item usar o toString() para listar os veículos.
  
### Pesquisar por Placa
* [x] Limpar a tela
* [X] Perguntar pela placa
* [X] Tratamento de exceção para caso não existir veículo
  * [X] Colocar mensagem da exceção.
* [X] Usar toString() para mostrar o veículo
* [X] Mensagem de "Pressione enter para continuar"

### Remover por Placa
* [X] Limpar a tela
* [X] Deverá mostrar todos os veículos (chamar o método de listar)
* [X] Pedir ao usuário qual o veículo ele deseja remover
* [X] Tratamento de exceção para caso não encontrar a placa
* [X] Mostrar mensagem que foi sucesso.
* [X] Mensagem de "Pressione enter para continuar"

## Service
### Cadastro Veiculo
* [X] Verificar campos
  * [X] Numero de portas maior 0
  * [X] Ano maior que 0
  * [X] Campos String não vazio ou null

### Listar
* [X] Override nos métodos toString()
  * [X] Veiculo (vai ser o pai, e o resto vai apenas complementa-la)
    * [X] Carro
    * [X] Moto
* [X] No método, apenas retornar a coleção (frotas)

### Pesquisar por Placa
* [X] Verificar se existe
  * [X] Caso sim, retornar o veículo
* [X] Caso não existir, lançar exceção

### Remover
* [X] Verificar se existe
* [X] Caso não existir, lançar exceção
