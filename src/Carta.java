
// Entidade - SUPERCLASSE - Definida como abstrada para impedir de ser instanciada, pois ele s[o tem metodos genericos, sem  regras de negocio
public abstract class Carta 
{
	private String nome;
	private int vida;
	
	// Construtor
	public Carta (String nome, int vida)
	{
		this.nome = nome;
		this.vida = vida;
	}
	
	public String retornarNome()
	{
		return this.nome;
	}
	
	public int retornarVida()
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
