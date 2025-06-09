package Modelos;

/**
 * Classe que representa um conteúdo educacional (vídeo, texto, etc.).
 * Implementada como um objeto Flyweight: é imutável para poder ser
 * compartilhado por vários Módulos, economizando memória.
 */
public class Conteudo {

    // --- CAMPOS ---
    // Todos os campos são 'final' para garantir a imutabilidade.
    private final int id;
    private final String titulo;
    private final String descricao;
    private final String tipo; // Ex: "video", "pdf", "quiz"
    private final String url;

    // --- CONSTRUTOR ---
    // O construtor é a única forma de definir os valores dos campos.
    public Conteudo(int id, String titulo, String descricao, String tipo, String url) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.tipo = tipo;
        this.url = url;
    }

    // --- GETTERS ---
    // Fornecemos apenas getters, pois os dados não podem ser alterados após a criação.

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public String getUrl() {
        return url;
    }

    // Não há setters para manter a imutabilidade do objeto.
}