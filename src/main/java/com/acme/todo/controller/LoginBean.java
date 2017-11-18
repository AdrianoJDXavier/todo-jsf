package com.acme.todo.controller;

import com.acme.todo.facade.UsuarioFacade;
import com.acme.todo.model.Usuario;
import com.acme.todo.model.UsuarioLogado;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class LoginBean implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Inject
    private UsuarioFacade facade;
    
    @Inject
    private UsuarioLogado usuarioLogado;
    
    private String email;
    private String senha;

    public String entrar(){
        Usuario usuario = facade.buscaPorCredenciais(email, senha);
        if(usuario != null){
            usuarioLogado.setUsuario(usuario);
            return "tarefas";
        }
        FacesMessage msg = new FacesMessage("E-mail/Senha invalidos!");
        FacesContext.getCurrentInstance().addMessage("erro", msg);
        return null;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    
}
