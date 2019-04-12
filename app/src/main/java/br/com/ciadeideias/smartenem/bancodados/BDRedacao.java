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

        String[] colunas = new String[]{"idredacao", "tema", "ano", "titulo", "apresentacao",
                "titulo1", "subtitulo1", "texto1", "assinatura1", "imagem1_end", "titulo2",
                "subtitulo2", "texto2", "assinatura2", "imagem2_end", "titulo3", "subtitulo3",
                "texto3", "assinatura3", "imagem3_end", "titulo4", "subtitulo4", "texto4",
                "assinatura4", "imagem4_end"};

        String[] args = new String[]{""+id};

        Cursor cursor = bd.query("redacoes", colunas, "idredacao = ?", args, null, null, null);

        if (cursor.getCount() > 0){
            cursor.moveToFirst();
            redacao.setIdRed(cursor.getInt(0));
            redacao.setTemaRed(cursor.getString(1));
            redacao.setAnoRed(cursor.getString(2));
            redacao.setTitulo(cursor.getString(3));
            redacao.setApresent(cursor.getString(4));
            redacao.setTit1(cursor.getString(5));
            redacao.setSubtit1(cursor.getString(6));
            redacao.setTxt1(cursor.getString(7));
            redacao.setAss1(cursor.getString(8));
            redacao.setImgEnd1(cursor.getString(9));
            redacao.setTit2(cursor.getString(10));
            redacao.setSubtit2(cursor.getString(11));
            redacao.setTxt2(cursor.getString(12));
            redacao.setAss2(cursor.getString(13));
            redacao.setImgEnd2(cursor.getString(14));
            redacao.setTit3(cursor.getString(15));
            redacao.setSubtit3(cursor.getString(16));
            redacao.setTxt3(cursor.getString(17));
            redacao.setAss3(cursor.getString(18));
            redacao.setImgEnd3(cursor.getString(19));
            redacao.setTit4(cursor.getString(20));
            redacao.setSubtit4(cursor.getString(21));
            redacao.setTxt4(cursor.getString(22));
            redacao.setAss4(cursor.getString(23));
            redacao.setImgEnd4(cursor.getString(24));
        }
        cursor.close();
        return redacao;
    }

    public List<Redacao> buscarTodas(){
        List<Redacao> redacaoList = new ArrayList<Redacao>();

        String[] colunas = new String[]{"idredacao", "tema", "ano", "titulo", "apresentacao",
                "titulo1", "subtitulo1", "texto1", "assinatura1", "imagem1_end", "titulo2",
                "subtitulo2", "texto2", "assinatura2", "imagem2_end", "titulo3", "subtitulo3",
                "texto3", "assinatura3", "imagem3_end", "titulo4", "subtitulo4", "texto4",
                "assinatura4", "imagem4_end"};

        Cursor cursor = bd.query("redacoes", colunas, null, null, null, null, "ano DESC");

        if (cursor.getCount() > 0){
            cursor.moveToFirst();
            do {
                Redacao redacao = new Redacao();
                redacao.setIdRed(cursor.getInt(0));
                redacao.setTemaRed(cursor.getString(1));
                redacao.setAnoRed(cursor.getString(2));
                redacao.setTitulo(cursor.getString(3));
                redacao.setApresent(cursor.getString(4));
                redacao.setTit1(cursor.getString(5));
                redacao.setSubtit1(cursor.getString(6));
                redacao.setTxt1(cursor.getString(7));
                redacao.setAss1(cursor.getString(8));
                redacao.setImgEnd1(cursor.getString(9));
                redacao.setTit2(cursor.getString(10));
                redacao.setSubtit2(cursor.getString(11));
                redacao.setTxt2(cursor.getString(12));
                redacao.setAss2(cursor.getString(13));
                redacao.setImgEnd2(cursor.getString(14));
                redacao.setTit3(cursor.getString(15));
                redacao.setSubtit3(cursor.getString(16));
                redacao.setTxt3(cursor.getString(17));
                redacao.setAss3(cursor.getString(18));
                redacao.setImgEnd3(cursor.getString(19));
                redacao.setTit4(cursor.getString(20));
                redacao.setSubtit4(cursor.getString(21));
                redacao.setTxt4(cursor.getString(22));
                redacao.setAss4(cursor.getString(23));
                redacao.setImgEnd4(cursor.getString(24));

                redacaoList.add(redacao);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return (redacaoList);
    }
}