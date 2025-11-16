package Tarea3;

import org.json.*;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class LeerJSON {
    public static void main(String[] args) {

        List<Pelicula> listaPeliculas = new ArrayList<>();

        try (FileReader fr = new FileReader("peliculas.json")) {


            JSONTokener tokener = new JSONTokener(fr);
            JSONObject root = new JSONObject(tokener);


            String catalogo = root.optString("catalogo", "desconocido");
            int version = root.optInt("version", 0);

            System.out.println("Catálogo: " + catalogo + " | Versión: " + version);
            System.out.println();


            JSONArray arrPeliculas = root.getJSONArray("peliculas");


            for (int i = 0; i < arrPeliculas.length(); i++) {

                JSONObject oPelicula = arrPeliculas.getJSONObject(i);

                String titulo = oPelicula.optString("titulo", "Sin título");
                String director = oPelicula.optString("director", "Desconocido");
                int anio = oPelicula.optInt("anio", 0);


                System.out.println(titulo + " (" + anio + ") - Director: " + director);
            }

            System.out.println();
            System.out.println("Total películas leídas: " + arrPeliculas.length());

        } catch (FileNotFoundException e) {
            System.out.println("Error: No se encontró el archivo 'peliculas.json'");
        } catch (JSONException e) {
            System.out.println("Error: JSON mal formado o clave/valor inesperado: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error de lectura: " + e.getMessage());
        }

    }

}
