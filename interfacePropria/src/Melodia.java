import javax.sound.midi.MidiChannel;

public class Melodia {
    private final static int DO = 60;
    private final static int RE = 62;
    private final static int MI = 64;
    private final static int FA = 65;
    private final static int SOL = 67;
    private final static int SILENCIO = 0;
    private final int UM_TEMPO;
    private final int DOIS_TEMPOS;

    public Melodia(double velocidade){
        UM_TEMPO = (int)(250/velocidade);
        DOIS_TEMPOS = (int)(500/velocidade);
    }
    public void musica(MidiChannel canal, int volume)
        throws InterruptedException{
        tocarNota(canal, DO, UM_TEMPO, volume);
        tocarNota(canal, RE, UM_TEMPO, volume);
        tocarNota(canal, MI, UM_TEMPO, volume);
        tocarNota(canal, FA, DOIS_TEMPOS, volume);
        tocarNota(canal, FA, UM_TEMPO, volume);
        tocarNota(canal, FA, UM_TEMPO, volume);
        tocarNota(canal, SILENCIO, UM_TEMPO, volume);
    }
    private static void tocarNota(MidiChannel canal, int nota, int tempo, int volume) throws InterruptedException {
        canal.noteOn(nota, volume);
        Thread.sleep(tempo);
        canal.noteOff(nota, volume);
    }



}
