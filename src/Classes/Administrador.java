package Classes;
import java.util.ArrayList;
import java.util.List;

public class Administrador {
    private List<Aluno> alunos;
    private List<Modulo> modulos;
    private List<Notificacao> notificacoes;

    public Administrador() {
        this.alunos = new ArrayList<>();
        this.modulos = new ArrayList<>();
        this.notificacoes = new ArrayList<>();
    }

    // Método para cadastrar um aluno
    public void cadastrarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    // Método para criar um módulo
    public void criarModulo(Modulo modulo) {
        modulos.add(modulo);
    }

    // Método para enviar uma notificação
    public void enviarNotificacao(Notificacao notificacao) {
        notificacoes.add(notificacao);
        notificacao.enviarPara(notificacao.getDestinatario());
    }

    // Retornar a lista de alunos
    public List<Aluno> listarAlunos() {
        return alunos;
    }

    // Retornar a lista de módulos
    public List<Modulo> listarModulos() {
        return modulos;
    }
}