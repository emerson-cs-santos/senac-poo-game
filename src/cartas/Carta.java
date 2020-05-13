package cartas;

import java.util.ArrayList;
import java.util.List;

// Entidade - SUPERCLASSE - Definida como abstrada para impedir de ser instanciada, pois ele s[o tem metodos genericos, sem  regras de negocio
public abstract class Carta 
{
	private String nome;
	private int vida;
	private boolean desviou = false;
	
	private List<Efeito> EfeitosList = new ArrayList<Efeito>();
	
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
	
	public boolean verDesviou()
	{
		return this.desviou;
	}		
	
	public void setarDesvio( boolean desviar)
	{
		this.desviou = desviar;
	}
	
	public void aplicarEfeito(String nome, int dano , int tipo)
	{
		this.EfeitosList.add( new Efeito( nome, dano, tipo ) );
	}
	
	public List<Efeito> getEfeitos()
	{
		return this.EfeitosList;
	}
}
