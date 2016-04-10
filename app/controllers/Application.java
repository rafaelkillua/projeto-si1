package controllers;

import models.FormularioCadastro;
import models.FormularioLogin;
import models.Usuario;
import play.Logger;
import play.data.Form;
import play.mvc.*;

import scala.App;
import views.html.*;

import java.util.ArrayList;
import java.util.List;

public class Application extends Controller {

    private final Form<FormularioLogin> formLogin = play.data.Form.form(FormularioLogin.class);
    private final Form<FormularioCadastro> formCadastro = play.data.Form.form(FormularioCadastro.class);

    private List<Usuario> usuariosCadastrados = new ArrayList<>();

    private static Application instance = new Application();

    private Application() {

    }

    public static Application getInstance() {
        return instance;
    }

    public Form<FormularioLogin> getFormLogin() {
        return formLogin;
    }

    public Form<FormularioCadastro> getFormCadastro() {
        return formCadastro;
    }

    public Usuario getUsuarioLogado() throws Exception {
        return pesquisarUsuario(session("logado"));
    }

    public void cadastrarUsuario(Usuario usuario) {
        usuariosCadastrados.add(usuario);
        Logger.info("Cadastrou " + usuario.getEmail() + usuario.getSenha());
    }

    public Usuario pesquisarUsuario(String email) throws Exception {
        for (Usuario user : usuariosCadastrados) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                return user;
            }
        }
        throw new Exception("E-mail* ou senha não conferem");
    }
}
