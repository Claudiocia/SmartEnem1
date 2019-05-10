package br.com.ciadeideias.smartenem.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import br.com.ciadeideias.smartenem.DisciplinasCardActivity;
import br.com.ciadeideias.smartenem.R;
import br.com.ciadeideias.smartenem.adapter.DisciplinasCardAdapter;
import br.com.ciadeideias.smartenem.interfaces.RecyclerViewOnClickListenerHack;
import br.com.ciadeideias.smartenem.model.NomeDisciplina;

public class DisciplinasCardFragment extends Fragment implements RecyclerViewOnClickListenerHack {

    private RecyclerView mRecyclerView;
    private List<NomeDisciplina> mList;
    private int idDiscipli;

    @SuppressLint("WrongConstant")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_card_disciplinas, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_card_disciplinas);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                LinearLayoutManager llm = (LinearLayoutManager) mRecyclerView.getLayoutManager();
                DisciplinasCardAdapter adapter = (DisciplinasCardAdapter) mRecyclerView.getAdapter();

                if (mList.size() == llm.findLastCompletelyVisibleItemPosition() + 1){
                    List<NomeDisciplina> listAux = ((DisciplinasCardActivity) getActivity()).getListaDisciplinaCard(0);

                    for (int i = 0; i < listAux.size(); i++) {
                        adapter.addListItem(listAux.get(i), mList.size());
                    }
                }
            }
        });

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(llm);

        mList = ((DisciplinasCardActivity) getActivity()).getListaDisciplinaCard(3);
        DisciplinasCardAdapter adapter = new DisciplinasCardAdapter(getActivity(), mList);
        adapter.setRecyclerViewOnClickListenerHack(this);
        mRecyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onClickListener(View view, int position) {

        idDiscipli = mList.get(position).getIdDisciplina();
        Toast.makeText(getActivity(), "Position: "+position+ " O id dela é "+ idDiscipli, Toast.LENGTH_SHORT).show();
    }
}
