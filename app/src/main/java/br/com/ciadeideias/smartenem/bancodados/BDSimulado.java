package br.com.ciadeideias.smartenem.bancodados;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.ciadeideias.smartenem.model.Simulado;

/**
 * Created by ClaudioSouza on 06/10/2016.
 */
public class BDSimulado {
    private SQLiteDatabase bd;

    public BDSimulado(Context context){
        BDPlunge auxBD = new BDPlunge(context);

        bd = auxBD.getWritableDatabase();
    }

    public void criarSimulado(Simulado simulado){
        ContentValues valores = new ContentValues();

        valores.put("usuarios_idusuario", simulado.getIdUserSimulado());
        valores.put("tipo", simulado.getTipo());
        valores.put("tempo", simulado.getTempo());
        valores.put("data_inicio", simulado.getDataInicio());
        valores.put("data_fim", simulado.getDataFim());
        valores.put("acertos_tot", simulado.getAcertosTotal());
        valores.put("pontos", simulado.getPontos());
        valores.put("status_simulado", simulado.getStatusSimulado());
        valores.put("filtro", simulado.getFiltroSimulado());

        bd.insert("simulados", null, valores);
    }

    public void atualizarSimulado(Simulado simulado){
        ContentValues valores = new ContentValues();

        valores.put("usuarios_idusuario", simulado.getIdUserSimulado());
        valores.put("tipo", simulado.getTipo());
        valores.put("tempo", simulado.getTempo());
        valores.put("data_inicio", simulado.getDataInicio());
        valores.put("data_fim", simulado.getDataFim());
        valores.put("acertos_tot", simulado.getAcertosTotal());
        valores.put("pontos", simulado.getPontos());
        valores.put("status_simulado", simulado.getStatusSimulado());
        valores.put("filtro", simulado.getFiltroSimulado());

        String[] args = new String[]{""+simulado.getIdSimulado()};

        bd.update("simulados", valores, "idsimulado = ?", args);
    }

    public void deletarSimulado(Simulado simulado){
        String[] args = new String[]{""+simulado.getIdSimulado()};

        bd.delete("simulados", "idsimulado = ?", args);
    }

    public Simulado buscarPorId(int id){
        Simulado simulado = new Simulado();

        String[] colunas = new String[]{"idsimulado", "usuarios_idusuario", "tipo", "tempo", "data_inicio", "data_fimal", "acertos_tot", "pontos", "status_simulado", "filtro"};
        String[] args = new String[]{""+id};

        Cursor cursor = bd.query("simulados", colunas, "idsimulado = ?", args, null, null, null);

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            simulado.setIdSimulado(cursor.getInt(0));
            simulado.setIdUserSimulado(cursor.getInt(1));
            simulado.setTipo(cursor.getString(2));
            simulado.setTempo(cursor.getString(3));
            simulado.setDataInicio(cursor.getString(4));
            simulado.setDataFim(cursor.getString(5));
            simulado.setAcertosTotal(cursor.getInt(6));
            simulado.setPontos(cursor.getInt(7));
            simulado.setStatusSimulado(cursor.getString(8));
            simulado.setFiltroSimulado(cursor.getString(9));
        }
        cursor.close();
        return simulado;
    }

    public List<Simulado> buscarTodos(){
        List<Simulado> simuladoList = new ArrayList<Simulado>();

        String[] colunas = new String[]{"idsimulado", "usuarios_idusuario", "tipo", "tempo", "data_inicio", "data_fimal", "acertos_tot", "pontos", "status_simulado", "filtro"};

        Cursor cursor = bd.query("simulados", colunas, null, null, null, null, null);

        if (cursor.getCount() > 0){
            cursor.moveToFirst();
            do {
                Simulado simulado = new Simulado();
                simulado.setIdSimulado(cursor.getInt(0));
                simulado.setIdUserSimulado(cursor.getInt(1));
                simulado.setTipo(cursor.getString(2));
                simulado.setTempo(cursor.getString(3));
                simulado.setDataInicio(cursor.getString(4));
                simulado.setDataFim(cursor.getString(5));
                simulado.setAcertosTotal(cursor.getInt(6));
                simulado.setPontos(cursor.getInt(7));
                simulado.setStatusSimulado(cursor.getString(8));
                simulado.setFiltroSimulado(cursor.getString(9));

                simuladoList.add(simulado);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return (simuladoList);
    }

    public List<Simulado> buscarPorStatus(String status){
        List<Simulado> simuladoList = new ArrayList<Simulado>();

        String[] colunas = new String[]{"idsimulado", "usuarios_idusuario", "tipo", "tempo", "data_inicio", "data_fimal", "acertos_tot", "pontos", "status_simulado", "filtro"};
        String[] args = new String[]{status};

        Cursor cursor = bd.query("simulados", colunas, "status_simulado = ?", args, null, null, null);

        if (cursor.getCount() > 0){
            cursor.moveToFirst();
            do {
                Simulado simulado = new Simulado();
                simulado.setIdSimulado(cursor.getInt(0));
                simulado.setIdUserSimulado(cursor.getInt(1));
                simulado.setTipo(cursor.getString(2));
                simulado.setTempo(cursor.getString(3));
                simulado.setDataInicio(cursor.getString(4));
                simulado.setDataFim(cursor.getString(5));
                simulado.setAcertosTotal(cursor.getInt(6));
                simulado.setPontos(cursor.getInt(7));
                simulado.setStatusSimulado(cursor.getString(8));
                simulado.setFiltroSimulado(cursor.getString(9));

                simuladoList.add(simulado);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return (simuladoList);
    }

}
