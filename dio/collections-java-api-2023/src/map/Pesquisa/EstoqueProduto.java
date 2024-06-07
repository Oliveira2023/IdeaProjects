package map.Pesquisa;

import java.util.HashMap;
import java.util.Map;

public class EstoqueProduto {

    private Map<Long, Produto> estoqueProdutosMap;

    public EstoqueProduto() {
        this.estoqueProdutosMap = new HashMap<>();
    }
    public void adicionaProduto(long codigo, String nome, int quantidade, double preco) {
        estoqueProdutosMap.put(codigo, new Produto(nome, preco, quantidade));
    }
    public void exibirProdutos() {
        System.out.println(estoqueProdutosMap);
    }
    public double calcularValorTotalEstoque() {
        double totalEstoque = 0d;
        if (!estoqueProdutosMap.isEmpty()) {
            for (Produto produto : estoqueProdutosMap.values()) {
                totalEstoque += produto.getPreco() * produto.getQuantidade();
            }
        }
        return totalEstoque;
    }
    public Produto obterProdutoMaisCaro() {
        Produto produtoMaisCaro = null;
        double maiorPreco = Double.MIN_VALUE;//isso é só pra confundir..kk é min valor positivo. não pode ser negativo
        if (!estoqueProdutosMap.isEmpty()) {
            for (Produto produto : estoqueProdutosMap.values()) {
                if (produto.getPreco() > maiorPreco) {
                    produtoMaisCaro = produto;
                    maiorPreco = produto.getPreco();
                }
            }

        }
        return produtoMaisCaro;
    }
    public Produto obterProdutoMaisBarato() {
        Produto produtoMaisBarato = null;
        double menorPreco = Double.MAX_VALUE;
        if (!estoqueProdutosMap.isEmpty()) {
            for (Produto produto : estoqueProdutosMap.values()) {
                if (produto.getPreco() < menorPreco) {
                    menorPreco = produto.getPreco();
                    produtoMaisBarato = produto;
                }
            }
        }
        return produtoMaisBarato;
    }
    public Produto obterProdutoMaiorQuantidadeValorTotalNoEstoque() {
        Produto produtoMaiorQuantidadeValorTotalNoEstoque = null;
        double maiorTotal = 0d;
        if (!estoqueProdutosMap.isEmpty()) {
            for (Produto produto : estoqueProdutosMap.values()) {
                double totalProduto = produto.getPreco() * produto.getQuantidade();
                if (totalProduto > maiorTotal) {
                    maiorTotal = totalProduto;
                    produtoMaiorQuantidadeValorTotalNoEstoque = produto;
                }
            }
        }
        return produtoMaiorQuantidadeValorTotalNoEstoque;
    }

    public static void main(String[] args) {
        EstoqueProduto estoqueProduto = new EstoqueProduto();

        estoqueProduto.adicionaProduto(1L, "Produto A", 10, 5.0);
        estoqueProduto.adicionaProduto(4L, "Produto A", 1, 45.0);
        estoqueProduto.adicionaProduto(2L, "Produto b", 5, 11.0);
        estoqueProduto.adicionaProduto(3L, "Produto c", 2, 15.0);

        estoqueProduto.exibirProdutos();
//        System.out.println("Total do estoque: " + estoqueProduto.calcularValorTotalEstoque());
        System.out.println("Produto mais caro: " + estoqueProduto.obterProdutoMaisCaro());
        System.out.println("Produto mais barato: " + estoqueProduto.obterProdutoMaisBarato());
        System.out.println("Produto com maior valor de estoque: " + estoqueProduto.obterProdutoMaiorQuantidadeValorTotalNoEstoque());
    }
}
