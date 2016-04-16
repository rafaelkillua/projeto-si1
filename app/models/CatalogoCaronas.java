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

    public ArrayList<Carona> pesquisaCaronas(String dia, String hora, String bairro, String rua){

        ArrayList<Carona> resultadoPesquisa = new ArrayList<>();

        for (Carona carona: catalogoCaronas) {

            if((carona.getRua().equals(rua)) && (carona.getBairro().equals(bairro))) {
                resultadoPesquisa.add(carona);
            }
        }

        return resultadoPesquisa;

    }


}
