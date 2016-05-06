package models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import play.data.validation.Constraints;
import com.avaje.ebean.Model;

/**
 * Created by Aillkeen on 16/04/2016.
 */

@Entity
public class Carona extends Model {

    private static final long serialVersionUID = 1L;

    @Id
    public Long id;

    @Constraints.Required
    public String nome;

    public static Model.Finder<Long,Carona> find = new Model.Finder<Long,Carona>(Carona.class);

    private String hora;
    private Rota rota;
    private int vagasDisponiveis;
    private Usuario motorista;
    private List<String> emailPassageiros;
    private TipoCarona tipo;

    public Carona(String hora, Endereco partida, Endereco destino, Usuario motorista, int vagasDisponiveis, TipoCarona tipo) {
        this.hora = hora;
        rota = new Rota(partida, destino);
        this.motorista = motorista;
        emailPassageiros = new ArrayList<>();
        this.vagasDisponiveis = vagasDisponiveis;
        this.tipo = tipo;
    }

    public TipoCarona getTipoCarona() {
        return this.tipo;
    }

    public boolean isIda() {
        return getTipoCarona() == TipoCarona.IDA;
    }

    public boolean isVolta() {
        return getTipoCarona() == TipoCarona.VOLTA;
    }

    public String getTipoString() {
        if (isIda()) {
            return "Ida para UFCG";
        } else {
            return "Volta da UFCG";
        }
    }

    public boolean temVagaDisponivel() {
        return getVagasDisponiveis() > 0;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Rota getRota() {
        return rota;
    }

    public void setRota(Rota rota) {
        this.rota = rota;
    }

    public int getVagasDisponiveis() {
        return vagasDisponiveis;
    }

    public void setVagasDisponiveis(int vagasDisponiveis) {
        this.vagasDisponiveis = vagasDisponiveis;
    }

    public Usuario getMotorista() {
        return motorista;
    }

    public void setMotorista(Usuario novoMotorista) {
        this.motorista = novoMotorista;
    }

    public List<String> getEmailPassageiros() {
        return emailPassageiros;
    }

    public void setEmailPassageiros(ArrayList<String> emailPassageiros) {
        this.emailPassageiros = emailPassageiros;
    }

    public void adicionarPassageiro(String passageiro){

        emailPassageiros.add(passageiro);
    }

    public void removerPassageiro(String passageiro){

        emailPassageiros.remove(passageiro);
    }
}