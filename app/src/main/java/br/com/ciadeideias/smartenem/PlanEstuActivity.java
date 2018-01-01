package br.com.ciadeideias.smartenem;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import br.com.ciadeideias.smartenem.adapter.PlanEstudAdapter;
import br.com.ciadeideias.smartenem.bancodados.BDPlanejamento;
import br.com.ciadeideias.smartenem.model.Planejamento;
import br.com.ciadeideias.smartenem.utils.Desempenho;

/**
 * Created by ClaudioSouza on 29/12/2017.
 */

public class PlanEstuActivity extends AppCompatActivity
                        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener{

    Dialog dialogDedic;
    String diaSemana;
    Planejamento planDia;
    BDPlanejamento bdPlan;
    ArrayList<Planejamento> planList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_estud);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.mipmap.ic_launcher);

        TextView tvPlanEstud = (TextView)findViewById(R.id.tv_tit_plan_estud);
        tvPlanEstud.setText(R.string.titulo_barra);

        GridView gridView = (GridView) findViewById(R.id.gridview_plan_estud);
        gridView.setAdapter(new PlanEstudAdapter(this));

        planList = new ArrayList<>();
        bdPlan = new BDPlanejamento(this);
        //planDia = bdPlan.buscarDia("Segunda-Feira");

        planList = bdPlan.buscarTodos();

        //diaSemana = planDia.getDiaSemana();

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        diaSemana = planList.get(0).getDiaSemana();
                        Toast.makeText(PlanEstuActivity.this, "Voce Clicou no dia: "+diaSemana, Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        diaSemana = planList.get(1).getDiaSemana();
                        Toast.makeText(PlanEstuActivity.this, "Voce Clicou no dia: "+diaSemana, Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        diaSemana = planList.get(2).getDiaSemana();
                        Toast.makeText(PlanEstuActivity.this, "Voce Clicou no dia: "+diaSemana, Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        diaSemana = planList.get(3).getDiaSemana();
                        Toast.makeText(PlanEstuActivity.this, "Voce Clicou no dia: "+diaSemana, Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        diaSemana = planList.get(4).getDiaSemana();
                        Toast.makeText(PlanEstuActivity.this, "Voce Clicou no dia: "+diaSemana, Toast.LENGTH_SHORT).show();
                        break;
                    case 5:
                        diaSemana = planList.get(5).getDiaSemana();
                        Toast.makeText(PlanEstuActivity.this, "Voce Clicou no dia: "+diaSemana, Toast.LENGTH_SHORT).show();
                        break;
                    case 6:
                        diaSemana = planList.get(6).getDiaSemana();
                        Toast.makeText(PlanEstuActivity.this, "Voce Clicou no dia: "+diaSemana, Toast.LENGTH_SHORT).show();
                        break;
                    case 7:
                        Toast.makeText(PlanEstuActivity.this, "Voce Clicou na configuração semanal", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_plano_estudo);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_plan_estud);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_premium) {
            Toast.makeText(PlanEstuActivity.this, "Voce Clicou no Menu premium", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_home) {
            Intent it = new Intent(PlanEstuActivity.this, SplashActivity.class);
            startActivity(it);
            finish();

        } else if (id == R.id.nav_plan_estud) {
            Intent it = new Intent(PlanEstuActivity.this, PlanEstuActivity.class);
            startActivity(it);
            finish();

        } else if (id == R.id.nav_meta) {
            Intent it = new Intent(PlanEstuActivity.this, MetasActivity.class);
            startActivity(it);
            finish();

        } else if (id == R.id.nav_desemp) {
            Intent it = new Intent(PlanEstuActivity.this, DesempenhoActivity.class);
            startActivity(it);
            finish();

        } else if (id == R.id.nav_compart){
            Toast.makeText(PlanEstuActivity.this, "Voce Clicou no Menu Compartilhar", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_config){
            Toast.makeText(PlanEstuActivity.this, "Voce Clicou no Menu Configurações", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_ajuda) {
            Toast.makeText(PlanEstuActivity.this, "Voce Clicou no Menu Ajuda", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_sobre) {
            Toast.makeText(PlanEstuActivity.this, "Voce Clicou no Menu Sobre", Toast.LENGTH_SHORT).show();

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_plano_estudo);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_plano_estudo);
        dialogDedic = new Dialog(this, R.style.FullHeightDialog);
        long lastBackPressTime = 0;
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }else if (dialogDedic.isShowing()){
            dialogDedic.dismiss();
        }
        else {
            new AlertDialog.Builder(this).setTitle("Alerta do Sistema")
                    .setMessage("Você quer encerrar o programa agora?")
                    .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            PlanEstuActivity.super.onBackPressed();
                        }
                    }).setNegativeButton("Não", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            }).show();

        }
    }

}
