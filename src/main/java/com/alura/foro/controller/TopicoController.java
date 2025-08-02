package com.alura.foro.controller;

import com.alura.foro.topico.*;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    // para indicar que va a haber modificaciones
    @Transactional
    @PostMapping
    public ResponseEntity agregar(@RequestBody @Valid DatosAgregarTopico datos, UriComponentsBuilder uriComponentsBuilder){
        var topico = new Topico(datos);
        topicoRepository.save(topico);
        var uri = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        // devuelve un 201 con su DTO y su uri
        return ResponseEntity.created(uri).body(new DatosDetalleTopico(topico));
        // falta ver que no agregue duplicados
    }

    @GetMapping
    public ResponseEntity<List<DatosDetalleTopico>> listarTopico(){
       List<DatosDetalleTopico> lista = topicoRepository.findAll().stream().map(DatosDetalleTopico::new).toList();
       // devuelve un 200
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosDetalleTopico> detalleTopico(@PathVariable Long id){
        if(id!=null){
            Optional<Topico> unTopico = topicoRepository.findById(id);
            if(unTopico.isPresent()){
                Topico topico = unTopico.get();
                DatosDetalleTopico detalle = new DatosDetalleTopico(topico);
                // devuelve un 200 con su DTO( siempre se devuelve un DTO)
                return ResponseEntity.ok(detalle);
            }else {
                // retorna un 404
                throw new EntityNotFoundException();
            }
        }else {
            // retorna un 404
            throw new EntityNotFoundException();
        }

    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity actualizarTopico(@PathVariable Long id,@RequestBody @Valid DatosActualizarTopico datos){

        if(id!=null){
            Optional<Topico> unTopico = topicoRepository.findById(id);
            if(unTopico.isPresent()){
                Topico topico = unTopico.get();
                topico.actualizar(datos);
                // devuelve un 200 con su DTO actualizado ( siempre se devuelve un DTO)
                return ResponseEntity.ok(new DatosDetalleTopico(topico));
            }else {
                // retorna un 404
                throw new EntityNotFoundException();
            }
        }else {
            // retorna un 404
            throw new EntityNotFoundException();
        }

    }
// falta validar si el id no existe,devolver algo
    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity eliminarTopico(@PathVariable Long id){
        if(id!=null){
            Optional<Topico> unTopico = topicoRepository.findById(id);
            if(unTopico.isPresent()){
                topicoRepository.deleteById(id);
                // devuelve un 204
                return ResponseEntity.noContent().build();
            }else {
                // retorna un 404
                throw new EntityNotFoundException();
            }
        }else {
            // retorna un 404
            throw new EntityNotFoundException();
        }

    }
}
