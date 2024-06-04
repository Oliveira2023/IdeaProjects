package list.Pesquisa;

import java.util.ArrayList;
import java.util.List;


public class CatalogoLivros {

    private List<Livro> livroList;
    public CatalogoLivros() {
        this.livroList = new ArrayList<>();
    }


    public void adicionarLivro(String titulo, String autor, int anoPublicacao) {
        this.livroList.add(new Livro(titulo, autor, anoPublicacao));
    }
    public List<Livro> pesquisaarPorAutor(String autor) {

        List<Livro> livrosPorAutor = new ArrayList<>();

        if (!this.livroList.isEmpty()) {

            for (Livro livro : this.livroList) {
                if (livro.getAutor().equalsIgnoreCase(autor)) {
                    livrosPorAutor.add(livro);
                }
            }
        }else {
            System.out.println("Lista vazia");
        }
        return livrosPorAutor;
    }
    public List<Livro> pesquisarPorIntervaloAnos(int anoInicial, int anoFinal) {

        List<Livro> livrosPorIntervaloAnos = new ArrayList<>();
        if (!this.livroList.isEmpty()) {
            for (Livro livro : this.livroList) {
                if (livro.getAnoPublicacao() >= anoInicial && livro.getAnoPublicacao() <= anoFinal) {
                    livrosPorIntervaloAnos.add(livro);
                }
            }
        }
        return livrosPorIntervaloAnos;
    }
    public Livro pesquisarPorTitulo(String titulo) {
        Livro livroPorTitulo = null;
        if (!this.livroList.isEmpty()) {
            for (Livro livro : this.livroList) {
                if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                    livroPorTitulo = livro;
                    break;
                }
            }
        }
        return livroPorTitulo;
    }

    public static void main(String[] args) {
        CatalogoLivros catalogoLivros = new CatalogoLivros();
        catalogoLivros.adicionarLivro("Livro 1", "Autor 1", 2020);
        catalogoLivros.adicionarLivro("Livro 1", "Autor 2", 2021);
        catalogoLivros.adicionarLivro("Livro 2", "Autor 2", 2022);
        catalogoLivros.adicionarLivro("Livro 3", "Autor 3", 2023);
        catalogoLivros.adicionarLivro("Livro 4", "Autor 4", 1994);
        catalogoLivros.adicionarLivro("Livro 5", "Autor 1", 2024);

//        System.out.println(catalogoLivros.pesquisaarPorAutor("Autor 4"));
//        System.out.println(catalogoLivros.pesquisarPorIntervaloAnos(2020, 2022));
        System.out.println(catalogoLivros.pesquisarPorTitulo("Livro 1"));
    }
}
