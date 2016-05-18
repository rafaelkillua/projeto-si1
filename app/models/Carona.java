package models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import com.avaje.ebean.Model;

/**
 * Created by Aillkeen on 16/04/2016.
 */

@Entity
public class Carona extends Model {

    public static Model.Finder<Long,Carona> find = new Model.Finder<>(Carona.class);

    @Id @GeneratedValue private Long id;
    @OneToOne private Rota rota;
    @OneToOne private Usuario motorista;
    private String hora;
    private int vagasDisponiveis;
    private TipoCarona tipo;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "carona_passageiros",
               joinColumns = @JoinColumn (name = "id_carona"),
               inverseJoinColumns = @JoinColumn (name = "id_passageiro"))
    private List<Usuario> passageiros;

    public Carona(String hora, Endereco partida, Endereco destino, Usuario motorista, int vagasDisponiveis, TipoCarona tipo) {
        this.hora = hora;
        rota = new Rota(partida, destino);
        this.motorista = motorista;
        passageiros = new ArrayList<>();
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

    public Long getId() {
        return id;
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

    public List<Usuario> getPassageiros() {
        return passageiros;
    }

    public void setPassageiros(ArrayList<Usuario> passageiros) {
        this.passageiros = passageiros;
    }

    public void adicionarPassageiro(Usuario passageiro){
        passageiros.add(passageiro);
        vagasDisponiveis--;
    }

    public void removerPassageiro(String passageiro){
        passageiros.remove(passageiro);
        vagasDisponiveis++;
    }

    @Override
    public String toString() {
        return "Carona{" +
                "id=" + id +
                ", rota=" + rota +
                ", motorista=" + motorista +
                ", hora='" + hora + '\'' +
                ", vagasDisponiveis=" + vagasDisponiveis +
                ", tipo=" + tipo +
                ", passageiros=" + passageiros +
                '}';
    }
}