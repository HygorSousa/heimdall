package br.com.heimdall.controller;

import br.com.heimdall.application.Util;
import br.com.heimdall.factory.ResponsavelFactory;
import br.com.heimdall.listController.ResponsavelListController;
import br.com.heimdall.model.Professor;
import br.com.heimdall.model.Responsavel;
import br.com.heimdall.model.Telefone;
import br.com.heimdall.repository.ProfessorRepository;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.util.List;

@Named
@ViewScoped
public class ResponsavelController extends Controller<Responsavel> {

    private Telefone telefone;

    @PostConstruct
    public void init() {
        getEntity().getPessoa().getUsuario().setPessoa(getEntity().getPessoa());
    }

    public void abrirListResponsavel() {
        ResponsavelListController list = new ResponsavelListController();
        list.openList(this::setEntity);
    }

    public List<Professor> completeProfessor(String query) {
        ProfessorRepository repository = new ProfessorRepository(getEntityManager());
        return repository.buscarComplete(query, 5);
    }

    @Override
    public void limpar() {
        setEntity(new Responsavel());
    }

    @Override
    public Responsavel incluir() {
        if (getEntity().isProfessor()) {
            getEntity().setPessoa(getEntity().getProfessorResponsavel().getPessoa());
            return super.incluir();
        }

        getEntity().getPessoa().getUsuario().setLogin(getEntity().getPessoa().getEmail());
        getEntity().getPessoa().getUsuario().setSenha(Util.encryptPassword(getEntity().getPessoa().getCpf()));

        getTelefone().setPessoa(getEntity().getPessoa());
        getEntity().getPessoa().getListaTelefone().add(getTelefone());
        return super.incluir();
    }

    @Override
    public Responsavel getEntity() {
        if (entity == null)
            entity = ResponsavelFactory.initialize();
        return entity;
    }

    public Telefone getTelefone() {
        if (telefone == null)
            telefone = new Telefone();
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }
}
