package br.com.brsantiago.refund.util;

import android.support.design.widget.Snackbar;
import android.view.View;

/**
 * Created by bruno.santiago on 13/12/2016.
 */

public class SnackHelper {

    private static Snackbar snackbar;
    private static SnackHelper instance;

    public static SnackHelper make(final View view) {
        if (instance == null) {
            instance = new SnackHelper();
        }
        snackbar = Snackbar.make(view, null, Snackbar.LENGTH_SHORT);
        return instance;
    }

    public static SnackHelper type(final int color) {
        View snackbarView = snackbar.getView();
        snackbarView.setBackgroundColor(color);

        return instance;
    }

    public static SnackHelper text(final String message) {
        snackbar.setText(message);
        return instance;
    }

    public static SnackHelper duration(final int duration) {
        snackbar.setDuration(duration);
        return instance;
    }

    public static SnackHelper action(final String message) {
        snackbar.setAction(message, null);
        return instance;
    }

    public SnackHelper action(final String message, final View.OnClickListener listener) {
        snackbar.setAction(message, listener);
        return this;
    }

    public void show() {
        snackbar.show();
    }

}
