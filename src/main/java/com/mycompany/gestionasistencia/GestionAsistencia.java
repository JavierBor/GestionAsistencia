package com.mycompany.gestionasistencia;
import java.io.*;

public class GestionAsistencia {

    public static void main(String[] args)throws IOException{
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        int opcion;
        //Crear mapa de cursos (4 en total)
        
        
        
        
        
        do{
            System.out.println("1. Pasar asistencia.");
            System.out.println("2. Modificar asistencia.");
            System.out.println("3. Mostrar registros.");
            System.out.println("4. Salir del Programa.");
            System.out.print("Ingrese su opción: ");
            opcion = Integer.parseInt(lector.readLine());
            String curso;
            String alumno;
            switch (opcion) 
            {
                case 1: 
                    System.out.print("Ingrese el curso: ");
                    curso = lector.readLine();
                    //Llamada a Método aquí
                    System.out.println();
                   
                    break;
                case 2:                 
                    System.out.print("Ingrese el curso: ");
                    curso = lector.readLine();
                    System.out.print("Ingrese nombre del alumno: ");
                    alumno = lector.readLine();
                    //Llamada a Método aquí
                    System.out.println();
                    break;
                    
                case 3:
                    System.out.println("Mostrando registros");
            }
        } while (opcion != 4);
        System.out.println("Saliendo del programa...");
    }
}
