package br.com.ciadeideias.smartenem.bancodados;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.ciadeideias.smartenem.model.Questao;

/**
 * Created by ClaudioSouza on 06/10/2016.
 */
public class BDQuestao {
    private SQLiteDatabase bd;

    public BDQuestao(Context context){
        BDPlunge auxBD = new BDPlunge(context);

        bd = auxBD.getWritableDatabase();
    }

    public Questao buscaEstudoPorArea(int idArea){
        Questao questao = new Questao();


        Cursor cursor = bd.rawQuery("SELECT * FROM questoes WHERE area_conhec_idarea_conhec = "+idArea+"  LIMIT 1", null);


        if (cursor.getCount() >0){
            cursor.moveToFirst();
            questao.setIdQuestao(cursor.getInt(0));
            questao.setIdAreaConhec(cursor.getInt(1));
            questao.setEnunciado(cursor.getString(2));
            questao.setTextoApoio(cursor.getString(3));
            questao.setConfirmImag(cursor.getString(4));
            questao.setEndImagem(cursor.getString(5));
            questao.setOpcaoA(cursor.getString(6));
            questao.setOpcaoB(cursor.getString(7));
            questao.setOpcaoC(cursor.getString(8));
            questao.setOpcaoD(cursor.getString(9));
            questao.setOpcaoE(cursor.getString(10));
            questao.setRespostaGab(cursor.getString(11));
            questao.setConfirmComent(cursor.getString(12));
            questao.setComentQuest(cursor.getString(13));
            questao.setAnoAplic(cursor.getString(14));
            questao.setValorQuest(cursor.getInt(15));
            questao.setIdDisciplina(cursor.getInt(16));
        }
        cursor.close();
        return questao;
    }

    public List<Questao> buscarQuestaoParaSimulado(int idArea){
        List<Questao> questaoList = new ArrayList<Questao>();


        int limite;

        switch (idArea){
            case 4: case 5:
                limite = 5;
                break;
            case 6:
                limite = 40;
                break;
            default:
                limite = 45;
        }

        Cursor cursor = bd.rawQuery("SELECT * FROM questoes WHERE area_conhec_idarea_conhec = "+idArea+" ORDER BY RANDOM() LIMIT "+ limite, null);

        if (cursor.getCount() > 0){
            cursor.moveToFirst();
            do {
                Questao questao = new Questao();
                questao.setIdQuestao(cursor.getInt(0));
                questao.setIdAreaConhec(cursor.getInt(1));
                questao.setEnunciado(cursor.getString(2));
                questao.setTextoApoio(cursor.getString(3));
                questao.setConfirmImag(cursor.getString(4));
                questao.setEndImagem(cursor.getString(5));
                questao.setOpcaoA(cursor.getString(6));
                questao.setOpcaoB(cursor.getString(7));
                questao.setOpcaoC(cursor.getString(8));
                questao.setOpcaoD(cursor.getString(9));
                questao.setOpcaoE(cursor.getString(10));
                questao.setRespostaGab(cursor.getString(11));
                questao.setConfirmComent(cursor.getString(12));
                questao.setComentQuest(cursor.getString(13));
                questao.setAnoAplic(cursor.getString(14));
                questao.setValorQuest(cursor.getInt(15));
                questao.setIdDisciplina(cursor.getInt(16));

                questaoList.add(questao);
            }while (cursor.moveToNext());
        }

        cursor.close();
        return (questaoList);
    }

