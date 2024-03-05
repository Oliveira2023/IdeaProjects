/**
 * Classe abstrata que modela a ideia de robô
 * @author Jesimar da Silva Arantes
 * Codigo 3.22
 */
public abstract class RoboIdeia {
    protected float posicaoX;
    protected float posicaoY;
    protected Orientacao orientacao;
    protected String nome;
    protected float peso;

    /**
     * Assinatura do metodo que mve o robô.
     * @param posX posição x em que o robô será movido.
     * @param posY posição Y em que o robô será movido.
     */
    public abstract void move (float posX, float posY);

    /**
     * Assinatura do método que move o robô ao longo do eixo x.
     * @param dist distância a partir da posição atual no eixo x que será movido o robô.
     */
    public abstract void moveX (float dist);

    /**
     * Assinatura do metodo que move o robô ao longo do eixo Y.
     * @param dist distância a partir da posição atual no eixo y que será movido o robô.
     */
    public abstract void moveY (float dist);
}
