package Ordenacao;

public class HeapSort {
	public static void main(String[] args) {
		int vetor[] = {10,3,4,5,7,43,4,6,8,6,3,3};
		vetor = heapSort(vetor);
		
		for(int i: vetor) {
			System.out.print(i+" ");
		}
	}
	
	public static int[] heapSort(int vetor[]) {
		vetor = maxHeap(vetor,vetor.length);
		
		int size = vetor.length-1;
		for(int i = size; i >= 0;i--) {
			trocaValores(vetor, i, 0);
			vetor = maxHeap(vetor,i);
		}
		
		return vetor;
	}

	private static int[] maxHeap(int[] vetor,int size) {
		int meio = (size/2) - 1;
		
		for(int i = meio; i >= 0; i--) {
			trocaNodes(vetor,i,size);
		}
		
		return vetor;
	}
	
	private static void trocaNodes(int[] vetor, int i,int size) {
		int left = childLeft(i);
		int right = childRight(i);
		int maior = i;
		
		if(left < size && vetor[left] > vetor[maior]) {
			maior = left;
		}
		
		if(right < size && vetor[right] > vetor[maior]) {
			maior = right;
		}
		
		if(maior != i) {
			trocaValores(vetor,maior,i);
			trocaNodes(vetor,maior,size);
		}	
	}
	
	private static int childLeft(int i) {
		return (i*2)+1;
	}

	private static int childRight(int i) {
		return (i*2)+2;
	}
	
	public static void trocaValores(int vetor[], int i, int j) {
		int aux = vetor[i];
		vetor[i] = vetor[j];
		vetor[j] = aux;
	}
}