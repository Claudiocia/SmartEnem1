package br.com.ciadeideias.smartenem.redacao;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
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
import br.com.ciadeideias.smartenem.AboutActivity;
import br.com.ciadeideias.smartenem.DesempenhoActivity;
import br.com.ciadeideias.smartenem.MetasActivity;
import br.com.ciadeideias.smartenem.PlanEstuActivity;
import br.com.ciadeideias.smartenem.PremiumActivity;
import br.com.ciadeideias.smartenem.R;
import br.com.ciadeideias.smartenem.SplashActivity;
import br.com.ciadeideias.smartenem.bancodados.BDDica;
import br.com.ciadeideias.smartenem.bancodados.BDRedacao;
import br.com.ciadeideias.smartenem.fragments.DicasFragment;
import br.com.ciadeideias.smartenem.fragments.PraticaRedaFragment;
import br.com.ciadeideias.smartenem.model.Dica;
import br.com.ciadeideias.smartenem.model.Redacao;
import br.com.ciadeideias.smartenem.model.TemasRedacao;
import br.com.ciadeideias.smartenem.model.TituloDica;

public class PraticaRedacaoActivity extends AppCompatActivity
            implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_temas_redacao);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.mipmap.ic_launcher);
        toolbar.setTitle(R.string.redacao);

        TextView tvTitulolista = (TextView) findViewById(R.id.tv_tit_lista_temas);
        tvTitulolista.setText(R.string.titulo_praticared);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_list_temas_reda);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_desemp);

        PraticaRedaFragment frag = (PraticaRedaFragment) getSupportFragmentManager().findFragmentByTag("temasRedaFrag");
        if(frag == null){
            frag = new PraticaRedaFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.rl_fragment_container_list_temas_reda, frag, "temasRedaFrag");
            ft.commit();
        }

    }

    @Override
    public void onBackPressed() {
        Intent it = new Intent(PraticaRedacaoActivity.this, SplashActivity.class);
        startActivity(it);
        finish();

    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_premium) {
            Intent it = new Intent(PraticaRedacaoActivity.this, PremiumActivity.class);
            startActivity(it);
            finish();
        } else if (id == R.id.nav_home) {
            Intent it = new Intent(PraticaRedacaoActivity.this, SplashActivity.class);
            startActivity(it);
            finish();

        } else if (id == R.id.nav_plan_estud) {
            Intent it = new Intent(PraticaRedacaoActivity.this, PlanEstuActivity.class);
            startActivity(it);
            finish();

        } else if (id == R.id.nav_meta) {
            Intent it = new Intent(PraticaRedacaoActivity.this, MetasActivity.class);
            startActivity(it);
            finish();

        } else if (id == R.id.nav_desemp) {
            Intent it = new Intent(PraticaRedacaoActivity.this, DesempenhoActivity.class);
            startActivity(it);
            finish();

        } else if (id == R.id.nav_compart){
            Toast.makeText(PraticaRedacaoActivity.this, "Voce Clicou no Menu Videos", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_ajuda) {
            Toast.makeText(PraticaRedacaoActivity.this, "Voce Clicou no Menu Ajuda", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_sobre) {
            Intent it = new Intent(PraticaRedacaoActivity.this, AboutActivity.class);
            startActivity(it);
            finish();

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_list_dicas);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {

    }


    public List<TemasRedacao> getListaTemas(){
        List<TemasRedacao> mList = new ArrayList<>();
        List<Redacao> listRedacao;

        BDRedacao bdRedacao = new BDRedacao(this);
        listRedacao = bdRedacao.buscarTodas();


        for(int i=0; i<listRedacao.size(); i++) {
            TemasRedacao temasRedacao = new TemasRedacao();
            temasRedacao.setTema (listRedacao.get(i).getTemaRed());
            temasRedacao.setAnoAplic(listRedacao.get(i).getAnoRed());
            temasRedacao.setIdRedacao(listRedacao.get(i).getIdRed());
            mList.add(temasRedacao);
        }

        return (mList);

    }
}
