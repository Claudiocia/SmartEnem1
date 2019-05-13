package br.com.ciadeideias.smartenem;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
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
import br.com.ciadeideias.smartenem.bancodados.BDPlanejamento;
import br.com.ciadeideias.smartenem.model.Planejamento;

public class ConfigPlanestudActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener{

    ArrayList<Planejamento> planList = new ArrayList<>();




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

        TextView tvLinha22 = (TextView) findViewById(R.id.tv_tabplan_lin2_col2);
        TextView tvLinha23 = (TextView) findViewById(R.id.tv_tabplan_lin2_col3);
        TextView tvLinha24 = (TextView) findViewById(R.id.tv_tabplan_lin2_col4);
        TextView tvLinha25 = (TextView) findViewById(R.id.tv_tabplan_lin2_col5);
        TextView tvLinha26 = (TextView) findViewById(R.id.tv_tabplan_lin2_col6);
        TextView tvLinha27 = (TextView) findViewById(R.id.tv_tabplan_lin2_col7);
        TextView tvLinha28 = (TextView) findViewById(R.id.tv_tabplan_lin2_col8);

        if (iteml2c2.equals("livre")){
            tvLinha22.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha22.setBackgroundColor(Color.RED);
        }

        if (iteml2c3.equals("livre")){
            tvLinha23.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha23.setBackgroundColor(Color.RED);
        }

        if (iteml2c4.equals("livre")){
            tvLinha24.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha24.setBackgroundColor(Color.RED);
        }

        if (iteml2c5.equals("livre")){
            tvLinha25.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha25.setBackgroundColor(Color.RED);
        }

        if (iteml2c6.equals("livre")){
            tvLinha26.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha26.setBackgroundColor(Color.RED);
        }

        if (iteml2c7.equals("livre")){
            tvLinha27.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha27.setBackgroundColor(Color.RED);
        }

        if (iteml2c8.equals("livre")){
            tvLinha28.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha28.setBackgroundColor(Color.RED);
        }

        //linha das 7:00hs
        String iteml3c2, iteml3c3, iteml3c4, iteml3c5, iteml3c6, iteml3c7, iteml3c8;

        iteml3c2 = planList.get(0).getHora7();
        iteml3c3 = planList.get(1).getHora7();
        iteml3c4 = planList.get(2).getHora7();
        iteml3c5 = planList.get(3).getHora7();
        iteml3c6 = planList.get(4).getHora7();
        iteml3c7 = planList.get(5).getHora7();
        iteml3c8 = planList.get(6).getHora7();

        TextView tvLinha32 = (TextView) findViewById(R.id.tv_tabplan_lin3_col2);
        TextView tvLinha33 = (TextView) findViewById(R.id.tv_tabplan_lin3_col3);
        TextView tvLinha34 = (TextView) findViewById(R.id.tv_tabplan_lin3_col4);
        TextView tvLinha35 = (TextView) findViewById(R.id.tv_tabplan_lin3_col5);
        TextView tvLinha36 = (TextView) findViewById(R.id.tv_tabplan_lin3_col6);
        TextView tvLinha37 = (TextView) findViewById(R.id.tv_tabplan_lin3_col7);
        TextView tvLinha38 = (TextView) findViewById(R.id.tv_tabplan_lin3_col8);

        if (iteml3c2.equals("livre")){
            tvLinha32.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha32.setBackgroundColor(Color.RED);
        }

        if (iteml3c3.equals("livre")){
            tvLinha33.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha33.setBackgroundColor(Color.RED);
        }

        if (iteml3c4.equals("livre")){
            tvLinha34.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha34.setBackgroundColor(Color.RED);
        }

        if (iteml3c5.equals("livre")){
            tvLinha35.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha35.setBackgroundColor(Color.RED);
        }

        if (iteml3c6.equals("livre")){
            tvLinha36.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha36.setBackgroundColor(Color.RED);
        }

        if (iteml3c7.equals("livre")){
            tvLinha37.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha37.setBackgroundColor(Color.RED);
        }

        if (iteml3c8.equals("livre")){
            tvLinha38.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha38.setBackgroundColor(Color.RED);
        }

        //linha das 8:00hs
        String iteml4c2, iteml4c3, iteml4c4, iteml4c5, iteml4c6, iteml4c7, iteml4c8;

        iteml4c2 = planList.get(0).getHora8();
        iteml4c3 = planList.get(1).getHora8();
        iteml4c4 = planList.get(2).getHora8();
        iteml4c5 = planList.get(3).getHora8();
        iteml4c6 = planList.get(4).getHora8();
        iteml4c7 = planList.get(5).getHora8();
        iteml4c8 = planList.get(6).getHora8();

