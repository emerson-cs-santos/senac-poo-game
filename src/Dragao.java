public class Dragao extends Carta 
{
	
	// Atributos da classe dragao, se precisar fazer alguma regra que precise ser guardado algum valor
	// precisa ser criado aqui, pois não é possivel alterar as propriedades da classe principal
	
	private int defesa = 2;
	
	
	// contrutor
	public Dragao (String nome, int vida)
	{
		super(nome,vida);
		
		// Dragao tem vida extra no inicio
		vida = vida * 2;
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
	
	
	
}
