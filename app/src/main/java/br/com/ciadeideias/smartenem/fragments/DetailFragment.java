package br.com.ciadeideias.smartenem.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bluejamesbond.text.DocumentView;

import br.com.ciadeideias.smartenem.R;
import br.com.ciadeideias.smartenem.parse.RSSFeed;

/**
 * Created by ClaudioSouza on 02/11/2016.
 */
public class DetailFragment extends Fragment{

    private int fPos;
    RSSFeed fFeed;
    String[] datas;
    String dataInicio, dataFinal;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fFeed = (RSSFeed)getArguments().getSerializable("feed");
        fPos = getArguments().getInt("pos");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.detail_fragment, container, false);

        //Inicializar as views
        TextView titulo = (TextView)view.findViewById(R.id.tv_titulo_evento);
        TextView dataIni = (TextView)view.findViewById(R.id.tv_data_inicio);
        TextView dataFim = (TextView)view.findViewById(R.id.tv_data_final);
        TextView local = (TextView)view.findViewById(R.id.tv_local);
        DocumentView conteudo = (DocumentView)view.findViewById(R.id.dv_conteudo);

        datas = fFeed.getItem(fPos).getData().split(" - ");
        dataInicio = datas[0].toString();
        dataFinal = datas[1].toString();

        titulo.setText(fFeed.getItem(fPos).getTitulo());
        dataIni.setText(dataInicio);
        dataFim.setText(dataFinal);
        local.setText(fFeed.getItem(fPos).getLocal());
        conteudo.setText(fFeed.getItem(fPos).getTexto());

        return view;
    }
}
