package cartas;

import java.util.Random;

public class Efeito 
{
	private String nome;
	private int dano;
	private int tipo;
	
	// Tipos
		// 0 = Aumentar ataque
		// 1 = Aumentar defesa
		// 2 = Random um dos 2 acima
	
	public Efeito ( String nome, int dano , int tipo  )
	{
		this.nome = nome;
		this.dano = dano;
		this.tipo = tipo;
	}
	
	public void verEfeito()
	{
		String efeito = "";
		
		// Aumentar ataque
		if ( tipo == 0 )
		{
			efeito = " - Aumentar ataque em " + dano;
		}
		
		// Aumentar defesa
		if ( tipo == 1 )
		{
			efeito = " - Aumentar defesa em " + dano;
		}		
		
		// Random de um dos 2 (ataque e defesa)
		if ( tipo == 2 )
		{
			efeito = " - Aumentar ataque ou defesa em " + dano;
		}			
		
		System.out.println("Efeito: " + nome + efeito );
	}
	
	public int aplicarEfeito(int ataque, boolean atacar)
	{
		// Random de um dos 2 (ataque e defesa)
		if ( this.tipo == 2 )
		{
			Random rand = new Random(); 
			
			 if ( (rand.nextInt(2) + 1) == 1 )
			 {
				 this.tipo = 0;
			 }
			 else
			 {
				 this.tipo = 1; 
			 }
		}		
		
		// Aumentar ataque
		if ( this.tipo == 0 && atacar == true )
		{
			ataque = ataque + this.dano;
		}
		
		// Aumentar defesa
		if ( this.tipo == 1 && atacar == false )
		{
			if (ataque > this.dano)
			{
				ataque = ataque - this.dano;
			}
			else
			{
				ataque = 0;
			}
		
		}
		return ataque;
	}

}
