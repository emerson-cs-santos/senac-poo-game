package Jogo;
// Serviço

import cartas.Carta;
import java.util.Random;
import java.util.Scanner;

import efeitos.Efeito;
import efeitos.TipoEfeito;

public class ControleJogo 
{
	Random rand = new Random();
	Scanner input = new Scanner(System.in);	
	
	Deck deck1;
	Deck deck2;
	
	// Construtor
	public ControleJogo ( Deck deck1, Deck deck2 )
	{
		this.deck1 = deck1;
		this.deck2 = deck2;
		
		jogo();
	}
	
	private void jogo()
	{
		int opcaoCarta1 = 0;
		int opcaoCarta2 = 0;
		int resultadoBatalha = 0;
		int indice = 0;
		Carta card1;
		Carta card2;
		
		while( this.deck1.retornarDeck().size() > 0 && this.deck2.retornarDeck().size() > 0 )
		{
			// Jogadores escolhem 1 carta para a batalha
			System.out.println(this.deck1.player.retornarNome() +  ", escolha uma carta para batalha:");
			System.out.println("Digite o número da carta para escolhê-la.");
			
			indice = 0;
			for( Carta carta: this.deck1.retornarDeck() )
		    {
				System.out.println( "\nCarta " + indice + " : " + carta.retornarNome() );
				System.out.println( carta.retornarDesc() );
				carta.verEfeitos();
				indice++;
		    }
			
			opcaoCarta1 = this.input.nextInt();
			
			if ( opcaoCarta1 > this.deck1.retornarDeck().size()-1 || opcaoCarta1 < 0 )
			{
				System.out.println("\nOpção inválida! Digite um número de uma carta conforme a lista.\n");
			}
			else
			{
				card1 = this.deck1.retornarDeck().get(opcaoCarta1);
				System.out.println("Carta escolhida: " + card1.retornarNome() + "\n");
				
				
				System.out.println(this.deck2.player.retornarNome() +  ", escolha uma carta para batalha:");
				System.out.println("Digite o número da carta para escolhê-la.");
				
				indice = 0;
				for( Carta carta: this.deck2.retornarDeck() )
			    {
					System.out.println( "\nCarta " + indice + " : " + carta.retornarNome() );
					System.out.println( carta.retornarDesc() );
					carta.verEfeitos();
					indice++;
			    }	
				
				opcaoCarta2 = this.input.nextInt();
				
				if ( opcaoCarta2 > this.deck2.retornarDeck().size()-1 || opcaoCarta2 < 0 )
				{
					System.out.println("\nOpção inválida! Digite um número de uma carta conforme a lista.\n");
				}				
				else
				{
					card2 = this.deck2.retornarDeck().get(opcaoCarta2);
					System.out.println("Carta escolhida: " + card2.retornarNome() + "\n" );
					
					resultadoBatalha = this.batalhar( card1, card2 );
					
					if ( resultadoBatalha == 1 )
					{
						this.deck2.retornarDeck().remove(opcaoCarta2);
					}
					
					if ( resultadoBatalha == 2 )
					{
						this.deck1.retornarDeck().remove(opcaoCarta1);
					}
				}
			}
		}
		
		
		// Exibir vencedor
		
		System.out.println("Fim de Jogo!! \n" );
		
		// Se vencedor foi jogador do deck 1
		if ( this.deck1.retornarDeck().size() > 0 )
		{
			System.out.println("Vencedor do jogo: " + this.deck1.retornarPlayer().retornarNome() );
		}
		
		// Se vencedor foi jogador do deck 2
		if ( this.deck2.retornarDeck().size() > 0 )
		{
			System.out.println("Vencedor do jogo: " + this.deck2.retornarPlayer().retornarNome() );
		}		
		
	}
	
	
	private int batalhar( Carta card1, Carta card2 )
	{
		// 0 até 1
		int vez = rand.nextInt( 2 ) + 1;
		
		int ataque = 0;
		int defesa = 0;
		int dano = 0;
		int retorno = 0;
		
		System.out.println( "\nIniciando batalha entre: \n" + card1.retornarNome() + " X " + card2.retornarNome() + "\n" );
		
		while ( card1.retornarVida() > 0 && card2.retornarVida() > 0 )
		{
			System.out.println( card1.retornarStatus() + "\n" );
			System.out.println( card2.retornarStatus() + "\n" );
			
			if ( vez == 1 )
			{
				vez = 2;

				// Card 1 ataca
				ataque = this.calcularAtaque( card1, card2 );
				
				
				// Card 2 defende
				defesa = this.calcularDefesa( card1, card2 );
				
				dano = ataque - defesa;
				if ( dano < 0 )
				{
					dano = 1;
				}
				
				card2.receberDano(dano);
				System.out.println(card2.retornarNome() + " recebeu " + dano + " de dano!" );
				
			}
			else
			{
				vez = 1;
				
				// Card 2 ataca
				ataque = this.calcularAtaque( card2, card1 );
				
				// Card 1 Defende
				ataque = this.calcularDefesa( card2, card1 );
				
				card1.receberDano(dano);
				System.out.println(card1.retornarNome() + " recebeu " + dano + " de dano!" );				
			}
			
			System.out.println("\nAperte qualquer tecla para continar...\n");
			String partida = this.input.nextLine();
		}
		
		
		if ( card1.retornarVida() > 0 )	
		{
			retorno = 1;
			System.out.println(card1.retornarNome() + " Venceu a batalha\n");
		}
		
		if ( card2.retornarVida() > 0 )	
		{
			retorno = 2;
			System.out.println(card2.retornarNome() + " Venceu a batalha");
		}
		
		System.out.println("Final da batalha:\n");
		
		System.out.println( card1.retornarStatus() + "\n" );
		System.out.println( card2.retornarStatus() + "\n" );		
				
		return retorno;
	}
	
	
	private int calcularAtaque( Carta card1, Carta card2 )
	{
		int ataqueSorteado = 0;
		int ataqueCarta = 0;
		int ataqueEfeito = 0;
		int ataqueTotal = 0;
		
		// 0 até 20
		ataqueSorteado = rand.nextInt(21);		
		
		// Card ataca
		System.out.println(card1.retornarNome() + " Ataca!" );
		System.out.println(card1.retornarDesc() + "\n" );
		
		System.out.println("Composição do ataque:" );
		
		
		// Ataque Sorteado
		System.out.println("Sorteado na vez de ataque: " + ataqueSorteado );
		ataqueTotal = ataqueTotal + ataqueSorteado;
		
		
		
		
		// Ataque da carta
		ataqueCarta = card1.retornarAtaque();
		
		// Checando de tipos das cartas são iguais
		if ( card1.retornarTipo() == card2.retornarTipo() )
		{
			ataqueCarta--;
			System.out.println("\nTipos das cartas são iguais, \npor isso o ataque da carta \n foi diminuido por 1!" );
		}
		
		// Checando fraqueza
		if ( card1.retornarTipo().name() == card2.retornarTipo().fraqueza.name() )
		{
			ataqueCarta++;
			System.out.println("\nCarta atacante tem vantagem de tipo, \npor isso o ataque da carta \n foi aumentado por 1!" );
		}
		
		// Checando se tipo carta é igual aos efeitos de defesas da carta 2
		for( Efeito efeito: card2.retornarListaEfeitos() )
	    {
			if ( efeito.retornarTipoEfeito() == TipoEfeito.DEFESA && card1.retornarTipo() == efeito.retornarTipo()  )
			{
				ataqueCarta--;
				System.out.println("\nTipo da carta atacante é igual ao efeito de defesa: \n" + efeito.retornarNome()  + ", por isso o ataque da carta \n foi diminuido por 1!" );
			}
	    }				
		
		System.out.println("	+ Ataque da carta: " + ataqueCarta );
		ataqueTotal = ataqueTotal + ataqueCarta;
		
		
		
		// Ataque dos efeitos de ataque
		for( Efeito efeito: card1.retornarListaEfeitos() )
	    {
			if ( efeito.retornarTipoEfeito() == TipoEfeito.ATAQUE )
			{
				ataqueEfeito = efeito.retornarValor();
				
				// Checando de tipos da arma e card2 são iguais
				if ( efeito.retornarTipo() == card2.retornarTipo() )
				{
					ataqueEfeito--;
					System.out.println("\nTipo do efeito " + efeito.retornarNome() + "\n é do mesmo tipo da carta que se defende! \nPor isso o ataque do efeito \n foi diminuido por 1!" );
				}
				
				// Efeito de ataque tem vantegem sobre a carta que se defende
				if ( efeito.retornarTipo().name() == card2.retornarTipo().fraqueza.name() )
				{
					ataqueEfeito++;
					System.out.println("\nTipo do efeito " + efeito.retornarNome() + "\n tem vantagem sobre a carta que se defende \nPor isso o ataque do efeito \n foi aumentado por 1!" );
				}							
				
				
				// Checando se tipos de arma e armadura são iguais
				for( Efeito efeitoCard2: card2.retornarListaEfeitos() )
			    {
					// Tipo igual de efeito de ataque ao de defesa
					if ( efeitoCard2.retornarTipoEfeito() == TipoEfeito.DEFESA && efeito.retornarTipo() == efeitoCard2.retornarTipo()  )
					{
						ataqueEfeito--;
						System.out.println("\nTipo do efeito " + efeito.retornarNome() + "\n é do mesmo tipo do efeito de defesa: " + efeitoCard2.retornarNome() +   " da carta que se defende \nPor isso o ataque do efeito \n foi diminuido por 1!" );
					}						
			    }	
				
				System.out.println("	+ Efeito " + efeito.retornarNome() + ": " + ataqueEfeito );
				ataqueTotal = ataqueTotal + ataqueEfeito;
			}
	    }
		
		if( ataqueTotal < 0 )
		{
			ataqueTotal = 1;
		}
		System.out.println("\nValor total do ataque: " + ataqueTotal + "\n");
		
		return ataqueTotal;
	}
	
	
	private int calcularDefesa( Carta card1, Carta card2 )  
	{
		int defesaSorteada = 0;
		int defesaCarta = 0;
		int defesaEfeito = 0;
		int defesaTotal = 0;
		
		// 0 até 10
		defesaSorteada = rand.nextInt(11);		
		
		System.out.println(card2.retornarNome() + " Defende!" );
		System.out.println(card2.retornarDesc() + "\n" );
		
		System.out.println("Composição da defesa:" );
		
		
		// Sorteado
		System.out.println("Sorteado na vez de defender: " + defesaSorteada );
		defesaTotal = defesaTotal + defesaSorteada;
		
		// Defesa da carta
		defesaCarta = card2.retornarDefesa();	
		
		System.out.println("	+ Defesa da carta: " + defesaCarta );
		defesaTotal = defesaTotal + defesaCarta;
		
		
		// Defesa dos efeitos de defesa
		for( Efeito efeito: card2.retornarListaEfeitos() )
	    {
			if ( efeito.retornarTipoEfeito() == TipoEfeito.DEFESA )
			{
				defesaEfeito = efeito.retornarValor();
			
				System.out.println("	+ Efeito " + efeito.retornarNome() + ": " + defesaEfeito );
				defesaTotal = defesaTotal + defesaEfeito;
			}
	    }	
		
		if( defesaTotal < 0 )
		{
			defesaTotal = 1;
		}				
		System.out.println("\nValor total da Defesa: " + defesaTotal + "\n" );	
		
		return defesaTotal;
		
	}
}
