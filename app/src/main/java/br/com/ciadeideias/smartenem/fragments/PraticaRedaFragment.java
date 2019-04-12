package br.com.ciadeideias.smartenem.fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Calendar;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import br.com.ciadeideias.smartenem.R;
import br.com.ciadeideias.smartenem.adapter.PraticaRedaAdapter;
import br.com.ciadeideias.smartenem.interfaces.RecyclerViewOnClickListenerHack;
import br.com.ciadeideias.smartenem.model.TemasRedacao;
import br.com.ciadeideias.smartenem.redacao.ExpoRedacaoActivity;
import br.com.ciadeideias.smartenem.redacao.PraticaRedacaoActivity;
import br.com.ciadeideias.smartenem.utils.DividerItemDecoration;

/**
 * Created by ClaudioSouza on 08/11/2016.
 */
public class PraticaRedaFragment extends Fragment implements RecyclerViewOnClickListenerHack {
    private RecyclerView mRecyclerView;
    private List<TemasRedacao> temasList;
    int pos;

    @SuppressLint("WrongConstant")
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_temas_reda, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_list_temas_reda);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));

        mRecyclerView.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(llm);

        temasList = ((PraticaRedacaoActivity) getActivity()).getListaTemas();
        PraticaRedaAdapter adapter = new PraticaRedaAdapter(temasList, getActivity());
        adapter.setRecyclerViewOnClickListenerHack(this);
        mRecyclerView.setAdapter(adapter);

        return view;
    }


    @SuppressLint("ResourceType")
    @Override
    public void onClickListener(View view, int position) {

        pos = position;

        String horaEstudo;

        Calendar data = Calendar.getInstance();
        Long hora = data.getTimeInMillis();
        horaEstudo = hora.toString();

        int id = temasList.get(position).getIdRedacao();
        String idRedacao = ""+id;

        Intent it = new Intent(getContext(), ExpoRedacaoActivity.class);
        it.putExtra("hora_estudo", horaEstudo);
        it.putExtra("id_redacao", idRedacao);
        startActivity(it);

        //Toast.makeText(getActivity(), "Voce clicou na redação " + position + " O id dela é "+ idRedacao, Toast.LENGTH_SHORT).show();

    }


}
