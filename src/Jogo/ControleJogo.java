package Jogo;
// Servi�o

import cartas.Carta;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
//import java.util.Set;
//import java.util.HashSet;
import java.util.Random;

import cartas.Arqueiro;
import cartas.Bruxa;
import cartas.Demonio;
import cartas.Dinossauro;
import cartas.Dragao;
import cartas.Elfo;
import cartas.Esqueleto;
import cartas.Fantasma;
import cartas.FeraDivina;
import cartas.Harpia;
import cartas.Mago;
import cartas.Monstro;

public class ControleJogo 
{
	private int ataque;
	
	private String vencedor;
	private String desviou;
	private boolean JogoON;
	private String QuemBatalhou;
	
	private List<Carta> Deck1 = new ArrayList<Carta>();
	private List<Carta> Deck2 = new ArrayList<Carta>();
	
	private Map<Integer, Carta> Cartas = new HashMap<Integer, Carta>();	
	
//	Object Carta1 = new Object();
//	Object Carta2 = new Object();
	
	Random rand = new Random(); 	
	
	// Construtor
	public ControleJogo ()
	{
		this.vencedor = "";
		this.desviou = "";
		this.JogoON = true;
		this.QuemBatalhou= "";
		
		iniciarDecks();
	}
	
	public void batalhar (Carta C1, Carta C2, Jogador jg1, Jogador jg2)
	{
		this.desviou = "";
		
		sortearAtaque();
		
		int atacante = decidirIniciativa();
		
		if (atacante == 1)
		{
			C2.receberDano(ataque);
			this.vencedor = C1.retornarNome() + "(" + jg1.retornarNome() + ")";
			definirSeDesviou(C2,jg2);
		}
		else
		{
			C1.receberDano(ataque);
			this.vencedor = C2.retornarNome() + "(" + jg2.retornarNome() + ")";
			definirSeDesviou(C1,jg1);
		}
	}
	
	private int decidirIniciativa()
	{
		
		// Fazer ramdom entre 2 (fun��o est� retornando de 0 at� 1)
		// Se ramdom retornar 0, ser� somado com 1, sorteando assim o numero 1
		// Se ramdom retornar 1, ser� somado com 1, sorteando assim o numero 2
		
		return rand.nextInt(2) + 1;
		
	}	
	
	private void sortearAtaque()
	{
		// De 1 at� 10
		this.ataque = rand.nextInt(10);		
	}
	
	public String exibirVencedorPartida()
	{
		return "Vencedor da partida: " + this.vencedor;
		
	}
	
	public String exibirAtaque()
	{
		return "Valor do Ataque: " + this.ataque;
		
	}	
	
	public String vencedorJogo(Jogador J1, Jogador J2)
	{
		
		int VidaCartas1 = 0;
		int VidaCartas2 = 0;
		
		for(Carta carta1: this.Deck1)
	    {
			VidaCartas1 = VidaCartas1 + carta1.retornarVida();
	    }	
		
		for(Carta carta2: this.Deck2)
	    {
			VidaCartas2 = VidaCartas2 + carta2.retornarVida();
	    }		
		
		
		String Vencedor = "";
		
		if (VidaCartas1 <= 0)
		{
			Vencedor = "Vencedor Jogador 2: " + J2.retornarNome();
		}
		
		if (VidaCartas2 <= 0)
		{
			Vencedor = "Vencedor Jogador 1: " + J1.retornarNome();
		}	
		
		
		return Vencedor;
	}
	
	private void definirSeDesviou(Carta C, Jogador pl)
	{
	
		if ( C.verDesviou() )
		{
			this.desviou = C.retornarNome() + "(" + pl.retornarNome() + ")" +  " desviou do Ataque!! ";
		}
		else
		{
			this.desviou = "";
		}
		
		C.setarDesvio(false);
	}
	
	public String ExibirDesviou()
	{
		return this.desviou;
	}
	
	private void iniciarDecks()
	{
		int ordem = 0;
		
		this.Cartas.put( ordem++, new Arqueiro		(	"Legolas",				10	)	);
		this.Cartas.put( ordem++, new Bruxa			(	"Floresta Negra",		15	)	);
		this.Cartas.put( ordem++, new Demonio		(	"Rei Caveira",			28	)	);
		this.Cartas.put( ordem++, new Dinossauro	(	"Rex de duas cabe�as",	60	)	);
		this.Cartas.put( ordem++, new Dragao		(	"Blue-eyes",			30	)	);
		this.Cartas.put( ordem++, new Elfo			(	"Elfa M�stica",			5	)	);
		this.Cartas.put( ordem++, new Esqueleto		(	"Guardi�o dos port�es",	75	)	);
		this.Cartas.put( ordem++, new Fantasma		(	"Fantasma Renegado",	36	)	);
		this.Cartas.put( ordem++, new FeraDivina	(	"Alado de R�",			200	)	);
		this.Cartas.put( ordem++, new Harpia		(	"Espanador de penas",	20	)	);
		this.Cartas.put( ordem++, new Mago			(	"Mago Negro",			25	)	);
		this.Cartas.put( ordem++, new Monstro		(	"Lustro Negro",			48	)	);
		
		// Deck 1
		preencherDeck(this.Deck1, this.Cartas);
		
		// Deck 2
		preencherDeck(this.Deck2, this.Cartas);
	}
	
	private void preencherDeck( List<Carta> deck, Map<Integer, Carta> Cartas)
	{
		int Carta_sorteada = 0;
		int count = 1;
		
		for (count=1; count<4; count++)
		{
			// De 1 at� 12
			Carta_sorteada = rand.nextInt(12);
			
			deck.add( Cartas.get(Carta_sorteada) );
		}		
	}
	
	public void exibirDeck(int DeckNumber)
	{
		if(DeckNumber == 1)
		{
			deckStatus(this.Deck1);
		}
		
		if(DeckNumber == 2)
		{
			deckStatus(this.Deck2);
		}
	}
	
	private void deckStatus(List<Carta> deck)
	{
		System.out.println("");
		System.out.println("Deck:");
		
		int CartaCount = 1;
		
		for(Carta carta: deck)
	    {
			System.out.println("Carta " + CartaCount++ + ":");
	        System.out.println( carta.retornarStatus());
	        System.out.println("");
	    }
	}

	public void controleBatalha(Jogador p1, Jogador p2)
	{
		boolean OcorreuBatalha = false;
		for(Carta carta1: this.Deck1)
	    {
			if( carta1.retornarVida() > 0)
			{
				for(Carta carta2: this.Deck2)
			    {
					if( carta2.retornarVida() > 0)
					{
						batalhar(carta1, carta2, p1, p2);
						OcorreuBatalha = true;
						this.QuemBatalhou = carta1.retornarNome() + "(" + p1.retornarNome() + ")" +  " VS " + carta2.retornarNome() + "(" + p2.retornarNome() + ")"; 
						break;
					}
			    }	
				break;
			}
	    }
		
		
		this.JogoON = OcorreuBatalha;
	}
	
	public boolean jogoContinua()
	{
		return this.JogoON;
	}
	
	public void quemBatalhouNaPartida()
	{
		System.out.println( this.QuemBatalhou );
	}
	
}
