package br.com.ciadeideias.smartenem.model;

public class TemasRedacao {
    private String tema;
    private String anoAplic;
    private int idRedacao;

    public TemasRedacao(){};

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getAnoAplic() {
        return anoAplic;
    }

    public void setAnoAplic(String anoAplic) {
        this.anoAplic = anoAplic;
    }

    public int getIdRedacao() {
        return idRedacao;
    }

    public void setIdRedacao(int idRedacao) {
        this.idRedacao = idRedacao;
    }
}
