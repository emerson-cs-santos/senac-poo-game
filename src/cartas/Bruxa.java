package cartas;

public class Bruxa extends Carta
{
	public Bruxa (String nome, int vida)
	{	
		super(nome,vida);
		
		aplicarEfeito("Espada", 8, 0);
		aplicarEfeito("Escudo", 3, 1);
	}	

}
