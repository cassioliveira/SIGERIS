package br.edu.uepb.sigeris.enumerations;

import java.io.Serializable;
import lombok.Getter;

/**
 *
 * @author cassio
 */
public enum GruposUsuarios implements Serializable {

    ADMINISTRADORES("ADMINISTRADORES"),
    PROFESSORES("PROFESSORES"),
    TECNICOS("TECNICOS"),
    TERCEIRIZADOS("TERCEIRIZADOS"),
    COORDENADORES("COORDENADORES"),
    VISITANTES("VISITANTES");
    
    @Getter
    private final String descricao;

    private GruposUsuarios(String descricao) {
        this.descricao = descricao;
    }
    
}
