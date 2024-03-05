import java.util.Scanner;

/**
 * Classe principal que inicia o simulado do robô.
 * @author Jesimar S. Arantes
 * Código 3.22
 */
public class App {
    /**
     * Ponto de entrada da aplicação.
     * @param args lista de argumentos receido via linha de comando.
     */
    public static void main(String[] args) {


        Robo robo = new Robo();
        String tecla = "";
        Scanner scan = new Scanner(System.in);
        boolean ok = false;
        do {
            try {
                tecla = scan.next();

                robo.setOrientacao(tecla.charAt(0));
                System.out.println("try before");
                robo.printPos();
                System.out.println("try after");
            }catch (IllegalArgumentException ex){
                if (tecla.charAt(0) == '0') {
                    ok = true;
                }else {
                    System.out.println("Valor errado");
                    scan.nextLine();
                    ok = false;
                }
            }
        }while (!ok);
        robo.printPos();
    }
}