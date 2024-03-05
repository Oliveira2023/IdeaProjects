public class ProgramaLoopComThread {

    public void programa() {
        System.out.println("inicio");
        Thread thread1 = new Thread(loop1());
        thread1.start();
        System.out.println("passou o primeiro loop");
        Thread thread2 = new Thread(loop2());
        thread2.start();
        System.out.println("passou o segundo loop");
        Thread thread3 = new Thread(loop3());
        thread3.start();
        System.out.println("fim");
    }
    public Runnable loop1() {
        Runnable run1 = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (1 % 2 == 2) break; //artimanha para compilar
                    System.out.println("loop infinito");
                }
            }
        };
        return run1;
    }
    public Runnable loop2() {
        Runnable run2 = new Runnable() {
            @Override
            public void run() {
                for (long i = 0; i < 1000000000000l; i++) {
                    System.out.println("loop super pesado");
                }
            }
        };
        return run2;
    }
    public Runnable loop3() {
        Runnable run3 = new Runnable() {
            @Override
            public void run() {
                boolean condicaoLoop = true;
                do {
                    System.out.println("loop condição complexa");
                } while (condicaoLoop);
            }
        };
        return run3;
    }

}
