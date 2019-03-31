package br.com.ciadeideias.smartenem;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.navigation.NavigationView;
import androidx.fragment.app.FragmentTransaction;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.ciadeideias.smartenem.bancodados.BDDisciplina;
import br.com.ciadeideias.smartenem.fragments.EstudoFragment;
import br.com.ciadeideias.smartenem.model.Disciplina;
import br.com.ciadeideias.smartenem.model.NomeDisciplina;

public class EstudoListaActivity extends AppCompatActivity
            implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_estudo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.mipmap.ic_launcher);
        toolbar.setTitle(R.string.disciplinas);

        TextView tvTitulolista = (TextView) findViewById(R.id.tv_tit_lista_estudo);
        tvTitulolista.setText(R.string.titulo_graficos);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_list_estudo);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_desemp);

        EstudoFragment frag = (EstudoFragment) getSupportFragmentManager().findFragmentByTag("estudFrag");
        if(frag == null){
            frag = new EstudoFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.rl_fragment_container_list_estudo, frag, "estudFrag");
            ft.commit();
        }

    }

    @Override
    public void onBackPressed() {
        Intent it = new Intent(EstudoListaActivity.this, SplashActivity.class);
        startActivity(it);
        finish();

    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_premium) {
            Intent it = new Intent(EstudoListaActivity.this, PremiumActivity.class);
            startActivity(it);
            finish();
        } else if (id == R.id.nav_home) {
            Intent it = new Intent(EstudoListaActivity.this, SplashActivity.class);
            startActivity(it);
            finish();

        } else if (id == R.id.nav_plan_estud) {
            Intent it = new Intent(EstudoListaActivity.this, PlanEstuActivity.class);
            startActivity(it);
            finish();

        } else if (id == R.id.nav_meta) {
            Intent it = new Intent(EstudoListaActivity.this, MetasActivity.class);
            startActivity(it);
            finish();

        } else if (id == R.id.nav_desemp) {
            Intent it = new Intent(EstudoListaActivity.this, DesempenhoActivity.class);
            startActivity(it);
            finish();

        } else if (id == R.id.nav_compart){
            Toast.makeText(EstudoListaActivity.this, "Voce Clicou no Menu Videos", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_ajuda) {
            Toast.makeText(EstudoListaActivity.this, "Voce Clicou no Menu Ajuda", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_sobre) {
            Intent it = new Intent(EstudoListaActivity.this, AboutActivity.class);
            startActivity(it);
            finish();

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_list_estudo);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {

    }


    public List<NomeDisciplina> getListaDisciplinas(){
        List<NomeDisciplina> mList = new ArrayList<>();
        List<Disciplina> listDisciplina;

        BDDisciplina bdDisciplina = new BDDisciplina(this);
        listDisciplina = bdDisciplina.buscarNomes();

        for(int i=0; i<listDisciplina.size(); i++) {
            NomeDisciplina nomeDisciplina = new NomeDisciplina();
            nomeDisciplina.setNome(listDisciplina.get(i).getNome());
            mList.add(nomeDisciplina);
        }

        return (mList);

    }
}
