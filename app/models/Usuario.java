package models;

import com.avaje.ebean.Model;

import javax.persistence.*;
import java.util.*;

@Entity
public class Usuario extends Model {

    public static Model.Finder<Long, Usuario> find = new Model.Finder<>(Usuario.class);

    @Id @GeneratedValue private Long id;
    private String nome;
    private String email;
    private String matricula;
    private String telefone;
    private String senha;
    private int quantidadeDeVagas;
    @Embedded private Endereco endereco;
    @Transient private List<Carona> pesquisasDoUsuario;

    @ManyToMany (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "solicitacoes_recebidas",
            joinColumns = @JoinColumn (name = "id_usuario"),
            inverseJoinColumns = @JoinColumn (name = "id_carona"))
    private List<Carona> solicitacoesRecebidas;

    public Usuario(String nome, String email, String matricula, String telefone, String senha, String rua, String bairro, int quantidadeDeVagas) {
        solicitacoesRecebidas = new ArrayList<>();
        pesquisasDoUsuario = new ArrayList<>();
        setNome(nome);
        setEmail(email);
        setMatricula(matricula);
        setTelefone(telefone);
        setSenha(senha);
        setEnderecoString(rua, bairro);
        setQuantidadeDeVagas(quantidadeDeVagas);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getQuantidadeDeVagas() {
        return quantidadeDeVagas;
    }

    public void setQuantidadeDeVagas(int quantidadeDeVagas) {
        this.quantidadeDeVagas = quantidadeDeVagas;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void setEnderecoString(String rua, String bairro) {
        this.endereco = new Endereco(rua, bairro);
    }

    public List<Carona> getPesquisasDoUsuario() {
        return pesquisasDoUsuario;
    }

    public void setPesquisasDoUsuario(List<Carona> pesquisasDoUsuario) {
        this.pesquisasDoUsuario = pesquisasDoUsuario;
    }

    public List<Carona> getSolicitacoesRecebidas() {
        return solicitacoesRecebidas;
    }

    public void setSolicitacoesRecebidas(List<Carona> solicitacoesRecebidas) {
        this.solicitacoesRecebidas = solicitacoesRecebidas;
    }

    public Carona getCaronaPorPosicao(int pos) {
        return solicitacoesRecebidas.get(pos);
    }

    public void validaSenha(String senha) throws Exception {
        if (!getSenha().equals(senha)) {
            throw new Exception("E-mail ou senha* não conferem");
        }
    }

    public void solicitar(Carona carona) {
        solicitacoesRecebidas.add(carona);
    }

    public void removerSolicitacao(Carona carona) {
        solicitacoesRecebidas.remove(carona);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", matricula='" + matricula + '\'' +
                ", telefone='" + telefone + '\'' +
                ", senha='" + senha + '\'' +
                ", quantidadeDeVagas=" + quantidadeDeVagas +
                ", endereco=" + endereco +
                ", pesquisasDoUsuario=" + pesquisasDoUsuario +
                ", solicitacoesRecebidas=" + solicitacoesRecebidas +
                '}';
    }
}
