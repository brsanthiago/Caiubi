package br.com.brsantiago.refund.util;

import android.util.Log;

import io.realm.DynamicRealm;
import io.realm.DynamicRealmObject;
import io.realm.FieldAttribute;
import io.realm.RealmMigration;
import io.realm.RealmObjectSchema;
import io.realm.RealmSchema;

/**
 * Created by bruno.oliveira on 26/01/2017.
 */

public class Migration implements RealmMigration {
    @Override
    public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {
        if (oldVersion == 0) {
            RealmSchema sessionSchema = realm.getSchema();

            if (oldVersion == 1) {
                RealmObjectSchema sessionObjSchema = sessionSchema.get("Despesa");
                sessionObjSchema.addField("tempo", String.class, FieldAttribute.REQUIRED)
                        .transform(obj -> obj.set("tempo", ""));
/*
                sessionObjSchema.setNullable("tempo", false);
*/
                oldVersion++;
            }
        }
        Log.i("OLD VERSION",oldVersion+"");
        Log.i("NEW VERSION",newVersion+"");
    }
}
