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
    // getters...
}