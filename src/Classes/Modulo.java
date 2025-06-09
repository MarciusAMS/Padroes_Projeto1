//package Classes;
//
//import Interfaces.Observer.Observador;
//import Interfaces.Sujeito.Sujeito;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Modulo implements Sujeito {
//    private String nome;
//    private List<Observador> alunos = new ArrayList<>();
//
//    public Modulo(String nome) {
//        this.nome = nome;
//    }
//
//    public void adicionar(Observador o) {
//        alunos.add(o);
//    }
//
//    @Override
//    public void remover(Observador o) {
//        alunos.remove(o);
//    }
//
//    @Override
//    public void notificar(String mensagem) {
//        for (Observador o : alunos) {
//            o.atualizar(mensagem);
//        }
//    }
//
//    public void publicarConteudo(String conteudo) {
//        System.out.println("Módulo " + nome + " publicou: " + conteudo);
//        notificar("Novo conteúdo publicado no módulo " + nome + ": " + conteudo);
//    }
//}

package Classes;
import Classes.Flyweight.Conteudo;

import java.util.ArrayList;
import java.util.List;

public class Modulo {
    private int id;
    private String titulo;
    private String descricao;
    private List<Aluno> alunosMatriculados;
    private List<Conteudo> conteudos;
    private float cargaHoraria;

    // Construtor
    public Modulo(int id, String titulo, String descricao, float cargaHoraria) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.cargaHoraria = cargaHoraria;
        this.alunosMatriculados = new ArrayList<>();
        this.conteudos = new ArrayList<>();
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(float cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public List<Aluno> getAlunosMatriculados() {
        return alunosMatriculados;
    }

    public List<Conteudo> getConteudos() {
        return conteudos;
    }

    // Métodos da classe

    public void adicionarConteudo(Conteudo conteudo) {
        conteudos.add(conteudo);
    }

    public void removerConteudo(Conteudo conteudo) {
        conteudos.remove(conteudo);
    }

    public List<Conteudo> listarConteudos() {
        return new ArrayList<>(conteudos);
    }

    public List<Aluno> listarAlunos() {
        return new ArrayList<>(alunosMatriculados);
    }

    public void matricularAluno(Aluno aluno) {
        if (!alunosMatriculados.contains(aluno)) {
            alunosMatriculados.add(aluno);
        }
    }

    public void removerAluno(Aluno aluno) {
        alunosMatriculados.remove(aluno);
    }
}
