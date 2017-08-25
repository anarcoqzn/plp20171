package threads;

import buffer.*;

public class Produtor extends Operador implements Runnable{
	
	private int totalProduzir;
	private int totalProduzidos;
	public static Thread produtor;
	
	public Produtor(int id, Buffer bufferCompartilhado, int totalProduzir) {
		super(id, bufferCompartilhado);
		setTotalProduzir(totalProduzir);
		this.totalProduzidos = 0;
		produtor = new Thread();
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
				System.out.println(toString()+" esperando...");
				
				try {
					produtor.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
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
		produtor.start();
		run();
	}
	
	@SuppressWarnings("deprecation")
	public void stop() {
		produtor.stop();
		produtor = null;
	}
}
