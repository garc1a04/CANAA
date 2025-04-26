package Ordenacao;

public class QuickSort {
	public static void main(String[] args) {
		int vetor[] = {1,2,3,4};
		quickSort(vetor);
		
		for(int i: vetor) {
			System.out.println(i);
		}
	}
	
	public static void quickSort(int[] vetor) {
		quickSort(vetor,0,vetor.length-1);
	}
	
	
	private static void quickSort(int[] vetor,int inicio,int fim) {
		if(inicio <= fim) {
			int part = particao(vetor,inicio,fim);
			
			quickSort(vetor,inicio,part-1);
			quickSort(vetor,part+1,fim);			
		}
	}

	private static int particao(int[] vetor, int inicio, int fim) {
		
		int pivo = vetor[fim];
		int i = inicio-1;
		
		for(int j = inicio; j <= fim-1;j++) {
			if(pivo >= vetor[j]) {
				i++;
				troca(vetor,i,j);
			}
		}
		
		troca(vetor, i+1,fim);
		return i+1;
	}
	
	public static void troca(int vetor[], int i, int j) {
		int aux = vetor[i];
		vetor[i] = vetor[j];
		vetor[j] = aux;
	}
}
