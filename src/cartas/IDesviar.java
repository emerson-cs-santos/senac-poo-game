package cartas;
import java.util.Random; 

public interface IDesviar 
{
	Random rand = new Random(); 
	
	public boolean desviar(); 
	
//	default boolean desviar() 
//	{
//		int chance = rand.nextInt(3) + 1;
//		boolean desviar = false;
//		
//		if ( chance == 2 )
//		{
//			desviar = true;
//		}
//		
//		return desviar;
//	}
	
}