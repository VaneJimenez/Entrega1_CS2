package com.software2.Entrega1_VanesaJimenez.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.software2.Entrega1_VanesaJimenez.model.Libro;

@RestController
@RequestMapping("/api/libros")

public class LibroController {

    private List<Libro> libros;

    public LibroController() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Libro[] librosArray = objectMapper.readValue(new ClassPathResource("libros.json").getFile(), Libro[].class);
            libros = new ArrayList<>(Arrays.asList(librosArray));
        } catch (IOException e) {
            e.printStackTrace();
            libros = new ArrayList<>();
        }
    }

    @GetMapping
    public List<Libro> getAllLibros(){
        return libros;
    }

    @GetMapping("/{id}")
    public Libro getLibroById(@PathVariable Long id) {
        return libros.stream()
                .filter(libro -> libro.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @PostMapping
    public Libro createLibro(@RequestBody Libro libro) {
        libros.add(libro);
        return libro;
    }
    
    @PutMapping("/{id}")
    public Libro updateLibro(@PathVariable Long id, @RequestBody Libro updatedLibro) {
        Libro libro = getLibroById(id);
        if (libro != null) {
            libro.setNombre(updatedLibro.getNombre());
            libro.setAutor(updatedLibro.getAutor());
            libro.setGenero(updatedLibro.getGenero());
            return libro;
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteLibro(@PathVariable Long id) {
        libros.removeIf(libro -> libro.getId().equals(id));
    }

    
}
