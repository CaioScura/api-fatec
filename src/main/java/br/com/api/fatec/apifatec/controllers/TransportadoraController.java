package br.com.api.fatec.apifatec.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.api.fatec.apifatec.domain.transportadora.TransportadoraRepository;
import br.com.api.fatec.apifatec.entities.Transportadora;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transportadoras")
public class TransportadoraController {

    @Autowired
    private TransportadoraRepository transportadoraRepository;

    // Criação de Transportadora
    @PostMapping
    public ResponseEntity<Transportadora> criarTransportadora(@RequestBody Transportadora transportadora) {
        Transportadora novaTransportadora = transportadoraRepository.save(transportadora);
        return new ResponseEntity<>(novaTransportadora, HttpStatus.CREATED);
    }

    // Leitura de todas as Transportadoras
    @GetMapping
    public List<Transportadora> listarTransportadoras() {
        return transportadoraRepository.findAll();
    }

    // Leitura de Transportadora por ID
    @GetMapping("/{id}")
    public ResponseEntity<Transportadora> obterTransportadoraPorId(@PathVariable Long id) {
        Optional<Transportadora> transportadora = transportadoraRepository.findById(id);
        if (transportadora.isPresent()) {
            return new ResponseEntity<>(transportadora.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Atualização de Transportadora
    @PutMapping("/{id}")
    public ResponseEntity<Transportadora> atualizarTransportadora(@PathVariable Long id, @RequestBody Transportadora dadosAtualizados) {
        Optional<Transportadora> transportadoraExistente = transportadoraRepository.findById(id);
        if (transportadoraExistente.isPresent()) {
            Transportadora transportadora = transportadoraExistente.get();
            transportadora.setNome(dadosAtualizados.getNome());
            transportadora.setTelefone(dadosAtualizados.getTelefone());
            transportadoraRepository.save(transportadora);
            return new ResponseEntity<>(transportadora, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Deleção de Transportadora
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTransportadora(@PathVariable Long id) {
        if (transportadoraRepository.existsById(id)) {
            transportadoraRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

