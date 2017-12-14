package br.com.ciadeideias.smartenem.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ClaudioSouza on 04/10/2016.
 */
public class Redacao implements Parcelable {
    private int idRed;
    private String temaRed;
    private String anoRed;
    private String exemRedTit;
    private String exemRedTex;
    private String comentAbert;
    private String comentDesen;
    private String comentFecha;
    private String exercRed;
    private String imagConfirm;
    private String imagEnd;

    public Redacao(){}

    public Redacao(Parcel in) {
        idRed = in.readInt();
        temaRed = in.readString();
        anoRed = in.readString();
        exemRedTit = in.readString();
        exemRedTex = in.readString();
        comentAbert = in.readString();
        comentDesen = in.readString();
        comentFecha = in.readString();
        exercRed = in.readString();
        imagConfirm = in.readString();
        imagEnd = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(idRed);
        dest.writeString(temaRed);
        dest.writeString(anoRed);
        dest.writeString(exemRedTit);
        dest.writeString(exemRedTex);
        dest.writeString(comentAbert);
        dest.writeString(comentDesen);
        dest.writeString(comentFecha);
        dest.writeString(exercRed);
        dest.writeString(imagConfirm);
        dest.writeString(imagEnd);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Redacao> CREATOR = new Parcelable.Creator<Redacao>() {
        @Override
        public Redacao createFromParcel(Parcel in) {
            return new Redacao(in);
        }

        @Override
        public Redacao[] newArray(int size) {
            return new Redacao[size];
        }
    };

    public int getIdRed() {
        return idRed;
    }

    public void setIdRed(int idRed) {
        this.idRed = idRed;
    }

    public String getTemaRed() {
        return temaRed;
    }

    public void setTemaRed(String temaRed) {
        this.temaRed = temaRed;
    }

    public String getAnoRed() {
        return anoRed;
    }

    public void setAnoRed(String anoRed) {
        this.anoRed = anoRed;
    }

    public String getExemRedTit() {
        return exemRedTit;
    }

    public void setExemRedTit(String exemRedTit) {
        this.exemRedTit = exemRedTit;
    }

    public String getExemRedTex() {
        return exemRedTex;
    }

    public void setExemRedTex(String exemRedTex) {
        this.exemRedTex = exemRedTex;
    }

    public String getComentAbert() {
        return comentAbert;
    }

    public void setComentAbert(String comentAbert) {
        this.comentAbert = comentAbert;
    }

    public String getComentDesen() {
        return comentDesen;
    }

    public void setComentDesen(String comentDesen) {
        this.comentDesen = comentDesen;
    }

    public String getComentFecha() {
        return comentFecha;
    }

    public void setComentFecha(String comentFecha) {
        this.comentFecha = comentFecha;
    }

    public String getExercRed() {
        return exercRed;
    }

    public void setExercRed(String exercRed) {
        this.exercRed = exercRed;
    }

    public String getImagConfirm() {
        return imagConfirm;
    }

    public void setImagConfirm(String imagConfirm) {
        this.imagConfirm = imagConfirm;
    }

    public String getImagEnd() {
        return imagEnd;
    }

    public void setImagEnd(String imagEnd) {
        this.imagEnd = imagEnd;
    }
}
