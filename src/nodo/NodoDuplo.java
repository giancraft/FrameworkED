package nodo;

public class NodoDuplo<T> extends Nodo<T>{
	private Nodo<?> ant;
	
	public NodoDuplo(T dado) {
		super(dado);
		super.setProx(null);
		this.ant = null;
	}

	public Nodo<?> getAnt() {
		return ant;
	}

	public void setAnt(Nodo<?> ant) {
		this.ant = ant;
	}
}
