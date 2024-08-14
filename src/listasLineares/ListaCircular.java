package listasLineares;

import nodo.Nodo;
import desenhoNodo.DesenhoNodo;
import interfaces.Lista;
import javafx.application.Application;

public class ListaCircular<T> extends TipoLista implements Lista<T> {
    private Nodo<T> inicio;
    private Nodo<T> fim;

    public ListaCircular() {
        inicio = null;
        fim = null;
    }

    @Override
    public boolean addFirst(T value) {
        try {
            Nodo<T> novoNodo = new Nodo<>(value);
            if (inicio == null) { // caso lista esteja vazia
                inicio = novoNodo;
                inicio.setProx(inicio);
                fim = inicio;
            } else { // caso lista não esteja vazia
                novoNodo.setProx(inicio);
                inicio = novoNodo;
                fim.setProx(inicio);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addLast(T value) {
        try {
            Nodo<T> novoNodo = new Nodo<>(value);
            if (inicio == null) {
                inicio = novoNodo;
                inicio.setProx(inicio);
                fim = inicio;
            } else {
                fim.setProx(novoNodo);
                fim = novoNodo;
                fim.setProx(inicio);
            }
            return true;
        } catch (Exception e) {
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
        StringBuilder lista = new StringBuilder("[");
        Nodo<T> aux = inicio;
        do {
            lista.append(aux.getDado());
            aux = (Nodo<T>) aux.getProx();
            if (aux != inicio) {
                lista.append(", ");
            }
        } while (aux != inicio);
        lista.append("]");
        return lista.toString();
    }

    @Override
    public int size() {
        int size = 0;
        if (isEmpty()) return size;
        Nodo<T> aux = inicio;
        do {
            size++;
            aux = (Nodo<T>) aux.getProx();
        } while (aux != inicio);
        return size;
    }

    @Override
    public boolean clear() {
        try {
            inicio = null;
            fim = null;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean remove(T value) {
        try {
            if (isEmpty()) return false;

            if (inicio.getDado().equals(value)) {
                if (inicio == fim) { // se a lista possuir apenas um elemento
                    inicio = null;
                    fim = null;
                    return true;
                }
                // se o elemento for o primeiro da lista e ela possui outros
                removeFirst();
                return true;
            }

            Nodo<T> aux = inicio;
            do {
                if (aux.getProx().getDado().equals(value)) {
                    if (aux.getProx() == fim)
                        fim = aux;
                    aux.setProx(aux.getProx().getProx());
                    return true;
                }
                aux = (Nodo<T>) aux.getProx();
            } while (aux != inicio);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeFirst() {
        try {
            if (isEmpty()) return false;

            if (inicio == fim) { // Se há apenas um elemento na lista
                inicio = null;
                fim = null;
            } else {
                inicio = (Nodo<T>) inicio.getProx();
                fim.setProx(inicio);
            }
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

            if (inicio == fim) { // Se há apenas um elemento na lista
                inicio = null;
                fim = null;
                return true;
            }

            Nodo<T> aux = inicio;
            while (aux.getProx() != fim) {
                aux = (Nodo<T>) aux.getProx();
            }
            fim = aux;
            fim.setProx(inicio);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public T get(int index) {
        if (isEmpty()) return null;

        int posicao = 0;
        Nodo<T> aux = inicio;
        do {
            if (posicao == index) {
                return aux.getDado();
            }
            aux = (Nodo<T>) aux.getProx();
            posicao++;
        } while (aux != inicio);
        return null;
    }

    @Override
    public T get(T value) {
        if (isEmpty()) return null;

        Nodo<T> aux = inicio;
        do {
            if (aux.getDado().equals(value)) {
                return aux.getDado();
            }
            aux = (Nodo<T>) aux.getProx();
        } while (aux != inicio);
        return null;
    }

	@Override
	public boolean desenharLista() {
		try {
			DesenhoNodo.setInicio(inicio, true);
	        Application.launch(DesenhoNodo.class);
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