        TextView tvLinha42 = (TextView) findViewById(R.id.tv_tabplan_lin4_col2);
        TextView tvLinha43 = (TextView) findViewById(R.id.tv_tabplan_lin4_col3);
        TextView tvLinha44 = (TextView) findViewById(R.id.tv_tabplan_lin4_col4);
        TextView tvLinha45 = (TextView) findViewById(R.id.tv_tabplan_lin4_col5);
        TextView tvLinha46 = (TextView) findViewById(R.id.tv_tabplan_lin4_col6);
        TextView tvLinha47 = (TextView) findViewById(R.id.tv_tabplan_lin4_col7);
        TextView tvLinha48 = (TextView) findViewById(R.id.tv_tabplan_lin4_col8);

        if (iteml4c2.equals("livre")){
            tvLinha42.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha42.setBackgroundColor(Color.RED);
        }

        if (iteml4c3.equals("livre")){
            tvLinha43.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha43.setBackgroundColor(Color.RED);
        }

        if (iteml4c4.equals("livre")){
            tvLinha44.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha44.setBackgroundColor(Color.RED);
        }

        if (iteml4c5.equals("livre")){
            tvLinha45.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha45.setBackgroundColor(Color.RED);
        }

        if (iteml4c6.equals("livre")){
            tvLinha46.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha46.setBackgroundColor(Color.RED);
        }

        if (iteml4c7.equals("livre")){
            tvLinha47.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha47.setBackgroundColor(Color.RED);
        }

        if (iteml4c8.equals("livre")){
            tvLinha48.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha48.setBackgroundColor(Color.RED);
        }

        //linha das 9:00hs
        String iteml5c2, iteml5c3, iteml5c4, iteml5c5, iteml5c6, iteml5c7, iteml5c8;

        iteml5c2 = planList.get(0).getHora9();
        iteml5c3 = planList.get(1).getHora9();
        iteml5c4 = planList.get(2).getHora9();
        iteml5c5 = planList.get(3).getHora9();
        iteml5c6 = planList.get(4).getHora9();
        iteml5c7 = planList.get(5).getHora9();
        iteml5c8 = planList.get(6).getHora9();

        TextView tvLinha52 = (TextView) findViewById(R.id.tv_tabplan_lin5_col2);
        TextView tvLinha53 = (TextView) findViewById(R.id.tv_tabplan_lin5_col3);
        TextView tvLinha54 = (TextView) findViewById(R.id.tv_tabplan_lin5_col4);
        TextView tvLinha55 = (TextView) findViewById(R.id.tv_tabplan_lin5_col5);
        TextView tvLinha56 = (TextView) findViewById(R.id.tv_tabplan_lin5_col6);
        TextView tvLinha57 = (TextView) findViewById(R.id.tv_tabplan_lin5_col7);
        TextView tvLinha58 = (TextView) findViewById(R.id.tv_tabplan_lin5_col8);

        if (iteml5c2.equals("livre")){
            tvLinha52.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha52.setBackgroundColor(Color.RED);
        }

        if (iteml5c3.equals("livre")){
            tvLinha53.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha53.setBackgroundColor(Color.RED);
        }

        if (iteml5c4.equals("livre")){
            tvLinha54.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha54.setBackgroundColor(Color.RED);
        }

        if (iteml5c5.equals("livre")){
            tvLinha55.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha55.setBackgroundColor(Color.RED);
        }

        if (iteml5c6.equals("livre")){
            tvLinha56.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha56.setBackgroundColor(Color.RED);
        }

        if (iteml5c7.equals("livre")){
            tvLinha57.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha57.setBackgroundColor(Color.RED);
        }

        if (iteml5c8.equals("livre")){
            tvLinha58.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha58.setBackgroundColor(Color.RED);
        }

        //linha das 10:00hs
        String iteml6c2, iteml6c3, iteml6c4, iteml6c5, iteml6c6, iteml6c7, iteml6c8;

        iteml6c2 = planList.get(0).getHora10();
        iteml6c3 = planList.get(1).getHora10();
        iteml6c4 = planList.get(2).getHora10();
        iteml6c5 = planList.get(3).getHora10();
        iteml6c6 = planList.get(4).getHora10();
        iteml6c7 = planList.get(5).getHora10();
        iteml6c8 = planList.get(6).getHora10();

        TextView tvLinha62 = (TextView) findViewById(R.id.tv_tabplan_lin6_col2);
        TextView tvLinha63 = (TextView) findViewById(R.id.tv_tabplan_lin6_col3);
        TextView tvLinha64 = (TextView) findViewById(R.id.tv_tabplan_lin6_col4);
        TextView tvLinha65 = (TextView) findViewById(R.id.tv_tabplan_lin6_col5);
        TextView tvLinha66 = (TextView) findViewById(R.id.tv_tabplan_lin6_col6);
        TextView tvLinha67 = (TextView) findViewById(R.id.tv_tabplan_lin6_col7);
        TextView tvLinha68 = (TextView) findViewById(R.id.tv_tabplan_lin6_col8);

