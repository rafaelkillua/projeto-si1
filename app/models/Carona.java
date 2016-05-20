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
    @OneToOne (fetch = FetchType.LAZY) private Rota rota;
    @ManyToOne (fetch = FetchType.LAZY) private Usuario motorista;
    private String hora;
    private int vagasDisponiveis;
    private int vagasAtuais;
    private TipoCarona tipo;

    @ManyToMany (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
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
        this.vagasAtuais = vagasDisponiveis;
        this.tipo = tipo;
    }

    public boolean isIda() {
        return getTipo() == TipoCarona.IDA;
    }

    public boolean isVolta() {
        return getTipo() == TipoCarona.VOLTA;
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

    public void setId(Long id) {
        this.id = id;
    }

    public Rota getRota() {
        return rota;
    }

    public void setRota(Rota rota) {
        this.rota = rota;
    }

    public Usuario getMotorista() {
        return motorista;
    }

    public void setMotorista(Usuario motorista) {
        this.motorista = motorista;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getVagasDisponiveis() {
        return vagasDisponiveis;
    }

    public void setVagasDisponiveis(int vagasDisponiveis) {
        this.vagasDisponiveis = vagasDisponiveis;
    }

    public int getVagasAtuais() {
        return vagasAtuais;
    }

    public void setVagasAtuais(int vagasAtuais) {
        this.vagasAtuais = vagasAtuais;
    }

    public TipoCarona getTipo() {
        return tipo;
    }

    public void setTipo(TipoCarona tipo) {
        this.tipo = tipo;
    }

    public List<Usuario> getPassageiros() {
        return passageiros;
    }

    public void setPassageiros(List<Usuario> passageiros) {
        this.passageiros = passageiros;
    }

    public void adicionarPassageiro(Usuario passageiro){
        passageiros.add(passageiro);
        vagasAtuais--;
        update();
    }

    public void removerPassageiro(String passageiro){
        passageiros.remove(passageiro);
        vagasAtuais++;
        update();
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