package com.acme.todo.listener;

import com.acme.todo.model.UsuarioLogado;
import javax.faces.application.Application;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class AutenticacaoListener implements PhaseListener {

    @Override
    public void afterPhase(PhaseEvent event) {
    }

    @Override
    public void beforePhase(PhaseEvent event) {
        FacesContext faces = FacesContext.getCurrentInstance();
        if (faces.getViewRoot() != null && !faces.getViewRoot().getViewId().equals("/login.xhtml")) {
            Application app = faces.getApplication();
            UsuarioLogado user = app.evaluateExpressionGet(faces, "#{usuarioLogado}", UsuarioLogado.class);
            if (user == null || !user.possuiUsuario()) {
                NavigationHandler h = app.getNavigationHandler();
                h.handleNavigation(faces, "", "login");
                faces.renderResponse();
            }
        }
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }

}
