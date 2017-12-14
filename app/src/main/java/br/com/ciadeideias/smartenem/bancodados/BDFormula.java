package br.com.ciadeideias.smartenem.bancodados;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.ciadeideias.smartenem.model.Formula;

/**
 * Created by ClaudioSouza on 06/10/2016.
 */
public class BDFormula {
    private SQLiteDatabase bd;

    public BDFormula(Context context){
        BDPlunge auxBD = new BDPlunge(context);

        bd = auxBD.getWritableDatabase();
    }

    public Formula buscaPorId(int id){
        Formula formula = new Formula();

        String[] colunas = new String[]{"idformula", "area_conhec_idarea_conhec", "nome", "aplicacao", "descricao", "imagem" };
        String[] args = new String[]{""+id};

        Cursor cursor = bd.query("formulas", colunas, "idformula = ?", args, null, null, null);

        if (cursor.getCount() > 0){
            cursor.moveToFirst();
            formula.setIdFormula(cursor.getInt(0));
            formula.setIdAreaConhec(cursor.getInt(1));
            formula.setNomeFormula(cursor.getString(2));
            formula.setAplicacaoFormula(cursor.getString(3));
            formula.setDescricaoFormula(cursor.getString(4));
            formula.setImgFormula(cursor.getString(5));
        }
        cursor.close();
        return formula;
    }

    public List<Formula> buscaTodas(){
        List<Formula> listFormula = new ArrayList<Formula>();

        String[] colunas = new String[]{"idformula", "area_conhec_idarea_conhec", "nome", "aplicacao", "descricao", "imagem" };
        Cursor cursor = bd.query("formulas", colunas, null, null, null, null, null);

        if (cursor.getCount() > 0){
            cursor.moveToFirst();
            do {
                Formula formula = new Formula();
                formula.setIdFormula(cursor.getInt(0));
                formula.setIdAreaConhec(cursor.getInt(1));
                formula.setNomeFormula(cursor.getString(2));
                formula.setAplicacaoFormula(cursor.getString(3));
                formula.setDescricaoFormula(cursor.getString(4));
                formula.setImgFormula(cursor.getString(5));

                listFormula.add(formula);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return (listFormula);
    }

    public List<Formula> buscarPorArea(int idArea){
        List<Formula> listFormula = new ArrayList<Formula>();

        String[] colunas = new String[]{"idformula", "area_conhec_idarea_conhec", "nome", "aplicacao", "descricao", "imagem" };
        String[] args = new String[]{""+idArea};

        Cursor cursor = bd.query("formulas", colunas, "area_conhec_idarea_conhec = ?", args, null, null, null);

        if (cursor.getCount() > 0){
            cursor.moveToFirst();
            do {
                Formula formula = new Formula();
                formula.setIdFormula(cursor.getInt(0));
                formula.setIdAreaConhec(cursor.getInt(1));
                formula.setNomeFormula(cursor.getString(2));
                formula.setAplicacaoFormula(cursor.getString(3));
                formula.setDescricaoFormula(cursor.getString(4));
                formula.setImgFormula(cursor.getString(5));

                listFormula.add(formula);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return (listFormula);
    }

}
