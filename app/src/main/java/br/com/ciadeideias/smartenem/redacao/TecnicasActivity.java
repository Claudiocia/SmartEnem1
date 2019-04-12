package br.com.ciadeideias.smartenem.redacao;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bluejamesbond.text.DocumentView;
import com.bluejamesbond.text.hyphen.DefaultHyphenator;
import com.github.chrisbanes.photoview.PhotoView;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import br.com.ciadeideias.smartenem.EstudoListaActivity;
import br.com.ciadeideias.smartenem.R;
import br.com.ciadeideias.smartenem.RedacaoActivity;
import br.com.ciadeideias.smartenem.bancodados.BDDisciplina;
import br.com.ciadeideias.smartenem.bancodados.BDEstudo;
import br.com.ciadeideias.smartenem.bancodados.BDQuestao;
import br.com.ciadeideias.smartenem.model.Estudo;
import br.com.ciadeideias.smartenem.model.Questao;


public class TecnicasActivity extends AppCompatActivity
            implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tecnicas_redacao);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.mipmap.ic_launcher);
        toolbar.setTitle(R.string.redacao);

        TextView tvTituloGraf = (TextView) findViewById(R.id.tv_tit_tecnicas_redacao);
        tvTituloGraf.setText("Técnicas de Redação");

        Button btnSairRed = (Button) findViewById(R.id.btn_sair_tecreda);

        btnSairRed.setAllCaps(true);

        btnSairRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(TecnicasActivity.this, RedacaoActivity.class);
                startActivity(it);
                finishAffinity();
            }
        });

    }

    @Override
    public void onBackPressed() {

        Intent it = new Intent(TecnicasActivity.this, RedacaoActivity.class);
        startActivity(it);
        finish();

    }

    @Override
    public void onClick(View v) {


    }

}
