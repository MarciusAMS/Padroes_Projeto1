package Classes.Flyweight;

public class Conteudo {
    private final int id;
    private final String titulo;
    private final String descricao;
    private final String tipo;
    private final String url;

    public Conteudo(int id, String titulo, String descricao, String tipo, String url) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.tipo = tipo;
        this.url = url;
    }

    public void exibir() {
        System.out.println("Conteúdo: " + titulo + " [" + tipo + "]");
        System.out.println("Descrição: " + descricao);
        System.out.println("URL: " + url);
    }

    // Getters (opcionais)
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
}
