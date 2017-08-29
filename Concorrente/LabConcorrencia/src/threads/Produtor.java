package threads;

import buffer.*;

public class Produtor extends Thread{
	
	private int totalProduzir;
	private int totalProduzidos;
	private Buffer bufferCompartilhado;
	private int iD;

	
	public Produtor(int id, Buffer bufferCompartilhado, int totalProduzir) {
		super();
		this.iD = id;
		this.totalProduzir = totalProduzir;
		this.bufferCompartilhado = bufferCompartilhado;
		this.totalProduzidos = 0;
	}
	@Override
	public void run() {
		while(totalProduzidos < totalProduzir) {
			totalProduzidos++;
			bufferCompartilhado.adicionaProduto(this,totalProduzidos);
		}
		System.out.println(toString()+" concluido!");
	}
	
	@Override
	public String toString() {
		return "Produtor #"+this.iD;
	}
}
