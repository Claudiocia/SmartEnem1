package br.com.ciadeideias.smartenem;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import br.com.ciadeideias.smartenem.bancodados.BDPlanejamento;
import br.com.ciadeideias.smartenem.model.Planejamento;
import br.com.ciadeideias.smartenem.utils.ArraySemRepet;

public class ConfigPlanestudActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener{

    ArrayList<Planejamento> planList = new ArrayList<>();


    ArrayList<String> itens = new ArrayList<>();

    Spinner spl2c2, spl2c3, spl2c4, spl2c5, spl2c6, spl2c7, spl2c8;
    Spinner spl3c2, spl3c3, spl3c4, spl3c5, spl3c6, spl3c7, spl3c8;
    Spinner spl4c2, spl4c3, spl4c4, spl4c5, spl4c6, spl4c7, spl4c8;
    Spinner spl5c2, spl5c3, spl5c4, spl5c5, spl5c6, spl5c7, spl5c8;
    Spinner spl6c2, spl6c3, spl6c4, spl6c5, spl6c6, spl6c7, spl6c8;

    String nome22, dia22, hora22;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config_planestud);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView tvVolta = (TextView)findViewById(R.id.tv_tit_confplan_estud_);

        tvVolta.setText("Quadro de Horário");

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_confplano_estudo);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        final NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_plan_estud);

        //implementação dos spinners
        final BDPlanejamento bdPlan = new BDPlanejamento(this);
        ArraySemRepet semRepet = new ArraySemRepet();


        planList = bdPlan.buscarTodos();

        //linha das 6:00hs

        String iteml2c2, iteml2c3, iteml2c4, iteml2c5, iteml2c6, iteml2c7, iteml2c8;

        iteml2c2 = planList.get(0).getHora6();
        iteml2c3 = planList.get(1).getHora6();
        iteml2c4 = planList.get(2).getHora6();
        iteml2c5 = planList.get(3).getHora6();
        iteml2c6 = planList.get(4).getHora6();
        iteml2c7 = planList.get(5).getHora6();
        iteml2c8 = planList.get(6).getHora6();

        final ArrayList<String> itens22;
        ArrayList<String> itens23;
        ArrayList<String> itens24;
        ArrayList<String> itens25;
        ArrayList<String> itens26;
        ArrayList<String> itens27;
        ArrayList<String> itens28;


        itens22 = semRepet.subst(iteml2c2);
        itens23 = semRepet.subst(iteml2c3);
        itens24 = semRepet.subst(iteml2c4);
        itens25 = semRepet.subst(iteml2c5);
        itens26 = semRepet.subst(iteml2c6);
        itens27 = semRepet.subst(iteml2c7);
        itens28 = semRepet.subst(iteml2c8);

        ArrayAdapter<String> adapterl2c2 = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, itens22);
        ArrayAdapter<String> adapterl2c3 = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, itens23);
        ArrayAdapter<String> adapterl2c4 = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, itens24);
        ArrayAdapter<String> adapterl2c5 = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, itens25);
        ArrayAdapter<String> adapterl2c6 = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, itens26);
        ArrayAdapter<String> adapterl2c7 = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, itens27);
        ArrayAdapter<String> adapterl2c8 = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, itens28);

        adapterl2c2.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        adapterl2c3.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        adapterl2c4.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        adapterl2c5.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        adapterl2c6.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        adapterl2c7.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        adapterl2c8.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);


        spl2c2 = (Spinner)findViewById(R.id.sp_tabplan_lin2_col2);
        spl2c3 = (Spinner)findViewById(R.id.sp_tabplan_lin2_col3);
        spl2c4 = (Spinner)findViewById(R.id.sp_tabplan_lin2_col4);
        spl2c5 = (Spinner)findViewById(R.id.sp_tabplan_lin2_col5);
        spl2c6 = (Spinner)findViewById(R.id.sp_tabplan_lin2_col6);
        spl2c7 = (Spinner)findViewById(R.id.sp_tabplan_lin2_col7);
        spl2c8 = (Spinner)findViewById(R.id.sp_tabplan_lin2_col8);


        spl2c2.setAdapter(adapterl2c2);
        spl2c3.setAdapter(adapterl2c3);
        spl2c4.setAdapter(adapterl2c4);
        spl2c5.setAdapter(adapterl2c5);
        spl2c6.setAdapter(adapterl2c6);
        spl2c7.setAdapter(adapterl2c7);
        spl2c8.setAdapter(adapterl2c8);

        spl2c2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                nome22 = itens22.get(pos);
                Toast.makeText(ConfigPlanestudActivity.this, "Nome do Item = "+ pos+ " o noe da posição é "+nome22, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Button btnSalvar = (Button)findViewById(R.id.btn_tab_planeja);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nome22 = spl2c2.getOnItemSelectedListener().toString();
                hora22 = "hora6";
                dia22 = "Segunda-Feira";
                Toast.makeText(ConfigPlanestudActivity.this,  "o noe da posição é "+nome22, Toast.LENGTH_LONG).show();
                salvarDia(dia22, hora22, nome22);
            }
        });

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_premium) {
            Toast.makeText(ConfigPlanestudActivity.this, "Voce Clicou no Menu premium", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_home) {
            Intent it = new Intent(ConfigPlanestudActivity.this, SplashActivity.class);
            startActivity(it);
            finish();

        } else if (id == R.id.nav_plan_estud) {
            Intent it = new Intent(ConfigPlanestudActivity.this, PlanEstuActivity.class);
            startActivity(it);
            finish();

        } else if (id == R.id.nav_meta) {
            Intent it = new Intent(ConfigPlanestudActivity.this, MetasActivity.class);
            startActivity(it);
            finish();

        } else if (id == R.id.nav_desemp) {
            Intent it = new Intent(ConfigPlanestudActivity.this, DesempenhoActivity.class);
            startActivity(it);
            finish();

        } else if (id == R.id.nav_compart){
            Toast.makeText(ConfigPlanestudActivity.this, "Voce Clicou no Menu Compartilhar", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_config){
            Toast.makeText(ConfigPlanestudActivity.this, "Voce Clicou no Menu Configurações", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_ajuda) {
            Toast.makeText(ConfigPlanestudActivity.this, "Voce Clicou no Menu Ajuda", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_sobre) {
            Toast.makeText(ConfigPlanestudActivity.this, "Voce Clicou no Menu Sobre", Toast.LENGTH_SHORT).show();

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_confplano_estudo);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {

    }

    public void  salvarDia(String dia, String hora, String valor){

        BDPlanejamento bdplan = new BDPlanejamento(this);
        bdplan.atualizeItem(dia, hora, valor);
    }
}
