package br.com.ciadeideias.smartenem.bancodados;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Parcelable;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.ciadeideias.smartenem.model.Grafico;

import static java.util.Calendar.DAY_OF_MONTH;

/**
 * Created by ClaudioSouza on 07/11/2016.
 */
public class BDGrafico {
    private SQLiteDatabase bd;

    public BDGrafico(Context context){
        BDPlunge auxBD = new BDPlunge(context);

        bd = auxBD.getWritableDatabase();
    }

    public void novoGrafico(Grafico graf){
        ContentValues valores = new ContentValues();

        valores.put("area_nome", graf.getAreaNome());
        valores.put("simul_compac_area", graf.getSimulCompacArea());
        valores.put("simul_comple", graf.getSimulComple());
        valores.put("data_realiz", graf.getDataRealiz());
        valores.put("qtd_quest", graf.getQtdQuest());
        valores.put("resp_certa", graf.getRespCerta());
        valores.put("resp_errada", graf.getRespErrada());
        valores.put("pts_simul_compac", graf.getPtsSimulCompac());
        valores.put("pts_simul_comple", graf.getPtsSimulComple());
        valores.put("temp_ativo", graf.getTempAtivo());

        bd.insert("graficos", null, valores);


    }

    public Grafico buscarGrafico(int id){
        Grafico graf = new Grafico();
        String[] colunas = new String[]{"idgrafico", "area_nome", "simul_compac_area", "simul_comple",
                "data_realiz", "qtd_quest", "resp_certa",
                "resp_errada", "pts_simul_compac",
                "pts_simul_comple", "temp_ativo"};
        String[]args = new String[]{""+id};
        Cursor cursor = bd.query("graficos", colunas, "idgrafico = ?", args, null, null, null);
        if (cursor.getCount() > 0){
            cursor.moveToFirst();
            graf.setIdGrafico(cursor.getInt(0));
            graf.setAreaNome(cursor.getString(1));
            graf.setSimulCompacArea(cursor.getString(2));
            graf.setSimulComple(cursor.getString(3));
            graf.setDataRealiz(cursor.getString(4));
            graf.setQtdQuest(cursor.getInt(5));
            graf.setRespCerta(cursor.getInt(6));
            graf.setRespErrada(cursor.getInt(7));
            graf.setPtsSimulCompac(cursor.getInt(8));
            graf.setPtsSimulComple(cursor.getInt(9));
            graf.setTempAtivo(cursor.getInt(10));
        }
        bd.close();
        return graf;
    }

