package interfaces;

/**
 * Interface a ser implementada pelas factories.
 *
 * @author gianlucamk04@gmail.com
 *
 * @param <T> Tipo de dados armazenados na lista
 */
public interface ListaFactory<T> {
	
	/**
     * Cria uma Lista e a retorna.
     * 
     * @return a lista criada
     */
	public Lista<T> criarLista();
}
