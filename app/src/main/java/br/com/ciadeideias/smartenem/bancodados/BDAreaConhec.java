package br.com.ciadeideias.smartenem.bancodados;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.ciadeideias.smartenem.model.AreaConhec;

/**
 * Created by ClaudioSouza on 04/10/2016.
 */
public class BDAreaConhec {
    private SQLiteDatabase bd;

    public BDAreaConhec(Context context){
        BDPlunge auxBD = new BDPlunge(context);

        bd = auxBD.getWritableDatabase();
    }

    public AreaConhec buscarPorId(int id){
        AreaConhec area = new AreaConhec();
        String[] colunas = new String[]{"idarea_conhec", "nome"};
        String[] args = new String[]{""+id};

        Cursor cursor = bd.query("area_conhec", colunas, "idarea_conhec = ?", args, null, null, null);

        if (cursor.getCount() > 0){
            cursor.moveToFirst();
            area.setId_areaConhec(cursor.getInt(0));
            area.setAreaConhec(cursor.getString(1));
        }
        return area;
    }

    public List<AreaConhec> buscarTodas(){
        List<AreaConhec> listArea = new ArrayList<AreaConhec>();
        String[] colunas = new String[]{"idarea_conhec", "nome"};

        Cursor cursor = bd.query("area_conhec", colunas, null, null, null, null, "nome ASC");

        if (cursor.getCount() > 0){
            cursor.moveToFirst();
            do{
                AreaConhec area = new AreaConhec();
                area.setId_areaConhec(cursor.getInt(0));
                area.setAreaConhec(cursor.getString(1));
                listArea.add(area);
            }while (cursor.moveToNext());
        }

        return (listArea);
    }
}
