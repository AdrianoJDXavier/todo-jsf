package com.acme.todo.facade;

import com.acme.todo.model.Tarefa;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class TarefaFacade extends AbstractFacade<Tarefa> {

    @PersistenceContext(unitName = "todo-pu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TarefaFacade() {
        super(Tarefa.class);
    }
    
}
