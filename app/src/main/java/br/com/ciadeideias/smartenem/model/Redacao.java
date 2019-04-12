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
    private String titulo;
    private String apresent;
    private String tit1;
    private String subtit1;
    private String txt1;
    private String ass1;
    private String imgEnd1;
    private String tit2;
    private String subtit2;
    private String txt2;
    private String ass2;
    private String imgEnd2;
    private String tit3;
    private String subtit3;
    private String txt3;
    private String ass3;
    private String imgEnd3;
    private String tit4;
    private String subtit4;
    private String txt4;
    private String ass4;
    private String imgEnd4;


    public Redacao(){}

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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getApresent() {
        return apresent;
    }

    public void setApresent(String apresent) {
        this.apresent = apresent;
    }

    public String getTit1() {
        return tit1;
    }

    public void setTit1(String tit1) {
        this.tit1 = tit1;
    }

    public String getSubtit1() {
        return subtit1;
    }

    public void setSubtit1(String subtit1) {
        this.subtit1 = subtit1;
    }

    public String getTxt1() {
        return txt1;
    }

    public void setTxt1(String txt1) {
        this.txt1 = txt1;
    }

    public String getAss1() {
        return ass1;
    }

    public void setAss1(String ass1) {
        this.ass1 = ass1;
    }

    public String getImgEnd1() {
        return imgEnd1;
    }

    public void setImgEnd1(String imgEnd1) {
        this.imgEnd1 = imgEnd1;
    }

    public String getTit2() {
        return tit2;
    }

    public void setTit2(String tit2) {
        this.tit2 = tit2;
    }

    public String getSubtit2() {
        return subtit2;
    }

    public void setSubtit2(String subtit2) {
        this.subtit2 = subtit2;
    }

    public String getTxt2() {
        return txt2;
    }

    public void setTxt2(String txt2) {
        this.txt2 = txt2;
    }

    public String getAss2() {
        return ass2;
    }

    public void setAss2(String ass2) {
        this.ass2 = ass2;
    }

    public String getImgEnd2() {
        return imgEnd2;
    }

    public void setImgEnd2(String imgEnd2) {
        this.imgEnd2 = imgEnd2;
    }

    public String getTit3() {
        return tit3;
    }

    public void setTit3(String tit3) {
        this.tit3 = tit3;
    }

    public String getSubtit3() {
        return subtit3;
    }

    public void setSubtit3(String subtit3) {
        this.subtit3 = subtit3;
    }

    public String getTxt3() {
        return txt3;
    }

    public void setTxt3(String txt3) {
        this.txt3 = txt3;
    }

    public String getAss3() {
        return ass3;
    }

    public void setAss3(String ass3) {
        this.ass3 = ass3;
    }

    public String getImgEnd3() {
        return imgEnd3;
    }

    public void setImgEnd3(String imgEnd3) {
        this.imgEnd3 = imgEnd3;
    }

    public String getTit4() {
        return tit4;
    }

    public void setTit4(String tit4) {
        this.tit4 = tit4;
    }

    public String getSubtit4() {
        return subtit4;
    }

    public void setSubtit4(String subtit4) {
        this.subtit4 = subtit4;
    }

    public String getTxt4() {
        return txt4;
    }

    public void setTxt4(String txt4) {
        this.txt4 = txt4;
    }

    public String getAss4() {
        return ass4;
    }

    public void setAss4(String ass4) {
        this.ass4 = ass4;
    }

    public String getImgEnd4() {
        return imgEnd4;
    }

    public void setImgEnd4(String imgEnd4) {
        this.imgEnd4 = imgEnd4;
    }

    protected Redacao(Parcel in) {
        idRed = in.readInt();
        temaRed = in.readString();
        anoRed = in.readString();
        titulo = in.readString();
        apresent = in.readString();
        tit1 = in.readString();
        subtit1 = in.readString();
        txt1 = in.readString();
        ass1 = in.readString();
        imgEnd1 = in.readString();
        tit2 = in.readString();
        subtit2 = in.readString();
        txt2 = in.readString();
        ass2 = in.readString();
        imgEnd2 = in.readString();
        tit3 = in.readString();
        subtit3 = in.readString();
        txt3 = in.readString();
        ass3 = in.readString();
        imgEnd3 = in.readString();
        tit4 = in.readString();
        subtit4 = in.readString();
        txt4 = in.readString();
        ass4 = in.readString();
        imgEnd4 = in.readString();
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
        dest.writeString(titulo);
        dest.writeString(apresent);
        dest.writeString(tit1);
        dest.writeString(subtit1);
        dest.writeString(txt1);
        dest.writeString(ass1);
        dest.writeString(imgEnd1);
        dest.writeString(tit2);
        dest.writeString(subtit2);
        dest.writeString(txt2);
        dest.writeString(ass2);
        dest.writeString(imgEnd2);
        dest.writeString(tit3);
        dest.writeString(subtit3);
        dest.writeString(txt3);
        dest.writeString(ass3);
        dest.writeString(imgEnd3);
        dest.writeString(tit4);
        dest.writeString(subtit4);
        dest.writeString(txt4);
        dest.writeString(ass4);
        dest.writeString(imgEnd4);
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
}
