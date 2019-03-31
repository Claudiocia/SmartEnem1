package br.com.ciadeideias.smartenem.bancodados;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.ciadeideias.smartenem.model.Disciplina;

/**
 * Created by ClaudioSouza on 12/10/2016.
 */
public class BDDisciplina {
    private SQLiteDatabase bd;

    public BDDisciplina(Context context){
        BDPlunge auxBD = new BDPlunge(context);

        bd = auxBD.getWritableDatabase();
    }

    public List<Disciplina> buscarNomes(){
        List<Disciplina> listDisciplina = new ArrayList<Disciplina>();

        String[] colunas = new String[]{"iddisciplina", "area_conhec_idarea_conhec", "nome"};
        String args = "nome";
        Cursor cursor = bd.query("disciplinas", colunas, null, null, null, null, args, null);


        if (cursor.getCount() > 0){
            cursor.moveToFirst();
            do{
                Disciplina disciplina = new Disciplina ();
                disciplina.setIdDisciplina(cursor.getInt(0));
                disciplina.setIdAreaChec(cursor.getInt(1));
                disciplina.setNome(cursor.getString(2));
                listDisciplina.add(disciplina);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return (listDisciplina);
    }

    public int buscarId (String nome){
        Disciplina disciplina = new Disciplina();

        String[] args = new String[]{nome};



        Cursor cursor = bd.rawQuery("SELECT * FROM disciplinas WHERE nome = ?", args);

        if (cursor.getCount() > 0){
            cursor.moveToFirst();
            disciplina.setIdDisciplina(cursor.getInt(0));
            disciplina.setIdAreaChec(cursor.getInt(1));
            disciplina.setNome(cursor.getString(2));
        }
        cursor.close();
        int id = disciplina.getIdDisciplina();
        return (id);
    }

}
