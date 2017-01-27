package br.com.brsantiago.refund.view.adapters.holders;

import android.app.Activity;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import br.com.brsantiago.refund.R;
import br.com.brsantiago.refund.model.domain.Despesa;
import br.com.brsantiago.refund.util.DataUtil;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by bruno.oliveira on 25/01/2017.
 */

public class DespesaHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tv_description)
    public TextView tvDescription;
    @BindView(R.id.tv_date)
    public TextView tvDate;
    @BindView(R.id.tv_simbol)
    public TextView tvSymbol;
    @BindView(R.id.tv_valor)
    public TextView tvValor;
    @BindView(R.id.iv_icon)
    public ImageView ivIcon;
    @BindView(R.id.rl_icon)
    public RelativeLayout rlIcon;
    @BindView(R.id.view_line)
    public View viewLine;
    private View view;
    private Activity context;
    private List<Despesa> despesas;

    public DespesaHolder(final List<Despesa> despesas, final View view, final Activity context) {
        super(view);
        ButterKnife.bind(this, view);
        this.context = context;
        this.despesas = despesas;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void setDados(final int position) {
        final Despesa despesa = despesas.get(position);
        tvDate.setText(DataUtil.formatData(despesa.getData()));
        tvDescription.setText(despesa.getDescricao());
        tvSymbol.setText(despesa.getMoeda());
        tvValor.setText(despesa.getValor().toString());
        int i = (position % 2);
        if (i == 0) {
            ivIcon.setImageDrawable(context.getDrawable(R.drawable.ic_local_hospital_white));
        } else {
            ivIcon.setImageDrawable(context.getDrawable(R.drawable.ic_local_taxi_white));
        }

        if (position == despesas.size() - 1) {
            viewLine.setVisibility(View.GONE);
        }

    }

    protected boolean isLollipop() {
        return (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP);
    }

}
