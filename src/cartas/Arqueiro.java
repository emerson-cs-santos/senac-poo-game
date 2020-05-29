package cartas;

import Jogo.Tipo;

public class Arqueiro extends Fusao implements IDesviar 
{
	
	// Construtor
	public Arqueiro (String nome, int vida, int ataque, int defesa, Tipo tipo)
	{
		super(nome ,vida, ataque, defesa, tipo);
	}
	
	@Override
	public void receberDano(int dano)
	{
		if (!desviar())
		{
			super.receberDano(dano);
			System.out.println(this.retornarNome() + " Falhou em desviar!");
		}
		else
		{
			System.out.println(this.retornarNome() + " Desviou do ataque! e Portanto não recebeu o dano abaixo!");
		}
	}	
	
	// Método obrigado a implementar por conta da interface
	public boolean desviar() 
	{
		int chance = rand.nextInt(3) + 1;
		
		return chance == 2;
	}
	
}