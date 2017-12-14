package br.com.ciadeideias.smartenem;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.ValueDependentColor;
import com.jjoe64.graphview.helper.DateAsXAxisLabelFormatter;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.ciadeideias.smartenem.bancodados.BDGrafico;
import br.com.ciadeideias.smartenem.model.Grafico;

public class GrafActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    ArrayList<Grafico> area1, area2, area3, area4;
    String titulo;
    int tipoGraf;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graf);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView tvVolta = (TextView)findViewById(R.id.tv_tit_grafico_);
        GraphView graph = (GraphView) findViewById(R.id.graph);
        bundle = getIntent().getExtras();
        titulo = bundle.getString("titulo");
        tvVolta.setText(titulo);
        tipoGraf = bundle.getInt("tipoGraf");

        switch (tipoGraf){
            case 1:
                String[] dias = new String[8];
                if (bundle.containsKey("area1")) {
                    area1 = bundle.getParcelableArrayList("area1");
                    String legend = area1.get(0).getAreaNome().toString();
                    LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[]{

                    });
                    int tam = area1.size();
                    for (int i = 0; i < tam; i++) {
                        String data = area1.get(i).getDataRealiz().toString();
                        String[] temp = data.split("-");
                        dias[i] = temp[0];
                        int a = area1.get(i).getQtdQuest();
                        DataPoint dp = new DataPoint(i, a);
                        series.appendData(dp, true, tam);
                    }
                    series.setTitle(legend);
                    series.setColor(Color.BLACK);
                    series.setDrawDataPoints(true);
                    series.setDataPointsRadius(10);
                    series.setThickness(5);
                    graph.addSeries(series);
                    if (bundle.containsKey("area2")) {
                        area2 = bundle.getParcelableArrayList("area2");
                        String legend2 = area2.get(0).getAreaNome().toString();
                        LineGraphSeries<DataPoint> series2 = new LineGraphSeries<DataPoint>(new DataPoint[]{

                        });
                        int tam2 = area2.size();
                        for (int i = 0; i < tam2; i++) {
                            int b = area2.get(i).getQtdQuest();
                            DataPoint dp2 = new DataPoint(i, b);
                            series2.appendData(dp2, true, tam2);
                        }
                        series2.setTitle(legend2);
                        series2.setColor(Color.GREEN);
                        series2.setDrawDataPoints(true);
                        series2.setDataPointsRadius(10);
                        series2.setThickness(5);
                        graph.addSeries(series2);

                        if (bundle.containsKey("area3")) {
                            area3 = bundle.getParcelableArrayList("area3");
                            String legend3 = area3.get(0).getAreaNome().toString();
                            LineGraphSeries<DataPoint> series3 = new LineGraphSeries<DataPoint>(new DataPoint[]{

                            });
                            int tam3 = area3.size();
                            for (int i = 0; i < tam3; i++) {
                                int c = area3.get(i).getQtdQuest();
                                DataPoint dp3 = new DataPoint(i, c);
                                series3.appendData(dp3, true, tam3);
                            }
                            series3.setTitle(legend3);
                            series3.setColor(Color.BLUE);
                            series3.setDrawDataPoints(true);
                            series3.setDataPointsRadius(10);
                            series3.setThickness(5);
                            graph.addSeries(series3);

                            if (bundle.containsKey("area4")) {
                                area4 = bundle.getParcelableArrayList("area4");
                                String legend4 = area4.get(0).getAreaNome().toString();
                                LineGraphSeries<DataPoint> series4 = new LineGraphSeries<DataPoint>(new DataPoint[]{

                                });
                                int tam4 = area4.size();
                                for (int i = 0; i < tam4; i++) {
                                    int d = area4.get(i).getQtdQuest();
                                    DataPoint dp4 = new DataPoint(i, d);
                                    series4.appendData(dp4, true, tam4);
                                }
                                series4.setTitle(legend4);
                                series4.setColor(Color.RED);
                                series4.setDrawDataPoints(true);
                                series4.setDataPointsRadius(10);
                                series4.setThickness(5);
                                graph.addSeries(series4);
                            }
                        } else {//if do tres
                            //tem o 1 o 2 e não tem o tres
                            if (bundle.containsKey("area4")) {
                                area4 = bundle.getParcelableArrayList("area4");
                                String legend4 = area4.get(0).getAreaNome().toString();
                                LineGraphSeries<DataPoint> series4 = new LineGraphSeries<DataPoint>(new DataPoint[]{

                                });
                                int tam4 = area4.size();
                                for (int i = 0; i < tam4; i++) {
                                    int d = area4.get(i).getQtdQuest();
                                    DataPoint dp4 = new DataPoint(i, d);
                                    series4.appendData(dp4, true, tam4);
                                }
                                series4.setTitle(legend4);
                                series4.setColor(Color.RED);
                                series4.setDrawDataPoints(true);
                                series4.setDataPointsRadius(10);
                                series4.setThickness(5);
                                graph.addSeries(series4);
                            }
                        }//fim do if do tres
                    } else {//else do dois
                        //tem o 1 mas não tem o dois
                        if (bundle.containsKey("area3")) {
                            area3 = bundle.getParcelableArrayList("area3");
                            String legend3 = area3.get(0).getAreaNome().toString();
                            LineGraphSeries<DataPoint> series3 = new LineGraphSeries<DataPoint>(new DataPoint[]{

                            });
                            int tam3 = area3.size();
                            for (int i = 0; i < tam3; i++) {
                                int c = area3.get(i).getQtdQuest();
                                DataPoint dp3 = new DataPoint(i, c);
                                series3.appendData(dp3, true, tam3);
                            }
                            series3.setTitle(legend3);
                            series3.setColor(Color.BLUE);
                            series3.setDrawDataPoints(true);
                            series3.setDataPointsRadius(10);
                            series3.setThickness(5);
                            graph.addSeries(series3);

                            if (bundle.containsKey("area4")) {
                                area4 = bundle.getParcelableArrayList("area4");
                                String legend4 = area4.get(0).getAreaNome().toString();
                                LineGraphSeries<DataPoint> series4 = new LineGraphSeries<DataPoint>(new DataPoint[]{

                                });
                                int tam4 = area4.size();
                                for (int i = 0; i < tam4; i++) {
                                    int d = area4.get(i).getQtdQuest();
                                    DataPoint dp4 = new DataPoint(i, d);
                                    series4.appendData(dp4, true, tam4);
                                }
                                series4.setTitle(legend4);
                                series4.setColor(Color.RED);
                                series4.setDrawDataPoints(true);
                                series4.setDataPointsRadius(10);
                                series4.setThickness(5);
                                graph.addSeries(series4);
                            }
                        } else {
                            if (bundle.containsKey("area4")) {
                                area4 = bundle.getParcelableArrayList("area4");
                                String legend4 = area4.get(0).getAreaNome().toString();
                                LineGraphSeries<DataPoint> series4 = new LineGraphSeries<DataPoint>(new DataPoint[]{

                                });
                                int tam4 = area4.size();
                                for (int i = 0; i < tam4; i++) {
                                    int d = area4.get(i).getQtdQuest();
                                    DataPoint dp4 = new DataPoint(i, d);
                                    series4.appendData(dp4, true, tam4);
                                }
                                series4.setTitle(legend4);
                                series4.setColor(Color.RED);
                                series4.setDrawDataPoints(true);
                                series4.setDataPointsRadius(10);
                                series4.setThickness(5);
                                graph.addSeries(series4);
                            }
                        }

                    }
                }
                else {//inicio do else 1
                    //else se não tiver o 1
                    if (bundle.containsKey("area2")) {
                        area2 = bundle.getParcelableArrayList("area2");
                        String legend2 = area2.get(0).getAreaNome().toString();
                        LineGraphSeries<DataPoint> series2 = new LineGraphSeries<DataPoint>(new DataPoint[]{

                        });
                        int tam2 = area2.size();
                        for (int i = 0; i < tam2; i++) {
                            String data2 = area2.get(i).getDataRealiz().toString();
                            String[]temp2 = data2.split("-");
                            dias[i] = temp2[0];
                            int b = area2.get(i).getQtdQuest();
                            DataPoint dp2 = new DataPoint(i, b);
                            series2.appendData(dp2, true, tam2);
                        }
                        series2.setTitle(legend2);
                        series2.setColor(Color.GREEN);
                        series2.setDrawDataPoints(true);
                        series2.setDataPointsRadius(10);
                        series2.setThickness(5);
                        graph.addSeries(series2);

                        if (bundle.containsKey("area3")) {
                            area3 = bundle.getParcelableArrayList("area3");
                            String legend3 = area3.get(0).getAreaNome().toString();
                            LineGraphSeries<DataPoint> series3 = new LineGraphSeries<DataPoint>(new DataPoint[]{

                            });
                            int tam3 = area3.size();
                            for (int i = 0; i < tam3; i++) {
                                int c = area3.get(i).getQtdQuest();
                                DataPoint dp3 = new DataPoint(i, c);
                                series3.appendData(dp3, true, tam3);
                            }
                            series3.setTitle(legend3);
                            series3.setColor(Color.BLUE);
                            series3.setDrawDataPoints(true);
                            series3.setDataPointsRadius(10);
                            series3.setThickness(5);
                            graph.addSeries(series3);

                            if (bundle.containsKey("area4")) {
                                area4 = bundle.getParcelableArrayList("area4");
                                String legend4 = area4.get(0).getAreaNome().toString();
                                LineGraphSeries<DataPoint> series4 = new LineGraphSeries<DataPoint>(new DataPoint[]{

                                });
                                int tam4 = area4.size();
                                for (int i = 0; i < tam4; i++) {
                                    int d = area4.get(i).getQtdQuest();
                                    DataPoint dp4 = new DataPoint(i, d);
                                    series4.appendData(dp4, true, tam4);
                                }
                                series4.setTitle(legend4);
                                series4.setColor(Color.RED);
                                series4.setDrawDataPoints(true);
                                series4.setDataPointsRadius(10);
                                series4.setThickness(5);
                                graph.addSeries(series4);
                            }
                        } else {//if do tres
                            //tem o 1 o 2 e não tem o tres
                            if (bundle.containsKey("area4")) {
                                area4 = bundle.getParcelableArrayList("area4");
                                String legend4 = area4.get(0).getAreaNome().toString();
                                LineGraphSeries<DataPoint> series4 = new LineGraphSeries<DataPoint>(new DataPoint[]{

                                });
                                int tam4 = area4.size();
                                for (int i = 0; i < tam4; i++) {
                                    int d = area4.get(i).getQtdQuest();
                                    DataPoint dp4 = new DataPoint(i, d);
                                    series4.appendData(dp4, true, tam4);
                                }
                                series4.setTitle(legend4);
                                series4.setColor(Color.RED);
                                series4.setDrawDataPoints(true);
                                series4.setDataPointsRadius(10);
                                series4.setThickness(5);
                                graph.addSeries(series4);
                            }
                        }//fim do if do tres
                    }
                    else {//else do dois
                        //não tem o 1  não tem o dois
                        if (bundle.containsKey("area3")) {
                            area3 = bundle.getParcelableArrayList("area3");
                            String legend3 = area3.get(0).getAreaNome().toString();
                            LineGraphSeries<DataPoint> series3 = new LineGraphSeries<DataPoint>(new DataPoint[]{

                            });
                            int tam3 = area3.size();
                            for (int i = 0; i < tam3; i++) {
                                String data2 = area2.get(i).getDataRealiz().toString();
                                String[]temp2 = data2.split("-");
                                dias[i] = temp2[0];
                                int c = area3.get(i).getQtdQuest();
                                DataPoint dp3 = new DataPoint(i, c);
                                series3.appendData(dp3, true, tam3);
                            }
                            series3.setTitle(legend3);
                            series3.setColor(Color.BLUE);
                            series3.setDrawDataPoints(true);
                            series3.setDataPointsRadius(10);
                            series3.setThickness(5);
                            graph.addSeries(series3);

                            if (bundle.containsKey("area4")) {
                                area4 = bundle.getParcelableArrayList("area4");
                                String legend4 = area4.get(0).getAreaNome().toString();
                                LineGraphSeries<DataPoint> series4 = new LineGraphSeries<DataPoint>(new DataPoint[]{

                                });
                                int tam4 = area4.size();
                                for (int i = 0; i < tam4; i++) {
                                    int d = area4.get(i).getQtdQuest();
                                    DataPoint dp4 = new DataPoint(i, d);
                                    series4.appendData(dp4, true, tam4);
                                }
                                series4.setTitle(legend4);
                                series4.setColor(Color.RED);
                                series4.setDrawDataPoints(true);
                                series4.setDataPointsRadius(10);
                                series4.setThickness(5);
                                graph.addSeries(series4);
                            }
                        }
                        else {
                            if (bundle.containsKey("area4")) {
                                area4 = bundle.getParcelableArrayList("area4");
                                String legend4 = area4.get(0).getAreaNome().toString();
                                LineGraphSeries<DataPoint> series4 = new LineGraphSeries<DataPoint>(new DataPoint[]{

                                });
                                int tam4 = area4.size();
                                for (int i = 0; i < tam4; i++) {
                                    String data2 = area2.get(i).getDataRealiz().toString();
                                    String[]temp2 = data2.split("-");
                                    dias[i] = temp2[0];
                                    int d = area4.get(i).getQtdQuest();
                                    DataPoint dp4 = new DataPoint(i, d);
                                    series4.appendData(dp4, true, tam4);
                                }
                                series4.setTitle(legend4);
                                series4.setColor(Color.RED);
                                series4.setDrawDataPoints(true);
                                series4.setDataPointsRadius(10);
                                series4.setThickness(5);
                                graph.addSeries(series4);
                            }
                        }
                    }
                }//fim do else 1
                StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(graph);
                staticLabelsFormatter.setHorizontalLabels(dias);
                graph.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);
                graph.getGridLabelRenderer().setNumHorizontalLabels(8);
                graph.getLegendRenderer().setVisible(true);
                graph.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.BOTTOM);

                break;
            case 2:
                String [] areasNomes = new String[6];
                areasNomes[0] = "";
                int totalResp, totalResp2, totalResp3, totalResp4;
                int respCertas, respCertas2, respCertas3, respCertas4;
                int respErradas, respErradas2, respErradas3, respErradas4;
                int ordem = 0;

                BarGraphSeries<DataPoint> series = new BarGraphSeries<>(new DataPoint[] {
                        new DataPoint(0, 0),
                        //new DataPoint(5, 0)
                });
                BarGraphSeries<DataPoint> series2 = new BarGraphSeries<>(new DataPoint[] {
                        new DataPoint(0, 0),
                        //new DataPoint(5, 0)
                });
                BarGraphSeries<DataPoint> series3 = new BarGraphSeries<>(new DataPoint[] {
                        new DataPoint(0, 0),
                       // new DataPoint(5, 0)
                });
                if (bundle.containsKey("area1")){
                    area1 = bundle.getParcelableArrayList("area1");
                    respCertas = 0;
                    respErradas = 0;
                    totalResp = 0;
                    int tam = area1.size();
                    for (int i=0; i< tam; i++){
                        respCertas += area1.get(i).getRespCerta();
                        respErradas += area1.get(i).getRespErrada();
                    }
                    totalResp = respCertas + respErradas;
                    ordem +=1;
                    DataPoint dp = new DataPoint(ordem, totalResp);
                    DataPoint dpa = new DataPoint(ordem, respCertas);
                    DataPoint dpb = new DataPoint(ordem, respErradas);

                    if (bundle.containsKey("area2")) {
                        area2 = bundle.getParcelableArrayList("area2");
                        respCertas2 = 0;
                        respErradas2 = 0;
                        totalResp2 = 0;
                        int tam2 = area2.size();
                        for (int i = 0; i < tam2; i++) {
                            respCertas2 += area2.get(i).getRespCerta();
                            respErradas2 += area2.get(i).getRespErrada();
                        }
                        totalResp2 = respCertas2 + respErradas2;
                        ordem +=1;
                        DataPoint dp2 = new DataPoint(ordem, totalResp2);
                        DataPoint dp2a = new DataPoint(ordem, respCertas2);
                        DataPoint dp2b = new DataPoint(ordem, respErradas2);

                        if (bundle.containsKey("area3")) {
                            area3 = bundle.getParcelableArrayList("area3");
                            respCertas3 = 0;
                            respErradas3 = 0;
                            totalResp3 = 0;
                            int tam3 = area3.size();
                            for (int i = 0; i < tam3; i++) {
                                respCertas3 += area3.get(i).getRespCerta();
                                respErradas3 += area3.get(i).getRespErrada();
                            }
                            totalResp3 = respCertas3 + respErradas3;
                            ordem +=1;
                            DataPoint dp3 = new DataPoint(ordem, totalResp3);
                            DataPoint dp3a = new DataPoint(ordem, respCertas3);
                            DataPoint dp3b = new DataPoint(ordem, respErradas3);

                            if (bundle.containsKey("area4")) {
                                area4 = bundle.getParcelableArrayList("area4");
                                respCertas4 = 0;
                                respErradas4 = 0;
                                totalResp4 = 0;
                                int tam4 = area4.size();
                                for (int i = 0; i < tam4; i++) {
                                    respCertas4 += area4.get(i).getRespCerta();
                                    respErradas4 += area4.get(i).getRespErrada();
                                }
                                totalResp4 = respCertas4 + respErradas4;
                                ordem +=1;
                                DataPoint dp4 = new DataPoint(ordem, totalResp4);
                                DataPoint dp4a = new DataPoint(ordem, respCertas4);
                                DataPoint dp4b = new DataPoint(ordem, respErradas4);
                                ordem +=1;
                                DataPoint dpe = new DataPoint(ordem, 0);

                                series.appendData(dp, true, 6);
                                series.appendData(dp2, true, 6);
                                series.appendData(dp3, true, 6);
                                series.appendData(dp4, true, 6);

                                series2.appendData(dpa, true, 6);
                                series2.appendData(dp2a, true, 6);
                                series2.appendData(dp3a, true, 6);
                                series2.appendData(dp4a, true, 6);

                                series3.appendData(dpb, true, 6);
                                series3.appendData(dp2b, true, 6);
                                series3.appendData(dp3b, true, 6);
                                series3.appendData(dp4b, true, 6);
                                series3.appendData(dpe, true, 6);

                            }
                            else{//Tem 1, 2, 3 e não tem o 4
                                ordem +=1;
                                DataPoint dpe = new DataPoint(ordem, 0);
                                series.appendData(dp, true, 6);
                                series.appendData(dp2, true, 6);
                                series.appendData(dp3, true, 6);
                                series2.appendData(dpa, true, 6);
                                series2.appendData(dp2a, true, 6);
                                series2.appendData(dp3a, true, 6);
                                series3.appendData(dpb, true, 6);
                                series3.appendData(dp2b, true, 6);
                                series3.appendData(dp3b, true, 6);
                                series3.appendData(dpe, true, 6);
                            }

                        }//final if 3
                        else{
                            //tem 1 e 2 não tem 3
                            if (bundle.containsKey("area4")) {
                                area4 = bundle.getParcelableArrayList("area4");
                                respCertas4 = 0;
                                respErradas4 = 0;
                                totalResp4 = 0;
                                int tam4 = area4.size();
                                for (int i = 0; i < tam4; i++) {
                                    respCertas4 += area4.get(i).getRespCerta();
                                    respErradas4 += area4.get(i).getRespErrada();
                                }
                                totalResp4 = respCertas4 + respErradas4;
                                ordem +=1;
                                DataPoint dp4 = new DataPoint(ordem, totalResp4);
                                DataPoint dp4a = new DataPoint(ordem, respCertas4);
                                DataPoint dp4b = new DataPoint(ordem, respErradas4);
                                ordem +=1;
                                DataPoint dpe = new DataPoint(ordem, 0);

                                series.appendData(dp, true, 6);
                                series.appendData(dp2, true, 6);
                                series.appendData(dp4, true, 6);
                                series2.appendData(dpa, true, 6);
                                series2.appendData(dp2a, true, 6);
                                series3.appendData(dp4a, true, 6);
                                series3.appendData(dpb, true, 6);
                                series3.appendData(dp2b, true, 6);
                                series3.appendData(dp4b, true, 6);
                                series3.appendData(dpe, true, 6);

                            }
                            else{//Tem 1, 2, 3 e não tem o 4
                                ordem +=1;
                                DataPoint dpe = new DataPoint(ordem, 0);
                                series.appendData(dp, true, 6);
                                series.appendData(dp2, true, 6);
                                series2.appendData(dpa, true, 6);
                                series2.appendData(dp2a, true, 6);
                                series3.appendData(dpb, true, 6);
                                series3.appendData(dp2b, true, 6);
                                series3.appendData(dpe, true, 6);
                            }
                        }
                    }//fim do if2
                    else{
                        //tenho 1 não tem o 2
                        if (bundle.containsKey("area3")) {
                            area3 = bundle.getParcelableArrayList("area3");
                            respCertas3 = 0;
                            respErradas3 = 0;
                            totalResp3 = 0;
                            int tam3 = area3.size();
                            for (int i = 0; i < tam3; i++) {
                                respCertas3 += area3.get(i).getRespCerta();
                                respErradas3 += area3.get(i).getRespErrada();
                            }
                            totalResp3 = respCertas3 + respErradas3;
                            ordem +=1;
                            DataPoint dp3 = new DataPoint(ordem, totalResp3);
                            DataPoint dp3a = new DataPoint(ordem, respCertas3);
                            DataPoint dp3b = new DataPoint(ordem, respErradas3);

                            if (bundle.containsKey("area4")) {
                                area4 = bundle.getParcelableArrayList("area4");
                                respCertas4 = 0;
                                respErradas4 = 0;
                                totalResp4 = 0;
                                int tam4 = area4.size();
                                for (int i = 0; i < tam4; i++) {
                                    respCertas4 += area4.get(i).getRespCerta();
                                    respErradas4 += area4.get(i).getRespErrada();
                                }
                                totalResp4 = respCertas4 + respErradas4;
                                ordem +=1;
                                DataPoint dp4 = new DataPoint(ordem, totalResp4);
                                DataPoint dp4a = new DataPoint(ordem, respCertas4);
                                DataPoint dp4b = new DataPoint(ordem, respErradas4);
                                ordem +=1;
                                DataPoint dpe = new DataPoint(ordem, 0);

                                series.appendData(dp, true, 6);
                                series.appendData(dp3, true, 6);
                                series.appendData(dp4, true, 6);
                                series2.appendData(dpa, true, 6);
                                series2.appendData(dp3a, true, 6);
                                series2.appendData(dp4a, true, 6);
                                series3.appendData(dpb, true, 6);;
                                series3.appendData(dp3b, true, 6);
                                series3.appendData(dp4b, true, 6);
                                series3.appendData(dpe, true, 6);

                            }
                            else{//Tem 1, não tem oo 2, tem o 3 e não tem o 4
                                ordem +=1;
                                DataPoint dpe = new DataPoint(ordem, 0);
                                series.appendData(dp, true, 6);
                                series.appendData(dp3, true, 6);
                                series2.appendData(dpa, true, 6);
                                series2.appendData(dp3a, true, 6);
                                series3.appendData(dpb, true, 6);
                                series3.appendData(dp3b, true, 6);
                                series3.appendData(dpe, true, 6);
                            }

                        }//final if 3
                        else {
                            //tem 1 e não tem o 2 não tem 3
                            if (bundle.containsKey("area4")) {
                                area4 = bundle.getParcelableArrayList("area4");
                                respCertas4 = 0;
                                respErradas4 = 0;
                                totalResp4 = 0;
                                int tam4 = area4.size();
                                for (int i = 0; i < tam4; i++) {
                                    respCertas4 += area4.get(i).getRespCerta();
                                    respErradas4 += area4.get(i).getRespErrada();
                                }
                                totalResp4 = respCertas4 + respErradas4;
                                ordem += 1;
                                DataPoint dp4 = new DataPoint(ordem, totalResp4);
                                DataPoint dp4a = new DataPoint(ordem, respCertas4);
                                DataPoint dp4b = new DataPoint(ordem, respErradas4);
                                ordem +=1;
                                DataPoint dpe = new DataPoint(ordem, 0);

                                series.appendData(dp, true, 6);
                                series.appendData(dp4, true, 6);
                                series2.appendData(dpa, true, 6);
                                series2.appendData(dp4a, true, 6);
                                series3.appendData(dpb, true, 6);
                                series3.appendData(dp4b, true, 6);
                                series3.appendData(dpe, true, 6);

                            } else {//Tem 1, não tem 2, não 3 e não tem o 4
                                ordem +=1;
                                DataPoint dpe = new DataPoint(ordem, 0);
                                series.appendData(dp, true, 6);
                                series2.appendData(dpa, true, 6);
                                series3.appendData(dpb, true, 6);
                                series3.appendData(dpe, true, 6);
                            }
                        }
                    }
                }
                else{
                    //não contenm 1
                    if (bundle.containsKey("area2")) {
                        area2 = bundle.getParcelableArrayList("area2");
                        respCertas2 = 0;
                        respErradas2 = 0;
                        totalResp2 = 0;
                        int tam2 = area2.size();
                        for (int i = 0; i < tam2; i++) {
                            respCertas2 += area2.get(i).getRespCerta();
                            respErradas2 += area2.get(i).getRespErrada();
                        }
                        totalResp2 = respCertas2 + respErradas2;
                        ordem +=1;
                        DataPoint dp2 = new DataPoint(ordem, totalResp2);
                        DataPoint dp2a = new DataPoint(ordem, respCertas2);
                        DataPoint dp2b = new DataPoint(ordem, respErradas2);

                        if (bundle.containsKey("area3")) {
                            area3 = bundle.getParcelableArrayList("area3");
                            respCertas3 = 0;
                            respErradas3 = 0;
                            totalResp3 = 0;
                            int tam3 = area3.size();
                            for (int i = 0; i < tam3; i++) {
                                respCertas3 += area3.get(i).getRespCerta();
                                respErradas3 += area3.get(i).getRespErrada();
                            }
                            totalResp3 = respCertas3 + respErradas3;
                            ordem +=1;
                            DataPoint dp3 = new DataPoint(ordem, totalResp3);
                            DataPoint dp3a = new DataPoint(ordem, respCertas3);
                            DataPoint dp3b = new DataPoint(ordem, respErradas3);

                            if (bundle.containsKey("area4")) {
                                area4 = bundle.getParcelableArrayList("area4");
                                respCertas4 = 0;
                                respErradas4 = 0;
                                totalResp4 = 0;
                                int tam4 = area4.size();
                                for (int i = 0; i < tam4; i++) {
                                    respCertas4 += area4.get(i).getRespCerta();
                                    respErradas4 += area4.get(i).getRespErrada();
                                }
                                totalResp4 = respCertas4 + respErradas4;
                                ordem +=1;
                                DataPoint dp4 = new DataPoint(ordem, totalResp4);
                                DataPoint dp4a = new DataPoint(ordem, respCertas4);
                                DataPoint dp4b = new DataPoint(ordem, respErradas4);
                                ordem +=1;
                                DataPoint dpe = new DataPoint(ordem, 0);

                                series.appendData(dp2, true, 6);
                                series.appendData(dp3, true, 6);
                                series.appendData(dp4, true, 6);
                                series2.appendData(dp2a, true, 6);
                                series2.appendData(dp3a, true, 6);
                                series2.appendData(dp4a, true, 6);
                                series3.appendData(dp2b, true, 6);
                                series3.appendData(dp3b, true, 6);
                                series3.appendData(dp4b, true, 6);
                                series3.appendData(dpe, true, 6);
                            }
                            else{//Tem 1, 2, 3 e não tem o 4
                                ordem +=1;
                                DataPoint dpe = new DataPoint(ordem, 0);

                                series.appendData(dp2, true, 6);
                                series.appendData(dp3, true, 6);
                                series2.appendData(dp2a, true, 6);
                                series2.appendData(dp3a, true, 6);
                                series3.appendData(dp2b, true, 6);
                                series3.appendData(dp3b, true, 6);
                                series3.appendData(dpe, true, 6);
                            }

                        }//final if 3
                        else{
                            //tem  e 2 não tem 1 e 3
                            if (bundle.containsKey("area4")) {
                                area4 = bundle.getParcelableArrayList("area4");
                                respCertas4 = 0;
                                respErradas4 = 0;
                                totalResp4 = 0;
                                int tam4 = area4.size();
                                for (int i = 0; i < tam4; i++) {
                                    respCertas4 += area4.get(i).getRespCerta();
                                    respErradas4 += area4.get(i).getRespErrada();
                                }
                                totalResp4 = respCertas4 + respErradas4;
                                ordem +=1;
                                DataPoint dp4 = new DataPoint(ordem, totalResp4);
                                DataPoint dp4a = new DataPoint(ordem, respCertas4);
                                DataPoint dp4b = new DataPoint(ordem, respErradas4);
                                ordem +=1;
                                DataPoint dpe = new DataPoint(ordem, 0);

                                series.appendData(dp2, true, 6);
                                series.appendData(dp4, true, 6);
                                series2.appendData(dp2a, true, 6);
                                series2.appendData(dp4a, true, 6);
                                series3.appendData(dp2b, true, 6);
                                series3.appendData(dp4b, true, 6);
                                series3.appendData(dpe, true, 6);
                            }
                            else{//Tem 1, 2, 3 e não tem o 4
                                ordem +=1;
                                DataPoint dpe = new DataPoint(ordem, 0);
                                series.appendData(dp2, true, 6);
                                series2.appendData(dp2a, true, 6);
                                series3.appendData(dp2b, true, 6);
                                series3.appendData(dpe, true, 6);
                            }
                        }
                    }//fim do if2
                    else{
                        // não tenho 1 não tem o 2
                        if (bundle.containsKey("area3")) {
                            area3 = bundle.getParcelableArrayList("area3");
                            respCertas3 = 0;
                            respErradas3 = 0;
                            totalResp3 = 0;
                            int tam3 = area3.size();
                            for (int i = 0; i < tam3; i++) {
                                respCertas3 += area3.get(i).getRespCerta();
                                respErradas3 += area3.get(i).getRespErrada();
                            }
                            totalResp3 = respCertas3 + respErradas3;
                            ordem +=1;
                            DataPoint dp3 = new DataPoint(ordem, totalResp3);
                            DataPoint dp3a = new DataPoint(ordem, respCertas3);
                            DataPoint dp3b = new DataPoint(ordem, respErradas3);

                            if (bundle.containsKey("area4")) {
                                area4 = bundle.getParcelableArrayList("area4");
                                respCertas4 = 0;
                                respErradas4 = 0;
                                totalResp4 = 0;
                                int tam4 = area4.size();
                                for (int i = 0; i < tam4; i++) {
                                    respCertas4 += area4.get(i).getRespCerta();
                                    respErradas4 += area4.get(i).getRespErrada();
                                }
                                totalResp4 = respCertas4 + respErradas4;
                                ordem +=1;
                                DataPoint dp4 = new DataPoint(ordem, totalResp4);
                                DataPoint dp4a = new DataPoint(ordem, respCertas4);
                                DataPoint dp4b = new DataPoint(ordem, respErradas4);
                                ordem +=1;
                                DataPoint dpe = new DataPoint(ordem, 0);

                                series.appendData(dp3, true, 6);
                                series.appendData(dp4, true, 6);
                                series2.appendData(dp3a, true, 6);
                                series2.appendData(dp4a, true, 6);
                                series3.appendData(dp3b, true, 6);
                                series3.appendData(dp4b, true, 6);
                                series3.appendData(dpe, true, 6);
                            }
                            else{//Não Tem 1, não tem oo 2, tem o 3 e não tem o 4
                                ordem += 1;
                                DataPoint dpe = new DataPoint(ordem, 0);
                                series.appendData(dp3, true, 6);
                                series2.appendData(dp3a, true, 6);
                                series3.appendData(dp3b, true, 6);
                                series3.appendData(dpe, true, 6);
                            }

                        }//final if 3
                        else {
                            //não tem 1 e não tem o 2 não tem 3
                            if (bundle.containsKey("area4")) {
                                area4 = bundle.getParcelableArrayList("area4");
                                respCertas4 = 0;
                                respErradas4 = 0;
                                totalResp4 = 0;
                                int tam4 = area4.size();
                                for (int i = 0; i < tam4; i++) {
                                    respCertas4 += area4.get(i).getRespCerta();
                                    respErradas4 += area4.get(i).getRespErrada();
                                }
                                totalResp4 = respCertas4 + respErradas4;
                                ordem += 1;
                                DataPoint dp4 = new DataPoint(ordem, totalResp4);
                                DataPoint dp4a = new DataPoint(ordem, respCertas4);
                                DataPoint dp4b = new DataPoint(ordem, respErradas4);
                                ordem +=1;
                                DataPoint dpe = new DataPoint(ordem, 0);

                                series.appendData(dp4, true, 6);
                                series2.appendData(dp4a, true, 6);
                                series3.appendData(dp4b, true, 6);
                                series3.appendData(dpe, true, 6);
                            }
                        }
                    }
                }

                graph.addSeries(series);
                graph.addSeries(series2);
                graph.addSeries(series3);

                series.setSpacing(10);
                series2.setSpacing(10);
                series3.setSpacing(10);
                // draw values on top
                series.setTitle("Total Respondido");
                series.setColor(Color.GRAY);
                series.setDrawValuesOnTop(true);
                series.setValuesOnTopColor(Color.BLACK);
                series.setValuesOnTopSize(30);

                series2.setTitle("Respostas Certas");
                series2.setColor(Color.BLUE);
                series2.setDrawValuesOnTop(true);
                series2.setValuesOnTopColor(Color.BLUE);
                series2.setValuesOnTopSize(30);

                series3.setTitle("Respostas Erradas");
                series3.setColor(Color.RED);
                series3.setDrawValuesOnTop(true);
                series3.setValuesOnTopColor(Color.RED);
                series3.setValuesOnTopSize(30);

                graph.getLegendRenderer().setVisible(true);
                graph.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);
                graph.getLegendRenderer().setFixedPosition(400, -10);
                graph.getLegendRenderer().setBackgroundColor(Color.WHITE);

                String[] dias2 = new String[] {"","Area1", "Area 2", "Area 3", "Area 4", ""};
                staticLabelsFormatter = new StaticLabelsFormatter(graph);
                staticLabelsFormatter.setHorizontalLabels(dias2);
                graph.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);
                graph.getGridLabelRenderer().setNumHorizontalLabels(6);
                break;
            case 3:
                // criar grafico 3
                if(bundle.containsKey("tempo")){
                    area1 = bundle.getParcelableArrayList("tempo");

                    String legend = "Tempo de estudos diários em minutos";
                    LineGraphSeries<DataPoint> seriesTempo = new LineGraphSeries<DataPoint>(new DataPoint[]{
                            new DataPoint(0, 0),
                    });
                    String[] diasTempo = new String[8];
                    diasTempo[0] = "00/00";
                    String[] tempy = new String [6]; //{"00:00", "01:00", "02:00", "03:00", "04:00", "06:00", "08:00" };
                    //tempy[0] = "00:00";
                    int tam = area1.size();

                    for (int i = 0; i < tam; i++) {
                        String data = area1.get(i).getDataRealiz().toString();
                        String[] temp = data.split("-");


                        long a = area1.get(i).getTempAtivo() * 1000;
                        long minutos = (a / 60000)%60;
                        long horas = a / 3600000;

                        String t = String.format("%2d:%2d", horas, minutos);

                        int k = i+1;
                        diasTempo[k] = temp[0]+"/"+temp[1];
                        tempy[k] = t;

                        DataPoint dp = new DataPoint(k, minutos);
                        seriesTempo.appendData(dp, true, tam);

                    }
                    seriesTempo.setTitle(legend);
                    seriesTempo.setColor(Color.BLUE);
                    seriesTempo.setDrawDataPoints(true);
                    seriesTempo.setDataPointsRadius(10);
                    seriesTempo.setThickness(5);
                    graph.addSeries(seriesTempo);

                    staticLabelsFormatter = new StaticLabelsFormatter(graph);
                    staticLabelsFormatter.setHorizontalLabels(diasTempo);
                    staticLabelsFormatter.setVerticalLabels(tempy);
                    graph.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);
                    graph.getGridLabelRenderer().setNumHorizontalLabels(7);
                    graph.getGridLabelRenderer().setNumVerticalLabels(7);

                }
                else{
                    Toast.makeText(this, "Não chegou nenhum dado para a construção do gráfico no período", Toast.LENGTH_LONG).show();
                }

                break;
            case 4:
                //implantar grafico 4
                String[] diasCompac = new String[8];
                if (bundle.containsKey("area1")) {
                    area1 = bundle.getParcelableArrayList("area1");
                    String legend = area1.get(0).getAreaNome().toString();
                    LineGraphSeries<DataPoint> seriesCompac = new LineGraphSeries<DataPoint>(new DataPoint[]{

                    });
                    int tam = area1.size();
                    for (int i = 0; i < tam; i++) {
                        String data = area1.get(i).getDataRealiz().toString();
                        String[] temp = data.split("-");
                        diasCompac[i] = temp[0];
                        int a = area1.get(i).getQtdQuest();
                        DataPoint dp = new DataPoint(i, a);
                        seriesCompac.appendData(dp, true, tam);
                    }
                    seriesCompac.setTitle(legend);
                    seriesCompac.setColor(Color.BLACK);
                    seriesCompac.setDrawDataPoints(true);
                    seriesCompac.setDataPointsRadius(10);
                    seriesCompac.setThickness(5);
                    graph.addSeries(seriesCompac);
                    if (bundle.containsKey("area2")) {
                        area2 = bundle.getParcelableArrayList("area2");
                        String legend2 = area2.get(0).getAreaNome().toString();
                        LineGraphSeries<DataPoint> seriesCompac2 = new LineGraphSeries<DataPoint>(new DataPoint[]{

                        });
                        int tam2 = area2.size();
                        for (int i = 0; i < tam2; i++) {
                            int b = area2.get(i).getQtdQuest();
                            DataPoint dp2 = new DataPoint(i, b);
                            seriesCompac2.appendData(dp2, true, tam2);
                        }
                        seriesCompac2.setTitle(legend2);
                        seriesCompac2.setColor(Color.GREEN);
                        seriesCompac2.setDrawDataPoints(true);
                        seriesCompac2.setDataPointsRadius(10);
                        seriesCompac2.setThickness(5);
                        graph.addSeries(seriesCompac2);

                        if (bundle.containsKey("area3")) {
                            area3 = bundle.getParcelableArrayList("area3");
                            String legend3 = area3.get(0).getAreaNome().toString();
                            LineGraphSeries<DataPoint> seriesCompac3 = new LineGraphSeries<DataPoint>(new DataPoint[]{

                            });
                            int tam3 = area3.size();
                            for (int i = 0; i < tam3; i++) {
                                int c = area3.get(i).getQtdQuest();
                                DataPoint dp3 = new DataPoint(i, c);
                                seriesCompac3.appendData(dp3, true, tam3);
                            }
                            seriesCompac3.setTitle(legend3);
                            seriesCompac3.setColor(Color.BLUE);
                            seriesCompac3.setDrawDataPoints(true);
                            seriesCompac3.setDataPointsRadius(10);
                            seriesCompac3.setThickness(5);
                            graph.addSeries(seriesCompac3);

                            if (bundle.containsKey("area4")) {
                                area4 = bundle.getParcelableArrayList("area4");
                                String legend4 = area4.get(0).getAreaNome().toString();
                                LineGraphSeries<DataPoint> seriesCompac4 = new LineGraphSeries<DataPoint>(new DataPoint[]{

                                });
                                int tam4 = area4.size();
                                for (int i = 0; i < tam4; i++) {
                                    int d = area4.get(i).getQtdQuest();
                                    DataPoint dp4 = new DataPoint(i, d);
                                    seriesCompac4.appendData(dp4, true, tam4);
                                }
                                seriesCompac4.setTitle(legend4);
                                seriesCompac4.setColor(Color.RED);
                                seriesCompac4.setDrawDataPoints(true);
                                seriesCompac4.setDataPointsRadius(10);
                                seriesCompac4.setThickness(5);
                                graph.addSeries(seriesCompac4);
                            }
                        } else {//if do tres
                            //tem o 1 o 2 e não tem o tres
                            if (bundle.containsKey("area4")) {
                                area4 = bundle.getParcelableArrayList("area4");
                                String legend4 = area4.get(0).getAreaNome().toString();
                                LineGraphSeries<DataPoint> seriesCompac4 = new LineGraphSeries<DataPoint>(new DataPoint[]{

                                });
                                int tam4 = area4.size();
                                for (int i = 0; i < tam4; i++) {
                                    int d = area4.get(i).getQtdQuest();
                                    DataPoint dp4 = new DataPoint(i, d);
                                    seriesCompac4.appendData(dp4, true, tam4);
                                }
                                seriesCompac4.setTitle(legend4);
                                seriesCompac4.setColor(Color.RED);
                                seriesCompac4.setDrawDataPoints(true);
                                seriesCompac4.setDataPointsRadius(10);
                                seriesCompac4.setThickness(5);
                                graph.addSeries(seriesCompac4);
                            }
                        }//fim do if do tres
                    } else {//else do dois
                        //tem o 1 mas não tem o dois
                        if (bundle.containsKey("area3")) {
                            area3 = bundle.getParcelableArrayList("area3");
                            String legend3 = area3.get(0).getAreaNome().toString();
                            LineGraphSeries<DataPoint> seriesCompac3 = new LineGraphSeries<DataPoint>(new DataPoint[]{

                            });
                            int tam3 = area3.size();
                            for (int i = 0; i < tam3; i++) {
                                int c = area3.get(i).getQtdQuest();
                                DataPoint dp3 = new DataPoint(i, c);
                                seriesCompac3.appendData(dp3, true, tam3);
                            }
                            seriesCompac3.setTitle(legend3);
                            seriesCompac3.setColor(Color.BLUE);
                            seriesCompac3.setDrawDataPoints(true);
                            seriesCompac3.setDataPointsRadius(10);
                            seriesCompac3.setThickness(5);
                            graph.addSeries(seriesCompac3);

                            if (bundle.containsKey("area4")) {
                                area4 = bundle.getParcelableArrayList("area4");
                                String legend4 = area4.get(0).getAreaNome().toString();
                                LineGraphSeries<DataPoint> seriesCompac4 = new LineGraphSeries<DataPoint>(new DataPoint[]{

                                });
                                int tam4 = area4.size();
                                for (int i = 0; i < tam4; i++) {
                                    int d = area4.get(i).getQtdQuest();
                                    DataPoint dp4 = new DataPoint(i, d);
                                    seriesCompac4.appendData(dp4, true, tam4);
                                }
                                seriesCompac4.setTitle(legend4);
                                seriesCompac4.setColor(Color.RED);
                                seriesCompac4.setDrawDataPoints(true);
                                seriesCompac4.setDataPointsRadius(10);
                                seriesCompac4.setThickness(5);
                                graph.addSeries(seriesCompac4);
                            }
                        } else {
                            if (bundle.containsKey("area4")) {
                                area4 = bundle.getParcelableArrayList("area4");
                                String legend4 = area4.get(0).getAreaNome().toString();
                                LineGraphSeries<DataPoint> seriesCompac4 = new LineGraphSeries<DataPoint>(new DataPoint[]{

                                });
                                int tam4 = area4.size();
                                for (int i = 0; i < tam4; i++) {
                                    int d = area4.get(i).getQtdQuest();
                                    DataPoint dp4 = new DataPoint(i, d);
                                    seriesCompac4.appendData(dp4, true, tam4);
                                }
                                seriesCompac4.setTitle(legend4);
                                seriesCompac4.setColor(Color.RED);
                                seriesCompac4.setDrawDataPoints(true);
                                seriesCompac4.setDataPointsRadius(10);
                                seriesCompac4.setThickness(5);
                                graph.addSeries(seriesCompac4);
                            }
                        }

                    }
                }
                else {//inicio do else 1
                    //else se não tiver o 1
                    if (bundle.containsKey("area2")) {
                        area2 = bundle.getParcelableArrayList("area2");
                        String legend2 = area2.get(0).getAreaNome().toString();
                        LineGraphSeries<DataPoint> seriesCompac2 = new LineGraphSeries<DataPoint>(new DataPoint[]{

                        });
                        int tam2 = area2.size();
                        for (int i = 0; i < tam2; i++) {
                            String data2 = area2.get(i).getDataRealiz().toString();
                            String[]temp2 = data2.split("-");
                            diasCompac[i] = temp2[0];
                            int b = area2.get(i).getQtdQuest();
                            DataPoint dp2 = new DataPoint(i, b);
                            seriesCompac2.appendData(dp2, true, tam2);
                        }
                        seriesCompac2.setTitle(legend2);
                        seriesCompac2.setColor(Color.GREEN);
                        seriesCompac2.setDrawDataPoints(true);
                        seriesCompac2.setDataPointsRadius(10);
                        seriesCompac2.setThickness(5);
                        graph.addSeries(seriesCompac2);

                        if (bundle.containsKey("area3")) {
                            area3 = bundle.getParcelableArrayList("area3");
                            String legend3 = area3.get(0).getAreaNome().toString();
                            LineGraphSeries<DataPoint> seriesCompac3 = new LineGraphSeries<DataPoint>(new DataPoint[]{

                            });
                            int tam3 = area3.size();
                            for (int i = 0; i < tam3; i++) {
                                int c = area3.get(i).getQtdQuest();
                                DataPoint dp3 = new DataPoint(i, c);
                                seriesCompac3.appendData(dp3, true, tam3);
                            }
                            seriesCompac3.setTitle(legend3);
                            seriesCompac3.setColor(Color.BLUE);
                            seriesCompac3.setDrawDataPoints(true);
                            seriesCompac3.setDataPointsRadius(10);
                            seriesCompac3.setThickness(5);
                            graph.addSeries(seriesCompac3);

                            if (bundle.containsKey("area4")) {
                                area4 = bundle.getParcelableArrayList("area4");
                                String legend4 = area4.get(0).getAreaNome().toString();
                                LineGraphSeries<DataPoint> seriesCompac4 = new LineGraphSeries<DataPoint>(new DataPoint[]{

                                });
                                int tam4 = area4.size();
                                for (int i = 0; i < tam4; i++) {
                                    int d = area4.get(i).getQtdQuest();
                                    DataPoint dp4 = new DataPoint(i, d);
                                    seriesCompac4.appendData(dp4, true, tam4);
                                }
                                seriesCompac4.setTitle(legend4);
                                seriesCompac4.setColor(Color.RED);
                                seriesCompac4.setDrawDataPoints(true);
                                seriesCompac4.setDataPointsRadius(10);
                                seriesCompac4.setThickness(5);
                                graph.addSeries(seriesCompac4);
                            }
                        } else {//if do tres
                            //tem o 1 o 2 e não tem o tres
                            if (bundle.containsKey("area4")) {
                                area4 = bundle.getParcelableArrayList("area4");
                                String legend4 = area4.get(0).getAreaNome().toString();
                                LineGraphSeries<DataPoint> seriesCompac4 = new LineGraphSeries<DataPoint>(new DataPoint[]{

                                });
                                int tam4 = area4.size();
                                for (int i = 0; i < tam4; i++) {
                                    int d = area4.get(i).getQtdQuest();
                                    DataPoint dp4 = new DataPoint(i, d);
                                    seriesCompac4.appendData(dp4, true, tam4);
                                }
                                seriesCompac4.setTitle(legend4);
                                seriesCompac4.setColor(Color.RED);
                                seriesCompac4.setDrawDataPoints(true);
                                seriesCompac4.setDataPointsRadius(10);
                                seriesCompac4.setThickness(5);
                                graph.addSeries(seriesCompac4);
                            }
                        }//fim do if do tres
                    }
                    else {//else do dois
                        //não tem o 1  não tem o dois
                        if (bundle.containsKey("area3")) {
                            area3 = bundle.getParcelableArrayList("area3");
                            String legend3 = area3.get(0).getAreaNome().toString();
                            LineGraphSeries<DataPoint> seriesCompac3 = new LineGraphSeries<DataPoint>(new DataPoint[]{

                            });
                            int tam3 = area3.size();
                            for (int i = 0; i < tam3; i++) {
                                String data2 = area2.get(i).getDataRealiz().toString();
                                String[]temp2 = data2.split("-");
                                diasCompac[i] = temp2[0];
                                int c = area3.get(i).getQtdQuest();
                                DataPoint dp3 = new DataPoint(i, c);
                                seriesCompac3.appendData(dp3, true, tam3);
                            }
                            seriesCompac3.setTitle(legend3);
                            seriesCompac3.setColor(Color.BLUE);
                            seriesCompac3.setDrawDataPoints(true);
                            seriesCompac3.setDataPointsRadius(10);
                            seriesCompac3.setThickness(5);
                            graph.addSeries(seriesCompac3);

                            if (bundle.containsKey("area4")) {
                                area4 = bundle.getParcelableArrayList("area4");
                                String legend4 = area4.get(0).getAreaNome().toString();
                                LineGraphSeries<DataPoint> seriesCompac4 = new LineGraphSeries<DataPoint>(new DataPoint[]{

                                });
                                int tam4 = area4.size();
                                for (int i = 0; i < tam4; i++) {
                                    int d = area4.get(i).getQtdQuest();
                                    DataPoint dp4 = new DataPoint(i, d);
                                    seriesCompac4.appendData(dp4, true, tam4);
                                }
                                seriesCompac4.setTitle(legend4);
                                seriesCompac4.setColor(Color.RED);
                                seriesCompac4.setDrawDataPoints(true);
                                seriesCompac4.setDataPointsRadius(10);
                                seriesCompac4.setThickness(5);
                                graph.addSeries(seriesCompac4);
                            }
                        }
                        else {
                            if (bundle.containsKey("area4")) {
                                area4 = bundle.getParcelableArrayList("area4");
                                String legend4 = area4.get(0).getAreaNome().toString();
                                LineGraphSeries<DataPoint> seriesCompac4 = new LineGraphSeries<DataPoint>(new DataPoint[]{

                                });
                                int tam4 = area4.size();
                                for (int i = 0; i < tam4; i++) {
                                    String data2 = area2.get(i).getDataRealiz().toString();
                                    String[]temp2 = data2.split("-");
                                    diasCompac[i] = temp2[0];
                                    int d = area4.get(i).getQtdQuest();
                                    DataPoint dp4 = new DataPoint(i, d);
                                    seriesCompac4.appendData(dp4, true, tam4);
                                }
                                seriesCompac4.setTitle(legend4);
                                seriesCompac4.setColor(Color.RED);
                                seriesCompac4.setDrawDataPoints(true);
                                seriesCompac4.setDataPointsRadius(10);
                                seriesCompac4.setThickness(5);
                                graph.addSeries(seriesCompac4);
                            }
                        }
                    }
                }//fim do else 1
                staticLabelsFormatter = new StaticLabelsFormatter(graph);
                staticLabelsFormatter.setHorizontalLabels(diasCompac);
                graph.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);
                graph.getGridLabelRenderer().setNumHorizontalLabels(8);
                graph.getLegendRenderer().setVisible(true);
                graph.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.BOTTOM);
                break;
            case 5:
                //implantar grafico 5
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
            super.onBackPressed();
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
            Toast.makeText(GrafActivity.this, "Voce Clicou no Menu Plano de estudo", Toast.LENGTH_SHORT).show();

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
