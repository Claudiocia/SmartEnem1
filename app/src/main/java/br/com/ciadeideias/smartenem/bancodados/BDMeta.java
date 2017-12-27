package br.com.ciadeideias.smartenem.bancodados;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import br.com.ciadeideias.smartenem.GrafActivity;
import br.com.ciadeideias.smartenem.model.Meta;

/**
 * Created by ClaudioSouza on 03/11/2016.
 */
public class BDMeta {
    private SQLiteDatabase bd;

    public BDMeta(Context context){
        BDPlunge auxBD = new BDPlunge(context);

        bd = auxBD.getWritableDatabase();
    }

    public void criarMetaPers(Meta meta){
        ContentValues valores = new ContentValues();
        valores.put("nome_meta", meta.getNomeMeta());
        valores.put("valor_meta", meta.getValorMeta());

        bd.insert("metas", null, valores);
    }

    public void configurarMetas(Meta meta){
        ContentValues valores = new ContentValues();

        valores.put("valor_meta", meta.getValorMeta());

        String arg = "" + meta.getIdMeta();
        String[] args = new String[]{arg};

        bd.update("metas", valores, "idmeta = ?", args);
        bd.close();
    }

    public void configurarDedic(Meta meta){
        ContentValues valores = new ContentValues();

        valores.put("nivel_dedic", meta.getNivelDedic());

        String arg = ""+1;
        String[] args = new String[]{arg};

        bd.update("metas", valores, "idmeta = ?", args);
        bd.close();
    }

    public Meta buscarMeta(int id){
        Meta meta = new Meta();

        String[] colunas = new String[]{"idmeta", "nome_meta", "valor_meta", "valor_exec", "desemp", "nivel_dedic" };
        String[] args = new String[]{""+id};
        try {
            Cursor cursor = bd.query("metas", colunas, "idmeta = ?", args, null, null, null);

            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                meta.setIdMeta(cursor.getInt(0));
                meta.setNomeMeta(cursor.getString(1));
                meta.setValorMeta(cursor.getInt(2));
                meta.setValorExec(cursor.getInt(3));
                meta.setDesempPerc(cursor.getString(4));
                meta.setNivelDedic(cursor.getString(5));
            }
            cursor.close();
        }catch (Exception e) {

            Log.d("banco", e.getMessage());
            bd.close();
        }

        return meta;
    }

    public List<Meta> buscarTodasMetas(){
        List<Meta> listMeta = new ArrayList<Meta>();

        String[] colunas = new String[]{"idmeta", "nome_meta", "valor_meta", "valor_exec", "desemp", "nivel_dedic" };

        Cursor cursor = bd.query("metas", colunas, null, null, null, null, null);

        if (cursor.getCount() > 0){
            cursor.moveToFirst();
            do {
                Meta meta = new Meta();
                meta.setIdMeta(cursor.getInt(0));
                meta.setNomeMeta(cursor.getString(1));
                meta.setValorMeta(cursor.getInt(2));
                meta.setValorExec(cursor.getInt(3));
                meta.setDesempPerc(cursor.getString(4));
                meta.setNivelDedic(cursor.getString(5));

                listMeta.add(meta);
            }while (cursor.moveToNext());
        }

        cursor.close();
        bd.close();
        return listMeta;
    }
}
