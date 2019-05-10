package br.com.ciadeideias.smartenem.model;

/**
 * Created by ClaudioSouza on 08/11/2016.
 */
public class NomeDisciplina {
    private String nome;
    private String img;
    private String descri;
    private int idDisciplina;

    public NomeDisciplina(){};

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescri() {
        return descri;
    }

    public void setDescri(String descri) {
        this.descri = descri;
    }

    public int getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(int idDisciplina) {
        this.idDisciplina = idDisciplina;
    }
}
