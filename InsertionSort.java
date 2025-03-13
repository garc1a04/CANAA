package Exercicios;

public class Main {
	
	public static void main(String[] args) {
		int vetor[] = {12,8,4,6,42,1}; // n = 4
		
		
		for(int i: insertionSort(vetor))
			System.out.println(i);
	}

	private static int[] insertionSort(int[] vetor) {
		
		for(int i = 1; i < vetor.length;i++) {
			
			int valor = vetor[i];
			
			int j = i-1;
			
			while(j >= 0 && valor < vetor[j]) {
				vetor[j+1] = vetor[j];
				j--;
			}
			
			vetor[j+1] = valor;
		}
		
		return vetor;
	}
	
	
	
	
	
}
