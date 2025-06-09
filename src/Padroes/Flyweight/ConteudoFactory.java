package Padroes.Flyweight;

import java.util.HashMap;
import java.util.Map;

import Modelos.Conteudo;
import Padroes.Flyweight.ConteudoFactory;
import java.util.HashMap;
import java.util.Map;

public class ConteudoFactory {
    private static final Map<String, Conteudo> conteudos = new HashMap<>();
    private static int proximoConteudoId = 1;

    // Método correto que espera os 5 argumentos
    public static Conteudo getConteudo(String titulo, String descricao, String tipo, String url) {
        // A URL é uma ótima chave para identificar um conteúdo único
        if (!conteudos.containsKey(url)) {
            System.out.println("LOG [Flyweight]: Criando NOVO objeto Conteudo para a URL: " + url);
            // Cria um novo conteúdo com um ID único
            Conteudo novoConteudo = new Conteudo(proximoConteudoId++, titulo, descricao, tipo, url);
            conteudos.put(url, novoConteudo);
        } else {
            System.out.println("LOG [Flyweight]: Reutilizando objeto Conteudo existente para a URL: " + url);
        }
        return conteudos.get(url);
    }
}


