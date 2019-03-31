package br.com.ciadeideias.smartenem.model;

/**
 * Created by ClaudioSouza on 12/10/2016.
 */
public class Disciplina {
    private String nome;
    private int idAreaChec;
    private int idDisciplina;

    public Disciplina(){};

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdAreaChec() {
        return idAreaChec;
    }

    public void setIdAreaChec(int idAreaChec) {
        this.idAreaChec = idAreaChec;
    }

    public int getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(int idDisciplina) {
        this.idDisciplina = idDisciplina;
    }
}