        if (iteml6c2.equals("livre")){
            tvLinha62.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha62.setBackgroundColor(Color.RED);
        }

        if (iteml6c3.equals("livre")){
            tvLinha63.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha63.setBackgroundColor(Color.RED);
        }

        if (iteml6c4.equals("livre")){
            tvLinha64.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha64.setBackgroundColor(Color.RED);
        }

        if (iteml6c5.equals("livre")){
            tvLinha65.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha65.setBackgroundColor(Color.RED);
        }

        if (iteml6c6.equals("livre")){
            tvLinha66.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha66.setBackgroundColor(Color.RED);
        }

        if (iteml6c7.equals("livre")){
            tvLinha67.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha67.setBackgroundColor(Color.RED);
        }

        if (iteml6c8.equals("livre")){
            tvLinha68.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha68.setBackgroundColor(Color.RED);
        }

        //linha das 11:00hs
        String iteml7c2, iteml7c3, iteml7c4, iteml7c5, iteml7c6, iteml7c7, iteml7c8;

        iteml7c2 = planList.get(0).getHora11();
        iteml7c3 = planList.get(1).getHora11();
        iteml7c4 = planList.get(2).getHora11();
        iteml7c5 = planList.get(3).getHora11();
        iteml7c6 = planList.get(4).getHora11();
        iteml7c7 = planList.get(5).getHora11();
        iteml7c8 = planList.get(6).getHora11();

        TextView tvLinha72 = (TextView) findViewById(R.id.tv_tabplan_lin7_col2);
        TextView tvLinha73 = (TextView) findViewById(R.id.tv_tabplan_lin7_col3);
        TextView tvLinha74 = (TextView) findViewById(R.id.tv_tabplan_lin7_col4);
        TextView tvLinha75 = (TextView) findViewById(R.id.tv_tabplan_lin7_col5);
        TextView tvLinha76 = (TextView) findViewById(R.id.tv_tabplan_lin7_col6);
        TextView tvLinha77 = (TextView) findViewById(R.id.tv_tabplan_lin7_col7);
        TextView tvLinha78 = (TextView) findViewById(R.id.tv_tabplan_lin7_col8);

        if (iteml7c2.equals("livre")){
            tvLinha72.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha72.setBackgroundColor(Color.RED);
        }

        if (iteml7c3.equals("livre")){
            tvLinha73.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha73.setBackgroundColor(Color.RED);
        }

        if (iteml7c4.equals("livre")){
            tvLinha74.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha74.setBackgroundColor(Color.RED);
        }

        if (iteml7c5.equals("livre")){
            tvLinha75.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha75.setBackgroundColor(Color.RED);
        }

        if (iteml7c6.equals("livre")){
            tvLinha76.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha76.setBackgroundColor(Color.RED);
        }

        if (iteml7c7.equals("livre")){
            tvLinha77.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha77.setBackgroundColor(Color.RED);
        }

        if (iteml7c8.equals("livre")){
            tvLinha78.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha78.setBackgroundColor(Color.RED);
        }

        //linha das 12:00hs
        String iteml8c2, iteml8c3, iteml8c4, iteml8c5, iteml8c6, iteml8c7, iteml8c8;

        iteml8c2 = planList.get(0).getHora12();
        iteml8c3 = planList.get(1).getHora12();
        iteml8c4 = planList.get(2).getHora12();
        iteml8c5 = planList.get(3).getHora12();
        iteml8c6 = planList.get(4).getHora12();
        iteml8c7 = planList.get(5).getHora12();
        iteml8c8 = planList.get(6).getHora12();

        TextView tvLinha82 = (TextView) findViewById(R.id.tv_tabplan_lin8_col2);
        TextView tvLinha83 = (TextView) findViewById(R.id.tv_tabplan_lin8_col3);
        TextView tvLinha84 = (TextView) findViewById(R.id.tv_tabplan_lin8_col4);
        TextView tvLinha85 = (TextView) findViewById(R.id.tv_tabplan_lin8_col5);
        TextView tvLinha86 = (TextView) findViewById(R.id.tv_tabplan_lin8_col6);
        TextView tvLinha87 = (TextView) findViewById(R.id.tv_tabplan_lin8_col7);
        TextView tvLinha88 = (TextView) findViewById(R.id.tv_tabplan_lin8_col8);

