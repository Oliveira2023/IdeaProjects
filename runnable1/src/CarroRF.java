import java.util.*;
public class CarroRF implements Runnable {
    private int nivelBateria;
    private int numMovimentos;

    public CarroRF() {
        this.nivelBateria = 100;
        this.numMovimentos = 0;
    }
    public void agendarMovimentos(Direcao... direcoesMovimentos) {
        String msg = String.format("Lista movimentos agendados: %s", Arrays.toString(direcoesMovimentos));
        System.out.println(msg);
        numMovimentos += direcoesMovimentos.length;
    }
    @Override
    public void run() {
        System.out.println("Executando movimentos ...");
        nivelBateria -= numMovimentos;
        numMovimentos = 0;
    }
    @Override
    public String toString() {
        return String.format("Nível da Bateria: %d%n" + "Movimentos a Executar: %d",
                nivelBateria, numMovimentos);
    }

}
