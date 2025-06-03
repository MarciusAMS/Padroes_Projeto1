package Classes;

import Interfaces.Recurso.Recurso;

public class MaterialDidatico implements Recurso {
    private String nomeArquivo;

    public MaterialDidatico(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    @Override
    public void exibir() {
        System.out.println("Arquivo: " + nomeArquivo);
    }
}
