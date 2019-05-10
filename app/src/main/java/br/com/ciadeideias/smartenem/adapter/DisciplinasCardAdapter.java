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

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import br.com.ciadeideias.smartenem.R;
import br.com.ciadeideias.smartenem.imagem.ImageHelper;
import br.com.ciadeideias.smartenem.interfaces.RecyclerViewOnClickListenerHack;
import br.com.ciadeideias.smartenem.model.NomeDisciplina;

public class DisciplinasCardAdapter extends RecyclerView.Adapter<DisciplinasCardAdapter.MyViewHolder> {
    private Context mContext;
    private List<NomeDisciplina> mList;
    private LayoutInflater mLayoutInflater;
    private RecyclerViewOnClickListenerHack mRecyclerViewOnClickListenerHack;
    private float scale;
    private int width;
    private int height;

    public DisciplinasCardAdapter(Context c, List<NomeDisciplina> l){
        mContext = c;
        mList = l;
        mLayoutInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        scale = mContext.getResources().getDisplayMetrics().density;
        width = mContext.getResources().getDisplayMetrics().widthPixels - (int)(14 * scale + 0.5f);
        height = (width / 16) * 14;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View v = mLayoutInflater.inflate(R.layout.item_card_disciplinas, viewGroup, false);
        MyViewHolder mvh = new MyViewHolder(v);
        return mvh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myholder, int position) {

        int img = Integer.parseInt(mList.get(position).getImg());
        myholder.tvTituloCard.setText(mList.get(position).getNome());
        int txt = Integer.parseInt(mList.get(position).getDescri());
        myholder.tvTextCard.setText(txt);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            myholder.ivCard.setImageResource(img);
        }
        else{
            Bitmap bitmap = BitmapFactory.decodeResource(mContext.getResources(), img);
            bitmap = Bitmap.createScaledBitmap(bitmap, width, height, false);

            bitmap = ImageHelper.getRoundedCornerBitmap(mContext, bitmap, 10, width, height, false,false, true, true);
            myholder.ivCard.setImageBitmap(bitmap);
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setRecyclerViewOnClickListenerHack(RecyclerViewOnClickListenerHack r){
        mRecyclerViewOnClickListenerHack = r;
    }

    public void addListItem(NomeDisciplina nDisci, int position){
        mList.add(nDisci);
        notifyItemInserted(position);
    }

    public void removeListItem(int position){
        mList.remove(position);
        notifyItemRemoved(position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public ImageView ivCard;
        public TextView  tvTituloCard;
        public TextView  tvTextCard;

        public MyViewHolder(View itemView){
            super(itemView);
            ivCard = (ImageView) itemView.findViewById(R.id.iv_card_disciplinas);
            tvTituloCard = (TextView) itemView.findViewById(R.id.titulo_card_disciplinas);
            tvTextCard = (TextView) itemView.findViewById(R.id.text_card_disciplinas);

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
