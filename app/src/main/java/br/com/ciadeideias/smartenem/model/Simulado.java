package br.com.ciadeideias.smartenem.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ClaudioSouza on 04/10/2016.
 */
public class Simulado implements Parcelable {
    private int idUserSimulado;
    private int idSimulado;
    private String tipo;
    private String tempo;
    private String dataInicio;
    private String dataFim;
    private int acertosTotal;
    private int pontos;
    private String statusSimulado;
    private String filtroSimulado;

    public Simulado(){}

    public Simulado(Parcel in) {
        idUserSimulado = in.readInt();
        idSimulado = in.readInt();
        tipo = in.readString();
        tempo = in.readString();
        dataInicio = in.readString();
        dataFim = in.readString();
        acertosTotal = in.readInt();
        pontos = in.readInt();
        statusSimulado = in.readString();
        filtroSimulado = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(idUserSimulado);
        dest.writeInt(idSimulado);
        dest.writeString(tipo);
        dest.writeString(tempo);
        dest.writeString(dataInicio);
        dest.writeString(dataFim);
        dest.writeInt(acertosTotal);
        dest.writeInt(pontos);
        dest.writeString(statusSimulado);
        dest.writeString(filtroSimulado);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Simulado> CREATOR = new Parcelable.Creator<Simulado>() {
        @Override
        public Simulado createFromParcel(Parcel in) {
            return new Simulado(in);
        }

        @Override
        public Simulado[] newArray(int size) {
            return new Simulado[size];
        }
    };

    public int getIdUserSimulado() {
        return idUserSimulado;
    }

    public void setIdUserSimulado(int idUserSimulado) {
        this.idUserSimulado = idUserSimulado;
    }

    public int getIdSimulado() {
        return idSimulado;
    }

    public void setIdSimulado(int idSimulado) {
        this.idSimulado = idSimulado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTempo() {
        return tempo;
    }

    public void setTempo(String tempo) {
        this.tempo = tempo;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public int getAcertosTotal() {
        return acertosTotal;
    }

    public void setAcertosTotal(int acertosTotal) {
        this.acertosTotal = acertosTotal;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public String getStatusSimulado() {
        return statusSimulado;
    }

    public void setStatusSimulado(String statusSimulado) {
        this.statusSimulado = statusSimulado;
    }

    public String getFiltroSimulado() {
        return filtroSimulado;
    }

    public void setFiltroSimulado(String filtroSimulado) {
        this.filtroSimulado = filtroSimulado;
    }
}
