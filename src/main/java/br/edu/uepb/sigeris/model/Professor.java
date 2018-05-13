package br.edu.uepb.sigeris.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.br.CPF;

/**
 *
 * @author cassio
 */
@Data
@Entity
@EqualsAndHashCode(callSuper = false)
//@NamedQuery(name = "Teacher.areas", query = "SELECT DISTINCT t.area FROM Teacher t")
public class Professor extends Pessoa implements Serializable {

    public static final long serialVersionUID = 1L;

    @Column(name = "regime_trabalho")
    private String regimeTrabalho;

    /*Aqui informa a área como Direito, Economia, Administração, etc.*/
    @Column(name = "area", length = 100)
    private String area;

    @Column(name = "descricao_funcao", length = 100)
    private String descricaoFuncao;

    @Column(name = "tem_funcao", length = 100)
    private boolean temFuncao;

    @CPF
    @Column(name = "cpf", unique = true)
    private String cpf;

}
