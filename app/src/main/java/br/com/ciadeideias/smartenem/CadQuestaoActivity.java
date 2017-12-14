package br.com.ciadeideias.smartenem;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import br.com.ciadeideias.smartenem.bancodados.BDQuestao;
import br.com.ciadeideias.smartenem.model.Questao;

public class CadQuestaoActivity extends AppCompatActivity {
    Questao questao;
    BDQuestao bdQuestao;
    EditText edtAreaConhec, edtAnoAplic, edtEnunciado, edtTextoApoio, edtEndImagem, edtOpcaoA, edtOpcaoB, edtOpcaoC, edtOpcaoD, edtOpcaoE, edtResposta, edtComent;
    private RadioGroup confirmImag;
    private RadioButton btnconfirm;
    String comentSN = "n";
    String anoAplic, enunciado, textoApoio, confirmSN, endImagem, opcaoA, opcaoB, opcaoC, opcaoD, opcaoE, resposta, coment;
    int areaConhec;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_questao);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(R.string.cad_quest);

        edtAreaConhec   = (EditText) findViewById(R.id.edt_area_conhec);
        edtAnoAplic     = (EditText) findViewById(R.id.edt_ano_aplic);
        edtEnunciado    = (EditText) findViewById(R.id.edt_enunciado);
        edtTextoApoio   = (EditText) findViewById(R.id.edt_txt_apoio);
        edtEndImagem    = (EditText) findViewById(R.id.edt_img_end);
        edtOpcaoA       = (EditText) findViewById(R.id.edt_opcao_a);
        edtOpcaoB       = (EditText) findViewById(R.id.edt_opcao_b);
        edtOpcaoC       = (EditText) findViewById(R.id.edt_opcao_c);
        edtOpcaoD       = (EditText) findViewById(R.id.edt_opcao_d);
        edtOpcaoE       = (EditText) findViewById(R.id.edt_opcao_e);
        edtResposta     = (EditText) findViewById(R.id.edt_resposta);
        edtComent       = (EditText) findViewById(R.id.edt_comentario);

        confirmImag     = (RadioGroup) findViewById(R.id.confirm_img);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        else if (id == R.id.sobre){
            return true;
        }
        else if(id == R.id.cad_quest){
            Intent cadQuest = new Intent(CadQuestaoActivity.this, CadQuestaoActivity.class);
            startActivity(cadQuest);
        }
        return super.onOptionsItemSelected(item);
    }

    public void gravarQuestao(View view){

        int radioId = confirmImag.getCheckedRadioButtonId();
        btnconfirm = (RadioButton) findViewById(radioId);
        int valor = 0;

        areaConhec  = Integer.parseInt(edtAreaConhec.getText().toString());
        anoAplic    = edtAnoAplic.getText().toString();
        enunciado   = edtEnunciado.getText().toString();
        textoApoio  = edtTextoApoio.getText().toString();
        confirmSN   = btnconfirm.getText().toString();
        endImagem   = edtEndImagem.getText().toString();
        opcaoA      = edtOpcaoA.getText().toString();
        opcaoB      = edtOpcaoB.getText().toString();
        opcaoC      = edtOpcaoC.getText().toString();
        opcaoD      = edtOpcaoD.getText().toString();
        opcaoE      = edtOpcaoE.getText().toString();
        resposta    = edtResposta.getText().toString();
        coment      = edtComent.getText().toString();

        questao = new Questao();

        questao.setIdAreaConhec(areaConhec);
        questao.setAnoAplic(anoAplic);
        questao.setEnunciado(enunciado);
        questao.setTextoApoio(textoApoio);
        questao.setConfirmImag(confirmSN);
        questao.setEndImagem(endImagem);
        questao.setOpcaoA(opcaoA);
        questao.setOpcaoB(opcaoB);
        questao.setOpcaoC(opcaoC);
        questao.setOpcaoD(opcaoD);
        questao.setOpcaoE(opcaoE);
        questao.setRespostaGab(resposta);
        questao.setConfirmComent(comentSN);
        questao.setComentQuest(coment);
        questao.setValorQuest(valor);

        bdQuestao = new BDQuestao(this);

        bdQuestao.inserirQuestao(questao);


        Intent it = new Intent(CadQuestaoActivity.this, MainActivity.class);
        startActivity(it);
        finish();

    }

}
