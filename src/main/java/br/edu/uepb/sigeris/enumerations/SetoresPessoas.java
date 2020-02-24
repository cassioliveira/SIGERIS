package br.edu.uepb.sigeris.enumerations;

import java.io.Serializable;
import lombok.Getter;

/**
 *
 * @author cassio
 */
public enum SetoresPessoas implements Serializable {

    DIRECAO("Direção"),
    EXTENSAO("Extensão"),
    BIBLIOTECA("Biblioteca"),
    CPD("CPD"),
    MATEMATICA("Coordenação de Matemática"),
    CONTABEIS("Coordenação de Contábeis"),
    LETRAS("Coordenação de Letras"),
    APOIO("Apoio"),
    VIGILANTES("Vigilantes"),
    OUTRO("Outro");

    @Getter
    private final String description;

    SetoresPessoas(String description) {
        this.description = description;
    }
}
