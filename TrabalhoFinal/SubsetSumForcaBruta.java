package TrabalhoFinal;

import java.util.ArrayList;
import java.util.List;

public class SubsetSumForcaBruta {

	public static void main(String[] args) {
        int[] numeros = { -7, -3, -2, 5, 8 };
        
        List<List<Integer>> subconjuntos = conjuntos(numeros); //O(2^N)
        
        List<List<Integer>> subconjuntosZero = new ArrayList<>();
        
        for (List<Integer> subconjunto : subconjuntos) {
            int soma = 0;
            for (int num : subconjunto) {
                soma += num;
            }
            
            System.out.println("Subconjunto atual: " + subconjunto + " | Soma: " + soma);
           
            if (soma == 0) {
                subconjuntosZero.add(subconjunto);
            }
        }
        // Mostrar o resultado final
        System.out.println("\nSubconjuntos que somam zero:");
        for (List<Integer> subconjunto : subconjuntosZero) {
            System.out.println(subconjunto);
        }
    }
	
	private static List<List<Integer>> conjuntos(int[] numeros) {
		List<List<Integer>> subconjuntos = new ArrayList<>();
        subconjuntos.add(new ArrayList<>());
        for (int num : numeros) { // N
            List<List<Integer>> novosSubconjuntos = new ArrayList<>();
            for (List<Integer> subconjunto : subconjuntos) { //N
                List<Integer> novoSubconjunto = new ArrayList<>(subconjunto);
                novoSubconjunto.add(num);
                novosSubconjuntos.add(novoSubconjunto);
            }
            subconjuntos.addAll(novosSubconjuntos);
        }
        subconjuntos.removeIf(List::isEmpty);
		return subconjuntos;
	}
}