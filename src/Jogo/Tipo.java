package Jogo;

import cartas.Fraqueza;

public enum Tipo 
{
	TREVAS(Fraqueza.LUZ), LUZ(Fraqueza.DIVINO), TERRA(Fraqueza.VENTO), FOGO(Fraqueza.AGUA), AGUA(Fraqueza.GELO), VENTO(Fraqueza.TERRA), GELO(Fraqueza.FOGO), DIVINO(Fraqueza.TREVAS);
	
	  public Fraqueza fraqueza;
	  Tipo(Fraqueza fraqueza) 
	  {
	    this.fraqueza = fraqueza;
	  }		

}
