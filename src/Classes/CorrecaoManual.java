package Classes;

import Interfaces.EstrategiaAvaliacao.EstrategiaAvaliacao;

public class CorrecaoManual implements EstrategiaAvaliacao {
    @Override
    public void avaliar() {
        System.out.println("Realizando correção manual!!!");
    }
}
