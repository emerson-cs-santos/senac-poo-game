package Jogo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import cartas.Carta;
import efeitos.Efeito;

public class Deck 
{
	Jogador player;
	List<Efeito> efeitosArmas;
	List<Efeito> efeitosArmaduras;
	List<Efeito> efeitosJoias;
	List<Carta> cartas;
	int qtdCartas;
	int qtdEfeitos;
	
	Random rand = new Random(); 
	Scanner input = new Scanner(System.in);	
	private List<Carta> Deck = new ArrayList<Carta>(); // Cartas sorteadas do jogador
	private List<Efeito> EfeitosEscolher = new ArrayList<Efeito>(); // efeitos sorteados
	
	public Deck( Jogador player, List<Efeito> efeitosArmas, List<Efeito> efeitosArmaduras, List<Efeito> efeitosJoias, List<Carta> cartas, int qtdCartas, int qtdEfeitos  ) 
	{
		this.player				= player;
		this.efeitosArmas		= efeitosArmas;		// Todos os efeitos de ataque do jogo
		this.efeitosArmaduras	= efeitosArmaduras;	// Todos os efeitos de defesa do jogo
		this.efeitosJoias		= efeitosJoias;		// Todos os efeitos de joia (ataque ou defesa random) do jogo
		this.cartas				= cartas; 			// Todas as cartas combatente do jogo
		this.qtdCartas			= qtdCartas;
		this.qtdEfeitos			= qtdEfeitos;
		
		this.iniciarDeck();
	}
	
	
	public List<Carta> retornarDeck()
	{
		return this.Deck;
	}
	
	
	public Jogador retornarPlayer()
	{
		return this.player;
	}
	
	
	private void iniciarDeck()
	{
		// Sortear cartas
		this.sortearCartas();
			
		// Sortear efeitos
		this.sortearEfeitos();
		
		// Jogador escolhe cartas sorteadas para colocar armadura
		System.out.println( "\n" + this.player.retornarNome() +  ", equipe efeitos nas cartas.");
		
		int opcaoCarta = 0;
		int opcaoEfeito = 0;
		int indice = 0;
			
		// Escolher efeitos nas cartas de combatentes
		while ( this.EfeitosEscolher.size() > 0 )
		{
			System.out.println(this.player.retornarNome() +  ", digite o número da carta para escolhê-la:");
			
			indice = 0;
			for( Carta carta: this.Deck )
		    {
				System.out.println( "\nCarta " + indice + " : " + carta.retornarNome() );
				System.out.println( carta.retornarDesc() );
				carta.verEfeitos();
				indice++;
		    }
			
			opcaoCarta = this.input.nextInt();
			
			// Adicionar efeito na carta
			if ( opcaoCarta > this.Deck.size()-1 || opcaoCarta < 0 )
			{
				System.out.println("\nOpção inválida! Digite um número de uma carta conforme a lista.\n");
			}
			else
			{
				System.out.println( "Carta escolhida: " + this.Deck.get(opcaoCarta).retornarNome() );
				System.out.println( this.Deck.get(opcaoCarta).retornarDesc() + "\n" );
				
				System.out.println(this.player.retornarNome() +  ", digite o número do efeito para escolhê-lo:");
				System.out.println("Atenção! Os números dos efeitos mudam \nconforme for sendo escolhidos!\n");
				
				indice = 0;
				for( Efeito efeito: this.EfeitosEscolher )
			    {
					System.out.println( "Efeito " + indice + " : " + efeito.retornarNome() );
					indice++;
			    }	
				
				opcaoEfeito = this.input.nextInt();
				
				if ( opcaoEfeito > this.EfeitosEscolher.size()-1 || opcaoEfeito < 0 )
				{
					System.out.println("\nOpção inválida! Digite um número conforme a lista.\n");
				}
				else
				{
					this.Deck.get( opcaoCarta ).guardarEfeito( this.EfeitosEscolher.get( opcaoEfeito ) );
					this.EfeitosEscolher.remove(opcaoEfeito); // Uma vez adicinado em uma carta, não pode ser usado novamente, pois aquela carta ficou com o efeito.
				}
			}			
		}
		
	}
	
	
	private void sortearCartas()
	{
		int Carta_sorteada = 0;
		int count = 0;
		
		for (count=0; count<this.qtdCartas; count++)
		{
			Carta_sorteada = rand.nextInt( this.cartas.size() );
			
			this.Deck.add( this.cartas.get(Carta_sorteada) );
			this.cartas.remove(Carta_sorteada); // Remove carta, pois não pode sortear carta repetida.
		}		
	}	
	

	private void sortearEfeitos()
	{
		int efeito_sorteado = 0;
		int count = 0;
		
		// Sortear ataques
		for (count=0; count<this.qtdEfeitos; count++)
		{
			efeito_sorteado = rand.nextInt( this.efeitosArmas.size() );
			this.EfeitosEscolher.add( this.efeitosArmas.get(efeito_sorteado) );
			this.efeitosArmas.remove(efeito_sorteado); // Remove efeito, pois não pode sortear efeito repetido.
		}	
		
		
		// Sortear defesas
		efeito_sorteado = 0;
		count = 0;
		
		for (count=0; count<this.qtdEfeitos; count++)
		{
			efeito_sorteado = rand.nextInt( this.efeitosArmaduras.size() );
			this.EfeitosEscolher.add( this.efeitosArmaduras.get(efeito_sorteado) );
			this.efeitosArmaduras.remove(efeito_sorteado); // Remove efeito, pois não pode sortear efeito repetido.
		}		
		
		// Sortear joias
		efeito_sorteado = 0;
		count = 0;
		
		for (count=0; count<this.qtdEfeitos; count++)
		{
			efeito_sorteado = rand.nextInt( this.efeitosJoias.size() );
			this.EfeitosEscolher.add( this.efeitosJoias.get(efeito_sorteado) );
			this.efeitosJoias.remove(efeito_sorteado); // Remove efeito, pois não pode sortear efeito repetido.
		}
	}	

}
