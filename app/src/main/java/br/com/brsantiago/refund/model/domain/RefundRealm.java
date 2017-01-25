package br.com.brsantiago.refund.model.domain;

import android.util.Log;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.exceptions.RealmException;

/**
 * Created by bruno.santiago on 24/01/17.
 */

public abstract class RefundRealm /*extends RealmObject*/{

/*
    private int id;
    private int nextId;

    public int idIncrease(){

        try{
            Realm realm = Realm.getDefaultInstance();
            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    Number current = realm.where(RefundRealm.class).max(String.valueOf(id));
                    if (current != null){
                        nextId = current.intValue() + 1;
                    }

                }
            });
        }catch (RealmException e){
            Log.e(getClass().getName(),e.getLocalizedMessage());
            return nextId;
        }

        return nextId;
    }

*/
}
