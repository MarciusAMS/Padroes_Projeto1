package Classes;

import Interfaces.EstrategiaAvaliacao.EstrategiaAvaliacao;

public class Avaliacao {
    private EstrategiaAvaliacao estrategia;

    public Avaliacao(EstrategiaAvaliacao estrategia) {
        this.estrategia = estrategia;
    }

    public void realizarCorrecao() {
        estrategia.avaliar();
    }

    void setEstrategia(EstrategiaAvaliacao estrategia) {
        this.estrategia = estrategia;
    }
}
