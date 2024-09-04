package com.mycompany.gestionasistencia;
import java.io.*;
import java.util.*;

public class GestionAsistencia {
    
    public static void main(String[] args)throws IOException{
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        int opcion;
        int i;
        int encontrado;
        
        //Crear mapa de cursos (4 en total)
        Map<String, List<Alumno>> cursos = new HashMap<String, List<Alumno>>();
        cursos.put("Primero Medio", new ArrayList<>());
        cursos.put("Segundo Medio", new ArrayList<>());
        cursos.put("Tercero Medio", new ArrayList<>());
        cursos.put("Cuarto Medio", new ArrayList<>());

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
        cursos.get("Cuarto Medio").add(new Alumno("Javier Borquez", "23451189-0", 12));
        cursos.get("Cuarto Medio").add(new Alumno("Diego Valenzuela", "21377678-9", 11));
   
        do{
            System.out.println("1. Pasar asistencia.");
            System.out.println("2. Modificar asistencia.");
            System.out.println("3. Mostrar registros.");
            System.out.println("4. Salir del Programa.");
            System.out.print("Ingrese su opcion: ");
            opcion = Integer.parseInt(lector.readLine());
            System.out.println("");
            
            String curso;
            String alumno;
            switch (opcion) 
            {
                case 1: 
                    System.out.println("Ingrese el curso: (ej: Primero Medio)");
                    curso = lector.readLine();
                    ArrayList listaAlumnos = (ArrayList) cursos.get(curso);
                    pasarAsistencia(listaAlumnos);
                    break;
                    
                case 2:                 
                    System.out.print("Ingrese el curso (ej: Primero Medio): ");
                    curso = lector.readLine();
                    System.out.print("Ingrese nombre del alumno: ");
                    alumno = lector.readLine();
                    encontrado = 0;
                    i = 0;
                    while (i != cursos.get(curso).size()){
                        if (cursos.get(curso).get(i).getNombre().equals(alumno)){
                            modificarAsistencia(cursos.get(curso).get(i));
                            encontrado = 1;
                            break;
                        }
                    }
                    if (encontrado == 0){
                        System.out.println("No se encontro el alumno entre los registros");
                    }
                    break;
                    
                case 3:
                    mostrarRegistro(cursos);                     
                    break;
                    
            }
        } while (opcion != 4);
        System.out.println("Saliendo del programa...");
    }
    
    
    
    
    public static void pasarAsistencia(ArrayList alumnos)throws IOException{
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ingrese la fecha actual: (dd/mm/aa)");
        String fecha = lector.readLine();
        System.out.println("Para cada alumno ingrese Ausente o Presente");
        int i = 0;
        Alumno alumno;
        while (true){
            if (i == alumnos.size()){
                break;
            }
            alumno = (Alumno) alumnos.get(i);
            alumno.registrar(fecha);
            i++;
        }
        System.out.println();
    }
    
    public static void modificarAsistencia(Alumno alumno) throws IOException{
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        String fecha, estado;
        System.out.println("Ingrese la fecha actual: (dd/mm/aa)");
        fecha = lector.readLine();
        System.out.println("Ingrese Retirado o Atrasado");
        estado = lector.readLine();
        alumno.registrar(fecha, estado);
    }
    
    public static void mostrarRegistro(Map<String, List<Alumno>> cursos) throws IOException{
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        int opcion;          
        String curso;
        ArrayList alumnos;
        System.out.println("1. Mostrar Registro de Curso.");
        System.out.println("2. Mostrar Registro de Alumno.");
        System.out.println("3. Cancelar.");
        System.out.print("Ingrese su opción: ");
        opcion = Integer.parseInt(lector.readLine());
        

        switch (opcion) {
            case 1: 
                System.out.print("Ingrese un curso: (ej: Primero Medio): ");
                curso = lector.readLine();
                System.out.println("");
                alumnos = (ArrayList) cursos.get(curso);
                for (int i = 0 ; i < alumnos.size() ; i++){
                    Alumno alumno = (Alumno) alumnos.get(i);
                    System.out.println("Nombre: "+alumno.getNombre());
                    System.out.println("RUT: "+alumno.getRut());
                    alumno.getAsistencia().getRegistros();
                    System.out.println("");
                }
                break;

            case 2:
                System.out.print("Ingrese un curso: (ej: Primero Medio): ");
                curso = lector.readLine();
                System.out.print("Ingrese el nombre del alumno: ");
                String nombre = lector.readLine();
                boolean encontrado = false;
                alumnos = (ArrayList) cursos.get(curso);
                for (int i = 0 ; i < alumnos.size() ; i++){
                    Alumno alumno = (Alumno) alumnos.get(i);
                    if (nombre.equals(alumno.getNombre())){
                        System.out.println("");
                        System.out.println("Nombre: "+alumno.getNombre());
                        System.out.println("RUT: "+alumno.getRut());
                        alumno.getAsistencia().getRegistros();
                        System.out.println("");      
                        encontrado = true;       
                        break;
                    }         
                }
                if (encontrado == false){
                    System.out.println("Alumno no encontrado.");
                }
                break;

            case 3:
                System.out.println("Volviendo al menú principal...");
                break;

            default:
                System.out.println("Opción no valida.");
                break;
        } 
    }
    
}

