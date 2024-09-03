package com.mycompany.gestionasistencia;
import java.io.*;
import java.util.*;

public class GestionAsistencia {

    public static void main(String[] args)throws IOException{
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        int opcion;
        
        //Crear mapa de cursos (4 en total)
        Map<String, List<Alumno>> cursos = new HashMap<String, List<Alumno>>();
        cursos.put("Primero Medio", new ArrayList<Alumno>());
        cursos.put("Segundo Medio", new ArrayList<Alumno>());
        cursos.put("Tercero Medio", new ArrayList<Alumno>());
        cursos.put("Cuarto Medio", new ArrayList<Alumno>());

        // Alumnos para Primero Medio
        cursos.get("Primero Medio").add(new Alumno("Juan Caceres", "21442863-9", 1));
        cursos.get("Primero Medio").add(new Alumno("Maria Gonzalez", "23456559-0", 2));
        cursos.get("Primero Medio").add(new Alumno("Carlos Lopez", "21567890-1", 3));

        // Alumnos para Segundo Medio
        cursos.get("Segundo Medio").add(new Alumno("Ana Astorga", "21678901-2", 4));
        cursos.get("Segundo Medio").add(new Alumno("Luis Martinez", "22789012-3", 5));
        cursos.get("Segundo Medio").add(new Alumno("Jose Zamorano", "20890123-4", 6));

        // Alumnos para Tercero Medio
         cursos.get("Tercero Medio").add(new Alumno("Pablo Diaz", "22012345-6", 8));
        cursos.get("Tercero Medio").add(new Alumno("Elena Fernandez", "21123456-7", 9));
        cursos.get("Tercero Medio").add(new Alumno("Laura Sanchez", "19901234-5", 7));
       

        // Alumnos para Cuarto Medio
        cursos.get("Cuarto Medio").add(new Alumno("Diego Alvarez", "22234567-8", 10));
        cursos.get("Cuarto Medio").add(new Alumno("Javiera Borquez", "23451189-0", 12));
        cursos.get("Cuarto Medio").add(new Alumno("Diego Valenzuela", "21377678-9", 11));

 
        cursos.put("Primero Medio", new ArrayList<Alumno>());
        cursos.put("Segundo Medio", new ArrayList<Alumno>());
        cursos.put("Tercero Medio", new ArrayList<Alumno>());
        cursos.put("Cuarto Medio", new ArrayList<Alumno>());
        //// TEST DIEGO COMMIT 
        // COMMIT 2 TEST SKDGADFSHGKJADFKGDFKLÑGJA

        

        
        
        do{
            System.out.println("1. Pasar asistencia.");
            System.out.println("2. Modificar asistencia.");
            System.out.println("3. Mostrar registros.");
            System.out.println("4. Salir del Programa.");
            System.out.print("Ingrese su opcion: ");
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

