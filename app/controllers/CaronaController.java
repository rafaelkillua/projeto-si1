package controllers;

import models.Carona;
import models.Endereco;
import models.Usuario;
import models.formularios.FormularioCarona;
import models.formularios.FormularioPesquisa;
import play.Logger;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rafael on 18/04/2016.
 */
public class CaronaController extends Controller {

    private final Endereco UFCG = new Endereco("UFCG", "Bodocongó");


    public Result criarCarona() {

        Form<FormularioCarona> formularioCarona = Application.getInstance().getFormCarona().bindFromRequest();
        if (!formularioCarona.hasErrors()) {
            FormularioCarona formCarona = formularioCarona.get();
            if (formCarona.tipo.equals("ida")) {
                try {
                    Application.getCatalogoCaronas().adicionarCaronas(criarCaronaIda(formCarona));
                } catch (Exception e) {
                    Logger.error(e.getMessage());
                }
            } else if (formCarona.tipo.equals("volta")) {
                try {
                    Application.getCatalogoCaronas().adicionarCaronas(criarCaronaVolta(formCarona));
                } catch (Exception e) {
                    Logger.error(e.getMessage());
                }
            } else if (formCarona.tipo.equals("idaVolta")) {
                try {
                    Application.getCatalogoCaronas().adicionarCaronas(criarCaronaIda(formCarona));
                    Application.getCatalogoCaronas().adicionarCaronas(criarCaronaVolta(formCarona));
                } catch (Exception e) {
                    Logger.error(e.getMessage());
                }
            } else {
                Logger.error("WTF ACONTECEU - BUG ESCROTO");
            }

            return redirect("/");
        } else {
            Logger.error("Erro de formulário de carona");
            return redirect("/");
        }
    }

    public Result pesquisaCarona(){

        List<Carona> resultadoPesquisa = new ArrayList<>();

        Form<FormularioPesquisa> formularioPesquisa = Application.getInstance().getFormPesquisa().bindFromRequest();

        try {
            Usuario usuario = Application.getInstance().getUsuarioLogado();

            if(!formularioPesquisa.hasErrors()){

                FormularioPesquisa formPesquisa =  formularioPesquisa.get();
                resultadoPesquisa = Application.getCatalogoCaronas().pesquisaCaronas(formPesquisa.hora, formPesquisa.bairro);

                usuario.setPesquisasDoUsuario(resultadoPesquisa);

            } else {
                Logger.error("ERRO AO PESQUISAR");
            }
        } catch (Exception e) {
            Logger.error(e.getMessage());
        }

        return redirect("/resultadoPesquisa");
    }
    private Carona criarCaronaIda(FormularioCarona formCarona) throws Exception {
        return new Carona(formCarona.horaPartida,
                new Endereco(formCarona.ruaPartida, formCarona.bairroPartida),
                UFCG,
                Application.getInstance().getUsuarioLogado(),
                formCarona.vagas);
    }

    private Carona criarCaronaVolta(FormularioCarona formCarona) throws Exception {
        return new Carona(formCarona.horaRetorno,
                UFCG,
                new Endereco(formCarona.ruaRetorno, formCarona.bairroRetorno),
                Application.getInstance().getUsuarioLogado(),
                formCarona.vagas);
    }
}
