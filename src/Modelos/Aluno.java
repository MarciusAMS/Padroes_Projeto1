package Modelos;
import Padroes.Observer.Observer;
import Padroes.Strategy.AtualizacaoProgressoStrategy;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
    private int id;
    private String nome;
    private String email;
    private float progresso;
    private List<Modulo> modulosMatriculados = new ArrayList<>();
    private List<Notificacao> notificacoes = new ArrayList<>();
    private AtualizacaoProgressoStrategy estrategiaProgresso;

    public Aluno(int id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.progresso = 0.0f; // Inicializa o progresso como 0
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getProgresso() {
        return progresso;
    }

    public void setProgresso(float progresso) {
        this.progresso = progresso;
    }

    public List<Modulo> getModulosMatriculados() {
        return modulosMatriculados;
    }

    public void setModulosMatriculados(List<Modulo> modulosMatriculados) {
        this.modulosMatriculados = modulosMatriculados;
    }

    public List<Notificacao> getNotificacoes() {
        return notificacoes;
    }

    public void setNotificacoes(List<Notificacao> notificacoes) {
        this.notificacoes = notificacoes;
    }

    public AtualizacaoProgressoStrategy getEstrategiaProgresso() {
        return estrategiaProgresso;
    }

    public void setEstrategiaProgresso(AtualizacaoProgressoStrategy estrategiaProgresso) {
        this.estrategiaProgresso = estrategiaProgresso;
    }

    public void matricular(Modulo modulo) { modulosMatriculados.add(modulo); }
    public void adicionarNotificacao(Notificacao n) { notificacoes.add(n); }
    // ... métodos de estratégia já mostrados ...
    // Método que DELEGA a ação para a estratégia
    public void atualizarProgresso(Modulo modulo, float progresso) {
        if (estrategiaProgresso != null) {
            estrategiaProgresso.atualizar(this, modulo, progresso);
        } else {
            System.out.println("Nenhuma estratégia de progresso definida.");
        }
    }
}


