package desenhoNodo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import nodo.*;


/**
 * Classe que representa um desenho de uma Lista Lineare genérica.
 *
 * @author gianlucamk04@gmail.com
 *
 * @param <T> Tipo de dados armazenados na lista
 */
public class DesenhoNodo<T> extends Application{
    private static Nodo<?> nodo;
    private static NodoDuplo<?> nodoDuplo;
    private static boolean isCircular;

    /**
     * Armazena qual o nodo inicial da lista.
     * 
     * @param <T>
     * 
     * @param inicio Nodo inicial a ser definido
     * 
     * @param circular define se a lista é circular ou não
     */
    public static void setInicio(Nodo<?> inicio, boolean circular) {
        nodo = inicio;
        isCircular = circular;
    }

    /**
     * Armazena qual o nodo inicial da lista.
     * 
     * @param <T>
     * 
     * @param inicio Nodo inicial a ser definido
     *
     */
    public static void setInicio(NodoDuplo<?> inicio) {
        nodoDuplo = inicio;
    }

    /**
     * Inicia o desenho de uma lista específica.
     * 
     * @param <Stage>
     * 
     * @param primaryStage define o estágio inicial
     *
     */
    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();

        double larguraTela = 800;
        double alturaTela = 600;
        double espacamento = 100;
        double larguraNodo = 30;

        // Cálculo do tamanho do Canvas baseado no número de nós
        int totalNodos = 0;
        if (nodo != null)
        	totalNodos = contarNodos();
        else if (nodoDuplo != null)
        	totalNodos = contarNodosDuplo();
        double larguraCanvas = Math.max(larguraTela, totalNodos * (larguraNodo + espacamento));
        Canvas canvas = new Canvas(larguraCanvas, alturaTela);

        GraphicsContext gc = canvas.getGraphicsContext2D();
        desenhar(gc);

        root.getChildren().add(canvas);

        // Adicionando a barra de rolagem
        ScrollPane scrollPane = new ScrollPane(root);
        Scene scene = new Scene(scrollPane, larguraTela, alturaTela);

