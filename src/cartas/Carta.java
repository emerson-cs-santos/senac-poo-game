package cartas;

import java.util.ArrayList;
import java.util.List;

import Jogo.Tipo;
import efeitos.Efeito;

// Entidade - SUPERCLASSE - Definida como abstrada para impedir de ser instanciada, pois ele s[o tem metodos genericos, sem  regras de negocio
public abstract class Carta 
{
	private String nome;
	private int vida;
	private int ataque;
	private int defesa;
	private Tipo tipo;
	
	private List<Efeito> efeitosList = new ArrayList<Efeito>();
	
	// Construtor
	public Carta (String nome, int vida, int ataque ,int defesa, Tipo tipo)
	{
		this.nome = nome;
		this.vida = vida;
		this.ataque = ataque;
		this.defesa = defesa;
		this.tipo = tipo;
	}
	
	public String retornarNome()
	{
		return this.nome;
	}
	
	
	public int retornarVida()
	{
		return this.vida;
	}
	
	
	public int retornarAtaque()
	{
		return this.ataque;
	}
	
	
	public int retornarDefesa()
	{
		return this.defesa;
	}
	
	
	public Tipo retornarTipo()
	{
		return this.tipo;
	}
	
	
	public List<Efeito> retornarListaEfeitos()
	{
		return this.efeitosList;
	}	
	
	
	public String retornarStatus()
	{
		return "Status: \nNome: " + this.nome + ", Vida: " + this.vida + ", Ataque: " + this.ataque + ", Defesa: " + this.defesa + ", Tipo: " + this.tipo + ", Fraqueza: " + this.tipo.fraqueza;
	}
	
	public String retornarDesc()
	{
		return "Vida: " + this.vida + ", Ataque: " + this.ataque + ", Defesa: " + this.defesa + ", Tipo: " + this.tipo + ", Fraqueza: " + this.tipo.fraqueza;
	}
	
	
	public void verEfeitos()
	{
		List<Efeito> efeitos = this.retornarListaEfeitos();
		
		for(Efeito Efeito: efeitos)
	    {
			Efeito.verEfeito();
	    }		
	}	
	
	
	public void receberDano(int dano)
	{
		this.vida = this.vida - dano;
	}
	
	
	public void guardarEfeito(Efeito efeitoNovo)
	{
		this.efeitosList.add( efeitoNovo );
	}
}
