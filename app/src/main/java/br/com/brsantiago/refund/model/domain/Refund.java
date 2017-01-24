package br.com.brsantiago.refund.model.domain;

import java.util.Date;

import br.com.brsantiago.refund.model.Categoria;

/**
 * Created by bruno.oliveira on 24/01/17.
 */

public class Refund extends RefundRealm {

    private Categoria categoria;
    private String descricao;
    private Double valor;
    private Date data;
    private boolean reembolsado;
    private Date dataReembolso;

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
}
