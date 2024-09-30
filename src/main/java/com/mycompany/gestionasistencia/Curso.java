package com.mycompany.gestionasistencia;

import java.io.*;
import java.net.URL;
import java.util.*;

public class Curso {
    private String nombreCurso;
    private List<Alumno> alumnos;
    
    public Curso(String curso){
        this.nombreCurso = curso;
        alumnos = new ArrayList<Alumno>();
    }
    
    public String getNombreCurso(){
        return nombreCurso;
    }
    public void setNombreCurso(String nombreCurso){
        this.nombreCurso = nombreCurso;
    }
    
    public void agregarAlumno(String nombre, String correo, String rut, int codigo, int numTutor) throws AlumnoRepetidoException{
        Alumno nuevoAlumno = estaAlumno(nombre);
        if (nuevoAlumno == null){
            nuevoAlumno = new Alumno(nombre, correo, rut, codigo, numTutor);
            alumnos.add(nuevoAlumno);
        }
        else{
            throw new AlumnoRepetidoException("El alumno ya fue registrado anteriormente");
        }
    }
    
    public Alumno estaAlumno(String nombre){
    Alumno alumnoActual;
    for (int i = 0 ; i < alumnos.size() ; i++) {
        alumnoActual = alumnos.get(i);
        if (nombre.equalsIgnoreCase(alumnoActual.getNombre())) {
            return alumnoActual;  // El alumno fue encontrado
        }
    }
    return null;
}

    
    public void cargarAlumnosDesdeURL(String urlArchivo, Map<String, List<Alumno>> cursos) {
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
    
    
    public void mostrarRegistro(){
        Alumno alumno;
        if (alumnos != null) {
            for (int i = 0 ; i < alumnos.size() ; i++) {
                alumno = alumnos.get(i);
                System.out.println("Nombre: " + alumno.getNombre());
                System.out.println("RUT: " + alumno.getRut());
                alumno.mostrarInfo();  
                System.out.println("");
            }
        }
    }
    
    public void mostrarRegistro(String nombre){
        Alumno alumnoActual = estaAlumno(nombre);
        if (alumnoActual != null){
            System.out.println("");
            System.out.println("Nombre: " + alumnoActual.getNombre());
            System.out.println("RUT: " + alumnoActual.getRut());
            alumnoActual.mostrarInfo();
            System.out.println("");
        }
    }
    
    public void modAsistencia()throws IOException{
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        Alumno alumno;
        System.out.println("Ingrese la fecha actual");
        String fecha = lector.readLine();
        for (int i = 0 ; i < alumnos.size() ; i++){
            alumno = alumnos.get(i);
            alumno.registrar(fecha);
        }
    }
    
    public void modAsistencia(String nombre) throws IOException{
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        Alumno alumno = estaAlumno(nombre);
        String fecha;
        String estado;
        if (alumno != null){
            System.out.println("Ingrese la fecha que quiere modificar");
            fecha = lector.readLine();
            System.out.println("Ingrese el nuevo estado");
            estado = lector.readLine();
            alumno.registrar(fecha, estado);
        }
        else{
            System.out.println("No se encontro el alumno");
        }
    }
}

