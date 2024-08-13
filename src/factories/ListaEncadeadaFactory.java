package factories;

import interfaces.ListaFactory;
import interfaces.Lista;
import listasLineares.*;

public class ListaEncadeadaFactory<T> implements ListaFactory<T>{

	@Override
	public Lista<T> criarLista() {
		return new ListaEncadeada<>();
	}

	
	
}
