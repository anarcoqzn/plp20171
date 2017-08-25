package threads;

import buffer.*;

public class Consumidor extends Operador implements Runnable{
	
	private int totalConsumir;
	private int totalConsumidos;
	public static Thread consumidor;

	public Consumidor(int id, Buffer bufferCompartilhado, int totalConsumir) {
		super(id, bufferCompartilhado);
		setTotalConsumir(totalConsumir);
		this.totalConsumidos = 0;
		this.consumidor = new Thread();
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
				Produtor.produtor.notify();
			}else {
				System.out.println(toString()+" esperando...");
			}
		}
		System.out.println(toString()+" concluido!");
	}
	
	@Override
	public String toString() {
		return "Consumidor #1"+getId();
	}
	
	public void start() {
		consumidor.start();
		run();
	}
	public void stop() {
		consumidor.stop();
		consumidor = null;
	}
}
