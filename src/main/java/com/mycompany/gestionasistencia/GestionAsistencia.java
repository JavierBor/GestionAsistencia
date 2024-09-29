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
        Map<String, List<Alumno>> cursos = new HashMap<String, List<Alumno>>();
        cursos.put("primero medio", new ArrayList<>());
        cursos.put("segundo medio", new ArrayList<>());
        cursos.put("tercero medio", new ArrayList<>());
        cursos.put("cuarto medio", new ArrayList<>());

        // Alumnos para Primero Medio
        cursos.get("primero medio").add(new Alumno("Juan Caceres", "juan.c@mail.com", "21442863-9", 53479, 937868948));
        cursos.get("primero medio").add(new Alumno("Maria Gonzalez", "maria.g@mail.com", "23456559-0", 41298, 937868948));
        cursos.get("primero medio").add(new Alumno("Carlos Lopez", "carlos.l@mail.com", "21567890-1", 57483, 937868948));

        // Alumnos para Segundo Medio
        cursos.get("segundo medio").add(new Alumno("Ana Astorga", "ana.a@mail.com", "21678901-2", 90834, 937868948));
        cursos.get("segundo medio").add(new Alumno("Luis Martinez", "luis.m@mail.com", "22789012-3", 98756, 937868948));
        cursos.get("segundo medio").add(new Alumno("Jose Zamorano", "jose.z@mail.com", "20890123-4", 12567, 937868948));

        // Alumnos para Tercero Medio
        cursos.get("tercero medio").add(new Alumno("Pablo Diaz", "pablo.d@mail.com", "22012345-6", 56437, 937868948));
        cursos.get("tercero medio").add(new Alumno("Elena Fernandez", "elena.f@mail.com", "21123456-7", 58394, 937868948));
        cursos.get("tercero medio").add(new Alumno("Laura Sanchez", "laura.s@mail.com", "19901234-5", 79856, 937868948));
       
        // Alumnos para Cuarto Medio
        cursos.get("cuarto medio").add(new Alumno("Diego Alvarez", "diego.a@mail.com", "22234567-8", 10000, 937868948));
        cursos.get("cuarto medio").add(new Alumno("Javier Borquez", "javier.b@mail.com", "23451189-0", 34867, 945746339));
        cursos.get("cuarto medio").add(new Alumno("Diego Valenzuela", "diego.v@mail.com", "21377678-9", 12761, 937868948));
        
        //Cargar archivo de alumnos
        String urlArchivo = "https://raw.githubusercontent.com/JavierBor/GestionAsistencia/refs/heads/master/src/main/java/com/mycompany/gestionasistencia/datosCursos.csv";
        cargarAlumnosDesdeURL(urlArchivo, cursos);
        
        do{
            boolean validInput = false;
            System.out.println("1. Pasar asistencia.");
            System.out.println("2. Modificar asistencia.");
            System.out.println("3. Mostrar registros.");
            System.out.println("4. Salir del Programa.");

            System.out.println("");
            
            String curso;
            String alumno;
            
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
                        ArrayList listaAlumnos = (ArrayList) cursos.get(cursoX);
                        pasarAsistencia(listaAlumnos);
                        
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
                        System.out.print("Ingrese nombre del alumno: ");
                        alumno = lector.readLine();
                        encontrado = 0;

                        i = 0;
       
                        while (i < cursos.get(cursoS).size()) {
                            if (cursos.get(cursoS).get(i).getNombre().equals(alumno)) {
                                modificarAsistencia(cursos.get(cursoS).get(i));
                                encontrado = 1;
                                break; 
                            }
                            i++; 
                        }

 
                        if (encontrado == 0) {
                            System.out.println("No se encontró el alumno entre los registros.");
                        }
                    } else {
                        System.out.println("El curso no existe en los registros.");
                    }
                    break;


  
                    
                case 3:
                    mostrarRegistro(cursos);                     
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