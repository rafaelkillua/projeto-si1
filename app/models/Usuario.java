package models;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nome;
    private String email;
    private String matricula;
    private String telefone;
    private String senha;
    private Endereco endereco;
    private int quantidadeDeVagas;
    private List<Integer> solicitacoesEnviadas = new ArrayList<>();
    private List<Integer> solicitacoesRecebidas = new ArrayList<>();

    public Usuario(String nome, String email, String matricula, String telefone, String senha, String rua, String bairro, int quantidadeDeVagas){
        setNome(nome);
        setEmail(email);
        setMatricula(matricula);
        setTelefone(telefone);
        setSenha(senha);
        setEndereco(rua, bairro);
        setQuantidadeDeVagas(quantidadeDeVagas);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(String rua, String bairro) {
        this.endereco = new Endereco(rua, bairro);
    }

    public int getQuantidadeDeVagas() {
        return quantidadeDeVagas;
    }

    public void setQuantidadeDeVagas(int quantidadeDeVagas) {
        this.quantidadeDeVagas = quantidadeDeVagas;
    }

    public List<Integer> getSolicitacoesEnviadas() {
        return solicitacoesEnviadas;
    }

    public List<Integer> getSolicitacoesRecebidas() {
        return solicitacoesRecebidas;
    }

    public void validaSenha(String senha) throws Exception {
        if (!getSenha().equals(senha)) {
            throw new Exception("E-mail ou senha* não conferem");
        }
    }
}
