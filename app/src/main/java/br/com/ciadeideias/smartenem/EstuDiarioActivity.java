package br.com.ciadeideias.smartenem;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bluejamesbond.text.DocumentView;
import com.bluejamesbond.text.hyphen.DefaultHyphenator;
import com.github.chrisbanes.photoview.PhotoView;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import br.com.ciadeideias.smartenem.bancodados.BDDisciplina;
import br.com.ciadeideias.smartenem.bancodados.BDEstudo;
import br.com.ciadeideias.smartenem.bancodados.BDQuestao;
import br.com.ciadeideias.smartenem.model.Estudo;
import br.com.ciadeideias.smartenem.model.Questao;


public class EstuDiarioActivity extends AppCompatActivity
            implements View.OnClickListener {

    Dialog myDialog;

    private Questao questao1, questao2;
    private BDQuestao bdQuestao;
    private BDEstudo bdEstudo;
    private DocumentView documentView, dvComent;
    private TextView tvDados;
    private RadioGroup selectOpcoes;
    private RadioButton opcaoA, opcaoB, opcaoC, opcaoD, opcaoE, respUser;
    InputStream stream;
    int idEstudoAtivo, selectedId, idQuestao;
    String resposta, respostaUser, dados, disciplina, totQuest, totAcert, totErros;

    PhotoView imagemR, imagemPop, imagemPopRes;

    int totalQuestoes;
    int totalAcertos;
    int totalErros;
    int totalAcertosN;
    int totalErrosN;
    int totalQuestoesN;

    String tempoAtivo, horaEstudo;

    Calendar data = Calendar.getInstance();

    Long tempo, horaFinal, tempoN;

    Estudo estudoAtivo = new Estudo();

    //String JTF_hora = (new SimpleDateFormat("HH:mm:ss").format(new Date(System.currentTimeMillis())));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Pega a intent de outra activity
        Intent it = getIntent();

        //Recuperei a string da outra activity
        disciplina = it.getStringExtra("disciplina");
        horaEstudo = it.getStringExtra("hora_estudo");

        setContentView(R.layout.activity_estudiario);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.mipmap.ic_launcher);

        toolbar.setTitle(R.string.estudo_title);

        TextView tvTituloGraf = (TextView) findViewById(R.id.tv_tit_estudo_diario);
        tvTituloGraf.setText("Disciplina "+ disciplina);


        idEstudoAtivo = testarEstudo(disciplina);

        Log.d("claudio", "quando já existe o estudo o que o teste me devolve é um estudo "+ idEstudoAtivo);

        if (horaEstudo != null){
            BDEstudo bdEstudoAtualizaHora = new BDEstudo(this);
            Estudo estudoAtualizaInicio = new Estudo();

            estudoAtualizaInicio.setIdEstudo(idEstudoAtivo);
            estudoAtualizaInicio.setHoraInicio(horaEstudo);

            bdEstudoAtualizaHora.atualizarHoraInicio(estudoAtualizaInicio);
            Log.d("claudio", "atualizou o inicio do Estudo");
        }

        BDEstudo bdBuscarEstudoId = new BDEstudo(this);
        estudoAtivo = bdBuscarEstudoId.buscarEstudo(idEstudoAtivo);

        Log.d("claudio", "Trouxe do Banco o estudo com a disciplina "+estudoAtivo.getDisciplinaNome());

        idEstudoAtivo = estudoAtivo.getIdEstudo();
        totalQuestoes = estudoAtivo.getQtdQuest();
        totalAcertos = estudoAtivo.getRespCerta();
        totalErros = estudoAtivo.getRespErrada();

            BDDisciplina bdDisciplina = new BDDisciplina(this);

            final int idDisciplina = bdDisciplina.buscarId(disciplina);

            documentView = (DocumentView) findViewById(R.id.texto_questao_estudo);
            selectOpcoes = (RadioGroup) findViewById(R.id.select_opcoes);
            //imagem = (ImageView) findViewById(R.id.imagem);
            tvDados = (TextView) findViewById(R.id.tv_dados_questao);
            imagemR = (PhotoView) findViewById(R.id.imagem);

            bdQuestao = new BDQuestao(this);

            questao1 = bdQuestao.buscaQuestaoPorIdDisc(idDisciplina);

            Log.d("claudio", "A questão que vem do banco  é: "+ questao1.getEnunciado());

            idQuestao = questao1.getIdQuestao();

            Log.d("claudio", "O id da questão é: "+idQuestao);



            dados = "Questão do enem ano " + questao1.getAnoAplic() + " id " + questao1.getIdQuestao();


            tvDados.setText(dados);

            documentView.setText(questao1.getEnunciado());
            documentView.getDocumentLayoutParams().setHyphenator(DefaultHyphenator.getInstance(DefaultHyphenator.HyphenPattern.PT));
            documentView.getDocumentLayoutParams().setHyphenated(false);

            opcaoA = (RadioButton) findViewById(R.id.opcao_a);
            opcaoA.setText(questao1.getOpcaoA());
            opcaoB = (RadioButton) findViewById(R.id.opcao_b);
            opcaoB.setText(questao1.getOpcaoB());
            opcaoC = (RadioButton) findViewById(R.id.opcao_c);
            opcaoC.setText(questao1.getOpcaoC());
            opcaoD = (RadioButton) findViewById(R.id.opcao_d);
            opcaoD.setText(questao1.getOpcaoD());
            opcaoE = (RadioButton) findViewById(R.id.opcao_e);
            opcaoE.setText(questao1.getOpcaoE());

            resposta = questao1.getRespostaGab().toUpperCase();

            //Script para Imagem
            try {
                if (questao1.getEndImagem() != null) {
                    stream = this.getResources().getAssets().open(questao1.getEndImagem());
                    Bitmap imagemQuest = BitmapFactory.decodeStream(stream);
                    imagemR.setImageBitmap(imagemQuest);
                    imagemR.setMinimumScale(0.5F);
                    imagemR.setMaximumScale(5.75F);
                    imagemR.setMediumScale(1.0F);
                } else {
                }
            } catch (IOException e) {

                e.printStackTrace();
            }
            //Fim do script da imagem


        //Inicio ainda no on create do botão que sai do estudo e volta para a lista

        Button buttonResp = (Button) findViewById(R.id.btn_enviar);
        buttonResp.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {

                if (selectOpcoes.getCheckedRadioButtonId() == -1){
                    Toast.makeText(EstuDiarioActivity.this, "Selecione uma opção", Toast.LENGTH_SHORT).show();
                }
                else {
                    int idTransf = idQuestao;
                    Log.d("claudio", "O id da questão é "+idTransf+" chegou no botão da resposta");
                    ShowPopup(v.findViewById(R.layout.custom_popup));
                }

            }
        });


        Button buttonSair = (Button) findViewById(R.id.btn_sair);

        buttonSair.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {

                BDEstudo bdEstudoAtualizaTempo = new BDEstudo(EstuDiarioActivity.this);
                Estudo estudoAtualizaTempo = new Estudo();

                //Atualizar o tempo de estudo
                horaFinal = data.getTimeInMillis();

                BDEstudo bdEstudoAtualizaTempo2 = new BDEstudo(EstuDiarioActivity.this);

                estudoAtivo = bdEstudoAtualizaTempo2.buscarEstudo(idEstudoAtivo);

                String horaInicio = estudoAtivo.getHoraInicio();
                String tempoBD = estudoAtivo.getTempAtivo();

                Log.d("claudio", "A string hora de inicio que vem do banco é: "+ horaInicio);
                Log.d("claudio", "A String de tempo ativo que vem do banco é: "+tempoBD);

                if (tempoBD == "0") {

                    Long horaInicial = Long.valueOf(horaInicio);
                    tempo = (horaFinal - horaInicial);
                    tempoAtivo = tempo.toString();
                    //Long tempoN = Long.valueOf(tempoAtivo);

                    estudoAtualizaTempo.setIdEstudo(idEstudoAtivo);
                    estudoAtualizaTempo.setTempAtivo(tempoAtivo);

                    bdEstudoAtualizaTempo.atualizarTempoEstudo(estudoAtualizaTempo);

                    Log.d("claudio", "atualizou o primeiro estudo! Tempo gravado é: "+tempoAtivo);

                }else{

                    Long horaInicial = Long.valueOf(horaInicio);
                    Long tempoNovo = (horaFinal - horaInicial);
                    Long tempoVelho = Long.valueOf(tempoBD);
                    tempo = tempoVelho + tempoNovo;
                    tempoAtivo = tempo.toString();
                    //Long tempoN = Long.valueOf(tempoAtivo);

                    estudoAtualizaTempo.setIdEstudo(idEstudoAtivo);
                    estudoAtualizaTempo.setTempAtivo(tempoAtivo);

                    bdEstudoAtualizaTempo.atualizarTempoEstudo(estudoAtualizaTempo);

                    Log.d("claudio", "atualizou sequencia de estudo! Tempo gravado é: "+tempoAtivo);

                }

                ShowPopupResumo(v.findViewById(R.layout.custom_popup_resumo_estudo));
            }
        });

    }

    @Override
    public void onBackPressed() {

        Toast.makeText(EstuDiarioActivity.this, "Para sair do estudo use o botão SAIR", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onClick(View v) {


    }

    public void ShowPopup(View v) {

        Log.d("claudio", "começou o popup da resposta");

        final int idQuestaoPopup = idQuestao;

        Log.d("claudio", "o id da questão no popup é "+ idQuestaoPopup);

        myDialog = new Dialog(this);
        TextView txtclose;
        Button btnComent, btnProxima;
        myDialog.setContentView(R.layout.custom_popup);
        txtclose =(TextView) myDialog.findViewById(R.id.txtclose);
        txtclose.setText("RESPOSTA DA QUESTÃO");
        TextView txtacerto  = myDialog.findViewById(R.id.texto_acerto);
        TextView txtResposta = myDialog.findViewById(R.id.texto_resposta);
        imagemPop = (PhotoView) myDialog.findViewById(R.id.imagem_resp);
        TextView txtTotalQuestoes = myDialog.findViewById(R.id.txt_total_questoes);
        TextView txtTotalAcertos = myDialog.findViewById(R.id.txt_total_acertos);
        TextView txtTotalErros = myDialog.findViewById(R.id.txt_total_erros);

        selectedId = selectOpcoes.getCheckedRadioButtonId();

        respUser = (RadioButton) findViewById(selectedId);

        respostaUser = respUser.getText().toString();

        String letra = respostaUser.substring(0, 1).toUpperCase();

        if (letra.equals(resposta)) {
            imagemPop.setImageResource(R.drawable.resp_certa);
            txtacerto.setText("Parabéns! Sua resposta está certa ");
            txtResposta.setText("A Resposta é a Opção "+ resposta);

            totalAcertosN = totalAcertos + 1;
            totalErrosN = totalErros;
            totalQuestoesN = totalAcertosN + totalErrosN;

            txtTotalQuestoes.setText(""+totalQuestoesN);
            txtTotalAcertos.setText(""+totalAcertosN);
            txtTotalErros.setText(""+totalErrosN);

        } else {
            imagemPop.setImageResource(R.drawable.resp_errada);
            txtacerto.setText("Desta vez você Errou! a sua opção foi "+ letra);
            txtResposta.setText("A resposta certa é a opção: "+resposta);

            totalAcertosN = totalAcertos;
            totalErrosN = totalErros +1;
            totalQuestoesN = totalAcertosN + totalErrosN;

            txtTotalQuestoes.setText(""+totalQuestoesN);
            txtTotalAcertos.setText(""+totalAcertosN);
            txtTotalErros.setText(""+totalErrosN);

        }

        btnComent = (Button) myDialog.findViewById(R.id.btncoment);


        btnProxima = (Button) myDialog.findViewById(R.id.btnproximo);
        btnProxima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String aux = disciplina;
                String horaEstudo = null;

                BDEstudo bdEstudoAtualiza = new BDEstudo(EstuDiarioActivity.this);

                Estudo estudoAtualiza = new Estudo();
                estudoAtualiza.setIdEstudo(idEstudoAtivo);
                estudoAtualiza.setQtdQuest(totalQuestoesN);
                estudoAtualiza.setRespCerta(totalAcertosN);
                estudoAtualiza.setRespErrada(totalErrosN);

                bdEstudoAtualiza.atualizarQuestEstudo(estudoAtualiza);

               Intent it = new Intent(EstuDiarioActivity.this, EstuDiarioActivity.class);
               it.putExtra("disciplina", aux);
               it.putExtra("hora_estudo", horaEstudo);
               startActivity(it);
               myDialog.dismiss();

            }
        });

        btnComent.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
                ShowPopupComent(view.findViewById(R.layout.custom_popup_comentario_estudo));
            }
        });

        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }


    public void ShowPopupResumo(View v) {

        myDialog = new Dialog(this);
        TextView txtResumoEst;
        Button btnSairEstudo, btnContinuarEstudo;
        myDialog.setContentView(R.layout.custom_popup_resumo_estudo);
        txtResumoEst =(TextView) myDialog.findViewById(R.id.txtresumo_estudo);
        txtResumoEst.setText("Resumo do Estudo - Disciplina: "+disciplina);

        TextView txtResumo1  = myDialog.findViewById(R.id.texto_resumo1);
        TextView txtResumo2 = myDialog.findViewById(R.id.texto_resumo2);
        TextView txtResumo3 = myDialog.findViewById(R.id.texto_resumo3);

        imagemPopRes = (PhotoView) myDialog.findViewById(R.id.imagem_emoji);

        TextView txtTotalQuestoesResp = myDialog.findViewById(R.id.txt_total_questoes_resp);
        TextView txtTotalAcertosResp = myDialog.findViewById(R.id.txt_total_acertos_resp);
        TextView txtTotalErrosResp = myDialog.findViewById(R.id.txt_total_erros_resp);

        BDEstudo bdEstudoResumo = new BDEstudo(this);

        Estudo estudoResumo = new Estudo();

        estudoResumo = bdEstudoResumo.buscarEstudo(idEstudoAtivo);

        Log.d("claudio", "o id que vem do banco  no popup show "+ idEstudoAtivo);

        int questoesRes = estudoResumo.getQtdQuest();
        int acertosRes = estudoResumo.getRespCerta();
        int errosRes   = estudoResumo.getRespErrada();
        float resultadoAcert;
        float resultadoErros;

        String tempoAtivoN = estudoResumo.getTempAtivo();

        tempoN = Long.valueOf(tempoAtivoN);

        int ms = tempoN.intValue();
        int segundos, minutos, horas;

        segundos = ( ms / 1000 ) % 60;
        minutos  = ( ms / 60000 ) % 60;     // 60000   = 60 * 1000
        horas    = ms / 3600000;            // 3600000 = 60 * 60 * 1000

        String tempodeEstudoRes =  String.format( "%02d:%02d:%02d", horas, minutos,segundos);

        if (questoesRes == 0) {

            resultadoAcert = 0;
            resultadoErros = 0;

        }else {
            resultadoAcert = (acertosRes * 100) / questoesRes;
            resultadoErros = (errosRes * 100) / questoesRes;
        }



        if (resultadoAcert > resultadoErros) {
            String textoResumo1 = "Parabéns! Você obteve um aproveitamento" + "\n" +
                    "positivo na disciplina "+ estudoResumo.getDisciplinaNome();
            String textoResumo2 = "Você alcançou  "+ resultadoAcert +"% de acertos e \n" + resultadoErros+"% de erros!";

            String textoResumo3 = "Hoje você já dedicou " + tempodeEstudoRes + "do seu tempo para esta disciplina!";
            imagemPopRes.setImageResource(R.drawable.feliz);
            txtResumo1.setText(textoResumo1);
            txtResumo2.setText(textoResumo2);
            txtResumo3.setText(textoResumo3);
            txtTotalQuestoesResp.setText(""+questoesRes);
            txtTotalAcertosResp.setText(""+acertosRes);
            txtTotalErrosResp.setText(""+errosRes);

        } else if (resultadoAcert < resultadoErros){
            imagemPopRes.setImageResource(R.drawable.triste);
            txtResumo1.setText("Que pena! Você obteve um aproveitamento" + "\n" +
                    "baixo na disciplina "+ estudoResumo.getDisciplinaNome());
            txtResumo2.setText("Você alcançou  "+ resultadoAcert +"% de acertos e \n" + resultadoErros+"% de erros!");
            String textoResumo3 = "Hoje você já dedicou " + tempodeEstudoRes + "do seu tempo para esta disciplina!";
            txtTotalQuestoesResp.setText(""+questoesRes);
            txtTotalAcertosResp.setText(""+acertosRes);
            txtTotalErrosResp.setText(""+errosRes);

        }else if (resultadoAcert == resultadoErros){
            imagemPopRes.setImageResource(R.drawable.serio);
            txtResumo1.setText("Quase! Você obteve um aproveitamento" + "\n" +
                    "médio na disciplina "+ estudoResumo.getDisciplinaNome());
            txtResumo2.setText("Você alcançou  "+ resultadoAcert +"% de acertos e \n" + resultadoErros+"% de erros!");
            String textoResumo3 = "Hoje você já dedicou " + tempodeEstudoRes + "do seu tempo para esta disciplina!";
            txtTotalQuestoesResp.setText(""+questoesRes);
            txtTotalAcertosResp.setText(""+acertosRes);
            txtTotalErrosResp.setText(""+errosRes);
        }

        btnContinuarEstudo = (Button) myDialog.findViewById(R.id.btn_continuar_est);

        btnSairEstudo = (Button) myDialog.findViewById(R.id.btn_sair_estudo);


        btnSairEstudo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // BDEstudo bd7 = new BDEstudo(EstuDiarioActivity.this);
               // bd7.limparTabela("estudos");
                Intent it = new Intent(EstuDiarioActivity.this, EstudoListaActivity.class);
                startActivity(it);
                finish();
            }
        });

        btnContinuarEstudo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String aux = disciplina;
                String horaEstudo = null;

                Intent it = new Intent(EstuDiarioActivity.this, EstuDiarioActivity.class);
                it.putExtra("disciplina", aux);
                it.putExtra("hora_estudo", horaEstudo);
                startActivity(it);
                myDialog.dismiss();

            }
        });

        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }


    public int testarEstudo(String disciplina){

        Estudo estudo = new Estudo();

        int idEstudo;

        String dataEstudo = (new SimpleDateFormat("dd/MM/yyyy").format(new Date(System.currentTimeMillis())));

        BDEstudo bdbuscarEstudo = new BDEstudo(EstuDiarioActivity.this);

        estudo = bdbuscarEstudo.buscarEstudoPorDisciplina(disciplina, dataEstudo);

        if (!disciplina.equals(estudo.getDisciplinaNome()) && !dataEstudo.equals(estudo.getDataRealiz())) {

            Long horaInicial = data.getTimeInMillis();
            String hora = horaInicial.toString();
            Estudo estudo1 = new Estudo();

            BDEstudo bdCriacaoEstudo = new BDEstudo(EstuDiarioActivity.this);

            estudo1.setDisciplinaNome(disciplina);
            estudo1.setDataRealiz(dataEstudo);
            estudo1.setQtdQuest(0);
            estudo1.setRespCerta(0);
            estudo1.setRespErrada(0);
            estudo1.setHoraInicio(hora);
            estudo1.setTempAtivo("0");

            bdCriacaoEstudo.novoEstudo(estudo1);


            BDEstudo bdBuscarEstudo2 = new BDEstudo(EstuDiarioActivity.this);
            Estudo estudo2 = new Estudo();
            estudo2 = bdBuscarEstudo2.buscarEstudoPorDisciplina(disciplina, dataEstudo);

            idEstudo = estudo2.getIdEstudo();

            return  idEstudo;

        } else {

            idEstudo = estudo.getIdEstudo();

            return idEstudo;

        }

    }

    public void ShowPopupComent(View v) {

        Log.d("claudio", "começou o popup do comentario");
        Log.d("claudio", "o id da questão no popcoment é: "+ idQuestao);

        myDialog = new Dialog(this);
        TextView txtcomentTitle;
        Button btnVoltar;
        myDialog.setContentView(R.layout.custom_popup_comentario_estudo);
        txtcomentTitle =(TextView) myDialog.findViewById(R.id.txtcoment_title);
        txtcomentTitle.setText("APRENDENDO UM POUCO MAIS");

        BDQuestao bdBuscaComentario = new BDQuestao(EstuDiarioActivity.this);

        questao2 = bdBuscaComentario.buscaQuestaoPorId(idQuestao);

        Log.d("claudio", " a questão que vem do banco é "+ questao2.getComentQuest());

        dvComent = (DocumentView)myDialog.findViewById(R.id.texto_coment_questao);

        dvComent.setText(questao2.getComentQuest());
        dvComent.getDocumentLayoutParams().setHyphenator(DefaultHyphenator.getInstance(DefaultHyphenator.HyphenPattern.PT));
        dvComent.getDocumentLayoutParams().setHyphenated(false);

        String inforComent = "Resolução da questão Enem do ano "+questao2.getAnoAplic();
        TextView tvInforComent;

        tvInforComent = (TextView)myDialog.findViewById(R.id.texto_coment_infor);
        tvInforComent.setText(inforComent);

        btnVoltar = (Button) myDialog.findViewById(R.id.btn_voltar);

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String aux = disciplina;
                String horaEstudo = null;

                BDEstudo bdEstudoAtualiza = new BDEstudo(EstuDiarioActivity.this);

                Estudo estudoAtualiza = new Estudo();
                estudoAtualiza.setIdEstudo(idEstudoAtivo);
                estudoAtualiza.setQtdQuest(totalQuestoesN);
                estudoAtualiza.setRespCerta(totalAcertosN);
                estudoAtualiza.setRespErrada(totalErrosN);

                bdEstudoAtualiza.atualizarQuestEstudo(estudoAtualiza);

                Intent it = new Intent(EstuDiarioActivity.this, EstuDiarioActivity.class);
                it.putExtra("disciplina", aux);
                it.putExtra("hora_estudo", horaEstudo);
                startActivity(it);
                myDialog.dismiss();

            }
        });

        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }



}
