package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

public class loginController extends Controller {

    public Result login() { return ok(login.render()); }

}