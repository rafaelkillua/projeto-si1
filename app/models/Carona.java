package models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aillkeen on 16/04/2016.
 */
public class Carona {

    private String hora;
    private Rota rota;
    private int vagasDisponiveis;
    private String emailMotorista;
    private List<String> emailPassageiros;

    public Carona(String hora, Endereco partida, Endereco destino, String emailMotorista, int vagasDisponiveis) {

        this.hora = hora;
        rota = new Rota(partida, destino);
        this.emailMotorista = emailMotorista;
        emailPassageiros = new ArrayList<>();
        this.vagasDisponiveis = vagasDisponiveis;
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

    public String getEmailMotorista() {
        return emailMotorista;
    }

    public void setEmailMotorista(String emailMotorista) {
        this.emailMotorista = emailMotorista;
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