package br.com.ciadeideias.smartenem;

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
import java.util.List;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;
import br.com.ciadeideias.smartenem.adapter.RedacaoAdapter;
import br.com.ciadeideias.smartenem.bancodados.BDDisciplina;
import br.com.ciadeideias.smartenem.fragments.EstudoFragment;
import br.com.ciadeideias.smartenem.model.Disciplina;
import br.com.ciadeideias.smartenem.model.NomeDisciplina;
import br.com.ciadeideias.smartenem.redacao.CoerenciaTextualActivity;
import br.com.ciadeideias.smartenem.redacao.CoesaoTextualActivity;
import br.com.ciadeideias.smartenem.redacao.DicasRedacaoActivity;
import br.com.ciadeideias.smartenem.redacao.ErrosComunsActivity;
import br.com.ciadeideias.smartenem.redacao.InterpretacaoTextoActivity;
import br.com.ciadeideias.smartenem.redacao.PraticaRedacaoActivity;
import br.com.ciadeideias.smartenem.redacao.RoteiroRedacaoActivity;
import br.com.ciadeideias.smartenem.redacao.TecnicasActivity;
import br.com.ciadeideias.smartenem.redacao.TipoEnemActivity;
import br.com.ciadeideias.smartenem.redacao.TipoTextosActivity;

public class RedacaoActivity extends AppCompatActivity
            implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redacao);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.mipmap.ic_launcher);
        toolbar.setTitle(R.string.redacao);

        TextView tvTitulolista = (TextView) findViewById(R.id.tv_tit_redacao);
        tvTitulolista.setText(R.string.redacao);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_redacao);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_desemp);

        GridView gridView = (GridView)findViewById(R.id.gridview_reda);
        gridView.setAdapter(new RedacaoAdapter(this));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               // Toast.makeText(RedacaoActivity.this, "Voce Clicou no dia: "+position, Toast.LENGTH_SHORT).show();

                 switch (position) {
                     case 0:
                         Intent it0 = new Intent(RedacaoActivity.this, TecnicasActivity.class);
                         startActivity(it0);
                         finish();
                         break;
                     case 1:
                         Intent it1 = new Intent(RedacaoActivity.this, TipoTextosActivity.class);
                         startActivity(it1);
                         finish();
                         break;
                     case 2:
                         Intent it2 = new Intent(RedacaoActivity.this, TipoEnemActivity.class);
                         startActivity(it2);
                         finish();
                         break;
                     case 3:
                         Intent it3 = new Intent(RedacaoActivity.this, CoerenciaTextualActivity.class);
                         startActivity(it3);
                         finish();
                         break;
                     case 4:
                         Intent it4 = new Intent(RedacaoActivity.this, CoesaoTextualActivity.class);
                         startActivity(it4);
                         finish();
                         break;
                     case 5:
                         Intent it5 = new Intent(RedacaoActivity.this, InterpretacaoTextoActivity.class);
                         startActivity(it5);
                         finish();
                         break;
                     case 6:
                         Intent it6 = new Intent(RedacaoActivity.this, RoteiroRedacaoActivity.class);
                         startActivity(it6);
                         finish();
                         break;
                     case 7:
                         Intent it7 = new Intent(RedacaoActivity.this, DicasRedacaoActivity.class);
                         startActivity(it7);
                         finish();
                         break;
                     case 8:
                         Intent it8 = new Intent(RedacaoActivity.this, ErrosComunsActivity.class);
                         startActivity(it8);
                         finish();
                         break;
                     case 9:
                         Intent it9 = new Intent(RedacaoActivity.this, PraticaRedacaoActivity.class);
                         startActivity(it9);
                         finish();
                         break;
                 }
            }
        });



    }

    @Override
    public void onBackPressed() {
        Intent it = new Intent(RedacaoActivity.this, SplashActivity.class);
        startActivity(it);
        finish();

    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_premium) {
            Intent it = new Intent(RedacaoActivity.this, PremiumActivity.class);
            startActivity(it);
            finish();
        } else if (id == R.id.nav_home) {
            Intent it = new Intent(RedacaoActivity.this, SplashActivity.class);
            startActivity(it);
            finish();

        } else if (id == R.id.nav_plan_estud) {
            Intent it = new Intent(RedacaoActivity.this, PlanEstuActivity.class);
            startActivity(it);
            finish();

        } else if (id == R.id.nav_meta) {
            Intent it = new Intent(RedacaoActivity.this, MetasActivity.class);
            startActivity(it);
            finish();

        } else if (id == R.id.nav_desemp) {
            Intent it = new Intent(RedacaoActivity.this, DesempenhoActivity.class);
            startActivity(it);
            finish();

        } else if (id == R.id.nav_compart){
            Toast.makeText(RedacaoActivity.this, "Voce Clicou no Menu Videos", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_ajuda) {
            Toast.makeText(RedacaoActivity.this, "Voce Clicou no Menu Ajuda", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_sobre) {
            Intent it = new Intent(RedacaoActivity.this, AboutActivity.class);
            startActivity(it);
            finish();

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_redacao);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {

    }

}
