package br.com.ciadeideias.smartenem.redacao;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import br.com.ciadeideias.smartenem.R;
import br.com.ciadeideias.smartenem.RedacaoActivity;
import br.com.ciadeideias.smartenem.model.Estudo;


public class TipoTextosActivity extends AppCompatActivity
            implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_textos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.mipmap.ic_launcher);
        toolbar.setTitle(R.string.titulo_tipotxt);

        TextView tvTituloGraf = (TextView) findViewById(R.id.tv_tit_tipo_textos);
        tvTituloGraf.setText("Tipos de Textos");

        Button btnSairRed = (Button) findViewById(R.id.btn_sair_tipotxt);

        btnSairRed.setAllCaps(true);

        btnSairRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(TipoTextosActivity.this, RedacaoActivity.class);
                startActivity(it);
                finishAffinity();
            }
        });

    }

    @Override
    public void onBackPressed() {

        Intent it = new Intent(TipoTextosActivity.this, RedacaoActivity.class);
        startActivity(it);
        finish();

    }

    @Override
    public void onClick(View v) {


    }

}
