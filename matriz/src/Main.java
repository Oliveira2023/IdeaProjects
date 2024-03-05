import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        double mat[][] = {
                {1.5, 5.2},
                {3.6, 4.9},
                {2.4, 8.1}
        };
        for (int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[i].length; j++) {
                System.out.println("Matriz [" + i + "][" + j + "] = " + mat[i][j]);
            }
        }
        int vetor[] = {6, 3, 7, 4, 2, 5, 1, 9, 0,8};
        System.out.println("vetor antes de ordenar");
        for (int i = 0; i < vetor.length; i++){
            System.out.print(vetor[i] + ",");
        }
        System.out.println("");
        System.out.println("");

        Arrays.sort(vetor);
        System.out.println("Vetor depois de ordenar");
        for (int i = 0; i < vetor.length; i++) {
            System.out.println(vetor[i]);
        }

    }
}