package Paradigmas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CaixeiroViajante {
	public static void main(String[] args) {
		
		List<Cidade> cidades = Arrays.asList(
			    new Cidade("A", 5, 25),
			    new Cidade("B", 15, 5),
			    new Cidade("C", 25, 20),
			    new Cidade("D", 10, 30),
			    new Cidade("E", 20, 10),
			    new Cidade("F", 35, 25),
			    new Cidade("G", 40, 10),
			    new Cidade("H", 30, 35),
			    new Cidade("I", 45, 5),
			    new Cidade("J", 50, 30)
			);
		

		System.out.println(caixeiroViajante(cidades));
	}
	
	public static List<Cidade> caixeiroViajante(List<Cidade> cidades) {

		List<List<Cidade>> conjuntos = new ArrayList<List<Cidade>>();
		possivelSolucoes(cidades, new ArrayList<Cidade>(),conjuntos, 0);
		List<Cidade> resultado = null;
		
		int menor = -1;
		
		
		for(int i = 0; i < conjuntos.size();i++) {
			int distancia = 0;
			
			cidades = conjuntos.get(i);
			for(int j = 0; j < cidades.size()-1;j++) {
				Cidade obj1 = cidades.get(j);
				Cidade obj2 = cidades.get(j+1);
				
				distancia += obj1.distanciaEuclidiana(obj2);
			}
			
			distancia += cidades.get(cidades.size() - 1).distanciaEuclidiana(cidades.get(0));
			
			
			if(distancia < menor || i == 0) {
				menor = distancia;
				resultado = cidades;
			}
		}
		
		
		
		for(int j = 0; j < resultado.size()-1;j++) {
			Cidade obj1 = resultado.get(j);
			Cidade obj2 = resultado.get(j+1);
			
			
			System.out.print(obj1);
			System.out.print(" -"+obj1.distanciaEuclidiana(obj2)+"-> ");
		}
		System.out.print(resultado.get(resultado.size() - 1));
		System.out.print(" -"+resultado.get(resultado.size() - 1).distanciaEuclidiana(resultado.get(0))+"-> ");
		System.out.print(resultado.get(0));
		System.out.println();
		
		System.out.println("Distancia total: "+ menor);
		
		return resultado;
	}

	private static void possivelSolucoes(List<Cidade> cidades, ArrayList<Cidade> permutacoes, List<List<Cidade>> conjuntos,int index) {	
		
		if(permutacoes.size() == cidades.size()) {
			conjuntos.add(new ArrayList<Cidade>(permutacoes));
			return;
		}
		
		for(int i = index; i < cidades.size();i++) {
			
			Cidade cidade = cidades.get(i);
			
			if(permutacoes.contains(cidade)) {
				continue;
			}
			
			permutacoes.add(cidades.get(i));
			possivelSolucoes(cidades, permutacoes,conjuntos, index);
			permutacoes.remove(permutacoes.size()-1);
		}
	}
}

class Cidade {
	
	private String nome;
	private int x;
	private int y;
	
	public Cidade(String nome,int x, int y) {
		setNome(nome);
		setX(x);
		setY(y);
	}
	
	public int distanciaEuclidiana(Cidade cidade) {
		double dx = cidade.getX() - getX();
		double dy = cidade.getY() - getY();

		return  (int) Math.sqrt(dx * dx + dy * dy);
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String toString() {
		return getNome();
	}
}
