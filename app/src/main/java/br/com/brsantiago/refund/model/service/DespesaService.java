package br.com.brsantiago.refund.model.service;

import java.util.List;

import br.com.brsantiago.refund.model.domain.Despesa;
import br.com.brsantiago.refund.model.repository.DespesaRepository;

/**
 * Created by bruno.oliveira on 26/01/2017.
 */

public class DespesaService {

    private DespesaRepository repository;

    public DespesaService() {
        this.repository = DespesaRepository.getInstance();
    }

    public void save(Despesa despesa) {
        repository.createOrUpdate(despesa);
    }

    public List<Despesa> findAll() {
        return repository.findAll();
    }
}
