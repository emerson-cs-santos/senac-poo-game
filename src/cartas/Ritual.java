package cartas;

import Jogo.Tipo;

public abstract class Ritual extends Carta implements ICurse 
{
	private int curseValor;
	
	public Ritual(String nome, int vida, int ataque, int defesa, Tipo tipo, int curseValor) 
	{
		super(nome, vida, ataque, defesa, tipo);
		this.curseValor = curseValor;
	}
	
	@Override
	public int retornarAtaque()
	{
		if (!aplicarCurse())
		{
			System.out.println(this.retornarNome() + " Não foi afetado pela Maldição de Ritual!");
			return super.retornarAtaque();
			
		}
		else
		{
			System.out.println(this.retornarNome() + ", seu ataque foi afetado pela Maldição de Ritual!");
			int novoAtaque = super.retornarAtaque();
			 
			if ( (novoAtaque - this.curseValor) < 0 )
			{
				novoAtaque = 0;
			}
			else
			{
				novoAtaque = novoAtaque - this.curseValor;
			}
			 
			 return novoAtaque;
		}
	}		
	
	
	public boolean aplicarCurse() 
	{
		int chance = rand.nextInt(5) + 1;

		return chance == 2;
	}
	
	@Override
	public String retornarStatus()
	{
		return super.retornarStatus() + "\nValor da Maldição por ser Ritual que pode afetar o seu ataque: " + this.curseValor;
	}		
}
