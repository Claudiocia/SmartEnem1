package br.com.ciadeideias.smartenem;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;


public class PremiumActivity extends AppCompatActivity
            implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_premium);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.mipmap.ic_launcher);
        toolbar.setTitle(R.string.title_version_premium);

       // TextView tvTituloGraf = (TextView) findViewById(R.id.tv_tit_desempenho);
       // tvTituloGraf.setText(R.string.nome_graf_item1);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_premium);
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
        DrawerLayout drawer = (DrawerLayout)findViewById(R.id.drawer_layout_premium);
        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else {
            new AlertDialog.Builder(this).setTitle("Alerta do sistema")
                    .setMessage("Você quer encerrar o programa agora?")
                    .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            PremiumActivity.super.onBackPressed();
                        }
                    }).setNegativeButton("Não", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent it = new Intent(PremiumActivity.this, PremiumActivity.class);
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
            Toast.makeText(PremiumActivity.this, "Você já se encontra na página da Versão Premium", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_home) {
            Intent it = new Intent(PremiumActivity.this, SplashActivity.class);
            startActivity(it);
            finish();

        } else if (id == R.id.nav_calendario){
            Toast.makeText(PremiumActivity.this, "Voce Clicou no Menu Calendário", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_plan_estud) {
            Intent it = new Intent(PremiumActivity.this, PlanEstuActivity.class);
            startActivity(it);
            finish();

        } else if (id == R.id.nav_meta) {
            Intent it = new Intent(PremiumActivity.this, MetasActivity.class);
            startActivity(it);
            finish();

        } else if (id == R.id.nav_desemp) {
            Intent it = new Intent(PremiumActivity.this, DesempenhoActivity.class);
            startActivity(it);
            finish();

        } else if (id == R.id.nav_ajuda) {
            Toast.makeText(PremiumActivity.this, "Voce Clicou no Menu Ajuda", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_sobre) {
            Intent it = new Intent(PremiumActivity.this, PremiumActivity.class);
            startActivity(it);
            finish();

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_premium);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {

    }

    public void comprarPremium(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(
                "https://play.google.com/store/apps/details?id=com.example.android"));
        intent.setPackage("com.android.vending");
        startActivity(intent);
    }
}
