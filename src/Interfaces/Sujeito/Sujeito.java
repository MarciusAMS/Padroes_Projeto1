package Interfaces.Sujeito;

import Interfaces.Observer.Observador;

public interface Sujeito {
    void adicionar(Observador o);
    void remover(Observador o);
    void notificar(String mensagem);
}
