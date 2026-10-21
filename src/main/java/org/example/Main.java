package org.example;

import org.example.models.Pokemon;
import org.example.services.FileService;
import java.util.List;

import static org.example.services.Estadisticas.*;

public class Main {
    static void main() {
        FileService fileService = new FileService("pokemon.json");

        List<Pokemon> pokemons = fileService.leerArchivoJson("pokemon.json");
        pokemons.forEach(System.out::println);

        calcularEstadisticas(pokemons);
        guardarEstadisticas(pokemons, "pokemons.txt");

    }
}