package br.com.brsantiago.refund.model.repository;

import br.com.brsantiago.refund.model.domain.Categoria;
import br.com.brsantiago.refund.model.domain.Despesa;
import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by bruno.santiago on 26/01/2017.
 */

public class CategoriaRepository {


    private static CategoriaRepository instance = new CategoriaRepository();
    private static Realm realm = null;

    private CategoriaRepository() {
        if (realm == null) {
            realm = Realm.getDefaultInstance();
        }
    }

    public static CategoriaRepository getInstance() {
        return instance;
    }

    public RealmResults<Categoria> findAll() {
        return realm.where(Categoria.class).findAll();
    }

    public Categoria findCategoriaById(int id) {
        return realm.where(Categoria.class)
                .equalTo("id", id)
                .findFirst();
    }

    public void createOrUpdate(Despesa despesa) {
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(despesa);
        realm.commitTransaction();
    }

    public void create(Despesa despesa) {
        realm.beginTransaction();
        realm.copyToRealm(despesa);
        realm.commitTransaction();
    }
}
