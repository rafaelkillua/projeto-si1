package models.formularios;

import play.Logger;
import play.i18n.Messages;

/**
 * Created by Rafael on 20/03/2016.
 */
public class FormularioCadastro {
    public String nome;
    public String email;
    public String matricula;
    public String telefone;
    public String senha;
    public String confirmaSenha;
    public String rua;
    public String bairro;
    public int quantidadeDeVagas;

    public FormularioCadastro(){
    }

    public String validate() {
        if(!senha.equals(confirmaSenha)) {
            Logger.error("Senhas não conferem");
            return Messages.get("error.mismatchPasswords");
        }
        return null;
    }
}
