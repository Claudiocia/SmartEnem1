package br.com.ciadeideias.smartenem.bancodados;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.ciadeideias.smartenem.model.Evento;

/**
 * Created by ClaudioSouza on 04/10/2016.
 */
public class BDEvento {
    private SQLiteDatabase bd;

    public BDEvento(Context context) {
        BDPlunge auxBD = new BDPlunge(context);

        bd = auxBD.getWritableDatabase();
    }

    public Evento buscarPorId(int id){
        Evento evento = new Evento();

        String[] colunas = new String[]{"idevento", "data_inicio", "data_final", "hora_inicio", "hora_final", "evento_tit", "evento", "status_evento", "notificar"};
        String[] args = new String[]{""+id};

        Cursor cursor = bd.query("eventos", colunas, "idevento = ?", args, null, null, null );

        if (cursor.getCount() > 0){
            cursor.moveToFirst();
            evento.setIdEvento(cursor.getInt(0));
            evento.setDataInicio(cursor.getString(1));
            evento.setDataFinal(cursor.getString(2));
            evento.setHoraInicio(cursor.getString(3));
            evento.setHoraFinal(cursor.getString(4));
            evento.setEventoTit(cursor.getString(5));
            evento.setEventoDescri(cursor.getString(6));
            evento.setStatusEvento(cursor.getString(7));
            evento.setNotificarEvent(cursor.getString(8));
        }
        return  evento;
    }

    public List<Evento> buscarAbertos(){
        List<Evento> listEvento = new ArrayList<Evento>();

        String[] colunas = new String[]{"idevento", "data_inicio", "data_final", "hora_inicio", "hora_final", "evento_tit", "evento", "status_evento", "notificar"};
        String hoje = DateFormat.getDateInstance().format(new Date());
        Cursor cursor = bd.rawQuery("SELECT * FROM eventos WHERE status_evento = 'a' AND data_final <="+ hoje, null);

        if (cursor.getCount() > 0 ){
            cursor.moveToFirst();
            do{
                Evento evento = new Evento();
                evento.setIdEvento(cursor.getInt(0));
                evento.setDataInicio(cursor.getString(1));
                evento.setDataFinal(cursor.getString(2));
                evento.setHoraInicio(cursor.getString(3));
                evento.setHoraFinal(cursor.getString(4));
                evento.setEventoTit(cursor.getString(5));
                evento.setEventoDescri(cursor.getString(6));
                evento.setStatusEvento(cursor.getString(7));
                evento.setNotificarEvent(cursor.getString(8));
                listEvento.add(evento);
            }while (cursor.moveToNext());
        }

        return (listEvento);
    }

    public List<Evento> buscarTodos(){
        List<Evento> listEventos = new ArrayList<Evento>();

        String[] colunas = new String[]{"idevento", "data_inicio", "data_final", "hora_inicio", "hora_final", "evento_tit", "evento", "status_evento", "notificar"};
        Cursor cursor = bd.query("eventos", colunas, null, null, null, null, "data_inicio ASC");

        if (cursor.getCount() > 0 ){
            cursor.moveToFirst();
            do{
                Evento evento = new Evento();
                evento.setIdEvento(cursor.getInt(0));
                evento.setDataInicio(cursor.getString(1));
                evento.setDataFinal(cursor.getString(2));
                evento.setHoraInicio(cursor.getString(3));
                evento.setHoraFinal(cursor.getString(4));
                evento.setEventoTit(cursor.getString(5));
                evento.setEventoDescri(cursor.getString(6));
                evento.setStatusEvento(cursor.getString(7));
                evento.setNotificarEvent(cursor.getString(8));
                listEventos.add(evento);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return (listEventos);
    }
}
