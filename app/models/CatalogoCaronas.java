package models;

import java.util.ArrayList;

/**
 * Created by Aillkeen on 16/04/2016.
 */
public class CatalogoCaronas {

    private ArrayList<Carona> catalogoCaronas = new ArrayList<>();

    public CatalogoCaronas() {
    }

    public void adicionarCaronas(Carona carona){

        catalogoCaronas.add(carona);
    }

    public ArrayList<Carona> pesquisaCaronas(String hora, String rua, String bairro){

        ArrayList<Carona> resultadoPesquisa = new ArrayList<>();

        for (Carona carona: catalogoCaronas) {

            if((carona.getRota().getDestino().getRua().equals(rua)) && (carona.getRota().getDestino().getBairro().equals(bairro))) {
                resultadoPesquisa.add(carona);
            }
        }

        return resultadoPesquisa;

    }


}
