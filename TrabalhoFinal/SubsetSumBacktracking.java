package TrabalhoFinal;

import java.util.ArrayList;
import java.util.List;

public class SubsetSumBacktracking {

	public static void main(String[] args) {
        int[] numeros = {-7, -3, -2, 5,8,-8};
        
        encontrarSubconjuntosComSomaZero(numeros, 0, new ArrayList<>(), 0);
    }

    public static void encontrarSubconjuntosComSomaZero(int[] numeros, int indice, List<Integer> atual, int somaAtual) {
        
    	if (somaAtual == 0 && !atual.isEmpty()) {
            System.out.println("RESULTADO: "+atual);
        }
        
        if (indice == numeros.length) {
            return;
        }

        for(int i = indice; i < numeros.length;i++) {
        	atual.add(numeros[i]);
        	System.out.println("Subconjunto atual: " + atual + " | Soma: " + (somaAtual+atual.get(atual.size()-1)));
        	encontrarSubconjuntosComSomaZero(numeros, i + 1, atual, somaAtual + numeros[i]);
        	atual.remove(atual.size()-1);
        }
    }
}