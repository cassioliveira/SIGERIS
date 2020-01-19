package br.edu.uepb.sigeris.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.edu.uepb.sigeris.exceptions.SIGERISException;
import br.edu.uepb.sigeris.model.Tecnico;
import br.edu.uepb.sigeris.services.TecnicoService;
import br.edu.uepb.sigeris.util.cdi.CDIServiceLocator;

/**
 *
 * @author cassio
 */
@FacesConverter(forClass = Tecnico.class)
public class TecnicoConverter implements Converter {

    private final TecnicoService tecnicoService;

    public TecnicoConverter() throws SIGERISException {
        this.tecnicoService = CDIServiceLocator.getBean(TecnicoService.class);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        Tecnico objectToReturn = null;

        if (value != null) {
            objectToReturn = this.tecnicoService.findById(new Long(value));
        }
        return objectToReturn;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value != null) {
            Long code = ((Tecnico) value).getId();
            return code == null ? null : code.toString();
        }
        return "";
    }
}
