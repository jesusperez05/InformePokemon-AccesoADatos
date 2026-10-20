package org.example.services;

import org.example.models.Pokemon;
import tools.jackson.core.JacksonException;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Objects;

public class FileService {
    private String fileName;

    public FileService(String fileName) {
        this.fileName = fileName;
    }

    public List<Pokemon> leerArchivoJson(String filename) {
        if (filename != null && !filename.isBlank()) {
            ObjectMapper mapper = new ObjectMapper();

            try {
                return (List)mapper.readValue(new FileReader(this.fileName), new TypeReference<List<Pokemon>>() {
                    {
                        Objects.requireNonNull(FileService.this);
                    }
                });
            } catch (FileNotFoundException e) {
                throw new RuntimeException("Error al leer el archivo de pokemons" + filename, e);
            } catch (JacksonException e) {
                throw new RuntimeException("Error al leer el archivo de pokemons" + filename, e);
            }
        } else {
            throw new IllegalArgumentException("El archivo no puede ser nulo");
        }
    }
}
