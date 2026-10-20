package org.example;

import org.example.models.Pokemon;
import org.example.services.FileService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.example.services.Estadisticas.calcularEstadisticas;

public class Main {
    static void main() {
        FileService fileService = new FileService("pokemon.json");

        List<Pokemon> pokemons = fileService.leerArchivoJson("pokemon.json");
        pokemons.forEach(System.out::println);

        calcularEstadisticas(pokemons);

    }
}