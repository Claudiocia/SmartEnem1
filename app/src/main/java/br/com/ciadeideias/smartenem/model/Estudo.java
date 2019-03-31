package br.com.ciadeideias.smartenem.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Estudo implements Parcelable {
    private int idEstudo;
    private String disciplinaNome;
    private String dataRealiz;
    private int qtdQuest;
    private int respCerta;
    private int respErrada;
    private String horaInicio;
    private String tempAtivo;

    public Estudo() {
    }

    public int getIdEstudo() {
        return idEstudo;
    }

    public void setIdEstudo(int idEstudo) {
        this.idEstudo = idEstudo;
    }

    public String getDisciplinaNome() {
        return disciplinaNome;
    }

    public void setDisciplinaNome(String disciplinaNome) {
        this.disciplinaNome = disciplinaNome;
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

    public String getHoraInicio() { return horaInicio; }

    public void setHoraInicio(String horaInicio) { this.horaInicio = horaInicio; }

    public String getTempAtivo() {
        return tempAtivo;
    }

    public void setTempAtivo(String tempAtivo) {
        this.tempAtivo = tempAtivo;
    }

    protected Estudo(Parcel in) {
        idEstudo = in.readInt();
        disciplinaNome = in.readString();
        dataRealiz = in.readString();
        qtdQuest = in.readInt();
        respCerta = in.readInt();
        respErrada = in.readInt();
        horaInicio = in.readString();
        tempAtivo = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(idEstudo);
        dest.writeString(disciplinaNome);
        dest.writeString(dataRealiz);
        dest.writeInt(qtdQuest);
        dest.writeInt(respCerta);
        dest.writeInt(respErrada);
        dest.writeString(horaInicio);
        dest.writeString(tempAtivo);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Estudo> CREATOR = new Parcelable.Creator<Estudo>() {
        @Override
        public Estudo createFromParcel(Parcel in) {
            return new Estudo(in);
        }

        @Override
        public Estudo[] newArray(int size) {
            return new Estudo[size];
        }
    };
}
