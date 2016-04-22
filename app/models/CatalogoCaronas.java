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
    }

    public List<Carona> pesquisaCaronas(String hora, String bairro){

        List<Carona> resultadoPesquisa = new ArrayList<>();

        for (Carona carona: catalogoCaronas) {

            if((carona.getVagasDisponiveis() > 0)  && (carona.getHora().equals(hora) || (carona.getRota().getEnderecoPartida().getBairro().equalsIgnoreCase(bairro)))) {
                resultadoPesquisa.add(carona);
            }
        }
        return resultadoPesquisa;

    }

    public int quantidadeDeCaronas() {
        return catalogoCaronas.size();
    }


}
