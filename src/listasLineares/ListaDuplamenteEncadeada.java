package listasLineares;
import nodo.Nodo;
import nodo.NodoDuplo;
import interfaces.Lista;

public class ListaDuplamenteEncadeada<T> implements Lista<T>{
	private NodoDuplo<?> inicio;
	private NodoDuplo<?> fim;

	@Override
	public boolean addFirst(T value) {
		try {
			NodoDuplo<?> novo = new NodoDuplo<>(value);
			if (inicio != null) {
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
			NodoDuplo<?> novo = new NodoDuplo<>(value);
			if (fim != null) {
				fim.setProx(novo);
				novo.setAnt(fim);
			} 
			fim = novo;
			if (inicio == null)
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
		if(inicio == null) return "";
		String lista = "[";
		NodoDuplo<?> aux = inicio;
		while (aux != null) {
			if (aux.getProx() != null) {
				lista += aux.getDado() + ", "; 
			} else if (aux.getProx() == null) {
				lista += aux.getDado() + "]"; 
			}
			aux = (NodoDuplo<?>) aux.getProx();
		}
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
			fim = null;
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean remove(int index) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(T value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeFirst() {
		try {
			if (inicio == null) return false;
			
			NodoDuplo<?> nodoRemovido = inicio;
			inicio = (NodoDuplo<?>) inicio.getProx();
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
			
			NodoDuplo<?> nodoRemovido = fim;
			if (fim != null)
				fim = (NodoDuplo<?>) fim.getAnt();
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object get(T value) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
