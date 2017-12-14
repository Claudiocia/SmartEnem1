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
import br.com.ciadeideias.smartenem.model.Meta;

/**
 * Created by ClaudioSouza on 04/11/2016.
 */
public class MetaAdapter extends RecyclerView.Adapter<MetaAdapter.MyViewHolder> {

    private List<Meta> mList;
    private LayoutInflater mLayoutInflater;
    private RecyclerViewOnClickListenerHack mRecyclerViewOnClickListenerHack;

    public MetaAdapter(Context c, List<Meta> l){
        mList = l;
        mLayoutInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = mLayoutInflater.inflate(R.layout.item_list_meta, parent, false);
        MyViewHolder mvh = new MyViewHolder(v);

        return mvh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int position) {

        String valorMeta = ""+mList.get(position).getValorMeta();
        String valorExec = ""+mList.get(position).getValorExec();
        myViewHolder.tvNomeMeta.setText(mList.get(position).getNomeMeta());
        myViewHolder.tvValorMeta.setText(valorMeta);
        myViewHolder.tvExecutado.setText(R.string.vlrExec);
        myViewHolder.tvValorExec.setText(valorExec);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setRecyclerViewOnClickListenerHack(RecyclerViewOnClickListenerHack r){
        mRecyclerViewOnClickListenerHack = r;
    }

    public void addListItem(Meta m, int position){
        mList.add(m);
        notifyItemInserted(position);
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView tvNomeMeta;
        public TextView tvValorMeta;
        public TextView tvExecutado;
        public TextView tvValorExec;

        public MyViewHolder(View itemView){
            super(itemView);

            tvNomeMeta  = (TextView) itemView.findViewById(R.id.nome_meta);
            tvValorMeta = (TextView) itemView.findViewById(R.id.valor_meta);
            tvExecutado = (TextView) itemView.findViewById(R.id.tit_executada);
            tvValorExec = (TextView) itemView.findViewById(R.id.valor_exect);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mRecyclerViewOnClickListenerHack != null){
                mRecyclerViewOnClickListenerHack.onClickListener(v, getPosition());
            }

        }
    }
}
