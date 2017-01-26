package br.com.brsantiago.refund.view.adapters.holders;

import android.app.Activity;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import br.com.brsantiago.refund.R;
import br.com.brsantiago.refund.util.RoundedTransformation;
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
    private View view;
    private Activity context;
    private List<String> despesas;

    public DespesaHolder(final List<String> despesas, final View view, final Activity context) {
        super(view);
        ButterKnife.bind(this, view);
        this.context = context;
        this.despesas = despesas;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void setDados(final int position) {
        tvDate.setText("25/01/2017");
        tvDescription.setText("Teste de Descrição");
        tvSymbol.setText("R$");
        tvValor.setText("17,50");
        int iconId = R.drawable.ic_local_taxi_white;
        if ((position % 2) == 0) {
            iconId = R.drawable.ic_local_hospital_white;
        }

        Glide.with(context).load(iconId)
                .thumbnail(0.5f)
                .crossFade()
                .error(R.drawable.ic_car_white)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .bitmapTransform(new RoundedTransformation(context, 35, 0))
                .into(ivIcon);

    }

    protected boolean isLollipop() {
        return (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP);
    }

}
