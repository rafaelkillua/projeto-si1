package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

public class indexController extends Controller {

    public Result index() { return ok(index.render()); }

}