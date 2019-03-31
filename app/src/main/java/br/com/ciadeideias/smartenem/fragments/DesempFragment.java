package br.com.ciadeideias.smartenem.fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.ciadeideias.smartenem.DesempenhoActivity;

import br.com.ciadeideias.smartenem.R;
import br.com.ciadeideias.smartenem.adapter.DesempAdapter;
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

        nomeGraficoList = ((DesempenhoActivity) getActivity()).getListaNome();
        DesempAdapter adapter = new DesempAdapter(nomeGraficoList, getActivity());
        adapter.setRecyclerViewOnClickListenerHack(this);
        mRecyclerView.setAdapter(adapter);

        return view;
    }


    @Override
    public void onClickListener(View view, int position) {
        int id = position + 1;
        String aux;

        switch (id){
            case 1:
                aux = "Estudos Diarios";
                Toast.makeText(getContext(), "Menu clicado é "+ aux, Toast.LENGTH_SHORT).show();

            case 2:
                aux = "Questões Respondidas";
                Toast.makeText(getContext(), "Menu clicado é "+ aux, Toast.LENGTH_SHORT).show();
            break;

            case 3:
                aux = "Questões Certas X Erradas";
                Toast.makeText(getContext(), "Menu clicado é "+ aux, Toast.LENGTH_SHORT).show();
            break;

            case 4:
                aux = "Área de Estudo";
                Toast.makeText(getContext(), "Menu clicado é "+ aux, Toast.LENGTH_SHORT).show();
            break;

            case 5:
                aux = "Tempo de Estudo";
                Toast.makeText(getContext(), "Menu clicado é "+ aux, Toast.LENGTH_SHORT).show();
            break;


        }



    }
}
