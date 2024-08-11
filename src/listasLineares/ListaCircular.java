package listasLineares;

import nodo.Nodo;
import interfaces.Lista;

public class ListaCircular<T> implements Lista<T>{
	private Nodo<?> inicio;
	private Nodo<?> fim;
	
	public ListaCircular() {
		inicio = null;
	}
	
	@Override
	public boolean addFirst(T value) {
		try {
			Nodo<?> novoNodo = new Nodo<>(value);
			if (inicio == null) {// caso lista esteja vazia
				inicio = novoNodo;
				inicio.setProx(inicio);
				fim = inicio;
			}  else {// caso lista não esteja vazia
				novoNodo.setProx(inicio);
				inicio = novoNodo;
				fim.setProx(inicio);
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
			Nodo<?> novoNodo = new Nodo<>(value);
			if (inicio == null) {
				inicio = novoNodo;
				inicio.setProx(inicio);
				fim = inicio;
			} else {
				novoNodo.setProx(inicio);
				while (fim.getProx() != inicio) {
					fim = fim.getProx();
				}
				fim.setProx(novoNodo);
			}
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
		if (isEmpty()) return "";
		String lista = "[";
		Nodo<?> aux = inicio;
		do {
			if (aux.getProx() != inicio) {
				lista += aux.getDado() + ", "; 
			} else if (aux.getProx() == inicio) {
				lista += aux.getDado() + "]"; 
			}
			aux = aux.getProx();
		} while(aux != inicio);
		return lista;
	}

	@Override
	public int size() {
		int size = 0;
		
		if (isEmpty()) {return size;}
		
		Nodo<?> aux = inicio;
		do {
			size++;
			aux = aux.getProx();
		} while (aux != inicio);
		return size;
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
		try {
			if (isEmpty()) return false;
			
			int posicao = 0;
			
			if (index == 0) {
				if(inicio == fim) {// se a lista possuir apenas um elemento
					inicio = null;
					return true;
				}
				// se o elemento for o primeiro da lista e ela possui outros
				inicio = inicio.getProx();
				fim.setProx(inicio);
				return true;
			}
			
			Nodo<?> aux = inicio;
			do {
				if (posicao == index) {
					if (aux.getProx() == fim) 
						fim = aux;
					aux.setProx(aux.getProx().getProx());
					return true;
				}
				posicao++;
				aux = aux.getProx();
			} while (aux != inicio);
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean remove(T value) {
		try {
			if (inicio == null) return false;
			
			if (inicio.getDado() == value) {
				if(inicio == fim) {// se a lista possuir apenas um elemento
					inicio = null;
					return true;
				}
				// se o elemento for o primeiro da lista e ela possui outros
				inicio = inicio.getProx();
				fim.setProx(inicio);
				return true;
			}
			Nodo<?> aux = inicio;
			do {
				if (aux.getProx().getDado() == value) {
					if (aux.getProx() == fim) 
						fim = aux;
					aux.setProx(aux.getProx().getProx());
					return true;
				}
				aux = aux.getProx();
			} while (aux != inicio);
			 return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean removeFirst() {
		try{
			inicio = inicio.getProx();
			fim.setProx(inicio);
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean removeLast() {
		try {
			Nodo<?> aux = inicio;
			do {
				aux = aux.getProx();
			} while (aux.getProx().getProx() != inicio);
			fim = aux;
			fim.setProx(inicio);
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
		Nodo<?> aux = inicio;
		do {
			if (posicao == index) {
				return aux.getDado();
			}
			posicao++;
			aux = aux.getProx();
		} while (aux != inicio);
		return null;
	}

	@Override
	public Object get(T value) {
		if (isEmpty()) return null;
		
		Nodo<?> aux = inicio;
		do {
			if (aux.getDado() == value) {
				return aux.getDado();
			}
			aux = aux.getProx();
		} while (aux != inicio);
		return null;
	}

}
