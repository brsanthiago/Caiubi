package br.com.brsantiago.refund.model.service;

import java.util.List;

import br.com.brsantiago.refund.model.domain.Relatorio;
import br.com.brsantiago.refund.model.repository.DespesaRepository;
import br.com.brsantiago.refund.model.repository.RelatorioRepository;

/**
 * Created by bruno.oliveira on 26/01/2017.
 */

public class RelatorioService {

    private RelatorioRepository repository;

    public RelatorioService() {
        this.repository = RelatorioRepository.getInstance();
    }

    public void save(Relatorio relatorio) {
        repository.createOrUpdate(relatorio);
    }

    /*public List<Relatorio> findAll() {
        return repository.findAll();
    }*/
}
