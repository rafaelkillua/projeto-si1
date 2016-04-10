package controllers;

import models.FormularioLogin;
import models.Usuario;
import play.Logger;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.login;

public class LoginController extends Controller {

    public Result logar() {
        FormularioLogin login = Application.getInstance().getFormLogin().bindFromRequest().get();
        try {
            Usuario usuario = Application.getInstance().pesquisarUsuario(login.getEmail());
            usuario.validaSenha(login.getSenha());
            session("logado", usuario.getEmail());
            Logger.info("Logou " + usuario.getEmail());
        } catch (Exception e) {
            Logger.error(e.getMessage());
        }
        return redirect("/");
    }

    public Result deslogar() {
        session().clear();
        return redirect("/");
    }

}
