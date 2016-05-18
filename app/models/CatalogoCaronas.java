package models;

import play.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aillkeen on 16/04/2016.
 */
public class CatalogoCaronas {

    private List<Carona> catalogoCaronas = new ArrayList<>();

    public CatalogoCaronas() {
        setCatalogoCaronas(Carona.find
                .fetch("rota").fetch("motorista").fetch("passageiros").fetch("motorista.solicitacoesRecebidas")
                .findList());
    }

    public void adicionarCaronas(Carona carona){
        carona.getRota().save();
        carona.save();
        catalogoCaronas.add(carona);
    }

    public List<Carona> pesquisaCaronas(String hora, String bairro, String tipo){

        List<Carona> resultadoPesquisa = new ArrayList<>();

        if (tipo.equals("ida")) {
            resultadoPesquisa = pesquisaCaronasIda(resultadoPesquisa, hora, bairro);
        } else if (tipo.equals("volta")) {
            resultadoPesquisa = pesquisaCaronasVolta(resultadoPesquisa, hora, bairro);
        }
        return resultadoPesquisa;
    }

    private List<Carona> pesquisaCaronasIda(List<Carona> caronas, String hora, String bairro) {
        for (Carona carona: catalogoCaronas) {
            if(carona.getTipo() == TipoCarona.IDA && carona.getHora().equals(hora) && (carona.getRota().getEnderecoPartida().getBairro().equalsIgnoreCase(bairro))
                    && carona.temVagaDisponivel()) {
                caronas.add(carona);
            }
        }
        return caronas;
    }

    private List<Carona> pesquisaCaronasVolta(List<Carona> caronas, String hora, String bairro) {
        for (Carona carona: catalogoCaronas) {
            if(carona.getTipo() == TipoCarona.VOLTA && carona.getHora().equals(hora) &&
                    (carona.getRota().getEnderecoDestino().getBairro().equalsIgnoreCase(bairro)) && carona.temVagaDisponivel()) {
                caronas.add(carona);
            }
        }
        return caronas;
    }

    public void setCatalogoCaronas(List<Carona> catalogoCaronas) {
        this.catalogoCaronas.addAll(catalogoCaronas);
    }

    public int quantidadeDeCaronas() {
        return catalogoCaronas.size();
    }

    public int pesquisaPosicaoCarona(Carona car) throws Exception {
        for (int i = 0; i < catalogoCaronas.size(); i++) {
            if (catalogoCaronas.get(i) == car) {
                return i;
            }
        }
        throw new Exception("Carona não encontrada");
    }

    @Override
    public String toString() {
        return "CatalogoCaronas{" +
                "catalogoCaronas=" + catalogoCaronas +
                '}';
    }

}
