package br.com.ciadeideias.smartenem.configplanoestudo;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import br.com.ciadeideias.smartenem.AboutActivity;
import br.com.ciadeideias.smartenem.DesempenhoActivity;
import br.com.ciadeideias.smartenem.MetasActivity;
import br.com.ciadeideias.smartenem.PlanEstuActivity;
import br.com.ciadeideias.smartenem.PremiumActivity;
import br.com.ciadeideias.smartenem.R;
import br.com.ciadeideias.smartenem.SplashActivity;
import br.com.ciadeideias.smartenem.SplashCalendActivity;
import br.com.ciadeideias.smartenem.bancodados.BDPlanejamento;
import br.com.ciadeideias.smartenem.model.Planejamento;
import br.com.ciadeideias.smartenem.utils.ArraySemRepet;


public class ConfigPlanestudDomActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener{

    Planejamento planDia = new Planejamento();

    Spinner spl2c2, spl7c2, spl12c2, spl17c2;
    Spinner spl3c2, spl8c2, spl13c2, spl18c2;
    Spinner spl4c2, spl9c2, spl14c2;
    Spinner spl5c2, spl10c2, spl15c2;
    Spinner spl6c2, spl11c2, spl16c2;

    String nome22, nome32, nome42, nome52, nome62;
    String nome72, nome82, nome92, nome102, nome112;
    String nome122, nome132, nome142, nome152, nome162, nome172, nome182;

