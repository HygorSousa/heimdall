package br.com.heimdall.controller;

import br.com.heimdall.application.Util;
import br.com.heimdall.factory.JPAFactory;
import br.com.heimdall.model.DefaultEntity;
import br.com.heimdall.repository.DefaultRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

public abstract class Controller<T extends DefaultEntity<T>> implements Serializable {

    protected T entity = null;
    private EntityManager em = null;
    private Class<T> clazz;

    public abstract void limpar();

    public T incluir() {
        DefaultRepository<T> repository = getRepository(getEntityManager());
        getEntityManager().getTransaction().begin();
        T result = repository.salvar(getEntity());
        getEntityManager().getTransaction().commit();
        limpar();
        Util.addInfoMessage("Inclus�o realizada com sucesso!");
        return result;
    }

    public T alterar() {
        DefaultRepository<T> repository = getRepository(getEntityManager());

        getEntityManager().getTransaction().begin();

        T result = repository.salvar(getEntity());

        getEntityManager().getTransaction().commit();
        limpar();
        Util.addInfoMessage("Altera��o realizada com sucesso!");
        return result;
    }

    public void remover() {
        DefaultRepository<T> repository = getRepository(getEntityManager());

        getEntityManager().getTransaction().begin();

        repository.remover(getEntity());

        getEntityManager().getTransaction().commit();
        limpar();
        Util.addInfoMessage("Remo��o realizada com sucesso!");
    }

    public abstract T getEntity();

    public void setEntity(T entity) {
        this.entity = entity;
    }

    protected EntityManager getEntityManager() {
        if (em == null)
            em = JPAFactory.getEntityManager();
        return em;
    }

    protected DefaultRepository<T> getRepository(EntityManager em) {
        try {
            return (DefaultRepository<T>) Class.forName(entity.getClass().getName().replace("model", "repository") + "Repository")
                    .getConstructor(EntityManager.class).newInstance(em);
        } catch (InstantiationException | IllegalAccessException
                | ClassNotFoundException | NoSuchMethodException | SecurityException | IllegalArgumentException | InvocationTargetException e) {
            System.out.println("N�o existe um reposit�rio (repository) para o modelo " + getEntity().getClass().getName());
            e.printStackTrace();
        }
        return null;
    }
}
