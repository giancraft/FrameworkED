package listasLineares;

import nodo.NodoDuplo;
import desenhoNodo.DesenhoNodo;
import interfaces.Lista;
import javafx.application.Application;

/**
 * Classe que representa uma Lista Duplamente Encadeada genérica.
 *
 * @author gianlucamk04@gmail.com
 *
 * @param <T> Tipo de dados armazenados na lista
 */

public class ListaDuplamenteEncadeada<T> implements Lista<T>{
	private NodoDuplo<T> inicio;
	private NodoDuplo<T> fim;

	/**
     * Construtor que inicializa uma lista duplamente encadeada vazia.
     */
	public ListaDuplamenteEncadeada() {
		inicio = null;
        fim = null;
	}
	
	/**
     * Adiciona um elemento ao inicio da lista.
     * 
     * @param <T> 
     * 
     * @param value Valor a ser adicionado
     * 
     * @return true se o elemento foi adicionado com sucesso, false caso o contrário
     */
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

	/**
     * Adiciona um elemento ao final da lista.
     * 
     * @param <T> 
     * 
     * @param value Valor a ser adicionado
     * 
     * @return true se o elemento foi adicionado com sucesso, false caso o contrário
     */
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

	/**
     * Retorna se a lista está vazia.
     * 
     * @return true se a lista está vazia, false caso o contrário
     */
	@Override
	public boolean isEmpty() {
		return inicio == null;
	}

	/**
     * Retorna uma String com os dados armazenados na lista.
     * 
     * @return retorna a String com os dados armazenados
     */
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

	/**
     * Retorna o tamanho da lista.
     * 
     * @return Número de elementos na lista
     */
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

	/**
     * Remove todos os elementos da lista.
     * 
     * @return true se a lista foi limpa, false caso o contrário
     */
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

	/**
     * Remove um elemento específico da lista.
     * 
     * @param <T>
     * 
     * @param value Valor a ser removido
     * 
     * @return true se a foi removido com sucesso, false caso o contrário
     */
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

	/**
     * Remove um elemento específico do inicio da lista.
     * 
     * @return true se a foi removido com sucesso, false caso o contrário
     */
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

	/**
     * Remove um elemento específico do final da lista.
     * 
     * @return true se a foi removido com sucesso, false caso o contrário
     */
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

	/**
     * Busca por um elemento na lista.
     * 
     * @param index Index referente a posição na lista do elemento a ser buscado
     * 
     * @return true se o elemento foi encontrado, false caso contrário
     */
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

	/**
     * Busca por um elemento na lista.
     * 
     * @param <T>
     * 
     * @param value Valor a ser buscado
     * 
     * @return true se o elemento foi encontrado, false caso contrário
     */
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

	/**
     * Faz um desenho da lista.
     * 
     * @return true se o desenho foi realizado, false caso contrário
     */
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
