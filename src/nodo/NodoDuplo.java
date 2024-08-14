package nodo;

/**
 * Classe que representa um Nodo de Listas Duplamente Encadeadas genéricas.
 *
 * @author gianlucamk04@gmail.com
 *
 * @param <T> Tipo de dados armazenados na lista
 */
public class NodoDuplo<T>{
	private T dado;
	private NodoDuplo<T> prox;
	private NodoDuplo<T> ant;
	
	/**
     * Construtor que inicializa um nodo com um dado.
     * 
     * @param <T>
     * 
     * @param dado Dado a ser armazenado no nodo
     */
	public NodoDuplo(T dado) {
		this.dado = dado;
		this.prox = null;
		this.ant = null;
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
	
	/**
     * Retorna o próximo nodo que está armazenado na lista.
     * 
     * @return o próximo nodo da lista 
     */
	public NodoDuplo<T> getProx() {
		return prox;
	}
	
	/**
     * Armazena qual o próximo nodo a ser armazenado na lista.
     * 
     * @param <T>
     * 
     * @param nodo Nodo que será o próximo na lista
     */
	public void setProx(NodoDuplo<T> prox) {
		this.prox = prox;
	}
	
	/**
     * Retorna o nodo anterior a este que está armazenado na lista.
     * 
     * @return o nodo anterior a este da lista 
     */
	public NodoDuplo<T> getAnt() {
		return ant;
	}
	
	/**
     * Armazena qual o nodo anterior a este a ser armazenado na lista.
     * 
     * @param <T>
     * 
     * @param nodo Nodo que será o anterior a este na lista
     */
	public void setAnt(NodoDuplo<T> ant) {
		this.ant = ant;
	}
}
