package br.com.ciadeideias.smartenem.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import br.com.ciadeideias.smartenem.FormulasCardActivity;
import br.com.ciadeideias.smartenem.R;
import br.com.ciadeideias.smartenem.adapter.FormulasAdapter;
import br.com.ciadeideias.smartenem.interfaces.RecyclerViewOnClickListenerHack;
import br.com.ciadeideias.smartenem.model.NomeDisciplina;

/**
 * Created by ClaudioSouza on 08/11/2016.
 */
public class FormulasFragment extends Fragment implements RecyclerViewOnClickListenerHack {
    private RecyclerView mRecyclerView;
    private List<NomeDisciplina> discipliList;
    private int idDiscipli;
    int pos;


    @SuppressLint("WrongConstant")
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_formulas, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_list_formulas_geral);
        //mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);


            }
        });

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(llm);

        discipliList = ((FormulasCardActivity) getActivity()).getListaDisciplinaCard(3);
        FormulasAdapter adapter = new FormulasAdapter(discipliList, getActivity());
        adapter.setRecyclerViewOnClickListenerHack(this);
        mRecyclerView.setAdapter(adapter);
        return view;
    }


    @SuppressLint("ResourceType")
    @Override
    public void onClickListener(View view, int position) {

        pos = position;

        idDiscipli = discipliList.get(position).getIdDisciplina();
        Toast.makeText(getActivity(), "Voce clicou no card de número " + position + " O id dela é "+ idDiscipli, Toast.LENGTH_SHORT).show();

    }

}
