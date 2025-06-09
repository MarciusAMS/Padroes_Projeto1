import java.util.ArrayList;
import java.util.List;

public class Aluno {
    private int id;
    private String nome;
    private String email;
    private String cpf;
    private String numero;
    private float progresso;

    private List<Modulo> modulosCadastrados;
    private AtualizacaoProgresso atualizador;
    private List<Notificacao> notificacoes;

    public Aluno(int id, String nome, String email, String cpf, String numero, AtualizacaoProgressoStrategy atualizador) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.numero = numero;
        this.progresso = 0.0f;
        this.atualizador = atualizador;
        this.modulosCadastrados = new ArrayList<>();
        this.notificacoes = new ArrayList<>();
    }

    public void matricular(Modulo modulo) {
        if (!modulosCadastrados.contains(modulo)) {
            modulosCadastrados.add(modulo);
            modulo.matricularAluno(this);
        }
    }

    public void cancelarMatricula(Modulo modulo) {
        modulosCadastrados.remove(modulo);
    }

    public void atualizarProgresso(Modulo modulo, float progresso) {
        if (atualizador != null) {
            atualizador.atualizar(this, modulo, progresso);
        }
    }

    public List<Modulo> listarModulos() {
        return modulosCadastrados;
    }

    public List<Notificacao> visualizarNotificacoes() {
        return notificacoes;
    }

    public void receberNotificacao(Notificacao notificacao) {
        notificacoes.add(notificacao);
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public float getProgresso() { return progresso; }
    public void setProgresso(float progresso) { this.progresso = progresso; }
}