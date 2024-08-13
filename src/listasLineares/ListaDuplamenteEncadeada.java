package listasLineares;

import nodo.NodoDuplo;
import desenhoNodo.DesenhoNodo;
import interfaces.Lista;
import javafx.application.Application;

public class ListaDuplamenteEncadeada<T> extends TipoLista implements Lista<T>{
	private NodoDuplo<T> inicio;
	private NodoDuplo<T> fim;

	@Override
	public boolean addFirst(T value) {
		try {
			NodoDuplo<T> novo = new NodoDuplo<>(value);
			if (!isEmpty()) {
				inicio.setAnt(novo);
				novo.setProx(inicio);
			}
			inicio = novo;
			if (fim == null) {
				fim = novo;
			}
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean addLast(T value) {
		try {
			NodoDuplo<T> novo = new NodoDuplo<>(value);
			if (fim != null) {
				fim.setProx(novo);
				novo.setAnt(fim);
			} 
			fim = novo;
			if (isEmpty())
				inicio = novo;
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean isEmpty() {
		return inicio == null;
	}

	@Override
	public String printList() {
		if(isEmpty()) return "";
		String lista = "[";
		NodoDuplo<?> aux = inicio;
		while (aux != null) {
			if (aux.getProx() != null) {
				lista += aux.getDado() + ", "; 
			} else if (aux.getProx() == null) {
				lista += aux.getDado() + "]"; 
			}
			aux = aux.getProx();
		}
		return lista;
	}

	@Override
	public int size() {
		if(isEmpty()) {
			return 0;
		}
		NodoDuplo<?> aux = inicio;
		int count = 0;
		while (aux != null) {
			count++;
			aux = aux.getProx();
		}
		return count;
	}

	@Override
	public boolean clear() {
		try {
			inicio = null;
			fim = null;
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean remove(T value) {
		if (isEmpty()) return false;
		if (inicio.getDado() == value) {
			removeFirst();
		}
			
		NodoDuplo<T> aux = inicio;
		while (aux != null) {
			if (aux.getDado() == value) {
				if (aux == fim) {
					removeLast();
					return true;
				} else {
					aux.getProx().setAnt(aux.getAnt());
					aux.getAnt().setProx(aux.getProx());
					return true;
				}
			}

			aux = aux.getProx();
		}
		return false;
	}

	@Override
	public boolean removeFirst() {
		try {
			if (isEmpty()) return false;
			
			NodoDuplo<T> nodoRemovido = inicio;
			inicio = inicio.getProx();
			if (inicio != null) {
				inicio.setAnt(null);
			}
			if (nodoRemovido == fim) {
				removeLast();
			}
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean removeLast() {
		try {
			if (fim == null) return false;
			
			NodoDuplo<T> nodoRemovido = fim;
			if (fim != null)
				fim = fim.getAnt();
				fim.setProx(fim.getProx().getProx());
				inicio.setAnt(fim);
			if (nodoRemovido == inicio) {
				removeFirst();
			}
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Object get(int index) {
		if (isEmpty()) return null;
		int posicao = 0;
		if (index == 0)
			return inicio.getDado();
		NodoDuplo<?> aux = inicio;
		while (aux != null) {
			posicao++;
			aux = aux.getProx();
			if (index == posicao)
				return aux.getDado();
		}
		
		return null;
	}

	@Override
	public Object get(T value) {
		if (isEmpty()) return null;
		if (inicio.getDado() == value)
			return inicio.getDado();
		NodoDuplo<?> aux = inicio;
		while (aux != null) {
			if (aux.getDado() == value)
				return aux.getDado();
			aux = aux.getProx();
		}
		
		return null;
	}

	@Override
	public boolean desenharLista() {
		try {
			DesenhoNodo.setInicio(inicio);
	        Application.launch(DesenhoNodo.class);
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
