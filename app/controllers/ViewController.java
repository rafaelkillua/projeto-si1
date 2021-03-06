package controllers;

import models.Carona;
import models.Solicitacao;
import play.Logger;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

import java.util.List;

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

    public Result oferecerCarona() {
        try {
            Application.getInstance().getUsuarioLogado();
            return ok(oferecerCarona.render(Application.getInstance().getUsuarioLogado(), Application.getInstance().getFormCarona()));
        } catch (Exception e) {
            return redirect("/");
        }
    }

    public Result solicitacoes(Integer pagina) throws Exception {
        try {
            Application.getInstance().getUsuarioLogado();
            return ok(solicitacoes.render(Application.getInstance().getUsuarioLogado(), pagina));
        } catch (Exception e) {
            Logger.error(e.getMessage());
            return redirect("/");
        }
    }

    public Result pesquisarCarona() {
        try{
            Application.getInstance().getUsuarioLogado();
            return ok(pesquisarCarona.render(Application.getInstance().getUsuarioLogado(), Application.getInstance().getFormPesquisa()));
        } catch (Exception e) {
            return redirect("/");
        }
    }

    public Result resultadoPesquisa(int pagina){
        try{
            Application.getInstance().getUsuarioLogado();
            return ok(resultadoPesquisa.render(Application.getInstance().getUsuarioLogado(), pagina));
        }catch (Exception e){
            return redirect("/");
        }
    }
}
