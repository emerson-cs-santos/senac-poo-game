package Jogo;

import java.util.ArrayList;
import java.util.List;

import cartas.Abdicacao;
import cartas.Abdutor;
import cartas.Anomalo;
import cartas.Arqueiro;
import cartas.BestaAlada;
import cartas.BestaGuerreira;
import cartas.BestaTensa;
import cartas.Bruxa;
import cartas.Camarartista;
import cartas.Carta;
import cartas.Cibernetico;
import cartas.Demonio;
import cartas.Dinossauro;
import cartas.Dragao;
import cartas.Elfo;
import cartas.Espaco;
import cartas.Esqueleto;
import cartas.Fada;
import cartas.Fantasma;
import cartas.Fenix;
import cartas.FeraDivina;
import cartas.Harpia;
import cartas.Inseto;
import cartas.Mago;
import cartas.Maquina;
import cartas.Monstro;
import cartas.Planta;
import cartas.Psiquico;
import cartas.Quantico;
import cartas.Reptil;
import cartas.Trovao;
import efeitos.Adaga;
import efeitos.AdagaVeneno;
import efeitos.Arco;
import efeitos.ArcoLongo;
import efeitos.ArcoPesado;
import efeitos.ArmaduraElementalLeve;
import efeitos.ArmaduraElementalMedia;
import efeitos.ArmaduraElementalPesada;
import efeitos.ArmaduraLeve;
import efeitos.ArmaduraMedia;
import efeitos.ArmaduraPesada;
import efeitos.Besta;
import efeitos.BestaVeneno;
import efeitos.Efeito;
import efeitos.Escudo;
import efeitos.EscudoAgua;
import efeitos.EscudoDivino;
import efeitos.EscudoDuplo;
import efeitos.EscudoFogo;
import efeitos.EscudoGelo;
import efeitos.EscudoLeve;
import efeitos.EscudoLuz;
import efeitos.EscudoMedio;
import efeitos.EscudoPesado;
import efeitos.EscudoReforcado;
import efeitos.EscudoTerra;
import efeitos.EscudoTrevas;
import efeitos.EscudoVento;
import efeitos.Espada;
import efeitos.EspadaLonga;
import efeitos.EspadaPesada;
import efeitos.Faca;
import efeitos.FacaVeneno;
import efeitos.Joia;
import efeitos.Lanca;
import efeitos.LancaLonga;
import efeitos.LancaPesada;
import efeitos.Maca;
import efeitos.MacaPesada;
import efeitos.Machado;
import efeitos.MachadoLongo;
import efeitos.MachadoPesado;
import efeitos.TipoEfeito;

public class Game 
{
	public static void main(String[] args) 
	{			
		Jogador player1 = new Jogador(1);
		System.out.println("");
		Jogador player2 = new Jogador(2);
		
		List<Efeito> efeitosArmas		= new ArrayList<Efeito>();
		List<Efeito> efeitosArmaduras	= new ArrayList<Efeito>();
		List<Efeito> efeitosJoias		= new ArrayList<Efeito>();
		
		List<Carta> Cartas = new ArrayList<Carta>();
		
		// Quantidade de combatentes que cada jogador terá
		final int qtdCartas = 5;
		
		// Quantidade de efeitos que cada tipo de efeito terá
		// Exemplo definindo 2:
		// Teremos 2 armas, 2 armaduras e 2 joias.
		final int qtdEfeitos = 6;
		
		carregarEfeitos(efeitosArmas, efeitosArmaduras, efeitosJoias);
		carregarCartas(Cartas);
		
		Deck deck1 = new Deck(player1, efeitosArmas, efeitosArmaduras, efeitosJoias, Cartas, qtdCartas, qtdEfeitos );
		
		carregarEfeitos(efeitosArmas, efeitosArmaduras, efeitosJoias);
		carregarCartas(Cartas);
		
		Deck deck2 = new Deck(player2, efeitosArmas, efeitosArmaduras, efeitosJoias, Cartas, qtdCartas, qtdEfeitos );
		
		// Executa jogo com decks dos jogadores
		ControleJogo jogo = new ControleJogo(deck1, deck2);
		
	}
	
