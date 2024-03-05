import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArquivoCSV {
    public final String DELIMITADOR_PV = ";";
    public final String DELIMITADOR_V = ",";

    public ArquivoCSV(){

    }
    public List<List<String>> leitura() { //Pode ser void, já está imprimindo os dados da forma que fiz.
        List<List<String>> registroDados = new ArrayList<>();
        try {
            File arquivo = new File("src/dados/dadosclientes.csv");
            Scanner sc = new Scanner(arquivo);
            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                registroDados.add(getRegistroDaLinha(linha));
            }
        }catch (FileNotFoundException ex) {
            System.out.printf("Erro de abertura do arquivo: %s.%n", ex.getMessage());
            System.exit(0);
        }
        imprimeDados(registroDados);
        return registroDados;
    }
    private List<String> getRegistroDaLinha(String linha) {
        List<String> listValores = new ArrayList<>();
        try (Scanner linhaScanner = new Scanner(linha)) {
            linhaScanner.useDelimiter(DELIMITADOR_V);
            while (linhaScanner.hasNext()) {
                listValores.add(linhaScanner.next());
            }
        }
        return listValores;
    }
    private void imprimeDados(List<List<String>> registroDados) {
        for (List<String> lista: registroDados) {
            for (String elemento : lista) {
                System.out.printf("|%15s ", elemento);
            }
            System.out.println("|");
        }
    }

}
