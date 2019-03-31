package br.com.ciadeideias.smartenem.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ClaudioSouza on 04/10/2016.
 */
public class Questao implements Parcelable {
    private int idQuestao;
    private int idAreaConhec;
    private String enunciado;
    private String textoApoio;
    private String confirmImag;
    private String endImagem;
    private String opcaoA;
    private String opcaoB;
    private String opcaoC;
    private String opcaoD;
    private String opcaoE;
    private String respostaGab;
    private String confirmComent;
    private String comentQuest;
    private String anoAplic;
    private int valorQuest;
    private int idDisciplina;

    public Questao(){}

    public Questao(Parcel in) {
        idQuestao = in.readInt();
        idAreaConhec = in.readInt();
        enunciado = in.readString();
        textoApoio = in.readString();
        confirmImag = in.readString();
        endImagem = in.readString();
        opcaoA = in.readString();
        opcaoB = in.readString();
        opcaoC = in.readString();
        opcaoD = in.readString();
        opcaoE = in.readString();
        respostaGab = in.readString();
        confirmComent = in.readString();
        comentQuest = in.readString();
        anoAplic = in.readString();
        valorQuest = in.readInt();
        idDisciplina = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(idQuestao);
        dest.writeInt(idAreaConhec);
        dest.writeString(enunciado);
        dest.writeString(textoApoio);
        dest.writeString(confirmImag);
        dest.writeString(endImagem);
        dest.writeString(opcaoA);
        dest.writeString(opcaoB);
        dest.writeString(opcaoC);
        dest.writeString(opcaoD);
        dest.writeString(opcaoE);
        dest.writeString(respostaGab);
        dest.writeString(confirmComent);
        dest.writeString(comentQuest);
        dest.writeString(anoAplic);
        dest.writeInt(valorQuest);
        dest.writeInt(idDisciplina);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Questao> CREATOR = new Parcelable.Creator<Questao>() {
        @Override
        public Questao createFromParcel(Parcel in) {
            return new Questao(in);
        }

        @Override
        public Questao[] newArray(int size) {
            return new Questao[size];
        }
    };

    public int getIdQuestao() {
        return idQuestao;
    }

    public void setIdQuestao(int idQuestao) {
        this.idQuestao = idQuestao;
    }

    public int getIdAreaConhec() {
        return idAreaConhec;
    }

    public void setIdAreaConhec(int idAreaConhec) {
        this.idAreaConhec = idAreaConhec;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public String getTextoApoio() {
        return textoApoio;
    }

    public void setTextoApoio(String textoApoio) {
        this.textoApoio = textoApoio;
    }

    public String getConfirmImag() {
        return confirmImag;
    }

    public void setConfirmImag(String confirmImag) {
        this.confirmImag = confirmImag;
    }

    public String getEndImagem() {
        return endImagem;
    }

    public void setEndImagem(String endImagem) {
        this.endImagem = endImagem;
    }

    public String getOpcaoA() {
        return opcaoA;
    }

    public void setOpcaoA(String opcaoA) {
        this.opcaoA = opcaoA;
    }

    public String getOpcaoB() {
        return opcaoB;
    }

    public void setOpcaoB(String opcaoB) {
        this.opcaoB = opcaoB;
    }

    public String getOpcaoC() {
        return opcaoC;
    }

    public void setOpcaoC(String opcaoC) {
        this.opcaoC = opcaoC;
    }

    public String getOpcaoD() {
        return opcaoD;
    }

    public void setOpcaoD(String opcaoD) {
        this.opcaoD = opcaoD;
    }

    public String getOpcaoE() {
        return opcaoE;
    }

    public void setOpcaoE(String opcaoE) {
        this.opcaoE = opcaoE;
    }

    public String getRespostaGab() {
        return respostaGab;
    }

    public void setRespostaGab(String respostaGab) {
        this.respostaGab = respostaGab;
    }

    public String getConfirmComent() {
        return confirmComent;
    }

    public void setConfirmComent(String confirmComent) {
        this.confirmComent = confirmComent;
    }

    public String getComentQuest() {
        return comentQuest;
    }

    public void setComentQuest(String comentQuest) {
        this.comentQuest = comentQuest;
    }

    public String getAnoAplic() {
        return anoAplic;
    }

    public void setAnoAplic(String anoAplic) {
        this.anoAplic = anoAplic;
    }

    public int getValorQuest() {
        return valorQuest;
    }

    public void setValorQuest(int valorQuest) {
        this.valorQuest = valorQuest;
    }

    public int getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(int idDisciplina) {
        this.idDisciplina = idDisciplina;
    }
}
