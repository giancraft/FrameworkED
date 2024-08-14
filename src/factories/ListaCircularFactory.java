package factories;

import interfaces.Lista;
import interfaces.ListaFactory;
import listasLineares.ListaCircular;

/**
 * Classe que representa um Factory para criar Listas Circulares genéricas.
 *
 * @author gianlucamk04@gmail.com
 *
 * @param <T> Tipo de dados armazenados na lista
 */

public class ListaCircularFactory<T> implements ListaFactory<T> {

	/**
     * Cria uma Lista Circular e a retorna.
     * 
     * @return a lista circular criada
     */
	@Override
	public Lista<T> criarLista() {
		return new ListaCircular<>();
	}
}
