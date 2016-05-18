package models;

import javax.persistence.Basic;
import javax.persistence.Embeddable;

/**
 * Created by JeffersonC on 22/03/2016.
 */
@Embeddable
public class Endereco {
    @Basic
    private String rua;
    @Basic
    private String bairro;

    public Endereco(String rua, String bairro){
        this.rua = rua;
        this.bairro = bairro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "rua='" + rua + '\'' +
                ", bairro='" + bairro + '\'' +
                '}';
    }
}
