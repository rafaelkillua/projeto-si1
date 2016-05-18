package controllers;

import models.CatalogoCaronas;
import models.Usuario;
import models.formularios.*;
import play.data.Form;
import play.i18n.Messages;
import play.mvc.Controller;

import java.util.ArrayList;
import java.util.List;

public class Application extends Controller {

    private final Form<FormularioLogin> formLogin = play.data.Form.form(FormularioLogin.class);
    private final Form<FormularioCadastro> formCadastro = play.data.Form.form(FormularioCadastro.class);
    private final Form<FormularioCarona> formCarona = play.data.Form.form(FormularioCarona.class);
    private final Form<FormularioPerfil> formPerfil = play.data.Form.form(FormularioPerfil.class);
    private final Form<FormularioPesquisa> formPesquisa = play.data.Form.form(FormularioPesquisa.class);

    private List<Usuario> usuariosCadastrados = new ArrayList<>();

    private static Application instance = new Application();
    private static CatalogoCaronas catalogoCaronas = new CatalogoCaronas();

    private Application() {
        usuariosCadastrados = Usuario.find.fetch("solicitacoesRecebidas").findList();
    }


    public static Application getInstance() {
        return instance;
    }

    public static CatalogoCaronas getCatalogoCaronas() {
        return catalogoCaronas;
    }

    public Form<FormularioLogin> getFormLogin() {
        return formLogin;
    }

    public Form<FormularioCadastro> getFormCadastro() {
        return formCadastro;
    }

    public Form<FormularioCarona> getFormCarona() {
        return formCarona;
    }

    public Form<FormularioPerfil> getFormPerfil() {
        return formPerfil;
    }

    public Form<FormularioPesquisa> getFormPesquisa() {
        return formPesquisa;
    }

    public Usuario getUsuarioLogado() throws Exception {
        return pesquisarUsuario(session("logado"));
    }

    public void cadastrarUsuario(Usuario usuario) {
        usuario.save();
        usuariosCadastrados.add(usuario);
    }

    public Usuario pesquisarUsuario(String email) throws Exception {
        for (Usuario user : usuariosCadastrados) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                return user;
            }
        }
        throw new Exception(Messages.get("error.login"));
    }
}
