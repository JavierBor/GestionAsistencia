package com.mycompany.gestionasistencia;
import java.io.*;
public class GestionAsistencia {

    public static void main(String[] args)throws IOException{
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        String opcion;
        do{
            System.out.println("1. Pasar asistencia.");
            System.out.println("2. Modificar asistencia.");
            System.out.println("3. Mostrar registros");
            System.out.println("4. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = lector.readLine();
            switch (opcion) {
                case "1" -> System.out.println("Pasar lista");
                case "2" -> {
                    System.out.println("Modificando asistencia");
                    System.out.print("Ingrese nombre del alumno:");
                    System.out.println();
                }
                case "3" -> System.out.println("Mostrando registros");
                case "4" -> {
                    System.out.println("Saliendo del programa");
                }

            }
        }while (!opcion.equals("4"));
    }
}
