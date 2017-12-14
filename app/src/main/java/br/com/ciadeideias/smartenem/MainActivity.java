package br.com.ciadeideias.smartenem;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bluejamesbond.text.DocumentView;
import com.bluejamesbond.text.hyphen.DefaultHyphenator;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import br.com.ciadeideias.smartenem.bancodados.BDGrafico;
import br.com.ciadeideias.smartenem.bancodados.BDQuestao;
import br.com.ciadeideias.smartenem.model.Grafico;
import br.com.ciadeideias.smartenem.model.Questao;


public class MainActivity extends AppCompatActivity {
    private Questao questao;
    private Questao questao1;
    private BDQuestao bdQuestao;
    private DocumentView documentView;
    private TextView tvOpcoes;
    private ImageView imagem;
    int idBusca;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("SmartEnem");
        toolbar.setLogo(R.mipmap.ic_launcher);
        documentView = (DocumentView) findViewById(R.id.teste1);
        tvOpcoes = (TextView) findViewById(R.id.tv_opcoes);
        imagem = (ImageView) findViewById(R.id.imagem);

        bdQuestao = new BDQuestao(this);

        questao1 = bdQuestao.buscaQuestaoPorId(164);


        documentView.setText(questao1.getEnunciado());
        documentView.getDocumentLayoutParams().setHyphenator(DefaultHyphenator.getInstance(DefaultHyphenator.HyphenPattern.PT));
        documentView.getDocumentLayoutParams().setHyphenated(false);

        //String opcoes = "\n"+questao1.getOpcaoA()+" -\n "+questao1.getOpcaoB()+" -\n "+questao1.getOpcaoC();





        //Script para Imagem

        InputStream stream;

        try {
            if(questao1.getEndImagem() != null){
                stream = this.getResources().getAssets().open(questao1.getEndImagem());
                Bitmap imagemQuest = BitmapFactory.decodeStream(stream);
                //imagem.setImageBitmap(imagemQuest);
            }else{

            }
        }catch (IOException e){
            e.printStackTrace();
        }
        //Fim do script da imagem

        //Inicio ainda no on create do botão que vai gravar os dados dos graficos

        Button buttonGraf = (Button) findViewById(R.id.btn_grafico);

        buttonGraf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        BDGrafico bdGrafico = new BDGrafico(this);

        int qtdQuestao = 15;
        int respCerta = 10;
        int respErrada = 5;
        String JTF_data = (new SimpleDateFormat("dd/MM/yyyy").format(new Date(System.currentTimeMillis())));
        String JTF_hora = (new SimpleDateFormat("HH:mm:ss").format(new Date(System.currentTimeMillis())));

        int ptsSimulCompac = 200;
        int ptsSimulComple = 500;
        int tempo =  1800000;

        /*for (int i = 0; i<30; i++){
            Grafico menu_graf = new Grafico();
            int x = i+1;
            int y = x * 2;

            Calendar calendarInicial = Calendar.getInstance();//data é a sua data
            Date d = new Date(System.currentTimeMillis());
            calendarInicial.setTime(d);
            calendarInicial.add(Calendar.DAY_OF_MONTH, -i);
            SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");

            String data = dataFormatada.format(calendarInicial.getTime()).toString();

            menu_graf.setAreaNome("Area Teste");
            menu_graf.setSimulCompacArea("Area"+y);
            menu_graf.setDataRealiz(data);
            menu_graf.setQtdQuest(qtdQuestao);
            menu_graf.setRespCerta(respCerta);
            menu_graf.setRespErrada(respErrada);
            menu_graf.setPtsSimulCompac(ptsSimulCompac);
            menu_graf.setPtsSimulComple(ptsSimulComple);
            menu_graf.setTempAtivo(tempo);

            bdGrafico.novoGrafico(menu_graf);

            qtdQuestao += 10;
            respCerta += 5;
            respErrada += 5;
            ptsSimulCompac += 100;
            ptsSimulComple += 125;
            tempo += 900000;

        }*/
        Grafico grafVolta = new Grafico();

        grafVolta = bdGrafico.buscarGrafico(8);

        String tempoVolta;

        int ms = grafVolta.getTempAtivo();
        int segundos, minutos, horas;

        segundos = ( ms / 1000 ) % 60;
        minutos  = ( ms / 60000 ) % 60;     // 60000   = 60 * 1000
        horas    = ms / 3600000;            // 3600000 = 60 * 60 * 1000
        tempoVolta =  String.format( "%02d:%02d:%02d", horas, minutos,segundos );

        String opcoes = "Data: "+grafVolta.getDataRealiz().toString()+"\n"
                +"Tempo: "+tempoVolta+"\n"
                +"Area Nome: "+grafVolta.getAreaNome().toString()+"\n"
                +"Simul Compac: "+grafVolta.getSimulCompacArea().toString()+"\n"
                +"Qtd Questão: "+grafVolta.getQtdQuest()+"\n"
                +"Resp Certa: "+grafVolta.getRespCerta()+"\n"
                +"Resp Err: "+grafVolta.getRespErrada()+"\n"
                +"Pts Compac: "+grafVolta.getPtsSimulCompac()+"\n"
                +"Pts Comple: "+grafVolta.getPtsSimulComple()+"\n"
                +"Id Graf: "+grafVolta.getIdGrafico();

        tvOpcoes.setText(opcoes);
    }

    public void novaQuestao(View view){
        Intent cadQuest = new Intent(MainActivity.this, MetasActivity.class);
        startActivity(cadQuest);
        finish();
    }
}
