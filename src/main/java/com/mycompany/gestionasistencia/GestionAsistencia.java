package com.mycompany.gestionasistencia;
import java.io.*;
import java.util.*;
import java.net.URL;

public class GestionAsistencia {
    
    public static void main(String[] args)throws IOException{

        //Crear mapa de cursos (4 en total)
        Map<String, Curso> cursos = new HashMap<String, Curso>();
        cursos.put("primero medio", new Curso("primero medio"));
        cursos.put("segundo medio", new Curso("segundo medio"));
        cursos.put("tercero medio", new Curso("tercero medio"));
        cursos.put("cuarto medio", new Curso("cuarto medio"));

        
        try {
            // Alumnos para Primero Medio
            cursos.get("primero medio").agregarAlumno("Juan Caceres", "juan.c@mail.com", "21442863-9", 937868948);
            cursos.get("primero medio").agregarAlumno("Maria Gonzalez", "maria.g@mail.com", "23456559-0", 937868948);
            cursos.get("primero medio").agregarAlumno("Carlos Lopez", "carlos.l@mail.com", "21567890-1", 937868948);

            // Alumnos para Segundo Medio
            cursos.get("segundo medio").agregarAlumno("Ana Astorga", "ana.a@mail.com", "21678901-2", 937868948);
            cursos.get("segundo medio").agregarAlumno("Luis Martinez", "luis.m@mail.com", "22789012-3", 937868948);
            cursos.get("segundo medio").agregarAlumno("Jose Zamorano", "jose.z@mail.com", "20890123-4",937868948);

            // Alumnos para Tercero Medio
            cursos.get("tercero medio").agregarAlumno("Pablo Diaz", "pablo.d@mail.com", "22012345-6", 937868948);
            cursos.get("tercero medio").agregarAlumno("Elena Fernandez", "elena.f@mail.com", "21123456-7", 937868948);
            cursos.get("tercero medio").agregarAlumno("Laura Sanchez", "laura.s@mail.com", "19901234-5", 937868948);
            
            // Alumnos para Cuarto Medio
            cursos.get("cuarto medio").agregarAlumno("Diego Alvarez", "diego.a@mail.com", "22234567-8", 937868948);
            cursos.get("cuarto medio").agregarAlumno("Javier Borquez", "javier.b@mail.com", "23451189-0", 945746339);
            cursos.get("cuarto medio").agregarAlumno("Diego Valenzuela", "diego.v@mail.com", "11222333-4", 937868948);

        } catch (AlumnoRepetidoException e){
            System.out.println(e.getMessage());
        }
        
        String urlArchivo = "https://raw.githubusercontent.com/JavierBor/GestionAsistencia/refs/heads/master/src/main/java/com/mycompany/gestionasistencia/datosCursos.csv";
        cargarAlumnosDesdeURL(urlArchivo, cursos);
        
        VentanaMenuPrincipal ventana = new VentanaMenuPrincipal(cursos);
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
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
                    String correo = datos[3].trim();
                    int numTutor = Integer.parseInt(datos[4].trim());
                    
                    // Crear objeto Alumno con nombre, rut y código único
                    Curso cursoActual = cursos.get(curso.toLowerCase());
                    cursoActual.agregarAlumno(nombre, correo, rut, numTutor);
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
