
// Entidade - SUPERCLASSE
public class Carta 
{
	private String nome;
	private int vida;
	
	// contrutor
	public Carta (String nome, int vida)
	{
		this.nome = nome;
		this.vida = vida;
	}
	
	public String retornaNome()
	{
		return this.nome;
	}
	
	public int retornaVida()
	{
		return this.vida;
	}
	
	public void receberDano(int dano)
	{
		this.vida = this.vida - dano;
	}
	
	public String retornarStatus()
	{
		return "Nome: " + this.nome + ", Vida: " + this.vida;
		
	}
}
