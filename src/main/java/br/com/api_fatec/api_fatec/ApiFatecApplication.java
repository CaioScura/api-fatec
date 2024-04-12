package br.com.api_fatec.api_fatec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import br.com.api_fatec.api_fatec.domain.cliente.ClienteRepository;
import br.com.api_fatec.api_fatec.entities.Cliente;

@RestController
@SpringBootApplication
public class ApiFatecApplication {
	@Bean
	public CommandLineRunner run(@Autowired ClienteRepository clienteRepository) {
		return args -> {
			Cliente cliente = new Cliente();
			cliente.setNome("Danilo");
			cliente.setEmail("h2danilofatec@hotmail.com");
			cliente.setEndereco("Rua xxx, 126");
			cliente.setRazaoSocial("Danilo");
			
			clienteRepository.save(cliente);
		};
	}
	

//    @RequestMapping("/")
//    String home() {
//        return "hello world";
//    }
//
//    @RequestMapping("/numero1")
//    int home3() {
//        return 10;
//    }
//
//    @RequestMapping("/numero/{num}")
//    Integer numero2(@PathVariable Integer num) {
//        return num;
//    }
//
//    @RequestMapping("/classificar/{idade}")
//    String classificarIdade(@PathVariable int idade) {
//        if (idade < 0) {
//            return "Idade inválida";
//        } else if (idade < 12) {
//            return "Criança";
//        } else if (idade >= 12 && idade <= 18) {
//            return "Adolescente";
//        } else if (idade >= 19 && idade <= 60) {
//            return "Adulto";
//        } else {
//            return "Idoso";
//        }
//    }

    public static void main(String[] args) {
        SpringApplication.run(ApiFatecApplication.class, args);
    }
}
