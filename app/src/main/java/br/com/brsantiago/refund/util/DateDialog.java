package br.com.brsantiago.refund.util;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;

import java.util.Calendar;

public class DateDialog extends DialogFragment implements
        DatePickerDialog.OnDateSetListener {

    public static String data = "";

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Obtem a data atual
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(
                getActivity(),
                (DatePickerDialog.OnDateSetListener) getActivity(),
                year,
                month,
                day);
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        data = day + "/" + month + 1 + "/" + year;
    }
}
