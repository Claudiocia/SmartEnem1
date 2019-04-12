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
import br.com.ciadeideias.smartenem.model.TemasRedacao;
import br.com.ciadeideias.smartenem.model.TituloDica;

/**
 * Created by ClaudioSouza on 08/11/2016.
 */
public class PraticaRedaAdapter extends RecyclerView.Adapter<PraticaRedaAdapter.MyViewHolderEstudo> {

    private List<TemasRedacao> mList;
    private LayoutInflater mLayoutInflater;
    private RecyclerViewOnClickListenerHack mRecyclerViewOnClickListenerHack;

    public PraticaRedaAdapter(List<TemasRedacao> l, Context c) {
        mList = l;
        mLayoutInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public MyViewHolderEstudo onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = mLayoutInflater.inflate(R.layout.item_list_temas_reda, parent, false);
        MyViewHolderEstudo mvh = new MyViewHolderEstudo(v);
        return mvh;
    }

    @Override
    public void onBindViewHolder(MyViewHolderEstudo holder, int position) {

        holder.temaRedacao.setText(mList.get(position).getTema());
        holder.anoAplic.setText("Ano de aplicação da Redação: "+mList.get(position).getAnoAplic());
    }

    @Override
    public int getItemCount () {
        return mList.size();
    }

    public void setRecyclerViewOnClickListenerHack(RecyclerViewOnClickListenerHack r){
        mRecyclerViewOnClickListenerHack = r;
    }

    public class MyViewHolderEstudo extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView temaRedacao, anoAplic;

        public MyViewHolderEstudo(View itemView) {
            super(itemView);

            temaRedacao = (TextView) itemView.findViewById(R.id.tema_redacao);
            anoAplic = (TextView) itemView.findViewById(R.id.ano_aplic);

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
