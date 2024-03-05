public class Main {
    public static void main(String[] args) {

        Primo2.sleepthread();

        Thread thr1 = new Thread(new Primo(0, 100));
        thr1.start();
//        Thread thr2 = new Thread(new Primo(1000001, 2000000));
//        thr2.start();
//        Thread thr3 = new Thread(new Primo(2000001, 3000000));
//        thr3.start();
//        Thread thr4 = new Thread(new Primo(3000001, 4000000));
//        thr4.start();

//        ProgramaLoopComThread p2 = new ProgramaLoopComThread();
//        p2.programa();
//        ProgramaLoopSemThread p = new ProgramaLoopSemThread();
//                p.programa();// loop infinito, não sai da função
//        Thread1.imprimeTh();

//        Book l1 = new Book("Alice no País das Maravilhas", 38);
//        Book l2 = new Book("O Senhor dos Anéis", 44);
//        Book l3 = new Book("Harry Potter", 38);
//
//        int compL1L2 = l1.compareTo(l2);
//        int compL1L3 = l1.compareTo(l3);
//        int compL2L3 = l2.compareTo(l3);
//
//        if (compL1L2 < 0){
//            System.out.printf("%s%n%s", l1.nome, l2.nome);
//        }else {
//            System.out.printf("%s%n%s", l2.nome, l1.nome);
//        }
//        System.out.println("Comparação l1 e l2: " + compL1L2);
//        System.out.println("Comparação l1 e l3: " + compL1L3);
//        System.out.println("Comparação l2 e l3: " + compL2L3);
    }
}