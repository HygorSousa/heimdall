package br.com.heimdall.listController;

import br.com.heimdall.application.Util;
import br.com.heimdall.factory.JPAFactory;
import br.com.heimdall.model.Sala;
import br.com.heimdall.repository.SalaRepository;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class SalaListController extends DefaultListController<Sala> {

    public SalaListController() {
        super(new SalaRepository(JPAFactory.getEntityManager()),
                true, false, false, 450, "95%", "/listings/listagemSala");
    }

    public String getLabel(Integer tipo, Integer numero) {
        if (tipo != null && numero != null)
            return Util.parseEnum(tipo, Sala.TipoSala.class).getLabel() + " - " + numero;
        return "";
    }

}
