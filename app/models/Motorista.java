package models;

/**
 * Created by JeffersonC on 22/03/2016.
 */
public class Motorista extends Pessoa {
    private int qtdVagas;

    public Motorista(String nome, String email, String matricula, String telefone, String senha, int qtdVagas){
        super(nome, email, matricula, telefone, senha);
        this.qtdVagas = qtdVagas;
    }

    public int getQtdPassageiros(){
        return qtdPassageiros;
    }
}
