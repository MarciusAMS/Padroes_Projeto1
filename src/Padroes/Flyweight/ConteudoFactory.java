package Padroes.Flyweight;

import java.util.HashMap;
import java.util.Map;

import Modelos.Conteudo;
import Padroes.Flyweight.ConteudoFactory;
import java.util.HashMap;
import java.util.Map;

public class ConteudoFactory {
    private static final Map<String, Conteudo> conteudos = new HashMap<>();

    public static Conteudo getConteudo(String titulo, String url) {
        // Usa a URL como chave única para o conteúdo
        if (!conteudos.containsKey(url)) {
            System.out.println("LOG [Flyweight]: Criando NOVO objeto Conteudo para a URL: " + url);
            conteudos.put(url, new Conteudo(titulo, url));
        } else {
            System.out.println("LOG [Flyweight]: Reutilizando objeto Conteudo existente para a URL: " + url);
        }
        return conteudos.get(url);
    }
}

