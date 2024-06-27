package br.com.api.fatec.apifatec.domain.fornecedor;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.fatec.apifatec.entities.Fornecedor;
import br.com.api.fatec.apifatec.entities.Transportadora;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
}
