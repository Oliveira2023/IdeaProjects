package map.OperacoesBasicas;

import java.util.HashMap;
import java.util.Map;

public class AgendaContatos {
    private Map<String, Integer> agendaContatoMap;

    public AgendaContatos() {
        agendaContatoMap = new HashMap<>();
    }
    public void adicionaContato(String nome, Integer telefone) {
        agendaContatoMap.put(nome, telefone);
    }
    public void removerContato(String nome) {
        if (!agendaContatoMap.isEmpty()) {
            agendaContatoMap.remove(nome);
        }
    }
    public void exibeContatos() {
        System.out.println(agendaContatoMap);
    }
    public Integer pesquisarPorNome(String nome) {
        Integer numeroPorNome = null;
        if (!agendaContatoMap.isEmpty()) {
            numeroPorNome = agendaContatoMap.get(nome);
        }
        return numeroPorNome;
    }

    public static void main(String[] args) {
        AgendaContatos agendaContatos = new AgendaContatos();

        agendaContatos.adicionaContato("Camila", 123456);
        agendaContatos.adicionaContato("Camila", 123457);
        agendaContatos.adicionaContato("Camila Cavalcane", 123458);
        agendaContatos.adicionaContato("Camila DIO", 123459);
        agendaContatos.adicionaContato("Maria Silva", 123466);
        agendaContatos.adicionaContato("Camila", 123476);

        agendaContatos.exibeContatos();

        agendaContatos.removerContato("Maria Silva");
//        agendaContatos.exibeContatos();

        System.out.println("o numero de Camila DIO é: " + agendaContatos.pesquisarPorNome("Camila DIO"));
    }
}
