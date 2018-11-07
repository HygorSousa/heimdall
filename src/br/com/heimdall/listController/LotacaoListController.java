package br.com.heimdall.listController;

import br.com.heimdall.factory.JPAFactory;
import br.com.heimdall.model.Lotacao;
import br.com.heimdall.repository.LotacaoRepository;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class LotacaoListController extends DefaultListController<Lotacao> {

    public LotacaoListController() {
        super(new LotacaoRepository(JPAFactory.getEntityManager()),
                true, false, false, 450, "95%", "/listings/listagemLotacao");
    }

}
