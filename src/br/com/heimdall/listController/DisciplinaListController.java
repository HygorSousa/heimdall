package br.com.heimdall.listController;

import br.com.heimdall.factory.JPAFactory;
import br.com.heimdall.model.Disciplina;
import br.com.heimdall.repository.DisciplinaRepository;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.util.List;

@Named
@ViewScoped
public class DisciplinaListController extends ListController<Disciplina> {

    private List<Disciplina> lista;

    public DisciplinaListController() {
        super(new DisciplinaRepository(JPAFactory.getEntityManager()),
                true, false, false, 450, "95%", "/listings/listagemDisciplina");
    }

    @Override
    public Disciplina getEntity() {
        return new Disciplina();
    }

    public List<Disciplina> getLista() {
        if (lista == null)
            lista = lista();
        return lista;
    }

    public void setLista(List<Disciplina> lista) {
        this.lista = lista;
    }
}
