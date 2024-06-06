package set.Ordenacao;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class GerenciadorAlunos {
    private Set<Aluno> alunoSet;

    public GerenciadorAlunos() {
        alunoSet = new HashSet<>();
    }
    public void adicionarAluno(String nome, Long matricula, double media) {
        alunoSet.add(new Aluno(nome, matricula, media));
    }
    public void removerAluno(long matricula) {
        Aluno alunoParaRemover = null;
        if (!alunoSet.isEmpty()) {
            Iterator<Aluno> iterator = alunoSet.iterator();
            while (iterator.hasNext()) {
                Aluno aluno = iterator.next();
                if (aluno.getMatricula() == matricula) {
                    alunoParaRemover = aluno;
                    //                iterator.remove();
                    break;
                }
            }
            alunoSet.remove(alunoParaRemover);
        } else {
            throw new RuntimeException("O conjunto está vazio!");
        }
        if (alunoParaRemover == null) {
            System.out.println("Matrícula não encontrada");
        }
    }

    public void exibirAlunosPorNome() {
        Set<Aluno> alunosPorNome = new TreeSet<>(alunoSet);
        if (!alunoSet.isEmpty()) {
            System.out.println(alunosPorNome);
        }else {
            System.out.println("Nenhum aluno encontrado");
        }
    }
    public void exibirAlunosPorNota() {
        Set<Aluno> alunosPorNota = new TreeSet<>(new compararPorNota());
        if (!alunoSet.isEmpty()) {
            alunosPorNota.addAll(alunoSet);
            System.out.println(alunosPorNota);
        }else {
            System.out.println("O consunto está vazio!");
        }
    }

    public void exibirAlunos() {
        if (!alunoSet.isEmpty()) {
            System.out.println(alunoSet);
        }else {
            System.out.println("O set de alunos está vazio");
        }
    }

    public static void main(String[] args) {
        GerenciadorAlunos gerenciador = new GerenciadorAlunos();
        gerenciador.exibirAlunos();

        gerenciador.adicionarAluno("Luciano", 4539L, 7.5);
        gerenciador.adicionarAluno("Antonio", 4538L, 8.5);
        gerenciador.adicionarAluno("Carlos", 4537L, 6.5);
        gerenciador.adicionarAluno("Guilherme", 4536L, 7d);

        gerenciador.exibirAlunos();
//        gerenciador.exibirAlunosPorNome();
//        gerenciador.exibirAlunosPorNota();
        gerenciador.removerAluno(4547);
        gerenciador.exibirAlunos();
    }
}
