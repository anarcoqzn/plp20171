package threads;

import buffer.*;

public class Produtor extends Operador implements Runnable{
	
	private int totalProduzir;
	private int totalProduzidos;

	
	public Produtor(int id, Buffer bufferCompartilhado, int totalProduzir) {
		super(id, bufferCompartilhado);
		setTotalProduzir(totalProduzir);
		this.totalProduzidos = 0;
	}
	
	//GETTTERS AND SETTERS

	public int getTotalProduzir() {
		return totalProduzir;
	}

	public void setTotalProduzir(int totalProduzir) {
		this.totalProduzir = totalProduzir;
	}

	@Override
	public void run() {
		
		while(totalProduzidos <= getTotalProduzir()) {
		
			if(bufferCompartilhado.isDisponivel()) {
				totalProduzidos++;
				bufferCompartilhado.adicionaProduto(totalProduzidos);
				System.out.println(toString()+" colocou produto "+ bufferCompartilhado.getBuffer());
				
			}else {
				synchronized (bufferCompartilhado) {
					try {
						System.out.println(toString()+" esperando...");
						bufferCompartilhado.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
		System.out.println(toString()+" concluido!");
	}
	
	@Override
	public String toString() {
		return "Produtor #"+getId();
	}
	
	public void start() {
		run();
	}
}
