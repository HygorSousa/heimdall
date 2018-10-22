package br.com.heimdall.repository;

import br.com.heimdall.model.Sala;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class SalaRepository extends DefaultRepository<Sala> {

    public SalaRepository(EntityManager em) {
        super(em);
    }

    @Override
    protected Class<Sala> getModelClass() {
        return Sala.class;
    }

    public Integer getNumeroSugestao() {
        Query query = getEntityManager().createNativeQuery(
                "select max(CAST(coalesce(sala.numerosala, '0') AS INTEGER)) AS numero  " +
                        "from sala");
        Integer result = (Integer) buscarResultadoUnico(query);
        return result == null ? 1 : result + 1;
    }


}
