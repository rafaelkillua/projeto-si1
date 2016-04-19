package models.formularios;

/**
 * Created by Rafael on 21/03/2016.
 */

public class FormularioCarona {
    public String tipo;
    public String horaPartida;
    public String ruaPartida;
    public String bairroPartida;
    public String horaRetorno;
    public String ruaRetorno;
    public String bairroRetorno;
    public int vagas;

    @Override
    public String toString() {
        return "FormularioCarona{" +
                "tipo='" + tipo + '\'' +
                ", horaPartida='" + horaPartida + '\'' +
                ", ruaPartida='" + ruaPartida + '\'' +
                ", bairroPartida='" + bairroPartida + '\'' +
                ", horaRetorno='" + horaRetorno + '\'' +
                ", ruaRetorno='" + ruaRetorno + '\'' +
                ", bairroRetorno='" + bairroRetorno + '\'' +
                ", vagas=" + vagas +
                '}';
    }
}