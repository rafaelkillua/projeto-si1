package models;

import com.avaje.ebean.Model;

import javax.persistence.*;

/**
 * Created by Aillkeen on 16/04/2016.
 */
@Entity
public class Rota extends Model {

    public static Model.Finder<Long,Rota> find = new Model.Finder<>(Rota.class);

    @Id @GeneratedValue
    private Long id;

    @AttributeOverrides({
            @AttributeOverride(name = "rua", column = @Column(name = "ruaPartida")),
            @AttributeOverride(name = "bairro", column = @Column(name = "bairroPartida"))
    })
    @Embedded
    private Endereco enderecoPartida;
    @AttributeOverrides({
            @AttributeOverride(name = "rua", column = @Column(name = "ruaDestino")),
            @AttributeOverride(name = "bairro", column = @Column(name = "bairroDestino"))
    })
    @Embedded
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

    @Override
    public String toString() {
        return "Rota{" +
                "id=" + id +
                ", enderecoPartida=" + enderecoPartida +
                ", enderecoDestino=" + enderecoDestino +
                '}';
    }
}
