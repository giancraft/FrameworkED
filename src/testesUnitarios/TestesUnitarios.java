package testesUnitarios;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import facade.ListaFacade;
import listasLineares.*;

public class TestesUnitarios extends TestCase {
	private ListaFacade<Integer> listaFacade;

	@Before
    public void setUp() {
        listaFacade = new ListaFacade<Integer>();
        listaFacade.criarListaEncadeada();
    }
	
	@Test
	public void testCriarListaEncadeada(){
		listaFacade = new ListaFacade<Integer>();
        listaFacade.criarListaEncadeada();
        ListaEncadeada<Integer> lista = new ListaEncadeada<Integer>();
        assertEquals(lista.getClass(), listaFacade.getLista().getClass());
	}
	
	@Test
	public void testCriarListaCircular(){
		listaFacade = new ListaFacade<Integer>();
        listaFacade.criarListaCircular();
        ListaCircular<Integer> lista = new ListaCircular<Integer>();
        assertEquals(lista.getClass(), listaFacade.getLista().getClass());
	}
	
	@Test
	public void testCriarListaDuplamenteEncadeada(){
		listaFacade = new ListaFacade<Integer>();
        listaFacade.criarListaDuplamenteEncadeada();
        ListaDuplamenteEncadeada<Integer> lista = new ListaDuplamenteEncadeada<Integer>();
        assertEquals(lista.getClass(), listaFacade.getLista().getClass());
	}

	@Test
    public void testAdicionarNoInicio() {
        listaFacade.addFirst(1);
        listaFacade.addFirst(2);
        listaFacade.addFirst(3);
        assertEquals(3, listaFacade.size());
    }
	
	public void testAdicionarNoFinal() {
        listaFacade.addLast(1);
        listaFacade.addLast(2);
        listaFacade.addLast(3);
        assertEquals(3, listaFacade.size());
    }

    @Test
    public void testRemoverElemento() {
    	listaFacade.addFirst(1);
        listaFacade.addFirst(2);
        listaFacade.remove(1);
        assertEquals(1, listaFacade.size());
    }

    @Test
    public void testBuscarElemento() {
    	listaFacade.addFirst(1);
        listaFacade.addFirst(2);
        Object elemento = listaFacade.get(1);
        assertEquals(1, elemento);
    }

    @Test
    public void testTamanhoLista() {
    	listaFacade.addFirst(1);
        listaFacade.addFirst(2);
        assertEquals(2, listaFacade.size());
    }

    @Test
    public void testListaVazia() {
    	listaFacade.clear();
        assertEquals(true, listaFacade.isEmpty());
    }

    @Test
    public void testLimparLista() {
    	listaFacade.addFirst(1);
        listaFacade.addFirst(2);
        listaFacade.clear();
        assertEquals(0, listaFacade.size());
    }
}
