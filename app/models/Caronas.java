package models;

/**
 * Created by Aillkeen on 16/04/2016.
 */
public class Caronas {

    private String rua;
    private String bairro;
    private String hora;
    private String data;

    public Caronas(String rua, String bairro, String hora, String data){

        this.rua = rua;
        this.bairro = bairro;
        this.hora = hora;
        this.data = data;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getBairro() {
        return bairro;
    }

    public String getHora() {
        return hora;
    }

    public String getData() {
        return data;
    }

    public String getRua() {

        return rua;
    }
}
