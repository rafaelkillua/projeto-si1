package controllers;

import models.formularios.FormularioCadastro;
import models.Usuario;
import play.data.Form;
import play.Logger;
import play.mvc.Controller;
import play.mvc.Result;

public class CadastroController extends Controller {

    public Result cadastrar() {
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
            return redirect("/");
        } else {
            Logger.error("Erro no Cadastro");
            return redirect("/");
        }
    }
}
