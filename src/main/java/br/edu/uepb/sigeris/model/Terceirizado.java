package br.edu.uepb.sigeris.model;

import br.edu.uepb.sigeris.enumerations.TurnosTerceirizados;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.br.CPF;

/**
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Terceirizado extends Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_controle")
    private Date data;

    @Enumerated(EnumType.STRING)
    @Column(name = "turno", length = 30)
    private TurnosTerceirizados turno;
    
    @CPF
    @Column(name = "cpf", unique = true)
    private String cpf;
}
