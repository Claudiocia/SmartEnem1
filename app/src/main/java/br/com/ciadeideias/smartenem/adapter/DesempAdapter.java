package br.com.ciadeideias.smartenem.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.ciadeideias.smartenem.R;
import br.com.ciadeideias.smartenem.interfaces.RecyclerViewOnClickListenerHack;
import br.com.ciadeideias.smartenem.model.NomeGrafico;

/**
 * Created by ClaudioSouza on 08/11/2016.
 */
public class DesempAdapter extends RecyclerView.Adapter<DesempAdapter.MyViewHolderGraf> {

    private List<NomeGrafico> mList;
    private LayoutInflater mLayoutInflater;
    private RecyclerViewOnClickListenerHack mRecyclerViewOnClickListenerHack;

    public DesempAdapter(List<NomeGrafico> l, Context c) {
        mList = l;
        mLayoutInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public MyViewHolderGraf onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = mLayoutInflater.inflate(R.layout.item_list_desempenho, parent, false);
        MyViewHolderGraf mvh = new MyViewHolderGraf(v);
        return mvh;
    }

    @Override
    public void onBindViewHolder(MyViewHolderGraf holder, int position) {

        holder.tvNomeGrafico.setText(mList.get(position).getNome());
    }

    @Override
    public int getItemCount () {
        return mList.size();
    }

    public void setRecyclerViewOnClickListenerHack(RecyclerViewOnClickListenerHack r){
        mRecyclerViewOnClickListenerHack = r;
    }

    public class MyViewHolderGraf extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView tvNomeGrafico;

        public MyViewHolderGraf(View itemView) {
            super(itemView);

            tvNomeGrafico = (TextView) itemView.findViewById(R.id.nome_graf);

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
