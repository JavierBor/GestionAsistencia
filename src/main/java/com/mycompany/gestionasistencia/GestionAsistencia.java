package com.mycompany.gestionasistencia;
import java.io.*;
import java.util.*;
import java.net.URL;

public class GestionAsistencia {
    
    public static void main(String[] args)throws IOException{
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        int opcion= 0;
        int i;
        int encontrado;
        
        //Crear mapa de cursos (4 en total)
        Map<String, Curso> cursos = new HashMap<String, Curso>();
        cursos.put("primero medio", new Curso("primero medio"));
        cursos.put("segundo medio", new Curso("segundo medio"));
        cursos.put("tercero medio", new Curso("tercero medio"));
        cursos.put("cuarto medio", new Curso("cuarto medio"));

        // Alumnos para Primero Medio
        try {
            cursos.get("primero medio").agregarAlumno("Juan Caceres", "juan.c@mail.com", "21442863-9", 53479, 937868948);
            cursos.get("primero medio").agregarAlumno("Maria Gonzalez", "maria.g@mail.com", "23456559-0", 41298, 937868948);
            cursos.get("primero medio").agregarAlumno("Carlos Lopez", "carlos.l@mail.com", "21567890-1", 57483, 937868948);
        } catch (AlumnoRepetidoException e){
            System.out.println(e.getMessage());
        }
        
        //Cargar archivo de alumnos
        //String urlArchivo = "https://raw.githubusercontent.com/JavierBor/GestionAsistencia/refs/heads/master/src/main/java/com/mycompany/gestionasistencia/datosCursos.csv";
        //cargarAlumnosDesdeURL(urlArchivo, cursos);
        
        do{
            boolean validInput = false;
            System.out.println("1. Pasar asistencia.");
            System.out.println("2. Modificar asistencia.");
            System.out.println("3. Mostrar registros.");
            System.out.println("4. Salir del Programa.");

            System.out.println("");
            
            String curso;
            String alumno;
            Curso cursoActual;
            
            while (!validInput) {
                try {
                    System.out.print("Ingrese su opción: ");
                    opcion = Integer.parseInt(lector.readLine());
                    if (opcion < 1 || opcion > 4) {
                        System.out.println("Opción no válida. Por favor, ingrese un número entre 1 y 4.");
                    } else {
                        validInput = true;  
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Entrada no válida. Por favor, ingrese un número entero.");
                }
            }
            
            switch (opcion) 
            {
                case 1: 
                    System.out.println("Ingrese el curso: (ej: Primero Medio)");
                    
                    curso = lector.readLine();
                    String cursoX = curso.toLowerCase();
                    if (cursos.containsKey(cursoX)) 
                    {
                        cursoActual = (Curso) cursos.get(cursoX);
                        cursoActual.modAsistencia();
                        
                    } else {
                        System.out.println("Curso no encontrado. Por favor, ingrese un curso válido.");
                    }
                    break;

                case 2:                 
                    System.out.print("Ingrese el curso (ej: Primero Medio): ");
                    curso = lector.readLine();
                    String cursoS = curso.toLowerCase(); // Convertir el curso a minúsculas para la búsqueda

                    if (cursos.containsKey(cursoS)) 
                    {
                        cursoActual = cursos.get(curso);
                    } else {
                        System.out.println("El curso no existe en los registros.");
                    }
                    break;


  
                    
                case 3:
                                         
                    break;
                case 4:
                    System.out.println("Saliendo del Programa..");
            }
            
        } while (opcion != 4);
        
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
    

    
    public static void mostrarRegistro(Map<String, List<Alumno>> cursos) throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        int opcion;          
        String curso;
        List<Alumno> alumnos;  
        System.out.println("1. Mostrar Registro de Curso.");
        System.out.println("2. Mostrar Registro de Alumno.");
        System.out.println("3. Cancelar.");
        System.out.print("Ingrese su opción: ");
        opcion = Integer.parseInt(lector.readLine());


        switch (opcion) {
            case 1: 
                System.out.print("Ingrese un curso: (ej: Primero Medio): ");
                curso = lector.readLine();

                String curso1 = curso.toLowerCase();
                System.out.println("");

                alumnos = cursos.get(curso1);
                if (alumnos != null) {
                    for (int i = 0 ; i < alumnos.size() ; i++) {
                        Alumno alumno = alumnos.get(i);
                        System.out.println("Nombre: " + alumno.getNombre());
                        System.out.println("RUT: " + alumno.getRut());
                        alumno.mostrarInfo();  
                        System.out.println("");
                    }
                } else {
                    System.out.println("El curso ingresado no existe.");
                }
                break;

            case 2:
                System.out.print("Ingrese un curso: (ej: Primero Medio): ");
                curso = lector.readLine();
                String curso2 = curso.toLowerCase();
                System.out.print("Ingrese el nombre del alumno: ");
                String nombre = lector.readLine();
                boolean encontrado = false;

                alumnos = cursos.get(curso2);
                if (alumnos != null) {
                    for (int i = 0 ; i < alumnos.size(); i++) {
                        Alumno alumno = alumnos.get(i);
                        if (nombre.equalsIgnoreCase(alumno.getNombre())){
                            System.out.println("");
                            System.out.println("Nombre: " + alumno.getNombre());
                            System.out.println("RUT: " + alumno.getRut());
                            alumno.mostrarInfo();  
                            System.out.println("");
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Alumno no encontrado.");
                    }
                } else {
                    System.out.println("El curso ingresado no existe.");
                }
                break;

            case 3:
                System.out.println("Volviendo al menú principal...");
                break;

            default:
                System.out.println("Opción no válida.");
                break;
        }
    }
    
    public static void cargarAlumnosDesdeURL(String urlArchivo, Map<String, List<Alumno>> cursos) {
        BufferedReader br = null;
        try {
            // Crear URL y abrir conexión
            URL url = new URL(urlArchivo);
            br = new BufferedReader(new InputStreamReader(url.openStream())); //Leemos a través del URL

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 6) {
                    String curso = datos[0].trim();
                    String nombre = datos[1].trim();
                    String rut = datos[2].trim();
                    int codigoUnico = Integer.parseInt(datos[3].trim());
                    String correo = datos[4].trim();
                    int numTutor = Integer.parseInt(datos[5].trim());

                    // Crear objeto Alumno con nombre, rut y código único
                    Alumno alumno = new Alumno(nombre, correo, rut, codigoUnico, numTutor);
                    List<Alumno> listaAlumnos = cursos.get(curso.toLowerCase());
                    if (listaAlumnos != null) {
                        listaAlumnos.add(alumno); // Agregar el alumno a la lista
                    } else {
                        System.out.println("Curso no encontrado: " + curso);
                    }
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Error al convertir el código único a entero: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al leer el archivo desde la URL: " + e.getMessage());
        } finally {
            try {
                if (br != null) {
                    br.close(); // Cerrar el BufferedReader
                }
            } catch (Exception e) {
                System.out.println("Error al cerrar el BufferedReader: " + e.getMessage());
            }
        }
    }
}