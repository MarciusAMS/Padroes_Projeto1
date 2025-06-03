package Classes;

import Interfaces.EstrategiaAvaliacao.EstrategiaAvaliacao;

public class CorrecaoAutomatica implements EstrategiaAvaliacao {
    @Override
    public void avaliar() {
        System.out.println("Realizando correção automática!!!");
    }
}
