package br.edu.uepb.sigeris.repository;

import br.edu.uepb.sigeris.model.Professor;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
public class Professores extends Generic<Professor> implements Serializable {

    private static final long serialVersionUID = 1L;

    public Professores() {
        super(Professor.class);
//        Professor teacher = new Professor();
    }

    /**
     * Retorna todas as áreas de conhecimento associadas ao professor
     * cadastradas
     *
     * @return
     */
    public List<String> getTeacherAreas() {
        return getEntityManager().createNamedQuery("Teacher.areas").getResultList();
    }
}
