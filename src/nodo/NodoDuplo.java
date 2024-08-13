package nodo;

public class NodoDuplo<T>{
	private T dado;
	private NodoDuplo<?> prox;
	private NodoDuplo<?> ant;
	
	public NodoDuplo(T dado) {
		this.dado = dado;
		this.prox = null;
		this.ant = null;
	}
	
	public T getDado() {
		return dado;
	}
	public void setDado(T dado) {
		this.dado = dado;
	}
	public NodoDuplo<?> getProx() {
		return prox;
	}
	public void setProx(NodoDuplo<?> prox) {
		this.prox = prox;
	}
	public NodoDuplo<?> getAnt() {
		return ant;
	}
	public void setAnt(NodoDuplo<?> ant) {
		this.ant = ant;
	}
}
