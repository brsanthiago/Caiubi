package br.com.brsantiago.refund.model.domain;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by bruno.oliveira on 26/01/2017.
 */

public class Relatorio extends RealmObject {
    @PrimaryKey
    private int id;
    private String nome;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
