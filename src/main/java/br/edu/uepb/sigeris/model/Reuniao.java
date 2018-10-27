package br.edu.uepb.sigeris.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import lombok.Data;

/**
 * Classe que representa o modelo da entidade Curso a ser persistida no banco,
 * com todos os seus atributos.
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
@Data
public class Reuniao implements Serializable {

    private static final long serialVersionUID = 1L;
    private String tituloDocumento;
    private String setor;
    private String atividade;
    private String local;
    private Date data;
    private Date hora;
    private String pauta;
    private List<Pessoa> servidores;

    public Reuniao() {
        setTituloDocumento("Lista de presença");
    }
    
}
