package br.com.api.fatec.apifatec.domain.pedidovenda;

import br.com.api.fatec.apifatec.entities.PedidoVenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface PedidoVendaRepository extends JpaRepository<PedidoVenda, Long>, JpaSpecificationExecutor<PedidoVenda> {

    @Query("SELECT p FROM PedidoVenda p JOIN p.itens i WHERE i.produto.id = :produtoId")
    List<PedidoVenda> findByProdutoId(@Param("produtoId") Long produtoId);
}
