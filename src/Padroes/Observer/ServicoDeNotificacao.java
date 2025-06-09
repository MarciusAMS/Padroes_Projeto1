package Padroes.Observer;

import Modelos.Aluno;
import Modelos.Modulo;
import Modelos.Notificacao;

public class ServicoDeNotificacao implements Observer {
    @Override
    public void update(String eventType, Object data) {
        if ("MATRICULA_ALUNO".equals(eventType) && data instanceof Object[]) {
            Object[] dataArray = (Object[]) data;
            Aluno aluno = (Aluno) dataArray[0];
            Modulo modulo = (Modulo) dataArray[1];

            String mensagem = "Olá, " + aluno.getNome() + "! Você foi matriculado no módulo: " + modulo.getTitulo();
            Notificacao notificacao = new Notificacao(mensagem, aluno);

            aluno.adicionarNotificacao(notificacao);
            System.out.println("LOG [Observer]: Notificação criada e enviada para " + aluno.getNome());
        }
    }
}
