package com.mycompany.gestionasistencia;
import java.io.*;
import java.util.*;
import java.net.URL;

public class GestionAsistencia {
    
    public static void main(String[] args)throws IOException{
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        int opcion= 0;
      
        //Crear mapa de cursos (4 en total)
        Map<String, Curso> cursos = new HashMap<String, Curso>();
        cursos.put("primero medio", new Curso("primero medio"));
        cursos.put("segundo medio", new Curso("segundo medio"));
        cursos.put("tercero medio", new Curso("tercero medio"));
        cursos.put("cuarto medio", new Curso("cuarto medio"));
            // Cargar alumnos desde la URL

        // Alumnos para Primero Medio
        try {
            cursos.get("primero medio").agregarAlumno("Juan Caceres", "juan.c@mail.com", "21442863-9", 53479, 937868948);
            cursos.get("primero medio").agregarAlumno("Maria Gonzalez", "maria.g@mail.com", "23456559-0", 41298, 937868948);
            cursos.get("primero medio").agregarAlumno("Carlos Lopez", "carlos.l@mail.com", "21567890-1", 57483, 937868948);

            // Alumnos para Segundo Medio
            cursos.get("segundo medio").agregarAlumno("Ana Astorga", "ana.a@mail.com", "21678901-2", 90834, 937868948);
            cursos.get("segundo medio").agregarAlumno("Luis Martinez", "luis.m@mail.com", "22789012-3", 98756, 937868948);
            cursos.get("segundo medio").agregarAlumno("Jose Zamorano", "jose.z@mail.com", "20890123-4", 12567, 937868948);

            // Alumnos para Tercero Medio
            cursos.get("tercero medio").agregarAlumno("Pablo Diaz", "pablo.d@mail.com", "22012345-6", 56437, 937868948);
            cursos.get("tercero medio").agregarAlumno("Elena Fernandez", "elena.f@mail.com", "21123456-7", 58394, 937868948);
            cursos.get("tercero medio").agregarAlumno("Laura Sanchez", "laura.s@mail.com", "19901234-5", 79856, 937868948);
            
            // Alumnos para Cuarto Medio
            cursos.get("cuarto medio").agregarAlumno("Diego Alvarez", "diego.a@mail.com", "22234567-8", 10000, 937868948);
            cursos.get("cuarto medio").agregarAlumno("Javier Borquez", "javier.b@mail.com", "23451189-0", 34867, 945746339);
            cursos.get("cuarto medio").agregarAlumno("Diego Valenzuela", "diego.v@mail.com", "11222333-4", 12761, 937868948);

        } catch (AlumnoRepetidoException e){
            System.out.println(e.getMessage());
        }
        // test para saber si ya puedo
        //Cargar alumnos desde archivo
        //String urlArchivo = "https://raw.githubusercontent.com/JavierBor/GestionAsistencia/refs/heads/master/src/main/java/com/mycompany/gestionasistencia/datosCursos.csv";
        //cargarAlumnosDesdeURL(urlArchivo, cursos);
        String rut;
        boolean validInput;
        String nombreCurso;
        Curso cursoActual;
        int opcionCase3;
        String cursoS;
        
        // do while que muestra menu y ejecuta acciones que requiera el usuario
        do{
            // se muestra el menu por consola
            validInput = false;
            System.out.println("-".repeat(50));
            System.out.println(" ".repeat(13)+"COLEGIO JINETES DEL BIEN");
            System.out.println("-".repeat(50));
            System.out.println("1. Pasar asistencia.");
            System.out.println("2. Modificar asistencia.");
            System.out.println("3. Mostrar registros.");
            System.out.println("4. Asignar profesor jefe.");
            System.out.println("5. Eliminar profesor jefe.");
            System.out.println("6. Salir del Programa.");
            System.out.println("");
            
            // bloque para confirmar que el usuario ingrese un opcion correcta
            while (!validInput) {
                try {
                    //El usuario ingresa la opcion que requiera
                    System.out.print("Ingrese su opción: ");
                    opcion = Integer.parseInt(lector.readLine());
                    // se comprueba que sea una opcion valida
                    if (opcion < 1 || opcion > 6) {
                        System.out.println("Opción no válida. Por favor, ingrese un número entre 1 y 6.");
                    } else {
                        validInput = true;  
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Entrada no válida. Por favor, ingrese un número entero.");
                }
            }
            
            //Switch que se encarga de ejecutar la opcion que requiera el usuario
            switch (opcion) 
            {
                case 1: // Pasar asistencia
                    //EL usuario ingresa el curso en el cual va a pasar asistencia
                    System.out.print("Ingrese el curso (Ej: Primero Medio): ");
                    nombreCurso = lector.readLine().toLowerCase();
                    if (cursos.containsKey(nombreCurso)) //si el curso se encuentra entre los registro lo obtiene y comienza a pasar lista uno po uno
                    {
                        cursoActual = (Curso) cursos.get(nombreCurso);
                        cursoActual.modAsistencia();
                        
                    } else { // Si el curso no se encuentra se muestra un mensaje indicandolo
                        System.out.println("Curso no encontrado. Por favor, ingrese un curso válido.");
                    }
                    break;
                   
                case 2:// Modificar la asistencia de un alumno en especifico en un dia en especifico
                    // El usuario ingresa el curso al que pertenece el alumno que quiere modificar la asistencia
                    System.out.print("Ingrese el curso (Ej: Primero Medio): ");
                    nombreCurso = lector.readLine();
                    cursoS = nombreCurso.toLowerCase(); // Convertir el curso a minúsculas para la búsqueda
                    
                    if (cursos.containsKey(cursoS)) //Si el curso se encuentra entre los registros se obtiene y se llama al metodo correspondiente
                    {
                        cursoActual = cursos.get(nombreCurso);
                        System.out.print("Ingrese el RUT del alumno: ");
                        rut = lector.readLine();
                        cursoActual.modAsistencia(rut);   
                    } 
                    else { //Si el curso no se encuentra muestra un mensaje indicandolo
                        System.out.println("El curso no existe en los registros.");
                    }
                    break;

                case 3: //mostrar registros (informacion del alumno)
                    System.out.println("1. Mostrar Registro de Curso."); //mostrar registro de todo el curso
                    System.out.println("2. Mostrar Registro de Alumno."); //mostrar registro de un alumno en especifico
                    System.out.println("3. Mostrar Alumnos en Situación de Riesgo."); // opcion SIA 2.5 muestra alumnos que estan bajo una cantidad de asistencia
                    System.out.println("4. Cancelar.");
                    System.out.print("Ingrese su opción: ");
                    opcionCase3 = Integer.parseInt(lector.readLine());

                    switch(opcionCase3){ //Switch para identificar de que forma mostrar el registro
                        case 1: // Mostrar el registro de todo el curso, alumno por alumno
                            System.out.print("Ingrese el curso (Ej: Primero Medio): ");
                            nombreCurso = lector.readLine().toLowerCase();
                            cursoActual = (Curso) cursos.get(nombreCurso);
                            cursoActual.mostrarRegistro();        
                            break;

                        case 2: // Mostrar el registro de un alumno en especifico
                            try{ // bloque try para identificar si el alumno que esta buscando se encuentra entre los registros
                                System.out.print("Ingrese el curso (ej: Primero Medio): ");
                                nombreCurso = lector.readLine().toLowerCase();// El usuario ingresa el curso
                                cursoActual = (Curso) cursos.get(nombreCurso);
                                if (cursoActual != null){ // si el curso esta, pasa a ingresar el nombre del alumno
                                    System.out.print("Ingrese el RUT del Alumno: ");
                                    rut = lector.readLine();
                                    cursoActual.mostrarRegistro(rut); //muestra el registro del alumno
                                }
                                else{ // si el curso no se encuentra se muestra un mensaje indicandolo
                                    System.out.println("El curso ingresado no esta entre los registros");
                                }
                            } catch(AlumnoNoEncontradoException e){ // en caso que salte la excepcion que indica que el alumno no se encuentra muestra un mensaje indicandolo
                                System.out.println(e.getMessage());
                            }
                            break;

                        case 3: // Nueva opción (FALTA MOSTRAR LOS ALUMNOS EN UN ARCHIVO TXT PERO NO ESTOY SEGURO SI LO 
                            //HARE ACA, EL PUNTO 2.5 ES MOSTRAR LOS ALUMNOS EN RIESGO DE ASISTENCIA
                            System.out.print("Ingrese el curso (Ej: Primero Medio): ");
                            nombreCurso = lector.readLine().toLowerCase();
                            if (cursos.containsKey(nombreCurso)) {
                                cursoActual = cursos.get(nombreCurso);
                                cursoActual.mostrarAlumnosEnRiesgo();
                            } else {
                                System.out.println("Curso no encontrado. Por favor, ingrese un curso válido.");
                            }
                            break;
                        
                    }
                    break;


                    
                case 4: //Función asignar profe jefe (la hace clapi)
                    System.out.println("PENDIENTE");
                    break;
                    
                case 5: //Función eliminar profe jefe (la hace clapi)
                    System.out.println("PENDIENTE");
                    break;
                    
                case 6:
                    System.out.println("Saliendo del Programa...");
                    break;
            }
            
        } while (opcion != 6);
    }
        

    public static void cargarAlumnosDesdeURL(String urlArchivo, Map<String, Curso> cursos) {
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
                    Curso cursoActual = cursos.get(curso.toLowerCase());
                    cursoActual.agregarAlumno(nombre, correo, rut, codigoUnico, numTutor);
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