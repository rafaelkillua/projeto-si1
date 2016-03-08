package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public Result index() { return ok(index.render("Index teste")); }

    public Result login() {
        return ok(login.render());
    }

    public Result cadastro() {return ok(cadastro.render()); }
}
