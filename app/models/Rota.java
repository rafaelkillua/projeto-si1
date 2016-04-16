package models;

/**
 * Created by Aillkeen on 16/04/2016.
 */
public class Rota {

    Endereco partida;
    Endereco destino;

    public Rota(Endereco partida, Endereco destino) {

        this.partida = partida;
        this.destino = destino;

    }

    public Endereco getPartida() {
        return partida;
    }

    public void setPartida(Endereco partida) {
        this.partida = partida;
    }

    public Endereco getDestino() {
        return destino;
    }

    public void setDestino(Endereco destino) {
        this.destino = destino;
    }
}
