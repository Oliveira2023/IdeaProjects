import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class arquivoTXT {

    public arquivoTXT()  { //throws FileNotFoundException
        try {
            File arquivo = new File("src/dados/poema.txt");
            Scanner scanner = new Scanner(arquivo);
            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                System.out.printf("%s%n", linha);
            }
        }catch (FileNotFoundException ex) {
            System.out.printf("Erro: %s%n", ex.getMessage());
        }


    }
}
