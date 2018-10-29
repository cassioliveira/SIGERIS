package br.edu.uepb.sigeris.enumerations;

import java.io.Serializable;
import lombok.Getter;

/**
 *
 * @author cassio
 */
public enum TurnosTerceirizados implements Serializable {

    DIURNOMATUTINO("Diurno Matutino"),
    DIURNOVESPERTINO("Diurno Vespertino"),
    DIURNOINTEGRAL("Diurno Integral"),
    NOTURNO("Noturno");

    @Getter
    private final String description;

    TurnosTerceirizados(String description) {
        this.description = description;
    }
}
