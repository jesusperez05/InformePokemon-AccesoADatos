package org.example.models;

public record Pokemon(
        Long id,
        String nombre,
        String tipo,
        Integer nivel,
        Integer ps
) {

}
