package factories;

import interfaces.Lista;
import interfaces.ListaFactory;
import listasLineares.ListaDuplamenteEncadeada;

public class ListaDuplamenteEncadeadaFactory<T> implements ListaFactory<T> {

	@Override
	public Lista<T> criarLista() {
		return new ListaDuplamenteEncadeada<>();
	}
}
