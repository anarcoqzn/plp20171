package threads;

import buffer.*;

public abstract class Operador {
	
	private long id;
	protected Buffer bufferCompartilhado;
	
	
	public Operador(int id, Buffer bufferCompartilhado) {
		setId(id);
		this.bufferCompartilhado = bufferCompartilhado;
	}
	
	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
