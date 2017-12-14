package br.com.ciadeideias.smartenem.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.ciadeideias.smartenem.DesempenhoActivity;
import br.com.ciadeideias.smartenem.GrafActivity;
import br.com.ciadeideias.smartenem.MetasActivity;
import br.com.ciadeideias.smartenem.R;
import br.com.ciadeideias.smartenem.adapter.DesempAdapter;
import br.com.ciadeideias.smartenem.bancodados.BDGrafico;
import br.com.ciadeideias.smartenem.interfaces.RecyclerViewOnClickListenerHack;
import br.com.ciadeideias.smartenem.model.Grafico;
import br.com.ciadeideias.smartenem.model.NomeGrafico;
import br.com.ciadeideias.smartenem.utils.DividerItemDecoration;

/**
 * Created by ClaudioSouza on 08/11/2016.
 */
public class DesempFragment extends Fragment implements RecyclerViewOnClickListenerHack {
    private RecyclerView mRecyclerView;
    private List<NomeGrafico> nomeGraficoList;
    ArrayList<Grafico> list1, list2, list3, list4;
    int tipoGraf;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_desempenho, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_list_desemp);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));

        mRecyclerView.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(llm);

        nomeGraficoList = ((DesempenhoActivity)getActivity()).getListaNome();
        DesempAdapter adapter = new DesempAdapter(nomeGraficoList, getActivity());
        adapter.setRecyclerViewOnClickListenerHack(this);
        mRecyclerView.setAdapter(adapter);

        return view;
    }


    @Override
    public void onClickListener(View view, int position) {
        int id = position+1;
        BDGrafico bdGraf = new BDGrafico(getActivity());

        Intent it = new Intent(getActivity(), GrafActivity.class);
        String area1, area2, area3, area4, titulo;
        area1 = "Ciências Humanas e suas Tecnologias";
        area2 = "Ciências da Natureza e suas Tecnologias";
        area3 = "Matemática e suas Tecnologias";
        area4 = "Linguagens, Códigos e suas Tecnologias";
        tipoGraf = id;
        it.putExtra("tipoGraf", tipoGraf);

        if (id == 1){
            titulo = "Quantidade de Questões X Dias de Estudo / últimos 7 dias";
            it.putExtra("titulo", titulo);
            list1 = bdGraf.estudosDiarios(area1);
            list2 = bdGraf.estudosDiarios(area2);
            list3 = bdGraf.estudosDiarios(area3);
            list4 = bdGraf.estudosDiarios(area4);

            int result = testeListas(list1, list2, list3, list4);

            switch (result){
                case 0:
                    Toast.makeText(getActivity(), "Você não realizou nos ultimos 7 dias nenhum " +
                            "estudo para visualizar gráficos", Toast.LENGTH_LONG).show();
                    break;
                case 4:
                    it.putExtra("area4", list4);
                    //Toast.makeText(getActivity(), "Achou apenas a lista da area 4", Toast.LENGTH_LONG).show();
                    startActivity(it);
                    break;
                case 30:
                    it.putExtra("area3", list3);
                    //Toast.makeText(getActivity(), "Achou apenas a lista da area 3", Toast.LENGTH_LONG).show();
                    startActivity(it);
                    break;
                case 200:
                    it.putExtra("area2", list2);
                    //Toast.makeText(getActivity(), "Achou apenas a lista da area 2", Toast.LENGTH_LONG).show();
                    startActivity(it);
                    break;
                case 1000:
                    it.putExtra("area1", list1);
                    //Toast.makeText(getActivity(), "Achou apenas a lista da area 1 ", Toast.LENGTH_LONG).show();
                    startActivity(it);
                    break;
                case 34:
                    it.putExtra("area3", list3);
                    it.putExtra("area4", list4);
                    //Toast.makeText(getActivity(), "Achou apenas a lista das areas 3 e 4 ", Toast.LENGTH_LONG).show();
                    startActivity(it);
                    break;
                case 230:
                    it.putExtra("area2", list2);
                    it.putExtra("area3", list3);
                    //Toast.makeText(getActivity(), "Achou apenas a lista das areas 2 e 3 ", Toast.LENGTH_LONG).show();
                    startActivity(it);
                    break;
                case 204:
                    it.putExtra("area2", list2);
                    it.putExtra("area4", list4);
                    //Toast.makeText(getActivity(), "Achou apenas a lista das areas 2 e 4 ", Toast.LENGTH_LONG).show();
                    startActivity(it);
                    break;
                case 1200:
                    it.putExtra("area1", list1);
                    it.putExtra("area2", list2);
                    //Toast.makeText(getActivity(), "Achou apenas a lista das areas 1 e 2 ", Toast.LENGTH_LONG).show();
                    startActivity(it);
                    break;
                case 1030:
                    it.putExtra("area1", list1);
                    it.putExtra("area3", list3);
                    //Toast.makeText(getActivity(), "Achou apenas a lista das areas 1 e 3 ", Toast.LENGTH_LONG).show();
                    startActivity(it);
                    break;
                case 1004:
                    it.putExtra("area1", list1);
                    it.putExtra("area4", list4);
                    //Toast.makeText(getActivity(), "Achou apenas a lista da area 3 e 4 ", Toast.LENGTH_LONG).show();
                    startActivity(it);
                    break;
                case 1230:
                    it.putExtra("area1", list1);
                    it.putExtra("area2", list2);
                    it.putExtra("area3", list3);
                    //Toast.makeText(getActivity(), "Achou apenas a lista da area 1, 2 e 3 ", Toast.LENGTH_LONG).show();
                    startActivity(it);
                    break;
                case 1204:
                    it.putExtra("area1", list1);
                    it.putExtra("area2", list2);
                    it.putExtra("area4", list4);
                    //Toast.makeText(getActivity(), "Achou apenas a lista da area 1, 2 e 4 ", Toast.LENGTH_LONG).show();
                    startActivity(it);
                    break;
                case 1034:
                    it.putExtra("area1", list1);
                    it.putExtra("area3", list3);
                    it.putExtra("area4", list4);
                    //Toast.makeText(getActivity(), "Achou apenas a lista da area 1, 3 e 4 ", Toast.LENGTH_LONG).show();
                    startActivity(it);
                    break;
                case 234:
                    it.putExtra("area2", list2);
                    it.putExtra("area3", list3);
                    it.putExtra("area4", list4);
                    //Toast.makeText(getActivity(), "Achou apenas a lista da area 2, 3 e 4 ", Toast.LENGTH_LONG).show();
                    startActivity(it);
                    break;
                default:
                    it.putExtra("area1", list1);
                    it.putExtra("area2", list2);
                    it.putExtra("area3", list3);
                    it.putExtra("area4", list4);
                    //Toast.makeText(getActivity(), "Achou apenas a lista da area 1, 2, 3 e 4 ", Toast.LENGTH_LONG).show();
                    startActivity(it);
            }
        }
        else if (id == 2){
            titulo = "Quantidade de Acertos/Erros X Área de Estudos";
            it.putExtra("titulo", titulo);
            list1 = bdGraf.estudosDiarios(area1);
            list2 = bdGraf.estudosDiarios(area2);
            list3 = bdGraf.estudosDiarios(area3);
            list4 = bdGraf.estudosDiarios(area4);

            int result = testeListas(list1, list2, list3, list4);

            switch (result){
                case 0:
                    Toast.makeText(getActivity(), "Você não realizou nos ultimos 7 dias nenhum " +
                            "estudo para visualizar gráficos", Toast.LENGTH_LONG).show();
                    break;
                case 4:
                    it.putExtra("area4", list4);
                    startActivity(it);
                    break;
                case 30:
                    it.putExtra("area3", list3);
                    startActivity(it);
                    break;
                case 200:
                    it.putExtra("area2", list2);
                    startActivity(it);
                    break;
                case 1000:
                    it.putExtra("area1", list1);
                    startActivity(it);
                    break;
                case 34:
                    it.putExtra("area3", list3);
                    it.putExtra("area4", list4);
                    startActivity(it);
                    break;
                case 230:
                    it.putExtra("area2", list2);
                    it.putExtra("area3", list3);
                    startActivity(it);
                    break;
                case 204:
                    it.putExtra("area2", list2);
                    it.putExtra("area4", list4);
                    startActivity(it);
                    break;
                case 1200:
                    it.putExtra("area1", list1);
                    it.putExtra("area2", list2);
                    startActivity(it);
                    break;
                case 1030:
                    it.putExtra("area1", list1);
                    it.putExtra("area3", list3);
                    startActivity(it);
                    break;
                case 1004:
                    it.putExtra("area1", list1);
                    it.putExtra("area4", list4);
                    startActivity(it);
                    break;
                case 1230:
                    it.putExtra("area1", list1);
                    it.putExtra("area2", list2);
                    it.putExtra("area3", list3);
                    startActivity(it);
                    break;
                case 1204:
                    it.putExtra("area1", list1);
                    it.putExtra("area2", list2);
                    it.putExtra("area4", list4);
                    startActivity(it);
                    break;
                case 1034:
                    it.putExtra("area1", list1);
                    it.putExtra("area3", list3);
                    it.putExtra("area4", list4);
                    startActivity(it);
                    break;
                case 234:
                    it.putExtra("area2", list2);
                    it.putExtra("area3", list3);
                    it.putExtra("area4", list4);
                    startActivity(it);
                    break;
                default:
                    it.putExtra("area1", list1);
                    it.putExtra("area2", list2);
                    it.putExtra("area3", list3);
                    it.putExtra("area4", list4);
                    startActivity(it);
            }
        }
        else if (id == 3){
            titulo ="Tempo dedicado aos estudos X Dias / últimos 7 dias";
            it.putExtra("titulo", titulo);
            list1 = bdGraf.tempoEstudo();
            if (list1.isEmpty()){
                Toast.makeText(getActivity(), "Você não realizou nos últimos 7 dias nenhuma " +
                        "atividade de estudo em qualquer área", Toast.LENGTH_LONG).show();
            }
            else {
                it.putExtra("tempo", list1 );
                startActivity(it);
            }
        }
        else if (id == 4){
            titulo = "Quantidade de Simulados compactos X Dias de Estudos  / últimos 7 dias";
            it.putExtra("titulo", titulo);
            list1 = bdGraf.simulCompac(area1);
            list2 = bdGraf.simulCompac(area2);
            list3 = bdGraf.simulCompac(area3);
            list4 = bdGraf.simulCompac(area4);
            int result = testeListas(list1, list2, list3, list4);

            switch (result){
                case 0:
                    Toast.makeText(getActivity(), "Você não realizou nos últimos 7 dias nenhum " +
                            "simulado compacto de qualquer área", Toast.LENGTH_LONG).show();
                    break;
                case 4:
                    it.putExtra("area4", list4);
                    startActivity(it);
                    break;
                case 30:
                    it.putExtra("area3", list3);
                    startActivity(it);
                    break;
                case 200:
                    it.putExtra("area2", list2);
                    startActivity(it);
                    break;
                case 1000:
                    it.putExtra("area1", list1);
                    startActivity(it);
                    break;
                case 34:
                    it.putExtra("area3", list3);
                    it.putExtra("area4", list4);
                    startActivity(it);
                    break;
                case 230:
                    it.putExtra("area2", list2);
                    it.putExtra("area3", list3);
                    startActivity(it);
                    break;
                case 204:
                    it.putExtra("area2", list2);
                    it.putExtra("area4", list4);
                    startActivity(it);
                    break;
                case 1200:
                    it.putExtra("area1", list1);
                    it.putExtra("area2", list2);
                    startActivity(it);
                    break;
                case 1030:
                    it.putExtra("area1", list1);
                    it.putExtra("area3", list3);
                    startActivity(it);
                    break;
                case 1004:
                    it.putExtra("area1", list1);
                    it.putExtra("area4", list4);
                    startActivity(it);
                    break;
                case 1230:
                    it.putExtra("area1", list1);
                    it.putExtra("area2", list2);
                    it.putExtra("area3", list3);
                    startActivity(it);
                    break;
                case 1204:
                    it.putExtra("area1", list1);
                    it.putExtra("area2", list2);
                    it.putExtra("area4", list4);
                    startActivity(it);
                    break;
                case 1034:
                    it.putExtra("area1", list1);
                    it.putExtra("area3", list3);
                    it.putExtra("area4", list4);
                    startActivity(it);
                    break;
                case 234:
                    it.putExtra("area2", list2);
                    it.putExtra("area3", list3);
                    it.putExtra("area4", list4);
                    startActivity(it);
                    break;
                default:
                    it.putExtra("area1", list1);
                    it.putExtra("area2", list2);
                    it.putExtra("area3", list3);
                    it.putExtra("area4", list4);
                    startActivity(it);
            }
        }else if (id == 5){
            titulo ="Simulados Completos X Dias / últimos 7 dias";
            it.putExtra("titulo", titulo);
            list1 = bdGraf.simulComplet();
            if (list1.isEmpty()){
                Toast.makeText(getActivity(), "Você não realizou nos últimos 7 dias nenhum " +
                        "simulado completo", Toast.LENGTH_LONG).show();
            }
            else {
                it.putExtra("simulComple", list1 );
                startActivity(it);
            }
        }
        else if (id == 6){
            titulo ="Simulados Completos X Tempo usado / últimos 7 dias";
            it.putExtra("titulo", titulo);
            list1 = bdGraf.simulComplet();
            if (list1.isEmpty()){
                Toast.makeText(getActivity(), "Você não realizou nos últimos 7 dias nenhum " +
                        "simulado completo", Toast.LENGTH_LONG).show();
            }
            else {
                it.putExtra("tempoComple", list1 );
                startActivity(it);
            }
        }
        else if (id == 7){
            titulo ="Pontos Alcançados X Simulados Completos / últimos 7 dias";
            it.putExtra("titulo", titulo);
            list1 = bdGraf.simulComplet();
            if (list1.isEmpty()){
                Toast.makeText(getActivity(), "Você não realizou nos últimos 7 dias nenhum " +
                        "simulado completo", Toast.LENGTH_LONG).show();
            }
            else {
                it.putExtra("pontosComple", list1 );
                startActivity(it);
            }
        }
    }

    public int testeListas(List<Grafico> list1, List<Grafico> list2, List<Grafico> list3, List<Grafico> list4){
        int x = 0;
        if (list1.isEmpty() && list2.isEmpty() && list3.isEmpty() && list4.isEmpty()){
            x = 0;
        }else if (list1.isEmpty() && list2.isEmpty() && list3.isEmpty() && !list4.isEmpty()){
            x = 4;
        }else if(list1.isEmpty() && list2.isEmpty() && !list3.isEmpty() && list4.isEmpty()){
            x = 30;
        }else if (list1.isEmpty() && !list2.isEmpty() && list3.isEmpty() && list4.isEmpty()){
            x = 200;
        }else if (!list1.isEmpty() && list2.isEmpty() && list3.isEmpty() && list4.isEmpty()){
            x = 1000;
        }else if (list1.isEmpty() && list2.isEmpty() && !list3.isEmpty() && !list4.isEmpty()){
            x = 34;
        }else if (list1.isEmpty() && !list2.isEmpty() && !list3.isEmpty() && list4.isEmpty()){
            x = 230;
        }else if (list1.isEmpty() && !list2.isEmpty() && list3.isEmpty() && !list4.isEmpty()){
            x = 204;
        }else if (!list1.isEmpty() && !list2.isEmpty() && list3.isEmpty() && list4.isEmpty()){
            x = 1200;
        }else if (!list1.isEmpty() && list2.isEmpty() && !list3.isEmpty() && list4.isEmpty()){
            x = 1030;
        }else if (!list1.isEmpty() && list2.isEmpty() && list3.isEmpty() && !list4.isEmpty()){
            x = 1004;
        }else if (!list1.isEmpty() && !list2.isEmpty() && !list3.isEmpty() && list4.isEmpty()){
            x = 1230;
        }else if (!list1.isEmpty() && !list2.isEmpty() && list3.isEmpty() && !list4.isEmpty()){
            x = 1204;
        }else if (!list1.isEmpty() && list2.isEmpty() && !list3.isEmpty() && !list4.isEmpty()){
            x = 1034;
        }else if (list1.isEmpty() && !list2.isEmpty() && !list3.isEmpty() && !list4.isEmpty()){
            x = 234;
        }else{
            x = 1234;
        }

        return x;
    }

}
