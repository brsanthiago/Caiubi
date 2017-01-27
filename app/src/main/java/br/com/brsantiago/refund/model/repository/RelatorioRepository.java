package br.com.brsantiago.refund.model.repository;

import br.com.brsantiago.refund.model.domain.Despesa;
import br.com.brsantiago.refund.model.domain.Relatorio;
import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by bruno.santiago on 26/01/2017.
 */

public class RelatorioRepository {


    private static RelatorioRepository instance = new RelatorioRepository();
    private static Realm realm = Realm.getDefaultInstance();

    public RelatorioRepository() {
        if (realm == null) {
            realm = Realm.getDefaultInstance();
        }
    }

    public static RelatorioRepository getInstance() {
        return instance;
    }

    /*public RealmResults<Relatorio> findAll() {
        return realm.where(Relatorio.class).findAll();
    }
*/
    public Despesa findStudentById(int id) {
        /*return realm.where(Despesa.class)
                .equalTo("id", id)
                .findFirst();*/
        return null;
    }

    public void createOrUpdate(Relatorio relatorio) {
       /* realm.beginTransaction();
        realm.copyToRealmOrUpdate(relatorio);
        realm.commitTransaction();*/
    }

    public void create(Relatorio relatorio) {
     /*   realm.beginTransaction();
        realm.copyToRealm(relatorio);
        realm.commitTransaction();*/
    }
}
