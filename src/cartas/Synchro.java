package cartas;

import Jogo.Tipo;

public abstract class Synchro extends Carta
{
	public Synchro( String nome, int vida, int ataque, int defesa, Tipo tipo )   
	{
		super(nome, vida, ataque, defesa, tipo);
	}
}
