package Padroes.Strategy;

import Modelos.Aluno;
import Modelos.Modulo;


/**
 * Estratégia Concreta: Implementa uma forma específica de atualizar o progresso.
 * Esta estratégia, chamada "Linear", simplesmente soma o novo progresso ao
 * progresso existente do aluno.
 */

public class ProgressoLinearStrategy implements AtualizacaoProgressoStrategy {
    @Override
    public void atualizar(Aluno aluno, Modulo modulo, float progresso) {
        System.out.println("LOG [Strategy]: Atualizando progresso de forma linear.");

        // Lógica da estratégia:
        // 1. Pega o progresso atual do aluno com aluno.getProgresso().
        // 2. Soma o novo valor de 'progresso'.
        // 3. Define o resultado como o novo progresso total do aluno com aluno.setProgresso().

        aluno.setProgresso(aluno.getProgresso() + progresso);
    }
}
