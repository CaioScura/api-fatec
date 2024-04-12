package br.com.api_fatec.api_fatec.domain.produto;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api_fatec.api_fatec.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto,Long>{

}
