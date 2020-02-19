package br.edu.uepb.sigeris.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.edu.uepb.sigeris.exceptions.SIGERISException;
import br.edu.uepb.sigeris.model.Reuniao;
import br.edu.uepb.sigeris.services.ReuniaoService;
import br.edu.uepb.sigeris.util.cdi.CDIServiceLocator;

/**
 *
 * @author cassio
 */
@FacesConverter(forClass = Reuniao.class)
public class ReuniaoConverter implements Converter {

    private final ReuniaoService reuniaoService;

    public ReuniaoConverter() throws SIGERISException {
        this.reuniaoService = CDIServiceLocator.getBean(ReuniaoService.class);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        Reuniao objectToReturn = null;

        if (value != null) {
            objectToReturn = this.reuniaoService.porId(Long.valueOf(value));
        }
        return objectToReturn;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value != null) {
            Long code = ((Reuniao) value).getId();
            return code == null ? null : code.toString();
        }
        return "";
    }
}