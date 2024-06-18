package br.com.api.fatec.apifatec;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.api.fatec.apifatec.domain.pedidovenda.PedidoVendaService;
import br.com.api.fatec.apifatec.entities.PedidoVenda;
import br.com.api.fatec.apifatec.entities.PedidoVendaItem;
import br.com.api.fatec.apifatec.shared.enums.PedidoVendaStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.api.fatec.apifatec.domain.cliente.ClienteRepository;
import br.com.api.fatec.apifatec.domain.pedidovenda.PedidoVendaRepository;
import br.com.api.fatec.apifatec.domain.produto.ProdutoRepository;
import br.com.api.fatec.apifatec.entities.Cliente;

import br.com.api.fatec.apifatec.entities.Produto;

@SpringBootApplication
public class ApiFatecApplication {
	@Bean
	public CommandLineRunner run(@Autowired ClienteRepository clienteRepository,
								 @Autowired ProdutoRepository produtoRepository,
								 @Autowired PedidoVendaRepository pedidoVendaRepository
								 ) {
		return args -> {
			//cliente1
			Cliente cliente = new Cliente();
			cliente.setNome("Danilo");
			cliente.setEmail("h2danilofatec@hotmail.com");
			cliente.setEndereco("Rua xxx, 126");
			cliente.setRazaoSocial("Danilo");
			clienteRepository.save(cliente);
			
			//cliente 2
			Cliente cliente2 = new Cliente();
			cliente2.setNome("Arthur");
			cliente2.setEmail("h2danilosfatec@hotmail.com");
			cliente2.setEndereco("Rua xxx, 126");
			cliente2.setRazaoSocial("Arthur");
			clienteRepository.save(cliente2);

			//cliente 3
			Cliente cliente3 = new Cliente();
			cliente3.setNome("Caio");
			cliente3.setEmail("caioscura@hotmail.com");
			cliente3.setEndereco("Rua xxx, 123456");
			cliente3.setRazaoSocial("Caio");
			clienteRepository.save(cliente3);

			//cliente 4
			Cliente cliente4 = new Cliente();
			cliente4.setNome("Matheus");
			cliente4.setEmail("matheus@hotmail.com");
			cliente4.setEndereco("Rua xxx, 696969");
			cliente4.setRazaoSocial("Matheus");
			clienteRepository.save(cliente4);

			//cliente 5
			Cliente cliente5 = new Cliente();
			cliente5.setNome("Pedro");
			cliente5.setEmail("pedro@hotmail.com");
			cliente5.setEndereco("Rua xxx, 434343");
			cliente5.setRazaoSocial("Pedro");
			clienteRepository.save(cliente5);
			

			//======= PRODUTOS =======
			Produto p1 = new Produto();
			p1.setDescricao("teste");
			p1.setPreco(new BigDecimal(100));
			p1.setAtivo("SIM");
			p1.setQuantidadeEstoque(null);
			produtoRepository.save(p1);

			//produto 2
			Produto p2 = new Produto();
			p2.setDescricao("produto2");
			p2.setPreco(new BigDecimal(150));
			p2.setAtivo("SIM");
			p2.setQuantidadeEstoque(null);
			produtoRepository.save(p2);

			//produto 3
			Produto p3 = new Produto();
			p3.setDescricao("produto3");
			p3.setPreco(new BigDecimal(250));
			p3.setAtivo("SIM");
			p3.setQuantidadeEstoque(null);
			produtoRepository.save(p3);

			//produto 4
			Produto p4 = new Produto();
			p4.setDescricao("produto4");
			p4.setPreco(new BigDecimal(350));
			p4.setAtivo("SIM");
			p4.setQuantidadeEstoque(null);
			produtoRepository.save(p4);

			//produto 5
			Produto p5 = new Produto();
			p5.setDescricao("produto5");
			p5.setPreco(new BigDecimal(450));
			p5.setAtivo("SIM");
			p5.setQuantidadeEstoque(null);
			produtoRepository.save(p5);


			//======= PEDIDO VENDA =======
			//PEDIDO 1
			PedidoVenda ped1 = new PedidoVenda();
			ped1.setCliente(cliente2);
			ped1.setStatus(PedidoVendaStatusEnum.CONCLUIDO);
			LocalDate data = LocalDate.now();
			ped1.setEmissao(data);


			//ITEM 1
			//Instanciando PedidoVendaItem na variavel item1
			PedidoVendaItem item1 = new PedidoVendaItem();

			//Inserindo valores nas propriedades de PedidoVendaItem
			item1.setProduto(p1);
			item1.setQuantidade(10);
			item1.setValorUnitario(new BigDecimal(10));
			item1.setValorTotal(item1.getValorUnitario().multiply(BigDecimal.valueOf(item1.getQuantidade())));

			//Adicionando Item no Pedido Venda
			ped1.addItem(item1);


			//ITEM 2
			//Instanciando PedidoVendaItem na variavel item2
			PedidoVendaItem item2 = new PedidoVendaItem();

			//Inserindo valores nas propriedades de PedidoVendaItem
			item2.setProduto(p1);
			item2.setQuantidade(10);
			item2.setValorUnitario(new BigDecimal(10));
			item2.setValorTotal(item2.getValorUnitario().multiply(BigDecimal.valueOf(item2.getQuantidade())));

			//Adicionando Item no Pedido Venda
			ped1.addItem(item2);

			//Calculando total dos itens do Pedido Venda
			ped1.setTotal();

			//Salvando Pedido Venda
			pedidoVendaRepository.save(ped1);



			//PEDIDO 2
			PedidoVenda ped2 = new PedidoVenda();
			ped2.setCliente(cliente3);
			ped2.setStatus(PedidoVendaStatusEnum.CONCLUIDO);
			LocalDate data2 = LocalDate.now();
			ped2.setEmissao(data2);


			//ITEM 3
			//Instanciando PedidoVendaItem na variavel item1
			PedidoVendaItem item3 = new PedidoVendaItem();

			//Inserindo valores nas propriedades de PedidoVendaItem
			item3.setProduto(p2);
			item3.setQuantidade(10);
			item3.setValorUnitario(new BigDecimal(10));
			item3.setValorTotal(item3.getValorUnitario().multiply(BigDecimal.valueOf(item3.getQuantidade())));

			//Adicionando Item no Pedido Venda
			ped2.addItem(item3);

			
			//ITEM 4
			//Instanciando PedidoVendaItem na variavel item2
			PedidoVendaItem item4 = new PedidoVendaItem();

			//Inserindo valores nas propriedades de PedidoVendaItem
			item4.setProduto(p2);
			item4.setQuantidade(10);
			item4.setValorUnitario(new BigDecimal(10));
			item4.setValorTotal(item4.getValorUnitario().multiply(BigDecimal.valueOf(item4.getQuantidade())));

			//Adicionando Item no Pedido Venda
			ped2.addItem(item4);

			//Calculando total dos itens do Pedido Venda
			ped2.setTotal();

			//Salvando Pedido Venda
			pedidoVendaRepository.save(ped2);



			//PEDIDO 3
			PedidoVenda ped3 = new PedidoVenda();
			ped3.setCliente(cliente4);
			ped3.setStatus(PedidoVendaStatusEnum.CONCLUIDO);
			LocalDate data3 = LocalDate.now();
			ped3.setEmissao(data3);


			//ITEM 5
			//Instanciando PedidoVendaItem na variavel item1
			PedidoVendaItem item5 = new PedidoVendaItem();

			//Inserindo valores nas propriedades de PedidoVendaItem
			item5.setProduto(p4);
			item5.setQuantidade(10);
			item5.setValorUnitario(new BigDecimal(10));
			item5.setValorTotal(item5.getValorUnitario().multiply(BigDecimal.valueOf(item5.getQuantidade())));

			//Adicionando Item no Pedido Venda
			ped3.addItem(item5);

			
			//ITEM 6
			//Instanciando PedidoVendaItem na variavel item2
			PedidoVendaItem item6 = new PedidoVendaItem();

			//Inserindo valores nas propriedades de PedidoVendaItem
			item6.setProduto(p5);
			item6.setQuantidade(10);
			item6.setValorUnitario(new BigDecimal(10));
			item6.setValorTotal(item6.getValorUnitario().multiply(BigDecimal.valueOf(item6.getQuantidade())));

			//Adicionando Item no Pedido Venda
			ped3.addItem(item6);

			//Calculando total dos itens do Pedido Venda
			ped3.setTotal();

			//Salvando Pedido Venda
			pedidoVendaRepository.save(ped3);





			//PEDIDO 4
			PedidoVenda ped4 = new PedidoVenda();
			ped4.setCliente(cliente4);
			ped4.setStatus(PedidoVendaStatusEnum.CONCLUIDO);
			LocalDate data4 = LocalDate.now();
			ped4.setEmissao(data4);


			//ITEM 7
			//Instanciando PedidoVendaItem na variavel item1
			PedidoVendaItem item7 = new PedidoVendaItem();

			//Inserindo valores nas propriedades de PedidoVendaItem
			item7.setProduto(p3);
			item7.setQuantidade(10);
			item7.setValorUnitario(new BigDecimal(10));
			item7.setValorTotal(item7.getValorUnitario().multiply(BigDecimal.valueOf(item7.getQuantidade())));

			//Adicionando Item no Pedido Venda
			ped4.addItem(item7);

			
			//ITEM 6
			//Instanciando PedidoVendaItem na variavel item2
			PedidoVendaItem item8 = new PedidoVendaItem();

			//Inserindo valores nas propriedades de PedidoVendaItem
			item8.setProduto(p4);
			item8.setQuantidade(10);
			item8.setValorUnitario(new BigDecimal(10));
			item8.setValorTotal(item8.getValorUnitario().multiply(BigDecimal.valueOf(item8.getQuantidade())));

			//Adicionando Item no Pedido Venda
			ped4.addItem(item8);

			//Calculando total dos itens do Pedido Venda
			ped4.setTotal();

			//Salvando Pedido Venda
			pedidoVendaRepository.save(ped4);





			//PEDIDO 5
			PedidoVenda ped5 = new PedidoVenda();
			ped5.setCliente(cliente5);
			ped5.setStatus(PedidoVendaStatusEnum.CONCLUIDO);
			LocalDate data5 = LocalDate.now();
			ped5.setEmissao(data5);


			//ITEM 7
			//Instanciando PedidoVendaItem na variavel item1
			PedidoVendaItem item9 = new PedidoVendaItem();

			//Inserindo valores nas propriedades de PedidoVendaItem
			item9.setProduto(p5);
			item9.setQuantidade(10);
			item9.setValorUnitario(new BigDecimal(10));
			item9.setValorTotal(item9.getValorUnitario().multiply(BigDecimal.valueOf(item9.getQuantidade())));

			//Adicionando Item no Pedido Venda
			ped4.addItem(item9);

			
			//ITEM 6
			//Instanciando PedidoVendaItem na variavel item2
			PedidoVendaItem item10 = new PedidoVendaItem();

			//Inserindo valores nas propriedades de PedidoVendaItem
			item10.setProduto(p4);
			item10.setQuantidade(10);
			item10.setValorUnitario(new BigDecimal(10));
			item10.setValorTotal(item10.getValorUnitario().multiply(BigDecimal.valueOf(item10.getQuantidade())));

			//Adicionando Item no Pedido Venda
			ped5.addItem(item10);

			//Calculando total dos itens do Pedido Venda
			ped5.setTotal();

			//Salvando Pedido Venda
			pedidoVendaRepository.save(ped5);
			
		};
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ApiFatecApplication.class, args);
	}
}
