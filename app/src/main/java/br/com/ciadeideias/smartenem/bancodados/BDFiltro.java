package br.com.ciadeideias.smartenem.bancodados;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.ciadeideias.smartenem.model.Filtro;

/**
 * Created by ClaudioSouza on 05/10/2016.
 */
public class BDFiltro {
    private SQLiteDatabase bd;

    public BDFiltro(Context context){
        BDPlunge auxBD = new BDPlunge(context);

        bd = auxBD.getWritableDatabase();
    }

    public List<Filtro> buscarTodos(){
        List<Filtro> listFiltro = new ArrayList<Filtro>();

        String[] colunas = new String[]{"idfiltro", "nome_filtro"};
        Cursor cursor = bd.query("dicas", colunas, null, null, null, null, null);

        if (cursor.getCount() > 0){
            cursor.moveToFirst();
            do {
                Filtro filtro = new Filtro();
                filtro.setIdFiltro(cursor.getInt(0));
                filtro.setNomeFiltro(cursor.getString(1));

                listFiltro.add(filtro);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return (listFiltro);
    }

    public Filtro buscaPorId(int id){
        Filtro filtro = new Filtro();

        String[] colunas = new String[]{"idfiltro", "nome_filtro"};
        String[] args = new String[]{""+id};

        Cursor cursor = bd.query("filtros", colunas, "idfiltro = ?", args, null, null, null);

        if (cursor.getCount() > 0){
            cursor.moveToFirst();
            filtro.setIdFiltro(cursor.getInt(0));
            filtro.setNomeFiltro(cursor.getString(1));

        }
        cursor.close();
        return filtro;
    }

}
