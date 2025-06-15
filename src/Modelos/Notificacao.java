package Modelos;

import java.time.LocalDateTime;

/**
 * Representa uma notificação simples enviada a um aluno.
 * É uma classe de modelo que armazena dados.
 *
 * No padrão Observer, este é o objeto criado pelo Observer concreto
 * (ServicoDeNotificacao) como resultado de um evento.
 */

public class Notificacao {
    private String mensagem;
    private Aluno destinatario;
    private java.time.LocalDateTime dataEnvio;
    private boolean lida = false; // Status da notificação

    /**
     * Construtor que cria uma notificação com os dados essenciais.
     * A data de envio é definida automaticamente para o momento da criação.
     */

    public Notificacao(String mensagem, Aluno destinatario) {
        this.mensagem = mensagem;
        this.destinatario = destinatario;
        this.dataEnvio = java.time.LocalDateTime.now();
    }
    // --- GETTERS E SETTERS ---

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Aluno getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Aluno destinatario) {
        this.destinatario = destinatario;
    }

    public LocalDateTime getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(LocalDateTime dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    public boolean isLida() {
        return lida;
    }

    public void setLida(boolean lida) {
        this.lida = lida;
    }
}