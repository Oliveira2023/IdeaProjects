package set.Pesquisa;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListaTarefas {
    private Set<Tarefa> tarefas;
    public ListaTarefas() {
        tarefas = new HashSet<Tarefa>();
    }
    public void adicionaTarefa(String descricao) {
        tarefas.add(new Tarefa(descricao));
    }
    public void removerTarefa(String descricao) {
        Tarefa tarefaParaRemover = null;
        if (!tarefas.isEmpty()) {
            for (Tarefa tarefa : tarefas) {
                if (tarefa.getDescricao().equalsIgnoreCase(descricao)) {
                    tarefaParaRemover = tarefa;
                    break;
                }
            }
            tarefas.remove(tarefaParaRemover);
        }else {
            System.out.println("O conjunto está vazio");
        }

        if (tarefaParaRemover == null) {
            System.out.println("Nenhuma tarefa enconctrada");
        }
    }
    public void exibirTarefas() {
        if (!tarefas.isEmpty()) {
            System.out.println(tarefas);
        }else {
            System.out.println("Nenhuma tarefa encontrada");
        }
    }
    public void contarTarefas() {
        System.out.println("Quantidade de tarefas: " + tarefas.size());
    }
    public Set<Tarefa> obterTarefasConcluidas() {
        Set<Tarefa> tarefasConcluidas = new HashSet<>();
        if (tarefas.size() > 0) {
            for (Tarefa tarefa : tarefas) {
                if (tarefa.isConcluida()) {
                    tarefasConcluidas.add(tarefa);
                }
            }
            System.out.println("Tarefas concluidas:");
            System.out.println(tarefasConcluidas);
        }else {
            System.out.println("Nenhuma tarefa encontrada");
        }
        return tarefasConcluidas;
    }
    public Set<Tarefa> obterTarefasPendentes() {
        Set<Tarefa> tarefasPendentes = new HashSet<>();
        if (tarefas.size() > 0) {
            for (Tarefa tarefa : tarefas) {
                if (!tarefa.isConcluida()) {
                    tarefasPendentes.add(tarefa);
                }
            }
            System.out.println("Tarefas Pendentes:");
            System.out.println(tarefasPendentes);
        }else {
            System.out.println("Nenhuma tarefa");
        }
        return tarefasPendentes;
    }
    public void marcarTarefaConcluida(String descricao) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getDescricao().equalsIgnoreCase(descricao)) {
                tarefa.setConcluida(true);
            }
        }
    }
    public void marcarTarefaPendente(String descricao) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getDescricao().equalsIgnoreCase(descricao)) {
                tarefa.setConcluida(false);
                break;
            }
        }
    }
    public void limparListaTarefas() {
        tarefas.clear();
    }

    public static void main(String[] args) {
        ListaTarefas listaTarefas = new ListaTarefas();
        listaTarefas.adicionaTarefa("Tarefa 1");
        listaTarefas.adicionaTarefa("Tarefa 2");
        listaTarefas.adicionaTarefa("Tarefa 3");
        listaTarefas.adicionaTarefa("Tarefa 4");
        listaTarefas.adicionaTarefa("Tarefa 5");

        listaTarefas.removerTarefa("tarefa 3");


        listaTarefas.contarTarefas();
        listaTarefas.marcarTarefaPendente("tarefa 1");
        listaTarefas.marcarTarefaPendente("tarefa 2");
//        listaTarefas.exibirTarefas();
//        listaTarefas.marcarTarefaConcluida("tarefa 2");
//        listaTarefas.exibirTarefas();
//        listaTarefas.obterTarefasConcluidas();
        listaTarefas.obterTarefasPendentes();
//        listaTarefas.limparListaTarefas();
        System.out.println("----------");
        listaTarefas.exibirTarefas();
    }



}
