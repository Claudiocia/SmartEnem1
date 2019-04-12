package br.com.ciadeideias.smartenem.redacao;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import br.com.ciadeideias.smartenem.R;
import br.com.ciadeideias.smartenem.RedacaoActivity;


public class ErrosComunsActivity extends AppCompatActivity
            implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_erros_comuns);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.mipmap.ic_launcher);
        toolbar.setTitle(R.string.titulo_errosred);

        TextView tvTituloGraf = (TextView) findViewById(R.id.tv_tit_erros_reda);
        tvTituloGraf.setText(R.string.titulo_errosred);

        Button btnSairRed = (Button) findViewById(R.id.btn_sair_errosred);

        btnSairRed.setAllCaps(true);

        btnSairRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(ErrosComunsActivity.this, RedacaoActivity.class);
                startActivity(it);
                finishAffinity();
            }
        });

    }

    @Override
    public void onBackPressed() {

        Intent it = new Intent(ErrosComunsActivity.this, RedacaoActivity.class);
        startActivity(it);
        finish();

    }

    @Override
    public void onClick(View v) {


    }

}
