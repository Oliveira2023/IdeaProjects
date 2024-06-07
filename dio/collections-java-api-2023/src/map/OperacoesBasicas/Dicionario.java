package map.OperacoesBasicas;

import java.util.HashMap;
import java.util.Map;

public class Dicionario {

    private Map<String, String> dicionario;

    public Dicionario() {
        this.dicionario = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, String definicao) {
        this.dicionario.put(palavra, definicao);
    }
    public void removerPalavra(String palavra) {
        if (!this.dicionario.isEmpty()) {
            this.dicionario.remove(palavra);
        }else {
            System.out.println("O dicionário está vazio.");
        }
    }
    public void exibirPalavras() {
        if (!this.dicionario.isEmpty()) {
            System.out.println(dicionario);
        }else {
            System.out.println("O dicionário está vazio.");
        }
    }
    public String pesquisarPorPalavra(String palavra) {
        String definicaoPalavra = this.dicionario.get(palavra);
        return definicaoPalavra;
    }

    public static void main(String[] args) {
        Dicionario dicionario = new Dicionario();
        dicionario.adicionarPalavra("descobrir", "encontrar algo novo");
        dicionario.adicionarPalavra("abacate", "Fruta com caroço");
//        dicionario.removerPalavra("abacate");
//        dicionario.exibirPalavras();
        System.out.println(dicionario.pesquisarPorPalavra("descobrir"));

    }
}
