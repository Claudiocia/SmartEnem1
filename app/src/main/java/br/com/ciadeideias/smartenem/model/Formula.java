package br.com.ciadeideias.smartenem.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ClaudioSouza on 03/10/2016.
 */
public class Formula implements Parcelable {
    private int idFormula;
    private int idAreaConhec;
    private String nomeFormula;
    private String aplicacaoFormula;
    private String descricaoFormula;
    private String imgFormula;

    public Formula(){

    }

    public Formula(Parcel in) {
        idFormula = in.readInt();
        idAreaConhec = in.readInt();
        nomeFormula = in.readString();
        aplicacaoFormula = in.readString();
        descricaoFormula = in.readString();
        imgFormula = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(idFormula);
        dest.writeInt(idAreaConhec);
        dest.writeString(nomeFormula);
        dest.writeString(aplicacaoFormula);
        dest.writeString(descricaoFormula);
        dest.writeString(imgFormula);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Formula> CREATOR = new Parcelable.Creator<Formula>() {
        @Override
        public Formula createFromParcel(Parcel in) {
            return new Formula(in);
        }

        @Override
        public Formula[] newArray(int size) {
            return new Formula[size];
        }
    };

    public int getIdFormula() {
        return idFormula;
    }

    public void setIdFormula(int idFormula) {
        this.idFormula = idFormula;
    }

    public int getIdAreaConhec() {
        return idAreaConhec;
    }

    public void setIdAreaConhec(int idAreaConhec) {
        this.idAreaConhec = idAreaConhec;
    }

    public String getNomeFormula() {
        return nomeFormula;
    }

    public void setNomeFormula(String nomeFormula) {
        this.nomeFormula = nomeFormula;
    }

    public String getAplicacaoFormula() {
        return aplicacaoFormula;
    }

    public void setAplicacaoFormula(String aplicacaoFormula) {
        this.aplicacaoFormula = aplicacaoFormula;
    }

    public String getDescricaoFormula() {
        return descricaoFormula;
    }

    public void setDescricaoFormula(String descricaoFormula) {
        this.descricaoFormula = descricaoFormula;
    }

    public String getImgFormula() {
        return imgFormula;
    }

    public void setImgFormula(String imgFormula) {
        this.imgFormula = imgFormula;
    }
}
