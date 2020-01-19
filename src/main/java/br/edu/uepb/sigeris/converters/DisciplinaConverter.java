package br.edu.uepb.sigeris.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.edu.uepb.sigeris.exceptions.SIGERISException;
import br.edu.uepb.sigeris.model.Disciplina;
import br.edu.uepb.sigeris.services.DisciplinaService;
import br.edu.uepb.sigeris.util.cdi.CDIServiceLocator;

/**
 *
 * @author cassio
 */
@FacesConverter(forClass = Disciplina.class)
public class DisciplinaConverter implements Converter {

    private final DisciplinaService disciplinaService;

    public DisciplinaConverter() throws SIGERISException {
        this.disciplinaService = CDIServiceLocator.getBean(DisciplinaService.class);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        Disciplina objectToReturn = null;

        if (value != null) {
            objectToReturn = this.disciplinaService.porId(new Long(value));
        }
        return objectToReturn;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value != null) {
            Long code = ((Disciplina) value).getId();
            return code == null ? null : code.toString();
        }
        return "";
    }
}