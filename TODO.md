## View
### Menu
* [ ] Limpar a tela
* [ ] O sistema deve permitir que o usuário digite na mesma linha, ao lado da pergunta
* [ ] Tratamento de valor numérico (não aceitar string em int)

### Cadastro Veiculo
* [ ] Limpa a tela
* [ ] Tratamento do valor de tipo (precisa ser 1 ou 2)
  * [ ] Moto: Perguntar se tem partida eletrica
  * [ ] Carro: Perguntar número de portas
* [ ] Tratamento de valor numérico (não aceitar string em int)
* [ ] O sistema deve permitir que o usuário digite na mesma linha, ao lado da pergunta
* [ ] Aparecer a mensagem que foi cadastrado com sucesso.
* [ ] Colocar exceção caso retornada pelo service (try-catch).
* [ ] Mensagem de "Pressione enter para continuar", e colocar na:
  * [ ] Adição com sucesso
  * [ ] Depois de exceção

### Listar
* [ ] Chamar o método de listar todos para retornar a frota
* [ ] Ler a coleção de frota
  * [ ] Para cada item usar o toString() para listar os veículos.
  
### Pesquisar por Placa
* [ ] Limpar a tela
* [ ] Perguntar pela placa
* [ ] Tratamento de exceção para caso não existir veículo
  * [ ] Colocar mensagem da exceção.
* [ ] Usar toString() para mostrar o veículo
* [ ] Mensagem de "Pressione enter para continuar"

### Remover por Placa
* [ ] Limpar a tela
* [ ] Deverá mostrar todos os veículos (chamar o método de listar)
* [ ] Pedir ao usuário qual o veículo ele deseja remover
* [ ] Tratamento de exceção para caso não encontrar a placa
* [ ] Mostrar mensagem que foi sucesso.
* [ ] Mensagem de "Pressione enter para continuar"

## Service
### Cadastro Veiculo
* [ ] Verificar campos
  * [X] Numero de portas maior 0
  * [X] Ano maior que 0
  * [ ] Campos String não vazio ou null

### Listar
* [ ] Override nos métodos toString()
  * [ ] Veiculo (vai ser o pai, e o resto vai apenas complementa-la)
    * [ ] Carro
    * [ ] Moto
* [ ] No método, apenas retornar a coleção (frotas)

### Pesquisar por Título
* [ ] Verificar se existe
  * [ ] Caso sim, retornar o veículo
* [ ] Caso não existir, lançar exceção

### Remover
* [ ] Verificar se existe
* [ ] Caso não existir, lançar exceção