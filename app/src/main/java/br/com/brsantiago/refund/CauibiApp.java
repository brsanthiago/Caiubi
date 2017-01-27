package br.com.brsantiago.refund;

import android.app.Application;

import br.com.brsantiago.refund.util.Migration;
import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by bruno.oliveira on 25/01/2017.
 */

public class CauibiApp extends Application {

    private String gsw_db = "gsw-aponte.realm";

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder()
                .name(gsw_db)
                .schemaVersion(1)
                .migration(new Migration())
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(config);
    }
}
