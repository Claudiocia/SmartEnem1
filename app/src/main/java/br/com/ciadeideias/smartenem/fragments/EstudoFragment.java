package br.com.ciadeideias.smartenem.fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.ciadeideias.smartenem.EstuDiarioActivity;
import br.com.ciadeideias.smartenem.EstudoListaActivity;
import br.com.ciadeideias.smartenem.R;
import br.com.ciadeideias.smartenem.adapter.EstudoAdapter;
import br.com.ciadeideias.smartenem.interfaces.RecyclerViewOnClickListenerHack;
import br.com.ciadeideias.smartenem.model.NomeDisciplina;
import br.com.ciadeideias.smartenem.utils.DividerItemDecoration;

/**
 * Created by ClaudioSouza on 08/11/2016.
 */
public class EstudoFragment extends Fragment implements RecyclerViewOnClickListenerHack {
    private RecyclerView mRecyclerView;
    private List<NomeDisciplina> nomeDisciplinaList;


    @SuppressLint("WrongConstant")
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_estudo, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_list_estudo);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));

        mRecyclerView.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(llm);

        nomeDisciplinaList = ((EstudoListaActivity) getActivity()).getListaDisciplinas();
        EstudoAdapter adapter = new EstudoAdapter(nomeDisciplinaList, getActivity());
        adapter.setRecyclerViewOnClickListenerHack(this);
        mRecyclerView.setAdapter(adapter);

        return view;
    }


    @Override
    public void onClickListener(View view, int position) {
        int id = position;

        String aux, horaEstudo;

        Calendar data = Calendar.getInstance();
        Long hora = data.getTimeInMillis();
        horaEstudo = hora.toString();
        aux = nomeDisciplinaList.get(position).getNome();

        switch (id){
            case 0:
                Intent it = new Intent(getContext(), EstuDiarioActivity.class);
                it.putExtra("hora_estudo", horaEstudo);
                it.putExtra("disciplina", aux);
                startActivity(it);
                break;
            case 1:
                Intent it1 = new Intent(getContext(), EstuDiarioActivity.class);
                it1.putExtra("hora_estudo", horaEstudo);
                it1.putExtra("disciplina", aux);
                startActivity(it1);
                break;
            case 2:
                Intent it2 = new Intent(getContext(), EstuDiarioActivity.class);
                it2.putExtra("hora_estudo", horaEstudo);
                it2.putExtra("disciplina", aux);
                startActivity(it2);
                break;
            case 3:
                Intent it3 = new Intent(getContext(), EstuDiarioActivity.class);
                it3.putExtra("hora_estudo", horaEstudo);
                it3.putExtra("disciplina", aux);
                startActivity(it3);
                break;
            case 4:
                Intent it4 = new Intent(getContext(), EstuDiarioActivity.class);
                it4.putExtra("hora_estudo", horaEstudo);
                it4.putExtra("disciplina", aux);
                startActivity(it4);
                break;
            case 5:
                Intent it5 = new Intent(getContext(), EstuDiarioActivity.class);
                it5.putExtra("hora_estudo", horaEstudo);
                it5.putExtra("disciplina", aux);
                startActivity(it5);
                break;
            case 6:
                Intent it6 = new Intent(getContext(), EstuDiarioActivity.class);
                it6.putExtra("hora_estudo", horaEstudo);
                it6.putExtra("disciplina", aux);
                startActivity(it6);
                break;
            case 7:
                Intent it7 = new Intent(getContext(), EstuDiarioActivity.class);
                it7.putExtra("hora_estudo", horaEstudo);
                it7.putExtra("disciplina", aux);
                startActivity(it7);
                break;
            case 8:
                Intent it8 = new Intent(getContext(), EstuDiarioActivity.class);
                it8.putExtra("hora_estudo", horaEstudo);
                it8.putExtra("disciplina", aux);
                startActivity(it8);
                break;
            case 9:
                Intent it9 = new Intent(getContext(), EstuDiarioActivity.class);
                it9.putExtra("hora_estudo", horaEstudo);
                it9.putExtra("disciplina", aux);
                startActivity(it9);
                break;
            case 10:
                Intent it10 = new Intent(getContext(), EstuDiarioActivity.class);
                it10.putExtra("hora_estudo", horaEstudo);
                it10.putExtra("disciplina", aux);
                startActivity(it10);
                break;
            case 11:
                Intent it11 = new Intent(getContext(), EstuDiarioActivity.class);
                it11.putExtra("hora_estudo", horaEstudo);
                it11.putExtra("disciplina", aux);
                startActivity(it11);
                break;
            case 12:
                Intent it12 = new Intent(getContext(), EstuDiarioActivity.class);
                it12.putExtra("hora_estudo", horaEstudo);
                it12.putExtra("disciplina", aux);
                startActivity(it12);
                break;

            }


    }
}