        if (iteml8c2.equals("livre")){
            tvLinha82.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha82.setBackgroundColor(Color.RED);
        }

        if (iteml8c3.equals("livre")){
            tvLinha83.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha83.setBackgroundColor(Color.RED);
        }

        if (iteml8c4.equals("livre")){
            tvLinha84.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha84.setBackgroundColor(Color.RED);
        }

        if (iteml8c5.equals("livre")){
            tvLinha85.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha85.setBackgroundColor(Color.RED);
        }

        if (iteml8c6.equals("livre")){
            tvLinha86.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha86.setBackgroundColor(Color.RED);
        }

        if (iteml8c7.equals("livre")){
            tvLinha87.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha87.setBackgroundColor(Color.RED);
        }

        if (iteml8c8.equals("livre")){
            tvLinha88.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha88.setBackgroundColor(Color.RED);
        }

        //linha das 13:00hs
        String iteml9c2, iteml9c3, iteml9c4, iteml9c5, iteml9c6, iteml9c7, iteml9c8;

        iteml9c2 = planList.get(0).getHora13();
        iteml9c3 = planList.get(1).getHora13();
        iteml9c4 = planList.get(2).getHora13();
        iteml9c5 = planList.get(3).getHora13();
        iteml9c6 = planList.get(4).getHora13();
        iteml9c7 = planList.get(5).getHora13();
        iteml9c8 = planList.get(6).getHora13();

        TextView tvLinha92 = (TextView) findViewById(R.id.tv_tabplan_lin9_col2);
        TextView tvLinha93 = (TextView) findViewById(R.id.tv_tabplan_lin9_col3);
        TextView tvLinha94 = (TextView) findViewById(R.id.tv_tabplan_lin9_col4);
        TextView tvLinha95 = (TextView) findViewById(R.id.tv_tabplan_lin9_col5);
        TextView tvLinha96 = (TextView) findViewById(R.id.tv_tabplan_lin9_col6);
        TextView tvLinha97 = (TextView) findViewById(R.id.tv_tabplan_lin9_col7);
        TextView tvLinha98 = (TextView) findViewById(R.id.tv_tabplan_lin9_col8);

        if (iteml9c2.equals("livre")){
            tvLinha92.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha92.setBackgroundColor(Color.RED);
        }

        if (iteml9c3.equals("livre")){
            tvLinha93.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha93.setBackgroundColor(Color.RED);
        }

        if (iteml9c4.equals("livre")){
            tvLinha94.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha94.setBackgroundColor(Color.RED);
        }

        if (iteml9c5.equals("livre")){
            tvLinha95.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha95.setBackgroundColor(Color.RED);
        }

        if (iteml9c6.equals("livre")){
            tvLinha96.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha96.setBackgroundColor(Color.RED);
        }

        if (iteml9c7.equals("livre")){
            tvLinha97.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha97.setBackgroundColor(Color.RED);
        }

        if (iteml9c8.equals("livre")){
            tvLinha98.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha98.setBackgroundColor(Color.RED);
        }

        //linha das 14:00hs
        String iteml10c2, iteml10c3, iteml10c4, iteml10c5, iteml10c6, iteml10c7, iteml10c8;

        iteml10c2 = planList.get(0).getHora14();
        iteml10c3 = planList.get(1).getHora14();
        iteml10c4 = planList.get(2).getHora14();
        iteml10c5 = planList.get(3).getHora14();
        iteml10c6 = planList.get(4).getHora14();
        iteml10c7 = planList.get(5).getHora14();
        iteml10c8 = planList.get(6).getHora14();

        TextView tvLinha102 = (TextView) findViewById(R.id.tv_tabplan_lin10_col2);
        TextView tvLinha103 = (TextView) findViewById(R.id.tv_tabplan_lin10_col3);
        TextView tvLinha104 = (TextView) findViewById(R.id.tv_tabplan_lin10_col4);
        TextView tvLinha105 = (TextView) findViewById(R.id.tv_tabplan_lin10_col5);
        TextView tvLinha106 = (TextView) findViewById(R.id.tv_tabplan_lin10_col6);
        TextView tvLinha107 = (TextView) findViewById(R.id.tv_tabplan_lin10_col7);
        TextView tvLinha108 = (TextView) findViewById(R.id.tv_tabplan_lin10_col8);

        if (iteml10c2.equals("livre")){
            tvLinha102.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha102.setBackgroundColor(Color.RED);
        }

        if (iteml10c3.equals("livre")){
            tvLinha103.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha103.setBackgroundColor(Color.RED);
        }

        if (iteml10c4.equals("livre")){
            tvLinha104.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha104.setBackgroundColor(Color.RED);
        }

