import Classes.Aluno;
import Classes.Facade.PlataformaEAD;
import Classes.Modulo;
import Classes.Notificacao;

public class Main {
    public static void main(String[] args) {
        PlataformaEAD plataforma = new PlataformaEAD();

        Aluno aluno1 = new Aluno(1, "Samara Queiroz", "samara@gmail.com","999999999", "19999999");
        Aluno aluno2 = new Aluno(2,"Pedro Romão", "pedro@gmail.com", "0000000000", "212992929");
//        MaterialDidatico material = new MaterialDidatico("padroes_java.pdf");
        Modulo modulo = plataforma.criarModulo("Padrões de Projeto Java", "Aula 1", 6);

        plataforma.matricularAluno(aluno1, modulo);
        plataforma.matricularAluno(aluno2, modulo);

        Notificacao notificacao1 = new Notificacao("Por favor verifique.", aluno1);
        Notificacao notificacao2 = new Notificacao("Por favor verifique. 2", aluno2);

        plataforma.enviarNotificacao(notificacao1);

        aluno1.visualizarNotificacoes();
    }
}