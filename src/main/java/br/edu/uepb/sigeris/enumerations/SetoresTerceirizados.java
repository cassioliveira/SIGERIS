package br.edu.uepb.sigeris.enumerations;

import java.io.Serializable;
import lombok.Getter;

/**
 *
 * @author cassio
 */
public enum SetoresTerceirizados implements Serializable {

    VIGILANCIA("Vigilância"),
    JARDINAGEM("Jardinagem"),
    LIMPEZA("Limpeza"),
    SUPORTE("Suporte"),
    CCHE("CCHE");

    @Getter
    private final String description;

    SetoresTerceirizados(String description) {
        this.description = description;
    }
}
