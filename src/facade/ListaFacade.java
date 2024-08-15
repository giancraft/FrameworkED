package facade;

import interfaces.*;
import factories.*;

/**
 * Classe que representa um Facade para manipular as Listas Lineares genéricas.
 *
 * @author gianlucamk04@gmail.com
 *
 * @param <T> Tipo de dados armazenados na lista
 */
public class ListaFacade<T> implements Lista<T>{
	private Lista<T> lista;
	private ListaFactory<T> circularFactory;
    private ListaFactory<T> duplamenteEncadeadaFactory;
    private ListaFactory<T> encadeadaFactory;

    /**
     * Construtor que inicializa as Factories das listas lineares.
     */
    public ListaFacade() {
        this.circularFactory = new ListaCircularFactory<>();
        this.duplamenteEncadeadaFactory = new ListaDuplamenteEncadeadaFactory<>();
        this.encadeadaFactory = new ListaEncadeadaFactory<>();
    }
    
    /**
     * Retorna a lista que foi armazenada na variável lista.
     * 
     * @return a lista armazenada 
     */
    public Lista<T> getLista() {
		return lista;
	}

    /**
     * Cria uma Lista Circular e armazena na variável lista.
     * 
     * @return a lista circular criada
     */
	public Lista<T> criarListaCircular() {
    	this.lista = circularFactory.criarLista();
        return circularFactory.criarLista();
    }

	/**
     * Cria uma Lista Duplamente Encadeada e armazena na variável lista.
     * 
     * @return a lista duplamente encadeada criada
     */
    public Lista<T> criarListaDuplamenteEncadeada() {
    	this.lista = duplamenteEncadeadaFactory.criarLista();
        return duplamenteEncadeadaFactory.criarLista();
    }

    /**
     * Cria uma Lista Encadeada e armazena na variável lista.
     * 
     * @return a lista encadeada criada
     */
    public Lista<T> criarListaEncadeada() {
    	this.lista = encadeadaFactory.criarLista();
        return encadeadaFactory.criarLista();
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
		return lista.addFirst(value);
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
		return lista.addLast(value);
	}

	/**
     * Retorna se a lista está vazia.
     * 
     * @return true se a lista está vazia, false caso o contrário
     */
	@Override
	public boolean isEmpty() {
		return lista.isEmpty();
	}

	/**
     * Retorna uma String com os dados armazenados na lista.
     * 
     * @return retorna a String com os dados armazenados
     */
	@Override
	public String printList() {
		return lista.printList();
	}

	/**
     * Retorna o tamanho da lista.
     * 
     * @return Número de elementos na lista
     */
	@Override
	public int size() {
		return lista.size();
	}

	/**
     * Remove todos os elementos da lista.
     * 
     * @return true se a lista foi limpa, false caso o contrário
     */
	@Override
	public boolean clear() {
		return lista.clear();
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
		return lista.remove(value);
	}

	/**
     * Remove um elemento específico do inicio da lista.
     * 
     * @return true se a foi removido com sucesso, false caso o contrário
     */
	@Override
	public boolean removeFirst() {
		return lista.removeFirst();
	}

	/**
     * Remove um elemento específico do final da lista.
     * 
     * @return true se a foi removido com sucesso, false caso o contrário
     */
	@Override
	public boolean removeLast() {
		return lista.removeLast();
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
		return lista.get(index);
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
		return lista.get(value);
	}

	/**
     * Faz um desenho da lista.
     * 
     * @return true se o desenho foi realizado, false caso contrário
     */
	@Override
	public boolean desenharLista() {
		return lista.desenharLista();
	} 
}
