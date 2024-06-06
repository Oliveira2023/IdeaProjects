package set.OperacoesBasicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoConvidados {

    private Set<Convidado> convidadoSet;
    public ConjuntoConvidados() {
        this.convidadoSet = new HashSet<>();
    }
    public void adicionarConvidado(String nome, int codigoConvite) {
        convidadoSet.add(new Convidado(nome, codigoConvite));
    }
    public void removerConvidadoPorCodigoConvite(int codigoConvite) {
        Convidado convidadoParaRemover = null;

        for (Convidado convidado : convidadoSet) {

            if (convidado.getCodigoConvite() == codigoConvite) {
                convidadoParaRemover = convidado;
                break;
            }
        }
        if (convidadoParaRemover != null) {
            convidadoSet.remove(convidadoParaRemover);
        }else {
            System.out.println("Convidado nao encontrado");
        }
    }
    public int contarConvidados() {
        return convidadoSet.size();
    }
    public void exibirConvidados() {

        for (Convidado convidado : convidadoSet) {
            System.out.println(convidado);
        }
    }

    public static void main(String[] args) {
        ConjuntoConvidados conjuntoConvidados = new ConjuntoConvidados();
        conjuntoConvidados.adicionarConvidado("convidado 1", 1234);
        conjuntoConvidados.adicionarConvidado("convidado 2", 1235);
        conjuntoConvidados.adicionarConvidado("convidado 3", 1236);
        conjuntoConvidados.adicionarConvidado("convidado 4", 1237);

        System.out.println("Convidados adicionados com sucesso");

        System.out.println("Existem " + conjuntoConvidados.contarConvidados() + " convidados");

        conjuntoConvidados.removerConvidadoPorCodigoConvite(1234);
        System.out.println("Existem " + conjuntoConvidados.contarConvidados() + " convidados");
        conjuntoConvidados.exibirConvidados();
    }
}
