package main;

import listasLineares.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		LinkedList<Integer> listaa = new LinkedList<>();
		ListaEncadeada<Integer> lista = new ListaEncadeada<>();
		ListaCircular<Integer> listaCirc = new ListaCircular<>();
		ListaDuplamenteEncadeada<Integer> listaDupla = new ListaDuplamenteEncadeada<>();
		
		/*lista.addFirst(3);
		lista.addFirst(2);
		lista.addFirst(1);
		
		System.out.println(lista.printList());
		System.out.println(lista.get(1));
		lista.clear();
		System.out.println(lista.printList());
		lista.addLast(5);
		lista.addLast(6);
		lista.addLast(7);
		System.out.println(lista.printList());
		System.out.println(lista.get(0));
		System.out.println(lista.size());*/
		
		/*listaCirc.addFirst(3);
		listaCirc.addFirst(2);
		listaCirc.addFirst(1);
		listaCirc.removeLast();
		//listaCirc.remove(2);
		
		System.out.println(listaCirc.printList());
		System.out.println(listaCirc.get(1));
		listaCirc.clear();
		System.out.println(listaCirc.printList());
		listaCirc.addLast(5);
		listaCirc.addLast(6);
		listaCirc.addLast(7);
		System.out.println(listaCirc.printList());
		System.out.println(listaCirc.size());*/
		
		listaDupla.addFirst(3);
		listaDupla.addFirst(2);
		listaDupla.addFirst(1);
		
		System.out.println(listaDupla.printList());
		listaDupla.removeFirst();
		System.out.println(listaDupla.printList());
		listaDupla.clear();
		
		System.out.println();
		
		listaDupla.addLast(5);
		listaDupla.addLast(6);
		listaDupla.addLast(7);
		
		System.out.println(listaDupla.printList());
		System.out.println(listaDupla.removeLast());
		System.out.println(listaDupla.printList());
		
		System.out.println();
		
		list.add(3);
		list.add(2);
		list.add(1);
	}

}
