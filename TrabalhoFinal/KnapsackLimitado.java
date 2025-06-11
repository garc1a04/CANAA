package TrabalhoFinal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KnapsackLimitado {
	static Integer memo[][];
	
	public static void main(String[] args) {
		List<Objeto2> objetos = Arrays.asList(
			    new Objeto2("Livro", 3, 8),
			    new Objeto2("Notebook", 4, 10),
			    new Objeto2("Câmera", 2, 5),
			    new Objeto2("Garrafa Térmica", 1, 3),
			    new Objeto2("Headset", 2, 4),
			    new Objeto2("Tablet", 3, 6)
		);
		
		int capacidade = 10;
		System.out.println("Valor total: R$"+ mochila(objetos,capacidade)+"\n");
	}
	
	public static int mochila(List<Objeto2> objetos, int capacidade) {
		int[][] dp = new int[objetos.size()+1][capacidade+1];
		
		for(int i = 1; i <= objetos.size();i++) {
			Objeto2 cano = objetos.get(i-1);
			
			for(int j = 0; j <= capacidade;j++) {
				
				if(cano.getPeso() <= j) {
					dp[i][j] = Math.max(dp[i-1][j], cano.getPreco() + dp[i-1][j - cano.getPeso()]);
					
					dpMatriz(dp);
					System.out.println();
					
					if (dp[i-1][j] != dp[i][j]) {
						System.out.print("Escolha: ");
						System.out.println(objetos.get(i-1)+"\n");						
					}
				}
				
			}
		}
		
		
		//dpMatriz(dp);
		itensMochila(objetos, capacidade, dp);
		return dp[objetos.size()][capacidade];
	}
	
	private static void dpMatriz(int[][] dp) {

		for(int i = 0; i < dp.length;i++) {
			for(int j = 0; j < dp[0].length;j++) {
				System.out.print(dp[i][j]+" ");
			}
			
			System.out.println();
		}
		
	}

	public static void itensMochila(List<Objeto2> objetos, int capacidade, int[][] dp) {
		
		int i = 0;
		while (i < objetos.size()-1 && capacidade > 0) {
			
			if (dp[i][capacidade] != dp[i + 1][capacidade]) {
		        System.out.println(objetos.get(i));
		        capacidade -= objetos.get(i).getPeso();
		    }
			
			i++;
		}
	}
	
}

class Objeto2 {
	
	private String nome;
	private int peso;
	private int preco;
	
	
	public Objeto2(String nome, int peso, int preco) {
		setNome(nome);
		setPeso(peso);
		setPreco(preco);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	public int getPreco() {
		return preco;
	}
	public void setPreco(int preco) {
		this.preco = preco;
	}
	
	public String toString() {
		return "nome: "+ getNome()+ " | " +"Preço: R$"+ getPreco();
	}
}
