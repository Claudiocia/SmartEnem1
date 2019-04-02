package br.com.ciadeideias.smartenem.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;
import br.com.ciadeideias.smartenem.R;
import br.com.ciadeideias.smartenem.interfaces.RecyclerViewOnClickListenerHack;
import br.com.ciadeideias.smartenem.model.NomeDisciplina;
import br.com.ciadeideias.smartenem.model.TituloDica;

/**
 * Created by ClaudioSouza on 08/11/2016.
 */
public class DicasAdapter extends RecyclerView.Adapter<DicasAdapter.MyViewHolderEstudo> {

    private List<TituloDica> mList;
    private LayoutInflater mLayoutInflater;
    private RecyclerViewOnClickListenerHack mRecyclerViewOnClickListenerHack;

    public DicasAdapter(List<TituloDica> l, Context c) {
        mList = l;
        mLayoutInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public MyViewHolderEstudo onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = mLayoutInflater.inflate(R.layout.item_list_dicas, parent, false);
        MyViewHolderEstudo mvh = new MyViewHolderEstudo(v);
        return mvh;
    }

    @Override
    public void onBindViewHolder(MyViewHolderEstudo holder, int position) {

        holder.ivListaDica.setImageResource(mList.get(position).getImg());
        holder.tituloDica.setText(mList.get(position).getTitulo());
        holder.descriDica.setText(mList.get(position).getDescr());
    }

    @Override
    public int getItemCount () {
        return mList.size();
    }

    public void setRecyclerViewOnClickListenerHack(RecyclerViewOnClickListenerHack r){
        mRecyclerViewOnClickListenerHack = r;
    }

    public class MyViewHolderEstudo extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView tituloDica, descriDica;
        public ImageView ivListaDica;

        public MyViewHolderEstudo(View itemView) {
            super(itemView);

            ivListaDica = (ImageView) itemView.findViewById(R.id.iv_list_dicas);
            tituloDica = (TextView) itemView.findViewById(R.id.titulo_lista_dica);
            descriDica = (TextView) itemView.findViewById(R.id.descri_lista_dica);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mRecyclerViewOnClickListenerHack != null) {
                mRecyclerViewOnClickListenerHack.onClickListener(v, getPosition());
            }
        }
    }
}
