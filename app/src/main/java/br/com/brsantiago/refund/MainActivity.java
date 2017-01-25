package br.com.brsantiago.refund;

import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import br.com.brsantiago.refund.view.DespesaFragment;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.bottom_navigation)
    BottomNavigationView bottomNavigationView;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {

            final int itemId = item.getItemId();
            switch (itemId) {
                case R.id.action_profile:
                    //showFavoritos(R.id.favorite_item);
                    break;
                case R.id.action_despesa:
                    showConfig(R.id.action_despesa);
                    break;
                default:
                    //showNoticias(R.id.noticia_item);
                    break;
            }
            return false;
        });

        View view = bottomNavigationView.findViewById(R.id.action_despesa);
        view.performClick();

    }


    public void showConfig(final int itemId) {
        initTransaction();
        transaction.replace(R.id.frame_fragment_containers, new DespesaFragment());
        updateNavigationState(itemId);
        commitTransaction();
    }

    public void updateNavigationState(int id) {
        Menu menu = bottomNavigationView.getMenu();
        for (int i = 0, size = menu.size(); i < size; i++) {
            MenuItem item = menu.getItem(i);
            item.setChecked(item.getItemId() == id);
        }
    }

    public void initTransaction() {
        transaction = getSupportFragmentManager().beginTransaction();
    }

    public void commitTransaction() {
        transaction.commit();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_config,menu);
        return super.onCreateOptionsMenu(menu);
    }
}
