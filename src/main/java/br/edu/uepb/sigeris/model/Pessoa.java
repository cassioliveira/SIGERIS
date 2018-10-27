package br.edu.uepb.sigeris.model;

import br.edu.uepb.sigeris.enumerations.CategoriasServidor;
import br.edu.uepb.sigeris.enumerations.Estados;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.Data;

/**
 * Classe que representa o modelo da entidade Cliente a ser persistida no banco,
 * com todos os seus atributos.
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
@Data
@Entity
@Table(name = "pessoa")
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQueries({
    @NamedQuery(name = "Servidores.todos", query = "FROM Pessoa p WHERE p.tipo='TECNICO' OR p.tipo='PROFESSOR' ORDER BY p.nome ASC"),
    @NamedQuery(name = "Professores.todos", query = "FROM Pessoa p WHERE p.tipo='PROFESSOR' ORDER BY p.nome ASC"),
    @NamedQuery(name = "Tecnicos.todos", query = "FROM Pessoa p WHERE p.tipo='TECNICO' ORDER BY p.nome ASC")
})
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tipo", length = 15)
    private String tipo;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "cadastro")
    private Date cadastro;

    @NotNull(message = "Um nome deve ser informado")
    @Column(name = "nome", nullable = false, length = 200)
    private String nome;

    @Column(name = "matricula", length = 15)
    private String matricula;

    @Column(name = "nome_social", length = 100)
    private String nomeSocial;

    @Pattern(regexp = "^$|^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})$",
            message = "E-mail com formato incorreto")
    @Column(name = "email", length = 100)
    private String email;

    @Pattern(regexp = "^$|^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})$",
            message = "E-mail com formato incorreto")
    @Column(name = "email2", length = 100)
    private String email2;

    @Pattern(regexp = "^$|[a-zA-Z\\d/.-]{1,}",
            message = "Apenas letras números ou os caracteres a seguir são aceitos para o RG: / . -")
    @Column(name = "rg", length = 15)
    private String rg;

    @Column(name = "telefone", length = 20)
    private String telefone;

    @Column(name = "celular", length = 20)
    private String celular;

    @Column(name = "sexo", length = 1)
    private String sexo;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_nascimento")
    private Date dataNascimento;

    @Enumerated(EnumType.STRING)
    @Column(name = "categoria")
    private CategoriasServidor categoria;

    @Column(name = "observacoes")
    private String observacoes;

    private byte[] foto;

    @Column(name = "endereco_rua", length = 200)
    private String rua;

    @Column(name = "endereco_numero", length = 10)
    private String numero;

    @Column(name = "endereco_complemento", length = 200)
    private String complemento;

    @Column(name = "endereco_bairro", length = 50)
    private String bairro;

    @Enumerated(EnumType.STRING)
    @Column(name = "endereco_estado")
    private Estados estado;

    @Column(name = "endereco_cidade", length = 70)
    private String cidade;

    @Column(name = "endereco_cep", length = 10)
    private String cep;

}
