package Classes;

import Interfaces.Observer.Observador;

public class Aluno implements Observador {
    private String nome;

    public Aluno(String nome) {
        this.nome = nome;
    }

    @Override
    public void atualizar(String mensagem) {
        System.out.println("Aluno " + nome + " recebeu: " + mensagem);
    }
}
