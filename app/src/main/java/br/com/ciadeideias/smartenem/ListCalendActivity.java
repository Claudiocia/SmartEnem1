package br.com.ciadeideias.smartenem;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import br.com.ciadeideias.smartenem.imagem.ImageLoader;
import br.com.ciadeideias.smartenem.parse.RSSFeed;

public class ListCalendActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        View.OnClickListener,
        AbsListView.OnScrollListener {

    private FloatingActionMenu fabMenu;

    RSSFeed feed;
    ListView lv;
    CustomListAdapter adapter;
    String feedLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_calend);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.mipmap.ic_launcher);

        feedLink = new SplashActivity().RSSFEEDURL;

        feed = (RSSFeed) getIntent().getExtras().get("feed");


        lv = (ListView) findViewById(R.id.listView_calend);
        lv.setVerticalFadingEdgeEnabled(true);
        lv.setOnScrollListener(this);

        adapter = new CustomListAdapter(this);
        lv.setAdapter(adapter);

        fabMenu = (FloatingActionMenu) findViewById(R.id.fabMenu);

        fabMenu.setOnMenuToggleListener(new FloatingActionMenu.OnMenuToggleListener(){
            @Override
            public void onMenuToggle(boolean b) {
                fabMenu.setAnimationDelayPerItem(50);
                if (b == true){
                    fabMenu.setBackgroundResource(R.drawable.bg);
                }else {
                    fabMenu.setBackgroundResource(R.drawable.bg2);
                }
                //Toast.makeText(ListActivity.this, "Menu aberto?"+(b ? "true" : "false"), Toast.LENGTH_SHORT).show();

            }
        });
        fabMenu.setClosedOnTouchOutside(true);

        FloatingActionButton fab1 = (FloatingActionButton) findViewById(R.id.fab1);
        FloatingActionButton fab2 = (FloatingActionButton) findViewById(R.id.fab2);
        FloatingActionButton fab3 = (FloatingActionButton) findViewById(R.id.fab3);
        FloatingActionButton fab4 = (FloatingActionButton) findViewById(R.id.fab4);
        FloatingActionButton fab5 = (FloatingActionButton) findViewById(R.id.fab5);

        fab1.setOnClickListener(this);
        fab2.setOnClickListener(this);
        fab3.setOnClickListener(this);
        fab4.setOnClickListener(this);
        fab5.setOnClickListener(this);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_calend);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int pos = position;
                String link = feed.getItem(pos).getLink();

                //Toast.makeText(ListCalendActivity.this, "Voce clicou no item número "+pos, Toast.LENGTH_SHORT).show();
                /*Snackbar.make(view, "Você clicou no item "+pos+" e o link é: "+link, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(link));
                startActivity(intent); */

                new AlertDialog.Builder(ListCalendActivity.this).setTitle(feed.getItem(pos).getTitulo())
                        .setMessage(feed.getItem(pos).getTexto()+" \n\n"+feed.getItem(pos).getData())
                        .setPositiveButton("Fechar", new DialogInterface.OnClickListener() {
                            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        }).setNegativeButton("", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).show();

            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_calend);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }else if (fabMenu.isOpened()){
            fabMenu.close(true);
        } else {
            new AlertDialog.Builder(this).setTitle("Alerta do sistema")
                    .setMessage("Você quer encerrar o programa agora?")
                    .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finishAffinity();

                        }
                    }).setNegativeButton("Não", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

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
            Intent it = new Intent(ListCalendActivity.this, PremiumActivity.class);
            startActivity(it);
            finish();
        } else if (id == R.id.nav_home) {
            Intent it = new Intent(ListCalendActivity.this, SplashActivity.class);
            startActivity(it);
            finish();

        } else if (id == R.id.nav_calendario){
            //Toast.makeText(ListCalendActivity.this, "Voce Clicou no Menu Calendário", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_plan_estud) {
            Intent it = new Intent(ListCalendActivity.this, PlanEstuActivity.class);
            startActivity(it);
            finish();

        } else if (id == R.id.nav_meta) {
            Intent it = new Intent(ListCalendActivity.this, MetasActivity.class);
            startActivity(it);
            finish();

        } else if (id == R.id.nav_desemp) {
            Intent it = new Intent(ListCalendActivity.this, DesempenhoActivity.class);
            startActivity(it);
            finish();

        } else if (id == R.id.nav_ajuda) {
            Toast.makeText(ListCalendActivity.this, "Voce Clicou no Menu Ajuda", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_sobre) {
            Intent it = new Intent(ListCalendActivity.this, AboutActivity.class);
            startActivity(it);
            finish();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_calend);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void onClick(View v) {
        String aux = "";

        switch (v.getId()) {
            case R.id.fab1:
                aux = "Fab 1";
                //simulados
                break;
            case R.id.fab2:
                //aux = "Fab 2";
                Intent it2 = new Intent(ListCalendActivity.this, EstudoListaActivity.class);
                startActivity(it2);
                finish();
                break;
            case R.id.fab3:
                //aux = "Fab 3";
                Intent it3 = new Intent(ListCalendActivity.this, RedacaoActivity.class);
                startActivity(it3);
                finish();
                break;
            case R.id.fab4:
                //aux = "Fab 4";
                Intent it4 = new Intent(ListCalendActivity.this, DisciplinasCardActivity.class);
                startActivity(it4);
                finish();
                break;
            case R.id.fab5:
                //aux = "Fab 5";
                Intent it5 = new Intent(ListCalendActivity.this, DicasListaActivity.class);
                startActivity(it5);
                finish();
                break;
        }
        //Toast.makeText(ListActivity.this, "Menu clicado é "+aux, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

    }

    public class CustomListAdapter extends BaseAdapter {
        private LayoutInflater layoutInflater;
        public ImageLoader imageLoader;

        public CustomListAdapter(ListCalendActivity activity){
            layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            imageLoader = new ImageLoader(activity.getApplicationContext());
        }

        @Override
        public int getCount() {
            return feed.getItemCount();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View listItem = convertView;
            int pos = position;

            if (listItem == null){
                listItem = layoutInflater.inflate(R.layout.item_list_calend, null);
            }

            ImageView iv = (ImageView) listItem.findViewById(R.id.thumb);
            TextView tvMesano = (TextView)listItem.findViewById(R.id.mesano);
            TextView tvTitle = (TextView) listItem.findViewById(R.id.titulo);
            TextView tvResumo = (TextView) listItem.findViewById(R.id.resumo);
            TextView tvDatas = (TextView) listItem.findViewById(R.id.data_list);

            //imageLoader.DisplayImage(feed.getItem(pos).getImagem(), iv);

            switch (feed.getItem(pos).getData()){
                case "Aguardando início":
                    iv.setImageResource(R.drawable.calendario_br);
                    break;
                case "Prazo vigente":
                    iv.setImageResource(R.drawable.calendario_np);
                    break;
                case "Prazo encerrado":
                    iv.setImageResource(R.drawable.calendario_en);
                    break;
                case "Últimos dias":
                    iv.setImageResource(R.drawable.calendario_fp);
                    break;

            }

            tvMesano.setText(feed.getItem(pos).getLocal());
            tvTitle.setText(feed.getItem(pos).getTitulo());
            tvResumo.setText(feed.getItem(pos).getResumo());
            tvDatas.setText(feed.getItem(pos).getData());

            Log.d("claudio", "O que eu recebo no image é:" + feed.getItem(pos).getImagem().toString());


            return listItem;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        adapter.imageLoader.clearCache();
        adapter.notifyDataSetChanged();
    }
}