        if (iteml10c5.equals("livre")){
            tvLinha105.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha105.setBackgroundColor(Color.RED);
        }

        if (iteml10c6.equals("livre")){
            tvLinha106.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha106.setBackgroundColor(Color.RED);
        }

        if (iteml10c7.equals("livre")){
            tvLinha107.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha107.setBackgroundColor(Color.RED);
        }

        if (iteml10c8.equals("livre")){
            tvLinha108.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha108.setBackgroundColor(Color.RED);
        }

        //linha das 15:00hs
        String iteml11c2, iteml11c3, iteml11c4, iteml11c5, iteml11c6, iteml11c7, iteml11c8;

        iteml11c2 = planList.get(0).getHora15();
        iteml11c3 = planList.get(1).getHora15();
        iteml11c4 = planList.get(2).getHora15();
        iteml11c5 = planList.get(3).getHora15();
        iteml11c6 = planList.get(4).getHora15();
        iteml11c7 = planList.get(5).getHora15();
        iteml11c8 = planList.get(6).getHora15();

        TextView tvLinha112 = (TextView) findViewById(R.id.tv_tabplan_lin11_col2);
        TextView tvLinha113 = (TextView) findViewById(R.id.tv_tabplan_lin11_col3);
        TextView tvLinha114 = (TextView) findViewById(R.id.tv_tabplan_lin11_col4);
        TextView tvLinha115 = (TextView) findViewById(R.id.tv_tabplan_lin11_col5);
        TextView tvLinha116 = (TextView) findViewById(R.id.tv_tabplan_lin11_col6);
        TextView tvLinha117 = (TextView) findViewById(R.id.tv_tabplan_lin11_col7);
        TextView tvLinha118 = (TextView) findViewById(R.id.tv_tabplan_lin11_col8);

        if (iteml11c2.equals("livre")){
            tvLinha112.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha112.setBackgroundColor(Color.RED);
        }

        if (iteml11c3.equals("livre")){
            tvLinha113.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha113.setBackgroundColor(Color.RED);
        }

        if (iteml11c4.equals("livre")){
            tvLinha114.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha114.setBackgroundColor(Color.RED);
        }

        if (iteml11c5.equals("livre")){
            tvLinha115.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha115.setBackgroundColor(Color.RED);
        }

        if (iteml11c6.equals("livre")){
            tvLinha116.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha116.setBackgroundColor(Color.RED);
        }

        if (iteml11c7.equals("livre")){
            tvLinha117.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha117.setBackgroundColor(Color.RED);
        }

        if (iteml11c8.equals("livre")){
            tvLinha118.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha118.setBackgroundColor(Color.RED);
        }

        //linha das 16:00hs
        String iteml12c2, iteml12c3, iteml12c4, iteml12c5, iteml12c6, iteml12c7, iteml12c8;

        iteml12c2 = planList.get(0).getHora16();
        iteml12c3 = planList.get(1).getHora16();
        iteml12c4 = planList.get(2).getHora16();
        iteml12c5 = planList.get(3).getHora16();
        iteml12c6 = planList.get(4).getHora16();
        iteml12c7 = planList.get(5).getHora16();
        iteml12c8 = planList.get(6).getHora16();

        TextView tvLinha122 = (TextView) findViewById(R.id.tv_tabplan_lin12_col2);
        TextView tvLinha123 = (TextView) findViewById(R.id.tv_tabplan_lin12_col3);
        TextView tvLinha124 = (TextView) findViewById(R.id.tv_tabplan_lin12_col4);
        TextView tvLinha125 = (TextView) findViewById(R.id.tv_tabplan_lin12_col5);
        TextView tvLinha126 = (TextView) findViewById(R.id.tv_tabplan_lin12_col6);
        TextView tvLinha127 = (TextView) findViewById(R.id.tv_tabplan_lin12_col7);
        TextView tvLinha128 = (TextView) findViewById(R.id.tv_tabplan_lin12_col8);

        if (iteml12c2.equals("livre")){
            tvLinha122.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha122.setBackgroundColor(Color.RED);
        }

        if (iteml12c3.equals("livre")){
            tvLinha123.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha123.setBackgroundColor(Color.RED);
        }

        if (iteml12c4.equals("livre")){
            tvLinha124.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha124.setBackgroundColor(Color.RED);
        }

        if (iteml12c5.equals("livre")){
            tvLinha125.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha125.setBackgroundColor(Color.RED);
        }

        if (iteml12c6.equals("livre")){
            tvLinha126.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha126.setBackgroundColor(Color.RED);
        }

        if (iteml12c7.equals("livre")){
            tvLinha127.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha127.setBackgroundColor(Color.RED);
        }

