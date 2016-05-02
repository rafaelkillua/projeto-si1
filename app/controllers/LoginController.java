package controllers;

import models.formularios.FormularioLogin;
import models.Usuario;
import play.Logger;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.Calendar;

public class LoginController extends Controller {

    public Result logar() {
        Calendar horaInicial = Calendar.getInstance();
        FormularioLogin login = Application.getInstance().getFormLogin().bindFromRequest().get();
        try {
            Usuario usuario = Application.getInstance().pesquisarUsuario(login.email);
            usuario.validaSenha(login.senha);
            session("logado", usuario.getEmail());
            Calendar horaFinal = Calendar.getInstance();
            Logger.info("Usuário " + usuario.getEmail() + " logado em " +
                    (horaFinal.getTimeInMillis() - horaInicial.getTimeInMillis()) + " ms");
        } catch (Exception e) {
            flash("error", e.getMessage());
            Logger.error(e.getMessage());
            return redirect("/login");
        }
        return redirect("/");
    }

    public Result deslogar() {
        String email = session("logado");
        session().clear();
        Logger.info("Usuário " + email + " deslogado");
        return redirect("/");

    }

}
