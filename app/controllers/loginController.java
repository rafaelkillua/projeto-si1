package controllers;

import models.FormularioLogin;
import models.Usuario;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.agendarCarona;
import views.html.enderecos;
import views.html.login;
import views.html.solicitacoes;

public class LoginController extends Controller {

    final static Form<FormularioLogin> loginForm = play.data.Form.form(FormularioLogin.class);

    public Result login() {
        return ok(login.render(loginForm));
    }

    public Result deslogar() {
        session().clear();
        return redirect("/");
    }

    public Result logar() {
        Form<FormularioLogin> loginForm = play.data.Form.form(FormularioLogin.class).bindFromRequest();
        session("logado", loginForm.get().nome);
        return redirect("/");
    }

}
