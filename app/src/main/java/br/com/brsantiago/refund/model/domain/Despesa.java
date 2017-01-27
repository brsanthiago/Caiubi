package br.com.brsantiago.refund.model.domain;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.exceptions.RealmException;

/**
 * Created by bruno.oliveira on 24/01/17.
 */
public class Despesa extends RealmObject {

    @PrimaryKey
    private int id;
    private Categoria categoria;
    private String descricao;
    private Double valor;
    private Date data;
    private String moeda;
    private boolean reembolsado;
    private Date dataReembolso;
    private String tempo;
    private int nextId;

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getMoeda() {
        return moeda;
    }

    public void setMoeda(String moeda) {
        this.moeda = moeda;
    }

    public boolean isReembolsado() {
        return reembolsado;
    }

    public void setReembolsado(boolean reembolsado) {
        this.reembolsado = reembolsado;
    }

    public Date getDataReembolso() {
        return dataReembolso;
    }

    public void setDataReembolso(Date dataReembolso) {
        this.dataReembolso = dataReembolso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTempo() {
        return tempo;
    }

    public void setTempo(String tempo) {
        this.tempo = tempo;
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
            return 1;
        }

        return nextId;
    }

}
