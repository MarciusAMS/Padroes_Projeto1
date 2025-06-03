import Classes.Aluno;
import Classes.CorrecaoAutomatica;
import Classes.CorrecaoManual;
import Classes.Facade.PlataformaEAD;
import Classes.MaterialDidatico;

public class Main {
    public static void main(String[] args) {
        PlataformaEAD plataforma = new PlataformaEAD("Padrões de Projeto");

        Aluno aluno1 = new Aluno("Samara Queiroz");
        Aluno aluno2 = new Aluno("Pedro Romão");
//        MaterialDidatico material = new MaterialDidatico("padroes_java.pdf");

        plataforma.inscreverAluno(aluno1);
        plataforma.inscreverAluno(aluno2);

        plataforma.publicarConteudo("Padrões de Projeto para Java.");
        plataforma.exibirMaterial("padroes_java.pdf");
        plataforma.corrigirAvaliacao(new CorrecaoAutomatica());
        plataforma.corrigirAvaliacao(new CorrecaoManual());
    }
}