        if (iteml12c8.equals("livre")){
            tvLinha128.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha128.setBackgroundColor(Color.RED);
        }

        //linha das 17:00hs
        String iteml13c2, iteml13c3, iteml13c4, iteml13c5, iteml13c6, iteml13c7, iteml13c8;

        iteml13c2 = planList.get(0).getHora17();
        iteml13c3 = planList.get(1).getHora17();
        iteml13c4 = planList.get(2).getHora17();
        iteml13c5 = planList.get(3).getHora17();
        iteml13c6 = planList.get(4).getHora17();
        iteml13c7 = planList.get(5).getHora17();
        iteml13c8 = planList.get(6).getHora17();

        TextView tvLinha132 = (TextView) findViewById(R.id.tv_tabplan_lin13_col2);
        TextView tvLinha133 = (TextView) findViewById(R.id.tv_tabplan_lin13_col3);
        TextView tvLinha134 = (TextView) findViewById(R.id.tv_tabplan_lin13_col4);
        TextView tvLinha135 = (TextView) findViewById(R.id.tv_tabplan_lin13_col5);
        TextView tvLinha136 = (TextView) findViewById(R.id.tv_tabplan_lin13_col6);
        TextView tvLinha137 = (TextView) findViewById(R.id.tv_tabplan_lin13_col7);
        TextView tvLinha138 = (TextView) findViewById(R.id.tv_tabplan_lin13_col8);

        if (iteml13c2.equals("livre")){
            tvLinha132.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha132.setBackgroundColor(Color.RED);
        }

        if (iteml13c3.equals("livre")){
            tvLinha133.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha133.setBackgroundColor(Color.RED);
        }

        if (iteml13c4.equals("livre")){
            tvLinha134.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha134.setBackgroundColor(Color.RED);
        }

        if (iteml13c5.equals("livre")){
            tvLinha135.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha135.setBackgroundColor(Color.RED);
        }

        if (iteml13c6.equals("livre")){
            tvLinha136.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha136.setBackgroundColor(Color.RED);
        }

        if (iteml13c7.equals("livre")){
            tvLinha137.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha137.setBackgroundColor(Color.RED);
        }

        if (iteml13c8.equals("livre")){
            tvLinha138.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha138.setBackgroundColor(Color.RED);
        }

        //linha das 18:00hs
        String iteml14c2, iteml14c3, iteml14c4, iteml14c5, iteml14c6, iteml14c7, iteml14c8;

        iteml14c2 = planList.get(0).getHora18();
        iteml14c3 = planList.get(1).getHora18();
        iteml14c4 = planList.get(2).getHora18();
        iteml14c5 = planList.get(3).getHora18();
        iteml14c6 = planList.get(4).getHora18();
        iteml14c7 = planList.get(5).getHora18();
        iteml14c8 = planList.get(6).getHora18();

        TextView tvLinha142 = (TextView) findViewById(R.id.tv_tabplan_lin14_col2);
        TextView tvLinha143 = (TextView) findViewById(R.id.tv_tabplan_lin14_col3);
        TextView tvLinha144 = (TextView) findViewById(R.id.tv_tabplan_lin14_col4);
        TextView tvLinha145 = (TextView) findViewById(R.id.tv_tabplan_lin14_col5);
        TextView tvLinha146 = (TextView) findViewById(R.id.tv_tabplan_lin14_col6);
        TextView tvLinha147 = (TextView) findViewById(R.id.tv_tabplan_lin14_col7);
        TextView tvLinha148 = (TextView) findViewById(R.id.tv_tabplan_lin14_col8);

        if (iteml14c2.equals("livre")){
            tvLinha142.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha142.setBackgroundColor(Color.RED);
        }

        if (iteml14c3.equals("livre")){
            tvLinha143.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha143.setBackgroundColor(Color.RED);
        }

        if (iteml14c4.equals("livre")){
            tvLinha144.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha144.setBackgroundColor(Color.RED);
        }

        if (iteml14c5.equals("livre")){
            tvLinha145.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha145.setBackgroundColor(Color.RED);
        }

        if (iteml14c6.equals("livre")){
            tvLinha146.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha146.setBackgroundColor(Color.RED);
        }

        if (iteml14c7.equals("livre")){
            tvLinha147.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha147.setBackgroundColor(Color.RED);
        }

        if (iteml14c8.equals("livre")){
            tvLinha148.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha148.setBackgroundColor(Color.RED);
        }

        //linha das 19:00hs
        String iteml15c2, iteml15c3, iteml15c4, iteml15c5, iteml15c6, iteml15c7, iteml15c8;

