package cartas;

public class Esqueleto extends Carta
{
	// Construtor
	public Esqueleto (String nome, int vida)
	{	
		super(nome,vida);
		
		aplicarEfeito("Escudo", 4, 1);
	}		

}
