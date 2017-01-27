package br.com.brsantiago.refund.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

import br.com.brsantiago.refund.R;
import br.com.brsantiago.refund.model.domain.Despesa;
import br.com.brsantiago.refund.model.service.DespesaService;
import br.com.brsantiago.refund.view.adapters.DespesaAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by bruno.oliveira on 24/01/17.
 */

public class DespesaFragment extends Fragment implements View.OnClickListener {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;
    @BindView(R.id.fab)
    FloatingActionButton fabMore;
    @BindView(R.id.sync)
    FloatingActionButton fabSettings;
    @BindView(R.id.share)
    FloatingActionButton fabShare;
    @BindView(R.id.restaurant)
    FloatingActionButton fabRestaurant;
    @BindView(R.id.gasoline)
    FloatingActionButton fabGasoline;

    Animation open, close, rotateclock, rotateanticlock;

    boolean isopen = false;
    private DespesaService service;

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
        initialize();
        setHasOptionsMenu(true);
        service = new DespesaService();
        initDespesas();

        return view;
    }

    protected void initialize() {
        // loading the animation from xml file
        open = AnimationUtils.loadAnimation(getActivity(), R.anim.fab_open);
        close = AnimationUtils.loadAnimation(getActivity(), R.anim.fab_close);
        rotateclock = AnimationUtils.loadAnimation(getActivity(), R.anim.rotate_forward);
        rotateanticlock = AnimationUtils.loadAnimation(getActivity(), R.anim.rotate_backward);

        // setting up the onClickListener() method
        fabMore.setOnClickListener(this);
        fabSettings.setOnClickListener(this);
        fabShare.setOnClickListener(this);
    }

    protected void initDespesas() {

        for (int i = 1; i < 11 ; i++){

            create(i);
        }

        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        despesaAdapter = new DespesaAdapter(getActivity(), service.findAll());
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(despesaAdapter);
    }

    protected void create(final int id) {
        Despesa despesa = new Despesa();
        Calendar calendar = Calendar.getInstance();
        Date date = new Date();
        if (id == 2){
            calendar.set(Calendar.DAY_OF_MONTH,22);
            date = calendar.getTime();
        }else if (id == 4){
            calendar.set(Calendar.DAY_OF_MONTH,15);
            calendar.set(Calendar.MONTH,11);
            calendar.set(Calendar.YEAR,2016);
            date = calendar.getTime();
        }else if (id == 3){
            calendar.set(Calendar.DAY_OF_MONTH,25);
            date = calendar.getTime();
        }
        despesa.setData(date);
        despesa.setDescricao("Gastos com o Realm");
        despesa.setMoeda("R$");
        despesa.setValor(19.90);
        despesa.setId(id);
        despesa.setTempo("Hoje");
        service.save(despesa);
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_config, menu);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sync:
                Toast.makeText(getActivity(), "You clicked settings", Toast.LENGTH_LONG).show();
                break;
            case R.id.share:
                Toast.makeText(getActivity(), "You clicked share", Toast.LENGTH_LONG).show();
                break;
        }
        animatedFab();
    }

    protected void animatedFab(){
        if (isopen) {
            // more button is already open
            fabGasoline.startAnimation(close);
            fabRestaurant.startAnimation(close);
            fabSettings.startAnimation(close);
            fabShare.startAnimation(close);
            fabMore.startAnimation(rotateanticlock);
            fabShare.setClickable(false);
            fabSettings.setClickable(false);
            fabGasoline.setClickable(false);
            fabRestaurant.setClickable(false);
            isopen = false;
        } else {
            // more button is already close
            fabGasoline.startAnimation(open);
            fabRestaurant.startAnimation(open);
            fabSettings.startAnimation(open);
            fabShare.startAnimation(open);
            fabMore.startAnimation(rotateclock);
            fabShare.setClickable(true);
            fabSettings.setClickable(true);
            fabRestaurant.setClickable(true);
            fabGasoline.setClickable(true);
            isopen = true;
        }
    }
}
