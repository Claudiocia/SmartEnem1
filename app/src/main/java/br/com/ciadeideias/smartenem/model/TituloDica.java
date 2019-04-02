package br.com.ciadeideias.smartenem.model;

import android.media.Image;

/**
 * Created by ClaudioSouza on 08/11/2016.
 */
public class TituloDica {
    private String titulo;
    private String descr;
    private int img;
    private int idDica;
    private String dicaTexto;

    public TituloDica(){};

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public int getIdDica() {
        return idDica;
    }

    public void setIdDica(int idDica) {
        this.idDica = idDica;
    }

    public String getDicaTexto() {
        return dicaTexto;
    }

    public void setDicaTexto(String dicaTexto) {
        this.dicaTexto = dicaTexto;
    }
}
