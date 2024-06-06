package set.Pesquisa;

import java.util.Objects;

public class Contato {

    private String nome;
    private int telefone;

    public Contato(String nome, int telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    public int getTelefone() {
        return telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "{" +
                "'" + nome + '\'' +
                ", '" + telefone + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contato contato)) return false;
        return Objects.equals(getNome(), contato.getNome());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getNome());
    }
}
