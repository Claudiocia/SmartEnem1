package br.com.ciadeideias.smartenem.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by ClaudioSouza on 07/11/2016.
 */
public class Grafico implements Parcelable  {
    private int idGrafico;
    private String areaNome;
    private String simulCompacArea;
    private String simulComple;
    private String dataRealiz;
    private int qtdQuest;
    private int respCerta;
    private int respErrada;
    private int ptsSimulCompac;
    private int ptsSimulComple;
    private int tempAtivo;

    public Grafico(){};

    public int getIdGrafico() {
        return idGrafico;
    }

    public void setIdGrafico(int idGrafico) {
        this.idGrafico = idGrafico;
    }

    public String getAreaNome() {
        return areaNome;
    }

    public void setAreaNome(String areaNome) {
        this.areaNome = areaNome;
    }

    public String getSimulCompacArea() {
        return simulCompacArea;
    }

    public void setSimulCompacArea(String simulCompacArea) {
        this.simulCompacArea = simulCompacArea;
    }

    public String getSimulComple() {
        return simulComple;
    }

    public void setSimulComple(String simulComple) {
        this.simulComple = simulComple;
    }

    public String getDataRealiz() {
        return dataRealiz;
    }

    public void setDataRealiz(String dataRealiz) {
        this.dataRealiz = dataRealiz;
    }

    public int getQtdQuest() {
        return qtdQuest;
    }

    public void setQtdQuest(int qtdQuest) {
        this.qtdQuest = qtdQuest;
    }

    public int getRespCerta() {
        return respCerta;
    }

    public void setRespCerta(int respCerta) {
        this.respCerta = respCerta;
    }

    public int getRespErrada() {
        return respErrada;
    }

    public void setRespErrada(int respErrada) {
        this.respErrada = respErrada;
    }

    public int getPtsSimulCompac() {
        return ptsSimulCompac;
    }

    public void setPtsSimulCompac(int ptsSimulCompac) {
        this.ptsSimulCompac = ptsSimulCompac;
    }

    public int getPtsSimulComple() {
        return ptsSimulComple;
    }

    public void setPtsSimulComple(int ptsSimulComple) {
        this.ptsSimulComple = ptsSimulComple;
    }

    public int getTempAtivo() {
        return tempAtivo;
    }

    public void setTempAtivo(int tempAtivo) {
        this.tempAtivo = tempAtivo;
    }

    public Grafico(Parcel in) {
        idGrafico = in.readInt();
        areaNome = in.readString();
        simulCompacArea = in.readString();
        simulComple = in.readString();
        dataRealiz = in.readString();
        qtdQuest = in.readInt();
        respCerta = in.readInt();
        respErrada = in.readInt();
        ptsSimulCompac = in.readInt();
        ptsSimulComple = in.readInt();
        tempAtivo = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(idGrafico);
        dest.writeString(areaNome);
        dest.writeString(simulCompacArea);
        dest.writeString(simulComple);
        dest.writeString(dataRealiz);
        dest.writeInt(qtdQuest);
        dest.writeInt(respCerta);
        dest.writeInt(respErrada);
        dest.writeInt(ptsSimulCompac);
        dest.writeInt(ptsSimulComple);
        dest.writeInt(tempAtivo);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Grafico> CREATOR = new Parcelable.Creator<Grafico>() {
        @Override
        public Grafico createFromParcel(Parcel in) {
            return new Grafico(in);
        }

        @Override
        public Grafico[] newArray(int size) {
            return new Grafico[size];
        }
    };

}
