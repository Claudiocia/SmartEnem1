package br.com.ciadeideias.smartenem;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.navigation.NavigationView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.core.view.GravityCompat;
import androidx.viewpager.widget.ViewPager;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import br.com.ciadeideias.smartenem.fragments.DetailFragment;
import br.com.ciadeideias.smartenem.parse.RSSFeed;

/**
 * Created by ClaudioSouza on 02/11/2016.
 */
public class DetailActivity extends FragmentActivity implements NavigationView.OnNavigationItemSelectedListener {
    RSSFeed feed;
    int pos;
    private DescAdapter adapter;
    private ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        toolbar.setLogo(R.mipmap.ic_launcher);
        toolbar.setTitle(R.string.title_activity_detail);

        //Obter o objeto feed e a posição na tela
        feed = (RSSFeed) getIntent().getExtras().get("feed");
        pos = getIntent().getExtras().getInt("pos");

        //Inicializando as views
        adapter = new DescAdapter(getSupportFragmentManager());
        pager = (ViewPager) findViewById(R.id.pager);

        //definindo a view para o pager
        pager.setAdapter(adapter);
        pager.setCurrentItem(pos);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_premium) {
            Intent it = new Intent(DetailActivity.this, PremiumActivity.class);
            startActivity(it);
            finish();
        } else if (id == R.id.nav_home) {
            Intent it = new Intent(DetailActivity.this, SplashActivity.class);
            startActivity(it);
            finish();
        } else if (id == R.id.nav_plan_estud) {
            Toast.makeText(DetailActivity.this, "Voce Clicou no Menu Plano de Estudo", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_meta) {
            Intent it = new Intent(DetailActivity.this, MetasActivity.class);
            startActivity(it);
            finish();

        } else if (id == R.id.nav_desemp) {
            Intent it = new Intent(DetailActivity.this, DesempenhoActivity.class);
            startActivity(it);
            finish();

        } else if (id == R.id.nav_compart){
            Toast.makeText(DetailActivity.this, "Voce Clicou no Menu Videos", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_ajuda) {
            Toast.makeText(DetailActivity.this, "Voce Clicou no Menu Ajuda", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_sobre) {
            Intent it = new Intent(DetailActivity.this, AboutActivity.class);
            startActivity(it);
            finish();

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public class DescAdapter extends FragmentStatePagerAdapter{

        public DescAdapter(FragmentManager fm){
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            DetailFragment frag = new DetailFragment();

            Bundle bundle = new Bundle();
            bundle.putSerializable("feed", feed);
            bundle.putInt("pos", position);
            frag.setArguments(bundle);
            return frag;
        }

        @Override
        public int getCount() {
            return feed.getItemCount();
        }
    }
}
