package controllers;

import play.mvc.Controller;
import play.mvc.Result;


public class IndexController extends Controller {

    public Result ptbr() {
        ctx().changeLang("pt-BR");
        return redirect("/");
    }

    public Result en() {
        ctx().changeLang("en");
        return redirect("/");
    }
}
