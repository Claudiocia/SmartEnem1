package br.com.ciadeideias.smartenem.model;

/**
 * Created by ClaudioSouza on 04/10/2016.
 */
public class Dica {
    private int idDica;
    private String tituloDica;
    private String textoDica;
    private int qtdApres;
    private String dataApres;

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
}
