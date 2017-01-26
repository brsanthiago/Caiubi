package br.com.brsantiago.refund.view.adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import br.com.brsantiago.refund.R;
import br.com.brsantiago.refund.view.adapters.holders.DespesaHolder;

/**
 * Created by bruno.oliveira on 25/01/2017.
 */

public class DespesaAdapter extends RecyclerView.Adapter<DespesaHolder> {


    private List<String> despesas = new ArrayList<>();
    private Activity context;

    public DespesaAdapter(Activity context, List<String> despesas) {
        this.despesas = despesas;
        this.context = context;
    }

    @Override
    public DespesaHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_reembolso, parent, false);
        DespesaHolder viewHolder = new DespesaHolder(despesas, view, context);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(DespesaHolder holder, int position) {
        holder.setDados(position);
    }

    @Override
    public int getItemCount() {
        return despesas.size();
    }

}
