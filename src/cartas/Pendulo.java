package cartas;

import Jogo.Tipo;

public abstract class Pendulo extends Carta
{
	public Pendulo( String nome, int vida, int ataque, int defesa, Tipo tipo ) 
	{
		super(nome, vida, ataque, defesa, tipo);
	}
}
