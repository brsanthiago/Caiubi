package br.com.brsantiago.refund.model.domain;

import android.util.Log;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.exceptions.RealmException;

/**
 * Created by bruno.oliveira on 24/01/17.
 */

public class Categoria extends RealmObject {

    @PrimaryKey
    private int id;
    private String nome;
    private int icon;
    private int nextId;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int idIncrease() {
        try {
            Realm realm = Realm.getDefaultInstance();
            realm.executeTransaction(realm1 -> {
                Number current = realm1.where(Categoria.class).max("id");
                if (current != null) {
                    nextId = current.intValue() + 1;
                }

            });
        } catch (RealmException e) {
            Log.e(getClass().getName(), e.getLocalizedMessage());
            return nextId;
        }

        return nextId;
    }
}
