package br.com.heimdall.listController;

import br.com.heimdall.factory.JPAFactory;
import br.com.heimdall.model.Responsavel;
import br.com.heimdall.repository.ResponsavelRepository;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class ResponsavelListController extends DefaultListController<Responsavel> {

    public ResponsavelListController() {
        super(new ResponsavelRepository(JPAFactory.getEntityManager()),
                true, false, false, 450, "95%", "/listings/listagemResponsavel");
    }

}
