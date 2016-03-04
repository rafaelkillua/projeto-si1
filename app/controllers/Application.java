package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public Result index() {
        return ok(index.render("Novo Tasdasdatulo asdgyuas"));
    }

    public Result login() {
        return ok(login.render());
    }

}
