package br.com.ciadeideias.smartenem;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import br.com.ciadeideias.smartenem.adapter.PlanEstudAdapter;
import br.com.ciadeideias.smartenem.bancodados.BDPlanejamento;
import br.com.ciadeideias.smartenem.configplanoestudo.ConfigPlanestudDomActivity;
import br.com.ciadeideias.smartenem.configplanoestudo.ConfigPlanestudQuaActivity;
import br.com.ciadeideias.smartenem.configplanoestudo.ConfigPlanestudQuiActivity;
import br.com.ciadeideias.smartenem.configplanoestudo.ConfigPlanestudSabActivity;
import br.com.ciadeideias.smartenem.configplanoestudo.ConfigPlanestudSegActivity;
import br.com.ciadeideias.smartenem.configplanoestudo.ConfigPlanestudSexActivity;
import br.com.ciadeideias.smartenem.configplanoestudo.ConfigPlanestudTerActivity;
import br.com.ciadeideias.smartenem.model.Planejamento;

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
                        //diaSemana = planList.get(0).getDiaSemana();
                        Intent itSeg = new Intent(PlanEstuActivity.this, ConfigPlanestudSegActivity.class);
                        startActivity(itSeg);
                        finish();
                        //Toast.makeText(PlanEstuActivity.this, "Voce Clicou no dia: "+diaSemana, Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        //diaSemana = planList.get(1).getDiaSemana();
                        Intent itTer = new Intent(PlanEstuActivity.this, ConfigPlanestudTerActivity.class);
                        startActivity(itTer);
                        finish();
                        //Toast.makeText(PlanEstuActivity.this, "Voce Clicou no dia: "+diaSemana, Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        //diaSemana = planList.get(2).getDiaSemana();
                        Intent itQua = new Intent(PlanEstuActivity.this, ConfigPlanestudQuaActivity.class);
                        startActivity(itQua);
                        finish();
                        //Toast.makeText(PlanEstuActivity.this, "Voce Clicou no dia: "+diaSemana, Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        //diaSemana = planList.get(3).getDiaSemana();
                        Intent itQui = new Intent(PlanEstuActivity.this, ConfigPlanestudQuiActivity.class);
                        startActivity(itQui);
                        finish();
                        //Toast.makeText(PlanEstuActivity.this, "Voce Clicou no dia: "+diaSemana, Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        //diaSemana = planList.get(4).getDiaSemana();
                        Intent itSex = new Intent(PlanEstuActivity.this, ConfigPlanestudSexActivity.class);
                        startActivity(itSex);
                        finish();
                        //Toast.makeText(PlanEstuActivity.this, "Voce Clicou no dia: "+diaSemana, Toast.LENGTH_SHORT).show();
                        break;
                    case 5:
                        //diaSemana = planList.get(5).getDiaSemana();
                        Intent itSab = new Intent(PlanEstuActivity.this, ConfigPlanestudSabActivity.class);
                        startActivity(itSab);
                        finish();
                        //Toast.makeText(PlanEstuActivity.this, "Voce Clicou no dia: "+diaSemana, Toast.LENGTH_SHORT).show();
                        break;
                    case 6:
                        //diaSemana = planList.get(6).getDiaSemana();
                        Intent itDom = new Intent(PlanEstuActivity.this, ConfigPlanestudDomActivity.class);
                        startActivity(itDom);
                        finish();
                        //Toast.makeText(PlanEstuActivity.this, "Voce Clicou no dia: "+diaSemana, Toast.LENGTH_SHORT).show();
                        break;
                    case 7:
                        Intent it = new Intent(PlanEstuActivity.this, ConfigPlanestudActivity.class);
                        startActivity(it);
                        finish();
                        //Toast.makeText(PlanEstuActivity.this, "Voce Clicou na configuração semanal", Toast.LENGTH_SHORT).show();
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
            Intent it = new Intent(PlanEstuActivity.this, PremiumActivity.class);
            startActivity(it);
            finish();
        } else if (id == R.id.nav_home) {
            Intent it = new Intent(PlanEstuActivity.this, SplashActivity.class);
            startActivity(it);
            finish();

        } else if (id == R.id.nav_calendario){
            Intent it = new Intent(PlanEstuActivity.this, SplashCalendActivity.class);
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

        } else if (id == R.id.nav_ajuda) {
            Toast.makeText(PlanEstuActivity.this, "Voce Clicou no Menu Ajuda", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_sobre) {
            Intent it = new Intent(PlanEstuActivity.this, AboutActivity.class);
            startActivity(it);
            finish();

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
