package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public Result agendarCarona(){return ok(agendarCarona.render()); }

    public Result enderecos() {return ok(enderecos.render()); }

    public Result solicitacoes() {return ok(solicitacoes.render()); }

}