package nodo;

/**
 * Classe que representa um Nodo de Listas Simplemente Encadeadas genéricas.
 *
 * @author gianlucamk04@gmail.com
 *
 * @param <T> Tipo de dados armazenados na lista
 */
public class Nodo<T> {
	private T dado;
	private Nodo<T> prox;

	/**
     * Construtor que inicializa um nodo com um dado.
     * 
     * @param <T>
     * 
     * @param dado Dado a ser armazenado no nodo
     */
	public Nodo(T dado) {
		this.prox = null;
		this.dado = dado;
	}
	
	/**
     * Retorna o próximo nodo que está armazenado na lista.
     * 
     * @return o próximo nodo da lista 
     */
	public Nodo<T> getProx() {
		return prox;
	}
	
	/**
     * Armazena qual o próximo nodo a ser armazenado na lista.
     * 
     * @param <T>
     * 
     * @param nodo Nodo que será o próximo na lista
     */
	public void setProx(Nodo<T> nodo) {
		this.prox = nodo;
	}
	
	/**
     * Retorna o dado que está armazenado no nodo específico.
     * 
     * @return o dado que está armazenado no nodo 
     */
	public T getDado() {
		return dado;
	}
	
	/**
     * Armazena o dado no respectivo nodo.
     * 
     * @param <T>
     * 
     * @param dado Dado a ser armazenado no nodo
     */
	public void setDado(T dado) {
		this.dado = dado;
	}
}
