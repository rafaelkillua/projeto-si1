package models;

import java.util.ArrayList;
import models.Caronas;

/**
 * Created by Aillkeen on 16/04/2016.
 */
public class CatalogoCaronas {

    private ArrayList<Caronas> catalogoCaronas = new ArrayList<>();

    public CatalogoCaronas() {
    }

    public void adicionarCaronas(Caronas carona){

        catalogoCaronas.add(carona);
    }

    public ArrayList<Caronas> pesquisaCaronas(String dia, String hora, String bairro, String rua){

        ArrayList<Caronas> resultadoPesquisa = new ArrayList<>();

        for (Caronas carona: catalogoCaronas) {

            if((carona.getRua().equals(rua)) && (carona.getBairro().equals(bairro))) {
                resultadoPesquisa.add(carona);
            }
        }

        return resultadoPesquisa;

    }


}
