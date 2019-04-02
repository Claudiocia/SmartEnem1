package br.com.ciadeideias.smartenem.fragments;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bluejamesbond.text.DocumentView;
import com.github.chrisbanes.photoview.PhotoView;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import br.com.ciadeideias.smartenem.DicasListaActivity;
import br.com.ciadeideias.smartenem.R;
import br.com.ciadeideias.smartenem.adapter.DicasAdapter;
import br.com.ciadeideias.smartenem.bancodados.BDDica;
import br.com.ciadeideias.smartenem.interfaces.RecyclerViewOnClickListenerHack;
import br.com.ciadeideias.smartenem.model.Dica;
import br.com.ciadeideias.smartenem.model.TituloDica;
import br.com.ciadeideias.smartenem.utils.DividerItemDecoration;

/**
 * Created by ClaudioSouza on 08/11/2016.
 */
public class DicasFragment extends Fragment implements RecyclerViewOnClickListenerHack {
    private RecyclerView mRecyclerView;
    private List<TituloDica> dicasList;
    private int idDica;
    int pos;

    Dialog myDialog;


    @SuppressLint("WrongConstant")
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_dicas, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_list_dicas);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));

        mRecyclerView.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(llm);

        dicasList = ((DicasListaActivity) getActivity()).getListaDicas();
        DicasAdapter adapter = new DicasAdapter(dicasList, getActivity());
        adapter.setRecyclerViewOnClickListenerHack(this);
        mRecyclerView.setAdapter(adapter);

        return view;
    }


    @SuppressLint("ResourceType")
    @Override
    public void onClickListener(View view, int position) {

        pos = position;

        idDica = dicasList.get(position).getIdDica();
        ShowPopupDica(view.findViewById(R.layout.custom_popup_dicas));

        //Toast.makeText(getActivity(), "Voce clicou na dica de número " + position + " O id dela é "+ idDica, Toast.LENGTH_SHORT).show();

    }

    public void ShowPopupDica(View v){

        myDialog = new Dialog(getActivity());
        TextView tvTitDica;
        DocumentView dvTextoDica;
        PhotoView photo;
        Button btnVoltar;
        ImageView ivTitPagDica;

        myDialog.setContentView(R.layout.custom_popup_dicas);

        ivTitPagDica = (ImageView)myDialog.findViewById(R.id.iv_titulo_dica_pag);
        ivTitPagDica.setImageResource(R.drawable.ficadica);


        tvTitDica = (TextView)myDialog.findViewById(R.id.tv_tit_dica);
        tvTitDica.setText(dicasList.get(pos).getTitulo());

        photo = (PhotoView)myDialog.findViewById(R.id.imagem_dica);
        photo.setImageResource(R.drawable.lampada_f);

        dvTextoDica = (DocumentView)myDialog.findViewById(R.id.texto_dica);
        dvTextoDica.setText(dicasList.get(pos).getDicaTexto());

        btnVoltar = (Button) myDialog.findViewById(R.id.btn_voltar_dica);

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();

    }

}
