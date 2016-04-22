package controllers;

import models.formularios.FormularioLogin;
import models.Usuario;
import play.Logger;
import play.mvc.Controller;
import play.mvc.Result;

public class LoginController extends Controller {

    public Result logar() {
        FormularioLogin login = Application.getInstance().getFormLogin().bindFromRequest().get();
        try {
            Usuario usuario = Application.getInstance().pesquisarUsuario(login.email);
            usuario.validaSenha(login.senha);
            session("logado", usuario.getEmail());
            Logger.info("Usuario " + usuario.getEmail() + "logou");
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
