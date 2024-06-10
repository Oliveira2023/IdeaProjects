package funcional_interface.examples;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionExample {

    // Function<T,R>: Representa uma função que aceita um argumento do tipo T e Retorna um resultado
    // tipo R. É utilizada para transformar ou mapear os elementos do Streasm em outros valores ou tipos
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1,2,3,4,5);
        System.out.println(numeros);

        // Usar a função com expressao lambda para dobrar todos os numeros
        Function<Integer,Integer> dobrar = num -> num * 2;

        // usar a função para dobrar todos os números no Stream e armazená-los em outra lista
        List<Integer> numerosDobrados = numeros.stream()
                .map(n -> n *2)
                .toList();

        // imprimir a lista de numeros dobrados
        numerosDobrados.forEach(System.out::println);

    }
}
