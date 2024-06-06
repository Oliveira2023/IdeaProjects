package set.OperacoesBasicas;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ConjuntoPalavrasUnicas {
    private Set<String> palavras;

    public ConjuntoPalavrasUnicas() {
        this.palavras = new HashSet<>();
    }

    public void adicionarPalavra(String palavra) {
        palavras.add(palavra);
    }
    public void removerPalavra(String palavra) {
        String palavraParaRemover = null;
        for (int i = 0; i < palavras.size(); i++) {}
        for (String p: palavras) {
            if (palavra.equals(p)) {
                palavras.remove(p);
                break;
            }
        }
        palavras.remove(palavra);
    }
    public void verificarPalavra(String palavra) {
        String palavraEncontrada = null;
        for (String p: palavras) {
            if (p.equalsIgnoreCase(palavra)) {
                palavraEncontrada = p;
                break;
            }
        }
        if (palavraEncontrada == null) {
            System.out.println("Nenhuma palavra encontrada");
        }else {
            System.out.println("A palavra => " + palavraEncontrada + ", está no conjunto de palavras");
        }
    }
    public void exibirPalavras() {

        System.out.println(palavras);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ConjuntoPalavrasUnicas that)) return false;
        return Objects.equals(palavras, that.palavras);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(palavras);
    }

    @Override
    public String toString() {
        return "ConjuntoPalavrasUnicas{" +
                "palavras=" + palavras +
                '}';
    }

    public static void main(String[] args) {
        ConjuntoPalavrasUnicas conjunto = new ConjuntoPalavrasUnicas();
        conjunto.adicionarPalavra("Palavra 1");
        conjunto.adicionarPalavra("Palavra 2");
        conjunto.adicionarPalavra("Palavra 3");
        conjunto.adicionarPalavra("Palavra 4");
        conjunto.adicionarPalavra("Palavra 5");

        conjunto.removerPalavra("Palavra 3");
        conjunto.exibirPalavras();
        conjunto.verificarPalavra("palavra 7");
    }
}
