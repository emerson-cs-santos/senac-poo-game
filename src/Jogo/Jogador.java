package Jogo;
import java.util.Scanner;

public class Jogador 
{
	private String nome;
	
	// Construtor
	public Jogador (int numJogador)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Digite o nome do jogador " + numJogador + ":");
		
		String nomeJogador = input.nextLine();
		
		if (nomeJogador.isEmpty())
		{
			nomeJogador = "Jogador " + numJogador;
		}
		
		this.nome = nomeJogador;
	}	
	
	public String retornarNome()
	{
		return this.nome;
	}
}
