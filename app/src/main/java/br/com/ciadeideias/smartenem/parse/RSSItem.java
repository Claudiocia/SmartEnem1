package br.com.ciadeideias.smartenem.parse;

import java.io.Serializable;

/**
 * Created by ClaudioSouza on 31/10/2016.
 */
public class RSSItem implements Serializable {

    private static final long serialVersionUID = 1L;
    private String titulo = null;
    private String resumo = null;
    private String data = null;
    private String imagem = null;
    private String link = null;
    private String local = null;
    private String texto = null;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
}
