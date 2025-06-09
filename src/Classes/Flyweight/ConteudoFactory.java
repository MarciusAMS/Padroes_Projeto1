package Classes.Flyweight;

import java.util.HashMap;
import java.util.Map;

public class ConteudoFactory {
    private static Map<Integer, Conteudo> conteudos = new HashMap<>();

    public static Conteudo getConteudo(int id, String titulo, String descricao, String tipo, String url) {
        if (!conteudos.containsKey(id)) {
            Conteudo novo = new Conteudo(id, titulo, descricao, tipo, url);
            conteudos.put(id, novo);
        }
        return conteudos.get(id);
    }

    public static int totalConteudosCriados() {
        return conteudos.size();
    }
}

