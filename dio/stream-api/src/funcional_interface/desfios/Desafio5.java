package funcional_interface.desfios;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Desafio5 {

    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);

        List<Integer> numerosMaioresQ5 = numeros.stream()
                .filter(n -> n > 5)
                .toList();

        int size = numerosMaioresQ5.size();
        int somatorio = numerosMaioresQ5.stream()
                .reduce(0, (a, b) -> a + b);

        System.out.println(somatorio/size);
    }
}
