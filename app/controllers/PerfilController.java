package controllers;

import models.Usuario;
import models.formularios.FormularioPerfil;
import play.Logger;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.Calendar;

public class PerfilController extends Controller {

    public Result atualizarPerfil() {
        Calendar horaInicial = Calendar.getInstance();
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
                usuarioLogado.setEndereco(perfil.rua, perfil.bairro);
                flash("success", "Perfil atualizado com sucesso");
                Calendar horaFinal = Calendar.getInstance();
                Logger.info("Usuário " + usuarioLogado.getEmail() + " atualizou o perfil em " +
                        (horaFinal.getTimeInMillis() - horaInicial.getTimeInMillis()) + " ms");
            }
        } catch (Exception e) {
            flash("error", e.getMessage());
            Logger.error(e.getMessage());
        }
        return redirect("/perfil");
    }
}
