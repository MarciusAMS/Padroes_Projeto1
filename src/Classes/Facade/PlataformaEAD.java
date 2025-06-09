public class PlataformaEAD {
    private Administrador administrador;

    public PlataformaEAD() {
        this.administrador = new Administrador();
    }

    // Cria e cadastra um aluno
    public void criarAluno(String nome, String email, String cpf, String numero) {
        Aluno novoAluno = new Aluno(nome, email, cpf, numero);
        administrador.cadastrarAluno(novoAluno);
    }

    // Cria e adiciona um módulo
    public void criarModulo(String titulo, String descricao, float cargaHoraria) {
        Modulo novoModulo = new Modulo(titulo, descricao, cargaHoraria);
        administrador.criarModulo(novoModulo);
    }

    // Matricula um aluno em um módulo
    public void matricularAluno(Aluno aluno, Modulo modulo) {
        aluno.matricular(modulo);
        modulo.getAlunosMatriculados().add(aluno);
    }

    // Envia uma notificação a um aluno
    public void enviarNotificacao(String mensagem, Aluno aluno) {
        Notificacao notificacao = new Notificacao(
                gerarIdNotificacao(),
                mensagem,
                aluno
        );
        administrador.enviarNotificacao(notificacao);
    }

    // (opcional) Método auxiliar para gerar ID único (simples)
    private int gerarIdNotificacao() {
        return administrador.listarAlunos().size() + administrador.listarModulos().size() + administrador.listarModulos().size(); // apenas para exemplo
    }
}