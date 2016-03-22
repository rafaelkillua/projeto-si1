package controllers;

import models.Usuario;
import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public static Usuario usuarioLogado() {
        return new Usuario(session("logado"));
    }

    public Result agendarCarona(){return ok(agendarCarona.render(usuarioLogado())); }

    public Result enderecos() {return ok(enderecos.render(usuarioLogado())); }

    public Result solicitacoes() {return ok(solicitacoes.render(usuarioLogado())); }

}
