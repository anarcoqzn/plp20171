package buffer;

public class Buffer {
	
	private int produto;
	
	public Buffer() {
		this.produto = 0;
	}

	public boolean isDisponivel() {
		return produto == 0;		
	}
	
	public void adicionaProduto(int produto) {
		synchronized (this) {
			this.produto = produto;	
			notify();
		}
	}
	
	public int getProduto() {
		int temp = 0;
		synchronized (this) {
			temp = this.produto;
			this.produto = 0;
			notify();
		}
		return temp;
	}
	
	public int getBuffer() {
		return this.produto;
	}
}
