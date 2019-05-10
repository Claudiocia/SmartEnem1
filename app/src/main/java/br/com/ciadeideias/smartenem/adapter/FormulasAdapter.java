package br.com.ciadeideias.smartenem.adapter;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;
import br.com.ciadeideias.smartenem.R;
import br.com.ciadeideias.smartenem.imagem.ImageHelper;
import br.com.ciadeideias.smartenem.interfaces.RecyclerViewOnClickListenerHack;
import br.com.ciadeideias.smartenem.model.NomeDisciplina;
/**
 * Created by ClaudioSouza on 08/11/2016.
 */
public class FormulasAdapter extends RecyclerView.Adapter<FormulasAdapter.MyViewHolder> {

    private Context mContext;
    private List<NomeDisciplina> mList;
    private LayoutInflater mLayoutInflater;
    private RecyclerViewOnClickListenerHack mRecyclerViewOnClickListenerHack;
    private float scale;
    private int width;
    private int height;

    public FormulasAdapter(List<NomeDisciplina> l, Context c) {
        mContext = c;
        mList = l;
        mLayoutInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        scale = mContext.getResources().getDisplayMetrics().density;
        width = mContext.getResources().getDisplayMetrics().widthPixels - (int) (14 * scale + 0.5f);
        height = (width / 16) * 9;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = mLayoutInflater.inflate(R.layout.item_card_discipli_formulas, parent, false);
        MyViewHolder mvh = new MyViewHolder(v);
        return mvh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {


        holder.tituloDiscipliFormu.setText(mList.get(position).getNome());
        int txt = Integer.parseInt(mList.get(position).getDescri());
        holder.descriDiscipliFormu.setText(txt);
        int imd = Integer.parseInt(mList.get(position).getImg());

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){

            holder.ivDiscipliFormu.setImageResource(imd);
        }else {
            Bitmap bitmap = BitmapFactory.decodeResource(mContext.getResources(), imd);
            bitmap = Bitmap.createScaledBitmap(bitmap, width, height, false);

            bitmap = ImageHelper.getRoundedCornerBitmap(mContext, bitmap, 4, width,
                    height, false, false, true, true);
            holder.ivDiscipliFormu.setImageBitmap(bitmap);
        }
    }

    @Override
    public int getItemCount () {
        return mList.size();
    }

    public void setRecyclerViewOnClickListenerHack(RecyclerViewOnClickListenerHack r){
        mRecyclerViewOnClickListenerHack = r;
    }

    public void addListItem(NomeDisciplina nDisci, int position){
        mList.add((nDisci));
        notifyItemInserted(position);
    }

    public void removeListItem(int position){
        mList.remove(position);
        notifyItemRemoved(position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView tituloDiscipliFormu, descriDiscipliFormu;
        public ImageView ivDiscipliFormu;

        public MyViewHolder(View itemView) {
            super(itemView);

            ivDiscipliFormu = (ImageView) itemView.findViewById(R.id.iv_card_discipli_formulas);
            tituloDiscipliFormu = (TextView) itemView.findViewById(R.id.titulo_discipli_formula);
            descriDiscipliFormu = (TextView) itemView.findViewById(R.id.descri_discipli_formula);

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
