package funcional_interface.desfios;

import java.util.List;
import java.util.Arrays;

public class Desafio2 {

    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);

        int somaNumerosPares = numeros.stream()
                .filter(num -> num % 2 == 0)
                .reduce(0, Integer::sum);

        System.out.println(somaNumerosPares);
    }
}
