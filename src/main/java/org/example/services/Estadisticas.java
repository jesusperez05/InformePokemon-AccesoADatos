package org.example.services;

import org.example.models.Pokemon;

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
}
