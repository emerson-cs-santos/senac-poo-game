package Jogo;

public class Game 
{
	
	public static void main(String[] args) 
	{
		Jogador player1 = new Jogador("Kaiba");
		Jogador player2 = new Jogador("Yugi");
		
		ControleJogo jogo = new ControleJogo();
		
		int contador = 1;
		
		System.out.println("");
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Statul Inicial:");
		
		while ( jogo.jogoContinua() )
		{			
			//System.out.println("");
			
			System.out.println("Status Jogador 1: " + player1.retornarNome());
			jogo.exibirDeck(1);
			
			System.out.println("");
			
			System.out.println("Status Jogador 2: " + player2.retornarNome());
			jogo.exibirDeck(2);
			
			jogo.controleBatalha(player1, player2);
			
			System.out.println("");
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println("Partida " + contador++ + ":");
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println("");
			
			jogo.quemBatalhouNaPartida();
			System.out.println(jogo.exibirVencedorPartida());
			System.out.println(jogo.exibirAtaque());
			System.out.println(jogo.ExibirDesviou());
			
			System.out.println("");
		}
		
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Statul Final:");
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("");
		
		System.out.println("Status Jogador 1: " + player1.retornarNome());
		jogo.exibirDeck(1);
		
		System.out.println("");
		
		System.out.println("Status Jogador 2: " + player2.retornarNome());
		jogo.exibirDeck(2);		
		
		System.out.println("");
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("--------------------------------------------------------------------------------");
	
		System.out.println( jogo.vencedorJogo(player1, player2) + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	}
}
