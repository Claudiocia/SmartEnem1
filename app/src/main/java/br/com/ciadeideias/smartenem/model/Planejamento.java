package br.com.ciadeideias.smartenem.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ClaudioSouza on 31/12/2017.
 */

public class Planejamento implements Parcelable {
    private int idPlanestud;
    private String diaSemana;
    private String hora6;
    private String hora7;
    private String hora8;
    private String hora9;
    private String hora10;
    private String hora11;
    private String hora12;
    private String hora13;
    private String hora14;
    private String hora15;
    private String hora16;
    private String hora17;
    private String hora18;
    private String hora19;
    private String hora20;
    private String hora21;
    private String hora22;
    private String notifc;
    private String corBack;

    public Planejamento(){}

    public int getIdPlanestud() { return idPlanestud; }

    public void setIdPlanestud(int idPlanestud) {
        this.idPlanestud = idPlanestud;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public String getHora6() {
        return hora6;
    }

    public void setHora6(String hora6) {
        this.hora6 = hora6;
    }

    public String getHora7() {
        return hora7;
    }

    public void setHora7(String hora7) {
        this.hora7 = hora7;
    }

    public String getHora8() {
        return hora8;
    }

    public void setHora8(String hora8) {
        this.hora8 = hora8;
    }

    public String getHora9() {
        return hora9;
    }

    public void setHora9(String hora9) {
        this.hora9 = hora9;
    }

    public String getHora10() {
        return hora10;
    }

    public void setHora10(String hora10) {
        this.hora10 = hora10;
    }

    public String getHora11() {
        return hora11;
    }

    public void setHora11(String hora11) {
        this.hora11 = hora11;
    }

    public String getHora12() {
        return hora12;
    }

    public void setHora12(String hora12) {
        this.hora12 = hora12;
    }

    public String getHora13() {
        return hora13;
    }

    public void setHora13(String hora13) {
        this.hora13 = hora13;
    }

    public String getHora14() {
        return hora14;
    }

    public void setHora14(String hora14) {
        this.hora14 = hora14;
    }

    public String getHora15() {
        return hora15;
    }

    public void setHora15(String hora15) {
        this.hora15 = hora15;
    }

    public String getHora16() {
        return hora16;
    }

    public void setHora16(String hora16) {
        this.hora16 = hora16;
    }

    public String getHora17() {
        return hora17;
    }

    public void setHora17(String hora17) {
        this.hora17 = hora17;
    }

    public String getHora18() {
        return hora18;
    }

    public void setHora18(String hora18) {
        this.hora18 = hora18;
    }

    public String getHora19() {
        return hora19;
    }

    public void setHora19(String hora19) {
        this.hora19 = hora19;
    }

    public String getHora20() {
        return hora20;
    }

    public void setHora20(String hora20) {
        this.hora20 = hora20;
    }

    public String getHora21() {
        return hora21;
    }

    public void setHora21(String hora21) {
        this.hora21 = hora21;
    }

    public String getHora22() {
        return hora22;
    }

    public void setHora22(String hora22) {
        this.hora22 = hora22;
    }

    public String getNotifc() {
        return notifc;
    }

    public void setNotifc(String notifc) {
        this.notifc = notifc;
    }

    public String getCorBack() {
        return corBack;
    }

    public void setCorBack(String corBack) {
        this.corBack = corBack;
    }


    public Planejamento(Parcel in) {
        idPlanestud = in.readInt();
        diaSemana = in.readString();
        hora6 = in.readString();
        hora7 = in.readString();
        hora8 = in.readString();
        hora9 = in.readString();
        hora10 = in.readString();
        hora11 = in.readString();
        hora12 = in.readString();
        hora13 = in.readString();
        hora14 = in.readString();
        hora15 = in.readString();
        hora16 = in.readString();
        hora17 = in.readString();
        hora18 = in.readString();
        hora19 = in.readString();
        hora20 = in.readString();
        hora21 = in.readString();
        hora22 = in.readString();
        notifc = in.readString();
        corBack = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(idPlanestud);
        dest.writeString(diaSemana);
        dest.writeString(hora6);
        dest.writeString(hora7);
        dest.writeString(hora8);
        dest.writeString(hora9);
        dest.writeString(hora10);
        dest.writeString(hora11);
        dest.writeString(hora12);
        dest.writeString(hora13);
        dest.writeString(hora14);
        dest.writeString(hora15);
        dest.writeString(hora16);
        dest.writeString(hora17);
        dest.writeString(hora18);
        dest.writeString(hora19);
        dest.writeString(hora20);
        dest.writeString(hora21);
        dest.writeString(hora22);
        dest.writeString(notifc);
        dest.writeString(corBack);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Planejamento> CREATOR = new Parcelable.Creator<Planejamento>() {
        @Override
        public Planejamento createFromParcel(Parcel in) {
            return new Planejamento(in);
        }

        @Override
        public Planejamento[] newArray(int size) {
            return new Planejamento[size];
        }
    };
}
