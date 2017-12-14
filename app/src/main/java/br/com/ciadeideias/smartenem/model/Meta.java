package br.com.ciadeideias.smartenem.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ClaudioSouza on 02/11/2016.
 */
public class Meta implements Parcelable {
    private int idMeta;
    private String nomeMeta;
    private int valorMeta;
    private int valorExec;
    private String desempPerc;
    private String nivelDedic;

    public Meta(){}

    public int getIdMeta() {
        return idMeta;
    }

    public void setIdMeta(int idMeta) {
        this.idMeta = idMeta;
    }

    public String getNomeMeta() {
        return nomeMeta;
    }

    public void setNomeMeta(String nomeMeta) {
        this.nomeMeta = nomeMeta;
    }

    public int getValorMeta() {
        return valorMeta;
    }

    public void setValorMeta(int valorMeta) {
        this.valorMeta = valorMeta;
    }

    public int getValorExec() {
        return valorExec;
    }

    public void setValorExec(int valorExec) {
        this.valorExec = valorExec;
    }

    public String getDesempPerc() {
        return desempPerc;
    }

    public void setDesempPerc(String desempPerc) {
        this.desempPerc = desempPerc;
    }

    public String getNivelDedic() {
        return nivelDedic;
    }

    public void setNivelDedic(String nivelDedic) {
        this.nivelDedic = nivelDedic;
    }

    protected Meta(Parcel in) {
        idMeta = in.readInt();
        nomeMeta = in.readString();
        valorMeta = in.readInt();
        valorExec = in.readInt();
        desempPerc = in.readString();
        nivelDedic = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(idMeta);
        dest.writeString(nomeMeta);
        dest.writeInt(valorMeta);
        dest.writeInt(valorExec);
        dest.writeString(desempPerc);
        dest.writeString(nivelDedic);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Meta> CREATOR = new Parcelable.Creator<Meta>() {
        @Override
        public Meta createFromParcel(Parcel in) {
            return new Meta(in);
        }

        @Override
        public Meta[] newArray(int size) {
            return new Meta[size];
        }
    };
}