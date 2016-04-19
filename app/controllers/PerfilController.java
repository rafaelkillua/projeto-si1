package controllers;

import models.Usuario;
import models.formularios.FormularioPerfil;
import play.Logger;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class PerfilController extends Controller {

    public Result atualizarPerfil() {
        Form<FormularioPerfil> formularioPerfil = Application.getInstance().getFormPerfil().bindFromRequest();
        try {
            Usuario usuarioLogado = Application.getInstance().getUsuarioLogado();
            if (!formularioPerfil.hasErrors()) {
                FormularioPerfil perfil = formularioPerfil.get();
                usuarioLogado.setNome(perfil.nome);
                usuarioLogado.setMatricula(perfil.matricula);
                usuarioLogado.setTelefone(perfil.telefone);
                usuarioLogado.setEmail(perfil.email);
                session("logado", usuarioLogado.getEmail());
                usuarioLogado.setQuantidadeDeVagas(perfil.quantidadeDeVagas);
            }
        } catch (Exception e) {
            Logger.error(e.getMessage());
        }
        return redirect("/perfil");
    }
}
