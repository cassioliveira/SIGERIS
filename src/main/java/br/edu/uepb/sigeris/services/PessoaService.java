package br.edu.uepb.sigeris.services;

import br.edu.uepb.sigeris.model.Pessoa;
import br.edu.uepb.sigeris.model.Professor;
import br.edu.uepb.sigeris.model.Tecnico;
import br.edu.uepb.sigeris.repository.GlobalQueries;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

/**
 * Possui metodos comuns a todas as entidades que herdam de <b>Pessoa</b>
 *
 * @see Pessoa
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
public class PessoaService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private GlobalQueries queries;

    @Inject
    private ProfessorService professorService;

    @Inject
    private TecnicoService tecnicoService;

    /**
     * Verifica se o ID da pessoa já existe, indicando se é um novo cadastro.
     *
     * @param entidade
     * @return
     */
    public boolean novoCadastro(Pessoa entidade) {
        return entidade.getId() == null;
    }

    public List<Pessoa> servidores() {
        return queries.servidores();
    }

    public String direcionaParaEdicao(Pessoa pessoa) {
        String pagina;
        switch (pessoa.getTipo()) {
            case "PROFESSOR":
                pagina = "/servidor/cadastro-professor";
                break;
            case "TECNICO":
                pagina = "/servidor/cadastro-tecnico";
                break;
            default:
                pagina = "";
                break;
        }
        return pagina;
    }

    public void botaoExclusaoServidor(Pessoa pessoa, Professor professor, Tecnico tecnico) {
        if("PROFESSOR".equals(pessoa.getTipo())){
            professorService.deletar(professor);
        }else if("TECNICO".equals(pessoa.getTipo())){
            tecnicoService.deletar(tecnico);
        }
    }
}
