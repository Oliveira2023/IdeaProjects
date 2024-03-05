package fxtestes.testefx2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import java.lang.Object;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.io.File;

public class inicio extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        Label label = new Label("Calculo fibonacci");
        label.setFont(Font.font("Serif", 25));
        label.setTextFill(Color.DARKGREEN);
        TextField numField = new TextField();
        Image imagem = new Image("C:\\Users\\lucia\\IdeaProjects\\testeFx2\\src\\main\\resources\\mission.png");
        ImageView imgBtn = new ImageView();
        imgBtn.setImage(imagem);

        Button btn = new Button("Calcular", imgBtn);
        TextArea textArea = new TextArea();
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    int num = Integer.parseInt(numField.getText());
                    if (num >= 1 && num <= 42) {
                        String resultado = String.format(
                                "Fibonacci(%d) = %d\n",
                                num, fibonacci(num)
                        );
                        textArea.appendText(resultado);
                    } else if (num < 1) {
                        String msg = String.format(
                                "o número deve ser >= 1\n"
                        );
                        textArea.appendText(msg);
                    } else if (num > 42) {
                        String msg = String.format(
                                "Número muito grande\n"
                        );
                        textArea.appendText(msg);
                    }
                } catch (Exception ex) {
                    String msg = String.format("Digite um numero inteiro\n");
                    textArea.appendText(msg);
                }
            }
        });


        textArea.setBackground(Background.fill(Color.rgb(200, 200,100)));

        VBox vBox = new VBox(label, numField, textArea, btn);
        vBox.setPadding(new Insets(10, 10, 10, 10));
        vBox.setSpacing(10);
        vBox.setAlignment(Pos.TOP_CENTER);
        vBox.setStyle("-fx-background-color: #BBDDFF;");
        Scene cena = new Scene(vBox, 400, 300);
        stage.setScene(cena);
        stage.setTitle("Aplicação que calcula Fibonacci");
        stage.show();
    }
    public long fibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }else {
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }
}
