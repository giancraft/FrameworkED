package nodo;

public class NodoDuplo<T>{
	private T dado;
	private NodoDuplo<T> prox;
	private NodoDuplo<T> ant;
	
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
	public NodoDuplo<T> getProx() {
		return prox;
	}
	public void setProx(NodoDuplo<T> prox) {
		this.prox = prox;
	}
	public NodoDuplo<T> getAnt() {
		return ant;
	}
	public void setAnt(NodoDuplo<T> ant) {
		this.ant = ant;
	}
}
