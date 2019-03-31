package br.com.ciadeideias.smartenem.adapter;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.ciadeideias.smartenem.R;
import br.com.ciadeideias.smartenem.interfaces.RecyclerViewOnClickListenerHack;
import br.com.ciadeideias.smartenem.model.NomeDisciplina;

/**
 * Created by ClaudioSouza on 08/11/2016.
 */
public class EstudoAdapter extends RecyclerView.Adapter<EstudoAdapter.MyViewHolderEstudo> {

    private List<NomeDisciplina> mList;
    private LayoutInflater mLayoutInflater;
    private RecyclerViewOnClickListenerHack mRecyclerViewOnClickListenerHack;

    public EstudoAdapter(List<NomeDisciplina> l, Context c) {
        mList = l;
        mLayoutInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public MyViewHolderEstudo onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = mLayoutInflater.inflate(R.layout.item_list_estudo, parent, false);
        MyViewHolderEstudo mvh = new MyViewHolderEstudo(v);
        return mvh;
    }

    @Override
    public void onBindViewHolder(MyViewHolderEstudo holder, int position) {

        holder.tvNomeDisciplina.setText(mList.get(position).getNome());
    }

    @Override
    public int getItemCount () {
        return mList.size();
    }

    public void setRecyclerViewOnClickListenerHack(RecyclerViewOnClickListenerHack r){
        mRecyclerViewOnClickListenerHack = r;
    }

    public class MyViewHolderEstudo extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView tvNomeDisciplina;

        public MyViewHolderEstudo(View itemView) {
            super(itemView);

            tvNomeDisciplina = (TextView) itemView.findViewById(R.id.nome_disciplina);

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
