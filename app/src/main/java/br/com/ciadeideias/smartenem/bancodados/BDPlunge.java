package br.com.ciadeideias.smartenem.bancodados;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import br.com.ciadeideias.smartenem.model.Usuario;

/**
 * Created by ClaudioSouza on 04/10/2016.
 */
public class BDPlunge extends SQLiteOpenHelper {
    private static String DB_PATH = "data/data/br.com.ciadeideias.smartenem/databases/";
    private static final String NOME_BD = "smartenem.db";
    private static final int VERSAO_BD = 1;
    private SQLiteDatabase dbQuery;
    private final Context dbContexto;

    public BDPlunge(Context context) {
        super(context, NOME_BD, null, VERSAO_BD);
        this.dbContexto = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void criarDataBase() throws IOException{
        boolean dbExist = checkDataBase();

        if (!dbExist){
            this.getReadableDatabase();
            try {
                this.copiarDataBase();
            }catch (IOException e){
                throw new Error("Erro ao copiar Banco de Dados");
            }
        }
        else{
            int x = buscarVersaoBd();
            if (VERSAO_BD > x ){
                String myPath = DB_PATH + NOME_BD;
                Usuario user = new Usuario();
                SQLiteDatabase db = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

                String[] colunas = new String[]{"idusuario", "nome", "email", "telefone", "regid"};
                String arg = ""+1;
                String [] args = new String[]{arg};

                Cursor cursor = db.query("usuarios", colunas, "idusuario = ?", args, null, null, null);
                if(cursor.getCount() > 0){
                    cursor.moveToFirst();
                    user.setIdUser(cursor.getInt(0));
                    user.setUserNome(cursor.getString(1));
                    user.setUserEmail(cursor.getString(2));
                    user.setUserTel(cursor.getString(3));
                    user.setRegId(cursor.getString(4));
                }
                db.close();
                this.getReadableDatabase();
                try {
                    this.copiarDataBase();
                }catch (IOException e){
                    throw new Error("Erro ao copiar Banco de Dados");
                }
                SQLiteDatabase db2 = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
                ContentValues valores = new ContentValues();
                valores.put("nome", user.getUserNome());
                valores.put("email", user.getUserEmail());
                valores.put("telefone", user.getUserTel());
                valores.put("regid", user.getRegId());

                db2.insert("usuarios", null, valores);
                db2.close();
            }
        }

    }

    private boolean checkDataBase(){
        SQLiteDatabase checkDB = null;

        try{
            String myPath = DB_PATH + NOME_BD;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

        }catch (SQLiteException e){

        }
        if(checkDB != null){
            checkDB.close();
        }

        return  checkDB != null ? true : false;
    }

    private void copiarDataBase() throws IOException{
        InputStream myInput = dbContexto.getAssets().open(NOME_BD);
        String outFileName = DB_PATH + NOME_BD;
        OutputStream myOutput = new FileOutputStream(outFileName);

        byte[] buffer = new byte[1024];
        int length;
        while((length = myInput.read(buffer))>0){
            myOutput.write(buffer, 0, length);
        }

        myOutput.flush();
        myOutput.close();
        myInput.close();
    }

    public void abrirDataBase() throws SQLException {
        String myPath = DB_PATH + NOME_BD;
        dbQuery = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
    }

    public void deletarDataBase()throws SQLException {
        String myPath = DB_PATH + NOME_BD;
        SQLiteDatabase checkDB = null;
        checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        checkDB.close();
        dbContexto.deleteDatabase(NOME_BD);
    }

    public int buscarVersaoBd(){
        String myPath = DB_PATH + NOME_BD;
        int x ;
        SQLiteDatabase db = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        x = db.getVersion();
        return x;
    }
}
