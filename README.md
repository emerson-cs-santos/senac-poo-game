# senac-poo-game
# Senac 2020 - Sistemas para internet - Programa��o orientada a objetos
## Jogo de "cartas".

Jogo de cartas para 2 jogadores.

### Deck
	- Cada jogador ter� um deck de 23 cartas.
		- 5 Combatentes
		- 6 Armas
		- 6 Armaduras
		- 6 Joias
	- Cada carta tem um nome, quantidade de vida, ataque e defesa pr�-definida.
	- Algumas cartas t�m efeitos e habilidades especiais, como aumento de ataque/defesa.
	- Armas aumentam o ataque
	- Armadura aumenta a defesa
	- Joia pode aumentar o ataque ou a defesa, isso � decidido de forma aleat�ria em cada ataque/defesa.
	

### Antes de come�ar, cada jogador deve
1. Digitar seu nome
2. Escolher os equipamentos de suas cartas.

### Como o Jogo funciona
	- Cada jogador escolha 1 carta por partida para batalhar, a carta que ficar sem vida � removida do deck, ent�o � feito outra partida
	- Quando todas as cartas de um jogador ficarem em vida, o outro vence.
	- O valor do ataque � aleat�rio entre 0 e 20.
	- O valor da Defesa � aleat�rio entre 0 e 10.
	- Ser� exibido o status da carta em cada partida.
	- Tamb�m � exibido antes de cada partida os efeitos (se tiver) das cartas que v�o participar da partida.


### Como o jogo � estruturado

#### Diagrama de Classe
![Diagrama de Classe](https://github.com/emerson-cs-santos/senac-poo-game/blob/master/src/images/Diagrama_de_classe.png "Diagrama de Classe")
Existe um atributo adicional na classe de Carta que � uma lista do tipo efeitos que cada carta pode ter.

#### Diagrama de Sequ�ncia
![Diagrama de Sequ�ncia](https://github.com/emerson-cs-santos/senac-poo-game/blob/master/src/images/Diagrama%20de%20sequencia.png "Diagrama de Sequ�ncia")

#### Pacote Cartas
- Existe uma super classe carta que tem as principais funcionalidades das cartas
- T�m outras 5 Super classes que herdam dessa Super classe carta, algumas delas t�m efeitos pr�prios
- As SubClasses (que herdam das 5) de cartas podem ter algumas particularidades 

#### Pacote Efeitos
- S�o os equipamentos: Armas, Armaduras e Joia.
 

#### Pacote Jogo
- Jogador - Informa��es do jogador
- ISkill - Habilidades fixas que s�o implementadas direto na subClasse.
- Game - Main que faz as principais chamadas
- ControleJogo - A classe mais complexa que tem toda base das regras de neg�cio e as executa.

#### Tipos
	As cartas e equipamentos tem tipos, algo que pode influenciar na batalha:
	- Um ataque de uma carta de um tipo contra outra do mesmo tipo, tem esse ataque reduzido.
	- As cartas tamb�m t�m fraquezas contras certos tipos.
	- Os efeitos/equipamentos tem um subTipo: Ataque, Defesa ou Random.
		- Um efeito subTipo ataque s� vai ser considerado quando a carta estiver atacando
		- J� um efeito subtipo defesa s� entra em a��o se a carta estiver se defendendo
		- O subtipo random muda para ataque ou defesa a cada vez que � feito um ataque/defesa	