	public static void carregarEfeitos( List<Efeito> efeitosArmas, List<Efeito> efeitosArmaduras, List<Efeito> efeitosJoias )
	{
		// Armas
		efeitosArmas.add( new Espada( "Espada de Gelo", 15, Tipo.GELO, TipoEfeito.ATAQUE ) );
		efeitosArmas.add( new EspadaLonga( "Espada de Fogo", 8, Tipo.FOGO, TipoEfeito.ATAQUE ) );
		efeitosArmas.add( new EspadaPesada( "Espada Pesada", 8, Tipo.TERRA, TipoEfeito.ATAQUE ) );
		efeitosArmas.add( new Lanca( "Lança de água", 12, Tipo.AGUA, TipoEfeito.ATAQUE ) );
		efeitosArmas.add( new LancaLonga( "Lança Longa", 14, Tipo.TREVAS, TipoEfeito.ATAQUE ) );
		efeitosArmas.add( new LancaPesada( "Lança Pesada", 16, Tipo.LUZ, TipoEfeito.ATAQUE ) );
		efeitosArmas.add( new Arco( "Arco", 5, Tipo.AGUA, TipoEfeito.ATAQUE ) );
		efeitosArmas.add( new ArcoLongo( "Arco Longo", 4, Tipo.VENTO, TipoEfeito.ATAQUE ) );
		efeitosArmas.add( new ArcoPesado( "Arco Pesado", 13, Tipo.AGUA, TipoEfeito.ATAQUE ) );
		efeitosArmas.add( new Machado( "Machado", 16, Tipo.VENTO, TipoEfeito.ATAQUE ) );
		efeitosArmas.add( new MachadoLongo( "Machado Longo", 17, Tipo.GELO, TipoEfeito.ATAQUE ) );
		efeitosArmas.add( new MachadoPesado( "Machado Pesado", 22, Tipo.DIVINO, TipoEfeito.ATAQUE ) );	
		efeitosArmas.add( new Faca( "Faca", 2, Tipo.LUZ, TipoEfeito.ATAQUE ) );
		efeitosArmas.add( new FacaVeneno( "Faca Veneno", 4, Tipo.AGUA, TipoEfeito.ATAQUE ) );
		efeitosArmas.add( new Adaga( "Adaga", 3, Tipo.TREVAS, TipoEfeito.ATAQUE ) );			
		efeitosArmas.add( new AdagaVeneno( "Adaga Veneno", 6, Tipo.AGUA, TipoEfeito.ATAQUE ) );
		efeitosArmas.add( new Besta( "Besta", 7, Tipo.TERRA, TipoEfeito.ATAQUE ) );			
		efeitosArmas.add( new BestaVeneno( "Besta Veneno", 9, Tipo.AGUA, TipoEfeito.ATAQUE ) );
		efeitosArmas.add( new Maca( "Maca", 14, Tipo.FOGO, TipoEfeito.ATAQUE ) );			
		efeitosArmas.add( new MacaPesada( "Maca Pesada", 18, Tipo.FOGO, TipoEfeito.ATAQUE ) );		
		

		// Armaduras
		efeitosArmaduras.add( new Escudo("Escudo terreste", 10, Tipo.TERRA, TipoEfeito.DEFESA ) );
		efeitosArmaduras.add( new EscudoLeve("Escudo de Luz", 20, Tipo.LUZ, TipoEfeito.DEFESA ) );
		efeitosArmaduras.add( new EscudoPesado("Escudo de Trevas", 25, Tipo.TREVAS, TipoEfeito.DEFESA ) );
		efeitosArmaduras.add( new EscudoMedio("Escudo Medio", 12, Tipo.FOGO, TipoEfeito.DEFESA ) );
		efeitosArmaduras.add( new EscudoReforcado("Escudo Reforcado", 14, Tipo.TERRA, TipoEfeito.DEFESA ) );
		efeitosArmaduras.add( new EscudoFogo("Escudo Fogo", 8, Tipo.AGUA, TipoEfeito.DEFESA ) );
		efeitosArmaduras.add( new EscudoGelo("Escudo Gelo", 8, Tipo.VENTO, TipoEfeito.DEFESA ) );
		efeitosArmaduras.add( new EscudoTerra("Escudo Terra", 7, Tipo.GELO, TipoEfeito.DEFESA ) );
		efeitosArmaduras.add( new EscudoVento("Escudo Vento", 7, Tipo.DIVINO, TipoEfeito.DEFESA ) );
		efeitosArmaduras.add( new EscudoTrevas("Escudo Trevas", 9, Tipo.TREVAS, TipoEfeito.DEFESA ) );
		efeitosArmaduras.add( new EscudoLuz("Escudo Luz", 9, Tipo.LUZ, TipoEfeito.DEFESA ) );
		efeitosArmaduras.add( new EscudoAgua("Escudo Agua", 6, Tipo.TERRA, TipoEfeito.DEFESA ) );
		efeitosArmaduras.add( new EscudoDivino("Escudo Divino", 25, Tipo.FOGO, TipoEfeito.DEFESA ) );
		efeitosArmaduras.add( new EscudoDuplo("Escudo Duplo", 40, Tipo.AGUA, TipoEfeito.DEFESA ) );
		efeitosArmaduras.add( new ArmaduraLeve("Armadura Leve", 4, Tipo.VENTO, TipoEfeito.DEFESA ) );
		efeitosArmaduras.add( new ArmaduraMedia("Armadura Media", 12, Tipo.GELO, TipoEfeito.DEFESA ) );
		efeitosArmaduras.add( new ArmaduraPesada("Armadura Pesada", 16, Tipo.DIVINO, TipoEfeito.DEFESA ) );
		efeitosArmaduras.add( new ArmaduraElementalLeve("Armadura ElementalLeve", 10, Tipo.TREVAS, TipoEfeito.DEFESA ) );
		efeitosArmaduras.add( new ArmaduraElementalMedia("Armadura ElementalMedia", 20, Tipo.LUZ, TipoEfeito.DEFESA ) );
		efeitosArmaduras.add( new ArmaduraElementalPesada("Armadura ElementalPesada", 30, Tipo.TERRA, TipoEfeito.DEFESA ) );
		
		
		// Joias
		efeitosJoias.add( new Joia("Amuleto", 5, Tipo.FOGO, TipoEfeito.RANDOM ) );
		efeitosJoias.add( new Joia("Gema", 15, Tipo.LUZ, TipoEfeito.RANDOM ) );
		efeitosJoias.add( new Joia("Pedra Filosofal", 30, Tipo.TREVAS, TipoEfeito.RANDOM ) );
		efeitosJoias.add( new Joia("Anel", 20, Tipo.VENTO, TipoEfeito.RANDOM ) );
		efeitosJoias.add( new Joia("Diamante", 50, Tipo.AGUA, TipoEfeito.RANDOM ) );
		efeitosJoias.add( new Joia("Cristal", 25, Tipo.DIVINO, TipoEfeito.RANDOM ) );
	}
	
