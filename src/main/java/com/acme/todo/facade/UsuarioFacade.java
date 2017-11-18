/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acme.todo.facade;

import com.acme.todo.model.Usuario;
import com.acme.todo.util.Hash;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author alunoces
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "todo-pu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    public Usuario buscaPorCredenciais(String email, String senha) {
        TypedQuery<Usuario> q = em.createQuery("select u from Usuario u where u.email = :email and u.senha = :senha", Usuario.class);
        q.setParameter("email", email);
        q.setParameter("senha", Hash.md5(senha));
        Usuario usuario;
        try {
            usuario = q.getSingleResult();
        } catch (NoResultException e) {
            usuario = null;
        }
        return usuario;
    }
}
