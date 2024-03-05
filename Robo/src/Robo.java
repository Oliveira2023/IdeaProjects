/**
 * Classe que modela a entidade robô.
 * @author Jesimar da Silva Arantes
 * Codigo 3.22
 */
public  class Robo extends RoboIdeia {

    private final float velocidadeMax = 5;
    private final float pesoCargaMax = 20;
    private final String tipoTracao = "esteira";
    private int velocidade = 1;
    private final int largura = 50;
    private final int altura = 50;

    /**
     * Construtor padrão da aplicação.
     */
    public Robo(){
        super.nome = "R-ATM";
        super.peso = 70;
        super.posicaoX = 50;
        super.posicaoY = 50;
    }

    /**
     * Construtor da calsse robô.
     * @param nome nome do robô.
     */
    public Robo(String nome) {
        super.nome = nome;
        super.peso = 70;
        super.posicaoX = 100;
        super.posicaoY = 50;
    }

    /**
     * Construtor da classe robo.
     * @param nome nome do robô.
     * @param peso valor do peso do robô.
     */
    public Robo(String nome, float peso) {
        super.nome = nome;
        super.peso = peso;
        super.posicaoX = 100;
        super.posicaoY = 50;
    }

    /**
     * Construtor da classe robô.
     * @param nome - nome do robô.
     * @param peso - valor do peso do robô.
     * @param posX - valor da posição x inicial do robô.
     * @param posY - valor da posição y inicial do robô.
     */
    public Robo(String nome, float peso, float posX, float posY) {
        super.nome = nome;
        super.peso = peso;
        super.posicaoX = posX;
        super.posicaoY = posY;
    }
    /**
     * Move o robô para a posição x e y.
     * @param posX posição x em que o robô será movido.
     * @param posY posição Y em que o robô será movido.
     * @throws IllegalArgumentException exceção lançada quando o argumento for NaN ou infinita
     */
    @Override
    public void move(float posX, float posY){
        if(Float.isNaN(posX) || Float.isNaN(posY) || Float.isFinite(posX) || Float.isFinite(posY)) {
            throw new IllegalArgumentException("Args não válidos");
        }
        super.posicaoX = posX;
        super.posicaoY = posY;
    }

    /**
     * Move o robo ao longo do eixo x.
     * @param dist distância a partir da posição atual no eixo x que será movido o robô.
     * @throws IllegalArgumentException exceção lançada quando o argumento for NaN ou infinito.
     */
    @Override
    public void moveX(float dist){
        if (Float.isNaN(dist) || Float.isFinite(dist)) {
            throw new IllegalArgumentException("Arg não válido");
        }
        super.posicaoX += dist;
    }

    /**
     * Move o robo ao longo do eixo Y.
     * @param dist distância a partir da posição atual no eixo y que será movido o robô.
     * @throws IllegalArgumentException exceção lançada quando o argumento for NaN ou infinito.
     */
    @Override
    public void moveY(float dist){
        if(Float.isNaN(dist) || Float.isFinite(dist)){
            throw new IllegalArgumentException("Arg não válido");
        }
        super.posicaoY += dist;
    }
    /**
     * Metodo que imprime o estado do objeto.
     * @return retorna uma string que representa o estado do objeto.
     */
    @Override
    public String toString(){
        return "Robo{" + "posiçãoX = " + posicaoX + ", posiçãoY = " + posicaoY +
                ", orientação = " + orientacao + "}";
    }

    /**
     * Metodo que compara dois objetos.
     * @param obj objeto a ser comparado.
     * @return retorna true se os dois objetos são iguais e retorna false se forem diferentes.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Robo) {
            Robo robo = (Robo) obj;
            return super.nome.equals(robo.nome);
        }else {
            return false;
        }
    }

    /**
     * Método que define a orientação do robô e também efetura o movimento na
     * direção da orientaçao que a tecla foi pressionada.
     * @param tecla - char representando a tecla que foi pressionada.
     */
    public void setOrientacao(char tecla) {
        //System.out.println(tecla instanceof String);
        System.out.printf("entrada setOrientaçao, valor tecla: %s%n", tecla);

        if (tecla == 'w') {
            super.orientacao = Orientacao.FRENTE;
            moveY(5);
        } else if (tecla == 's') {
            super.orientacao = Orientacao.ATRAS;
            moveY(-5);
        } else if (tecla == 'a') {
            System.out.println("reconhece tecla a");
            super.orientacao = Orientacao.ESQUERDA;
            moveX(-5);
        } else if (tecla == 'd') {
            super.orientacao = Orientacao.DIREITA;
            moveX(5);
        } else {
            throw new IllegalArgumentException("Arg não válido");
        }
    }
    public void movimentosAgendados(String... moves){
        for (String tecla : moves){
            if ((!tecla.equals("--move") && !tecla.equals("-m"))) {
                System.out.println("Tecla: " + tecla);
                System.out.println("Descrição: " + descricaoDoMovimento(tecla.charAt(0)));
                setOrientacao(tecla.charAt(0));
                printPos();
            }
        }
    }
    public String descricaoDoMovimento(char tecla){
        if(tecla == 'w'){
            return "movendo para frente";
        } else if (tecla == 'a') {
            return "movendo para esquerda";
        } else if (tecla == 's') {
            return "movendo para baixo";
        } else if (tecla == 'd') {
            return "movendo para direita";
        } else {
            return "";
        }
    }

    /**
     * Metodo que imprime todos os estado internos do objeto.
     */
    public void printStatus(){
        System.out.println("-----------Info R-ATM----------");
        System.out.println("Nome do robo: " + nome);
        System.out.println("Peso do robo: " + peso);
        System.out.println("Velocidade Max: " + velocidadeMax);
        System.out.println("Carga Max do Robô: " + pesoCargaMax);
        System.out.println("Tipo Tração do Robô: " + tipoTracao);
        System.out.println("Posição X do Robô: " + posicaoX);
        System.out.println("Posição Y do Robô: " + posicaoY);
        System.out.println("-------------------------------");
    }
    public boolean avaliaPos(int posX, int posY) {
        posX = posX + largura/2;
        posY = posY + altura/2;
        if (posX<40 || posX>560 || posY<30 || posY>360) {
            return false; //delimitação da fronteira da sala.
        }
        if ((posX>=170 && posX<=430) && (posY>=240 && posY<=400)){
            return false; //delimitação região operação máquinas
        }
        if ((posX>=0 && posX<=100) && (posY>=0 && posY<=200)) {
            return false; //delimitaçao regiao caixas livros
        }
        if ((posX>=500 && posX<=600) && (posY>=0 && posY<=200)) {
            return false; //delimitação região caixas impressoras
        }
        if ((posX>=170 && posX<=430) && (posY>=0 && posY<=90)) {
            return false; //delimitação região caixas com HDs
        }
        if ((posX>=170 && posX<=430) && (posY>=120 && posY<=200)){
            return false; //delimitação região caixas com HDs
        }

        return true;
    }

    /**
     * Metodo que imprime a posição corrente do objeto.
     */
    public void printPos(){
        System.out.println("(x,y) = (" + posicaoX + "," + posicaoY + ")");
    }

    public int getPosicaoX() {
        return (int) super.posicaoX;
    }
    public int getPosicaoY() {
        return (int) super.posicaoY;
    }
    public void setPosicaoX(int x) {
        super.posicaoX = x;
    }
    public void setPosicaoY(int y) {
        super.posicaoY = y;
    }
    public int getVelocidade() {
        return velocidade;
    }
    public void setVelocidade(int v) {
        velocidade = v;
    }

}
