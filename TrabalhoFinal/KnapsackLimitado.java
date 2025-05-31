package Paradigmas.PD;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KnapsackLimitado {
	static Integer memo[][];
	
	public static void main(String[] args) {
		List<Objeto> objetos = Arrays.asList(
			    new Objeto("Livro", 3, 8),
			    new Objeto("Notebook", 4, 10),
			    new Objeto("Câmera", 2, 5),
			    new Objeto("Garrafa Térmica", 1, 3),
			    new Objeto("Headset", 2, 4),
			    new Objeto("Tablet", 3, 6)
		);
		
		int capacidade = 10;
		memo = new Integer[objetos.size()+1][capacidade+1];
		
		System.out.println("Valor total: R$"+ mochila(objetos,capacidade,0,0)+"\n");
		itensMochila(objetos,capacidade);
	}
	
	public static int mochila(List<Objeto> objetos, int capacidade, int i, int valor) {
		if(capacidade == 0 || i >= objetos.size()) return 0;
		
		Objeto obj = objetos.get(i);
		
		if(memo[i][capacidade] != null) {
			return memo[i][capacidade];
		}
		
		int pegar = mochila(objetos,capacidade,i+1,valor);
		
		int notPegar = 0;
		
		if(obj.getPeso() <= capacidade) {
			notPegar = obj.getPreco() + mochila(objetos,capacidade-obj.getPeso(),i+1,valor);
		}
		
		memo[i][capacidade] = Math.max(pegar, notPegar);
		
		return memo[i][capacidade];
	}
	
	public static void itensMochila(List<Objeto> objetos, int capacidade) {
		
		int i = 0;
		while (i++ < objetos.size()-1 && capacidade > 0) {
			if (memo[i][capacidade] != memo[i + 1][capacidade]) {
		        System.out.println(objetos.get(i));
		        capacidade -= objetos.get(i).getPeso();
		    }
		}
		
		
	}
	
}

class Objeto {
	
	private String nome;
	private int peso;
	private int preco;
	
	
	public Objeto(String nome, int peso, int preco) {
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
