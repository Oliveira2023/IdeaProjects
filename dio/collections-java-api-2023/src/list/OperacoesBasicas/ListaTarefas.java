package list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class ListaTarefas {
    //atributo
    private List<Tarefa> tarefaList;

    //construtor já criando uma lista vazia esperando para adicionar itens
    public ListaTarefas() {
        this.tarefaList = new ArrayList<>();
    }

    public void adicionarTarefa(String descricao) {

    this.tarefaList.add(new Tarefa(descricao));
    }

    public void removerTarefa(String descricao) {
        List<Tarefa> tarefasParaRemover = new ArrayList<>();
        for (Tarefa t : this.tarefaList) {
            if (t.getDescricao().equalsIgnoreCase(descricao)) {
                tarefasParaRemover.add(t);
            }
        }
        this.tarefaList.removeAll(tarefasParaRemover);
    }
    public int quantidadeTarefas() {
    return this.tarefaList.size();
    }
    public void obterDescricoesTarefas() {
        System.out.println(tarefaList);
    }
//    public void imprimirTarefas() {
//        for (Tarefa t : this.tarefaList) {
//            System.out.println(t.getDescricao());
//        }
//    }

    public static void main(String[] args) {
        ListaTarefas listaTarefas = new ListaTarefas();
        System.out.println("o numero total de elentos na lista é: " + listaTarefas.quantidadeTarefas());

        listaTarefas.adicionarTarefa("Tarefa 1");
        listaTarefas.adicionarTarefa("Tarefa 2");
        listaTarefas.adicionarTarefa("Tarefa 3");
        System.out.println("o numero total de elentos na lista é: " + listaTarefas.quantidadeTarefas());

        listaTarefas.removerTarefa("Tarefa 2");
        System.out.println("o numero total de elentos na lista é: " + listaTarefas.quantidadeTarefas());

        listaTarefas.obterDescricoesTarefas();
    }
}
