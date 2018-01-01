package br.com.ciadeideias.smartenem;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import br.com.ciadeideias.smartenem.bancodados.BDMeta;
import br.com.ciadeideias.smartenem.model.Grafico;
import br.com.ciadeideias.smartenem.model.Meta;
import br.com.ciadeideias.smartenem.utils.Desempenho;

public class GrafActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    ArrayList<Grafico> area1, area2, area3, area4, mlist;

    String titulo, legenda;
    int tipoGraf;
    Bundle bundle;
    Meta meta, meta2, meta3, meta4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graf);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView tvVolta = (TextView)findViewById(R.id.tv_tit_grafico_);

        TextView tvLin1Col1 = (TextView)findViewById(R.id.tv_tab_lin1_col1);
        TextView tvLin1Col2 = (TextView)findViewById(R.id.tv_tab_lin1_col2);
        TextView tvLin1Col3 = (TextView)findViewById(R.id.tv_tab_lin1_col3);
        TextView tvLin1Col4 = (TextView)findViewById(R.id.tv_tab_lin1_col4);
        TextView tvLin1Col5 = (TextView)findViewById(R.id.tv_tab_lin1_col5);

        TextView tvLin2Col1 = (TextView)findViewById(R.id.tv_tab_lin2_col1);
        TextView tvLin2Col2 = (TextView)findViewById(R.id.tv_tab_lin2_col2);
        TextView tvLin2Col3 = (TextView)findViewById(R.id.tv_tab_lin2_col3);
        TextView tvLin2Col4 = (TextView)findViewById(R.id.tv_tab_lin2_col4);
        TextView tvLin2Col5 = (TextView)findViewById(R.id.tv_tab_lin2_col5);

        TextView tvLin3Col1 = (TextView)findViewById(R.id.tv_tab_lin3_col1);
        TextView tvLin3Col2 = (TextView)findViewById(R.id.tv_tab_lin3_col2);
        TextView tvLin3Col3 = (TextView)findViewById(R.id.tv_tab_lin3_col3);
        TextView tvLin3Col4 = (TextView)findViewById(R.id.tv_tab_lin3_col4);
        TextView tvLin3Col5 = (TextView)findViewById(R.id.tv_tab_lin3_col5);

        TextView tvLin4Col1 = (TextView)findViewById(R.id.tv_tab_lin4_col1);
        TextView tvLin4Col2 = (TextView)findViewById(R.id.tv_tab_lin4_col2);
        TextView tvLin4Col3 = (TextView)findViewById(R.id.tv_tab_lin4_col3);
        TextView tvLin4Col4 = (TextView)findViewById(R.id.tv_tab_lin4_col4);
        TextView tvLin4Col5 = (TextView)findViewById(R.id.tv_tab_lin4_col5);

        TextView tvLin5Col1 = (TextView)findViewById(R.id.tv_tab_lin5_col1);
        TextView tvLin5Col2 = (TextView)findViewById(R.id.tv_tab_lin5_col2);
        TextView tvLin5Col3 = (TextView)findViewById(R.id.tv_tab_lin5_col3);
        TextView tvLin5Col4 = (TextView)findViewById(R.id.tv_tab_lin5_col4);
        TextView tvLin5Col5 = (TextView)findViewById(R.id.tv_tab_lin5_col5);

        TextView tvTabLegend = (TextView) findViewById(R.id.tv_tab_legend);

        BDMeta bdMeta = new BDMeta(this);

        bundle = getIntent().getExtras();
        titulo = bundle.getString("titulo");
        tvVolta.setText(titulo);
        tipoGraf = bundle.getInt("tipoGraf");

        switch (tipoGraf){
            case 1:
                String area1a, area2a, area3a, area4a;
                int percMeta = 0, percMeta2 = 0, percMeta3 = 0, percMeta4 = 0;
                int numDias = 0, numDias2 = 0, numDias3 = 0, numDias4 = 0;
                int vlrMeta1, vlrMeta2, vlrMeta3, vlrMeta4;
                int soma = 0, soma2 = 0, soma3 = 0, soma4 = 0;


                ArrayList<Integer> a = new ArrayList<Integer>();
                meta = new Meta();
                meta = bdMeta.buscarMeta(1);
                vlrMeta1 = (meta.getValorMeta())*7;


                if (bundle.containsKey("area1")) {
                    area1 = bundle.getParcelableArrayList("area1");
                    area1a = area1.get(0).getAreaNome().toString();
                    numDias = area1.size();

                    for (int i = 0; i < numDias; i++) {
                        a.add(area1.get(i).getQtdQuest());
                    }
                    for(int i = 0; i < a.size(); i++){
                        soma += a.get(i);
                    }

                    if (vlrMeta1 == 0){

                        new AlertDialog.Builder(this).setTitle("Alerta do sistema")
                                .setMessage("Você precisa definir as metas de estudos para a Area1. Deseja fazer isso agora?")
                                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent it = new Intent(GrafActivity.this, MetasActivity.class);
                                        startActivity(it);
                                        finish();
                                    }
                                }).setNegativeButton("Não", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent it = new Intent(GrafActivity.this, DesempenhoActivity.class);
                                startActivity(it);
                                finish();
                            }
                        }).show();
                    }
                    else {
                        percMeta = (soma * 100) / vlrMeta1;
                    }

                }
                else {
                    area1a = "Ciências Humanas e suas Tecnologias";

                }

                //Definição da área 2

                ArrayList<Integer> a2 = new ArrayList<Integer>();

                meta2 = new Meta();
                meta2 = bdMeta.buscarMeta(2);
                vlrMeta2 = (meta2.getValorMeta())*7;

                if (bundle.containsKey("area2")) {
                    area2 = bundle.getParcelableArrayList("area2");
                    area2a = area2.get(0).getAreaNome().toString();
                    numDias2 = area2.size();

                    for (int i = 0; i < numDias2; i++){
                        a2.add(area2.get(i).getQtdQuest());
                    }
                    for (int i = 0; i< a2.size(); i++){
                        soma2 += a2.get(i);
                    }

                    if (vlrMeta2 == 0){

                        new AlertDialog.Builder(this).setTitle("Alerta do sistema")
                                .setMessage("Você precisa definir as metas de estudos para a Area2. Deseja fazer isso agora?")
                                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent it = new Intent(GrafActivity.this, MetasActivity.class);
                                        startActivity(it);
                                        finish();
                                    }
                                }).setNegativeButton("Não", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent it = new Intent(GrafActivity.this, DesempenhoActivity.class);
                                startActivity(it);
                                finish();
                            }
                        }).show();
                    }
                    else {
                        percMeta2 = (soma2 * 100) / vlrMeta2;
                    }
                }
                else {
                    area2a = "Ciências da Natureza e suas Tecnologias";
                }
                //Definição area 3

                ArrayList<Integer> a3 = new ArrayList<Integer>();

                meta3 = new Meta();
                meta3 = bdMeta.buscarMeta(3);
                vlrMeta3 = (meta3.getValorMeta())*7;

                if (bundle.containsKey("area3")) {
                    area3 = bundle.getParcelableArrayList("area3");
                    area3a = area3.get(0).getAreaNome().toString();
                    numDias3 = area3.size();

                    for (int i = 0; i < numDias3; i++){
                        a3.add(area3.get(i).getQtdQuest());
                    }
                    for (int i = 0; i< a3.size(); i++){
                        soma3 += a3.get(i);
                    }

                    if (vlrMeta3 == 0){

                        new AlertDialog.Builder(this).setTitle("Alerta do sistema")
                                .setMessage("Você precisa definir as metas de estudos para a Area3. Deseja fazer isso agora?")
                                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent it = new Intent(GrafActivity.this, MetasActivity.class);
                                        startActivity(it);
                                        finish();
                                    }
                                }).setNegativeButton("Não", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent it = new Intent(GrafActivity.this, DesempenhoActivity.class);
                                startActivity(it);
                                finish();
                            }
                        }).show();
                    }
                    else {
                        percMeta3 = (soma3 * 100) / vlrMeta3;
                    }
                }
                else {
                    area3a = "Matemática e suas Tecnologias";
                }

                //Definindo area4

                ArrayList<Integer> a4 = new ArrayList<Integer>();

                meta4 = new Meta();
                meta4 = bdMeta.buscarMeta(4);
                vlrMeta4 = (meta4.getValorMeta())*7;

                if (bundle.containsKey("area4")) {
                    area4 = bundle.getParcelableArrayList("area4");
                    area4a = area4.get(0).getAreaNome().toString();
                    numDias4 = area4.size();

                    for (int i = 0; i < numDias4; i++){
                        a4.add(area4.get(i).getQtdQuest());
                    }
                    for (int i = 0; i< a4.size(); i++){
                        soma4 += a4.get(i);
                    }

                    if (vlrMeta4 == 0){

                        new AlertDialog.Builder(this).setTitle("Alerta do sistema")
                                .setMessage("Você precisa definir as metas de estudos para a Area4. Deseja fazer isso agora?")
                                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent it = new Intent(GrafActivity.this, MetasActivity.class);
                                        startActivity(it);
                                        finish();
                                    }
                                }).setNegativeButton("Não", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent it = new Intent(GrafActivity.this, DesempenhoActivity.class);
                                startActivity(it);
                                finish();
                            }
                        }).show();
                    }
                    else {
                        percMeta4 = (soma4 * 100) / vlrMeta4;
                    }

                }
                else {
                    area4a = "Linguagens, Código e suas Tecnologias";
                }

                tvLin1Col1.setText("Área de Estudos");
                tvLin1Col2.setText("Qtd Dias");
                tvLin1Col3.setText("Qtd Quest");
                tvLin1Col4.setText("Meta");
                tvLin1Col5.setText("% Meta");

                tvLin2Col1.setText(area1a);
                tvLin2Col2.setText(""+numDias);
                tvLin2Col3.setText(""+soma);
                tvLin2Col4.setText(""+vlrMeta1);
                tvLin2Col5.setText(percMeta+"%");

                tvLin3Col1.setText(area2a);
                tvLin3Col2.setText(""+numDias2);
                tvLin3Col3.setText(""+soma2);
                tvLin3Col4.setText(""+vlrMeta2);
                tvLin3Col5.setText(percMeta2+"%");

                tvLin4Col1.setText(area3a);
                tvLin4Col2.setText(""+numDias3);
                tvLin4Col3.setText(""+soma3);
                tvLin4Col4.setText(""+vlrMeta3);
                tvLin4Col5.setText(percMeta3+"%");

                tvLin5Col1.setText(area4a);
                tvLin5Col2.setText(""+numDias4);
                tvLin5Col3.setText(""+soma4);
                tvLin5Col4.setText(""+vlrMeta4);
                tvLin5Col5.setText(percMeta4+"%");

                legenda ="Legenda:\n\r" +
                        "Qtd Dias - É a quantidade de dias em que houve estudo na área correspondente ao longo dos últimos 7(sete) dias.\n\r" +
                        "Qtd Quest - É a quantidade total de questões respondidas por área ao longo dos últimos 7(sete) dias.\n\r" +
                        "Meta - Corresponde ao valor da meta diária, estabelecida pelo usuário, multiplicada por 7(sete).\n\r" +
                        "% Meta - Percentual de estudos alcançado nos últimos 7 (sete) dias referente a cada área";

                tvTabLegend.setText(legenda);

                break;
            case 2:
                String area1b, area2b, area3b, area4b;
                int numDias1b = 0, numDias2b = 0, numDias3b = 0, numDias4b = 0;
                int somaQuest1b = 0, somaQuest2b = 0, somaQuest3b = 0, somaQuest4b = 0;
                int somaAcert1b = 0, somaAcert2b = 0, somaAcert3b = 0, somaAcert4b = 0;
                int percAcert1b = 0, percAcert2b = 0, percAcert3b = 0, percAcert4b = 0;

                //Definindo variaveis area1
                ArrayList<Integer> b1 = new ArrayList<Integer>();

                if (bundle.containsKey("area1")){

                    area1 = bundle.getParcelableArrayList("area1");
                    area1b = area1.get(0).getAreaNome().toString();
                    numDias1b = area1.size();

                    for (int i = 0; i < numDias1b; i++){
                        b1.add(area1.get(i).getQtdQuest());
                    }
                    for (int i = 0; i < b1.size(); i++){
                        somaQuest1b += b1.get(i);
                    }
                    b1.clear();

                    for (int i = 0; i < numDias1b; i++){
                        b1.add(area1.get(i).getRespCerta());
                    }
                    for (int i = 0; i < b1.size(); i++){
                        somaAcert1b += b1.get(i);
                    }

                    if (somaQuest1b == 0){
                        percAcert1b = 0;
                    }
                    else {
                        percAcert1b = (somaAcert1b * 100) / somaQuest1b;
                    }
                }
                else{
                    area1b = "Ciências Humanas e suas Tecnologias";
                }

                //Definindo variaveis area2
                ArrayList<Integer> b2 = new ArrayList<Integer>();

                if (bundle.containsKey("area2")){

                    area2 = bundle.getParcelableArrayList("area2");
                    area2b = area2.get(0).getAreaNome().toString();
                    numDias2b = area2.size();

                    for (int i = 0; i < numDias2b; i++){
                        b2.add(area2.get(i).getQtdQuest());
                    }
                    for (int i = 0; i < b2.size(); i++){
                        somaQuest2b += b2.get(i);
                    }
                    b2.clear();

                    for (int i = 0; i < numDias2b; i++){
                        b2.add(area2.get(i).getRespCerta());
                    }
                    for (int i = 0; i < b2.size(); i++){
                        somaAcert2b += b2.get(i);
                    }

                    if (somaQuest2b == 0){
                        percAcert2b = 0;
                    }
                    else {
                        percAcert2b = (somaAcert2b * 100) / somaQuest2b;
                    }
                }
                else{
                    area2b = "Ciências da Natureza e suas Tecnologias";
                }

                //Definindo variaveis area3
                ArrayList<Integer> b3 = new ArrayList<Integer>();

                if (bundle.containsKey("area3")){

                    area3 = bundle.getParcelableArrayList("area3");
                    area3b = area3.get(0).getAreaNome().toString();
                    numDias3b = area3.size();

                    for (int i = 0; i < numDias3b; i++){
                        b3.add(area3.get(i).getQtdQuest());
                    }
                    for (int i = 0; i < b3.size(); i++){
                        somaQuest3b += b3.get(i);
                    }
                    b3.clear();

                    for (int i = 0; i < numDias3b; i++){
                        b3.add(area3.get(i).getRespCerta());
                    }
                    for (int i = 0; i < b3.size(); i++){
                        somaAcert3b += b3.get(i);
                    }

                    if (somaQuest3b == 0){
                        percAcert3b = 0;
                    }
                    else {
                        percAcert3b = (somaAcert3b * 100) / somaQuest3b;
                    }
                }
                else{
                    area3b = "Matemática e suas Tecnologias";
                }

                //Definindo variaveis area4
                ArrayList<Integer> b4 = new ArrayList<Integer>();

                if (bundle.containsKey("area4")){

                    area4 = bundle.getParcelableArrayList("area4");
                    area4b = area4.get(0).getAreaNome().toString();
                    numDias4b = area4.size();

                    for (int i = 0; i < numDias4b; i++){
                        b4.add(area4.get(i).getQtdQuest());
                    }
                    for (int i = 0; i < b4.size(); i++){
                        somaQuest4b += b4.get(i);
                    }
                    b4.clear();

                    for (int i = 0; i < numDias4b; i++){
                        b4.add(area4.get(i).getRespCerta());
                    }
                    for (int i = 0; i < b4.size(); i++){
                        somaAcert4b += b4.get(i);
                    }

                    if (somaQuest4b == 0){
                        percAcert4b = 0;
                    }
                    else {
                        percAcert4b = (somaAcert4b * 100) / somaQuest4b;
                    }
                }
                else{
                    area4b = "Linguagens, Códigos e suas Tecnologias";
                }


                tvLin1Col1.setText("Área de Estudos");
                tvLin1Col2.setText("Qtd Dias");
                tvLin1Col3.setText("Qtd Quest");
                tvLin1Col4.setText("Qtd Acerto");
                tvLin1Col5.setText("% Acerto");

                tvLin2Col1.setText(area1b);
                tvLin2Col2.setText(""+numDias1b);
                tvLin2Col3.setText(""+somaQuest1b);
                tvLin2Col4.setText(""+somaAcert1b);
                tvLin2Col5.setText(percAcert1b+"%");

                tvLin3Col1.setText(area2b);
                tvLin3Col2.setText(""+numDias2b);
                tvLin3Col3.setText(""+somaQuest2b);
                tvLin3Col4.setText(""+somaAcert2b);
                tvLin3Col5.setText(percAcert2b+"%");

                tvLin4Col1.setText(area3b);
                tvLin4Col2.setText(""+numDias3b);
                tvLin4Col3.setText(""+somaQuest3b);
                tvLin4Col4.setText(""+somaAcert3b);
                tvLin4Col5.setText(percAcert3b+"%");

                tvLin5Col1.setText(area4b);
                tvLin5Col2.setText(""+numDias4b);
                tvLin5Col3.setText(""+somaQuest4b);
                tvLin5Col4.setText(""+somaAcert4b);
                tvLin5Col5.setText(percAcert4b+"%");

                legenda ="Legenda:\n\r" +
                        "Qtd Dias - É a quantidade de dias em que houve estudo na área correspondente ao longo dos últimos 7(sete) dias.\n\r" +
                        "Qtd Quest - É a quantidade total de questões respondidas por área ao longo dos últimos 7(sete) dias.\n\r" +
                        "Qtd Acerto - Corresponde ao total de respostas certas nos últimos 7(sete) dias.\n\r" +
                        "% Acerto - Percentual de acerto referente a cada área nos ultimos 7(sete) dias.";

                tvTabLegend.setText(legenda);

                break;
            case 3:
                // criar grafico 3

                String area1c, area2c, area3c, area4c;
                int numDias1c = 0, numDias2c = 0, numDias3c = 0, numDias4c = 0;
                int soma1c = 0, soma2c = 0, soma3c = 0, soma4c = 0;
                int media1c = 0, media2c = 0, media3c = 0, media4c = 0;
                long somaTempo1c = 0, somaTempo2c = 0, somaTempo3c = 0, somaTempo4c = 0;
                long mediaTempo1c = 0, mediaTempo2c = 0, mediaTempo3c = 0, mediaTempo4c = 0;
                String desempSema1c = null, desempSema2c = null, desempSema3c = null, desempSema4c = null;
                String confgDedic;
                String tempoTotal1c = null, tempoTotal2c, tempoTotal3c, tempoTotal4c, tempoMedio1c = null, tempoMedio2c, tempoMedio3c, tempoMedio4c;

                meta = new Meta();
                meta = bdMeta.buscarMeta(1);
                confgDedic = meta.getNivelDedic();

                //Definindo variaveis area1

                ArrayList<Integer> c1 = new ArrayList<Integer>();

                if (bundle.containsKey("area1")){

                    area1 = bundle.getParcelableArrayList("area1");
                    area1c = area1.get(0).getAreaNome().toString();
                    numDias1c = area1.size();

                    for (int i = 0; i < numDias1c; i++){
                        c1.add(area1.get(i).getTempAtivo());
                    }
                    for (int i = 0; i < c1.size(); i++){
                        soma1c += c1.get(i);
                    }

                    media1c = soma1c / 7;

                    Desempenho desemp = new Desempenho();

                    desempSema1c = desemp.testeDesemp(soma1c, confgDedic);

                    somaTempo1c = soma1c * 1000;
                    long minutos = (somaTempo1c / 60000)%60;
                    long horas = somaTempo1c / 3600000;

                    tempoTotal1c = String.format("%2d:%2d", horas, minutos);

                    mediaTempo1c = media1c * 1000;
                    long minutosM = (mediaTempo1c / 60000)%60;
                    long horasM = mediaTempo1c / 3600000;

                    tempoMedio1c = String.format("%2d:%2d", horasM, minutosM);

                }else{
                    area1c = "Ciências Humanas e suas Tecnologias";
                    tempoMedio1c = "0:00";
                    tempoTotal1c = "0:00";
                    desempSema1c = "Não avaliado";
                }

                //Definindo variaveis area2

                ArrayList<Integer> c2 = new ArrayList<Integer>();

                if (bundle.containsKey("area2")){

                    area2 = bundle.getParcelableArrayList("area2");
                    area2c = area2.get(0).getAreaNome().toString();
                    numDias2c = area2.size();

                    for (int i = 0; i < numDias2c; i++){
                        c2.add(area2.get(i).getTempAtivo());
                    }
                    for (int i = 0; i < c2.size(); i++){
                        soma2c += c2.get(i);
                    }

                    media2c = soma2c / 7;

                    Desempenho desemp2 = new Desempenho();

                    desempSema2c = desemp2.testeDesemp(soma2c, confgDedic);

                    somaTempo2c = soma2c * 1000;
                    long minutos2 = (somaTempo2c / 60000)%60;
                    long horas2 = somaTempo2c / 3600000;

                    tempoTotal2c = String.format("%2d:%2d", horas2, minutos2);

                    mediaTempo2c = media2c * 1000;
                    long minutosM2 = (mediaTempo2c / 60000)%60;
                    long horasM2 = mediaTempo2c / 3600000;

                    tempoMedio2c = String.format("%2d:%2d", horasM2, minutosM2);

                }else{
                    area2c = "Ciências Naturais e suas Tecnologias";
                    tempoMedio2c = "0:00";
                    tempoTotal2c = "0:00";
                    desempSema2c = "Não avaliado";
                }

                //Definindo variaveis area3

                ArrayList<Integer> c3 = new ArrayList<Integer>();

                if (bundle.containsKey("area3")){

                    area3 = bundle.getParcelableArrayList("area3");
                    area3c = area3.get(0).getAreaNome().toString();
                    numDias3c = area3.size();

                    for (int i = 0; i < numDias3c; i++){
                        c3.add(area3.get(i).getTempAtivo());
                    }
                    for (int i = 0; i < c3.size(); i++){
                        soma3c += c3.get(i);
                    }

                    media3c = soma3c / 7;

                    Desempenho desemp3 = new Desempenho();

                    desempSema3c = desemp3.testeDesemp(soma3c, confgDedic);

                    somaTempo3c = soma3c * 1000;
                    long minutos3 = (somaTempo3c / 60000)%60;
                    long horas3 = somaTempo3c / 3600000;

                    tempoTotal3c = String.format("%2d:%2d", horas3, minutos3);

                    mediaTempo3c = media3c * 1000;
                    long minutosM3 = (mediaTempo3c / 60000)%60;
                    long horasM3 = mediaTempo3c / 3600000;

                    tempoMedio3c = String.format("%2d:%2d", horasM3, minutosM3);

                }else{
                    area3c = "Matemática e suas Tecnologias";
                    tempoMedio3c = "0:00";
                    tempoTotal3c = "0:00";
                    desempSema3c = "Não avaliado";
                }

                //Definindo variaveis area4

                ArrayList<Integer> c4 = new ArrayList<Integer>();

                if (bundle.containsKey("area4")){

                    area4 = bundle.getParcelableArrayList("area4");
                    area4c = area4.get(0).getAreaNome().toString();
                    numDias4c = area4.size();

                    for (int i = 0; i < numDias4c; i++){
                        c4.add(area4.get(i).getTempAtivo());
                    }
                    for (int i = 0; i < c4.size(); i++){
                        soma4c += c4.get(i);
                    }

                    media4c = soma4c / 7;

                    Desempenho desemp4 = new Desempenho();

                    desempSema4c = desemp4.testeDesemp(soma4c, confgDedic);

                    somaTempo4c = soma4c * 1000;
                    long minutos4 = (somaTempo4c / 60000)%60;
                    long horas4 = somaTempo4c / 3600000;

                    tempoTotal4c = String.format("%2d:%2d", horas4, minutos4);

                    mediaTempo4c = media4c * 1000;
                    long minutosM4 = (mediaTempo4c / 60000)%60;
                    long horasM4 = mediaTempo4c / 3600000;

                    tempoMedio4c = String.format("%2d:%2d", horasM4, minutosM4);

                }else{
                    area4c = "Linguagens, Códigos e suas Tecnologias";
                    tempoMedio4c = "0:00";
                    tempoTotal4c = "0:00";
                    desempSema4c = "Não avaliado";
                }

                //impressão do gráfico

                tvLin1Col1.setText("Área de Estudos");
                tvLin1Col2.setText("Qtd Dias");
                tvLin1Col3.setText("Tempo Tot");
                tvLin1Col4.setText("Média/dia");
                tvLin1Col5.setText("Desemp");

                tvLin2Col1.setText(area1c);
                tvLin2Col2.setText(""+numDias1c);
                tvLin2Col3.setText(tempoTotal1c+"h");
                tvLin2Col4.setText(tempoMedio1c+"h");
                tvLin2Col5.setText(desempSema1c);

                tvLin3Col1.setText(area2c);
                tvLin3Col2.setText(""+numDias2c);
                tvLin3Col3.setText(tempoTotal2c+"h");
                tvLin3Col4.setText(tempoMedio2c+'h');
                tvLin3Col5.setText(desempSema2c);

                tvLin4Col1.setText(area3c);
                tvLin4Col2.setText(""+numDias3c);
                tvLin4Col3.setText(tempoTotal3c+"h");
                tvLin4Col4.setText(tempoMedio3c+'h');
                tvLin4Col5.setText(desempSema3c);

                tvLin5Col1.setText(area4c);
                tvLin5Col2.setText(""+numDias4c);
                tvLin5Col3.setText(tempoTotal4c+"h");
                tvLin5Col4.setText(tempoMedio4c+"h");
                tvLin5Col5.setText(desempSema4c);

                legenda ="Legenda:\n\r" +
                        "Qtd Dias - É a quantidade de dias em que houve estudo na área correspondente ao longo dos últimos 7(sete) dias.\n\r" +
                        "Tempo Tot - É a o tempo total dedicado ao estudo por área ao longo dos últimos 7(sete) dias.\n\r" +
                        "Média /dia - Corresponde a média do tempo de estudo por área por dia nos últimos 7(sete) dias.\n\r" +
                        "Desemp - Classificação do seu desempenho de estudo nos ultimos 7(sete) dias em relação ao nível de dedicação.";

                tvTabLegend.setText(legenda);

                break;
            case 4:
                //implantar grafico 4

                String area1d, area2d = null, area3d = null, area4d = null;
                int numSimul1d, numSimul2d = 0, numSimul3d = 0, numSimul4d = 0;
                int somaQuest1d = 0, somaQuest2d = 0, somaQuest3d = 0, somaQuest4d = 0;
                int somaAcert1d = 0, somaAcert2d = 0, somaAcert3d = 0, somaAcert4d = 0;
                int percAcert1d = 0, percAcert2d = 0, percAcert3d = 0, percAcert4d = 0;

                //Dados área1

                ArrayList<Integer> d1 = new ArrayList<Integer>();

                if (bundle.containsKey("area1")){

                    area1 = bundle.getParcelableArrayList("area1");
                    area1d = area1.get(0).getAreaNome().toString();
                    numSimul1d = area1.size();

                    for (int i = 0; i < numSimul1d; i++){
                        d1.add(area1.get(i).getQtdQuest());
                    }
                    for (int i = 0; i < d1.size(); i++){
                        somaQuest1d += d1.get(i);
                    }
                    d1.clear();

                    for (int i = 0; i < numSimul1d; i++){
                        d1.add(area1.get(i).getRespCerta());
                    }
                    for (int i = 0; i < d1.size(); i++){
                        somaAcert1d += d1.get(i);
                    }

                    if (somaQuest1d == 0){
                        percAcert1d = 0;
                    }
                    else {
                        percAcert1d = (somaAcert1d * 100) / somaQuest1d;
                    }

                }else{
                    area1d = "Ciências Humanas e suas Tecnologias";
                    numSimul1d = 0;
                    somaQuest1d = 0;
                    somaAcert1d = 0;
                    percAcert1d = 0;
                }

                //Dados área2

                ArrayList<Integer> d2 = new ArrayList<Integer>();

                if (bundle.containsKey("area2")){

                    area2 = bundle.getParcelableArrayList("area2");
                    area2d = area2.get(0).getAreaNome().toString();
                    numSimul2d = area2.size();

                    for (int i = 0; i < numSimul2d; i++){
                        d2.add(area2.get(i).getQtdQuest());
                    }
                    for (int i = 0; i < d2.size(); i++){
                        somaQuest2d += d2.get(i);
                    }
                    d2.clear();

                    for (int i = 0; i < numSimul2d; i++){
                        d2.add(area2.get(i).getRespCerta());
                    }
                    for (int i = 0; i < d2.size(); i++){
                        somaAcert2d += d2.get(i);
                    }

                    if (somaQuest2d == 0){
                        percAcert2d = 0;
                    }
                    else {
                        percAcert2d = (somaAcert2d * 100) / somaQuest2d;
                    }

                }else{
                    area2d = "Ciências Naturais e suas Tecnologias";
                    numSimul2d = 0;
                    somaQuest2d = 0;
                    somaAcert2d = 0;
                    percAcert2d = 0;
                }

                //Dados área3

                ArrayList<Integer> d3 = new ArrayList<Integer>();

                if (bundle.containsKey("area3")){

                    area3 = bundle.getParcelableArrayList("area3");
                    area3d = area3.get(0).getAreaNome().toString();
                    numSimul3d = area3.size();

                    for (int i = 0; i < numSimul3d; i++){
                        d3.add(area3.get(i).getQtdQuest());
                    }
                    for (int i = 0; i < d3.size(); i++){
                        somaQuest3d += d3.get(i);
                    }
                    d3.clear();

                    for (int i = 0; i < numSimul3d; i++){
                        d3.add(area3.get(i).getRespCerta());
                    }
                    for (int i = 0; i < d3.size(); i++){
                        somaAcert3d += d3.get(i);
                    }

                    if (somaQuest3d == 0){
                        percAcert3d = 0;
                    }
                    else {
                        percAcert3d = (somaAcert3d * 100) / somaQuest3d;
                    }

                }else{
                    area3d = "Matemática e suas Tecnologias";
                    numSimul3d = 0;
                    somaQuest3d = 0;
                    somaAcert3d = 0;
                    percAcert3d = 0;
                }

                //Dados área4

                ArrayList<Integer> d4 = new ArrayList<Integer>();

                if (bundle.containsKey("area4")){

                    area4 = bundle.getParcelableArrayList("area4");
                    area4d = area4.get(0).getAreaNome().toString();
                    numSimul4d = area4.size();

                    for (int i = 0; i < numSimul4d; i++){
                        d4.add(area4.get(i).getQtdQuest());
                    }
                    for (int i = 0; i < d4.size(); i++){
                        somaQuest4d += d4.get(i);
                    }
                    d4.clear();

                    for (int i = 0; i < numSimul4d; i++){
                        d4.add(area4.get(i).getRespCerta());
                    }
                    for (int i = 0; i < d4.size(); i++){
                        somaAcert4d += d4.get(i);
                    }

                    if (somaQuest4d == 0){
                        percAcert4d = 0;
                    }
                    else {
                        percAcert4d = (somaAcert4d * 100) / somaQuest4d;
                    }

                }else{
                    area4d = "Linguagens, Códigos e suas Tecnologias";
                    numSimul4d = 0;
                    somaQuest4d = 0;
                    somaAcert4d = 0;
                    percAcert4d = 0;
                }


                //impressão do gráfico

                tvLin1Col1.setText("Área de Estudos");
                tvLin1Col2.setText("Simulados");
                tvLin1Col3.setText("Qtd Quest");
                tvLin1Col4.setText("Qtd Acerto");
                tvLin1Col5.setText("% Acerto");

                tvLin2Col1.setText(area1d);
                tvLin2Col2.setText(""+numSimul1d);
                tvLin2Col3.setText(somaQuest1d+"");
                tvLin2Col4.setText(somaAcert1d+"");
                tvLin2Col5.setText(percAcert1d+"%");

                tvLin3Col1.setText(area2d);
                tvLin3Col2.setText(""+numSimul2d);
                tvLin3Col3.setText(somaQuest2d+"");
                tvLin3Col4.setText(somaAcert2d+"");
                tvLin3Col5.setText(percAcert2d+"%");

                tvLin4Col1.setText(area3d);
                tvLin4Col2.setText(""+numSimul3d);
                tvLin4Col3.setText(somaQuest3d+"");
                tvLin4Col4.setText(somaAcert3d+"");
                tvLin4Col5.setText(percAcert3d+"%");

                tvLin5Col1.setText(area4d);
                tvLin5Col2.setText(""+numSimul4d);
                tvLin5Col3.setText(""+somaQuest4d);
                tvLin5Col4.setText(""+somaAcert4d);
                tvLin5Col5.setText(percAcert4d+"%");

                legenda ="Legenda:\n\r" +
                        "Simulados - É a quantidade total de simulados concluidos por área nos últimos 7(sete) dias.\n\r" +
                        "Qtd Quest - É a quantidade total de questões respondidas nos simulados nos últimos 7(sete) dias.\n\r" +
                        "Qtd Acerto - É a quantidade total de respostas certas nos simulados realizados nos últimos 7(sete) dias.\n\r" +
                        "% Acerto - É o percentual de acerto sobre o total das questões.";

                tvTabLegend.setText(legenda);

                break;
            case 5:
                //implantar grafico 5
                String dataRealiz1 = null, dataRealiz2 = null, dataRealiz3 = null, dataRealiz4 = null, data1, data2, data3, data4;
                int pontos1 = 0, pontos2 = 0, pontos3 = 0, pontos4 = 0;
                int tempoProva1a = 0, tempoProva2a = 0, tempoProva3a = 0, tempoProva4a = 0;
                String tempoSimul1 = null, tempoSimul2 = null, tempoSimul3 = null, tempoSimul4 = null;
                int qtdAcert1 = 0, qtdAcert2 = 0, qtdAcert3 = 0, qtdAcert4 = 0;
                int qtdQuest1 = 0, qtdQuest2 = 0, qtdQuest3 = 0, qtdQuest4 = 0;
                int acertSimul1 = 0, acertSimul2 = 0, acertSimul3 = 0, acertSimul4 = 0;

                mlist = bundle.getParcelableArrayList("simulComple");


                if (mlist.isEmpty()) {

                    new AlertDialog.Builder(this).setTitle("Alerta do sistema")
                            .setMessage("Você ainda não realizou nenhumm simulado Quer fazer agora?")
                            .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent it = new Intent(GrafActivity.this, MetasActivity.class);
                                    startActivity(it);
                                    finish();
                                }
                            }).setNegativeButton("Não", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent it = new Intent(GrafActivity.this, DesempenhoActivity.class);
                            startActivity(it);
                            finish();
                        }
                    }).show();


                }else {

                    data1 = mlist.get(0).getDataRealiz().toString();
                    data2 = mlist.get(1).getDataRealiz().toString();
                    data3 = mlist.get(2).getDataRealiz().toString();
                    data4 = mlist.get(3).getDataRealiz().toString();

                    String data1a[] = data1.split("-");
                    dataRealiz1 = data1a[2]+"/"+data1a[1]+"/"+data1a[0];

                    String data2a[] = data2.split("-");
                    dataRealiz2 = data2a[2]+"/"+data2a[1]+"/"+data2a[0];

                    String data3a[] = data3.split("-");
                    dataRealiz3 = data3a[2]+"/"+data3a[1]+"/"+data3a[0];

                    String data4a[] = data4.split("-");
                    dataRealiz4 = data4a[2]+"/"+data4a[1]+"/"+data4a[0];


                    pontos1 = mlist.get(0).getPtsSimulComple();
                    pontos2 = mlist.get(1).getPtsSimulComple();
                    pontos3 = mlist.get(2).getPtsSimulComple();
                    pontos4 = mlist.get(3).getPtsSimulComple();

                    tempoProva1a = (mlist.get(0).getTempAtivo()) * 1000;
                    long min1 = (tempoProva1a / 60000)%60;
                    long hor1 = tempoProva1a / 3600000;
                    tempoSimul1 = String.format("%2d:%2d", hor1, min1);

                    tempoProva2a = (mlist.get(1).getTempAtivo()) * 1000;
                    long min2 = (tempoProva2a / 60000)%60;
                    long hor2 = tempoProva2a / 3600000;
                    tempoSimul2 = String.format("%2d:%2d", hor2, min2);

                    tempoProva3a = (mlist.get(2).getTempAtivo()) * 1000;
                    long min3 = (tempoProva3a / 60000)%60;
                    long hor3 = tempoProva3a / 3600000;
                    tempoSimul3 = String.format("%2d:%2d", hor3, min3);

                    tempoProva4a = (mlist.get(3).getTempAtivo()) * 1000;
                    long min4 = (tempoProva4a / 60000)%60;
                    long hor4 = tempoProva4a / 3600000;
                    tempoSimul4 = String.format("%2d:%2d", hor4, min4);

                    qtdAcert1 = mlist.get(0).getRespCerta();
                    qtdAcert2 = mlist.get(1).getRespCerta();
                    qtdAcert3 = mlist.get(2).getRespCerta();
                    qtdAcert4 = mlist.get(3).getRespCerta();

                    qtdQuest1 = mlist.get(0).getQtdQuest();
                    qtdQuest2 = mlist.get(1).getQtdQuest();
                    qtdQuest3 = mlist.get(2).getQtdQuest();
                    qtdQuest4 = mlist.get(3).getQtdQuest();

                    if (qtdQuest1 == 0){
                        acertSimul1 = 0;
                    }
                    else {
                        acertSimul1 = (qtdAcert1 * 100) / qtdQuest1;
                    }

                    if (qtdQuest2 == 0){
                        acertSimul2 = 0;
                    }
                    else {
                        acertSimul2 = (qtdAcert2 * 100) / qtdQuest2;
                    }

                    if (qtdQuest3 == 0){
                        acertSimul3 = 0;
                    }
                    else {
                        acertSimul3 = (qtdAcert3 * 100) / qtdQuest3;
                    }

                    if (qtdQuest4 == 0){
                        acertSimul4 = 0;
                    }
                    else {
                        acertSimul4 = (qtdAcert4 * 100) / qtdQuest4;
                    }


                }

                //impressão do gráfico

                tvLin1Col1.setText("Data de Realização do Simulado");
                tvLin1Col2.setText("Tot Pontos");
                tvLin1Col3.setText("Tot Tempo");
                tvLin1Col4.setText("Qtd Acerto");
                tvLin1Col5.setText("% Acertos");

                tvLin2Col1.setText(dataRealiz1);
                tvLin2Col2.setText(""+pontos1);
                tvLin2Col3.setText(tempoSimul1+"h");
                tvLin2Col4.setText(""+qtdAcert1);
                tvLin2Col5.setText(acertSimul1+"%");

                tvLin3Col1.setText(dataRealiz2);
                tvLin3Col2.setText(""+pontos2);
                tvLin3Col3.setText(tempoSimul2+"h");
                tvLin3Col4.setText(""+qtdAcert2);
                tvLin3Col5.setText(acertSimul2+"%");

                tvLin4Col1.setText(dataRealiz3);
                tvLin4Col2.setText(""+pontos3);
                tvLin4Col3.setText(tempoSimul3+"h");
                tvLin4Col4.setText(""+qtdAcert3);
                tvLin4Col5.setText(acertSimul3+"%");

                tvLin5Col1.setText(dataRealiz4);
                tvLin5Col2.setText(""+pontos4);
                tvLin5Col3.setText(tempoSimul4+"h");
                tvLin5Col4.setText(""+qtdAcert4);
                tvLin5Col5.setText(acertSimul4+"%");

                legenda ="Legenda:\n\r" +
                        "Pontos - É o total de pontos alcançados no simulado, levando em  conta o grau de dificuldade de cada questão.\n\r" +
                        "Qtd Quest - O tempo total gasto para realizar o simulado. Na prova seu tempo será no máximo 4:30h.\n\r" +
                        "Qtd Acerto - É a quantidade total de respostas certas no simulado realizado.\n\r" +
                        "% Acerto - É o percentual de acerto sobre o total das questões de cada simulado.";

                tvTabLegend.setText(legenda);

                break;
        }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            Intent it = new Intent(GrafActivity.this, DesempenhoActivity.class);
            startActivity(it);
            finish();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_graf, menu);
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

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_premium) {
            Toast.makeText(GrafActivity.this, "Voce Clicou no Menu premium", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_home) {
            Intent it = new Intent(GrafActivity.this, SplashActivity.class);
            startActivity(it);
            finish();

        } else if (id == R.id.nav_plan_estud) {
            Intent it = new Intent(GrafActivity.this, PlanEstuActivity.class);
            startActivity(it);
            finish();

        } else if (id == R.id.nav_meta) {
            Intent it = new Intent(GrafActivity.this, MetasActivity.class);
            startActivity(it);
            finish();

        } else if (id == R.id.nav_desemp) {
            Intent it = new Intent(GrafActivity.this, DesempenhoActivity.class);
            startActivity(it);
            finish();

        } else if (id == R.id.nav_compart){
            Toast.makeText(GrafActivity.this, "Voce Clicou no Menu Compartilhar", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_config){
            Toast.makeText(GrafActivity.this, "Voce Clicou no Menu Configurações", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_ajuda) {
            Toast.makeText(GrafActivity.this, "Voce Clicou no Menu Ajuda", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_sobre) {
            Toast.makeText(GrafActivity.this, "Voce Clicou no Menu Sobre", Toast.LENGTH_SHORT).show();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
