//package Classes.Facade;
//import Classes.Administrador;
//import Classes.Aluno;
//import Classes.Modulo;
//import Classes.Notificacao;
//import Interfaces.Strategy.AtualizacaoProgresso;
//
//public class PlataformaEAD {
//    private Administrador administrador;
//    private AtualizacaoProgresso atualizacaoProgresso;
//
//    public PlataformaEAD() {
//        this.administrador = new Administrador();
//    }
//
//    // Cria e cadastra um aluno
//    public void criarAluno(String nome, String email, String cpf, String numero) {
//        Aluno novoAluno = new Aluno(1, nome, email, cpf, numero);
//        administrador.cadastrarAluno(novoAluno);
//    }
//
//    // Cria e adiciona um módulo
//    public Modulo criarModulo(String titulo, String descricao, float cargaHoraria) {
//        Modulo novoModulo = new Modulo(1, titulo, descricao, cargaHoraria);
//        administrador.criarModulo(novoModulo);
//        return novoModulo;
//    }
//
//    // Matricula um aluno em um módulo
//    public void matricularAluno(Aluno aluno, Modulo modulo) {
//        aluno.matricular(modulo);
//        modulo.getAlunosMatriculados().add(aluno);
//    }
//
//    // Envia uma notificação a um aluno
//    public void enviarNotificacao(Notificacao notificacao1) {
//        Notificacao notificacao = new Notificacao(
//                gerarIdNotificacao(),
////                mensagem,
////                aluno
////        );
////        administrador.enviarNotificacao(notificacao);
//    }
//
//    // (opcional) Método auxiliar para gerar ID único (simples)
//    private int gerarIdNotificacao() {
//        return administrador.listarAlunos().size() + administrador.listarModulos().size() + administrador.listarModulos().size(); // apenas para exemplo
//    }
//}