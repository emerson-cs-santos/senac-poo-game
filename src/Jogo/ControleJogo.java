package Jogo;
// Serviço

import cartas.Carta;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
//import java.util.Set;
//import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

import cartas.Arqueiro;
import cartas.Bruxa;
import cartas.Demonio;
import cartas.Dinossauro;
import cartas.Dragao;
import cartas.Efeito;
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
	private int ataqueOriginal;
	
	private String vencedor;
	private String desviou;
	private boolean JogoON;
	private String QuemBatalhou;
	private boolean jogoAuto= false;
	
	private List<Carta> Deck1 = new ArrayList<Carta>();
	private List<Carta> Deck2 = new ArrayList<Carta>();
	
	private Map<Integer, Carta> Cartas = new HashMap<Integer, Carta>();	
	
	Random rand = new Random(); 	
	
	Scanner input = new Scanner(System.in);	
	
	// Construtor
	public ControleJogo ()
	{
		this.vencedor = "";
		this.desviou = "";
		this.JogoON = true;
		this.QuemBatalhou= "";
		
		criarCartas();
		definirJogoAuto();
	}
	
	private void definirJogoAuto()
	{
		// DECIDIR SE JOGO SERÁ RODADO DE UMA VEZ OU SERÁ EXECUTADO CADA PARTIDA CONFORME USUARIO QUISER
		boolean modoRespostaOk = false;
		
		String modo = "";
	
		while ( !modoRespostaOk )
		{
			System.out.println("\nDeseja modo automático de execução das partidas do jogo?");
			System.out.println("Digite s para Sim ou n para Não");
			modo = this.input.nextLine();
			
			if ( modo.toUpperCase().contentEquals("S") )
			{
				this.jogoAuto = true;
				modoRespostaOk = true;
			}
			else if (modo.toUpperCase().contentEquals("N"))
			{
				modoRespostaOk = true;
			}
			else
			{
				System.out.println("\nOpção incorreta! Digite 's' ou 'n'.");
			}
		}		
	}
	
	
	public void batalhar (Carta C1, Carta C2, Jogador jg1, Jogador jg2)
	{
		this.desviou = "";
		
		sortearAtaque();
		
		int atacante = decidirIniciativa();
		
		// Aplicando efeitos no valor do ataque
		List<Efeito> efeitosC1 = C1.getEfeitos();
		List<Efeito> efeitosC2 = C2.getEfeitos();
		
		System.out.println("Efeitos das Cartas para essa partida:");
		
		System.out.println(C1.retornarNome());
		for(Efeito Efeito: efeitosC1)
	    {
			Efeito.verEfeito();
	    }
		
		System.out.println("");
		System.out.println(C2.retornarNome());
		for(Efeito Efeito: efeitosC2)
	    {
			Efeito.verEfeito();
	    }		
		
		
		if (atacante == 1)
		{
			// Efeitos quando carta 1 ataca
			for(Efeito Efeito: efeitosC1)
		    {
				this.ataque = Efeito.aplicarEfeito(this.ataque, true);
		    }
			
			// Efeitos quando carta 2 defende
			for(Efeito Efeito: efeitosC2)
		    {
				this.ataque = Efeito.aplicarEfeito(this.ataque, false);
		    }			
			
			C2.receberDano(this.ataque);
			this.vencedor = C1.retornarNome() + "(" + jg1.retornarNome() + ")";
			definirSeDesviou(C2,jg2);
		}
		else
		{
			// Efeitos quando carta 2 ataca
			for(Efeito Efeito: efeitosC2)
		    {
				this.ataque = Efeito.aplicarEfeito(this.ataque, true);
		    }
			
			// Efeitos quando carta 1 defende
			for(Efeito Efeito: efeitosC1)
		    {
				this.ataque = Efeito.aplicarEfeito(this.ataque, false);
		    }				
			
			C1.receberDano(this.ataque);
			this.vencedor = C2.retornarNome() + "(" + jg2.retornarNome() + ")";
			definirSeDesviou(C1,jg1);
		}
	}
	
	
	private int decidirIniciativa()
	{
		
		// Fazer ramdom entre 2 (função está retornando de 0 até 1)
		// Se ramdom retornar 0, será somado com 1, sorteando assim o numero 1
		// Se ramdom retornar 1, será somado com 1, sorteando assim o numero 2
		
		return rand.nextInt(2) + 1;
		
	}	
	
	
	private void sortearAtaque()
	{
		// De 1 até 10
		this.ataque = rand.nextInt(10);
		
		this.ataqueOriginal = this.ataque; 
	}
	
	
	public String exibirVencedorPartida()
	{
		return "Vencedor da partida: " + this.vencedor;
		
	}
	
	
	public String exibirAtaque()
	{
		return "Valor do Ataque: " + this.ataque;
		
	}	
	
	public int exbirAtaqueOriginal()
	{
		return this.ataqueOriginal;
		
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
	
	
	private void criarCartas()
	{
		int ordem = 0;
		
		this.Cartas.put( ordem++, new Arqueiro		(	"Legolas",				10	)	);
		this.Cartas.put( ordem++, new Bruxa			(	"Floresta Negra",		15	)	);
		this.Cartas.put( ordem++, new Demonio		(	"Rei Caveira",			28	)	);
		this.Cartas.put( ordem++, new Dinossauro	(	"Rex de duas cabeças",	60	)	);
		this.Cartas.put( ordem++, new Dragao		(	"Blue-eyes",			30	)	);
		this.Cartas.put( ordem++, new Elfo			(	"Elfa Mística",			5	)	);
		this.Cartas.put( ordem++, new Esqueleto		(	"Guardião dos portões",	75	)	);
		this.Cartas.put( ordem++, new Fantasma		(	"Fantasma Renegado",	36	)	);
		this.Cartas.put( ordem++, new FeraDivina	(	"Alado de Rá",			200	)	);
		this.Cartas.put( ordem++, new Harpia		(	"Espanador de penas",	20	)	);
		this.Cartas.put( ordem++, new Mago			(	"Mago Negro",			25	)	);
		this.Cartas.put( ordem++, new Monstro		(	"Lustro Negro",			48	)	);
		
		// Deck 1
		//preencherDeck(this.Deck1, this.Cartas);
		
		// Deck 2
		//preencherDeck(this.Deck2, this.Cartas);
	}
	
	
	public void iniciarDeck( Jogador player, int jogadorNumber )
	{
		// DEFININDO O TAMANHO DO DECK
		int deckQtd = 3;
		
		// DECIDIR SE VAI USAR DECK RANDOM
		boolean modoRespostaOk = false;
		boolean randDeck= false;
		String modo = "";
	
		while ( !modoRespostaOk )
		{
			System.out.println("\n" + player.retornarNome() + " deseja utilizar cartas aleatórias?");
			System.out.println("Digite s para Sim ou n para Não");
			modo = this.input.nextLine();
			
			if ( modo.toUpperCase().contentEquals("S") )
			{
				randDeck = true;
				modoRespostaOk = true;
			}
			else if (modo.toUpperCase().contentEquals("N"))
			{
				modoRespostaOk = true;
			}
			else
			{
				System.out.println("\nOpção incorreta! Digite 's' ou 'n'.");
			}
		}
		
		
		if (randDeck)
		{
			preencherDeckRandom( deckJogador(jogadorNumber) );
			// EXIBE DECK QUE ESTÁ SENDO MONTADO
			deckList( deckJogador(jogadorNumber) );				
		}
		else
		{
			int opcaoCarta = 0;
			int count = 1;
			
			System.out.println("\n" + player.retornarNome() + " escolha " + deckQtd + " cartas:");
		    
			for(int indice: this.Cartas.keySet())
		    {
		      System.out.println( "Carta " + indice + " : " + this.Cartas.get(indice).retornarNome() );
		    }
			
			System.out.println("");
			
			String deckResp = "";
			
			while(count < deckQtd+1)
			{				
				System.out.println("Carta " + count + ":");
				System.out.println("Digite o número da carta para escolher:");
				opcaoCarta = this.input.nextInt();
				
				if ( opcaoCarta > this.Cartas.size()-1 || opcaoCarta < 0 )
				{
					System.out.println("\nOpção inválida! Digite um número de uma carta conforme a lista.\n");
				}
				else
				{
					deckAdd( deckJogador(jogadorNumber), opcaoCarta);
					count++;
				}
				// EXIBE DECK QUE ESTÁ SENDO MONTADO
				deckList( deckJogador(jogadorNumber) );					
			}			
		}
	}
	
	
	private void deckAdd( List<Carta> deck, int cartaNumber)
	{
		deck.add( this.Cartas.get(cartaNumber) );		
	}
	
	
	private void preencherDeckRandom( List<Carta> deck )
	{
		int Carta_sorteada = 0;
		int count = 1;
		
		for (count=1; count<4; count++)
		{
			// De 1 até 12
			Carta_sorteada = rand.nextInt(12);
			
			deck.add( this.Cartas.get(Carta_sorteada) );
		}		
	}
	
	
	private void deckList(List<Carta> deck)
	{
		// Valida o tamanho para não mostrar enquanto não tiver cartas
		if (deck.size() > 0)
		{
			System.out.println("\nCartas no Deck:");
			
			int CartaCount = 1;
			
			for(Carta carta: deck)
		    {
				System.out.println(CartaCount++ + " - " + carta.retornarNome() );
		    }
		}
	}
	
	
	private List<Carta> deckJogador (int jogadorNumber)
	{
		if (jogadorNumber == 1)
		{
			return this.Deck1;
		}
		else
		{
			return this.Deck2;
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
	
	
	public void continuarJogo()
	{
		if ( !this.jogoAuto )
		{
			System.out.println("\nAperte qualquer tecla para continar...");
			String partida = this.input.nextLine();				
		}
	}
	
	
}
