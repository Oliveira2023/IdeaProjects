public class Thread1 {


    public static void imprimeTh(){
        Thread thFluxo = Thread.currentThread();
        System.out.printf("Nome Thread: %s%n", thFluxo.getName());
    }

}