    String dia = "Domingo";
    String hora6, hora7, hora8, hora9, hora10, hora11;
    String hora12, hora13, hora14, hora15, hora16;
    String hora17, hora18, hora19, hora20, hora21, hora22;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config_planestud_seg);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView tvVolta = (TextView)findViewById(R.id.tv_tit_confplan_estud_seg);
        TextView tvDia = (TextView)findViewById(R.id.tv_tabplan_lin1_col2_seg);

        tvVolta.setText("Quadro de Horário");
        tvDia.setText(dia);
        tvDia.setTextColor(Color.RED);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_confplano_estudo_seg);
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

        planDia = bdPlan.buscarDia(dia);

        final String iteml2, iteml3, iteml4, iteml5, iteml6, iteml7, iteml8;
        final String iteml9, iteml10, iteml11, iteml12, iteml13, iteml14, iteml15;
        final String iteml16, iteml17, iteml18;

        iteml2 = planDia.getHora6();
        iteml3 = planDia.getHora7();
        iteml4 = planDia.getHora8();
        iteml5 = planDia.getHora9();
        iteml6 = planDia.getHora10();
        iteml7 = planDia.getHora11();
        iteml8 = planDia.getHora12();
        iteml9 = planDia.getHora13();
        iteml10 = planDia.getHora14();
        iteml11 = planDia.getHora15();
        iteml12 = planDia.getHora16();
        iteml13 = planDia.getHora17();
        iteml14 = planDia.getHora18();
        iteml15 = planDia.getHora19();
        iteml16 = planDia.getHora20();
        iteml17 = planDia.getHora21();
        iteml18 = planDia.getHora22();


        final ArrayList<String> itens22, itens32, itens42, itens52, itens62, itens72, itens82, itens92 ;
        final ArrayList<String> itens102, itens112, itens122, itens132, itens142, itens152, itens162, itens172, itens182;

        itens22 = semRepet.subst(iteml2);
        itens32 = semRepet.subst(iteml3);
        itens42 = semRepet.subst(iteml4);
        itens52 = semRepet.subst(iteml5);
        itens62 = semRepet.subst(iteml6);
        itens72 = semRepet.subst(iteml7);
        itens82 = semRepet.subst(iteml8);
        itens92 = semRepet.subst(iteml9);
        itens102 = semRepet.subst(iteml10);
        itens112 = semRepet.subst(iteml11);
        itens122 = semRepet.subst(iteml12);
        itens132 = semRepet.subst(iteml13);
        itens142 = semRepet.subst(iteml14);
        itens152 = semRepet.subst(iteml15);
        itens162 = semRepet.subst(iteml16);
        itens172 = semRepet.subst(iteml17);
        itens182 = semRepet.subst(iteml18);


        ArrayAdapter<String> adapterl2c2 = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, itens22);
        ArrayAdapter<String> adapterl3c2 = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, itens32);
        ArrayAdapter<String> adapterl4c2 = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, itens42);
        ArrayAdapter<String> adapterl5c2 = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, itens52);
        ArrayAdapter<String> adapterl6c2 = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, itens62);
        ArrayAdapter<String> adapterl7c2 = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, itens72);
        ArrayAdapter<String> adapterl8c2 = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, itens82);
        ArrayAdapter<String> adapterl9c2 = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, itens92);
        ArrayAdapter<String> adapterl10c2 = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, itens102);
        ArrayAdapter<String> adapterl11c2 = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, itens112);
        ArrayAdapter<String> adapterl12c2 = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, itens122);
        ArrayAdapter<String> adapterl13c2 = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, itens132);
        ArrayAdapter<String> adapterl14c2 = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, itens142);
        ArrayAdapter<String> adapterl15c2 = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, itens152);
        ArrayAdapter<String> adapterl16c2 = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, itens162);
        ArrayAdapter<String> adapterl17c2 = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, itens172);
        ArrayAdapter<String> adapterl18c2 = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, itens182);


        adapterl2c2.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        adapterl3c2.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        adapterl4c2.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        adapterl5c2.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        adapterl6c2.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        adapterl7c2.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        adapterl8c2.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        adapterl9c2.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        adapterl10c2.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        adapterl11c2.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        adapterl12c2.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        adapterl13c2.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        adapterl14c2.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        adapterl15c2.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        adapterl16c2.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        adapterl17c2.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        adapterl18c2.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        spl2c2 = (Spinner)findViewById(R.id.sp_tabplan_lin2_col2);
        spl2c2.setAdapter(adapterl2c2);
        spl3c2 = (Spinner) findViewById(R.id.sp_tabplan_lin3_col2);
        spl3c2.setAdapter(adapterl3c2);
        spl4c2 = (Spinner) findViewById(R.id.sp_tabplan_lin4_col2);
        spl4c2.setAdapter(adapterl4c2);
        spl5c2 = (Spinner) findViewById(R.id.sp_tabplan_lin5_col2);
        spl5c2.setAdapter(adapterl5c2);
        spl6c2 = (Spinner) findViewById(R.id.sp_tabplan_lin6_col2);
        spl6c2.setAdapter(adapterl6c2);
        spl7c2 = (Spinner) findViewById(R.id.sp_tabplan_lin7_col2);
        spl7c2.setAdapter(adapterl7c2);
        spl8c2 = (Spinner) findViewById(R.id.sp_tabplan_lin8_col2);
        spl8c2.setAdapter(adapterl8c2);
        spl9c2 = (Spinner) findViewById(R.id.sp_tabplan_lin9_col2);
        spl9c2.setAdapter(adapterl9c2);
        spl10c2 = (Spinner) findViewById(R.id.sp_tabplan_lin10_col2);
        spl10c2.setAdapter(adapterl10c2);
        spl11c2 = (Spinner) findViewById(R.id.sp_tabplan_lin11_col2);
        spl11c2.setAdapter(adapterl11c2);
        spl12c2 = (Spinner) findViewById(R.id.sp_tabplan_lin12_col2);
        spl12c2.setAdapter(adapterl12c2);
        spl13c2 = (Spinner) findViewById(R.id.sp_tabplan_lin13_col2);
        spl13c2.setAdapter(adapterl13c2);
        spl14c2 = (Spinner) findViewById(R.id.sp_tabplan_lin14_col2);
        spl14c2.setAdapter(adapterl14c2);
        spl15c2 = (Spinner) findViewById(R.id.sp_tabplan_lin15_col2);
        spl15c2.setAdapter(adapterl15c2);
        spl16c2 = (Spinner) findViewById(R.id.sp_tabplan_lin16_col2);
        spl16c2.setAdapter(adapterl16c2);
        spl17c2 = (Spinner) findViewById(R.id.sp_tabplan_lin17_col2);
        spl17c2.setAdapter(adapterl17c2);
        spl18c2 = (Spinner) findViewById(R.id.sp_tabplan_lin18_col2);
        spl18c2.setAdapter(adapterl18c2);


        spl2c2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                nome22 = itens22.get(pos);
                hora6 = "hora6";
                salvarDia(dia, hora6, nome22);
                //Toast.makeText(ConfigPlanestudSegActivity.this, "Nome do Item na l2c2 é "+ iteml2c2+ " e o l3c2 é "+iteml3c2, Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spl3c2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                nome32 = itens32.get(position);
                hora7 = "hora7";
                salvarDia(dia, hora7, nome32);
                //Toast.makeText(ConfigPlanestudSegActivity.this, "Nome do Item na posição "+ position+ " é "+nome32, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spl4c2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                nome42 = itens42.get(position);
                hora8 = "hora8";
                salvarDia(dia, hora8, nome42);
                //Toast.makeText(ConfigPlanestudSegActivity.this, "Nome do Item na posição "+ position+ " é "+nome32, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spl5c2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                nome52 = itens52.get(position);
                hora9 = "hora9";
                salvarDia(dia, hora9, nome52);
                //Toast.makeText(ConfigPlanestudSegActivity.this, "Nome do Item na posição "+ position+ " é "+nome32, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spl6c2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                nome62 = itens62.get(position);
                hora10 = "hora10";
                salvarDia(dia, hora10, nome62);
                //Toast.makeText(ConfigPlanestudSegActivity.this, "Nome do Item na posição "+ position+ " é "+nome32, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spl7c2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                nome72 = itens72.get(position);
                hora11 = "hora11";
                salvarDia(dia, hora11, nome72);
                //Toast.makeText(ConfigPlanestudSegActivity.this, "Nome do Item na posição "+ position+ " é "+nome32, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spl8c2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                nome82 = itens82.get(position);
                hora12 = "hora12";
                salvarDia(dia, hora12, nome82);
                //Toast.makeText(ConfigPlanestudSegActivity.this, "Nome do Item na posição "+ position+ " é "+nome32, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spl9c2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                nome92 = itens92.get(position);
                hora13 = "hora13";
                salvarDia(dia, hora13, nome92);
                //Toast.makeText(ConfigPlanestudSegActivity.this, "Nome do Item na posição "+ position+ " é "+nome32, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spl10c2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                nome102 = itens102.get(position);
                hora14 = "hora14";
                salvarDia(dia, hora14, nome102);
                //Toast.makeText(ConfigPlanestudSegActivity.this, "Nome do Item na posição "+ position+ " é "+nome32, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spl11c2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                nome112 = itens112.get(position);
                hora15 = "hora15";
                salvarDia(dia, hora15, nome112);
                //Toast.makeText(ConfigPlanestudSegActivity.this, "Nome do Item na posição "+ position+ " é "+nome32, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spl12c2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                nome122 = itens122.get(position);
                hora16 = "hora16";
                salvarDia(dia, hora16, nome122);
                //Toast.makeText(ConfigPlanestudSegActivity.this, "Nome do Item na posição "+ position+ " é "+nome32, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spl13c2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                nome132 = itens132.get(position);
                hora17 = "hora17";
                salvarDia(dia, hora17, nome132);
                //Toast.makeText(ConfigPlanestudSegActivity.this, "Nome do Item na posição "+ position+ " é "+nome32, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spl14c2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                nome142 = itens142.get(position);
                hora18 = "hora18";
                salvarDia(dia, hora18, nome142);
                //Toast.makeText(ConfigPlanestudSegActivity.this, "Nome do Item na posição "+ position+ " é "+nome32, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spl15c2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                nome152 = itens152.get(position);
                hora19 = "hora19";
                salvarDia(dia, hora19, nome152);
                //Toast.makeText(ConfigPlanestudSegActivity.this, "Nome do Item na posição "+ position+ " é "+nome32, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spl16c2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                nome162 = itens162.get(position);
                hora20 = "hora20";
                salvarDia(dia, hora20, nome162);
                //Toast.makeText(ConfigPlanestudSegActivity.this, "Nome do Item na posição "+ position+ " é "+nome32, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spl17c2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                nome172 = itens172.get(position);
                hora21 = "hora21";
                salvarDia(dia, hora21, nome172);
                //Toast.makeText(ConfigPlanestudSegActivity.this, "Nome do Item na posição "+ position+ " é "+nome32, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spl18c2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                nome182 = itens182.get(position);
                hora22 = "hora22";
                salvarDia(dia, hora22, nome182);
                //Toast.makeText(ConfigPlanestudSegActivity.this, "Nome do Item na posição "+ position+ " é "+nome32, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout)findViewById(R.id.drawer_layout_confplano_estudo_seg);
        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else {
            Intent it = new Intent(ConfigPlanestudDomActivity.this, PlanEstuActivity.class);
            startActivity(it);
            finish();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_premium) {
            Intent it = new Intent(ConfigPlanestudDomActivity.this, PremiumActivity.class);
            startActivity(it);
            finish();
        } else if (id == R.id.nav_home) {
            Intent it = new Intent(ConfigPlanestudDomActivity.this, SplashActivity.class);
            startActivity(it);
            finish();

        } else if (id == R.id.nav_calendario){
            Intent it = new Intent(ConfigPlanestudDomActivity.this, SplashCalendActivity.class);
            startActivity(it);
            finish();

        } else if (id == R.id.nav_plan_estud) {
            Intent it = new Intent(ConfigPlanestudDomActivity.this, PlanEstuActivity.class);
            startActivity(it);
            finish();

        } else if (id == R.id.nav_meta) {
            Intent it = new Intent(ConfigPlanestudDomActivity.this, MetasActivity.class);
            startActivity(it);
            finish();

        } else if (id == R.id.nav_desemp) {
            Intent it = new Intent(ConfigPlanestudDomActivity.this, DesempenhoActivity.class);
            startActivity(it);
            finish();

        } else if (id == R.id.nav_ajuda) {
            Toast.makeText(ConfigPlanestudDomActivity.this, "Voce Clicou no Menu Ajuda", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_sobre) {
            Intent it = new Intent(ConfigPlanestudDomActivity.this, AboutActivity.class);
            startActivity(it);
            finish();

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_confplano_estudo_seg);
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
