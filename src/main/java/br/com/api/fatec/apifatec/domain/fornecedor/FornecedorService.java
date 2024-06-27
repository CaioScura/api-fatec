package br.com.api.fatec.apifatec.domain.fornecedor;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.fatec.apifatec.entities.Transportadora;
import br.com.api.fatec.apifatec.domain.transportadora.TransportadoraRepository;


import br.com.api.fatec.apifatec.entities.Fornecedor;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public List<Fornecedor> listarFornecedores() {
        return fornecedorRepository.findAll();
    }

    public Fornecedor encontrarFornecedorPorId(Long id) {
        return fornecedorRepository.findById(id).orElse(null);
    }

    public Fornecedor salvarFornecedor(Fornecedor fornecedor) {
        return fornecedorRepository.save(fornecedor);
    }

    public void deletarFornecedor(Long id) {
        Fornecedor fornecedor = encontrarFornecedorPorId(id);

        if (fornecedor == null)
            throw new IllegalArgumentException("Fornecedor não existe");

        fornecedorRepository.deleteById(id);
    }

    public Fornecedor atualizarFornecedor(Long id, Fornecedor fornecedor) {
        Fornecedor fornecedorCadastrado = encontrarFornecedorPorId(id);

        if (fornecedorCadastrado == null) {
            return null;
        } else {
            fornecedorCadastrado.setNome(fornecedor.getNome());
            fornecedorCadastrado.setContato(fornecedor.getContato());
            return fornecedorRepository.save(fornecedorCadastrado);
        }
    }
}
