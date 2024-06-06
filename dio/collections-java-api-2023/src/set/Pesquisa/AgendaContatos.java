package set.Pesquisa;

import java.util.HashSet;
import java.util.Set;

public class AgendaContatos {
    private Set<Contato> contatoSet;

    public AgendaContatos() {
        this.contatoSet = new HashSet<>();
    }
    public void adicionarContato(String nome, int telefone) {
        this.contatoSet.add(new Contato(nome, telefone));
    }
    public void exibirContatos() {
        System.out.println(contatoSet);
    }
    public Set<Contato> pesquisarPorNome(String nome) {
        Set<Contato> contatosPorNome = new HashSet<>();
        for (Contato contato : this.contatoSet) {
            if (contato.getNome().startsWith(nome)) {
                contatosPorNome.add(contato);
            }
        }
        return contatosPorNome;
    }
    public Contato atualizarContato(String nome, int novoTelefone) {
        Contato contatoAtualizado = null;
        for (Contato contato : this.contatoSet) {
            if (contato.getNome().equalsIgnoreCase(nome)) {
                contato.setTelefone(novoTelefone);
                contatoAtualizado = contato;
                break;
            }
        }
        return contatoAtualizado;
    }

    public static void main(String[] args) {
        AgendaContatos agenda = new AgendaContatos();
        agenda.exibirContatos();

        agenda.adicionarContato("Camila", 123456);
        agenda.adicionarContato("Camila", 56665);
        agenda.adicionarContato("Camila Cavalcante", 111111);
        agenda.adicionarContato("Camila DIO", 654987);
        agenda.adicionarContato("Maria Silva", 11111111);

        agenda.exibirContatos();

        System.out.println("Pesquisa contato: Camila");
        System.out.println(agenda.pesquisarPorNome("Maria"));

        System.out.println("Contato Atualizado" + agenda.atualizarContato("Maria Silva", 555555));

        agenda.exibirContatos();
    }
}
