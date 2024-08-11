package listasLineares;

import nodo.Nodo;
import interfaces.Lista;

public class ListaEncadeada <T> implements Lista<T>{
	private Nodo<?> inicio;
	
	@Override
	public boolean isEmpty() {
		return inicio == null;
	}
	
	@Override
	public boolean addFirst(T value) {
		try {
			Nodo<T> novoNodo = new Nodo<T>(value);
			novoNodo.setProx(inicio);
			inicio = novoNodo;
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	@Override
	public boolean addLast(T value) {
		try {
			if (isEmpty()) {
				addFirst(value);
				return false;
			}
			Nodo<T> novoNodo = new Nodo<T>(value);
			Nodo<?> aux = inicio;
			while (aux.getProx() != null) {
				aux = aux.getProx();
			}
			aux.setProx(novoNodo);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public String printList() {
		if(isEmpty()) {
			return "";
		}
		Nodo<?> aux = inicio;
		String lista = "[";
		do {
			if (aux.getProx() != null) {
				lista += aux.getDado() + ", "; 
			} else if (aux.getProx() == null) {
				lista += aux.getDado() + "]"; 
			}
			aux = aux.getProx();
		} while (aux != null);
		return lista;
	}
	
	@Override
	public int size() {
		if(isEmpty()) {
			return 0;
		}
		Nodo<?> aux = inicio;
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
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean remove(T value) {
		try {
			if (isEmpty()) 
				return false;
			if (inicio.getDado() == value) {
				inicio = inicio.getProx();
				return true;
			}
			Nodo<?> aux = inicio;
			while (aux.getProx() != null) {
				if (aux.getProx().getDado() == value) {
					aux.setProx(aux.getProx().getProx());
					return true;
				}
				aux = aux.getProx();
			}
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean remove(int index) {
		return false;
	}
	
	@Override
	public boolean removeFirst() {
		try {
			inicio = inicio.getProx();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean removeLast() {
		try {
			if (isEmpty()) return false;
			
			if (inicio.getProx() == null) {
				inicio = null;
				return true;
			}
			
			Nodo<?> aux = inicio;
			while (aux.getProx() != null) {
				aux = aux.getProx();
				if(aux.getProx().getProx() == null) {
					aux.setProx(aux.getProx().getProx());
				}
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public Object get(int index) {
		if(isEmpty()) {return null;}
		if(inicio.getProx() == null) {
			return inicio.getDado();
		}
		int posicao = 0;
		Nodo<?> aux = inicio;
		do {
			if (posicao == index) {
				return aux.getDado();
			}
			posicao++;
			aux = aux.getProx();
		} while (aux != null);
		return null;
	}
	
	@Override
	public Object get(T value) {
		if(isEmpty()) {return null;}
		Nodo<?> aux = inicio;
		do {
			if (aux.getDado() == value) {
				return aux.getDado();
			}
			aux = aux.getProx();
		} while (aux != null);
		return null;
		
	}
}
