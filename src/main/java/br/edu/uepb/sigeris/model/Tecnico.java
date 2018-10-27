package br.edu.uepb.sigeris.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
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
public class Tecnico extends Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_controle")
    private Date data;

    @Column(name = "regime_trabalho")
    private String regimeTrabalho;

    @Column(name = "descricao_funcao", length = 100)
    private String descricaoFuncao;

    @Column(name = "tem_funcao")
    private boolean temFuncao;
    
    @Column(name = "classe", length = 50)
    private String classe;
    
    @Column(name = "nivel", length = 50)
    private String nivel;
    
    @Column(name = "setor", length = 100)
    private String setor;
    
    @CPF
    @Column(name = "cpf", unique = true)
    private String cpf;
}
