package com.acme.todo.controller;

import com.acme.todo.facade.TarefaFacade;
import com.acme.todo.model.Tarefa;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class TarefasBean implements Serializable{
    
   private static final long serialVersionUID = 1L;
   
    @Inject
    private TarefaFacade facade;
   
    private Tarefa novaTarefa 
            = new Tarefa();
    
    public Tarefa getNovaTarefa() {
        return novaTarefa;
    }

    public List<Tarefa> getTarefas() {
        return facade.findAll();
    }
    
    public void adicionar(){
        facade.create(novaTarefa);
        novaTarefa = new Tarefa();
    }
    
}
