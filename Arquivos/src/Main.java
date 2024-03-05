import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
//        arquivoTXT arquivo = new arquivoTXT();
            ArquivoCSV arquivoCSV = new ArquivoCSV();
            arquivoCSV.leitura();
    }
}