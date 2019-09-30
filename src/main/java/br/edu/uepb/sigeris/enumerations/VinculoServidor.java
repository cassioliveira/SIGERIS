package br.edu.uepb.sigeris.enumerations;

import java.io.Serializable;
import lombok.Getter;

/**
 *
 * @author cassio
 */
public enum VinculoServidor implements Serializable {

    EFETIVO("Efetivo"),
    SUBSTITUTO("Substituto/Contratado"),
    VISITANTE("Visitante");

    @Getter
    private final String description;

    VinculoServidor(String description) {
        this.description = description;
    }
}
