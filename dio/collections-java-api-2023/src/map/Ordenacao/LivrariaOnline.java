package map.Ordenacao;

import java.util.*;

public class LivrariaOnline {

    private Map<String, Livro> livroMap;

    public LivrariaOnline() {
        this.livroMap = new HashMap<>();
    }
    public void adicionarLivro(String link, Livro livro) {
        livroMap.put(link, livro);
    }
    public Map<String, Livro> getLivroMap() {
        return livroMap;
    }
    public void removerLivro(String titulo) {
        List<String> chavesRemover = new ArrayList<>();

        if (!livroMap.isEmpty()) {
            for (Map.Entry<String, Livro> livro : livroMap.entrySet()) {
                if (livro.getValue().getTitulo().equals(titulo)) {
                    chavesRemover.add(livro.getKey());
                }
            }
            for (String chave : chavesRemover) {
                livroMap.remove(chave);
            }
        }
    }
    public Map<String, Livro> exibirLivrosOrdenadosPorPreco() {
        List<Map.Entry<String, Livro>> livrosParaOrdenarPorPreco = new ArrayList<>(livroMap.entrySet());

        Collections.sort(livrosParaOrdenarPorPreco, new ComparatorPorPreco());

        Map<String, Livro> livrosOrdenadoPorPreco = new LinkedHashMap<>();
        for (Map.Entry<String, Livro> livro : livrosParaOrdenarPorPreco) {
            livrosOrdenadoPorPreco.put(livro.getKey(), livro.getValue());
        }
        return livrosOrdenadoPorPreco;
    }

    public Map<String, Livro> exibirLivrosOrdenadosPorAutor() {
        List<Map.Entry<String, Livro>> livrosParaOrdenarPorAutor = new ArrayList<>(livroMap.entrySet());
        Collections.sort(livrosParaOrdenarPorAutor, new ComparatorPorAutor());

        Map<String, Livro> livrosOrdenadoPorAutor = new LinkedHashMap<>();
        for (Map.Entry<String, Livro> livro : livrosParaOrdenarPorAutor) {
            livrosOrdenadoPorAutor.put(livro.getKey(), livro.getValue());
        }
        return livrosOrdenadoPorAutor;
    }

    public Map<String, Livro> pesquisarLivrosPorAutor(String autor) {
        Map<String, Livro> livrosPorAutor = new LinkedHashMap<>();
        for (Map.Entry<String, Livro> entry : livroMap.entrySet()) {
            Livro livro = entry.getValue();
            if (livro.getAutor().equals(autor)) {
                livrosPorAutor.put(entry.getKey(), livro);
            }
        }
        return livrosPorAutor;
    }
    public List<Livro> obterLivroMaisCaro() {
        List<Livro> livrosMaisCaro = new ArrayList<>();
        double precoMaisAlto = Double.MIN_VALUE;

        if (!livroMap.isEmpty()) {
            for (Livro livro : livroMap.values()) {
                if (livro.getPreco() > precoMaisAlto) {
                    precoMaisAlto = livro.getPreco();
                }
            }
        }else {
            throw new NoSuchElementException("A livraria está vazia!");
        }
        for(Map.Entry<String, Livro> livro : livroMap.entrySet()) {
            if (livro.getValue().getPreco() == precoMaisAlto) {
                Livro livroComPrecoMaisAlto = livroMap.get(livro.getKey());
                livrosMaisCaro.add(livroComPrecoMaisAlto);
            }
        }
        return livrosMaisCaro;
    }
    public List<Livro> exibirLivroMaisBarato() {
        List<Livro> livrosMaisBarato = new ArrayList<>();
        double precoMaisBarato = Double.MAX_VALUE;

        if (!livroMap.isEmpty()) {
            for (Livro livro : livroMap.values()) {
                if (livro.getPreco() < precoMaisBarato) {
                    precoMaisBarato = livro.getPreco();
                }
            }
        }else {
            throw new NoSuchElementException("A livraria está vazia!");
        }
        for(Map.Entry<String, Livro> entry : livroMap.entrySet()) {
            if (entry.getValue().getPreco() == precoMaisBarato) {
                Livro livroComPrecoMaisBarato = livroMap.get(entry.getKey());
                livrosMaisBarato.add(livroComPrecoMaisBarato);
            }
        }
        return livrosMaisBarato;
    }

    public static void main(String[] args) {
        LivrariaOnline livrariaOnline = new LivrariaOnline();

        livrariaOnline.adicionarLivro("https://amzn.to/3EclT8Z", new Livro("1984", "George Orwell", 50d));
        livrariaOnline.adicionarLivro("https://amzn.to/47Umiun", new Livro("A Revolução dos Bichos", "George Orwell", 7.05d));
        livrariaOnline.adicionarLivro("https://amzn.to/3L1FFI6", new Livro("Caixa de Pássaros - Bird Box: Não Abra os Olhos", "Josh Malerman", 19.99d));
        livrariaOnline.adicionarLivro("https://amzn.to/3OYb9jk", new Livro("Malorie", "Josh Malerman", 5d));
        livrariaOnline.adicionarLivro("https://amzn.to/45HQE1L", new Livro("E Não Sobrou Nenhum", "Agatha Christie", 50d));
        livrariaOnline.adicionarLivro("https://amzn.to/45u86q4", new Livro("Assassinato no Expresso do Oriente", "Agatha Christie", 5d));

        //exibe os livros ordenados por preço
        System.out.println("Livros ordenados por preço: \n" + livrariaOnline.exibirLivrosOrdenadosPorPreco());

        //exibe os livros ordenados por autor
        System.out.println("Livros ordenados por autor: \n" + livrariaOnline.exibirLivrosOrdenadosPorAutor());

        //pesquisa livros por autor
        String autorPesquisa = "Josh Malerman";
        System.out.println("Pesquisa por Josh");
        System.out.println(livrariaOnline.pesquisarLivrosPorAutor(autorPesquisa));

        //Obtém e exibe o livro mais caro
        System.out.println("Livro mais caro " + livrariaOnline.obterLivroMaisCaro());

        //Obtém e exibe o livro mais barato
        System.out.println("Livro mais barato: " + livrariaOnline.exibirLivroMaisBarato());

        // Remover um livro pelo título
        livrariaOnline.removerLivro("1984");
        System.out.println(livrariaOnline.livroMap);
    }
}
