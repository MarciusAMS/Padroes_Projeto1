package Modelos;

import java.time.LocalDateTime;
public class Notificacao {
    private String mensagem;
    private Aluno destinatario;
    private java.time.LocalDateTime dataEnvio;
    private boolean lida = false;

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