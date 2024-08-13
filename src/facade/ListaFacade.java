package facade;

import interfaces.*;
import factories.*;

public class ListaFacade<T> implements Lista<T>{
	private Lista<T> lista;
	private ListaFactory<T> circularFactory;
    private ListaFactory<T> duplamenteEncadeadaFactory;
    private ListaFactory<T> encadeadaFactory;

    public ListaFacade() {
        this.circularFactory = new ListaCircularFactory<>();
        this.duplamenteEncadeadaFactory = new ListaDuplamenteEncadeadaFactory<>();
        this.encadeadaFactory = new ListaEncadeadaFactory<>();
    }
    
    public Lista<T> criarListaCircular() {
    	this.lista = circularFactory.criarLista();
        return circularFactory.criarLista();
    }

    public Lista<T> criarListaDuplamenteEncadeada() {
    	this.lista = duplamenteEncadeadaFactory.criarLista();
        return duplamenteEncadeadaFactory.criarLista();
    }

    public Lista<T> criarListaEncadeada() {
    	this.lista = encadeadaFactory.criarLista();
        return encadeadaFactory.criarLista();
    }

	@Override
	public boolean addFirst(T value) {
		return lista.addFirst(value);
	}

	@Override
	public boolean addLast(T value) {
		return lista.addLast(value);
	}

	@Override
	public boolean isEmpty() {
		return lista.isEmpty();
	}

	@Override
	public String printList() {
		return lista.printList();
	}

	@Override
	public int size() {
		return lista.size();
	}

	@Override
	public boolean clear() {
		return lista.clear();
	}

	@Override
	public boolean remove(T value) {
		return lista.remove(value);
	}

	@Override
	public boolean removeFirst() {
		return lista.removeFirst();
	}

	@Override
	public boolean removeLast() {
		return lista.removeLast();
	}

	@Override
	public Object get(int index) {
		return lista.get(index);
	}

	@Override
	public Object get(T value) {
		return lista.get(value);
	}

	@Override
	public boolean desenharLista() {
		return lista.desenharLista();
	}
    
    
}
