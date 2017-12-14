package br.com.ciadeideias.smartenem.bancodados;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import br.com.ciadeideias.smartenem.model.Usuario;

/**
 * Created by ClaudioSouza on 04/10/2016.
 */
public class BDUsuario {
    private SQLiteDatabase bd;

    public BDUsuario(Context context) {
        BDPlunge auxBD = new BDPlunge(context);

        bd = auxBD.getWritableDatabase();
    }

    public void inserir(Usuario user){
        ContentValues valores = new ContentValues();
        valores.put("nome", user.getUserNome());
        valores.put("email", user.getUserEmail());
        valores.put("telefone", user.getUserTel());
        valores.put("regid", user.getRegId());

        bd.insert("usuarios", null, valores);
    }

    public void atualizar(Usuario user){
        ContentValues valores = new ContentValues();
        valores.put("nome", user.getUserNome());
        valores.put("email", user.getUserEmail());
        valores.put("telefone", user.getUserTel());
        valores.put("regid", user.getRegId());

        String arg = ""+ user.getIdUser();
        String [] args = new String[]{arg};

        bd.update("usuarios", valores, "idusuario = ?", args);
    }

    public void deletar(Usuario user){
        String arg = ""+ user.getIdUser();
        String [] args = new String[]{arg};

        bd.delete("usuarios", "idusuario = ?", args);
    }

    public boolean buscaPorArg(String arg){
        String[] colunas = new String[]{"idusuario", "nome", "email", "telefone", "regid"};
        String[] args =  new String[]{arg};

        Cursor c = bd.query("usuarios", colunas, "idusuario = ?", args, null, null, null);
        if (c.getCount() > 0){
            return true;
        }
        else {
            return false;
        }
    }

    public Usuario buscaPorId(int id){
        Usuario user = new Usuario();
        String[] colunas = new String[]{"idusuario", "nome", "email", "telefone", "regid"};
        String[] args = new String[]{""+id};
        Cursor cursor = bd.query("usuarios", colunas, "_idusuario = ?", args, null, null, null);

        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            user.setIdUser(cursor.getInt(0));
            user.setUserNome(cursor.getString(1));
            user.setUserEmail(cursor.getString(2));
            user.setUserTel(cursor.getString(3));
            user.setRegId(cursor.getString(4));
        }
        bd.close();
        return user;
    }
}
