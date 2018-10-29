package br.edu.uepb.sigeris.enumerations;

import java.io.Serializable;
import lombok.Getter;

/**
 *
 * @author cassio
 */
public enum TurnosTerceirizados implements Serializable {

    MATUTINO("Matutino"),
    VESPERTINO("Vespertino"),
    NOTURNO("Noturno");

    @Getter
    private final String description;

    TurnosTerceirizados(String description) {
        this.description = description;
    }
}
