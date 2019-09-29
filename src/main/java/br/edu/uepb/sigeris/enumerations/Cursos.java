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
    LETRASPT("Licenciatura Plena em Letras Português"),
    LETRASES("Licenciatura Plena em Letras Espanhol");

    @Getter
    private final String description;

    Cursos(String description) {
        this.description = description;
    }
}
