public class Main {
    public static void main(String[] args) {
        CarroRF carro = new CarroRF();
        carro.agendarMovimentos(Direcao.CIMA, Direcao.DIREITA, Direcao.CIMA, Direcao.ESQUERDA);
        System.out.println(carro);
        carro.run();
        System.out.println(carro);
        carro.agendarMovimentos(Direcao.BAIXO, Direcao.ESQUERDA, Direcao.ESQUERDA);
        System.out.println(carro);
        carro.run();
        System.out.println(carro);
    }
}
