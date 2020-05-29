package efeitos;

import java.util.Random;

import Jogo.Tipo;

public abstract class Efeito 
{
	private String nome;
	private int valor;
	private TipoEfeito tipoEfeito;
	private Tipo tipo;
	
	public Efeito ( String nome, int valor , Tipo tipo, TipoEfeito tipoEfeito  )
	{
		this.nome = nome;
		this.valor = valor;
		this.tipo = tipo;
		this.tipoEfeito = tipoEfeito;
	}
	
	public void verEfeito()
	{
		String efeito = "";
		
		// Aumentar ataque
		if ( this.tipoEfeito ==  TipoEfeito.ATAQUE)
		{
			efeito = " - Aumentar ataque em " + this.valor + "\nSendo uma arma do tipo: " + this.tipo;
		}
		
		// Aumentar defesa
		if ( this.tipoEfeito ==  TipoEfeito.DEFESA )
		{
			efeito = " - Aumentar defesa em " + this.valor + "\nSendo uma arma do tipo: " + this.tipo;
		}		
		
		// Random de um dos 2 (ataque e defesa)
		if ( this.tipoEfeito ==  TipoEfeito.RANDOM )
		{
			efeito = " - Aumentar ataque ou defesa em " + this.valor + "\nSendo uma arma do tipo: " + this.tipo;
		}			
		
		System.out.println("Efeito: " + nome + efeito );
	}

	
	public TipoEfeito retornarTipoEfeito()
	{
		TipoEfeito TipoEfeitoRetorno = this.tipoEfeito; 
		
		// Random de um dos 2 (ataque e defesa)
		if ( this.tipoEfeito == TipoEfeito.RANDOM )
		{
			Random rand = new Random(); 
			
			 if ( (rand.nextInt(2) + 1) == 1 )
			 {
				 TipoEfeitoRetorno = TipoEfeito.ATAQUE;
			 }
			 else
			 {
				 TipoEfeitoRetorno = TipoEfeito.DEFESA; 
			 }
		}			
		
		return TipoEfeitoRetorno;
	}
	
	
	public Tipo retornarTipo()
	{
		return this.tipo;
	}	
	
	
	public String retornarNome()
	{
		return this.nome;
	}
	
	
	public int retornarValor()
	{
		return this.valor;
	}

}
