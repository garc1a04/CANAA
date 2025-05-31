package Paradigmas.Gulosos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CasaDePraia {
	public static void main(String[] args) {
		List<PDF> arquivos = Arrays.asList(
				new PDF("A",100,30),
				new PDF("B",10,5),
				new PDF("C",56,10),
				new PDF("D",32,4),
				new PDF("E",150,99)
		);
		
		System.out.println(arquivosPendrive(99,arquivos));
	}
	
	
	public static List<PDF> arquivosPendrive(int capacidade, List<PDF> arquivos) {
		List<PDF> pendrive = new ArrayList<>();
		
		arquivos.sort(Comparator.comparingDouble(PDF::getRazao).reversed());
		
		
		for(int i = 0; i < arquivos.size();i++){
			PDF obj = arquivos.get(i);
			
			
			if(obj.getPeso() > capacidade) {
				continue;
			}
			
			capacidade -= obj.getPeso();
			pendrive.add(obj);
		}
		
		
		return pendrive;
	}
}

class PDF {
	
	private String nome;
	private int	paginas;
	private int peso;
	
	public PDF(String nome,int	paginas,int peso) {
		setNome(nome);
		setPaginas(paginas);
		setPeso(peso);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	public double getRazao() {
		double valor = (getPaginas()/(getPeso()+0.0))*100;
		return Math.round(valor)/100.0;
	}
	
	public String toString() {
		return "nome: "+ getNome()+" | "+"páginas: "+getPaginas();
	}
}
	