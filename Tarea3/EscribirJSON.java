package Tarea3;

import org.json.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class EscribirJSON {
    public static void main(String[] args) {

        List<Pelicula> misPeliculas = Arrays.asList(
                new Pelicula("El Padrino", "Francis Ford Coppola", 1972),
                new Pelicula("Pulp Fiction", "Quentin Tarantino", 1994),
                new Pelicula("El Señor de los Anillos", "Peter Jackson", 2001)
        );


        JSONObject root = new JSONObject();
        root.put("catalogo", "Mis Películas");
        root.put("version", "1.0");

        JSONArray peliculasArray = new JSONArray();

        for (Pelicula p : misPeliculas) {
            JSONObject peliculaJson = new JSONObject();
            peliculaJson.put("titulo", p.getTitulo());
            peliculaJson.put("director", p.getDirector());
            peliculaJson.put("anio", p.getAnio());

            peliculasArray.put(peliculaJson);
        }

        root.put("peliculas", peliculasArray);


        try (FileWriter file = new FileWriter("peliculas.json")) {

            file.write(root.toString(4));
            System.out.println("Archivo peliculas.json creado correctamente.");
            System.out.println("\nJSON generado:");
            System.out.println(root.toString(4));

        } catch (IOException e) {
            System.out.println("Error al escribir: " + e.getMessage());
        }

    }
}
