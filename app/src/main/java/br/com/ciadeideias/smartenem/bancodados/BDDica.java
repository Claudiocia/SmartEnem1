package br.com.ciadeideias.smartenem.bancodados;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.ciadeideias.smartenem.model.Dica;

/**
 * Created by ClaudioSouza on 05/10/2016.
 */
public class BDDica {
    private SQLiteDatabase bd;

    public BDDica (Context context){
        BDPlunge auxBD = new BDPlunge(context);

        bd = auxBD.getWritableDatabase();
    }

    public Dica buscaAleatoria(){
        Dica dica = new Dica();

        String[] colunas = new String[]{"iddica", "dica_tit", "dica", "ultima_data", "qtd_apres"};

        Cursor cursor = bd.rawQuery("SELECT * FROM dicas ORDER BY RANDOM() LIMIT 1", null);

        if (cursor.getCount() > 0){
            cursor.moveToFirst();
            dica.setIdDica(cursor.getInt(0));
            dica.setTituloDica(cursor.getString(1));
            dica.setTextoDica(cursor.getString(2));
            dica.setDataApres(cursor.getString(3));
            dica.setQtdApres(cursor.getInt(4));

        }
        return dica;
    }

    public Dica buscaPorId(int id){
        Dica dica = new Dica();

        String[] colunas = new String[]{"iddica", "dica_tit", "dica", "ultima_data", "qtd_apres"};
        String[] args = new String[]{""+id};

        Cursor cursor = bd.query("dicas", colunas, "iddica = ?", args, null, null, null);

        if (cursor.getCount() > 0){
            cursor.moveToFirst();
            dica.setIdDica(cursor.getInt(0));
            dica.setTituloDica(cursor.getString(1));
            dica.setTextoDica(cursor.getString(2));
            dica.setDataApres(cursor.getString(3));
            dica.setQtdApres(cursor.getInt(4));

        }
        cursor.close();
        return dica;
    }

    public List<Dica> buscarTodas(){
        List<Dica> listDica = new ArrayList<Dica>();

        String[] colunas = new String[]{"iddica", "dica_tit", "dica", "ultima_data", "qtd_apres"};
        Cursor cursor = bd.query("dicas", colunas, null, null, null, null, null);

        if (cursor.getCount() > 0){
            cursor.moveToFirst();
            do {
                Dica dica = new Dica();
                dica.setIdDica(cursor.getInt(0));
                dica.setTituloDica(cursor.getString(1));
                dica.setTextoDica(cursor.getString(2));
                dica.setDataApres(cursor.getString(3));
                dica.setQtdApres(cursor.getInt(4));
                listDica.add(dica);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return (listDica);
    }

    public void atualizarDica(Dica dica){
        ContentValues valores = new ContentValues();

        String arg = ""+ dica.getIdDica();
        String[] args = new String[]{arg};

        int x = dica.getQtdApres()+ 1;
        String hoje = DateFormat.getDateInstance().format(new Date());

        valores.put("ultima_data", hoje);
        valores.put("qtd_apres", x);

        bd.update("dicas", valores, "iddica = ?", args);

    }

}
