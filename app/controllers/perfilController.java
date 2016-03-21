package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

public class perfilController extends Controller {

    public Result perfil() {return ok(perfil.render()); }
}