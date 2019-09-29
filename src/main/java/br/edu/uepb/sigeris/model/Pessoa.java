package br.edu.uepb.sigeris.model;

import br.edu.uepb.sigeris.enumerations.VincluoServidor;
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

    @Column(name = "situacao", length = 10)
    private String situacao; 
    
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

    @Pattern(regexp = "^$|^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})$",
            message = "E-mail com formato incorreto")
    @Column(name = "email_emergencia", length = 100)
    private String contatoEmergenciaEmail;

    @Pattern(regexp = "^$|[a-zA-Z\\d/.-]{1,}",
            message = "Apenas letras números ou os caracteres a seguir são aceitos para o RG: / . -")
    @Column(name = "rg", length = 15)
    private String rg;

    @Column(name = "orgao_expedidor", length = 20)
    private String orgaoExpedidor;

    @Temporal(TemporalType.DATE)
    @Column(name = "rg_data_expedicao")
    private Date rgDataExpedicao;

    @Column(name = "rg_uf", length = 10)
    private String rgUF;

    @Column(name = "titulo_eleitoral", length = 20)
    private String tituloEleitoral;

    @Column(name = "titulo_zona", length = 5)
    private String tituloZona;

    @Column(name = "titulo_secao", length = 5)
    private String tituloSecao;

    @Column(name = "titulo_municipio", length = 70)
    private String tituloMunicipio;

    @Column(name = "titulo_uf", length = 10)
    private String tituloUF;

    @Column(name = "reservista", length = 20)
    private String reservista;

    @Column(name = "reservista_regiao_militar", length = 20)
    private String reservistaRegiaoMilitar;

    @Column(name = "reservista_municipio", length = 70)
    private String reservistaMunicipio;

    @Column(name = "reservista_uf", length = 10)
    private String reservistaUF;

    @Column(name = "certidao_casamento_nascimento", length = 20)
    private String certidaoCasamentoNascimento;

    @Column(name = "certidao_numero", length = 20)
    private String certidaoNumero;

    @Column(name = "certidao_livro", length = 20)
    private String certidaoLivro;

    @Column(name = "certidao_folha", length = 20)
    private String certidaoFolha;

    @Column(name = "certidao_cartorio", length = 20)
    private String certidaoCartorio;

    @Column(name = "certidao_comarca", length = 20)
    private String certidaoComarca;
    
    @Column(name = "certidao_uf", length = 10)
    private String certidaoUF;

    @Column(name = "ctps", length = 20)
    private String ctps;

    @Column(name = "ctps_municipio", length = 70)
    private String ctpsMunicipio;

    @Column(name = "ctps_uf", length = 10)
    private String ctpsUF;

    @Column(name = "ctps_serie", length = 20)
    private String ctpsSerie;

    @Column(name = "telefone", length = 20)
    private String telefone;

    @Column(name = "celular", length = 20)
    private String celular;

    @Column(name = "contato_emergencia_tipo", length = 30)
    private String contatoEmergenciaTipo;

    @Column(name = "contato_emergencia_nome", length = 200)
    private String contatoEmergenciaNome;

    @Column(name = "contato_emergencia_telefone", length = 20)
    private String contatoEmergenciaTelefone;
    
    @Column(name = "contato_emergencia_celular", length = 20)
    private String contatoEmergenciaCelular;

    @Column(name = "sexo", length = 1)
    private String sexo;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_nascimento")
    private Date dataNascimento;

    @Column(name = "estado_civil", length = 15)
    private String estadoCivil;

    @Column(name = "pis_pasep", length = 30)
    private String pisPasep;

    @Enumerated(EnumType.STRING)
    @Column(name = "categoria")
    private VincluoServidor vinculo;

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

    @Column(name = "nacionalidade", length = 40)
    private String nacionalidade;

    @Column(name = "naturalidade", length = 70)
    private String naturalidade;

    @Column(name = "municipio_residencia", length = 70)
    private String municipioResidencia;

    @Column(name = "estado_origem", length = 70)
    private String estadoOrigem;
    
    @Column(name = "pais_origem", length = 70)
    private String paisOrigem;
    
    @Column(name = "cidade_origem", length = 70)
    private String cidadeOrigem;

    @Column(name = "estado_residencia", length = 70)
    private String estadoResidencia;

    @Column(name = "profissional_escolaridade", length = 50)
    private String profissionalEscolaridade;
    
    @Column(name = "profissional_setor", length = 50)
    private String profissionalSetor;

    @Column(name = "profissional_formacao", length = 50)
    private String profissionalFormacao;

    @Column(name = "profissional_cargo", length = 50)
    private String profissionalCargo;

    @Column(name = "profissional_funcao", length = 50)
    private String profissionalFuncao;

    @Column(name = "profissional_campus_lotacao", length = 50)
    private String profissionalCampusLotacao;
    
    @Column(name = "passaporte_numero", length = 50)
    private String passaporteNumero;
    
    @Column(name = "deficiencia", length = 100)
    private String deficiencia;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "passaporte_visto")
    private Date passaporteVisto;

    @Temporal(TemporalType.DATE)
    @Column(name = "passaporte_validade")
    private Date passaporteValidade;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "profissional_data_admissao")
    private Date profissionalDataAdmissao;

    @Temporal(TemporalType.DATE)
    @Column(name = "profissional_data_final_contrato")
    private Date profissionalDataFinalContrato;

    @Temporal(TemporalType.DATE)
    @Column(name = "profissional_data_desligamento")
    private Date profissionalDataDesligamento;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_ultima_atualizacao")
    private Date dataUltimaAtualizacao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_cadastro")
    private Date dataCadastro;
}
