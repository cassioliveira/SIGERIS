//package br.edu.uepb.sigeris.repository;
//
//import br.edu.uepb.sigeris.model.Pessoa;
//import java.io.Serializable;
//import java.util.List;
//import javax.persistence.Query;
//
///**
// *
// * @author Cássio Oliveira <cassio@cassioliveira.com.br>
// */
//public class GlobalQueries extends Generic<GlobalQueries> implements Serializable {
//
//    private static final long serialVersionUID = 1L;
//
//    public GlobalQueries() {
//        super(GlobalQueries.class);
//    }
//
//    public List<String> returnCities(int ufCode) {
//        Query createQuery;
//        createQuery = getEntityManager().createNativeQuery("SELECT c.nome FROM cidades c where c.estado = " + ufCode);
//        return createQuery.getResultList();
//    }
//}
