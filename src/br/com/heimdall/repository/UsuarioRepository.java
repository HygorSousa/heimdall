package br.com.heimdall.repository;

import br.com.heimdall.application.Util;
import br.com.heimdall.model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class UsuarioRepository extends DefaultRepository<Usuario> {

    public UsuarioRepository(EntityManager em) {
        super(em);
    }

    @Override
    protected Class<Usuario> getModelClass() {
        return Usuario.class;
    }

    @Override
    public List<Object> buscarLazy(String search, Integer first, Integer pageSize, Integer lim) {
        String colunas = " usu.id, usu.tipousuario, usu.numerousuario, usu.descricao ";
        Query query = getEntityManager().createNativeQuery(
                "select " + colunas +
                        "from usuario usu " +
                        "where usu.login ilike  ?1 " +
                        "order by usu.id ");
        query.setParameter(1, "%" + search + "%");

        query.setFirstResult(first);
        query.setMaxResults(pageSize);

        return buscarSQL(query);
    }

    @Override
    public Long buscarTodosRegistros(String search) {
        String colunas = " count(1) as count ";
        Query query = getEntityManager().createNativeQuery(
                "select " + colunas +
                        "from usuario usu " +
                        "where usu.login ilike  ?1 ");
        query.setParameter(1, "%" + search + "%");

        return (Long) buscarResultadoUnico(query);
    }

    public Usuario buscarUsuarioLogar(String email, String senha) {
        Query query = getEntityManager().createNativeQuery(
                "select usuario.* " +
                        "from usuario " +
                        "where " +
                        "usuario.login ilike ?1 and " +
                        "usuario.senha ilike ?2 ", Usuario.class);
        query.setParameter(1, email);
        query.setParameter(2, Util.encrypt(senha));

        return buscarResultadoUnicoTipado(query);
    }


}
