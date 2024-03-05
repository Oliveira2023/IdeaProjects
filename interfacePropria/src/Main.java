import javax.sound.midi.MidiUnavailableException;

public class Main {
    public static void main(String[] args) throws MidiUnavailableException {
         System.out.println("Tocando melodia piano vel. normal");
         Melodia melodiaNormal = new Melodia(1.00);
         Piano piano = new Piano();
         piano.setVolume(75);
         piano.tocar(melodiaNormal);

        System.out.println("Tocando melodia celo vel. rápida");
        Melodia melodiaRapida = new Melodia(1.25);
        Violoncelo violoncelo = new Violoncelo();
        violoncelo.setVolume(100);
        violoncelo.tocar(melodiaRapida);

        System.out.println("Tocando melodia violão vel. lenta");
        Melodia melodiaLenta = new Melodia(0.75);
        Violao violao = new Violao();
        violao.setVolume(50);
        violao.tocar(melodiaLenta);
    }
}
