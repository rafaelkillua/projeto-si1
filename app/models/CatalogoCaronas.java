package models;

import play.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aillkeen on 16/04/2016.
 */
public class CatalogoCaronas {

    private List<Carona> catalogoCaronas;

    public CatalogoCaronas() {
        catalogoCaronas = new ArrayList<>();
    }

    public void adicionarCaronas(Carona carona){
        catalogoCaronas.add(carona);
        Logger.info("Carona criada indo de " + carona.getRota().getEnderecoPartida().getBairro() +
                " para " + carona.getRota().getEnderecoDestino().getBairro() +
                " criada por " + carona.getEmailMotorista());
    }

    public List<Carona> pesquisaCaronas(String hora, String bairro){

        List<Carona> resultadoPesquisa = new ArrayList<>();

        for (Carona carona: catalogoCaronas) {

            if(carona.getHora().equals(hora) && (carona.getRota().getEnderecoDestino().getBairro().equals(bairro))) {
                resultadoPesquisa.add(carona);
            }
        }
        Logger.info("Pesquisa feita para Hora: "+ hora + " E" + " Bairro: " + bairro);
        return resultadoPesquisa;

    }

    public int quantidadeDeCaronas() {
        return catalogoCaronas.size();
    }


}
