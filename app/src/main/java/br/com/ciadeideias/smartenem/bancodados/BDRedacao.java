package br.com.ciadeideias.smartenem.bancodados;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.ciadeideias.smartenem.model.Redacao;

/**
 * Created by ClaudioSouza on 06/10/2016.
 */
public class BDRedacao {
    private SQLiteDatabase bd;

    public BDRedacao(Context context){
        BDPlunge auxBD = new BDPlunge(context);

        bd = auxBD.getWritableDatabase();
    }

    public Redacao buscaPorId(int id){
        Redacao redacao = new Redacao();

        String[] colunas = new String[]{"idredacao", "tema", "ano", "exemplo_tit", "exemplo_text", "coment_abert", "coment_desenv", "coment_fecha", "exercicio", "imagem_sn", "imagem_end" };
        String[] args = new String[]{""+id};

        Cursor cursor = bd.query("redacoes", colunas, "idredacao = ?", args, null, null, null);

        if (cursor.getCount() > 0){
            cursor.moveToFirst();
            redacao.setIdRed(cursor.getInt(0));
            redacao.setTemaRed(cursor.getString(1));
            redacao.setAnoRed(cursor.getString(2));
            redacao.setExemRedTit(cursor.getString(3));
            redacao.setExemRedTex(cursor.getString(4));
            redacao.setComentAbert(cursor.getString(5));
            redacao.setComentDesen(cursor.getString(6));
            redacao.setComentFecha(cursor.getString(7));
            redacao.setExercRed(cursor.getString(8));
            redacao.setImagConfirm(cursor.getString(9));
            redacao.setImagEnd(cursor.getString(10));
        }
        cursor.close();
        return redacao;
    }

    public List<Redacao> buscarTodas(){
        List<Redacao> redacaoList = new ArrayList<Redacao>();

        String[] colunas = new String[]{"idredacao", "tema", "ano", "exemplo_tit", "exemplo_text", "coment_abert", "coment_desenv", "coment_fecha", "exercicio", "imagem_sn", "imagem_end" };

        Cursor cursor = bd.query("redacoes", colunas, null, null, null, null, null);

        if (cursor.getCount() > 0){
            cursor.moveToFirst();
            do {
                Redacao redacao = new Redacao();
                redacao.setIdRed(cursor.getInt(0));
                redacao.setTemaRed(cursor.getString(1));
                redacao.setAnoRed(cursor.getString(2));
                redacao.setExemRedTit(cursor.getString(3));
                redacao.setExemRedTex(cursor.getString(4));
                redacao.setComentAbert(cursor.getString(5));
                redacao.setComentDesen(cursor.getString(6));
                redacao.setComentFecha(cursor.getString(7));
                redacao.setExercRed(cursor.getString(8));
                redacao.setImagConfirm(cursor.getString(9));
                redacao.setImagEnd(cursor.getString(10));

                redacaoList.add(redacao);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return (redacaoList);
    }
}
