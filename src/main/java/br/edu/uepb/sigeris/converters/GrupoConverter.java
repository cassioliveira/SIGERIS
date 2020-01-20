package br.edu.uepb.sigeris.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.edu.uepb.sigeris.exceptions.SIGERISException;
import br.edu.uepb.sigeris.model.Grupo;
import br.edu.uepb.sigeris.services.GrupoService;
import br.edu.uepb.sigeris.util.cdi.CDIServiceLocator;

/**
 *
 * @author cassio
 */
@FacesConverter(forClass = Grupo.class)
public class GrupoConverter implements Converter {

    private final GrupoService grupoService;

    public GrupoConverter() throws SIGERISException {
        this.grupoService = CDIServiceLocator.getBean(GrupoService.class);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        Grupo objectToReturn = null;

        if (value != null) {
            objectToReturn = this.grupoService.porId(Long.valueOf(value));
        }
        return objectToReturn;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value != null) {
            Long code = ((Grupo) value).getId();
            return code == null ? null : code.toString();
        }
        return "";
    }
}