	public static void carregarCartas( List<Carta> cartas )
	{
		// Ritual
		cartas.add( new Bruxa( "Floresta Negra", 20, 10, 5, Tipo.TREVAS, 10) );
		cartas.add( new Demonio( "Rei Caveira",	60,	25, 50, Tipo.TREVAS, 10) );
		cartas.add( new Esqueleto( "Bones",	25,	30, 20, Tipo.FOGO, 5) );
		cartas.add( new Fantasma( "Ghost",	10,	45, 18, Tipo.AGUA, 2) );
		cartas.add( new Mago( "Mago Negro",	55,	35, 25, Tipo.TREVAS, 6) );
		
		// Fusao
		cartas.add( new Arqueiro( "Legolas", 30, 25, 20, Tipo.VENTO) );
		cartas.add( new Dragao(	"Blue-eyes", 30, 50, 35, Tipo.FOGO) );
		cartas.add( new Dinossauro(	"Rex de duas cabeças", 45, 15, 10, Tipo.TERRA) );
		cartas.add( new FeraDivina(	"Neos", 78, 60, 40, Tipo.DIVINO) );
		cartas.add( new Monstro( "Neos", 35, 20, 15, Tipo.GELO) );
		
		// Synchro
		cartas.add( new Elfo( "Elfo negro", 35, 25, 20, Tipo.TREVAS) );
		cartas.add( new Harpia(	"Espanador de penas", 25, 50, 35, Tipo.LUZ) );
		cartas.add( new Maquina( "Scrap", 30, 18, 12, Tipo.TERRA) );
		cartas.add( new Psiquico( "Psy", 42, 32, 22, Tipo.FOGO) );
		cartas.add( new Planta( "Rose", 14, 20, 23, Tipo.AGUA) );		
		
		// Xyz
		cartas.add( new Inseto( "Grande Boca", 23, 25, 36, Tipo.VENTO) );
		cartas.add( new Reptil(	"Red-eyes", 15, 25, 35, Tipo.GELO) );
		cartas.add( new BestaAlada(	"Alado de Rá", 5, 15, 25, Tipo.DIVINO) );
		cartas.add( new BestaGuerreira(	"Touro Guerreiro", 15, 25, 35, Tipo.DIVINO) );
		cartas.add( new BestaTensa( "Mamuth", 45, 15, 25, Tipo.TREVAS) );
		
		// Pendulo
		cartas.add( new Anomalo( "Odd-Eyes", 10, 20, 30, Tipo.LUZ) );
		cartas.add( new Abdicacao( "Cegueira dos mil olhos", 40, 20, 30, Tipo.TERRA) );
		cartas.add( new Camarartista( "Poney Pulador", 40, 25, 10, Tipo.FOGO) );
		cartas.add( new Abdutor( "Aguado", 36, 60, 45, Tipo.AGUA) );
		cartas.add( new Fada( "Sensata", 14, 18, 5, Tipo.VENTO) );
		
		// Link
		cartas.add( new Cibernetico( "Decode Talker", 18, 20, 22, Tipo.GELO) );
		cartas.add( new Trovao( "Thunder god", 26, 32, 40, Tipo.DIVINO) );
		cartas.add( new Fenix( "Ikki", 15, 23, 14, Tipo.TREVAS) );
		cartas.add( new Quantico( "Break", 45, 10, 5, Tipo.LUZ) );
		cartas.add( new Espaco( "Photon", 7, 9, 10, Tipo.GELO) );
	}	
}
