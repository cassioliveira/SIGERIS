package br.edu.uepb.sigeris.enumerations;

import java.io.Serializable;
import lombok.Getter;

/**
 *
 * @author cassio
 */
public enum Cursos implements Serializable {

    MATEMATICA("Licenciatura Plena em Matemática"),
    CONTABEIS("Bacharelado em Ciências Contábeis"),
    LETRAS("Licenciatura Plena em Letras");

    @Getter
    private final String description;

    Cursos(String description) {
        this.description = description;
    }
}
