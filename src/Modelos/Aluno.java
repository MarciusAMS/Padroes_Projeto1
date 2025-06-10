package Modelos;
import Padroes.Observer.Observer;
import Padroes.Strategy.AtualizacaoProgressoStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa um Aluno na plataforma EAD. Esta é uma classe de modelo central.
 * Ela interage com múltiplos padrões de projeto de diferentes maneiras:
 *
 * - STRATEGY: Atua como o "Context" para o padrão Strategy. Ela possui um objeto
 * de estratégia (AtualizacaoProgressoStrategy) e delega a ele o algoritmo
 * de como o progresso deve ser calculado.
 *
 * - OBSERVER: É um participante passivo do padrão Observer. Ela não é um Observer
 * nem um Subject, mas é o *alvo* da ação de um Observer. A classe
 * 'ServicoDeNotificacao' (um Observer) adiciona objetos 'Notificacao' a este aluno.
 *
 * - FLYWEIGHT: Beneficia-se indiretamente do padrão Flyweight. Ao se matricular
 * em Módulos, esses módulos contêm Conteúdos que são objetos Flyweight (compartilhados),
 * resultando em uma economia de memória geral no sistema.
 */

public class Aluno {
    private int id;
    private String nome;
    private String email;
    private float progresso;

    // Lista de módulos em que o aluno está matriculado.
    private List<Modulo> modulosMatriculados = new ArrayList<>();

    // Lista de notificações recebidas pelo aluno.
    private List<Notificacao> notificacoes = new ArrayList<>();

    // Referência para a estratégia de cálculo de progresso, Padrão Strategy.
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

    /**
     * Define a estratégia de cálculo de progresso a ser usada.
     * Permite que o algoritmo de cálculo seja trocado em tempo de execução.
     * estrategiaProgresso: A implementação da estratégia a ser utilizada.
     */

    public void setEstrategiaProgresso(AtualizacaoProgressoStrategy estrategiaProgresso) {
        this.estrategiaProgresso = estrategiaProgresso;
    }

    // --- Métodos de Ação ---

    /**
     * Adiciona uma notificação à lista do aluno.
     * Este método é o ponto de conexão com o padrão Observer. Ele é chamado
     * pelo 'ServicoDeNotificacao' quando um evento relevante para o aluno ocorre.
     * A notificação a ser adicionada.
     */

    public void matricular(Modulo modulo) { modulosMatriculados.add(modulo); }
    public void adicionarNotificacao(Notificacao n) { notificacoes.add(n); }

    // Método que DELEGA a ação para a estratégia

    public void atualizarProgresso(Modulo modulo, float progresso) {
        if (estrategiaProgresso != null) {
            estrategiaProgresso.atualizar(this, modulo, progresso);
        } else {
            System.out.println("Nenhuma estratégia de progresso definida.");
        }
    }
}


