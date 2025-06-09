package Classes;

import java.time.LocalDateTime;

public class Certificado {
    private int id;
    private Aluno aluno;
    private Modulo modulo;
    private LocalDateTime dataEmissao;
    private float cargaHoraria;

    public void calcularCargaHoraria() {
        this.cargaHoraria = modulo != null ? modulo.listarConteudos().size() * 1.5f : 0;
    }

    public void emitir() {
        this.dataEmissao = LocalDateTime.now();
    }

    public boolean verificarConclusao() {
        return aluno != null && aluno.listarModulos().contains(modulo);
    }
}
