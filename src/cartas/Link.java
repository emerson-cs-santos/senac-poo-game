package cartas;

import Jogo.Tipo;

public abstract class Link extends Carta
{
	public Link( String nome, int vida, int ataque, int defesa, Tipo tipo ) 
	{
		super(nome, vida, ataque, defesa, tipo);
	}
}
