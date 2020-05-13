package cartas;

public class Fantasma extends Carta
{
	// Construtor
	public Fantasma (String nome, int vida)
	{
		super(nome,vida);
		
		aplicarEfeito("Diamante", 7, 2);
	}		

}
