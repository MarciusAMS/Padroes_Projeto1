package src;

import Modelos.Aluno;
import Padroes.Facade.PlataformaEAD;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Iniciando Simulação da Plataforma EAD ---\n");

        // 1. O cliente interage apenas com a FACADE
        PlataformaEAD plataforma = new PlataformaEAD();

        // 2. Usando a Facade para criar alunos e módulos
        Aluno aluno1 = plataforma.criarAluno("João Silva", "joao@email.com", "111.111.111-11");
        Aluno aluno2 = plataforma.criarAluno("Maria Souza", "maria@email.com", "222.222.222-22");
        plataforma.criarModulo("Java Básico", "Introdução à linguagem Java.");
        plataforma.criarModulo("Design Patterns", "Padrões de projeto GoF.");

        System.out.println("\n--- Demonstração do Flyweight ---");
        // 3. Adicionando conteúdo. Note como o conteúdo reutilizável é tratado.
        plataforma.adicionarConteudoAoModulo(1, "Vídeo de Instalação", "http://videos.com/instalar-jdk");
        plataforma.adicionarConteudoAoModulo(2, "Vídeo de Instalação", "http://videos.com/instalar-jdk"); // <-- Reutilização!

        System.out.println("\n--- Demonstração do Observer ---");
        // 4. Matriculando um aluno. Isso vai disparar o Observer de Notificação.
        plataforma.matricularAluno(aluno1.getId(), 1); // João no Java Básico
        plataforma.matricularAluno(aluno1.getId(), 2); // João no Design Patterns

        System.out.println("\n--- Demonstração do Strategy ---");
        // 5. Usando a Strategy para atualizar o progresso do aluno.
        System.out.println("Progresso inicial do João: " + aluno1.getProgresso() + "%");
        aluno1.atualizarProgresso(plataforma.getModulo(1), 15.5f);
        System.out.println("Progresso do João após estudar Java: " + aluno1.getProgresso() + "%");

        System.out.println("\n--- Verificando o resultado ---");
        // Verificando as notificações do aluno1 (criadas pelo Observer)
        System.out.println("Notificações de " + aluno1.getNome() + ":");
        aluno1.getNotificacoes().forEach(n -> System.out.println("- " + n.getMensagem()));
    }
}