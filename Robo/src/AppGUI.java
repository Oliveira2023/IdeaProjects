import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import java.sql.Connection;

public class AppGUI extends Application {

    private final ConexaoBD conBD = new ConexaoBD();
    private final ComandosBD comandos = new ComandosBD();
    private final Connection connection = conBD.getConexao();
    private final Image imgFundo = new Image("recursos/galpao.png");
    private final Image imgRoboFrente = new Image("recursos/robo1.png");
    private final Image imgRoboCostas = new Image("recursos/robo2.png");
    private final Image imgRoboEsq = new Image("recursos/robo3.png");
    private final Image imgRoboDir = new Image("recursos/robo4.png");
    private final Image imgBoxLvr = new Image("recursos/box.png");
    private final Image imgBoxHd = new Image("recursos/box2.png");
    private final Image imgBoxPrt = new Image("recursos/box3.png");
    private final Image imgCar = new Image("recursos/carregador.png");

    private final ImageView viewFundo = new ImageView(imgFundo);
    private final ImageView viewRobo = new ImageView(imgRoboFrente);
    private final ImageView viewBoxLvr[] = new ImageView[3];
    private final ImageView viewBoxHd[][] = new ImageView[2][3];
    private final ImageView viewBoxPrt[] = new ImageView[3];
    private final ImageView viewCar = new ImageView(imgCar);

    private final Mundo2D mundo = new Mundo2D(600, 400);
    private final Robo robo = new Robo("A32", 300);
    private final Caixa caixaLvr[] = new Caixa[3];

//    private final Caixa caixaLvr = new Caixa(
//            "Caixa de Livros", 15, 25, 100,30, 0.4f, 0.4f,
//            0.3f);
    private final Caixa caixaHd[][] = new Caixa[2][3];

    private final Caixa caixaPrt[] = new Caixa[3];
//        ("Caixa de Impressoras", 8, 525, 100, 40, 0.5f, 0.5f, 0.3f);
    private final Carregador car = new Carregador(250, 270, viewCar);


