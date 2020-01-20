//package br.edu.uepb.sigeris.converters;
//
//import br.edu.uepb.sigeris.exceptions.SIGERISException;
//import br.edu.uepb.sigeris.model.Curso;
//import br.edu.uepb.sigeris.services.CursoService;
//import br.edu.uepb.sigeris.util.cdi.CDIServiceLocator;
//import javax.faces.component.UIComponent;
//import javax.faces.context.FacesContext;
//import javax.faces.convert.Converter;
//import javax.faces.convert.FacesConverter;
//
///**
// *
// * @author cassio
// */
//@FacesConverter(forClass = Curso.class, value = "cursoConverter")
//public class CursoConverter implements Converter {
//
//    private final CursoService cursoService;
//
//    public CursoConverter() throws SIGERISException {
//        this.cursoService = CDIServiceLocator.getBean(CursoService.class);
//    }
//
//    @Override
//    public Object getAsObject(FacesContext context, UIComponent component, String value) {
//
//        Curso objectToReturn = null;
//
//        if (value != null) {
//            objectToReturn = this.cursoService.porId(Long.valueOf(value));
//        }
//        return objectToReturn;
//    }
//
//    @Override
//    public String getAsString(FacesContext context, UIComponent component, Object value) {
//
//        if (value != null) {
//            Long code = ((Curso) value).getId();
//            return code == null ? null : code.toString();
//        }
//        return "";
//    }
//}