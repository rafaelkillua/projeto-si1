package controllers;

import models.*;
import models.formularios.FormularioCarona;
import models.formularios.FormularioPesquisa;
import play.Logger;
import play.data.Form;
import play.i18n.Messages;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Rafael on 18/04/2016.
 */
public class CaronaController extends Controller {

    private final Endereco UFCG = new Endereco("UFCG", "Bodocongó");


    public Result criarCarona() {
        Calendar horaInicial = Calendar.getInstance();
        Calendar horaFinal;
        Form<FormularioCarona> formularioCarona = Application.getInstance().getFormCarona().bindFromRequest();
        if (!formularioCarona.hasErrors()) {
            FormularioCarona formCarona = formularioCarona.get();
            if (formCarona.tipo.equals("ida")) {
                try {
                    Application.getCatalogoCaronas().adicionarCaronas(criarCaronaIda(formCarona));
                    horaFinal = Calendar.getInstance();
                    Logger.info("Carona do tipo Ida criada em " + (horaFinal.getTimeInMillis() - horaInicial.getTimeInMillis()) + " ms");
                } catch (Exception e) {
                    Logger.error("Excecao ao criar carona de Ida - " + e.getMessage());
                    e.printStackTrace();
                }
            } else if (formCarona.tipo.equals("volta")) {
                try {
                    Application.getCatalogoCaronas().adicionarCaronas(criarCaronaVolta(formCarona));
                    horaFinal = Calendar.getInstance();
                    Logger.info("Carona do tipo Volta criada em " + (horaFinal.getTimeInMillis() - horaInicial.getTimeInMillis()) + " ms");
                } catch (Exception e) {
                    Logger.error("Excecao ao criar carona de Volta", e.getMessage());
                }
            } else if (formCarona.tipo.equals("idaVolta")) {
                try {
                    Application.getCatalogoCaronas().adicionarCaronas(criarCaronaIda(formCarona));
                    Application.getCatalogoCaronas().adicionarCaronas(criarCaronaVolta(formCarona));
                    horaFinal = Calendar.getInstance();
                    Logger.info("Carona do tipo IdaVolta criada em " + (horaFinal.getTimeInMillis() - horaInicial.getTimeInMillis()) + " ms");
                } catch (Exception e) {
                    Logger.error("Excecao ao criar carona de IdaVolta", e.getMessage());
                }
            } else {
                Logger.error("Erro no tipo de carona no formulario de criar carona");
            }

            return redirect("/");
        } else {
            Logger.error("Erro no formulario de criar carona");
            return redirect("/");
        }
    }

    public Result pesquisaCarona(){
        Calendar horaInicial = Calendar.getInstance();
        Calendar horaFinal;

        List<Carona> resultadoPesquisa = new ArrayList<>();

        Form<FormularioPesquisa> formularioPesquisa = Application.getInstance().getFormPesquisa().bindFromRequest();

        try {
            Usuario usuario = Application.getInstance().getUsuarioLogado();

            if(!formularioPesquisa.hasErrors()){
                FormularioPesquisa formPesquisa =  formularioPesquisa.get();
                if (formPesquisa.tipo.equals("ida")) {
                    resultadoPesquisa = Application.getCatalogoCaronas().pesquisaCaronas(formPesquisa.hora, formPesquisa.bairroPartida, formPesquisa.tipo);
                } else if (formPesquisa.tipo.equals("volta")) {
                    resultadoPesquisa = Application.getCatalogoCaronas().pesquisaCaronas(formPesquisa.hora, formPesquisa.bairroRetorno, formPesquisa.tipo);
                }

                usuario.setPesquisasDoUsuario(resultadoPesquisa);
                horaFinal = Calendar.getInstance();
                Logger.info("Pesquisa de carona feita pelo usuario " + usuario.getEmail() + " em " + (horaFinal.getTimeInMillis() - horaInicial.getTimeInMillis()) + " ms");

            } else {
                Logger.error("Erro no formulario de pesquisar carona");
            }
        } catch (Exception e) {
            Logger.error("Excecao ao Pesquisar Carona", e.getMessage());
        }

        return redirect("/resultadoPesquisa/1");
    }

    public Result solicitar(Integer posicaoCaronaPesquisas) {
        try {
            Usuario usuarioSolicitando = Application.getInstance().getUsuarioLogado();
            Carona carona = Application.getInstance().getUsuarioLogado().getPesquisasDoUsuario().get(posicaoCaronaPesquisas);
            carona.getMotorista().solicitar(carona, usuarioSolicitando);
            flash("success", Messages.get("success.requestRide"));
            Logger.info(usuarioSolicitando.getEmail() + " solicitou carona de " + carona.getMotorista().getEmail());
        } catch (Exception e) {
            flash("error", Messages.get("error.requestRide") + " - " + e.getMessage());
        }
        return redirect("/resultadoPesquisa/1");
    }

    public Result aceitarSolicitacao (Integer posicaoCaronaSolicitacoes) {
        try {
            Solicitacao solicitacao = Application.getInstance().getUsuarioLogado().getSolicitacoesRecebidas().get(posicaoCaronaSolicitacoes);
            solicitacao.getCaronaSolicitada().getMotorista().aceitarSolicitacao(solicitacao);
            flash("success", Messages.get("success.acceptRequest"));
            Logger.info(solicitacao.getCaronaSolicitada().getMotorista().getEmail() + " aceitou solicitação de carona de " + solicitacao.getUsuarioSolicitando().getEmail());
        } catch (Exception e) {
            flash("error", Messages.get("error.acceptRequest") + " - " + e.getMessage());
            e.printStackTrace();
        }
        return redirect("/solicitacoes/1");
    }

    public Result recusarSolicitacao (Integer posicaoCaronaSolicitacoes) {
        try {
            Solicitacao solicitacao = Application.getInstance().getUsuarioLogado().getSolicitacoesRecebidas().get(posicaoCaronaSolicitacoes);
            solicitacao.getCaronaSolicitada().getMotorista().removerSolicitacao(solicitacao);
            flash("success", Messages.get("success.refuseRequest"));
            Logger.info(solicitacao.getCaronaSolicitada().getMotorista().getEmail() + " recusou solicitação de carona de " + solicitacao.getUsuarioSolicitando().getEmail());
        } catch (Exception e) {
            flash("error", Messages.get("error.refuseRequest") + " - " + e.getMessage());
            e.printStackTrace();
        }
        return redirect("/solicitacoes/1");
    }

    private Carona criarCaronaIda(FormularioCarona formCarona) throws Exception {
        return new Carona(formCarona.horaPartida,
                new Endereco(formCarona.ruaPartida, formCarona.bairroPartida),
                UFCG,
                Application.getInstance().getUsuarioLogado(),
                formCarona.vagas, TipoCarona.IDA);
    }

    private Carona criarCaronaVolta(FormularioCarona formCarona) throws Exception {
        return new Carona(formCarona.horaRetorno,
                UFCG,
                new Endereco(formCarona.ruaRetorno, formCarona.bairroRetorno),
                Application.getInstance().getUsuarioLogado(),
                formCarona.vagas, TipoCarona.VOLTA);
    }
}
