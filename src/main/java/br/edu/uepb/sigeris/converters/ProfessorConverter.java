package br.edu.uepb.sigeris.converters;

import br.edu.uepb.sigeris.exceptions.SIGERISException;
import br.edu.uepb.sigeris.model.Professor;
import br.edu.uepb.sigeris.services.ProfessorService;
import br.edu.uepb.sigeris.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author cassio
 */
@FacesConverter(forClass = Professor.class)
public class ProfessorConverter implements Converter {

    private final ProfessorService teacherService;

    public ProfessorConverter() throws SIGERISException {
        this.teacherService = CDIServiceLocator.getBean(ProfessorService.class);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        Professor objectToReturn = null;

        if (value != null) {
            objectToReturn = this.teacherService.findById(new Long(value));
        }
        return objectToReturn;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value != null) {
            Long code = ((Professor) value).getId();
            return code == null ? null : code.toString();
        }
        return "";
    }
}
