package threads;

import buffer.*;

public class Consumidor extends Thread{
	
	private int totalConsumir;
	private int totalConsumidos;
	private Buffer bufferCompartilhado;
	private int iD;

	public Consumidor(int id, Buffer bufferCompartilhado, int totalConsumir) {
		super();
		this.iD = id;
		this.bufferCompartilhado = bufferCompartilhado;
		this.totalConsumir = totalConsumir;
		this.totalConsumidos = 0;
	}

	@Override
	public void run() {
		while(totalConsumidos < totalConsumir){
			bufferCompartilhado.consomeProduto(this);
			totalConsumidos++;
		}
		System.out.println(toString()+" concluido!");
	}
	
	@Override
	public String toString() {
		return "Consumidor #"+this.iD;
	}
}
