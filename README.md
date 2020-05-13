# senac-poo-game
# Senac 2020 - Sistemas para internet - Programação orientada a objetos
## Jogo de "cartas".

### Como o Jogo funciona
Jogo de cartas para 2 jogadores.


#### Deck e Partidas
	- Cada jogador terá um deck de 3 cartas.
	- É feito uma partida por vez entre 2 cartas de cada jogador.
	- Cada carta tem um nome e quantidade de vida pré-definida.
	- Algumas cartas tem efeitos e habilidades especiais, como aumento de ataque/defesa.

#### Modos de execução
	- Manual: Cada partida é executada apenas quando os jogadores quiserem,
	- Auto: Todas as partidas são executadas de uma vez, ficando apenas os resultados para serem analisados.
	
#### Antes de começar, cada jogador deve
1. Digitar seu nome
2. Escolher suas cartas, existe opção de cartas aleatórias.

#### O Jogo
	- O valor do ataque é aleatório entre 0 e 10.
	- Será exibido o status de cada jogador e suas cartas em cada partida.
	- Também é exibido antes de cada partida os efeitos (se tiver) das cartas que vão participar da partida.


### Como o jogo é estruturado

#### Diagrama de Classe
![Diagrama de Classe](https://github.com/emerson-cs-santos/senac-poo-game/blob/master/src/images/Diagrama_de_classe.png "Diagrama de Classe")
Existe um atributo adicional que é uma lista do tipo efeitos que cada carta pode ter.

#### Diagrama de Sequência
![Diagrama de Sequência](https://github.com/emerson-cs-santos/senac-poo-game/blob/master/src/images/Diagrama%20de%20sequencia.png "Diagrama de Sequência")

#### Pacote Cartas
- Existe uma super classe carta que tem as principais funcionalidades das cartas
- As SubClasses de cartas podem ter algumas particularidades 
- Os efeitos são habilidades que cada carta pode ter uma lista delas, do tipo efeito. Esses efeitos podem aumentar ou diminuir  um ataque.

#### Pacote Jogo
- Jogador - Informações do jogador
- ISkill - Habilidades fixas que são implementadas direto na subClasse.
- Game - Main que faz as principais chamadas
- ControleJogo - A classe mais complexa que tem toda base das regras de negócio e as executa.