    public Questao buscaQuestaoPorId(int idquest) {
        Questao questao = new Questao();

        String[] colunas = new String[]{"idquestao", "area_conhec_idarea_conhec", "enunciado", "text_apoio", "imagem_sn", "imagem_end",
        "opcao_a", "opcao_b", "opcao_c", "opcao_d", "opcao_e", "resposta", "coment_sn", "comentario", "ano_aplic", "valor", "iddisciplina" };
        String[] args = new String[]{""+idquest};
       // Cursor cursor = bd.query("questoes", colunas, "_idquestao = ?", args, null, null, null);


        Cursor cursor = bd.rawQuery("SELECT * FROM questoes WHERE idquestao = " + idquest, null);


        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            questao.setIdQuestao(cursor.getInt(0));
            questao.setIdAreaConhec(cursor.getInt(1));
            questao.setEnunciado(cursor.getString(2));
            questao.setTextoApoio(cursor.getString(3));
            questao.setConfirmImag(cursor.getString(4));
            questao.setEndImagem(cursor.getString(5));
            questao.setOpcaoA(cursor.getString(6));
            questao.setOpcaoB(cursor.getString(7));
            questao.setOpcaoC(cursor.getString(8));
            questao.setOpcaoD(cursor.getString(9));
            questao.setOpcaoE(cursor.getString(10));
            questao.setRespostaGab(cursor.getString(11));
            questao.setConfirmComent(cursor.getString(12));
            questao.setComentQuest(cursor.getString(13));
            questao.setAnoAplic(cursor.getString(14));
            questao.setValorQuest(cursor.getInt(15));
            questao.setIdDisciplina(cursor.getInt(16));
        }
        cursor.close();
        return questao;
    }

    public void inserirQuestao(Questao questao){

        ContentValues valores = new ContentValues();
        valores.put("area_conhec_idarea_conhec", questao.getIdAreaConhec());
        valores.put("enunciado", questao.getEnunciado());
        valores.put("text_apoio", questao.getTextoApoio());
        valores.put("imagem_sn", questao.getConfirmImag());
        valores.put("imagem_end", questao.getEndImagem());
        valores.put("opcao_a", questao.getOpcaoA());
        valores.put("opcao_b", questao.getOpcaoB());
        valores.put("opcao_c", questao.getOpcaoC());
        valores.put("opcao_d", questao.getOpcaoD());
        valores.put("opcao_e", questao.getOpcaoE());
        valores.put("resposta", questao.getRespostaGab());
        valores.put("coment_sn", questao.getConfirmComent());
        valores.put("comentario", questao.getComentQuest());
        valores.put("ano_aplic", questao.getAnoAplic());
        valores.put("valor", questao.getValorQuest());
        valores.put("id_disciplina", questao.getIdDisciplina());

        bd.insert("questoes", null, valores);


    }

    public Questao buscaQuestaoPorIdDisc(int idDisciplina) {
        Questao questao = new Questao();

        String[] colunas = new String[]{"idquestao", "area_conhec_idarea_conhec", "enunciado", "text_apoio", "imagem_sn", "imagem_end",
                "opcao_a", "opcao_b", "opcao_c", "opcao_d", "opcao_e", "resposta", "coment_sn", "comentario", "ano_aplic", "valor", "iddisciplina" };
        String[] args = new String[]{""+idDisciplina};
        // Cursor cursor = bd.query("questoes", colunas, "_iddisciplina = ?", args, null, null, "RANDOM()", "1");


        Cursor cursor = bd.rawQuery("SELECT * FROM questoes WHERE iddisciplina = ? ORDER BY RANDOM() LIMIT 1", args);


        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            questao.setIdQuestao(cursor.getInt(0));
            questao.setIdAreaConhec(cursor.getInt(1));
            questao.setEnunciado(cursor.getString(2));
            questao.setTextoApoio(cursor.getString(3));
            questao.setConfirmImag(cursor.getString(4));
            questao.setEndImagem(cursor.getString(5));
            questao.setOpcaoA(cursor.getString(6));
            questao.setOpcaoB(cursor.getString(7));
            questao.setOpcaoC(cursor.getString(8));
            questao.setOpcaoD(cursor.getString(9));
            questao.setOpcaoE(cursor.getString(10));
            questao.setRespostaGab(cursor.getString(11));
            questao.setConfirmComent(cursor.getString(12));
            questao.setComentQuest(cursor.getString(13));
            questao.setAnoAplic(cursor.getString(14));
            questao.setValorQuest(cursor.getInt(15));
            questao.setIdDisciplina(cursor.getInt(16));
        }
        cursor.close();
        return questao;
    }
}
