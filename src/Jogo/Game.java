package Jogo;

public class Game 
{
	
	public static void main(String[] args) 
	{
		Jogador Player1 = new Jogador("Kaiba");
		Jogador Player2 = new Jogador("Yugi");
		
		ControleJogo Jogo = new ControleJogo();
		
		int contador = 1;
		
		System.out.println("");
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Statul Inicial:");
		
		while ( Jogo.JogoContinua() )
		{			
			//System.out.println("");
			
			System.out.println("Status Jogador 1: " + Player1.retornarNome());
			Jogo.ExibirDeck(1);
			
			System.out.println("");
			
			System.out.println("Status Jogador 2: " + Player2.retornarNome());
			Jogo.ExibirDeck(2);
			
			Jogo.ControleBatalha(Player1, Player2);
			
			System.out.println("");
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println("Partida " + contador++ + ":");
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println("");
			
			Jogo.QuemBatalhouNaPartida();
			System.out.println(Jogo.ExibirVencedorPartida());
			System.out.println(Jogo.ExibirAtaque());
			System.out.println(Jogo.ExibirDesviou());
			
			System.out.println("");
		}
		
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Statul Final:");
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("");
		
		System.out.println("Status Jogador 1: " + Player1.retornarNome());
		Jogo.ExibirDeck(1);
		
		System.out.println("");
		
		System.out.println("Status Jogador 2: " + Player2.retornarNome());
		Jogo.ExibirDeck(2);		
		
		System.out.println("");
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("--------------------------------------------------------------------------------");
	
		System.out.println( Jogo.VencedorJogo(Player1, Player2) + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	}
}
