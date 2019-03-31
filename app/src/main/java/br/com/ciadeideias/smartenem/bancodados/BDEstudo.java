package br.com.ciadeideias.smartenem.bancodados;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import br.com.ciadeideias.smartenem.model.Estudo;

/**
 * Created by ClaudioSouza on 27/03/2019.
 */

public class BDEstudo {

    private SQLiteDatabase bd;

    public BDEstudo(Context context) {
        BDPlunge auxBD = new BDPlunge(context);

        bd = auxBD.getWritableDatabase();
    }

    public void novoEstudo(Estudo estudo){
        ContentValues valores = new ContentValues();

        valores.put("disciplina_nome", estudo.getDisciplinaNome());
        valores.put("data_realiz", estudo.getDataRealiz());
        valores.put("qtd_quest", estudo.getQtdQuest());
        valores.put("resp_certa", estudo.getRespCerta());
        valores.put("resp_errada", estudo.getRespErrada());
        valores.put("hora_inicio", estudo.getHoraInicio());
        valores.put("temp_ativo", estudo.getTempAtivo());

        bd.insert("estudos", null, valores);
        bd.close();

    }


    public Estudo buscarEstudo(int id){
        Estudo estudo = new Estudo();
        String[] colunas = new String[]{"idestudo", "disciplina_nome", "data_realiz",
                "qtd_quest", "resp_certa", "resp_errada", "hora_inicio", "temp_ativo"};

        String[] args = new String[]{""+id};

        try {

            Cursor cursor = bd.query("estudos", colunas, "idestudo = ?", args, null, null, null);

            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                estudo.setIdEstudo(cursor.getInt(0));
                estudo.setDisciplinaNome(cursor.getString(1));
                estudo.setDataRealiz(cursor.getString(2));
                estudo.setQtdQuest(cursor.getInt(3));
                estudo.setRespCerta(cursor.getInt(4));
                estudo.setRespErrada(cursor.getInt(5));
                estudo.setHoraInicio(cursor.getString(6));
                estudo.setTempAtivo(cursor.getString(7));
            }
            cursor.close();
        }catch (Exception e) {
            Log.d("banco estudo", e.getMessage());
            bd.close();
        }
        return estudo;
    }

    public Estudo buscarEstudoPorDisciplina(String disciplinaNome, String dataEstudo){
        Estudo estudo = new Estudo();
        String[] colunas = new String[]{"idestudo", "disciplina_nome", "data_realiz",
                "qtd_quest", "resp_certa", "resp_errada", "hora_inicio", "temp_ativo"};

        String[] args = new String[]{disciplinaNome, dataEstudo};

        Cursor cursor = bd.query("estudos", colunas, "disciplina_nome = ? AND data_realiz = ?", args, null, null, null);

        if (cursor.getCount() > 0){
            cursor.moveToFirst();
            estudo.setIdEstudo(cursor.getInt(0));
            estudo.setDisciplinaNome(cursor.getString(1));
            estudo.setDataRealiz(cursor.getString(2));
            estudo.setQtdQuest(cursor.getInt(3));
            estudo.setRespCerta(cursor.getInt(4));
            estudo.setRespErrada(cursor.getInt(5));
            estudo.setHoraInicio(cursor.getString(6));
            estudo.setTempAtivo(cursor.getString(7));
        }
        cursor.close();
        bd.close();
        return estudo;
    }

    public void atualizarQuestEstudo(Estudo estudo){
        ContentValues valores =  new ContentValues();

        valores.put("qtd_quest", estudo.getQtdQuest());
        valores.put("resp_certa", estudo.getRespCerta());
        valores.put("resp_errada", estudo.getRespErrada());

        String arg = ""+ estudo.getIdEstudo();
        String[] args = new String[]{arg};

        bd.update("estudos", valores, "idestudo = ?", args);
        bd.close();

    }

    public void atualizarTempoEstudo(Estudo estudo){
        ContentValues valores =  new ContentValues();

        valores.put("temp_ativo", estudo.getTempAtivo());

        String arg = ""+ estudo.getIdEstudo();
        String[] args = new String[]{arg};

        bd.update("estudos", valores, "idestudo = ?", args);
        bd.close();

    }

    public void atualizarHoraInicio(Estudo estudo){
        ContentValues valores = new ContentValues();

        valores.put("hora_inicio", estudo.getHoraInicio());

        String arg = ""+estudo.getIdEstudo();
        String[]args = new String[]{arg};

        bd.update("estudos", valores, "idestudo = ?", args);
        bd.close();

    }

    public void limparTabela(String tabela){
        String[] args = new String[]{tabela};

        bd.delete(tabela, null, null);
        bd.delete("sqlite_sequence", "name = ?", args);
        bd.close();
    }


























}
