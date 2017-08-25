package threads;

import buffer.*;

public class Consumidor extends Operador implements Runnable{
	
	private int totalConsumir;
	private int totalConsumidos;

	public Consumidor(int id, Buffer bufferCompartilhado, int totalConsumir) {
		super(id, bufferCompartilhado);
		setTotalConsumir(totalConsumir);
		this.totalConsumidos = 0;
	}
	
	// GETTERS AND SETTERS

	public int getTotalConsumir() {
		return totalConsumir;
	}

	public void setTotalConsumir(int totalConsumir) {
		this.totalConsumir = totalConsumir;
	}

	@Override
	public void run() {
		
		while(totalConsumidos <= getTotalConsumir()) {
			
			if(bufferCompartilhado.getBuffer() > 0) {
				bufferCompartilhado.getProduto();
				totalConsumidos++;
				System.out.println(toString()+" consumiu produto #"+ bufferCompartilhado.getBuffer());
			}else {
				synchronized(bufferCompartilhado) {
					System.out.println(toString()+" esperando...");
					try {
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
		return "Consumidor #"+getId();
	}
	
	public void start() {
		run();
	}
}
