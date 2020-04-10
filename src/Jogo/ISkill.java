package Jogo;
import java.util.Random; 

public interface ISkill 
{
	
	Random rand = new Random(); 
	
	
	default boolean desviar() 
	{
		int chance = rand.nextInt(3) + 1;
		boolean desviar = false;
		
		if ( chance == 2 )
		{
			desviar = true;
		}
		
		return desviar;
	}
	
	
	// AINDA NÃO UTILIZADO, QUANDO FOR, PRECISA INFORMAR NO LOG QUE HOUVE AUMENTO DE VIDA
	public static int AumentarVida() 
	{
		
		int chance = rand.nextInt(3) + 1;
		int valor = 0;
		
		if ( chance == 2 )
		{
			valor = 5;
		}
		
		return valor;
	}
}