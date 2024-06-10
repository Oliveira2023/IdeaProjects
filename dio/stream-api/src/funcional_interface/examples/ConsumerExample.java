package funcional_interface.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {

    // Consumer<T>: Representa uma operaçaõ que aceita um argumento do tipo T e não retorna nenhum
    // resultado. É utilizada principalmente para realizar ações ou efeitos colaterais nos elementos
    // do Stream sem modificar ou retornar um valor.
    public static void main(String[] args) {

        // Criar uma lista de números inteiros
        List<Integer> numeros = Arrays.asList(1,2,3,4,5,6,7);

        // Usar o Consumer com expressão lambda para imprimir números pares
        Consumer<Integer> imprimirnumeroPar = num -> {
            if (num % 2 == 0) {
                System.out.println(num);
            }
        };

        //usar o Consumer para imprimir numeros pares no Stream
        numeros.stream()
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);
    }
}
