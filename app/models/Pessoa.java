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

    public Pessoa(String nome, String email, String matricula, String telefone, String senha){
        this.nome = nome;
        this.email = email;
        this.matricula = matricula;
        this.telefone = telefone;
        this.senha = senha;
    }

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

}
