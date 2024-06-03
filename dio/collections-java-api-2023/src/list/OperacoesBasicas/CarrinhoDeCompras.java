package list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {

    private List<Item> listaItems;

    public CarrinhoDeCompras() {
        listaItems = new ArrayList<>();
    }

    public void adicionaItem(String nome, double preco, int quantidade) {
        listaItems.add(new Item(nome, preco, quantidade));
    }
    public void removerItem(String nome){
        List<Item> listaItemsRemover = new ArrayList<>();
        if (!listaItems.isEmpty()) {
            for(Item item : listaItems){
                if(item.getNome().equalsIgnoreCase(nome)){
                    listaItemsRemover.add(item);
                }
            }
            listaItems.removeAll(listaItemsRemover);
        } else {
            System.out.println("A lista esta vazia!");
        }

    }
    public void calcularValorTotal(){
        double total = 0;
        double totalItem = 0;
        for(Item item : listaItems){
            totalItem = item.getQuantidade() * item.getPreco();
            total += totalItem;
        }
        System.out.println("Total: " + total);;
    }
    public void imprimeLista(){
        System.out.println(listaItems);
    }

    public static void main(String[] args) {
        //criando uma instancia do carrinho de compras
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();

        carrinhoDeCompras.adicionaItem("sabão", 35d, 2);
        carrinhoDeCompras.adicionaItem("sucrilhos", 15d, 1);
        carrinhoDeCompras.adicionaItem("bolacha", 5d, 1);
        carrinhoDeCompras.adicionaItem("feijão", 10d, 2);

        carrinhoDeCompras.removerItem("sucrilhos");

        carrinhoDeCompras.calcularValorTotal();

        carrinhoDeCompras.imprimeLista();

    }

}
