package nodo;

public class Nodo<T> {
	private T dado;
	private Nodo<T> prox;

	public Nodo(T dado) {
		this.prox = null;
		this.dado = dado;
	}
	
	public Nodo<T> getProx() {
		return prox;
	}
	public void setProx(Nodo<T> inicio) {
		this.prox = inicio;
	}
	public T getDado() {
		return dado;
	}
	public void setDado(T dado) {
		this.dado = dado;
	}
}
