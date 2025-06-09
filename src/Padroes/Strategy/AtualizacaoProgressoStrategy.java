package Padroes.Strategy;

import Modelos.Aluno;
import Modelos.Modulo;

public interface AtualizacaoProgressoStrategy {
    void atualizar(Aluno aluno, Modulo modulo, float progresso);
}
