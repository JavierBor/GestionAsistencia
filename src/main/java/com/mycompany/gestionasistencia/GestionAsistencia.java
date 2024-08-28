  
package com.mycompany.gestionasistencia;
import java.io.*;

public class GestionAsistencia {

    public static void main(String[] args)throws IOException{
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        int opcion;
        do{
            System.out.println("1. Pasar asistencia.");
            System.out.println("2. Modificar asistencia.");
            System.out.println("3. Mostrar registros");
            System.out.println("4. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = Integer.parseInt(lector.readLine());
            switch (opcion) 
            {
                case 1: 
                    System.out.println("Pasar lista");
                    break;
                case 2:
                    System.out.println("Modificando asistencia");
                    System.out.print("Ingrese nombre del alumno:");
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Mostrando registros");
            }
        } while (opcion != 4);
        System.out.println("Saliendo del programa...");
    }
}
