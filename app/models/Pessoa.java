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
    private Endereco endereco;

    public Pessoa(String nome, String email, String matricula, String telefone, String senha, String rua, String bairro){
        this.nome = nome;
        this.email = email;
        this.matricula = matricula;
        this.telefone = telefone;
        this.senha = senha;
        endereco = new Endereco(rua, bairro);
    }

    public String getNome(){ return nome;}

    public String getEmail() { return email;}

    public String getTelefone() {
        return telefone;
    }

    public String getMatricula() {
        return matricula;
    }

    public Endereco getEndereco(){return endereco;}

}
