package br.com.ciadeideias.smartenem.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ClaudioSouza on 04/10/2016.
 */
public class Dica implements Parcelable {

    public Dica() { }

    private int idDica;
    private String tituloDica;
    private String textoDica;
    private int qtdApres;
    private String dataApres;
    private String descri;

    public int getIdDica() {
        return idDica;
    }

    public void setIdDica(int idDica) {
        this.idDica = idDica;
    }

    public String getTituloDica() {
        return tituloDica;
    }

    public void setTituloDica(String tituloDica) {
        this.tituloDica = tituloDica;
    }

    public String getTextoDica() {
        return textoDica;
    }

    public void setTextoDica(String textoDica) {
        this.textoDica = textoDica;
    }

    public int getQtdApres() {
        return qtdApres;
    }

    public void setQtdApres(int qtdApres) {
        this.qtdApres = qtdApres;
    }

    public String getDataApres() {
        return dataApres;
    }

    public void setDataApres(String dataApres) {
        this.dataApres = dataApres;
    }

    public String getDescri() {
        return descri;
    }

    public void setDescri(String descri) {
        this.descri = descri;
    }

    protected Dica(Parcel in) {
        idDica = in.readInt();
        tituloDica = in.readString();
        textoDica = in.readString();
        qtdApres = in.readInt();
        dataApres = in.readString();
        descri = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(idDica);
        dest.writeString(tituloDica);
        dest.writeString(textoDica);
        dest.writeInt(qtdApres);
        dest.writeString(dataApres);
        dest.writeString(descri);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Dica> CREATOR = new Parcelable.Creator<Dica>() {
        @Override
        public Dica createFromParcel(Parcel in) {
            return new Dica(in);
        }

        @Override
        public Dica[] newArray(int size) {
            return new Dica[size];
        }
    };
}
