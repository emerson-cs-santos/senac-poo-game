# senac-poo-game
# Senac 2020 - Sistemas para internet - Programa��o orientada a objetos
## Jogo de "cartas".

### Como o Jogo funciona
Jogo de cartas para 2 jogadores.


#### Deck e Partidas
	- Cada jogador ter� um deck de 3 cartas.
	- � feito uma partida por vez entre 2 cartas de cada jogador.
	- Cada carta tem um nome e quantidade de vida pr�-definida.
	- Algumas cartas tem efeitos e habilidades especiais, como aumento de ataque/defesa.

#### Modos de execu��o
	- Manual: Cada partida � executada apenas quando os jogadores quiserem,
	- Auto: Todas as partidas s�o executadas de uma vez, ficando apenas os resultados para serem analisados.
	
#### Antes de come�ar, cada jogador deve
1. Digitar seu nome
2. Escolher suas cartas, existe op��o de cartas aleat�rias.

#### O Jogo
	- O valor do ataque � aleat�rio entre 0 e 10.
	- Ser� exibido o status de cada jogador e suas cartas em cada partida.
	- Tamb�m � exibido antes de cada partida os efeitos (se tiver) das cartas que v�o participar da partida.


### Como o jogo � estruturado

#### Diagrama de Classe
![Diagrama de Classe](https://github.com/emerson-cs-santos/senac-poo-game/blob/master/src/images/Diagrama_de_classe.png "Diagrama de Classe")
Existe um atributo adicional que � uma lista do tipo efeitos que cada carta pode ter.

#### Diagrama de Sequ�ncia
![Diagrama de Sequ�ncia](https://github.com/emerson-cs-santos/senac-poo-game/blob/master/src/images/Diagrama%20de%20sequencia.png "Diagrama de Sequ�ncia")

#### Pacote Cartas
- Existe uma super classe carta que tem as principais funcionalidades das cartas
- As SubClasses de cartas podem ter algumas particularidades 
- Os efeitos s�o habilidades que cada carta pode ter uma lista delas, do tipo efeito. Esses efeitos podem aumentar ou diminuir  um ataque.

#### Pacote Jogo
- Jogador - Informa��es do jogador
- ISkill - Habilidades fixas que s�o implementadas direto na subClasse.
- Game - Main que faz as principais chamadas
- ControleJogo - A classe mais complexa que tem toda base das regras de neg�cio e as executa.