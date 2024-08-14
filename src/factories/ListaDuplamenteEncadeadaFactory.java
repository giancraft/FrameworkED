package factories;

import interfaces.Lista;
import interfaces.ListaFactory;
import listasLineares.ListaDuplamenteEncadeada;

/**
 * Classe que representa um Factory para criar Listas Duplamente Encadeadas genéricas.
 *
 * @author gianlucamk04@gmail.com
 *
 * @param <T> Tipo de dados armazenados na lista
 */
public class ListaDuplamenteEncadeadaFactory<T> implements ListaFactory<T> {

	/**
     * Cria uma Lista Duplamente Encadeada e a retorna.
     * 
     * @return a lista duplamente encadeada criada
     */
	@Override
	public Lista<T> criarLista() {
		return new ListaDuplamenteEncadeada<>();
	}
}
