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

public class PlataformaEAD {
    // Referências ao subsistema
    private Map<Integer, Aluno> alunos = new HashMap<>();
    private Map<Integer, Modulo> modulos = new HashMap<>();
    private int proximoAlunoId = 1;
    private int proximoModuloId = 1;

    // Lógica do Observer
    private List<Observer> observers = new ArrayList<>();
    // ... métodos add/remove/notify Observer ...

    public PlataformaEAD() {
        // Ao iniciar, já inscreve o serviço de notificação
        this.addObserver(new ServicoDeNotificacao());
    }

    // Métodos simplificados da fachada
    public Aluno criarAluno(String nome, String email, String cpf) {
        Aluno aluno = new Aluno(proximoAlunoId, nome, email, cpf);
        aluno.setEstrategiaProgresso(new ProgressoLinearStrategy()); // Define a estratégia padrão
        alunos.put(proximoAlunoId, aluno);
        proximoAlunoId++;
        System.out.println("LOG [Facade]: Aluno " + nome + " criado com sucesso.");
        return aluno;
    }

    public Modulo criarModulo(String titulo, String descricao) {
        Modulo modulo = new Modulo(proximoModuloId, titulo, descricao);
        modulos.put(proximoModuloId, modulo);
        proximoModuloId++;
        System.out.println("LOG [Facade]: Módulo " + titulo + " criado com sucesso.");
        return modulo;
    }

    // Usa o Flyweight internamente
    public void adicionarConteudoAoModulo(int moduloId, String tituloConteudo, String urlConteudo) {
        Modulo modulo = modulos.get(moduloId);
        if (modulo != null) {
            Conteudo conteudo = ConteudoFactory.getConteudo(tituloConteudo, urlConteudo);
            modulo.adicionarConteudo(conteudo);
        }
    }

    // Orquestra múltiplas ações e notifica os observers
    public void matricularAluno(int alunoId, int moduloId) {
        Aluno aluno = alunos.get(alunoId);
        Modulo modulo = modulos.get(moduloId);

        if (aluno != null && modulo != null) {
            aluno.matricular(modulo);
            modulo.adicionarAluno(aluno);
            System.out.println("LOG [Facade]: Matriculando " + aluno.getNome() + " no módulo " + modulo.getTitulo());

            // Notifica os observers sobre o evento
            notifyObservers("MATRICULA_ALUNO", new Object[]{aluno, modulo});
        }
    }

    // Outros métodos para acessar dados...
    public Aluno getAluno(int id) {
        return alunos.get(id);
    }


    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String eventType, Object data) {
        for (Observer observer : observers) {
            observer.update(eventType, data);
        }
    }
}
