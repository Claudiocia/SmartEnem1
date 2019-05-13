package br.com.ciadeideias.smartenem;

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
import br.com.ciadeideias.smartenem.fragments.FormulasFragment;
import br.com.ciadeideias.smartenem.model.NomeDisciplina;

public class FormulasCardActivity extends AppCompatActivity
            implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_formulas);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.mipmap.ic_launcher);
        toolbar.setTitle(R.string.formulas);

        TextView tvTitulolista = (TextView) findViewById(R.id.tv_tit_card_formulas);
        tvTitulolista.setText(R.string.formulas);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_card_formulas);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_desemp);

        FormulasFragment frag = (FormulasFragment) getSupportFragmentManager().findFragmentByTag("formulasFrag");
        if(frag == null){
            frag = new FormulasFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.rl_fragment_container_card_formulas, frag, "formulasFrag");
            ft.commit();
        }

    }

    @Override
    public void onBackPressed() {
        Intent it = new Intent(FormulasCardActivity.this, SplashActivity.class);
        startActivity(it);
        finish();

    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_premium) {
            Intent it = new Intent(FormulasCardActivity.this, PremiumActivity.class);
            startActivity(it);
            finish();
        } else if (id == R.id.nav_home) {
            Intent it = new Intent(FormulasCardActivity.this, SplashActivity.class);
            startActivity(it);
            finish();

        } else if (id == R.id.nav_calendario){
            Intent it = new Intent(FormulasCardActivity.this, SplashCalendActivity.class);
            startActivity(it);
            finish();

        } else if (id == R.id.nav_plan_estud) {
            Intent it = new Intent(FormulasCardActivity.this, PlanEstuActivity.class);
            startActivity(it);
            finish();

        } else if (id == R.id.nav_meta) {
            Intent it = new Intent(FormulasCardActivity.this, MetasActivity.class);
            startActivity(it);
            finish();

        } else if (id == R.id.nav_desemp) {
            Intent it = new Intent(FormulasCardActivity.this, DesempenhoActivity.class);
            startActivity(it);
            finish();

        } else if (id == R.id.nav_ajuda) {
            Toast.makeText(FormulasCardActivity.this, "Voce Clicou no Menu Ajuda", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_sobre) {
            Intent it = new Intent(FormulasCardActivity.this, AboutActivity.class);
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

    //auto construção da lista
    public List<NomeDisciplina> getListaDisciplinaCard (int qtd){
        String[] nome = new String[]{"Matemática", "Física", "Química" };

        String[] descri = new String[]{""+R.string.card_matematica, ""+R.string.card_fisica, ""+R.string.card_quimica };
        String[] img = new String[]{""+R.drawable.matematica, ""+R.drawable.fisica, ""+R.drawable.quimica};
        int[] idDisci = new int[]{8, 6, 5};

        List<NomeDisciplina> listAux = new ArrayList<>();

        for (int i = 0; i < qtd; i++){
            NomeDisciplina nomeDisci = new NomeDisciplina();
            nomeDisci.setNome(nome[i]);
            nomeDisci.setDescri(descri[i]);
            nomeDisci.setImg(img[i]);
            nomeDisci.setIdDisciplina(idDisci[i]);
            listAux.add(nomeDisci);
        }

        return (listAux);

    }


    //Construção da lista vinda do banco
/*
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
    */
}
