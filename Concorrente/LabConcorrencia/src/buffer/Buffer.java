package buffer;

import threads.Consumidor;
import threads.Produtor;

public class Buffer {
	
	private int produto;
	private boolean disponivel;
	
	public Buffer() {
		this.produto = 0;
		this.disponivel = true;
	}
	
	public synchronized void adicionaProduto(Produtor produtor, int produto) {
		while(!disponivel){
			try {
				System.out.println(produtor + " esperando...");
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(produtor + " colocou produto #"+ produto);
		this.produto = produto;
		this.disponivel = false;
		this.notify();
	}
	
	 public synchronized void consomeProduto(Consumidor consumidor) {
	    while (disponivel) {
	      try {
	    	System.out.println(consumidor + " esperando...");
	        this.wait();
	      } catch (InterruptedException e) {
	        e.printStackTrace();
	      }
	    }
	    System.out.println(consumidor + " consumiu: produto #"+this.produto);
	    disponivel = true;
	    this.notify();
	  }
}
