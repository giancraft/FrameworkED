package factories;

import interfaces.ListaFactory;
import interfaces.Lista;
import listasLineares.*;

/**
 * Classe que representa um Factory para criar Listas Encadeadas genéricas.
 *
 * @author gianlucamk04@gmail.com
 *
 * @param <T> Tipo de dados armazenados na lista
 */
public class ListaEncadeadaFactory<T> implements ListaFactory<T>{

	/**
     * Cria uma Lista Encadeada e a retorna.
     * 
     * @return a lista duplamente criada
     */
	@Override
	public Lista<T> criarLista() {
		return new ListaEncadeada<T>();
	}

	
	
}
