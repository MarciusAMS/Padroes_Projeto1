package Padroes.Flyweight;

import java.util.HashMap;
import java.util.Map;

import Modelos.Conteudo;
import Padroes.Flyweight.ConteudoFactory;
import java.util.HashMap;
import java.util.Map;

/**
 * A classe ConteudoFactory implementa o padrão de projeto Flyweight.
 * Seu objetivo é gerenciar a criação e o compartilhamento de objetos do tipo Conteudo,
 * a fim de reduzir o consumo de memória, evitando a criação de múltiplos objetos idênticos.
 * Ela atua como um ponto central para obter instâncias de Conteudo.
 */

public class ConteudoFactory {

    /**
     * A estrutura Map armazena os objetos Conteudo que já foram criados.
     * - A chave (String) é um identificador único para o conteúdo (neste caso, a URL).
     * - O valor (Conteudo) é o objeto compartilhado (o flyweight).
     * É 'static' para garantir que exista apenas um pool para toda a aplicação.
     */

    private static final Map<String, Conteudo> conteudos = new HashMap<>();
    private static int proximoConteudoId = 1;

    // Método correto que espera os 5 argumentos
    public static Conteudo getConteudo(String titulo, String descricao, String tipo, String url) {

        // Passo 1: Verifica se um objeto com esta chave (URL) já existe no cache.

        if (!conteudos.containsKey(url)) {
            System.out.println("LOG [Flyweight]: Criando NOVO objeto Conteudo para a URL: " + url);

            // Passo 2: Cria a nova instância do objeto 'Conteudo' (o Flyweight).
            // Os dados passados (titulo, descricao, etc.) formam o "estado intrínseco" do flyweight.

            Conteudo novoConteudo = new Conteudo(proximoConteudoId++, titulo, descricao, tipo, url);

            // Passo 3: Armazena o novo objeto no cache para que possa ser reutilizado no futuro.

            conteudos.put(url, novoConteudo);
        } else {
            System.out.println("LOG [Flyweight]: Reutilizando objeto Conteudo existente para a URL: " + url);
        }

        // Passo 4: Retorna o objeto do cache.
        // Será o objeto recém-criado ou o objeto que já existia.
        
        return conteudos.get(url);
    }
}


