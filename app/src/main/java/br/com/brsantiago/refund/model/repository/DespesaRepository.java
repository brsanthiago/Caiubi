package br.com.brsantiago.refund.model.repository;

import br.com.brsantiago.refund.model.domain.Despesa;
import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by bruno.santiago on 26/01/2017.
 */

public class DespesaRepository {


    private static DespesaRepository instance = new DespesaRepository();
    private static Realm realm = Realm.getDefaultInstance();

    public DespesaRepository() {
        if (realm == null) {
            realm = Realm.getDefaultInstance();
        }
    }

    public static DespesaRepository getInstance() {
        return instance;
    }

    public RealmResults<Despesa> findAll() {
        return realm.where(Despesa.class).findAll();
    }

    public Despesa findStudentById(int id) {
        return realm.where(Despesa.class)
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

    public RealmResults<Despesa> findDespesaFromCategoriaByID(int id) {
        return realm.where(Despesa.class)
                .equalTo("categoriaId", id).findAll();
    }

}
