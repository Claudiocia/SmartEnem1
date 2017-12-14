package br.com.ciadeideias.smartenem.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ClaudioSouza on 04/10/2016.
 */
public class QuestoesSimulado implements Parcelable {
    private int idQuestao;
    private int idSimulado;
    private int numQuestao;
    private String statusQuestao;
    private String userResposta;
    private String statusResposta;

    public QuestoesSimulado(){}

    public QuestoesSimulado(Parcel in) {
        idQuestao = in.readInt();
        idSimulado = in.readInt();
        numQuestao = in.readInt();
        statusQuestao = in.readString();
        userResposta = in.readString();
        statusResposta = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(idQuestao);
        dest.writeInt(idSimulado);
        dest.writeInt(numQuestao);
        dest.writeString(statusQuestao);
        dest.writeString(userResposta);
        dest.writeString(statusResposta);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<QuestoesSimulado> CREATOR = new Parcelable.Creator<QuestoesSimulado>() {
        @Override
        public QuestoesSimulado createFromParcel(Parcel in) {
            return new QuestoesSimulado(in);
        }

        @Override
        public QuestoesSimulado[] newArray(int size) {
            return new QuestoesSimulado[size];
        }
    };

    public int getIdQuestao() {
        return idQuestao;
    }

    public void setIdQuestao(int idQuestao) {
        this.idQuestao = idQuestao;
    }

    public int getIdSimulado() {
        return idSimulado;
    }

    public void setIdSimulado(int idSimulado) {
        this.idSimulado = idSimulado;
    }

    public int getNumQuestao() {
        return numQuestao;
    }

    public void setNumQuestao(int numQuestao) {
        this.numQuestao = numQuestao;
    }

    public String getStatusQuestao() {
        return statusQuestao;
    }

    public void setStatusQuestao(String statusQuestao) {
        this.statusQuestao = statusQuestao;
    }

    public String getUserResposta() {
        return userResposta;
    }

    public void setUserResposta(String userResposta) {
        this.userResposta = userResposta;
    }

    public String getStatusResposta() {
        return statusResposta;
    }

    public void setStatusResposta(String statusResposta) {
        this.statusResposta = statusResposta;
    }
}
