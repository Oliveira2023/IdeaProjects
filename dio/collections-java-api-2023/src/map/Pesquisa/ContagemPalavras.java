package map.Pesquisa;

import java.util.HashMap;
import java.util.Map;

public class ContagemPalavras {
    private Map<String, Integer> palavras;

    public ContagemPalavras() {
        this.palavras = new HashMap<>();
    }

    public void adicionarPalavra(String linguagem, Integer contagem) {
        this.palavras.put(linguagem, contagem);
    }

    public void removerPalavra(String palavra) {
        if (!palavras.isEmpty()) {
            this.palavras.remove(palavra);
        }else {
            System.out.println("O Map está vazio");
        }
    }

    public int exibirContagemPalavras() {
        int contagemTotal = 0;
        if (!this.palavras.isEmpty()) {
            for (int contagem : this.palavras.values()) {
                contagemTotal += contagem;
            }
        }
        return contagemTotal;
    }

    public String encontrarPalavraMaisFrequente() {
        String linguagemFrequente = null;
        int contador = 0;
        if (!this.palavras.isEmpty()) {
            for (Map.Entry<String, Integer> palavra : palavras.entrySet()) {
                if(palavra.getValue() > contador) {
                    contador = palavra.getValue();
                    linguagemFrequente = palavra.getKey();
                }
            }
        }
        return linguagemFrequente;
    }

    public static void main(String[] args) {
        ContagemPalavras contagemLinguagens = new ContagemPalavras();

        contagemLinguagens.adicionarPalavra("Java", 2);
        contagemLinguagens.adicionarPalavra("Python", 8);
        contagemLinguagens.adicionarPalavra("JavaScript", 1);
        contagemLinguagens.adicionarPalavra("C#", 6);

        System.out.println("Existem: " + contagemLinguagens.exibirContagemPalavras() + " palavras");
//        contagemLinguagens.removerPalavra("Python");
        System.out.println("Existem: " + contagemLinguagens.exibirContagemPalavras() + " palavras");
        System.out.println("A linguagem mais frequente é: " + contagemLinguagens.encontrarPalavraMaisFrequente());
    }

}
