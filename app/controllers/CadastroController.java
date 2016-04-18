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
            Logger.info(cadastro.email + " " + cadastro.senha + " " + cadastro.quantidadeDeVagas);
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
            Logger.error("Não deu");
            return redirect("/");
        }
    }
}
