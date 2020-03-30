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
}