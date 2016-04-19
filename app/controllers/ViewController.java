package controllers;

import play.Logger;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

/**
 * Created by Rafael on 10/04/2016.
 */
public class ViewController extends Controller {

    public Result index() {
        String email = session("logado");
        if (email == null) {
            return redirect("/login");
        }
        try {
            return ok(index2.render(Application.getInstance().getUsuarioLogado(), Application.getCatalogoCaronas().quantidadeDeCaronas()));
        } catch (Exception e) {
            Logger.error(e.getMessage());
            session().clear();
            return redirect("/login");
        }
    }

    public Result cadastro() throws Exception {
        try {
            Application.getInstance().getUsuarioLogado();
            return redirect("/");
        } catch (Exception e) {
            return ok(cadastro.render(Application.getInstance().getFormCadastro()));
        }
    }

    public Result login() {
        try {
            Application.getInstance().getUsuarioLogado();
            return redirect("/");
        } catch (Exception e) {
            return ok(login.render(Application.getInstance().getFormLogin()));
        }
    }

    public Result perfil() throws Exception {
        try {
            Application.getInstance().getUsuarioLogado();
            return ok(perfil.render(Application.getInstance().getUsuarioLogado(), Application.getInstance().getFormPerfil()));
        } catch (Exception e) {
            return redirect("/");
        }
    }

    public Result agendarCarona() {
        try {
            Application.getInstance().getUsuarioLogado();
            return ok(agendarCarona.render(Application.getInstance().getUsuarioLogado()));
        } catch (Exception e) {
            return redirect("/");
        }
    }

    public Result oferecerCarona() {
        try {
            Application.getInstance().getUsuarioLogado();
            return ok(oferecerCarona.render(Application.getInstance().getUsuarioLogado(), Application.getInstance().getFormCarona()));
        } catch (Exception e) {
            return redirect("/");
        }
    }

    public Result solicitacoes() throws Exception {
        try {
            Application.getInstance().getUsuarioLogado();
            return ok(solicitacoes.render(Application.getInstance().getUsuarioLogado()));
        } catch (Exception e) {
            return redirect("/");
        }
    }
}
