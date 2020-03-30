public class Game 
{
	
	public static void main(String[] args) 
	{
		
		int contador = 0;
		String defesaCarta1 = "";
		
		Dragao Carta1 = new Dragao("Blue-eyes",30);
		defesaCarta1 = Carta1.VerDefesa();
		
		Arqueiro Carta2 = new Arqueiro("Legolas",10);
		
		ControleJogo Jogo = new ControleJogo();
		
		System.out.println("Status Inicial:");
		System.out.println("Carta 1");
		System.out.println(Carta1.retornarStatus());
		
		System.out.println("");
		
		System.out.println("Carta 2");
		System.out.println(Carta2.retornarStatus());		
		
		while (Carta1.retornarVida() > 0 && Carta2.retornarVida() > 0)
		{

			System.out.println("");
			System.out.println("--------------------------------------------------------------------------------");
			
			contador++;
			System.out.println("Partida " + contador + ":");
			
			Jogo.Batalhar(Carta1, Carta2);
			
			System.out.println("");
			
			System.out.println("Status atual:");
			System.out.println("Carta 1");
			System.out.println(defesaCarta1);
			System.out.println(Carta1.retornarStatus());
			
			System.out.println("");
			
			System.out.println("Carta 2");
			System.out.println(Carta2.retornarStatus());	
			
			System.out.println("");
			
			System.out.println(Jogo.ExibirVencedorPartida());
			System.out.println(Jogo.ExibirAtaque());
			System.out.println(Jogo.ExibirDesviou());
		}
		
		System.out.println("");
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println(Jogo.ExibirVencedorJogo(Carta1, Carta2) + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		
	}
}
