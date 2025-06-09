package Padroes.Strategy;

import Modelos.Aluno;
import Modelos.Modulo;

/**
 * Interface Strategy: Define um contrato (um método padrão) para todas as
 * estratégias de atualização de progresso. Qualquer classe que implemente
 * esta interface será uma "estratégia" e deverá fornecer sua própria
 * lógica para o método 'atualizar'.
 */

public interface AtualizacaoProgressoStrategy {

    /**
     * Método abstrato que será implementado pelas estratégias concretas.
     *  aluno: O objeto Aluno cujo progresso será atualizado.
     *  modulo: O objeto Modulo relacionado à atualização (pode ser usado para lógicas mais complexas).
     *  progresso: O valor do progresso a ser adicionado.
     */
    void atualizar(Aluno aluno, Modulo modulo, float progresso);
}
