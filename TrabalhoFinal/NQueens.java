package Paradigmas.Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NQueens {
	public static void main(String[] args) {
		solveNQueens(8);
	}
	
	public static void solveNQueens(int n) {
    	List<List<String>> result = new ArrayList<>();
    	ArrayList<String> tabul = new ArrayList<String>();
    	
    	
    	backQueens(result,tabul,new HashSet<Integer>(),new HashSet<Integer>(), new HashSet<Integer>(),0,n);
    	
    	
		for(String linha : result.get(0)) {
			System.out.println(linha);
		}
		
		System.out.println();
    	
		return;
    }

	private static void backQueens(List<List<String>> result, ArrayList<String> tabul, Set<Integer> rainhasColunas,Set<Integer> diagPrinci,Set<Integer> diagSegund, int linha, int tam) {

		if(linha == tam) {
			result.add(new ArrayList<String>(tabul));
			return;
		}
		
		
		for(int i = 0; i < tam ;i++) {
			
			if(rainhasColunas.contains(i) || diagPrinci.contains(linha-i) || diagSegund.contains(linha+i)) {
				continue;
			}
			
			rainhasColunas.add(i);
			diagPrinci.add(linha-i);
			diagSegund.add(linha+i);
			
			tabul.add(linhaTabul(i,tam));
			
			backQueens(result,tabul,rainhasColunas,diagPrinci, diagSegund, linha+1,tam);
			
			tabul.remove(tabul.size()-1);
			rainhasColunas.remove(i);
			diagPrinci.remove(linha-i);
			diagSegund.remove(linha+i);		
		}
		
	}

	private static String linhaTabul(int localRainha, int tam) {
		
		String aux = "";
		
		for(int i = 0; i < tam;i++) {
			
			if(i == localRainha) {
				aux+= " Q ";
				continue;
			}
			
			aux+= " X ";
		}
		
		return aux;
	}
}
