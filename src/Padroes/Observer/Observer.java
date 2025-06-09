package Padroes.Observer;

/**
 * A interface Observer define o contrato para todos os "observadores" ou "ouvintes".
 * Qualquer classe que deseje ser notificada sobre mudanças em um objeto "Subject" (Observado)
 * deve implementar esta interface.
 * Ela garante que o Subject saiba exatamente qual método chamar em seus observadores.
 */

public interface Observer {

    /**
     * Este é o método que o Subject chamará quando um evento ocorrer.
     * É por meio do 'update' que o observador é notificado e pode reagir.
     *
     * eventType: Uma String que identifica o tipo do evento (ex: "MATRICULA_ALUNO", "AULA_CONCLUIDA").
     * Isso permite que um mesmo observer possa reagir a diferentes tipos de eventos.
     * data: Um objeto que carrega os dados relevantes sobre o evento.
     * Pode ser qualquer tipo de objeto, permitindo flexibilidade para passar informações.
     */

    void update(String eventType, Object data);
}
