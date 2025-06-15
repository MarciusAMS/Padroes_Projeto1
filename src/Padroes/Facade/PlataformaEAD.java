package Padroes.Facade;

import Modelos.Aluno;
import Modelos.Conteudo;
import Modelos.Modulo;
import Padroes.Flyweight.ConteudoFactory;
import Padroes.Observer.Observer;
import Padroes.Observer.ServicoDeNotificacao;
import Padroes.Strategy.ProgressoLinearStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A classe PlataformaEAD atua como um Facade (Fachada).
 * Ela fornece uma interface única e simplificada para um conjunto complexo de operações
 * e subsistemas (gerenciamento de alunos, módulos, conteúdos, notificações, etc.).
 * O cliente (quem usa esta classe) não precisa saber os detalhes de como
 * cada parte funciona ou interage; ele apenas chama os métodos simples da fachada.
 */

public class PlataformaEAD {

    // --- Início do Subsistema Complexo ---
    // A fachada gerencia internamente as diferentes partes do sistema.
    // Para o cliente, esses detalhes são irrelevantes.

    private Map<Integer, Aluno> alunos = new HashMap<>();
    private Map<Integer, Modulo> modulos = new HashMap<>();
    private int proximoAlunoId = 1;
    private int proximoModuloId = 1;


    // A fachada também gerencia a lógica do padrão Observer.
    // Ela esconde do cliente a necessidade de adicionar/remover/notificar observers.

    private List<Observer> observers = new ArrayList<>();

    public PlataformaEAD() {
        // Ao iniciar, já inscreve o serviço de notificação
        this.addObserver(new ServicoDeNotificacao());
    }


    // Métodos simplificados da fachada

    /**
     * Simplifica a criação de um aluno.
     * Este método esconde a complexidade de:
     * 1. Instanciar um objeto Aluno.
     * 2. Definir uma estratégia de progresso padrão (padrão Strategy).
     * 3. Armazená-lo na estrutura de dados interna.
     * 4. Gerenciar os IDs.
     */

    public Aluno criarAluno(int id, String nome, String email) {
        Aluno aluno = new Aluno(proximoAlunoId, nome, email);
        aluno.setEstrategiaProgresso(new ProgressoLinearStrategy()); // Define a estratégia padrão
        alunos.put(proximoAlunoId, aluno);
        proximoAlunoId++;
        System.out.println("LOG [Facade]: Aluno " + nome + " criado com sucesso.");
        return aluno;
    }

    /**
     * Simplifica a criação de um módulo.
     * O cliente não precisa se preocupar com o armazenamento ou gerenciamento de IDs.
     */

    public Modulo criarModulo(int id, String titulo, float cargaHoraria) {
        Modulo modulo = new Modulo(proximoModuloId, titulo, cargaHoraria);
        modulos.put(proximoModuloId, modulo);
        proximoModuloId++;
        System.out.println("LOG [Facade]: Módulo " + titulo + " criado com sucesso.");
        return modulo;
    }

    /**
     * Simplifica a adição de conteúdo a um módulo.
     * Este método esconde o uso do padrão Flyweight (ConteudoFactory).
     * O cliente não precisa saber que os conteúdos estão sendo reutilizados para
     * economizar memória.
     */
    public void adicionarConteudoAoModulo(int moduloId, String tituloConteudo, String descricaoConteudo, String tipoConteudo, String urlConteudo) {
        Modulo modulo = modulos.get(moduloId);
        if (modulo != null) {
            Conteudo conteudo = ConteudoFactory.getConteudo(tituloConteudo, descricaoConteudo, tipoConteudo, urlConteudo);
            modulo.adicionarConteudo(conteudo);
            System.out.println("LOG [Facade]: Conteúdo '" + tituloConteudo + "' adicionado ao módulo '" + modulo.getTitulo() + "'.");
        }
    }

    /**
     * Orquestra uma operação complexa: a matrícula de um aluno.
     * Este é um exemplo clássico do poder do Facade. O método coordena ações
     * em múltiplos objetos do subsistema (Aluno e Modulo) e também dispara
     * um evento para o padrão Observer.
     */

    public void matricularAluno(int alunoId, int moduloId) {
        Aluno aluno = alunos.get(alunoId);
        Modulo modulo = modulos.get(moduloId);

        if (aluno != null && modulo != null) {
            aluno.matricular(modulo);
            modulo.adicionarAluno(aluno);
            System.out.println("LOG [Facade]: Matriculando " + aluno.getNome() + " no módulo " + modulo.getTitulo());

            // Notifica os observers sobre o evento.
            notifyObservers("MATRICULA_ALUNO", new Object[]{aluno, modulo});
        }
    }

    // --- Métodos de acesso e gerenciamento que a fachada expõe ---
    public Aluno getAluno(int id) {
        return alunos.get(id);
    }
    public Modulo getModulo(int id) {
        return modulos.get(id);
    }

    // A própria fachada expõe os métodos para gerenciar os observers,
    // embora a notificação em si seja escondida dentro de outros métodos.

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    // Neste caso o 'Subject' será este método definido na PlataformaEAD.

    public void notifyObservers(String eventType, Object data) {
        for (Observer observer : observers) {
            observer.update(eventType, data);
        }
    }
}
