package cartas;

import Jogo.Tipo;

public abstract class Xyz extends Carta
{
	public Xyz( String nome, int vida, int ataque, int defesa, Tipo tipo ) 
	{
		super(nome, vida, ataque, defesa, tipo);
	}
}
