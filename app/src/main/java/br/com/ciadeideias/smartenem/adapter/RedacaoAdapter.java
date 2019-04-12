package br.com.ciadeideias.smartenem.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import br.com.ciadeideias.smartenem.R;

public class RedacaoAdapter extends BaseAdapter {
    private Context mContext;
    private String TAG = "claudio";
    private int width;
    private int height;

    public RedacaoAdapter(Context c){
        mContext = c;
        width = (mContext.getResources().getDisplayMetrics().widthPixels /2 )- 30;
        height = width;
    }

    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            Log.v(TAG, "Largura da tela é =" + width);
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(width, height));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 10, 8, 10);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    // references to our images
    private Integer[] mThumbIds = {
            R.drawable.tec_reda1, R.drawable.tipos_textos1, R.drawable.reda_enem1, R.drawable.coerencia_textual1, R.drawable.coesao_textual1,
            R.drawable.interpretacao_textos1, R.drawable.aboa_redacao1, R.drawable.dicas_redacao1,
            R.drawable.erros_comuns1, R.drawable.pratica1
    };
}
