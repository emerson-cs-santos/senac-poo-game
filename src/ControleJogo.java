// Serviço - SUBCLASSE
import java.util.Random; 

public class ControleJogo 
{
	
	private String vencedor;
	private int ataque;
	
	Random rand = new Random(); 
	
	// Construtor
	public ControleJogo ()
	{
		this.vencedor = "";
	}
	
	public void Batalhar (Carta C1, Carta C2)
	{
		SortearAtaque();
		
		int atacante = DecidirIniciativa();
		
		if (atacante == 1)
		{
			C2.receberDano(ataque);
			this.vencedor = C1.retornarNome();
		}
		else
		{
			C1.receberDano(ataque);
			this.vencedor = C2.retornarNome();
		}
	}
	
	private int DecidirIniciativa()
	{
		
		// Fazer ramdom entre 2 (função está retornando de 0 até 1)
		// Se ramdom retornar 0, será somado com 1, sorteando assim o numero 1
		// Se ramdom retornar 1, será somado com 1, sorteando assim o numero 2
		
		return rand.nextInt(2) + 1;
		
	}	
	
	private void SortearAtaque()
	{
		// De 0 até 10
		this.ataque = rand.nextInt(10);		
	}
	
	public String ExibirVencedorPartida()
	{
		return "Vencedor da partida: " + this.vencedor;
		
	}
	
	public String ExibirAtaque()
	{
		return "Valor do Ataque: " + this.ataque;
		
	}	
	
	public String ExibirVencedorJogo(Carta C1, Carta C2)
	{
		
		String vencedorJogo = "";
		
		if(C1.retornarVida() <= 0)
		{
			vencedorJogo = C2.retornarNome();
		}
		else if (C2.retornarVida() <= 0)
		{
			vencedorJogo = C1.retornarNome();
		}
		else if(C1.retornarVida() == 0 && C2.retornarVida() == 0)
		{
			vencedorJogo = "Empate!";
		}
		else
		{
			vencedorJogo = "Jogo ainda não terminou...";
		}
			
		return "Vencedor do Jogo: " + vencedorJogo;
		
	}	

}
