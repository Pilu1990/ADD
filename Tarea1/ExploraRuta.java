package Tarea1;

import java.io.File;
import java.util.Scanner;

public class ExploraRuta {
    public static void main(String[] args) {

        String ruta = args[0];
        File archivo = new File(ruta);

        if (archivo.exists()) {

            if (archivo.isFile()) {
                System.out.println("Nombre: " + archivo.getName());
                System.out.println("Tamaño: " + archivo.length() + " Bytes");
                System.out.println("¿Se puede leer? " + archivo.canRead());
                System.out.println("¿Se puede escribir? " + archivo.canWrite());
            }

            if (archivo.isDirectory()) {
                String[] elementos = archivo.list();
                System.out.println("El directorio contiene " + elementos.length + " elementos");
                for (String nombre : elementos) {
                    System.out.println("- " + nombre);
                }
            }
        }
        else{
            System.out.println("La ruta no existe");
        }
    }
}
