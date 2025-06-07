package Paradigmas.PD;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KnapsackIlimitado {
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
					dp[i][j] = Math.max(dp[i-1][j], cano.getPreco() + dp[i][j - cano.getPeso()]);
				}
				
			}
		}
		
		
		dpMatriz(dp);
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
		 	int i = objetos.size();
		    int j = capacidade;

		    while (j > 0 && i > 0) {
		        Objeto2 obj = objetos.get(i - 1);
		        
		        if (obj.getPeso() <= j && dp[i][j] == obj.getPreco() + dp[i][j - obj.getPeso()]) {
		            System.out.println(obj);
		            j -= obj.getPeso();
		            continue;
		        }
		        
		        
		        i--;
		    }
	}
	
}