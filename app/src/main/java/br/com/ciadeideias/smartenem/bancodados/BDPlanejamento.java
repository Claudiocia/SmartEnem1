package br.com.ciadeideias.smartenem.bancodados;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import br.com.ciadeideias.smartenem.model.Planejamento;

/**
 * Created by ClaudioSouza on 31/12/2017.
 */

public class BDPlanejamento {
    private SQLiteDatabase bd;

    public BDPlanejamento(Context context){
        BDPlunge auxBD = new BDPlunge(context);

        bd = auxBD.getWritableDatabase();
    }

    public Planejamento buscarDia(String nomeDia){
        Planejamento planDia = new Planejamento();

        String[] colunas = new String[]{"idplanestud", "dia_semana", "hora6", "hora7", "hora8",
                "hora9", "hora10", "hora11", "hora12", "hora13", "hora14", "hora15", "hora16",
                "hora17", "hora18", "hora19", "hora20", "hora21", "hora22", "notifc", "cor_back"};
        String [] args = new String[]{nomeDia};
        Cursor cursor = bd.query("planestud", colunas, "dia_semana = ?", args, null, null, null);

        if (cursor.getCount() > 0){
            cursor.moveToFirst();
            planDia.setIdPlanestud(cursor.getInt(0));
            planDia.setDiaSemana(cursor.getString(1));
            planDia.setHora6(cursor.getString(2));
            planDia.setHora7(cursor.getString(3));
            planDia.setHora8(cursor.getString(4));
            planDia.setHora9(cursor.getString(5));
            planDia.setHora10(cursor.getString(6));
            planDia.setHora11(cursor.getString(7));
            planDia.setHora12(cursor.getString(8));
            planDia.setHora13(cursor.getString(9));
            planDia.setHora14(cursor.getString(10));
            planDia.setHora15(cursor.getString(11));
            planDia.setHora16(cursor.getString(12));
            planDia.setHora17(cursor.getString(13));
            planDia.setHora18(cursor.getString(14));
            planDia.setHora19(cursor.getString(15));
            planDia.setHora20(cursor.getString(16));
            planDia.setHora21(cursor.getString(17));
            planDia.setHora22(cursor.getString(18));
            planDia.setNotifc(cursor.getString(19));
            planDia.setCorBack(cursor.getString(20));
        }
        bd.close();
        return planDia;
    }

    public ArrayList<Planejamento> buscarTodos(){
        ArrayList<Planejamento> planejaList = new ArrayList<>();

        String[] colunas = new String[]{"idplanestud", "dia_semana", "hora6", "hora7", "hora8",
                "hora9", "hora10", "hora11", "hora12", "hora13", "hora14", "hora15", "hora16",
                "hora17", "hora18", "hora19", "hora20", "hora21", "hora22", "notifc", "cor_back"};
        Cursor cursor = bd.query("planestud", colunas, null, null, null, null, "idplanestud ASC");

        if (cursor.getCount() > 0 ){
            cursor.moveToFirst();
            do {
                Planejamento planDia = new Planejamento();
                planDia.setIdPlanestud(cursor.getInt(0));
                planDia.setDiaSemana(cursor.getString(1));
                planDia.setHora6(cursor.getString(2));
                planDia.setHora7(cursor.getString(3));
                planDia.setHora8(cursor.getString(4));
                planDia.setHora9(cursor.getString(5));
                planDia.setHora10(cursor.getString(6));
                planDia.setHora11(cursor.getString(7));
                planDia.setHora12(cursor.getString(8));
                planDia.setHora13(cursor.getString(9));
                planDia.setHora14(cursor.getString(10));
                planDia.setHora15(cursor.getString(11));
                planDia.setHora16(cursor.getString(12));
                planDia.setHora17(cursor.getString(13));
                planDia.setHora18(cursor.getString(14));
                planDia.setHora19(cursor.getString(15));
                planDia.setHora20(cursor.getString(16));
                planDia.setHora21(cursor.getString(17));
                planDia.setHora22(cursor.getString(18));
                planDia.setNotifc(cursor.getString(19));
                planDia.setCorBack(cursor.getString(20));
                planejaList.add(planDia);
            }while (cursor.moveToNext());
        }
        cursor.close();
        bd.close();
        return (planejaList);
    }

    public void configPlanDia(Planejamento planDia){
        ContentValues valores = new ContentValues();

        valores.put("hora6", planDia.getHora6());
        valores.put("hora7", planDia.getHora7());
        valores.put("hora8", planDia.getHora8());
        valores.put("hora9", planDia.getHora9());
        valores.put("hora10", planDia.getHora10());
        valores.put("hora11", planDia.getHora11());
        valores.put("hora12", planDia.getHora12());
        valores.put("hora13", planDia.getHora13());
        valores.put("hora14", planDia.getHora14());
        valores.put("hora15", planDia.getHora15());
        valores.put("hora16", planDia.getHora16());
        valores.put("hora17", planDia.getHora17());
        valores.put("hora18", planDia.getHora18());
        valores.put("hora19", planDia.getHora19());
        valores.put("hora20", planDia.getHora20());
        valores.put("hora21", planDia.getHora21());
        valores.put("hora22", planDia.getHora22());

        String arg = planDia.getDiaSemana();
        String[] args = new String[]{arg};

        bd.update("planestud", valores, "dia_semana = ?", args);
        bd.close();
    }





}
