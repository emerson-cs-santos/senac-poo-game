package cartas;

import Jogo.Tipo;

// Entidade - SUBCLASSE
public class Dragao extends Fusao implements IDefesaExtra
{
	// Atributos da classe dragao, se precisar fazer alguma regra que precise ser guardado algum valor
	// precisa ser criado aqui, pois n�o � possivel alterar as propriedades da classe principal
	
	private int defesa = 10;
	
	// Construtor
	public Dragao (String nome, int vida, int ataque, int defesa, Tipo tipo)
	{
		// Vida do dragao é dobrada
		super(nome ,vida*2, ataque, defesa, tipo);
	}
	
	
	@Override
	public int retornarDefesa()
	{
		System.out.println(this.retornarNome() + " Tem " + this.defesa + " de defesa adicionais por ser Drag�o!");
		return super.retornarDefesa() + aumentarDefesa() ;
	}
	
	
	public int aumentarDefesa()
	{
		return this.defesa;
	}
	
}
