package cartas;

import Jogo.Tipo;

public class Espaco extends Link
{
	public Espaco( String nome, int vida, int ataque, int defesa, Tipo tipo ) 
	{
		super(nome, vida, ataque, defesa, tipo);
	}
}
