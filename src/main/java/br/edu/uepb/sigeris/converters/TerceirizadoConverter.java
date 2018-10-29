package br.edu.uepb.sigeris.converters;

import br.edu.uepb.sigeris.exceptions.SIGERISException;
import br.edu.uepb.sigeris.model.Terceirizado;
import br.edu.uepb.sigeris.services.TerceirizadoService;
import br.edu.uepb.sigeris.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author cassio
 */
@FacesConverter(forClass = Terceirizado.class)
public class TerceirizadoConverter implements Converter {

    private final TerceirizadoService terceirizadoService;

    public TerceirizadoConverter() throws SIGERISException {
        this.terceirizadoService = CDIServiceLocator.getBean(TerceirizadoService.class);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        Terceirizado objectToReturn = null;

        if (value != null) {
            objectToReturn = this.terceirizadoService.findById(new Long(value));
        }
        return objectToReturn;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value != null) {
            Long code = ((Terceirizado) value).getId();
            return code == null ? null : code.toString();
        }
        return "";
    }
}
