package br.com.ciadeideias.smartenem.redacao;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;
import br.com.ciadeideias.smartenem.R;
import br.com.ciadeideias.smartenem.RedacaoActivity;
import br.com.ciadeideias.smartenem.bancodados.BDRedacao;
import br.com.ciadeideias.smartenem.fragments.PraticaRedaFragment;
import br.com.ciadeideias.smartenem.model.Redacao;
import br.com.ciadeideias.smartenem.model.TemasRedacao;

public class PraticaRedacaoActivity extends AppCompatActivity
            implements View.OnClickListener{



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
        Intent it = new Intent(PraticaRedacaoActivity.this, RedacaoActivity.class);
        startActivity(it);
        finish();

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
