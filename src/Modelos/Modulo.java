package Modelos;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa um Módulo de ensino dentro da plataforma EAD.
 * Esta classe agrupa um conjunto de conteúdos e a lista de alunos matriculados.
 */

public class Modulo {
    private int id;
    private String titulo;
    private float cargaHoraria;

    /**
     * Lista de conteúdos pertencentes a este módulo.
     * Esta é a conexão principal com o padrão Flyweight. Os objetos 'Conteudo'
     * nesta lista são os flyweights compartilhados.
     */
    private List<Conteudo> conteudos = new ArrayList<>();

    /**
     * Lista de alunos que estão matriculados neste módulo.
     */
    private List<Aluno> alunosMatriculados = new ArrayList<>();

    // --- CONSTRUTOR ---

    // Métodos padrão para acessar e modificar os atributos da classe.
    public Modulo(int id, String titulo, float cargaHoraria) {
        this.id = id;
        this.titulo = titulo;
        this.cargaHoraria = cargaHoraria;
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

    /**
     * Adiciona um conteúdo à lista de conteúdos do módulo.
     * O objeto 'Conteudo' recebido aqui é geralmente uma instância gerenciada
     * pela ConteudoFactory (Flyweight), podendo ser compartilhada com outros módulos.
     * c: O conteúdo (Flyweight) a ser adicionado.
     */
    public void adicionarConteudo(Conteudo c) { conteudos.add(c); }

    /**
     * Adiciona um aluno à lista de matriculados neste módulo.
     * a: O aluno a ser adicionado.
     */
    public void adicionarAluno(Aluno a) { alunosMatriculados.add(a); }
}
