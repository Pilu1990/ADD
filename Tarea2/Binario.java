package Tarea2;

import java.io.*;

public class Binario {
    public static void main(String[] args) {
        String ruta = "binario.bin";

        //Parte 2 del ejercicio

        try(DataOutputStream n = new DataOutputStream(new FileOutputStream(ruta))){
            n.writeInt(34);
            n.writeUTF("Tarea de Acceso a Datos");
            n.writeDouble(3.14);

            System.out.println("Datos escritos en: " + ruta);


        }catch(IOException e){
            System.out.println("Error al escribir los datos: " + e.getMessage());
        }

        //Parte 3 del ejercicio

        try(DataInputStream n = new DataInputStream(new FileInputStream(ruta))){
            int numero = n.readInt();
            String texto = n.readUTF();
            double decimal = n.readDouble();

            System.out.println("número = " + numero + " texto = " + texto + " decimal = " + decimal);

        }catch(IOException e){
            System.out.println("Error al leer datos: " + e.getMessage());
        }
    }
}