    public ArrayList<Grafico> estudosDiarios(String area){
        ArrayList<Grafico> graficoList = new ArrayList<>();

        Calendar calendar = Calendar.getInstance();

        String dIni, dFim;
        dFim = (new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()));
        System.out.println("Data final: "+dFim);
        calendar.add(DAY_OF_MONTH, -6);
        dIni = (new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()));
        System.out.println("Data Inicial: "+dIni);

        String[] args = new String[]{area, dIni, dFim};

        String[] colunas = new String[]{"idgrafico", "area_nome", "simul_compac_area", "simul_comple",
                "data_realiz", "qtd_quest", "resp_certa",
                "resp_errada", "pts_simul_compac",
                "pts_simul_comple", "temp_ativo"};

        Cursor cursor = bd.rawQuery("SELECT * FROM graficos WHERE area_nome = ? AND data_realiz BETWEEN ? AND ?", args);

        if (cursor.getCount() > 0){
            cursor.moveToFirst();
            do {
                Grafico graf = new Grafico();
                graf.setIdGrafico(cursor.getInt(0));
                graf.setAreaNome(cursor.getString(1));
                graf.setSimulCompacArea(cursor.getString(2));
                graf.setSimulComple(cursor.getString(3));
                graf.setDataRealiz(cursor.getString(4));
                graf.setQtdQuest(cursor.getInt(5));
                graf.setRespCerta(cursor.getInt(6));
                graf.setRespErrada(cursor.getInt(7));
                graf.setPtsSimulCompac(cursor.getInt(8));
                graf.setPtsSimulComple(cursor.getInt(9));
                graf.setTempAtivo(cursor.getInt(10));

                graficoList.add(graf);
            }while (cursor.moveToNext());
        }

        cursor.close();
        return graficoList;
    }

    public ArrayList<Grafico> simulCompac(String area){
        ArrayList<Grafico> graficoList = new ArrayList<Grafico>();

        Calendar calendar = Calendar.getInstance();
        String dIni, dFim;
        dFim = (new SimpleDateFormat("dd/MM/yyyy").format(calendar.getTime()));
        calendar.add(DAY_OF_MONTH, -7);
        dIni = (new SimpleDateFormat("dd/MM/yyyy").format(calendar.getTime()));

        String[] args = new String[]{area, dIni, dFim};


        Cursor cursor = bd.rawQuery("SELECT * FROM graficos WHERE simul_compac_area = ? AND data_realiz >= ? AND data_realiz <= ? GROUP BY simul_compac_area ORDER BY data_realiz ASC", args);

        if (cursor.getCount() > 0){
            cursor.moveToFirst();
            do {
                Grafico graf = new Grafico();
                graf.setIdGrafico(cursor.getInt(0));
                graf.setAreaNome(cursor.getString(1));
                graf.setSimulCompacArea(cursor.getString(2));
                graf.setSimulComple(cursor.getString(3));
                graf.setDataRealiz(cursor.getString(4));
                graf.setQtdQuest(cursor.getInt(5));
                graf.setRespCerta(cursor.getInt(6));
                graf.setRespErrada(cursor.getInt(7));
                graf.setPtsSimulCompac(cursor.getInt(8));
                graf.setPtsSimulComple(cursor.getInt(9));
                graf.setTempAtivo(cursor.getInt(10));

                graficoList.add(graf);
            }while (cursor.moveToNext());
        }

        cursor.close();
        return graficoList;
    }

    public ArrayList<Grafico> simulComplet(){
        ArrayList<Grafico> graficoList = new ArrayList<Grafico>();
        String arg = "s";

        Calendar calendar = Calendar.getInstance();
        String dIni, dFim;
        dFim = (new SimpleDateFormat("dd/MM/yyyy").format(calendar.getTime()));
        calendar.add(DAY_OF_MONTH, -8);
        dIni = (new SimpleDateFormat("dd/MM/yyyy").format(calendar.getTime()));

        String[] args = new String[]{arg, dIni, dFim};

        Cursor cursor = bd.rawQuery("SELECT * FROM graficos WHERE simul_comple = ? AND data_realiz >= ? AND data_realiz <= ?", args);

        if (cursor.getCount() > 0){
            cursor.moveToFirst();
            do {
                Grafico graf = new Grafico();
                graf.setIdGrafico(cursor.getInt(0));
                graf.setAreaNome(cursor.getString(1));
                graf.setSimulCompacArea(cursor.getString(2));
                graf.setSimulComple(cursor.getString(3));
                graf.setDataRealiz(cursor.getString(4));
                graf.setQtdQuest(cursor.getInt(5));
                graf.setRespCerta(cursor.getInt(6));
                graf.setRespErrada(cursor.getInt(7));
                graf.setPtsSimulCompac(cursor.getInt(8));
                graf.setPtsSimulComple(cursor.getInt(9));
                graf.setTempAtivo(cursor.getInt(10));

                graficoList.add(graf);
            }while (cursor.moveToNext());
        }

        cursor.close();
        return graficoList;
    }

    public ArrayList<Grafico> tempoEstudo(){
        ArrayList<Grafico> graficoList = new ArrayList<Grafico>();

        Calendar calendar = Calendar.getInstance();
        String dIni, dFim;
        dFim = (new SimpleDateFormat("dd/MM/yyyy").format(calendar.getTime()));
        calendar.add(DAY_OF_MONTH, -6);
        dIni = (new SimpleDateFormat("dd/MM/yyyy").format(calendar.getTime()));

        String[] args = new String[]{dIni, dFim};

        Cursor cursor; // = bd.rawQuery("SELECT * FROM graficos WHERE data_realiz >= ? AND data_realiz <= ? ORDER BY data_realiz ASC ", args);

        cursor = bd.rawQuery("SELECT  data_realiz, Sum(temp_ativo) AS tempativo FROM graficos WHERE data_realiz >= ? AND data_realiz <= ? GROUP BY data_realiz ORDER BY data_realiz ASC", args);

        if (cursor.getCount() > 0){
            cursor.moveToFirst();
            do {
                Grafico graf = new Grafico();
                /*graf.setIdGrafico(cursor.getInt(0));
                graf.setAreaNome(cursor.getString(1));
                graf.setSimulCompacArea(cursor.getString(2));
                graf.setSimulComple(cursor.getString(3));
                graf.setDataRealiz(cursor.getString(4));
                graf.setQtdQuest(cursor.getInt(5));
                graf.setRespCerta(cursor.getInt(6));
                graf.setRespErrada(cursor.getInt(7));
                graf.setPtsSimulCompac(cursor.getInt(8));
                graf.setPtsSimulComple(cursor.getInt(9));
                graf.setTempAtivo(cursor.getInt(10));*/
                graf.setDataRealiz(cursor.getString(0));
                graf.setTempAtivo(cursor.getInt(1));

                graficoList.add(graf);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return graficoList;
    }

}
