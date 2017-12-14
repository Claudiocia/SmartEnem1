package br.com.ciadeideias.smartenem.model;

/**
 * Created by ClaudioSouza on 04/10/2016.
 */
public class Evento {
    private int idEvento;
    private String dataInicio;
    private String dataFinal;
    private String horaInicio;
    private String horaFinal;
    private String eventoTit;
    private String eventoDescri;
    private String statusEvento;
    private String notificarEvent;

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(String horaFinal) {
        this.horaFinal = horaFinal;
    }

    public String getEventoTit() {
        return eventoTit;
    }

    public void setEventoTit(String eventoTit) {
        this.eventoTit = eventoTit;
    }

    public String getEventoDescri() {
        return eventoDescri;
    }

    public void setEventoDescri(String eventoDescri) {
        this.eventoDescri = eventoDescri;
    }

    public String getStatusEvento() {
        return statusEvento;
    }

    public void setStatusEvento(String statusEvento) {
        this.statusEvento = statusEvento;
    }

    public String getNotificarEvent() {
        return notificarEvent;
    }

    public void setNotificarEvent(String notificarEvent) {
        this.notificarEvent = notificarEvent;
    }
}
