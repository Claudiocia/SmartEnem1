package br.com.ciadeideias.smartenem;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class EstuDiarioActivity extends AppCompatActivity
            implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estudiario);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.mipmap.ic_launcher);
        toolbar.setTitle(R.string.progresso);

        TextView tvTituloGraf = (TextView) findViewById(R.id.tv_tit_desempenho);
        tvTituloGraf.setText(R.string.nome_graf_item1);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_estudiario);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_desemp);


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout)findViewById(R.id.drawer_layout_estudiario);
        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else {
            new AlertDialog.Builder(this).setTitle("Alerta do sistema")
                    .setMessage("Você quer encerrar o programa agora?")
                    .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            EstuDiarioActivity.super.onBackPressed();
                        }
                    }).setNegativeButton("Não", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent it = new Intent(EstuDiarioActivity.this, EstuDiarioActivity.class);
                    startActivity(it);
                    finish();
                }
            }).show();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_premium) {
            Toast.makeText(EstuDiarioActivity.this, "Voce Clicou no Menu premium", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_home) {
            Intent it = new Intent(EstuDiarioActivity.this, SplashActivity.class);
            startActivity(it);
            finish();

        } else if (id == R.id.nav_plan_estud) {
            Intent it = new Intent(EstuDiarioActivity.this, PlanEstuActivity.class);
            startActivity(it);
            finish();

        } else if (id == R.id.nav_meta) {
            Intent it = new Intent(EstuDiarioActivity.this, MetasActivity.class);
            startActivity(it);
            finish();

        } else if (id == R.id.nav_desemp) {
            Intent it = new Intent(EstuDiarioActivity.this, DesempenhoActivity.class);
            startActivity(it);
            finish();

        } else if (id == R.id.nav_compart){
            Toast.makeText(EstuDiarioActivity.this, "Voce Clicou no Menu Compartilhar", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_config){
            Toast.makeText(EstuDiarioActivity.this, "Voce Clicou no Menu Configurações", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_ajuda) {
            Toast.makeText(EstuDiarioActivity.this, "Voce Clicou no Menu Ajuda", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_sobre) {
            Toast.makeText(EstuDiarioActivity.this, "Voce Clicou no Menu Sobre", Toast.LENGTH_SHORT).show();

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_desempenho);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {

    }

}
