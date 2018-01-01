package br.com.ciadeideias.smartenem.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import br.com.ciadeideias.smartenem.R;

/**
 * Created by ClaudioSouza on 29/12/2017.
 */

public class PlanEstudAdapter extends BaseAdapter {

    private Context mContext;
    private String TAG = "Tico";
    private int width, height;

    public PlanEstudAdapter(Context c){
        mContext = c;
        width = (mContext.getResources().getDisplayMetrics().widthPixels / 2) - 60;
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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ImageView imageView;
        if (convertView == null){
            Log.v(TAG, "Largura da tela é = "+ width);
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(width, height));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 10, 8, 10);
        }else{
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    //referencias das imagens
    private  int[] mThumbIds = {
            R.drawable.segunda, R.drawable.terca, R.drawable.quarta,
            R.drawable.quinta, R.drawable.sexta, R.drawable.sabado,
            R.drawable.domingo, R.drawable.semana
    };

}
