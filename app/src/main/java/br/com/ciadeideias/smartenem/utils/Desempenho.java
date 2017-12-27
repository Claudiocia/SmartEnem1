package br.com.ciadeideias.smartenem.utils;

import android.content.Context;

import br.com.ciadeideias.smartenem.bancodados.BDMeta;
import br.com.ciadeideias.smartenem.model.Meta;

/**
 * Created by ClaudioSouza on 26/12/2017.
 */

public class Desempenho {

    String desempSemana, nivelDedic;

    public Desempenho(){

    }

    public String testeDesemp (int valor, String nivel){

        if(nivel.contentEquals("Pouco dedicado")) {

            if (valor <= 6300) {
                desempSemana = "Péssimo";
            }else if (valor >= 6301 && valor <= 12600){
                desempSemana = "Ruim";
            }else if (valor >= 12601 && valor <= 18900){
                desempSemana = "Regular";
            }else if (valor >= 18901 && valor <= 25200){
                desempSemana = "Bom";
            }else if (valor >= 25201){
                desempSemana = "Ótimo";
            }
        }else if (nivel.contentEquals("Dedicado")){
            if (valor <= 12600) {
                desempSemana = "Péssimo";
            }else if (valor >= 12601 && valor <= 25200){
                desempSemana = "Ruim";
            }else if (valor >= 25201 && valor <= 37800){
                desempSemana = "Regular";
            }else if (valor >= 37801 && valor <= 50400){
                desempSemana = "Bom";
            }else if (valor >= 50401){
                desempSemana = "Ótimo";
            }
        }else if (nivel.contentEquals("Bastante Dedicado")){
            if (valor <= 25200) {
                desempSemana = "Péssimo";
            }else if (valor >= 25201 && valor <= 50400){
                desempSemana = "Ruim";
            }else if (valor >= 50401 && valor <= 75600){
                desempSemana = "Regular";
            }else if (valor >= 75601 && valor <= 100800){
                desempSemana = "Bom";
            }else if (valor >= 100801){
                desempSemana = "Ótimo";
            }
        }else if (nivel.contentEquals("Dedicação Exclusiva")){
            if (valor <= 37800) {
                desempSemana = "Péssimo";
            }else if (valor >= 37801 && valor <= 75600){
                desempSemana = "Ruim";
            }else if (valor >= 75601 && valor <= 113400){
                desempSemana = "Regular";
            }else if (valor >= 113401 && valor <= 151200){
                desempSemana = "Bom";
            }else if (valor >= 151201){
                desempSemana = "Ótimo";
            }
        }

        return desempSemana;
    }

}
