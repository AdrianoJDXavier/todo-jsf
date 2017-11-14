package com.acme.todo.controller;

import com.acme.todo.facade.UsuarioFacade;
import com.acme.todo.model.Usuario;
import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class LoginBean implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Inject
    private UsuarioFacade facade;
    
    private Usuario novoUsuario = new Usuario();
    
    public void validaLogin(String email, String senha){
        
    }
    
}
