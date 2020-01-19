package br.edu.uepb.sigeris.repository;

import java.io.Serializable;
import java.util.List;

import br.edu.uepb.sigeris.model.Professor;

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
