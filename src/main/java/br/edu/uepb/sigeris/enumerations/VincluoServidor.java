package br.edu.uepb.sigeris.enumerations;

import java.io.Serializable;
import lombok.Getter;

/**
 *
 * @author cassio
 */
public enum VincluoServidor implements Serializable {

    EFETIVO("Efetivo"),
    SUBSTITUTO("Substituto/Contratado"),
    VISITANTE("Visitante");

    @Getter
    private final String description;

    VincluoServidor(String description) {
        this.description = description;
    }
}
