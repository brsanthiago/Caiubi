package br.com.brsantiago.refund.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtil {
    private static final SimpleDateFormat defaultFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat defaultBr = new SimpleDateFormat("dd/MM/yyyy");


    private static String timeline(final Date data) {
        double seconds = Math.abs((double) (data.getTime()));
        int days = (int) Math.floor(seconds / 86400);
        Date one = new Date();
        long difference = (one.getTime() - data.getTime()) / 86400000;
        int dias = (int) Math.abs(difference);
        switch (dias) {
            case 0:
                return "Hoje";
            case 1:
                return "Ontem";
            default:
                if (dias > 31) {
                    return defaultBr.format(seconds);
                } else {
                    return dias + " dias atrás";
                }
        }

    }

    public static String formatData(final Date date) {
        return timeline(date);
    }

}
