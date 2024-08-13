package factories;

import interfaces.Lista;
import interfaces.ListaFactory;
import listasLineares.ListaCircular;

public class ListaCircularFactory<T> implements ListaFactory<T> {

	@Override
	public Lista<T> criarLista() {
		return new ListaCircular<>();
	}
}
