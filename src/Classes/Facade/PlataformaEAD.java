package Classes.Facade;

import Classes.*;
import Interfaces.EstrategiaAvaliacao.EstrategiaAvaliacao;
import Interfaces.Recurso.Recurso;

public class PlataformaEAD {
    private Modulo modulo;
    private RecursoFactory recursoFactory = new RecursoFactory();

    public PlataformaEAD(String nomeModulo) {
        this.modulo = new Modulo(nomeModulo);
    }

    public void inscreverAluno(Aluno aluno) {
        modulo.adicionar(aluno);
        System.out.println(aluno.toString() + " inscrito no módulo com sucesso!!!");
    }

    public void publicarConteudo(String conteudo) {
        modulo.publicarConteudo(conteudo);
    }

    public void exibirMaterial(String material) {
        Recurso recurso = recursoFactory.obterRecurso(material);
        recurso.exibir();
    }

    public void corrigirAvaliacao(EstrategiaAvaliacao estrategia) {
        Avaliacao avaliacao = new Avaliacao(estrategia);
        avaliacao.realizarCorrecao();
    }
}
