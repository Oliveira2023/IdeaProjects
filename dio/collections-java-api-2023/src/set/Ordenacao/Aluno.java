package set.Ordenacao;

import java.util.Comparator;
import java.util.Objects;

public class Aluno implements Comparable<Aluno> {


    private String nome;
    private long matricula;
    private double nota;

    public Aluno(String nome, long matricula, double nota) {
        this.nome = nome;
        this.matricula = matricula;
        this.nota = nota;
    }
    public String getNome() {
        return nome;
    }

    public long getMatricula() {
        return matricula;
    }

    public double getNota() {
        return nota;
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", matricula='" + matricula + '\'' +
                ", nota=" + nota +
                '}' + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Aluno aluno)) return false;
        return Objects.equals(getMatricula(), aluno.getMatricula());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getMatricula());
    }
    @Override
    public int compareTo(Aluno a) {
        return nome.compareTo(a.getNome());
    }
}
class compararPorNota implements Comparator<Aluno> {

    @Override
    public int compare(Aluno o1, Aluno o2) {
        return Double.compare(o1.getNota(), o2.getNota());
    }
}
