// Entidade - SUBCLASSE
public class Dragao extends Carta implements ISkill
{
	
	// Atributos da classe dragao, se precisar fazer alguma regra que precise ser guardado algum valor
	// precisa ser criado aqui, pois n�o � possivel alterar as propriedades da classe principal
	
	private int defesa = 2;
	
	// Construtor
	public Dragao (String nome, int vida)
	{
		// Vida do dragao é dobrada
		super(nome,vida*2);
	}
	
	
	@Override
	public void receberDano(int dano)
	{
		// Defesa extra do dragao
		if(dano > defesa)
		{
			dano = dano - defesa;
		}
		
		super.receberDano(dano);
	}
	
	public String VerDefesa()
	{
		return "Defesa: "+ defesa;
	}
	
	@Override
	public boolean desviar() {
		return false;
	}	
}
