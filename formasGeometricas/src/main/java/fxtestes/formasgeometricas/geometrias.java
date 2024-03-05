package fxtestes.formasgeometricas;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class geometrias extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        Rectangle retangulo = new Rectangle(100, 100);
        retangulo.setTranslateX(10);
        retangulo.setTranslateY(10);
        retangulo.setFill(Color.RED);
        Circle circulo = new Circle(50);
        circulo.setTranslateX(170);
        circulo.setTranslateY(60);
        circulo.setFill(Color.GREEN);
        Circle circunferencia = new Circle(50);
        circunferencia.setTranslateY(60);
        circunferencia.setTranslateX(280);
        circunferencia.setStroke(Color.BLUE);
        circunferencia.setStrokeWidth(3.0);
        circunferencia.setFill(Color.TRANSPARENT);
        Ellipse elipse = new Ellipse(50, 25);
        elipse.setTranslateX(390);
        elipse.setTranslateY(60);
        elipse.setFill(Color.YELLOW);
        Line linha = new Line(10.0f, 10.0f, 100.0f, 100.0f);
        linha.setTranslateX(450);
        linha.setTranslateY(10);
        linha.setStroke(Color.GREENYELLOW);
        linha.setStrokeWidth(3.0);
        Polygon poligono = new Polygon();
        poligono.getPoints().addAll(new Double[]{
            0.0, 0.0,
            100.0, 0.0,
            50.0, 100.0
        });
        poligono.setTranslateX(550);
        poligono.setTranslateY(10);
        poligono.setFill(Color.SKYBLUE);
        Polyline polilinha = new Polyline();
        polilinha.getPoints().addAll(new Double[]{
                0.0, 0.0,
                100.0, 0.0,
                0.0, 100.0,
                100.0, 100.0
        });
        polilinha.setTranslateX(670);
        polilinha.setTranslateX(670);
        polilinha.setTranslateY(10);
        polilinha.setStroke(Color.BLACK);
        polilinha.setStrokeWidth(3.0);
        Group root = new Group();
        root.getChildren().addAll(retangulo, circulo, circunferencia, elipse, linha, poligono, polilinha);
        Scene scene = new Scene(root, 800, 120, Color.GRAY);
        Image icon = new Image("C:\\Users\\lucia\\OneDrive\\Aprendizado\\Projetos\\Luciano-site\\favicon-16x16.png");
        stage.getIcons().addAll(icon);

        //stage.setFullScreen(true);
        //stage.setFullScreenExitHint("Para sair pressine a letra q");
        //stage.setFullScreenExitKeyCombination(KeyCombination.keyCombination("q"));
        stage.setTitle("Aplicação de Figuras Geométricas");
        stage.setScene(scene);
        stage.show();
    }
}
