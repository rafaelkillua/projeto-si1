package controllers;

import models.Usuario;
import play.Logger;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;


public class IndexController extends Controller {

    public Result index() {
        String nomeDoUsuarioLogado = session("logado");
        if (nomeDoUsuarioLogado == null) {
            return redirect("/login");
        } else {
            return ok(index2.render(Application.usuarioLogado()));
        }
    }

}
