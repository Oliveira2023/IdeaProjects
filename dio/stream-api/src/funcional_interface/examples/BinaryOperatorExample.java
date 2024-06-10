package funcional_interface.examples;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class BinaryOperatorExample {
    /* Representa uma operação que ombina dois argumentos do tipo T e retorna um resultado do mesmo tipo T;
    é usada para realizar operações de redução em pares de elementos, como somar números ou combinar objetos
     */
    public static void main(String[] args) {
        //criar uma lista de numeros inteiros
        List<Integer> numeros = Arrays.asList(1,2,3,4,5,6,7,8,9);

        // Usar o BinaryOperator com expressão lambda para somar dois numeros inteiros
        BinaryOperator<Integer> somar = (num1, num2) -> num1 + num2;

        // usar o BinaryOperator para somar todos os numeros no Stream
        int resultado = numeros.stream()
                .reduce(0, Integer::sum);

        System.out.println(resultado);
    }
}
