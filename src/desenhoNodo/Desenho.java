package desenhoNodo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import nodo.*;

public class Desenho<T> extends Application{
	private static Nodo<?> nodo;
	//private static NodoDuplo<?> nodoDuplo;
	
	/*public DesenhoNodo(Nodo<T> nodo){
		this.nodo = nodo;
	}
	
	public DesenhoNodo(NodoDuplo<T> nodoDuplo) {
		this.nodoDuplo = nodoDuplo;
	}*/
	
	public static void setInicio(Nodo<?> inicio) {
		nodo = inicio;
	}
	
	/*public static void setInicio(NodoDuplo<?> inicio) {
		nodoDuplo = inicio;
	}*/
	
	@Override
	public void start(Stage primaryStage) {
        Pane root = new Pane();
        Canvas canvas = new Canvas(800, 600);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        desenhar(gc);

        root.getChildren().add(canvas);
        Scene scene = new Scene(root, 800, 600);

        primaryStage.setTitle("Visualização da Lista Encadeada");
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.DECORATED);  // Controle da janela
        primaryStage.show();
    }
	
	private void desenhar(GraphicsContext gc) {
        gc.setFill(Color.BLACK);
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(2);
        gc.setFont(new Font(11)); 
        
        // Fonte original para a posição (pode ser maior)
        Font fonteOriginal = gc.getFont();

        // Percorre a lista e desenha cada nodo
        if (nodo != null) {
        	Nodo<?> current = nodo;
            double x = 100;
            double y = 100;
            double largura = 30;
            double altura = 30;
            double espacamento = 100;
            Integer posicao = 0;

            while (current != null) {
            	 String dado = current.getDado().toString();
                 //double largura = posicao * 30;
                 //double espacamento = largura + 50;
            	
                gc.strokeRect(x, y, largura, altura);
                gc.fillText(posicao.toString(), x + 10, y + 20);
                
                // Ajusta o tamanho da fonte para o dado
                gc.setFont(new Font(10));  // Tamanho menor para o texto do dado
                
                // Desenhar o dado abaixo do retângulo
                gc.fillText(dado, x + (largura / 2) - (dado.length() * 3), y + altura + 15);  // Ajusta a posição do texto do dado

                // Restaura a fonte original para outros textos
                gc.setFont(fonteOriginal);

                if (current.getProx() != null) {
                	
                    // Desenhar a seta
                    gc.strokeLine(x + largura, y + altura / 2, x + largura + espacamento - 35.5, y + altura / 2);
                    gc.strokeLine(x + largura + espacamento - 32, y + altura / 2, x + largura + espacamento - 42, y + altura / 2 - 10);
                    gc.strokeLine(x + largura + espacamento - 32, y + altura / 2, x + largura + espacamento - 42, y + altura / 2 + 10);
                }
                
                posicao++;
                x += espacamento;
                current = current.getProx();
            }
        }
	}
}
