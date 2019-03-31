package br.com.ciadeideias.smartenem.utils;

import java.util.ArrayList;

/**
 * Created by ClaudioSouza on 03/01/2018.
 */

public class ArraySemRepet {

    String itens1, itens2, itens3, itens4, itens5, itens6, itens7, itens8;


    public ArraySemRepet() {}

    public ArrayList<String> subst(String string1) {

        ArrayList<String> lista = new ArrayList<>();

        lista.add(0, string1);

        itens1 = "livre";
        itens2 = "C.Hum.Tec";
        itens3 = "C.Nat.Tec";
        itens4 = "Mat.Tec";
        itens5 = "L.Cod.Tec";
        itens6 = "Simul.Completo";
        itens7 = "Simul.Compac";
        itens8 = "Redação";

        if (itens1 == string1.intern()){
            lista.add(1, itens2);
            lista.add(2, itens3);
            lista.add(3, itens4);
            lista.add(4, itens5);
            lista.add(5, itens6);
            lista.add(6, itens7);
            lista.add(7, itens8);

            return lista;

        }else if (itens2 == string1.intern()){
            lista.add(1, itens1);
            lista.add(2, itens3);
            lista.add(3, itens4);
            lista.add(4, itens5);
            lista.add(5, itens6);
            lista.add(6, itens7);
            lista.add(7, itens8);

            return lista;

        }else if (itens3 == string1.intern()){
            lista.add(1, itens1);
            lista.add(2, itens2);
            lista.add(3, itens4);
            lista.add(4, itens5);
            lista.add(5, itens6);
            lista.add(6, itens7);
            lista.add(7, itens8);

            return lista;

        }else if (itens4 == string1.intern()){
            lista.add(1, itens1);
            lista.add(2, itens2);
            lista.add(3, itens3);
            lista.add(4, itens5);
            lista.add(5, itens6);
            lista.add(6, itens7);
            lista.add(7, itens8);

            return lista;

        }else if (itens5 == string1.intern()){
            lista.add(1, itens1);
            lista.add(2, itens2);
            lista.add(3, itens3);
            lista.add(4, itens4);
            lista.add(5, itens6);
            lista.add(6, itens7);
            lista.add(7, itens8);

            return lista;

        }else if (itens6 == string1.intern()){
            lista.add(1, itens1);
            lista.add(2, itens2);
            lista.add(3, itens3);
            lista.add(4, itens4);
            lista.add(5, itens5);
            lista.add(6, itens7);
            lista.add(7, itens8);

            return lista;

        }else if (itens7 == string1.intern()){
            lista.add(1, itens1);
            lista.add(2, itens2);
            lista.add(3, itens3);
            lista.add(4, itens4);
            lista.add(5, itens5);
            lista.add(6, itens6);
            lista.add(7, itens8);

            return lista;

        }else if (itens8 == string1.intern()){
            lista.add(1, itens1);
            lista.add(2, itens2);
            lista.add(3, itens3);
            lista.add(4, itens4);
            lista.add(5, itens5);
            lista.add(6, itens6);
            lista.add(7, itens7);

            return lista;
        }else{

            lista.add(1, itens1);
            lista.add(2, itens2);
            lista.add(3, itens3);
            lista.add(4, itens4);
            lista.add(5, itens5);
            lista.add(6, itens6);
            lista.add(7, itens7);
            lista.add(8, itens8);

            return  lista;
        }

    }
}
