package com.software2.Entrega1_VanesaJimenez.model;

public class Libro {
    private Long id;
    private String nombre;
    private String autor;
    private String genero;
    
    public Libro() {
    }

    public Libro(Long id, String nombre, String autor, String genero) {
        this.id = id;
        this.nombre = nombre;
        this.autor = autor;
        this.genero = genero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    

}



