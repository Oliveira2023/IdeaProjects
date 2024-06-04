package list.Pesquisa;

import java.util.ArrayList;
import java.util.List;

public class SomaNumeros {

    private List<Integer> listaNumeros;

    public SomaNumeros(){
        listaNumeros = new ArrayList<>();
    }

    public void adicionarNumero(int numero) {
        listaNumeros.add(numero);
    }
    public int calcularSoma() {
        int soma = 0;
        if (listaNumeros.size() > 0) {
            for (Integer numero : listaNumeros) {
                soma = soma + numero;
            }
        }
        return soma;
    }
    public int encontrarMaiorNumero() {
        int maior = Integer.MIN_VALUE;
        if (listaNumeros.size() > 0) {
            for (Integer numero : listaNumeros) {
                if (numero > maior) {
                    maior = numero;
                }
            }
            return maior;
        }else {
            throw new RuntimeException("A lista está vazia!");
        }
    }
    public int encontrarMenorNumero() {
        int menor = Integer.MAX_VALUE;
        if (listaNumeros.size() > 0) {

            for (Integer numero : listaNumeros) {
                if (numero < menor) {
                    menor = numero;
                }
            }
            return menor;
        }else {
            throw new RuntimeException("A lista esta vazia");
        }
    }
    public void exibirNumeros() {
        if(!listaNumeros.isEmpty()) {
            System.out.println(this.listaNumeros);
        }else {
            System.out.println("Lista vazia");
        }
    }

    public static void main(String[] args) {
        SomaNumeros somaNumeros = new SomaNumeros();
        somaNumeros.adicionarNumero(45);
        somaNumeros.adicionarNumero(5);
        somaNumeros.adicionarNumero(35);
        somaNumeros.adicionarNumero(65);

        System.out.println(somaNumeros.calcularSoma());
        System.out.println(somaNumeros.encontrarMaiorNumero());
        System.out.println(somaNumeros.encontrarMenorNumero());
        somaNumeros.exibirNumeros();
    }

}
