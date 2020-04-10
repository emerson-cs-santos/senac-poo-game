package cartas;
import Jogo.ISkill;

// Entidade - SUBCLASSE
public class Arqueiro extends Carta implements ISkill 
{
	
	// Construtor
	public Arqueiro (String nome, int vida)
	{
		super(nome,vida);
	}
	
	@Override
	public void receberDano(int dano)
	{
		if (!desviar())
		{
			super.receberDano(dano);
			super.SetarDesvio(false);
		}
		else
		{
			super.SetarDesvio(true);
		}
	}	
	
//	@Override
//	public boolean desviar() {
//		return ISkill.super.desviar();
//	}	
	
}