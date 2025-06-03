package Classes;

import Interfaces.Recurso.Recurso;

import java.util.HashMap;

public class RecursoFactory {
    private static final HashMap<String, Recurso> recursos = new HashMap<>();

    public static Recurso obterRecurso(String nomeArquivo) {
        return recursos.computeIfAbsent(nomeArquivo, k -> new MaterialDidatico(nomeArquivo));
    }
}
