package buffer;

public class Buffer {
	
	private int produto;

	public Buffer() {
		this.produto = 0;
	}

	public boolean isDisponivel() {
		return produto == 0;		
	}
	
	public synchronized void adicionaProduto(int produto) {
		this.produto = produto;
	}
	
	public synchronized int getProduto() {
		int temp = this.produto;
		this.produto--;
		return temp;
	}
	
	public int getBuffer() {
		return this.produto;
	}
}
