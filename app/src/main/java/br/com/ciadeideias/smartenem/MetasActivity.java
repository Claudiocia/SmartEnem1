package br.com.ciadeideias.smartenem;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;
import br.com.ciadeideias.smartenem.bancodados.BDMeta;
import br.com.ciadeideias.smartenem.fragments.MetaFragment;
import br.com.ciadeideias.smartenem.model.Meta;

public class MetasActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    Meta meta;
    List<Meta> listMetas;
    TextView tvDedic;
    Dialog dialogDedic;
    ImageView buttonFechar;
    Button buttonSalvar;
    RadioGroup nivelDedic;
    RadioButton dedicNivel;
    RadioButton dedicNivel1;
    RadioButton dedicNivel2;
    RadioButton dedicNivel3;
    RadioButton dedicNivel4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.mipmap.ic_launcher);

        TextView tvTituloMetas = (TextView) findViewById(R.id.tv_config_metas);
        tvTituloMetas.setText(R.string.titulo_Metas);

        Meta metaAtualDedic = new Meta();
        BDMeta bdMetaAtual = new BDMeta(this);
        metaAtualDedic = bdMetaAtual.buscarMeta(1);

        tvDedic = (TextView)findViewById(R.id.valor_dedic);
        tvDedic.setText(metaAtualDedic.getNivelDedic().toString());
        tvDedic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Snackbar.make(v, "você clicou no valor dedicação", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                dedicSetValor();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_metas);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_meta);

        //Fragment
        MetaFragment frag = (MetaFragment) getSupportFragmentManager().findFragmentByTag("metaFrag");
        if (frag == null){
            frag = new MetaFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.rl_fragment_container_metas, frag, "metaFrag");
            ft.commit();
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_metas);
        dialogDedic = new Dialog(this, R.style.FullHeightDialog);
        long lastBackPressTime = 0;
        Toast toast = null;
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }else if (dialogDedic.isShowing()){
            dialogDedic.dismiss();
        }
        else {

            new AlertDialog.Builder(this).setTitle("Alerta do sistema")
                    .setMessage("Você quer encerrar o programa agora?")
                    .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            MetasActivity.super.onBackPressed();
                        }
                    }).setNegativeButton("Não", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent it = new Intent(MetasActivity.this, MetasActivity.class);
                    startActivity(it);
                    finish();
                }
            }).show();

        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_premium) {
            Intent it = new Intent(MetasActivity.this, PremiumActivity.class);
            startActivity(it);
            finish();
        } else if (id == R.id.nav_home) {
            Intent it = new Intent(MetasActivity.this, SplashActivity.class);
            startActivity(it);
            finish();

        } else if (id == R.id.nav_calendario){
            Toast.makeText(MetasActivity.this, "Voce Clicou no Menu Calendário", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_plan_estud) {
            Intent it = new Intent(MetasActivity.this, PlanEstuActivity.class);
            startActivity(it);
            finish();

        } else if (id == R.id.nav_meta) {
            Intent it = new Intent(MetasActivity.this, MetasActivity.class);
            startActivity(it);
            finish();

        } else if (id == R.id.nav_desemp) {
            Intent it = new Intent(MetasActivity.this, DesempenhoActivity.class);
            startActivity(it);
            finish();

        } else if (id == R.id.nav_ajuda) {
            Toast.makeText(MetasActivity.this, "Voce Clicou no Menu Ajuda", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_sobre) {
            Intent it = new Intent(MetasActivity.this, AboutActivity.class);
            startActivity(it);
            finish();

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_metas);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {

    }

    public List<Meta> getListMetas(){
        List<Meta> mList = new ArrayList<>();

        BDMeta bdMeta = new BDMeta(this);
        List<Meta> list = bdMeta.buscarTodasMetas();
        int tamList = list.size();
        for (int i = 0; i<tamList; i++){
            Meta meta = new Meta();
            meta.setNomeMeta(list.get(i).getNomeMeta().toString());
            meta.setValorMeta(list.get(i).getValorMeta());
            meta.setValorExec(list.get(i).getValorExec());
            mList.add(meta);
        }
        return (mList);
    }


    public void dedicSetValor(){
        dialogDedic = new Dialog(this, R.style.FullHeightDialog);
        dialogDedic.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogDedic.setContentView(R.layout.dialog_dedic);
        buttonFechar = (ImageView) dialogDedic.findViewById(R.id.button_fechar_dedic);
        buttonSalvar = (Button) dialogDedic.findViewById(R.id.button_salvar_dedic);

        nivelDedic = (RadioGroup) dialogDedic.findViewById(R.id.select_dedic);
        dedicNivel1 = (RadioButton) dialogDedic.findViewById(R.id.nivel_dedic1);
        dedicNivel2 = (RadioButton) dialogDedic.findViewById(R.id.nivel_dedic2);
        dedicNivel3 = (RadioButton) dialogDedic.findViewById(R.id.nivel_dedic3);
        dedicNivel4 = (RadioButton) dialogDedic.findViewById(R.id.nivel_dedic4);

        dialogDedic.show();

        buttonFechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogDedic.dismiss();
            }
        });

        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvarDedic();
                dialogDedic.dismiss();
                Intent cadQuest = new Intent(MetasActivity.this, MetasActivity.class);
                startActivity(cadQuest);
                finish();
            }
        });

    }

    public void salvarDedic(){
        String nivelDedicFinal;

        int selectedId = nivelDedic.getCheckedRadioButtonId();

        dedicNivel = (RadioButton) nivelDedic.findViewById(selectedId);
        nivelDedicFinal = dedicNivel.getText().toString();

        Meta metaDedic = new Meta();
        metaDedic.setNivelDedic(nivelDedicFinal);
        BDMeta bdMetaDedic = new BDMeta(this);
        bdMetaDedic.configurarDedic(metaDedic);

    }



}
