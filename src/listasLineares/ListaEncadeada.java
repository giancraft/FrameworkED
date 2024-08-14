package listasLineares;

import nodo.Nodo;
import interfaces.Lista;
import javafx.application.Application;
import desenhoNodo.DesenhoNodo;

/**
 * Classe que representa uma Lista Simplemente Encadeada genérica.
 *
 * @author gianlucamk04@gmail.com
 *
 * @param <T> Tipo de dados armazenados na lista
 */

public class ListaEncadeada<T> implements Lista<T>{
	private Nodo<T> inicio;
	
	/**
     * Construtor que inicializa uma lista encadeada vazia.
     */
	public ListaEncadeada() {
		this.inicio = null;
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
			Nodo<T> novoNodo = new Nodo<T>(value);
			novoNodo.setProx(inicio);
			inicio = novoNodo;
			return true;
		} catch (Exception e) {
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
			if (isEmpty()) {
				addFirst(value);
				return false;
			}
			Nodo<T> novoNodo = new Nodo<T>(value);
			Nodo<T> aux = inicio;
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
	
	/**
     * Retorna uma String com os dados armazenados na lista.
     * 
     * @return retorna a String com os dados armazenados
     */
	@Override
	public String printList() {
		if(isEmpty()) {
			return "";
		}
		Nodo<?> aux = inicio;
		StringBuilder lista = new StringBuilder("[");
		do {
			lista.append(aux.getDado());
			if (aux.getProx() != null) {
				lista.append(", "); 
			} else if (aux.getProx() == null) {
				lista.append("]"); 
			}
			aux = aux.getProx();
		} while (aux != null);
		return lista.toString();
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
		Nodo<?> aux = inicio;
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
		try {
			if (isEmpty()) 
				return false;
			if (inicio.getDado() == value) {
				removeFirst();
				return true;
			}
			Nodo<T> aux = inicio;
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
	
	/**
     * Remove um elemento específico do inicio da lista.
     * 
     * @return true se a foi removido com sucesso, false caso o contrário
     */
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
	
	/**
     * Remove um elemento específico do final da lista.
     * 
     * @return true se a foi removido com sucesso, false caso o contrário
     */
	@Override
	public boolean removeLast() {
		try {
			if (isEmpty()) return false;
			
			if (inicio.getProx() == null) {
				inicio = null;
				return true;
			}
			
			Nodo<T> aux = inicio;
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
	
	/**
     * Busca por um elemento na lista.
     * 
     * @param index Index referente a posição na lista do elemento a ser buscado
     * 
     * @return true se o elemento foi encontrado, false caso contrário
     */
	@Override
	public Object get(int index) {
		if(isEmpty()) {return null;}
		if(index == 0) {
			return inicio.getDado();
		}
		int posicao = 0;
		Nodo<?> aux = inicio;
		do {
			posicao++;
			aux = aux.getProx();
			if (posicao == index) {
				return aux.getDado();
			}
		} while (aux != null);
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
	
	/**
     * Faz um desenho da lista.
     * 
     * @return true se o desenho foi realizado, false caso contrário
     */
	public boolean desenharLista() {
		try {
			DesenhoNodo.setInicio(inicio, false);
	        Application.launch(DesenhoNodo.class);
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
    }
}
