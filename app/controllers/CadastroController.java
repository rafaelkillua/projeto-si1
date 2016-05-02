package controllers;

import models.formularios.FormularioCadastro;
import models.Usuario;
import play.data.Form;
import play.Logger;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.Calendar;

public class CadastroController extends Controller {

    public Result cadastrar() {
        Calendar horaInicial = Calendar.getInstance();
        Form<FormularioCadastro> formularioCadastro = Application.getInstance().getFormCadastro().bindFromRequest();
        if (!formularioCadastro.hasErrors()) {
            FormularioCadastro cadastro = formularioCadastro.get();
            Usuario usuario = new Usuario(cadastro.nome,
                    cadastro.email,
                    cadastro.matricula,
                    cadastro.telefone,
                    cadastro.senha,
                    cadastro.rua,
                    cadastro.bairro,
                    cadastro.quantidadeDeVagas);
            Application.getInstance().cadastrarUsuario(usuario);
            Calendar horaFinal = Calendar.getInstance();
            flash("success", "Cadastrado com sucesso");
            Logger.info("Usuário " + usuario.getEmail() + " cadastrado em " +
                    (horaFinal.getTimeInMillis() - horaInicial.getTimeInMillis()) + " ms");
            return redirect("/login");
        } else {
            flash("error", "Houve algum problema no cadastro.");
            Logger.error("Erro no Cadastro");
            return redirect("/cadastro");
        }
    }
}
