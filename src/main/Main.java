package main;

import interfaces.*;
import java.util.ArrayList;
import java.util.LinkedList;
import factories.*;

public class Main {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		LinkedList<Integer> listaa = new LinkedList<>();
		ListaFactory<String> listaEn = new ListaEncadeadaFactory<>();
		Lista<String> lista = listaEn.criarLista();
		
		ListaFactory<String> listaC = new ListaCircularFactory<>();
		Lista<String> listaCirc = listaC.criarLista();
		
		ListaFactory<String> listaD = new ListaDuplamenteEncadeadaFactory<>();
		Lista<String> listaDupla = listaD.criarLista();
		
		/*ListaEncadeada<Integer> lista = new ListaEncadeada<>();
		ListaCircular<Integer> listaCirc = new ListaCircular<>();
		ListaDuplamenteEncadeada<Integer> listaDupla = new ListaDuplamenteEncadeada<>();*/
		
		/*lista.addFirst("c");
		lista.addFirst("b");
		lista.addFirst("a");
		
		System.out.println(lista.printList());
		System.out.println(lista.get(1));
		lista.removeFirst();
		System.out.println(lista.printList());
		lista.clear();
		System.out.println(lista.printList());
		lista.addLast("d");
		lista.addLast("e");
		lista.addLast("f");
		lista.addLast("g");
		System.out.println(lista.printList());
		lista.removeLast();
		System.out.println(lista.printList());
		lista.remove("e");
		System.out.println(lista.printList());
		System.out.println(lista.get(0));
		System.out.println(lista.size());*/
		
		/*listaCirc.addFirst("c");
		listaCirc.addFirst("b");
		listaCirc.addFirst("a");
		System.out.println(listaCirc.printList());
		listaCirc.removeLast();
		System.out.println(listaCirc.printList());
		listaCirc.remove("a");
		
		System.out.println(listaCirc.printList());
		System.out.println(listaCirc.get(0));
		listaCirc.clear();
		System.out.println(listaCirc.printList());
		listaCirc.addLast("d");
		listaCirc.addLast("e");
		listaCirc.addLast("f");
		listaCirc.addLast("g");
		System.out.println(listaCirc.printList());
		System.out.println(listaCirc.get(2));
		listaCirc.removeFirst();
		System.out.println(listaCirc.printList());
		listaCirc.remove("f");
		System.out.println(listaCirc.printList());
		System.out.println(listaCirc.size());*/
		
		/*listaDupla.addFirst("c");
		listaDupla.addFirst("b");
		listaDupla.addFirst("a");
		
		System.out.println(listaDupla.printList());
		System.out.println(listaDupla.size());
		System.out.println(listaDupla.get(0));
		listaDupla.removeFirst();
		System.out.println(listaDupla.printList());
		System.out.println(listaDupla.size());
		listaDupla.clear();
		
		System.out.println();
		
		listaDupla.addLast("d");
		listaDupla.addLast("e");
		listaDupla.addLast("f");
		
		System.out.println(listaDupla.printList());
		System.out.println(listaDupla.size());
		System.out.println(listaDupla.removeLast());
		System.out.println(listaDupla.printList());
		System.out.println(listaDupla.size());
		
		listaDupla.addLast("g");
		listaDupla.addLast("h");
		listaDupla.remove("i");
		System.out.println(listaDupla.printList());
		System.out.println(listaDupla.size());*/
		
		System.out.println();
		
		list.add(3);
		list.add(2);
		list.add(1);
	}

}
