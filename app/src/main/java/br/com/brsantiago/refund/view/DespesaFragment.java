package br.com.brsantiago.refund.view;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import br.com.brsantiago.refund.R;
import br.com.brsantiago.refund.view.adapters.DespesaAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by bruno.oliveira on 24/01/17.
 */

public class DespesaFragment extends Fragment {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;

    private DespesaAdapter despesaAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_despesa, container, false);
        ButterKnife.bind(this, view);
        setHasOptionsMenu(true);

        initDespesas();

        return view;
    }

    protected void initDespesas(){

        List<String> despesas = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            despesas.add(""+i+"");
        }

        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        despesaAdapter = new DespesaAdapter(getActivity(),despesas);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(despesaAdapter);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_config,menu);
    }
}
