package br.edu.uepb.sigeris.converters;

import br.edu.uepb.sigeris.exceptions.SIGERISException;
import br.edu.uepb.sigeris.model.Setor;
import br.edu.uepb.sigeris.services.SetorService;
import br.edu.uepb.sigeris.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author cassio
 */
@FacesConverter(forClass = Setor.class)
public class SetorConverter implements Converter {

    private final SetorService setorService;

    public SetorConverter() throws SIGERISException {
        this.setorService = CDIServiceLocator.getBean(SetorService.class);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        Setor objectToReturn = null;

        if (value != null) {
            objectToReturn = this.setorService.porId(new Long(value));
        }
        return objectToReturn;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value != null) {
            Long code = ((Setor) value).getId();
            return code == null ? null : code.toString();
        }
        return "";
    }
}