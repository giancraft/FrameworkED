package testesUnitarios;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import facade.ListaFacade;
import listasLineares.*;

/**
 * Classe que realiza os testes unitários para as Listas Simplesmente Encadeadas.
 *
 * @author gianlucamk04@gmail.com
 */
public class TestesUnitariosEncadeada extends TestCase {
	private ListaFacade<Integer> listaFacade;

	/**
     * Cria a lista que será utilizada antes de executar os devidos testes.
     */
	@Before
    public void setUp() {
        listaFacade = new ListaFacade<Integer>();
        listaFacade.criarListaEncadeada();
    }
	
	/**
     * Cria uma Lista Encadeada e realiza o teste unitário.
     */
	@Test
	public void testCriarListaEncadeada(){
		listaFacade = new ListaFacade<Integer>();
        listaFacade.criarListaEncadeada();
        ListaEncadeada<Integer> lista = new ListaEncadeada<Integer>();
        assertEquals(lista.getClass(), listaFacade.getLista().getClass());
	}

	/**
     * Adiciona valores no início da lista e realiza o teste unitário.
     */
	@Test
    public void testAdicionarNoInicio() {
        listaFacade.addFirst(1);
        listaFacade.addFirst(2);
        listaFacade.addFirst(3);
        assertEquals(3, listaFacade.size());
    }
	
	/**
     * Adiciona valores no final da lista e realiza o teste unitário.
     */
	@Test
	public void testAdicionarNoFinal() {
        listaFacade.addLast(1);
        listaFacade.addLast(2);
        listaFacade.addLast(3);
        assertEquals(3, listaFacade.size());
    }

	/**
     * Adiciona valores na lista, remove um deles e realiza o teste unitário.
     */
    @Test
    public void testRemoverElemento() {
    	listaFacade.addFirst(1);
        listaFacade.addFirst(2);
        listaFacade.remove(1);
        assertEquals(1, listaFacade.size());
    }

    /**
     * Adiciona valores na lista, busca um deles e realiza o teste unitário.
     */
    @Test
    public void testBuscarElemento() {
    	listaFacade.addFirst(1);
        listaFacade.addFirst(2);
        Object elemento = listaFacade.get(1);
        assertEquals(1, elemento);
    }

    /**
     * Adiciona valores na lista, verifica o tamanho e realiza o teste unitário.
     */
    @Test
    public void testTamanhoLista() {
    	listaFacade.addFirst(1);
        listaFacade.addFirst(2);
        assertEquals(2, listaFacade.size());
    }

    /**
     * Verifica se a lista está vazia e realiza o teste unitário.
     */
    @Test
    public void testListaVazia() {
        assertEquals(true, listaFacade.isEmpty());
    }

    /**
     * Adiciona valores na lista, limpa ela e realiza o teste unitário.
     */
    @Test
    public void testLimparLista() {
    	listaFacade.addFirst(1);
        listaFacade.addFirst(2);
        listaFacade.clear();
        assertEquals(0, listaFacade.size());
    }
}
