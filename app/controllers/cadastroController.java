package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

public class cadastroController extends Controller {

    public Result cadastro() {return ok(cadastro.render()); }

}