        primaryStage.setTitle("Visualização da Lista Encadeada");
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.show();
    }

    /**
     * Desenha uma lista específica.
     * 
     * @param <GraphicsContext>
     * 
     * @param gc define qual o módelo gráfico a ser desenhado
     *
     */
    private void desenhar(GraphicsContext gc) {
        gc.setFill(Color.BLACK);
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(2);
        gc.setFont(new Font(11));  // Define o tamanho da fonte para o dado
        
        if (nodo != null) {
            desenharListaSimples(gc);
        } else if (nodoDuplo != null) {
            desenharListaDuplamenteEncadeada(gc);
        }
    }

    /**
     * Conta os nodos pertencentes uma lista simplismente encadeada específica.
     * 
     * @return o total de Nodos que esta lista possui
     */
    private int contarNodos() {
        Nodo<?> current = nodo;
        int count = 0;

        while (current != null) {
            count++;
            current = current.getProx();

            if (isCircular && current == nodo) {
                break; // Evita loop infinito em listas circulares
            }
        }
        return count;
    }
    
    /**
     * Conta os nodos pertencentes uma lista duplamente encadeada específica.
     * 
     * @return o total de Nodos que esta lista possui
     */
    private int contarNodosDuplo() {
        NodoDuplo<?> current = nodoDuplo;
        int count = 0;

        while (current != null) {
            count++;
            current = current.getProx();
        }
        return count;
    }

    /**
     * Desenha uma lista simplismente encadeada específica.
     * 
     * @param <GraphicsContext>
     * 
     * @param gc define qual o módelo gráfico a ser desenhado
     *
     */
    private void desenharListaSimples(GraphicsContext gc) {
        Nodo<?> current = nodo;
        double x = 100;
        double y = 100;
        double largura = 30;
        double altura = 30;
        double espacamento = 100;
        int posicao = 0;
        Nodo<?> primeiroNodo = nodo;

        while (current != null) {
            String dado = current.getDado().toString();

            // Desenhar o retângulo para o nodo
            gc.strokeRect(x, y, largura, altura);
            gc.fillText(Integer.toString(posicao), x + 10, y + 20);

            // Desenhar o dado embaixo do retângulo
            gc.setFont(new Font(10));
            if (dado.length() < 4)
            	gc.fillText(dado, (x + 10) - dado.length(), y + 40);
            else if(dado.length() >= 4 && dado.length() < 6)
            	gc.fillText(dado, (x + 5) - dado.length(), y + 40);
            else
            	gc.fillText(dado, x - dado.length(), y + 40);
            gc.setFont(new Font(11));

            if (current.getProx() != null && current.getProx() != primeiroNodo) {
                // Desenhar a seta para o próximo nodo
                gc.strokeLine(x + largura, y + altura / 2, x + largura + espacamento - 35.5, y + altura / 2);
                gc.strokeLine(x + largura + espacamento - 32, y + altura / 2, x + largura + espacamento - 42, y + altura / 2 - 10);
                gc.strokeLine(x + largura + espacamento - 32, y + altura / 2, x + largura + espacamento - 42, y + altura / 2 + 10);
            }

            x += espacamento;
            posicao++;

            // Avança para o próximo nodo
            current = current.getProx();

            // Evitar loop infinito em listas circulares
            if (isCircular && current == primeiroNodo) {
                break;
            }
        }

        // Se for circular, desenhar a seta do último nodo para o primeiro
        if (isCircular && current == primeiroNodo) {
            double lastX = x - espacamento + largura;
            double primeiroX = 100;

            gc.strokeLine(lastX + largura, y + altura / 2, lastX, y + altura / 2);
            gc.strokeLine(lastX + largura, y + altura / 2, lastX + altura/2 + largura / 2, y - altura);
            gc.strokeLine(primeiroX + largura / 2, y - altura, lastX + altura/2 + largura / 2, y - altura);
            gc.strokeLine(primeiroX + largura / 2, y, primeiroX + largura / 2, y - altura);
            gc.strokeLine(primeiroX + largura / 2, y, primeiroX + 25, y - altura + 20);
            gc.strokeLine(primeiroX + largura / 2, y, primeiroX + 5, y - altura + 20);
        }
    }

    /**
     * Desenha uma lista duplamente encadeada específica.
     * 
     * @param <GraphicsContext>
     * 
     * @param gc define qual o módelo gráfico a ser desenhado
     *
     */
    private void desenharListaDuplamenteEncadeada(GraphicsContext gc) {
        NodoDuplo<?> current = nodoDuplo;
        double x = 100;
        double y = 100;
        double largura = 30;
        double altura = 30;
        double espacamento = 100;
        int posicao = 0;

        while (current != null) {
            String dado = current.getDado().toString();

            gc.strokeRect(x, y, largura, altura);
            gc.fillText(Integer.toString(posicao), x + 10, y + 20);

            gc.setFont(new Font(10));
            if (dado.length() < 4)
            	gc.fillText(dado, (x + 10) - dado.length(), y + 40);
            else if(dado.length() >= 4 && dado.length() < 6)
            	gc.fillText(dado, (x + 5) - dado.length(), y + 40);
            else
            	gc.fillText(dado, x - dado.length(), y + 40);
            gc.setFont(new Font(11));

            if (current.getProx() != null) {
                gc.strokeLine(x + largura, y + altura / 2, x + largura + espacamento - 35.5, y + altura / 2);
                gc.strokeLine(x + largura + espacamento - 32, y + altura / 2, x + largura + espacamento - 42, y + altura / 2 - 10);
                gc.strokeLine(x + largura + espacamento - 32, y + altura / 2, x + largura + espacamento - 42, y + altura / 2 + 10);
            }

            if (current.getAnt() != null) {
                gc.strokeLine(x - 35.5, y + altura / 2, x - espacamento + largura, y + altura / 2);
                gc.strokeLine(x - espacamento + largura + 3, y + altura / 2, x - espacamento + largura + 13, y + altura / 2 - 10);
                gc.strokeLine(x - espacamento + largura + 3, y + altura / 2, x - espacamento + largura + 13, y + altura / 2 + 10);
            }

            x += espacamento;
            posicao++;

            current = current.getProx();
        }
    }
}
