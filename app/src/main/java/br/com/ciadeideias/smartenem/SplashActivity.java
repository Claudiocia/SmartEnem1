package br.com.ciadeideias.smartenem;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import br.com.ciadeideias.smartenem.bancodados.BDPlunge;
import br.com.ciadeideias.smartenem.parse.DOMParseHtml;
import br.com.ciadeideias.smartenem.parse.RSSFeed;

/**
 * Created by ClaudioSouza on 01/11/2016.
 */
public class SplashActivity extends AppCompatActivity {
    String RSSFEEDURL = "http://www.smartenem.com.br/noticias/index";  //"http://192.168.25.3/agenda/listagenda.php";
    RSSFeed feed;
    String fileName;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        BDPlunge bd = new BDPlunge(this);
        try {
            bd.criarDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }

        fileName = "SmartEnemDoc.td";

        File feedFile = getBaseContext().getFileStreamPath(fileName);

        ConnectivityManager conMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (conMgr.getActiveNetworkInfo() == null){
            if (!feedFile.exists()){
                //Sem conectividade e o arquivo não existe. Mostra uma mensagem e sai
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Servidor inacessivel! \n  Favor verificar sua rede.")
                        .setTitle("SmartEnem")
                        .setCancelable(false)
                        .setPositiveButton("Sair", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }else{
                //Não tem conectividade mas existe o arquivo. o feed será formado a partir do arquivo
                Toast toast = Toast.makeText(this, "Sem conectividade. Lendo as ultimas materias salvas", Toast.LENGTH_LONG);
                toast.show();

                feed = ReadFeed(fileName);
                startLisActivity(feed);
            }
        }else {
            //Conectado - dispara o Parsing
            new AsyncLoadXMLFeed().execute();
        }
    }

    private void startLisActivity(RSSFeed feed){
        Bundle bundle = new Bundle();
        bundle.putSerializable("feed", feed);

        Intent it = new Intent(SplashActivity.this, ListActivity.class);
        it.putExtras(bundle);
        startActivity(it);

        finish();
    }

    private class AsyncLoadXMLFeed extends AsyncTask<Void, Void, Void>{
        @Override
        protected Void doInBackground(Void... params) {
            DOMParseHtml myParser = new DOMParseHtml();
            feed = myParser.parseHtml(RSSFEEDURL);
            if (feed != null && feed.getItemCount() > 0)
                WriteFeed(feed);
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

            startLisActivity(feed);
        }
    }

    private void WriteFeed (RSSFeed data){
        FileOutputStream fOut = null;
        ObjectOutputStream osw = null;

        try {
            fOut = openFileOutput(fileName, MODE_PRIVATE);
            osw = new ObjectOutputStream(fOut);
            osw.writeObject(data);
            osw.flush();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                fOut.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }

    }

    private RSSFeed ReadFeed (String fName){
        FileInputStream fIn = null;
        ObjectInputStream isr = null;

        RSSFeed _feed = null;
        File feedFile = getBaseContext().getFileStreamPath(fileName);
        if (!feedFile.exists())
            return null;

        try {
            fIn = openFileInput(fName);
            isr = new ObjectInputStream(fIn);

            _feed = (RSSFeed) isr.readObject();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fIn.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return _feed;

    }

}
