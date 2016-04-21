package models;

/**
 * Created by Aillkeen on 16/04/2016.
 */
public class Rota {

    private Endereco enderecoPartida;
    private Endereco enderecoDestino;

    public Rota(Endereco enderecoPartida, Endereco enderecoDestino) {
        this.enderecoPartida = enderecoPartida;
        this.enderecoDestino = enderecoDestino;
    }

    public Endereco getEnderecoPartida() {
        return enderecoPartida;
    }

    public void setEnderecoPartida(Endereco enderecoPartida) {
        this.enderecoPartida = enderecoPartida;
    }

    public Endereco getEnderecoDestino() {
        return enderecoDestino;
    }

    public void setEnderecoDestino(Endereco enderecoDestino) {
        this.enderecoDestino = enderecoDestino;
    }
}
