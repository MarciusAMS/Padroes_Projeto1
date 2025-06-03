package Classes;

import Interfaces.Observer.Observador;
import Interfaces.Sujeito.Sujeito;

import java.util.ArrayList;
import java.util.List;

public class Modulo implements Sujeito {
    private String nome;
    private List<Observador> alunos = new ArrayList<>();

    public Modulo(String nome) {
        this.nome = nome;
    }

    public void adicionar(Observador o) {
        alunos.add(o);
    }

    @Override
    public void remover(Observador o) {
        alunos.remove(o);
    }

    @Override
    public void notificar(String mensagem) {
        for (Observador o : alunos) {
            o.atualizar(mensagem);
        }
    }

    public void publicarConteudo(String conteudo) {
        System.out.println("Módulo " + nome + " publicou: " + conteudo);
        notificar("Novo conteúdo publicado no módulo " + nome + ": " + conteudo);
    }
}
