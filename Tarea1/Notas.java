package Tarea1;
import java.io.*;
import java.util.Scanner;

public class Notas {
    public static void main(String[] args) {

        String ruta = "frases.txt";
        Scanner scanner = new Scanner(System.in);

        try{
            FileWriter archivo = new FileWriter(ruta);
            BufferedWriter frases = new BufferedWriter(archivo);

            System.out.println("Escribe la primera frase: ");
            frases.write(scanner.nextLine());
            frases.newLine();

            System.out.println("Escribe la segunda frase: ");
            frases.write(scanner.nextLine());
            frases.newLine();

            System.out.println("Escribe la tercera frase: ");
            frases.write(scanner.nextLine());
            frases.newLine();

            frases.close();
            System.out.println("Archivo creado con éxito");
        }
        catch (IOException e){
            System.out.println ("Error al crear el archivo: "+ e.getMessage());
        }

        try{
            FileReader fr = new FileReader(ruta);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            int numeroLinea = 1;

            while ((linea = br.readLine()) != null){
                System.out.println(numeroLinea + ". " + linea);
                numeroLinea++;
            }
            br.close();
        } catch (IOException e){
            System.out.println ("Error al leer el archivo: "+ e.getMessage());
        }

        scanner.close();
    }
}