        iteml15c2 = planList.get(0).getHora19();
        iteml15c3 = planList.get(1).getHora19();
        iteml15c4 = planList.get(2).getHora19();
        iteml15c5 = planList.get(3).getHora19();
        iteml15c6 = planList.get(4).getHora19();
        iteml15c7 = planList.get(5).getHora19();
        iteml15c8 = planList.get(6).getHora19();

        TextView tvLinha152 = (TextView) findViewById(R.id.tv_tabplan_lin15_col2);
        TextView tvLinha153 = (TextView) findViewById(R.id.tv_tabplan_lin15_col3);
        TextView tvLinha154 = (TextView) findViewById(R.id.tv_tabplan_lin15_col4);
        TextView tvLinha155 = (TextView) findViewById(R.id.tv_tabplan_lin15_col5);
        TextView tvLinha156 = (TextView) findViewById(R.id.tv_tabplan_lin15_col6);
        TextView tvLinha157 = (TextView) findViewById(R.id.tv_tabplan_lin15_col7);
        TextView tvLinha158 = (TextView) findViewById(R.id.tv_tabplan_lin15_col8);

        if (iteml15c2.equals("livre")){
            tvLinha152.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha152.setBackgroundColor(Color.RED);
        }

        if (iteml15c3.equals("livre")){
            tvLinha153.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha153.setBackgroundColor(Color.RED);
        }

        if (iteml15c4.equals("livre")){
            tvLinha154.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha154.setBackgroundColor(Color.RED);
        }

        if (iteml15c5.equals("livre")){
            tvLinha155.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha155.setBackgroundColor(Color.RED);
        }

        if (iteml15c6.equals("livre")){
            tvLinha156.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha156.setBackgroundColor(Color.RED);
        }

        if (iteml15c7.equals("livre")){
            tvLinha157.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha157.setBackgroundColor(Color.RED);
        }

        if (iteml15c8.equals("livre")){
            tvLinha158.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha158.setBackgroundColor(Color.RED);
        }

        //linha das 20:00hs
        String iteml16c2, iteml16c3, iteml16c4, iteml16c5, iteml16c6, iteml16c7, iteml16c8;

        iteml16c2 = planList.get(0).getHora20();
        iteml16c3 = planList.get(1).getHora20();
        iteml16c4 = planList.get(2).getHora20();
        iteml16c5 = planList.get(3).getHora20();
        iteml16c6 = planList.get(4).getHora20();
        iteml16c7 = planList.get(5).getHora20();
        iteml16c8 = planList.get(6).getHora20();

        TextView tvLinha162 = (TextView) findViewById(R.id.tv_tabplan_lin16_col2);
        TextView tvLinha163 = (TextView) findViewById(R.id.tv_tabplan_lin16_col3);
        TextView tvLinha164 = (TextView) findViewById(R.id.tv_tabplan_lin16_col4);
        TextView tvLinha165 = (TextView) findViewById(R.id.tv_tabplan_lin16_col5);
        TextView tvLinha166 = (TextView) findViewById(R.id.tv_tabplan_lin16_col6);
        TextView tvLinha167 = (TextView) findViewById(R.id.tv_tabplan_lin16_col7);
        TextView tvLinha168 = (TextView) findViewById(R.id.tv_tabplan_lin16_col8);

        if (iteml16c2.equals("livre")){
            tvLinha162.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha162.setBackgroundColor(Color.RED);
        }

        if (iteml16c3.equals("livre")){
            tvLinha163.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha163.setBackgroundColor(Color.RED);
        }

        if (iteml16c4.equals("livre")){
            tvLinha164.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha164.setBackgroundColor(Color.RED);
        }

        if (iteml16c5.equals("livre")){
            tvLinha165.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha165.setBackgroundColor(Color.RED);
        }

        if (iteml16c6.equals("livre")){
            tvLinha166.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha166.setBackgroundColor(Color.RED);
        }

        if (iteml16c7.equals("livre")){
            tvLinha167.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha167.setBackgroundColor(Color.RED);
        }

        if (iteml16c8.equals("livre")){
            tvLinha168.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha168.setBackgroundColor(Color.RED);
        }

        //linha das 21:00hs
        String iteml17c2, iteml17c3, iteml17c4, iteml17c5, iteml17c6, iteml17c7, iteml17c8;

        iteml17c2 = planList.get(0).getHora21();
        iteml17c3 = planList.get(1).getHora21();
        iteml17c4 = planList.get(2).getHora21();
        iteml17c5 = planList.get(3).getHora21();
        iteml17c6 = planList.get(4).getHora21();
        iteml17c7 = planList.get(5).getHora21();
        iteml17c8 = planList.get(6).getHora21();

