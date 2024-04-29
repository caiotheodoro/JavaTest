## ALUNO: CAIO EDUARDO THEODORO DA SILVA
## RA: 2044560


## Identificando as partições de equivalência

### MCDC LEFTPAD

#### TRUTH TABLE

|str==null|padStr==null or padStr.isEmpty()|padSize <= 0|padSize == padStr.length()                   |padSize < padStr.length()|
|---------|--------------------------------|------------|---------------------------------------------|-------------------------|
|V        |V                               |V           |V                                            |V                        |
|V        |V                               |V           |V                                            |F                        |
|V        |V                               |V           |F                                            |V                        |
|V        |V                               |V           |F                                            |F                        |
|V        |V                               |F           |V                                            |V                        |
|V        |V                               |F           |V                                            |F                        |
|V        |V                               |F           |F                                            |V                        |
|V        |V                               |F           |F                                            |F                        |
|V        |F                               |V           |V                                            |V                        |
|V        |F                               |V           |V                                            |F                        |
|V        |F                               |V           |F                                            |V                        |
|V        |F                               |V           |F                                            |F                        |
|V        |F                               |F           |V                                            |V                        |
|V        |F                               |F           |V                                            |F                        |
|V        |F                               |F           |F                                            |V                        |
|V        |F                               |F           |F                                            |F                        |
|F        |V                               |V           |V                                            |V                        |
|F        |V                               |V           |V                                            |F                        |
|F        |V                               |V           |F                                            |V                        |
|F        |V                               |V           |F                                            |F                        |
|F        |V                               |F           |V                                            |V                        |
|F        |V                               |F           |V                                            |F                        |
|F        |V                               |F           |F                                            |V                        |
|F        |V                               |F           |F                                            |F                        |
|F        |F                               |V           |V                                            |V                        |
|F        |F                               |V           |V                                            |F                        |
|F        |F                               |V           |F                                            |V                        |
|F        |F                               |V           |F                                            |F                        |
|F        |F                               |F           |V                                            |V                        |
|F        |F                               |F           |V                                            |F                        |
|F        |F                               |F           |F                                            |V                        |
|F        |F                               |F           |F                                            |F                        |


### Testes derivados

- str é nulo
- padStr é nulo ou "" (vazio)
- padSize é 0 ou menor que  0
- padSize é igual ao tamanho de padStr
- padSize é menor que o tamanho de padStr
- padSize é maior que o tamanho de padStr


### Partições de equivalência

#### Partição 1: INVALIDA (INFERIOR)
- padSize é 0 ou menor que  0
- str é nulo

#### Partição 2: INVALIDA (SUPERIOR)
- padStr é nulo ou "" (vazio)
- padSize é maior que o tamanho de padStr

#### Partição 3: VALIDA
- padStr é nulo ou "" (vazio)
- padSize é igual ao tamanho de padStr
- padSize é menor que o tamanho de padStr



### Identificando valores limites

Limites próximos para teste em valores limites:

- str é nulo
- padStr é nulo
- padSize é -1
- padSize é 0
- padSize é 1
- padSize é um menor que o tamanho de padStr
- padSize é igual ao tamanho de padStr
- padSize é 1 maior que o tamanho de padStr
- padSize é 2 maior que o tamanho de padStr


### Derivando casos de teste


Idealmente, combinaríamos todas as partições que criamos para cada uma das entradas: 2 x 2 x 3 = 12 casos de teste. No entanto, podemos reduzir isso, pois algumas combinações podem ser agrupadas.

#### Partição inválida 

- padStr é nulo ou "" (vazio)
- padSize é maior que o tamanho de padStr
- padSize é -1

#### Partição válida

- padSize é 0
- padSize é 1
- str é nulo
- padStr é nulo ou "" (vazio)
- padSize é igual ao tamanho de padStr
- padSize é um menor que o tamanho de padStr
- padSize é 1 maior que o tamanho de padStr
- padSize é 2 maior que o tamanho de padStr
- padSize é igual ao tamanho de padStr


Temos 27 casos, contando com os limites. Para simplificar, podemos reduzir isso para 10 casos de teste.


#### Partição inválida 

- padStr é nulo ou "" (vazio)
- padSize é maior que o tamanho de padStr
- padSize é -1

#### Partição válida

- padSize é 0
- padSize é 1
- str é nulo
- padStr é nulo ou "" (vazio)
- padSize é igual ao tamanho de padStr
- padSize é um menor que o tamanho de padStr


Temos então 18 casos de teste, contando com os limites.

### Automatizando os testes

Para a implementação foram feitos os casos isolados, uma função para geração de listas aleatórias, e um test para os casos válidos.