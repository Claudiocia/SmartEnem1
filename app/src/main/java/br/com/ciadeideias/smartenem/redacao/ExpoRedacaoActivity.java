package br.com.ciadeideias.smartenem.redacao;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bluejamesbond.text.DocumentView;
import com.bluejamesbond.text.hyphen.DefaultHyphenator;
import com.bluejamesbond.text.style.TextAlignment;
import com.github.chrisbanes.photoview.PhotoView;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import br.com.ciadeideias.smartenem.R;
import br.com.ciadeideias.smartenem.bancodados.BDEstudo;
import br.com.ciadeideias.smartenem.bancodados.BDRedacao;
import br.com.ciadeideias.smartenem.model.Estudo;
import br.com.ciadeideias.smartenem.model.Redacao;


public class ExpoRedacaoActivity extends AppCompatActivity
            implements View.OnClickListener {



    private BDRedacao bdRedacao;
    InputStream stream;
    int idEstudoAtivo, idRedacao;
    String disciplina;

    Redacao redacao;

    int totalQuestoes = 0;
    int totalAcertos = 0;
    int totalErros = 0;
    LinearLayout linear;

    String tempoAtivo, horaEstudo, dados;

    Calendar data = Calendar.getInstance();

    Long tempo, horaFinal, tempoN;

    Estudo estudoAtivo = new Estudo();

    //String JTF_hora = (new SimpleDateFormat("HH:mm:ss").format(new Date(System.currentTimeMillis())));

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Pega a intent de outra activity
        Intent it = getIntent();

        //Recuperei a string da outra activity
        disciplina = "Redação";
        horaEstudo = it.getStringExtra("hora_estudo");
        idRedacao = Integer.parseInt(it.getStringExtra("id_redacao"));


        setContentView(R.layout.activity_expo_redacao);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.mipmap.ic_launcher);

        toolbar.setTitle(R.string.titulo_praticared);

        bdRedacao = new BDRedacao(this);
        redacao = bdRedacao.buscaPorId(idRedacao);

        idEstudoAtivo = testarEstudo(disciplina);

        if (horaEstudo != null){
            BDEstudo bdEstudoAtualizaHora = new BDEstudo(this);
            Estudo estudoAtualizaInicio = new Estudo();

            estudoAtualizaInicio.setIdEstudo(idEstudoAtivo);
            estudoAtualizaInicio.setHoraInicio(horaEstudo);

            bdEstudoAtualizaHora.atualizarHoraInicio(estudoAtualizaInicio);
        }

        BDEstudo bdBuscarEstudoId = new BDEstudo(this);
        estudoAtivo = bdBuscarEstudoId.buscarEstudo(idEstudoAtivo);

        idEstudoAtivo = estudoAtivo.getIdEstudo();

        linear = (LinearLayout) findViewById(R.id.expo_reda);

        TextView tvTituloGraf = new TextView(this);
        TextView tvDados = new TextView(this);;
        DocumentView dvApres = new DocumentView(this);

        tvTituloGraf.setText(redacao.getTitulo());
        tvTituloGraf.setTextAppearance(R.style.TextViewTituloGeral);
        tvTituloGraf.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        tvDados.setText("Tema Enem ano: "+redacao.getAnoRed());
        tvDados.setTextAppearance(R.style.TextViewDados);

        dvApres.setText(redacao.getApresent());
        dvApres.getDocumentLayoutParams().setHyphenator(DefaultHyphenator.getInstance(DefaultHyphenator.HyphenPattern.PT));
        dvApres.getDocumentLayoutParams().setHyphenated(false);
        dvApres.getDocumentLayoutParams().setInsetPaddingLeft(15);
        dvApres.getDocumentLayoutParams().setTextAlignment(TextAlignment.JUSTIFIED);
        dvApres.getDocumentLayoutParams().setInsetPaddingTop(10);
        dvApres.getDocumentLayoutParams().setInsetPaddingBottom(10);
        dvApres.getDocumentLayoutParams().setInsetPaddingRight(15);
        dvApres.getDocumentLayoutParams().setTextSize(1, 16);
        dvApres.getDocumentLayoutParams().setTextColor(R.color.bck_dicas);
        dvApres.getDocumentLayoutParams().setTextFakeBold(true);

        linear.addView(tvTituloGraf);
        linear.addView(tvDados);
        linear.addView(dvApres);

        //Trazendo o Titulo 1
        if (redacao.getTit1() != null){
            String tit1 = redacao.getTit1();
            TextView tvtitulo1 = new TextView(this);
            tvtitulo1.setText(tit1);
            tvtitulo1.setTextAppearance(R.style.TextViewTituloTexto);
            tvtitulo1.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            linear.addView(tvtitulo1);
        }

        //trazendo o subtitulo 1
        if (redacao.getSubtit1() != null){

            String sub1 = redacao.getSubtit1();
            DocumentView dvSub1 = new DocumentView(this);
            dvSub1.setText(sub1);
            dvSub1.getDocumentLayoutParams().setHyphenator(DefaultHyphenator.getInstance(DefaultHyphenator.HyphenPattern.PT));
            dvSub1.getDocumentLayoutParams().setHyphenated(false);
            dvSub1.getDocumentLayoutParams().setInsetPaddingLeft(15);
            dvSub1.getDocumentLayoutParams().setTextAlignment(TextAlignment.JUSTIFIED);
            dvSub1.getDocumentLayoutParams().setInsetPaddingTop(10);
            dvSub1.getDocumentLayoutParams().setInsetPaddingBottom(10);
            dvSub1.getDocumentLayoutParams().setInsetPaddingRight(15);
            dvSub1.getDocumentLayoutParams().setTextSize(1, 14);
            dvSub1.getDocumentLayoutParams().setTextColor(R.color.bck_dicas);
            dvSub1.getDocumentLayoutParams().setTextFakeBold(true);
            linear.addView(dvSub1);
        }

        //compondo e exibindo as imagens do texto 1
        if (redacao.getImgEnd1() != null) {

            if (redacao.getImgEnd1().contains(",")) {
                String endereco = redacao.getImgEnd1();
                String enderecos[] = new String[]{};
                enderecos = endereco.split(",");


                int i = 0;
                while (i < enderecos.length) {

                    String end = enderecos[i];

                    try {
                        stream = this.getResources().getAssets().open(end);
                        Bitmap imagem1 = BitmapFactory.decodeStream(stream);
                        Bitmap imagemRedm = redimensionarImagem(imagem1);
                        PhotoView img1 = new PhotoView(this);
                        img1.setImageBitmap(imagemRedm);
                        img1.setZoomable(true);
                        linear.addView(img1);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    i++;
                }

            }else{

                    try {
                        stream = this.getResources().getAssets().open(redacao.getImgEnd1());
                        Bitmap imagem1 = BitmapFactory.decodeStream(stream);
                        Bitmap imagemRedm = redimensionarImagem(imagem1);
                        PhotoView img1 = new PhotoView(this);
                        img1.setImageBitmap(imagemRedm);
                        img1.setZoomable(true);
                        linear.addView(img1);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        }

        //trazendo o texto do titulo1
        if (redacao.getTxt1() != null){
            String txt1 = redacao.getTxt1();
            DocumentView dvTxt1 = new DocumentView(this);
            dvTxt1.setText(txt1);
            dvTxt1.getDocumentLayoutParams().setHyphenator(DefaultHyphenator.getInstance(DefaultHyphenator.HyphenPattern.PT));
            dvTxt1.getDocumentLayoutParams().setHyphenated(false);
            dvTxt1.getDocumentLayoutParams().setInsetPaddingLeft(15);
            dvTxt1.getDocumentLayoutParams().setTextAlignment(TextAlignment.JUSTIFIED);
            dvTxt1.getDocumentLayoutParams().setInsetPaddingTop(10);
            dvTxt1.getDocumentLayoutParams().setInsetPaddingBottom(10);
            dvTxt1.getDocumentLayoutParams().setInsetPaddingRight(15);
            dvTxt1.getDocumentLayoutParams().setTextSize(1, 16);
            dvTxt1.getDocumentLayoutParams().setTextColor(R.color.bck_dicas);
            dvTxt1.getDocumentLayoutParams().setTextFakeBold(true);
            linear.addView(dvTxt1);
        }

        //trazendo assinatura do texto
        if (redacao.getAss1() != null){
            String ass1 = redacao.getAss1();

            TextView tvAss1 = new TextView(this);
            tvAss1.setText(ass1);
            tvAss1.setTextAppearance(R.style.TextViewAssinatura);
            tvAss1.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_END);
            linear.addView(tvAss1);
        }

    // !!!!!!!!!!------- FIM DO TEXTO 1 ----------!!!!!!!!!!!!!!

        // !!!!!!!!!!------- Inicio DO TEXTO 2 ----------!!!!!!!!!!!!!!

        //Trazendo o Titulo 2
        if (redacao.getTit2() != null){
            String tit2 = redacao.getTit2();
            TextView tvtitulo2 = new TextView(this);
            tvtitulo2.setText(tit2);
            tvtitulo2.setTextAppearance(R.style.TextViewTituloTexto);
            tvtitulo2.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            linear.addView(tvtitulo2);
        }

        //trazendo o subtitulo 2
        if (redacao.getSubtit2() != null){

            String sub2 = redacao.getSubtit2();
            DocumentView dvSub2 = new DocumentView(this);
            dvSub2.setText(sub2);
            dvSub2.getDocumentLayoutParams().setHyphenator(DefaultHyphenator.getInstance(DefaultHyphenator.HyphenPattern.PT));
            dvSub2.getDocumentLayoutParams().setHyphenated(false);
            dvSub2.getDocumentLayoutParams().setInsetPaddingLeft(15);
            dvSub2.getDocumentLayoutParams().setTextAlignment(TextAlignment.JUSTIFIED);
            dvSub2.getDocumentLayoutParams().setInsetPaddingTop(10);
            dvSub2.getDocumentLayoutParams().setInsetPaddingBottom(10);
            dvSub2.getDocumentLayoutParams().setInsetPaddingRight(15);
            dvSub2.getDocumentLayoutParams().setTextSize(1, 14);
            dvSub2.getDocumentLayoutParams().setTextColor(R.color.bck_dicas);
            dvSub2.getDocumentLayoutParams().setTextFakeBold(true);
            linear.addView(dvSub2);
        }

        //compondo e exibindo as imagens do texto 2
        if (redacao.getImgEnd2() != null) {

            if (redacao.getImgEnd2().contains(",")) {
                String endereco = redacao.getImgEnd2();
                String enderecos[] = new String[]{};
                enderecos = endereco.split(",");


                int i = 0;
                while (i < enderecos.length) {

                    String end = enderecos[i];

                    try {
                        stream = this.getResources().getAssets().open(end);
                        Bitmap imagem2 = BitmapFactory.decodeStream(stream);
                        Bitmap imagemRedm2 = redimensionarImagem(imagem2);
                        PhotoView img2 = new PhotoView(this);
                        img2.setImageBitmap(imagemRedm2);
                        img2.setZoomable(true);
                        linear.addView(img2);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    i++;
                }

            }else{

                try {
                    stream = this.getResources().getAssets().open(redacao.getImgEnd2());
                    Bitmap imagem2 = BitmapFactory.decodeStream(stream);
                    Bitmap imagemRedm2 = redimensionarImagem(imagem2);
                    PhotoView img2 = new PhotoView(this);
                    img2.setImageBitmap(imagemRedm2);
                    img2.setZoomable(true);
                    linear.addView(img2);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        //trazendo o texto do titulo2
        if (redacao.getTxt2() != null){
            String txt2 = redacao.getTxt2();
            DocumentView dvTxt2 = new DocumentView(this);
            dvTxt2.setText(txt2);
            dvTxt2.getDocumentLayoutParams().setHyphenator(DefaultHyphenator.getInstance(DefaultHyphenator.HyphenPattern.PT));
            dvTxt2.getDocumentLayoutParams().setHyphenated(false);
            dvTxt2.getDocumentLayoutParams().setInsetPaddingLeft(15);
            dvTxt2.getDocumentLayoutParams().setTextAlignment(TextAlignment.JUSTIFIED);
            dvTxt2.getDocumentLayoutParams().setInsetPaddingTop(10);
            dvTxt2.getDocumentLayoutParams().setInsetPaddingBottom(10);
            dvTxt2.getDocumentLayoutParams().setInsetPaddingRight(15);
            dvTxt2.getDocumentLayoutParams().setTextSize(1, 16);
            dvTxt2.getDocumentLayoutParams().setTextColor(R.color.bck_dicas);
            dvTxt2.getDocumentLayoutParams().setTextFakeBold(true);
            linear.addView(dvTxt2);
        }

        //trazendo assinatura2 do texto
        if (redacao.getAss2() != null){
            String ass2 = redacao.getAss2();

            TextView tvAss2 = new TextView(this);
            tvAss2.setText(ass2);
            tvAss2.setTextAppearance(R.style.TextViewAssinatura);
            tvAss2.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_END);
            linear.addView(tvAss2);
        }

        // !!!!!!!!!!------- FIM DO TEXTO 2 ----------!!!!!!!!!!!!!!

        // !!!!!!!!!!------- Inicio DO TEXTO 3 ----------!!!!!!!!!!!!!!

        //Trazendo o Titulo 3
        if (redacao.getTit3() != null){
            String tit3 = redacao.getTit3();
            TextView tvtitulo3 = new TextView(this);
            tvtitulo3.setText(tit3);
            tvtitulo3.setTextAppearance(R.style.TextViewTituloTexto);
            tvtitulo3.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            linear.addView(tvtitulo3);
        }

        //trazendo o subtitulo 3
        if (redacao.getSubtit3() != null){

            String sub3 = redacao.getSubtit3();
            DocumentView dvSub3 = new DocumentView(this);
            dvSub3.setText(sub3);
            dvSub3.getDocumentLayoutParams().setHyphenator(DefaultHyphenator.getInstance(DefaultHyphenator.HyphenPattern.PT));
            dvSub3.getDocumentLayoutParams().setHyphenated(false);
            dvSub3.getDocumentLayoutParams().setInsetPaddingLeft(15);
            dvSub3.getDocumentLayoutParams().setTextAlignment(TextAlignment.JUSTIFIED);
            dvSub3.getDocumentLayoutParams().setInsetPaddingTop(10);
            dvSub3.getDocumentLayoutParams().setInsetPaddingBottom(10);
            dvSub3.getDocumentLayoutParams().setInsetPaddingRight(15);
            dvSub3.getDocumentLayoutParams().setTextSize(1, 14);
            dvSub3.getDocumentLayoutParams().setTextColor(R.color.bck_dicas);
            dvSub3.getDocumentLayoutParams().setTextFakeBold(true);
            linear.addView(dvSub3);
        }

        //compondo e exibindo as imagens do texto 3
        if (redacao.getImgEnd3() != null) {

            if (redacao.getImgEnd3().contains(",")) {
                String endereco = redacao.getImgEnd3();
                String enderecos[] = new String[]{};
                enderecos = endereco.split(",");


                int i = 0;
                while (i < enderecos.length) {

                    String end = enderecos[i];

                    try {
                        stream = this.getResources().getAssets().open(end);
                        Bitmap imagem3 = BitmapFactory.decodeStream(stream);
                        Bitmap imagemRedm3 = redimensionarImagem(imagem3);
                        PhotoView img3 = new PhotoView(this);
                        img3.setImageBitmap(imagemRedm3);
                        img3.setZoomable(true);
                        linear.addView(img3);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    i++;
                }

            }else{

                try {
                    stream = this.getResources().getAssets().open(redacao.getImgEnd3());
                    Bitmap imagem3 = BitmapFactory.decodeStream(stream);
                    Bitmap imagemRedm3 = redimensionarImagem(imagem3);
                    PhotoView img3 = new PhotoView(this);
                    img3.setImageBitmap(imagemRedm3);
                    img3.setZoomable(true);
                    linear.addView(img3);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        //trazendo o texto do titulo3
        if (redacao.getTxt3() != null){
            String txt3 = redacao.getTxt3();
            DocumentView dvTxt3 = new DocumentView(this);
            dvTxt3.setText(txt3);
            dvTxt3.getDocumentLayoutParams().setHyphenator(DefaultHyphenator.getInstance(DefaultHyphenator.HyphenPattern.PT));
            dvTxt3.getDocumentLayoutParams().setHyphenated(false);
            dvTxt3.getDocumentLayoutParams().setInsetPaddingLeft(15);
            dvTxt3.getDocumentLayoutParams().setTextAlignment(TextAlignment.JUSTIFIED);
            dvTxt3.getDocumentLayoutParams().setInsetPaddingTop(10);
            dvTxt3.getDocumentLayoutParams().setInsetPaddingBottom(10);
            dvTxt3.getDocumentLayoutParams().setInsetPaddingRight(15);
            dvTxt3.getDocumentLayoutParams().setTextSize(1, 16);
            dvTxt3.getDocumentLayoutParams().setTextColor(R.color.bck_dicas);
            dvTxt3.getDocumentLayoutParams().setTextFakeBold(true);
            linear.addView(dvTxt3);
        }

        //trazendo assinatura3 do texto
        if (redacao.getAss3() != null){
            String ass3 = redacao.getAss3();

            TextView tvAss3 = new TextView(this);
            tvAss3.setText(ass3);
            tvAss3.setTextAppearance(R.style.TextViewAssinatura);
            tvAss3.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_END);
            linear.addView(tvAss3);
        }

        // !!!!!!!!!!------- FIM DO TEXTO 3 ----------!!!!!!!!!!!!!!

        // !!!!!!!!!!------- Inicio DO TEXTO 4 ----------!!!!!!!!!!!!!!

        //Trazendo o Titulo 4
        if (redacao.getTit4() != null){
            String tit4 = redacao.getTit4();
            TextView tvtitulo4 = new TextView(this);
            tvtitulo4.setText(tit4);
            tvtitulo4.setTextAppearance(R.style.TextViewTituloTexto);
            tvtitulo4.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            linear.addView(tvtitulo4);
        }

        //trazendo o subtitulo 4
        if (redacao.getSubtit4() != null){

            String sub4 = redacao.getSubtit4();
            DocumentView dvSub4 = new DocumentView(this);
            dvSub4.setText(sub4);
            dvSub4.getDocumentLayoutParams().setHyphenator(DefaultHyphenator.getInstance(DefaultHyphenator.HyphenPattern.PT));
            dvSub4.getDocumentLayoutParams().setHyphenated(false);
            dvSub4.getDocumentLayoutParams().setInsetPaddingLeft(15);
            dvSub4.getDocumentLayoutParams().setTextAlignment(TextAlignment.JUSTIFIED);
            dvSub4.getDocumentLayoutParams().setInsetPaddingTop(10);
            dvSub4.getDocumentLayoutParams().setInsetPaddingBottom(10);
            dvSub4.getDocumentLayoutParams().setInsetPaddingRight(15);
            dvSub4.getDocumentLayoutParams().setTextSize(1, 14);
            dvSub4.getDocumentLayoutParams().setTextColor(R.color.bck_dicas);
            dvSub4.getDocumentLayoutParams().setTextFakeBold(true);
            linear.addView(dvSub4);
        }

        //compondo e exibindo as imagens do texto 4
        if (redacao.getImgEnd4() != null) {

            if (redacao.getImgEnd4().contains(",")) {
                String endereco = redacao.getImgEnd4();
                String enderecos[] = new String[]{};
                enderecos = endereco.split(",");


                int i = 0;
                while (i < enderecos.length) {

                    String end = enderecos[i];

                    try {
                        stream = this.getResources().getAssets().open(end);
                        Bitmap imagem4 = BitmapFactory.decodeStream(stream);
                        Bitmap imagemRedm4 = redimensionarImagem(imagem4);
                        PhotoView img4 = new PhotoView(this);
                        img4.setImageBitmap(imagemRedm4);
                        img4.setZoomable(true);
                        linear.addView(img4);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    i++;
                }

            }else{

                try {
                    stream = this.getResources().getAssets().open(redacao.getImgEnd4());
                    Bitmap imagem4 = BitmapFactory.decodeStream(stream);
                    Bitmap imagemRedm4 = redimensionarImagem(imagem4);
                    PhotoView img4 = new PhotoView(this);
                    img4.setImageBitmap(imagemRedm4);
                    img4.setZoomable(true);
                    linear.addView(img4);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        //trazendo o texto do titulo4
        if (redacao.getTxt4() != null){
            String txt4 = redacao.getTxt4();
            DocumentView dvTxt4 = new DocumentView(this);
            dvTxt4.setText(txt4);
            dvTxt4.getDocumentLayoutParams().setHyphenator(DefaultHyphenator.getInstance(DefaultHyphenator.HyphenPattern.PT));
            dvTxt4.getDocumentLayoutParams().setHyphenated(false);
            dvTxt4.getDocumentLayoutParams().setInsetPaddingLeft(15);
            dvTxt4.getDocumentLayoutParams().setTextAlignment(TextAlignment.JUSTIFIED);
            dvTxt4.getDocumentLayoutParams().setInsetPaddingTop(10);
            dvTxt4.getDocumentLayoutParams().setInsetPaddingBottom(10);
            dvTxt4.getDocumentLayoutParams().setInsetPaddingRight(15);
            dvTxt4.getDocumentLayoutParams().setTextSize(1, 16);
            dvTxt4.getDocumentLayoutParams().setTextColor(R.color.bck_dicas);
            dvTxt4.getDocumentLayoutParams().setTextFakeBold(true);
            linear.addView(dvTxt4);
        }

        //trazendo assinatura4 do texto
        if (redacao.getAss4() != null){
            String ass4 = redacao.getAss4();

            TextView tvAss4 = new TextView(this);
            tvAss4.setText(ass4);
            tvAss4.setTextAppearance(R.style.TextViewAssinatura);
            tvAss4.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_END);
            linear.addView(tvAss4);
        }

/*
            documentView = (DocumentView) findViewById(R.id.texto_questao_estudo);

            tvDados = (TextView) findViewById(R.id.tv_dados_questao);
            imagem1 = (PhotoView) findViewById(R.id.imagem);

            bdRedacao = new BDRedacao(this);

            redacao = bdRedacao.buscaPorId(idRedacao);


            dados = "Redação do enem ano " + redacao.getAnoRed()+ " com o tema: "+ redacao.getTemaRed();
            tvDados.setText(dados);

            documentView.setText(redacao.getEnun1());
            documentView.getDocumentLayoutParams().setHyphenator(DefaultHyphenator.getInstance(DefaultHyphenator.HyphenPattern.PT));
            documentView.getDocumentLayoutParams().setHyphenated(false);

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
                    Toast.makeText(ExpoRedacaoActivity.this, "Selecione uma opção", Toast.LENGTH_SHORT).show();
                }
                else {
                    int idTransf = idQuestao;
                    Log.d("claudio", "O id da questão é "+idTransf+" chegou no botão da resposta");
                    ShowPopup(v.findViewById(R.layout.custom_popup));
                }

            }
        });

*/
        Button buttonSair = new Button(this);
        buttonSair.setText("SAIR");
        buttonSair.setTextAppearance(R.style.ButtonExpoReda);
        linear.addView(buttonSair);

        buttonSair.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {

                Intent it = new Intent(ExpoRedacaoActivity.this, PraticaRedacaoActivity.class);
                startActivity(it);
                finish();
/*
                BDEstudo bdEstudoAtualizaTempo = new BDEstudo(ExpoRedacaoActivity.this);
                Estudo estudoAtualizaTempo = new Estudo();

                //Atualizar o tempo de estudo
                horaFinal = data.getTimeInMillis();

                BDEstudo bdEstudoAtualizaTempo2 = new BDEstudo(ExpoRedacaoActivity.this);

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
*/
                //ShowPopupResumo(v.findViewById(R.layout.custom_popup_resumo_estudo));
            }
        });

    }

    @Override
    public void onBackPressed() {

        Toast.makeText(ExpoRedacaoActivity.this, "Para sair do estudo use o botão SAIR", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onClick(View v) {


    }
/*
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

                BDEstudo bdEstudoAtualiza = new BDEstudo(ExpoRedacaoActivity.this);

                Estudo estudoAtualiza = new Estudo();
                estudoAtualiza.setIdEstudo(idEstudoAtivo);
                estudoAtualiza.setQtdQuest(totalQuestoesN);
                estudoAtualiza.setRespCerta(totalAcertosN);
                estudoAtualiza.setRespErrada(totalErrosN);

                bdEstudoAtualiza.atualizarQuestEstudo(estudoAtualiza);

               Intent it = new Intent(ExpoRedacaoActivity.this, ExpoRedacaoActivity.class);
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

        String tempoAtivoN = estudoResumo.getTempAtivo();

        tempoN = Long.valueOf(tempoAtivoN);

        int ms = tempoN.intValue();
        int segundos, minutos, horas;

        segundos = ( ms / 1000 ) % 60;
        minutos  = ( ms / 60000 ) % 60;     // 60000   = 60 * 1000
        horas    = ms / 3600000;            // 3600000 = 60 * 60 * 1000

        String tempodeEstudoRes =  String.format( "%02d:%02d:%02d", horas, minutos,segundos);

        float resultadoAcert = (acertosRes * 100) /  questoesRes;
        float resultadoErros = (errosRes * 100) / questoesRes;



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
                Intent it = new Intent(ExpoRedacaoActivity.this, EstudoListaActivity.class);
                startActivity(it);
                finish();
            }
        });

        btnContinuarEstudo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String aux = disciplina;
                String horaEstudo = null;

                Intent it = new Intent(ExpoRedacaoActivity.this, ExpoRedacaoActivity.class);
                it.putExtra("disciplina", aux);
                it.putExtra("hora_estudo", horaEstudo);
                startActivity(it);
                myDialog.dismiss();

            }
        });

        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }

*/
    public int testarEstudo(String disciplina){

        Estudo estudo = new Estudo();

        int idEstudo;

        String dataEstudo = (new SimpleDateFormat("dd/MM/yyyy").format(new Date(System.currentTimeMillis())));

        BDEstudo bdbuscarEstudo = new BDEstudo(ExpoRedacaoActivity.this);

        estudo = bdbuscarEstudo.buscarEstudoPorDisciplina(disciplina, dataEstudo);

        if (!disciplina.equals(estudo.getDisciplinaNome()) && !dataEstudo.equals(estudo.getDataRealiz())) {

            Long horaInicial = data.getTimeInMillis();
            String hora = horaInicial.toString();
            Estudo estudo1 = new Estudo();

            BDEstudo bdCriacaoEstudo = new BDEstudo(ExpoRedacaoActivity.this);

            estudo1.setDisciplinaNome(disciplina);
            estudo1.setDataRealiz(dataEstudo);
            estudo1.setQtdQuest(0);
            estudo1.setRespCerta(0);
            estudo1.setRespErrada(0);
            estudo1.setHoraInicio(hora);
            estudo1.setTempAtivo("0");

            bdCriacaoEstudo.novoEstudo(estudo1);


            BDEstudo bdBuscarEstudo2 = new BDEstudo(ExpoRedacaoActivity.this);
            Estudo estudo2 = new Estudo();
            estudo2 = bdBuscarEstudo2.buscarEstudoPorDisciplina(disciplina, dataEstudo);

            idEstudo = estudo2.getIdEstudo();

            return  idEstudo;

        } else {

            idEstudo = estudo.getIdEstudo();

            return idEstudo;

        }

    }
/*
    public void ShowPopupComent(View v) {

        Log.d("claudio", "começou o popup do comentario");
        Log.d("claudio", "o id da questão no popcoment é: "+ idQuestao);

        myDialog = new Dialog(this);
        TextView txtcomentTitle;
        Button btnVoltar;
        myDialog.setContentView(R.layout.custom_popup_comentario_estudo);
        txtcomentTitle =(TextView) myDialog.findViewById(R.id.txtcoment_title);
        txtcomentTitle.setText("APRENDENDO UM POUCO MAIS");

        BDQuestao bdBuscaComentario = new BDQuestao(ExpoRedacaoActivity.this);

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

                BDEstudo bdEstudoAtualiza = new BDEstudo(ExpoRedacaoActivity.this);

                Estudo estudoAtualiza = new Estudo();
                estudoAtualiza.setIdEstudo(idEstudoAtivo);
                estudoAtualiza.setQtdQuest(totalQuestoesN);
                estudoAtualiza.setRespCerta(totalAcertosN);
                estudoAtualiza.setRespErrada(totalErrosN);

                bdEstudoAtualiza.atualizarQuestEstudo(estudoAtualiza);

                Intent it = new Intent(ExpoRedacaoActivity.this, ExpoRedacaoActivity.class);
                it.putExtra("disciplina", aux);
                it.putExtra("hora_estudo", horaEstudo);
                startActivity(it);
                myDialog.dismiss();

            }
        });

        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }

*/


    public Bitmap redimensionarImagem(Bitmap bmp){
        Bitmap novoBmp = null;
        int w = bmp.getWidth();
        int h = bmp.getHeight();
        int tamW = (ExpoRedacaoActivity.this.getResources().getDisplayMetrics().widthPixels) - 200;
        float scalaW =((float) tamW) / w;
        float scalaH = scalaW;

        Matrix matrix = new Matrix();

        matrix.postScale(scalaW, scalaH);

        novoBmp = Bitmap.createBitmap(bmp, 0, 0, w, h, matrix, true);

        return novoBmp;

    }

}