        TextView tvLinha172 = (TextView) findViewById(R.id.tv_tabplan_lin17_col2);
        TextView tvLinha173 = (TextView) findViewById(R.id.tv_tabplan_lin17_col3);
        TextView tvLinha174 = (TextView) findViewById(R.id.tv_tabplan_lin17_col4);
        TextView tvLinha175 = (TextView) findViewById(R.id.tv_tabplan_lin17_col5);
        TextView tvLinha176 = (TextView) findViewById(R.id.tv_tabplan_lin17_col6);
        TextView tvLinha177 = (TextView) findViewById(R.id.tv_tabplan_lin17_col7);
        TextView tvLinha178 = (TextView) findViewById(R.id.tv_tabplan_lin17_col8);

        if (iteml17c2.equals("livre")){
            tvLinha172.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha172.setBackgroundColor(Color.RED);
        }

        if (iteml17c3.equals("livre")){
            tvLinha173.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha173.setBackgroundColor(Color.RED);
        }

        if (iteml17c4.equals("livre")){
            tvLinha174.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha174.setBackgroundColor(Color.RED);
        }

        if (iteml17c5.equals("livre")){
            tvLinha175.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha175.setBackgroundColor(Color.RED);
        }

        if (iteml17c6.equals("livre")){
            tvLinha176.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha176.setBackgroundColor(Color.RED);
        }

        if (iteml17c7.equals("livre")){
            tvLinha177.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha177.setBackgroundColor(Color.RED);
        }

        if (iteml17c8.equals("livre")){
            tvLinha178.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha178.setBackgroundColor(Color.RED);
        }

        //linha das 22:00hs
        String iteml18c2, iteml18c3, iteml18c4, iteml18c5, iteml18c6, iteml18c7, iteml18c8;

        iteml18c2 = planList.get(0).getHora22();
        iteml18c3 = planList.get(1).getHora22();
        iteml18c4 = planList.get(2).getHora22();
        iteml18c5 = planList.get(3).getHora22();
        iteml18c6 = planList.get(4).getHora22();
        iteml18c7 = planList.get(5).getHora22();
        iteml18c8 = planList.get(6).getHora22();

        TextView tvLinha182 = (TextView) findViewById(R.id.tv_tabplan_lin18_col2);
        TextView tvLinha183 = (TextView) findViewById(R.id.tv_tabplan_lin18_col3);
        TextView tvLinha184 = (TextView) findViewById(R.id.tv_tabplan_lin18_col4);
        TextView tvLinha185 = (TextView) findViewById(R.id.tv_tabplan_lin18_col5);
        TextView tvLinha186 = (TextView) findViewById(R.id.tv_tabplan_lin18_col6);
        TextView tvLinha187 = (TextView) findViewById(R.id.tv_tabplan_lin18_col7);
        TextView tvLinha188 = (TextView) findViewById(R.id.tv_tabplan_lin18_col8);

        if (iteml18c2.equals("livre")){
            tvLinha182.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha182.setBackgroundColor(Color.RED);
        }

        if (iteml18c3.equals("livre")){
            tvLinha183.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha183.setBackgroundColor(Color.RED);
        }

        if (iteml18c4.equals("livre")){
            tvLinha184.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha184.setBackgroundColor(Color.RED);
        }

        if (iteml18c5.equals("livre")){
            tvLinha185.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha185.setBackgroundColor(Color.RED);
        }

        if (iteml18c6.equals("livre")){
            tvLinha186.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha186.setBackgroundColor(Color.RED);
        }

        if (iteml18c7.equals("livre")){
            tvLinha187.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha187.setBackgroundColor(Color.RED);
        }

        if (iteml18c8.equals("livre")){
            tvLinha188.setBackgroundColor(Color.BLUE);
        }else{
            tvLinha188.setBackgroundColor(Color.RED);
        }

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout)findViewById(R.id.drawer_layout_confplano_estudo);
        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else {
            Intent it = new Intent(ConfigPlanestudActivity.this, PlanEstuActivity.class);
            startActivity(it);
            finish();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_premium) {
            Intent it = new Intent(ConfigPlanestudActivity.this, PremiumActivity.class);
            startActivity(it);
            finish();
        } else if (id == R.id.nav_home) {
            Intent it = new Intent(ConfigPlanestudActivity.this, SplashActivity.class);
            startActivity(it);
            finish();

        } else if (id == R.id.nav_calendario){
            Intent it = new Intent(ConfigPlanestudActivity.this, SplashCalendActivity.class);
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

        } else if (id == R.id.nav_ajuda) {
            Toast.makeText(ConfigPlanestudActivity.this, "Voce Clicou no Menu Ajuda", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_sobre) {
            Intent it = new Intent(ConfigPlanestudActivity.this, AboutActivity.class);
            startActivity(it);
            finish();

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