    public static void main(String[] args) {

        if (args.length !=0){
            args[0].toLowerCase();
            if (args[0].equals("--author")){
                System.out.println("Autor: Jesimar S. Arantes");
            } else if (args[0].equals("--version")) {
                System.out.println("Versão: 1.0.0");
            } else if (args[0].equals("--help")) {
                System.out.println("Exec. Movimentos Agendados:");
                System.out.println("/t--move w a w w s d d a");
            } else if (args[0].equals("--commands")) {
                System.out.println("Comandos suportados");
                System.out.println("/tw: move para cima");
                System.out.println("/ta: move para esquerda");
                System.out.println("/ts: move para baixo");
                System.out.println("/td: move para direita");
                System.out.println("/t0: sair da aplicação");
            } else if (args[0].equals("--move")) {
                Robo robo = new Robo();
                System.out.println("Movimentos agendados");
                robo.movimentosAgendados(args);
            } else {
                System.out.println("Argumento não válido");
            }
            System.exit(0);
        }

        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Thread threadCarregador = new Thread(car);
        threadCarregador.start();

        viewFundo.setTranslateX(0);
        viewFundo.setTranslateY(0);
        viewRobo.setTranslateX(robo.getPosicaoX());
        viewRobo.setTranslateY(robo.getPosicaoY());

        for (int i = 0; i < caixaLvr.length; i++){
            caixaLvr[i] = new Caixa("Caixa de Livros", 15, 25, 50 + i * 50,30,
                    0.4f, 0.4f, 0.3f);
            viewBoxLvr[i] = new ImageView(imgBoxLvr);
            viewBoxLvr[i].setTranslateX(caixaLvr[i].getPosX());
            viewBoxLvr[i].setTranslateY(caixaLvr[i].getPosY());
        }
        for (int i = 0; i < caixaPrt.length; i++) {
            caixaPrt[i] = new Caixa("Caixa de Impressoras", 8, 525, 50 + i * 50, 40,
                    0.6f, 0.6f, 0.4f);
            viewBoxPrt[i] = new ImageView(imgBoxPrt);
            viewBoxPrt[i].setTranslateX(caixaPrt[i].getPosX());
            viewBoxPrt[i].setTranslateY(caixaPrt[i].getPosY());
        }
        for (int i = 0; i < caixaHd.length; i++) {
            for (int j = 0; j < caixaHd[i].length; j++) {
                if (i == 0) {
                    caixaHd[i][j] = new Caixa(
                            "Caixa de HDs", 20,230 + j * 50,
                            50, 40, 0.5f, 0.5f, 0.3f
                    );
                }else {
                    caixaHd[i][j] = new Caixa("Caixa de HDs", 20,230 + j * 50,
                            160, 40, 0.5f, 0.5f, 0.3f);
                }
                viewBoxHd[i][j] =  new ImageView(imgBoxHd);
                viewBoxHd[i][j].setTranslateX(caixaHd[i][j].getPosX());
                viewBoxHd[i][j].setTranslateY(caixaHd[i][j].getPosY());
            }
        }

        Group grupo = new Group();
        grupo.getChildren().addAll(viewFundo, viewRobo, viewCar);

        for (int i = 0; i < viewBoxLvr.length; i++) {
            grupo.getChildren().add(viewBoxLvr[i]);
        }
        for (int i = 0; i < viewBoxPrt.length; i++) {
            grupo.getChildren().add(viewBoxPrt[i]);
        }
        for (int i = 0; i < viewBoxHd.length; i++) {
            for (int j =0; j < viewBoxHd[i].length; j++) {
                grupo.getChildren().add(viewBoxHd[i][j]);
            }
        }

        Scene cena = new Scene(grupo, mundo.DIM_X, mundo.DIM_Y);
        stage.setTitle("Simulador Robo");
        stage.getIcons().add(imgRoboFrente);

        stage.setScene(cena);
        stage.show();

        cena.setOnKeyPressed((evt) -> {
            if (evt.getCode() == KeyCode.UP) {
                viewRobo.setImage(imgRoboCostas);

                if (robo.avaliaPos(robo.getPosicaoX(), robo.getPosicaoY())) {
                    robo.setPosicaoY(
                            robo.getPosicaoY() - (int)robo.getVelocidade()
                    );
                    viewRobo.setTranslateX(robo.getPosicaoX());
                    viewRobo.setTranslateY(robo.getPosicaoY());
                    comandos.inserirPos(connection,
                            robo.getPosicaoX(), robo.getPosicaoY());

                }else {
                    if (robo.getPosicaoY()<=5) {
                        robo.setPosicaoY(5);
                        viewRobo.setTranslateY(robo.getPosicaoY());
                    }
                    if (robo.getPosicaoY()>=335) {
                        robo.setPosicaoY(335);
                        viewRobo.setTranslateY(robo.getPosicaoY());
                    }

                }

                robo.printPos();
            }
            if (evt.getCode() == KeyCode.DOWN) {
                    viewRobo.setImage(imgRoboFrente);

                    if (robo.avaliaPos(robo.getPosicaoX(), robo.getPosicaoY())) {
                        robo.setPosicaoY(
                                robo.getPosicaoY() + (int)robo.getVelocidade()
                        );
                        viewRobo.setTranslateX(robo.getPosicaoX());
                        viewRobo.setTranslateY(robo.getPosicaoY());
                        comandos.inserirPos(connection,
                                robo.getPosicaoX(), robo.getPosicaoY());
                    }else {
                        if (robo.getPosicaoY()<=5) {
                            robo.setPosicaoY(5);
                            viewRobo.setTranslateY(robo.getPosicaoY());
                        }
                        if (robo.getPosicaoY()>=335) {
                            robo.setPosicaoY(335);
                            viewRobo.setTranslateY(robo.getPosicaoY());
                        }
                    }

                    robo.printPos();
            }
            if (evt.getCode() == KeyCode.LEFT) {
                viewRobo.setImage(imgRoboEsq);
                robo.setPosicaoX(
                        robo.getPosicaoX() - (int)robo.getVelocidade()
                );
                if (robo.getPosicaoX() < 0) {
                    robo.setPosicaoX(0);
                }
                viewRobo.setTranslateX(robo.getPosicaoX());
                viewRobo.setTranslateY(robo.getPosicaoY());
                comandos.inserirPos(connection,
                        robo.getPosicaoX(), robo.getPosicaoY());
            }
            if (evt.getCode() == KeyCode.RIGHT) {
                viewRobo.setImage(imgRoboDir);
                robo.setPosicaoX(
                        robo.getPosicaoX() + (int)robo.getVelocidade()
                );
                if (robo.getPosicaoX() > mundo.DIM_X -60) {
                    robo.setPosicaoX(mundo.DIM_X -60);
                }
                viewRobo.setTranslateX(robo.getPosicaoX());
                viewRobo.setTranslateY(robo.getPosicaoY());
                comandos.inserirPos(connection,
                        robo.getPosicaoX(), robo.getPosicaoY());
            }
            if (evt.getCode() == KeyCode.SPACE) {
                if (robo.getVelocidade() == 1) {
                    robo.setVelocidade(5);
                }else {
                    robo.setVelocidade(1);
                }
            }
        });
    }
}
