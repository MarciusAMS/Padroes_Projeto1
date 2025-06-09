package Classes;
import Classes.Aluno;
import java.time.LocalDateTime;

public class Notificacao {
    private int id;
    private String mensagem;
    private LocalDateTime dataEnvio;
    private Aluno destinatario;
    private boolean lida;

    // Construtor
    public Notificacao(String mensagem, Aluno destinatario) {
        this.mensagem = mensagem;
        this.destinatario = destinatario;
        this.dataEnvio = LocalDateTime.now();
        this.lida = false;
    }

    // Método para enviar notificação
    public void enviarPara(Aluno aluno) {
        this.destinatario = aluno;
        this.dataEnvio = LocalDateTime.now();
        aluno.receberNotificacao(this); // Assumindo que Aluno tem esse método
    }

    // Método para marcar a notificação como lida
    public void marcarComoLida() {
        this.lida = true;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getMensagem() {
        return mensagem;
    }

    public LocalDateTime getDataEnvio() {
        return dataEnvio;
    }

    public Aluno getDestinatario() {
        return destinatario;
    }

    public boolean isLida() {
        return lida;
    }
}