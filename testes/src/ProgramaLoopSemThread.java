public class ProgramaLoopSemThread {

    public void programa() {
        System.out.println("inicio");
        while (true) {
            if (1 % 2 ==2) break;
            System.out.println("loop infinito");
        }
        System.out.println("Passou o primeiro loop");
        for (long i  = 0; i < 1000000000000l; i++){
            System.out.println("loop super pesado");
        }
        System.out.println("passou o segundo loop");
        boolean condicaoLoop = true;
        do {
            System.out.println("loop condição complexa");
        }while (condicaoLoop);
        System.out.println("fim");
    }
}
