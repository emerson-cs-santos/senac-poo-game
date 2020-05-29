package cartas;

import Jogo.Tipo;

// Entidade - SUBCLASSE
public class Dragao extends Fusao implements IDefesaExtra
{
	// Atributos da classe dragao, se precisar fazer alguma regra que precise ser guardado algum valor
	// precisa ser criado aqui, pois nï¿½o ï¿½ possivel alterar as propriedades da classe principal
	
	private int defesa = 10;
	
	// Construtor
	public Dragao (String nome, int vida, int ataque, int defesa, Tipo tipo)
	{
		// Vida do dragao Ã© dobrada
		super(nome ,vida*2, ataque, defesa, tipo);
	}
	
	
	@Override
	public int retornarDefesa()
	{
		System.out.println(this.retornarNome() + " Tem " + this.defesa + " de defesa adicionais por ser Dragão!");
		return super.retornarDefesa() + aumentarDefesa() ;
	}
	
	
	public int aumentarDefesa()
	{
		return this.defesa;
	}
	
}
