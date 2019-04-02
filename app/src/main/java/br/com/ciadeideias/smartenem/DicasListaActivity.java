package br.com.ciadeideias.smartenem;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.chrisbanes.photoview.PhotoView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;
import br.com.ciadeideias.smartenem.bancodados.BDDica;
import br.com.ciadeideias.smartenem.bancodados.BDDisciplina;
import br.com.ciadeideias.smartenem.fragments.DicasFragment;
import br.com.ciadeideias.smartenem.fragments.EstudoFragment;
import br.com.ciadeideias.smartenem.model.Dica;
import br.com.ciadeideias.smartenem.model.Disciplina;
import br.com.ciadeideias.smartenem.model.NomeDisciplina;
import br.com.ciadeideias.smartenem.model.TituloDica;

public class DicasListaActivity extends AppCompatActivity
            implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_dicas);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.mipmap.ic_launcher);
        toolbar.setTitle(R.string.dicas);

        TextView tvTitulolista = (TextView) findViewById(R.id.tv_tit_lista_dicas);
        tvTitulolista.setText(R.string.tit_dicas);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_list_dicas);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_desemp);

        DicasFragment frag = (DicasFragment) getSupportFragmentManager().findFragmentByTag("dicasFrag");
        if(frag == null){
            frag = new DicasFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.rl_fragment_container_list_dicas, frag, "dicasFrag");
            ft.commit();
        }

    }

    @Override
    public void onBackPressed() {
        Intent it = new Intent(DicasListaActivity.this, SplashActivity.class);
        startActivity(it);
        finish();

    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_premium) {
            Intent it = new Intent(DicasListaActivity.this, PremiumActivity.class);
            startActivity(it);
            finish();
        } else if (id == R.id.nav_home) {
            Intent it = new Intent(DicasListaActivity.this, SplashActivity.class);
            startActivity(it);
            finish();

        } else if (id == R.id.nav_plan_estud) {
            Intent it = new Intent(DicasListaActivity.this, PlanEstuActivity.class);
            startActivity(it);
            finish();

        } else if (id == R.id.nav_meta) {
            Intent it = new Intent(DicasListaActivity.this, MetasActivity.class);
            startActivity(it);
            finish();

        } else if (id == R.id.nav_desemp) {
            Intent it = new Intent(DicasListaActivity.this, DesempenhoActivity.class);
            startActivity(it);
            finish();

        } else if (id == R.id.nav_compart){
            Toast.makeText(DicasListaActivity.this, "Voce Clicou no Menu Videos", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_ajuda) {
            Toast.makeText(DicasListaActivity.this, "Voce Clicou no Menu Ajuda", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_sobre) {
            Intent it = new Intent(DicasListaActivity.this, AboutActivity.class);
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


    public List<TituloDica> getListaDicas(){
        List<TituloDica> mList = new ArrayList<>();
        List<Dica> listDica;

        BDDica bdDica = new BDDica(this);
        listDica = bdDica.buscarTodas();


        for(int i=0; i<listDica.size(); i++) {
            TituloDica tituloDica = new TituloDica();
            tituloDica.setTitulo(listDica.get(i).getTituloDica());
            tituloDica.setDescr(listDica.get(i).getDescri());
            tituloDica.setIdDica(listDica.get(i).getIdDica());
            tituloDica.setImg(R.drawable.lampada_f);
            tituloDica.setDicaTexto(listDica.get(i).getTextoDica());
            mList.add(tituloDica);
        }

        return (mList);

    }
}
