package src;

import Modelos.Aluno;
import Padroes.Facade.PlataformaEAD;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Iniciando Simulação da Plataforma EAD ---\n");

        // 1. O cliente interage apenas com a FACADE
        PlataformaEAD plataforma = new PlataformaEAD();

        // 2. Usando a Facade para criar alunos e módulos
        Aluno aluno1 = plataforma.criarAluno(1,"João Silva", "joao@email.com");
        Aluno aluno2 = plataforma.criarAluno(2,"Maria Souza", "maria@email.com" );
        plataforma.criarModulo(3,"Java Básico", 4);
        plataforma.criarModulo(4, "Design Patterns", 5);

        System.out.println("\n--- Demonstração do Flyweight ---");
        // 3. Adicionando conteúdo. Note como o conteúdo reutilizável é tratado.
        plataforma.adicionarConteudoAoModulo(1, "Vídeo de Instalação", "aaaaaaaaa","redes","http://videos.com/instalar-jdk");
        plataforma.adicionarConteudoAoModulo(2, "Vídeo de Instalaçaão", "bbbbbbbbbbbb","radios","http://videos.com/instalar-jdk"); // <-- Reutilização!

        System.out.println("\n--- Demonstração do Observer ---");
        // 4. Matriculando um aluno. Isso vai disparar o Observer de Notificação.
        plataforma.matricularAluno(aluno1.getId(), 1);
        plataforma.matricularAluno(aluno2.getId(), 2);

        System.out.println("\n--- Demonstração do Strategy ---");
        // 5. Usando a Strategy para atualizar o progresso do aluno.
        System.out.println("Progresso inicial do " + aluno1.getNome() + ": " + aluno1.getProgresso() + "%");
        aluno1.atualizarProgresso(plataforma.getModulo(1), 15.5f);
        System.out.println("Progresso após estudar Java: " + aluno1.getProgresso() + "%");

        System.out.println("Progresso inicial do " + aluno2.getNome() + ": " + aluno2.getProgresso() + "%");
        aluno2.atualizarProgresso(plataforma.getModulo(2), 30.0f);
        System.out.println("Progresso após estudar Java: " + aluno2.getProgresso() + "%");

        System.out.println("\n--- Verificando o resultado ---");
        // Verificando as notificações do aluno1 (criadas pelo Observer)
        System.out.println("Notificações de " + aluno1.getNome() + ":");
        aluno1.getNotificacoes().forEach(n -> System.out.println("- " + n.getMensagem()));

        System.out.println("Notificações de " + aluno2.getNome() + ":");
        aluno2.getNotificacoes().forEach(n -> System.out.println("- " + n.getMensagem()));
    }
}