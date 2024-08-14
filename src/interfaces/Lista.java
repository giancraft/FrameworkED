package interfaces;

/**
 * Interface a ser implementada pelas Listas.
 *
 * @author gianlucamk04@gmail.com
 *
 * @param <T> Tipo de dados armazenados na lista
 */
public interface Lista<T> {
	
	/**
     * Adiciona um elemento ao inicio da lista.
     * 
     * @param <T> 
     * 
     * @param value Valor a ser adicionado
     * 
     * @return true se o elemento foi adicionado com sucesso, false caso o contrário
     */
	public boolean addFirst(T value);
	
	/**
     * Adiciona um elemento ao final da lista.
     * 
     * @param <T> 
     * 
     * @param value Valor a ser adicionado
     * 
     * @return true se o elemento foi adicionado com sucesso, false caso o contrário
     */
	public boolean addLast(T value);
	
	/**
     * Retorna se a lista está vazia.
     * 
     * @return true se a lista está vazia, false caso o contrário
     */
	public boolean isEmpty();
	
	/**
     * Retorna uma String com os dados armazenados na lista.
     * 
     * @return retorna a String com os dados armazenados
     */
	public String printList();
	
	/**
     * Retorna o tamanho da lista.
     * 
     * @return Número de elementos na lista
     */
	public int size();
	
	/**
     * Remove todos os elementos da lista.
     * 
     * @return true se a lista foi limpa, false caso o contrário
     */
	public boolean clear();
	
	/**
     * Remove um elemento específico da lista.
     * 
     * @param <T>
     * 
     * @param value Valor a ser removido
     * 
     * @return true se a foi removido com sucesso, false caso o contrário
     */
	public boolean remove(T value);
	
	/**
     * Remove um elemento específico do inicio da lista.
     * 
     * @return true se a foi removido com sucesso, false caso o contrário
     */
	public boolean removeFirst();
	
	/**
     * Remove um elemento específico do final da lista.
     * 
     * @return true se a foi removido com sucesso, false caso o contrário
     */
	public boolean removeLast();
	
	/**
     * Busca por um elemento na lista.
     * 
     * @param index Index referente a posição na lista do elemento a ser buscado
     * 
     * @return true se o elemento foi encontrado, false caso contrário
     */
	public Object get(int index);
	
	/**
     * Busca por um elemento na lista.
     * 
     * @param <T>
     * 
     * @param value Valor a ser buscado
     * 
     * @return true se o elemento foi encontrado, false caso contrário
     */
	public Object get(T value);
	
	/**
     * Faz um desenho da lista.
     * 
     * @return true se o desenho foi realizado, false caso contrário
     */
	public boolean desenharLista();
}
