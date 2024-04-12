package br.com.api_fatec.api_fatec.domain.cliente;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api_fatec.api_fatec.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}