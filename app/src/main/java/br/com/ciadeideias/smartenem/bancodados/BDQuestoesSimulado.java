package br.com.ciadeideias.smartenem.bancodados;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.ciadeideias.smartenem.model.Questao;
import br.com.ciadeideias.smartenem.model.QuestoesSimulado;

/**
 * Created by ClaudioSouza on 07/10/2016.
 */
public class BDQuestoesSimulado {
    private SQLiteDatabase bd;

    public BDQuestoesSimulado(Context context){
        BDPlunge auxBD = new BDPlunge(context);

        bd = auxBD.getWritableDatabase();
    }

    public void gravarQuestoes(List<Questao> questaoList, int idSimulado){
        int numQuest = 1;

        for (Questao quest : questaoList){
            ContentValues valores = new ContentValues();

            valores.put("questoes_idquestao", quest.getIdQuestao());
            valores.put("simulados_idsimulado", idSimulado);
            valores.put("questao_num", numQuest);
            valores.put("status_quest", "a");
            valores.put("user_resp", "null");
            valores.put("status_resp", "a");

            bd.insert("simulados_has_questoes", null, valores);
            numQuest++;
        }
    }

    public void atualizarQuestSimulado(QuestoesSimulado questSimul ){
        ContentValues valores = new ContentValues();

        valores.put("questoes_idquestao", questSimul.getIdQuestao());
        valores.put("simulados_idsimulado", questSimul.getIdSimulado());
        valores.put("questao_num", questSimul.getNumQuestao());
        valores.put("status_quest", questSimul.getStatusQuestao());
        valores.put("user_resp", questSimul.getUserResposta());
        valores.put("status_resp",questSimul.getStatusResposta());

        String[] args = new String[]{""+questSimul.getIdSimulado(), ""+questSimul.getNumQuestao()};

        bd.update("simulados_has_questoes", valores, "simulados_idsimulado = ? AND questao_num = ?", args);
    }

    public void deletarSimulado(int idSimulado){
        String[] args = new String[]{""+idSimulado};

        bd.delete("simulados_has_questoes", "idsimulado = ?", args);
    }

    public List<QuestoesSimulado> buscarQuestoesSimul(int idSimulado){
        List<QuestoesSimulado> questoesSimuladoList = new ArrayList<QuestoesSimulado>();

        String[] colunas = new String[]{"questoes_idquestao", "simulados_idsimulado", "questao_num", "status_quest", "user_resp", "status_resp" };
        String[] args = new String[]{""+idSimulado};

        Cursor cursor = bd.query("simulados_has_questoes", colunas, "simulado_idsimulado = ?", args, null, null, "questao_num ASC");

        if (cursor.getCount() > 0){
            cursor.moveToFirst();
            do {
                QuestoesSimulado questSimul = new QuestoesSimulado();
                questSimul.setIdQuestao(cursor.getInt(0));
                questSimul.setIdSimulado(cursor.getInt(1));
                questSimul.setNumQuestao(cursor.getInt(2));
                questSimul.setStatusQuestao(cursor.getString(3));
                questSimul.setUserResposta(cursor.getString(4));
                questSimul.setStatusResposta(cursor.getString(5));

                questoesSimuladoList.add(questSimul);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return (questoesSimuladoList);
    }
}
