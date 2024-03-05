import javafx.scene.image.ImageView;

public class Carregador implements Runnable{
    private float posicaoX;
    private float posicaoY;
    private final ImageView viewCarregador;
    private final int velocidade = 3;

    public Carregador(float posX, float posY, ImageView view) {
        this.posicaoX = posX;
        this.posicaoY = posY;
        this.viewCarregador = view;
    }
    @Override
    public void run() {
        boolean isMoveRight = true;
        while (true) {
            if (isMoveRight) {
                posicaoX += velocidade;
            }else {
                posicaoX -= velocidade;
            }
            if (isMoveRight && posicaoX > 350) {
                isMoveRight = false;
            }else if (!isMoveRight && posicaoX <190) {
                isMoveRight = true;
            }
            viewCarregador.setTranslateX(posicaoX);
            viewCarregador.setTranslateY(posicaoY);
            try{
                Thread.sleep(100);
            }catch (InterruptedException ex) {
                System.out.println("Problema no timer da Thread");
                System.out.println(ex);
            }
        }
    }
}
