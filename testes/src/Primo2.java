public class Primo2  extends Thread{
    public static void sleepthread(){
        System.out.println("inicio do metodo sleep");
        try {
            System.out.println("inicio sleep");
            Thread.sleep(5000);
            System.out.println("fim sleep");
        }catch ( InterruptedException ex) {
            System.out.println(ex);
        }

        System.out.println("fim");
    }
}
