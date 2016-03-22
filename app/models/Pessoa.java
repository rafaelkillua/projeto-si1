package models;

/**
 * Created by JeffersonC on 22/03/2016.
 */
public abstract class Pessoa {
    private String nome;
    private String email;
    private String matricula;
    private String telefone;
    private String senha;
    private String rua;
    private String bairro;

    public String getNome(){ return nome;}

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getEndereco(){
        return "Rua: " + rua + "\n" + "Bairro: " + bairro;
    }
}
