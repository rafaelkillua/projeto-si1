package models;

import com.avaje.ebean.Model;

import javax.persistence.*;

/**
 * Created by Rafael on 18/05/2016.
 */

@Entity
public class Solicitacao extends Model {

    @Id @GeneratedValue
    private Long id;
    @ManyToOne
    private Carona caronaSolicitada;
    @ManyToOne
    private Usuario usuarioSolicitando;

    public Solicitacao(Carona caronaSolicitada, Usuario usuarioSolicitando) {
        this.caronaSolicitada = caronaSolicitada;
        this.usuarioSolicitando = usuarioSolicitando;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuarioSolicitando() {
        return usuarioSolicitando;
    }

    public void setUsuarioSolicitando(Usuario usuarioSolicitando) {
        this.usuarioSolicitando = usuarioSolicitando;
    }

    public Carona getCaronaSolicitada() {
        return caronaSolicitada;
    }

    public void setCaronaSolicitada(Carona caronaSolicitada) {
        this.caronaSolicitada = caronaSolicitada;
    }

    @Override
    public String toString() {
        return "Solicitacao{" +
                "id=" + id +
                ", caronaSolicitada=" + caronaSolicitada +
                ", usuarioSolicitando=" + usuarioSolicitando +
                '}';
    }
}
