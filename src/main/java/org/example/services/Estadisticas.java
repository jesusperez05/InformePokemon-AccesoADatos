package org.example.services;

import org.example.models.Pokemon;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Estadisticas {

    public static void calcularEstadisticas(List<Pokemon> pokemons) {
        System.out.println("Total de Pokémon: " + pokemons.size());
        System.out.println();

        int sumaNiveles = 0;
        int sumaPS = 0;

        Pokemon pokemonMayorNivel = pokemons.get(0);
        Pokemon pokemonMasPS = pokemons.get(0);

        for (int i = 0; i < pokemons.size(); i++) {
            Pokemon pokemon = pokemons.get(i);

            sumaNiveles += pokemon.nivel();
            sumaPS += pokemon.ps();

            if (pokemon.nivel() > pokemonMayorNivel.nivel()) {
                pokemonMayorNivel = pokemon;
            }

            if (pokemon.ps() > pokemonMasPS.ps()) {
                pokemonMasPS = pokemon;
            }
        }

        int nivelMedio = sumaNiveles / pokemons.size();
        int psMedios = sumaPS / pokemons.size();

        System.out.println("Nivel medio: " + nivelMedio);
        System.out.println();
        System.out.printf("PS medios: " + psMedios);
        System.out.println();

        System.out.println("Pokémon con mayor nivel:");
        System.out.println(pokemonMayorNivel.nombre() + " (Nivel " + pokemonMayorNivel.nivel() + ")");
        System.out.println();

        System.out.println("Pokémon con más PS:");
        System.out.println(pokemonMasPS.nombre() + " (PS " + pokemonMasPS.ps() + ")");
        System.out.println();

        List<String> tiposMostrados = new ArrayList<>();

        System.out.println("-------------------------");
        System.out.println("POKÉMON POR TIPO");
        System.out.println("-------------------------");
        System.out.println();

        for (int i = 0; i < pokemons.size(); i++) {
            String tipo = pokemons.get(i).tipo();

            if (!tiposMostrados.contains(tipo)) {
                tiposMostrados.add(tipo);

                int contador = 0;

                for (int j = 0; j < pokemons.size(); j++) {
                    if (pokemons.get(j).tipo().equals(tipo)) {
                        contador++;
                    }
                }

                System.out.println(tipo + ": " + contador);
                System.out.println();

                for (int j = 0; j < pokemons.size(); j++) {
                    if (pokemons.get(j).tipo().equals(tipo)) {
                        System.out.println(pokemons.get(j).nombre());
                    }
                }
            }
        }
    }

    public static void guardarEstadisticas(List<Pokemon> pokemons, String rutaArchivo) {
        if (pokemons == null || pokemons.isEmpty()) {
            System.out.println("La lista de Pokémon está vacía.");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {

            writer.write("Total de Pokémon: " + pokemons.size());
            writer.newLine();
            writer.newLine();

            int sumaNiveles = 0;
            int sumaPS = 0;

            Pokemon pokemonMayorNivel = pokemons.get(0);
            Pokemon pokemonMasPS = pokemons.get(0);

            for (int i = 0; i < pokemons.size(); i++) {
                Pokemon pokemon = pokemons.get(i);

                sumaNiveles += pokemon.nivel();
                sumaPS += pokemon.ps();

                if (pokemon.nivel() > pokemonMayorNivel.nivel()) {
                    pokemonMayorNivel = pokemon;
                }

                if (pokemon.ps() > pokemonMasPS.ps()) {
                    pokemonMasPS = pokemon;
                }
            }

            int nivelMedio = sumaNiveles / pokemons.size();
            int psMedios = sumaPS / pokemons.size();

            writer.write("Nivel medio: " + nivelMedio);
            writer.newLine();
            writer.newLine();
            writer.write("PS medios: " + psMedios);
            writer.newLine();
            writer.newLine();

            writer.write("Pokémon con mayor nivel:");
            writer.newLine();
            writer.write(pokemonMayorNivel.nombre() + " (Nivel " + pokemonMayorNivel.nivel() + ")");
            writer.newLine();
            writer.newLine();

            writer.write("Pokémon con más PS:");
            writer.newLine();
            writer.write(pokemonMasPS.nombre() + " (PS " + pokemonMasPS.ps() + ")");
            writer.newLine();
            writer.newLine();

            List<String> tiposMostrados = new ArrayList<>();

            writer.write("-------------------------");
            writer.newLine();
            writer.write("POKÉMON POR TIPO");
            writer.newLine();
            writer.write("-------------------------");
            writer.newLine();
            writer.newLine();

            for (int i = 0; i < pokemons.size(); i++) {
                String tipo = pokemons.get(i).tipo();

                if (!tiposMostrados.contains(tipo)) {
                    tiposMostrados.add(tipo);

                    int contador = 0;

                    for (int j = 0; j < pokemons.size(); j++) {
                        if (pokemons.get(j).tipo().equals(tipo)) {
                            contador++;
                        }
                    }

                    writer.write(tipo + ": " + contador);
                    writer.newLine();
                    writer.newLine();

                    for (int j = 0; j < pokemons.size(); j++) {
                        if (pokemons.get(j).tipo().equals(tipo)) {
                            writer.write(pokemons.get(j).nombre());
                            writer.newLine();
                        }
                    }
                    writer.newLine();
                }
            }

            System.out.println("¡Estadísticas guardadas con éxito en el archivo: " + rutaArchivo + "!");

        } catch (IOException e) {
            System.err.println("Error de E/S al escribir en el archivo: " + e.getMessage());
        }
    }
}
