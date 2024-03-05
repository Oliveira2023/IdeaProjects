package fxtestes.showimages;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MostrandoImagens extends Application {

    private final String IMG_URL1 = "https://bit.ly/2Pxqady";
    private final String IMG_URL2 = "https://bit.ly/2EZlriY";
    private final String IMG_URL3 = "https://bit.ly/3fylvmj";
    private final String IMG_URL4 = "https://bit.ly/3iaOOgk";
    private final String file_uls = "C:\\Users\\lucia\\OneDrive\\Aprendizado\\Projetos\\Luciano-site\\favicon-16x16.png";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Text texto = new Text("Aplicação para exibir imagens");
        texto.setTranslateX(50);
        texto.setTranslateY(20);
        Image icon = new Image("favicon-16x16.png");
        Image img1 = new Image(IMG_URL1);
        ImageView view1 = new ImageView(img1);
        view1.setTranslateX(100);
        view1.setTranslateY(30);
        Group grupo = new Group();
        grupo.getChildren().addAll(texto, view1);
        Scene cena = new Scene(grupo, 300,300);
        cena.setFill(Color.GRAY);
        stage.getIcons().addAll(icon);
        stage.setTitle("Manipulação de imagens");
        stage.setScene(cena);
        stage.show();
    }
}
