package Padroes.Strategy;

import Modelos.Aluno;
import Modelos.Modulo;

public class ProgressoLinearStrategy implements AtualizacaoProgressoStrategy {
    @Override
    public void atualizar(Aluno aluno, Modulo modulo, float progresso) {
        System.out.println("LOG [Strategy]: Atualizando progresso de forma linear.");
        // Lógica simples: apenas atualiza o progresso geral do aluno.
        aluno.setProgresso(aluno.getProgresso() + progresso);
    }
}
