package Padroes.Observer;

import Modelos.Aluno;
import Modelos.Modulo;
import Modelos.Notificacao;

/**
 * ServicoDeNotificacao é uma implementação concreta da interface Observer.
 * É um "observador" específico cuja responsabilidade é criar e enviar notificações
 * quando certos eventos acontecem na plataforma.
 */

public class ServicoDeNotificacao implements Observer {

    /**
     * Implementação do método de atualização.
     * Este método contém a lógica que será executada quando o Subject
     * notificar este observador.
     */
    @Override
    public void update(String eventType, Object data) {

        // Passo 1: Filtrar o evento.
        // O observador primeiro verifica se o evento notificado é um daqueles que ele tem interesse em tratar.
        // Neste caso, ele só se importa com o evento "MATRICULA_ALUNO".
        // A verificação 'data instanceof Object[]' garante que os dados estão no formato esperado.

        if ("MATRICULA_ALUNO".equals(eventType) && data instanceof Object[]) {

            // Passo 2: Desempacotar os dados recebidos.
            // Os dados genéricos (Object) são convertidos para os tipos específicos (Aluno, Modulo)
            // para que possam ser utilizados.

            Object[] dataArray = (Object[]) data;
            Aluno aluno = (Aluno) dataArray[0];
            Modulo modulo = (Modulo) dataArray[1];

            // Passo 3: Executar a lógica de negócio do observador.
            // Aqui, a responsabilidade é criar uma mensagem e um objeto de Notificação.

            String mensagem = "Olá, " + aluno.getNome() + "! Você foi matriculado no módulo: " + modulo.getTitulo();
            Notificacao notificacao = new Notificacao(mensagem, aluno);

            // A notificação é entregue ao ser adicionada ao aluno correspondente.
            aluno.adicionarNotificacao(notificacao);

            // Log para confirmar que o observador foi acionado e executou sua tarefa.

            System.out.println("LOG [Observer]: Notificação criada e enviada para " + aluno.getNome());
        }
        // Se o eventType não for "MATRICULA_ALUNO", este observador simplesmente ignora a notificação.
    }
}
