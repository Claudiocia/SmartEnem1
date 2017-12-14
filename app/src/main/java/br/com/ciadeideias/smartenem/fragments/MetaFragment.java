package br.com.ciadeideias.smartenem.fragments;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.ciadeideias.smartenem.MetasActivity;
import br.com.ciadeideias.smartenem.R;
import br.com.ciadeideias.smartenem.adapter.MetaAdapter;
import br.com.ciadeideias.smartenem.bancodados.BDMeta;
import br.com.ciadeideias.smartenem.interfaces.RecyclerViewOnClickListenerHack;
import br.com.ciadeideias.smartenem.model.Meta;
import br.com.ciadeideias.smartenem.utils.DividerItemDecoration;

/**
 * Created by ClaudioSouza on 04/11/2016.
 */
public class MetaFragment extends Fragment implements RecyclerViewOnClickListenerHack, View.OnClickListener {
    private RecyclerView mRecyclerView;
    private List<Meta> metaList;
    public  static Dialog dialog;
    ImageView buttonFechar;
    Button buttonSalvar1;
    EditText edtMeta1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_meta, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_list_metas);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));

        mRecyclerView.setHasFixedSize(true);


        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(llm);

        metaList = ((MetasActivity)getActivity()).getListMetas();
        MetaAdapter adapter = new MetaAdapter(getActivity(), metaList);
        adapter.setRecyclerViewOnClickListenerHack(this);
        mRecyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onClickListener(View view, int position) {
        int id;

        switch (position){
            case 0: case 1:case 2: case 3:
                id = position+1;
                configMetas(id);
                break;
            case 4:
                id = position+1;
                configRed(id);
                break;
            case 5:
                id = position+1;
                configCompac(id);
                break;
            case 6:
                id = position+1;
                configComple(id);
                break;
        }
        //Toast.makeText(getActivity(), "Voce clicou no item número "+ position + " ID nº: "+ id, Toast.LENGTH_LONG).show();
    }

    public void configMetas(int id){
        final int x =id;
        BDMeta buscarMeta = new BDMeta(getActivity());
        Meta metaAtiva = buscarMeta.buscarMeta(x);
        dialog = new Dialog(getActivity(), R.style.FullHeightDialog);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.meta_1);
        TextView tvNomeMeta = (TextView) dialog.findViewById(R.id.titulo_dialog_meta_1);
        tvNomeMeta.setText(metaAtiva.getNomeMeta().toString());
        buttonFechar = (ImageView) dialog.findViewById(R.id.button_fechar_1);
        buttonSalvar1 = (Button) dialog.findViewById(R.id.button_salvar_meta1);
        edtMeta1 = (EditText) dialog.findViewById(R.id.edt_meta_1);
        String valorMetaAtiv = ""+metaAtiva.getValorMeta();
        edtMeta1.setText(valorMetaAtiv);

        dialog.show();

        buttonSalvar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvar(x);
            }
        });

        buttonFechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

    }

    public void configRed(int id){
        final int x =id;
        BDMeta buscarMeta = new BDMeta(getActivity());
        Meta metaAtiva = buscarMeta.buscarMeta(x);
        dialog = new Dialog(getActivity(), R.style.FullHeightDialog);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.meta_red);
        TextView tvNomeMeta = (TextView) dialog.findViewById(R.id.titulo_dialog_meta_red);
        tvNomeMeta.setText(metaAtiva.getNomeMeta().toString());
        buttonFechar = (ImageView) dialog.findViewById(R.id.button_fechar_red);
        buttonSalvar1 = (Button) dialog.findViewById(R.id.button_salvar_meta_red);
        edtMeta1 = (EditText) dialog.findViewById(R.id.edt_meta_red);
        String valorMetaAtiv = ""+metaAtiva.getValorMeta();
        edtMeta1.setText(valorMetaAtiv);

        dialog.show();

        buttonSalvar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvar(x);
            }
        });

        buttonFechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

    }

    public void configCompac(int id){
        final int x =id;
        BDMeta buscarMeta = new BDMeta(getActivity());
        Meta metaAtiva = buscarMeta.buscarMeta(x);
        dialog = new Dialog(getActivity(), R.style.FullHeightDialog);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.meta_simul_compac);
        TextView tvNomeMeta = (TextView) dialog.findViewById(R.id.titulo_dialog_meta_compac);
        tvNomeMeta.setText(metaAtiva.getNomeMeta().toString());
        buttonFechar = (ImageView) dialog.findViewById(R.id.button_fechar_compac);
        buttonSalvar1 = (Button) dialog.findViewById(R.id.button_salvar_meta_compac);
        edtMeta1 = (EditText) dialog.findViewById(R.id.edt_meta_compac);
        String valorMetaAtiv = ""+metaAtiva.getValorMeta();
        edtMeta1.setText(valorMetaAtiv);

        dialog.show();

        buttonSalvar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvar(x);
            }
        });

        buttonFechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

    }

    public void configComple(int id){
        final int x =id;
        BDMeta buscarMeta = new BDMeta(getActivity());
        Meta metaAtiva = buscarMeta.buscarMeta(x);
        dialog = new Dialog(getActivity(), R.style.FullHeightDialog);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.meta_simul_comple);
        TextView tvNomeMeta = (TextView) dialog.findViewById(R.id.titulo_dialog_meta_comple);
        tvNomeMeta.setText(metaAtiva.getNomeMeta().toString());
        buttonFechar = (ImageView) dialog.findViewById(R.id.button_fechar_comple);
        buttonSalvar1 = (Button) dialog.findViewById(R.id.button_salvar_meta_comple);
        edtMeta1 = (EditText) dialog.findViewById(R.id.edt_meta_comple);
        String valorMetaAtiv = ""+metaAtiva.getValorMeta();
        edtMeta1.setText(valorMetaAtiv);

        dialog.show();

        buttonSalvar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvar(x);
            }
        });

        buttonFechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

    }

    public void salvar(int id){
        BDMeta bdMeta = new BDMeta(getActivity());
        Meta meta1 = new Meta();

        int valorMeta1 = Integer.parseInt(edtMeta1.getText().toString());

        meta1.setIdMeta(id);
        meta1.setValorMeta(valorMeta1);

        bdMeta.configurarMetas(meta1);
        MetaFragment.dialog.dismiss();
        Intent cadQuest = new Intent(getActivity(), MetasActivity.class);
        startActivity(cadQuest);
        getActivity().finish();

    }

    @Override
    public void onClick(View v) {

    }


}
