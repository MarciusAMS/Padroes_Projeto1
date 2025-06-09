package Modelos;

import java.util.ArrayList;
import java.util.List;

public class Modulo {
    private int id;
    private String titulo;
    private List<Conteudo> conteudos = new ArrayList<>();
    private List<Aluno> alunosMatriculados = new ArrayList<>();

    // --- CONSTRUTOR ---
    public Modulo(int id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    // --- GETTERS E SETTERS ---
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

    public List<Conteudo> getConteudos() {
        return conteudos;
    }

    public void setConteudos(List<Conteudo> conteudos) {
        this.conteudos = conteudos;
    }

    public List<Aluno> getAlunosMatriculados() {
        return alunosMatriculados;
    }

    public void setAlunosMatriculados(List<Aluno> alunosMatriculados) {
        this.alunosMatriculados = alunosMatriculados;
    }

    public void adicionarConteudo(Conteudo c) { conteudos.add(c); }
    public void adicionarAluno(Aluno a) { alunosMatriculados.add(a); }
}
