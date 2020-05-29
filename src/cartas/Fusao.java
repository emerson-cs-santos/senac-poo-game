package cartas;

import Jogo.Tipo;

public abstract class Fusao extends Carta
{
	public Fusao( String nome, int vida, int ataque, int defesa, Tipo tipo ) 
	{
		super(nome, vida, ataque, defesa, tipo);
	}
}
