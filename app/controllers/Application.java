package controllers;

import models.Pessoa;
import models.Usuario;
import play.*;
import play.mvc.*;

import views.html.*;

import java.util.ArrayList;
import java.util.List;

public class Application extends Controller {

    public static List<Pessoa> usuariosCadastrados = new ArrayList<>();

    public static Usuario usuarioLogado() {
        return new Usuario(session("logado"));
    }

    public Result agendarCarona(){return ok(agendarCarona.render(usuarioLogado())); }

    public Result enderecos() {return ok(enderecos.render(usuarioLogado())); }

    public Result solicitacoes() {return ok(solicitacoes.render(usuarioLogado())); }

}
