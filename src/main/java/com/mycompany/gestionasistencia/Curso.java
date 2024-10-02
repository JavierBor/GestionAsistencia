package com.mycompany.gestionasistencia;

import java.io.*;
import java.util.*;

public class Curso {
    private String nombreCurso;
    private List<Alumno> alumnos;
    private Profesor profesorJefe; //Pendiente (clapi)
    
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
        Alumno nuevoAlumno = estaAlumno(rut);
        if (nuevoAlumno == null){
            nuevoAlumno = new Alumno(nombre, correo, rut, numTutor);
            alumnos.add(nuevoAlumno);
        }
        else{
            throw new AlumnoRepetidoException("El alumno ya fue registrado anteriormente");
        }
    }
    
    public Alumno estaAlumno(String rut){
    Alumno alumnoActual;
    for (int i = 0 ; i < alumnos.size() ; i++) {
        alumnoActual = alumnos.get(i);
        if (rut.equalsIgnoreCase(alumnoActual.getRut())) {
            return alumnoActual;  // El alumno fue encontrado
        }
    }
    return null;
}

    public void mostrarRegistro(){
        Alumno alumno;
        if (alumnos != null) {
            System.out.println("-".repeat(60));
            for (int i = 0 ; i < alumnos.size() ; i++) {
                alumno = alumnos.get(i);
                alumno.mostrarInformacion();
                System.out.println("-".repeat(60));
                //System.out.println("");
            }
        }
    }
    
    public void mostrarRegistro(String rut) throws AlumnoNoEncontradoException{
        Alumno alumno = estaAlumno(rut);
        if (alumno != null){
            System.out.println("-".repeat(60));
            alumno.mostrarInformacion();
            System.out.println("-".repeat(60));
        }
        else{
            throw new AlumnoNoEncontradoException("El alumno que se ingreso no se encuentra entre los registros");
        }
    }
    // metodo para mostrar los alumnos en riesgo
    public void mostrarAlumnosEnRiesgo() {
        boolean hayAlumnosEnRiesgo = false;
        System.out.println("Alumnos en Situación de Riesgo (<70% de asistencia):");
        System.out.println("-".repeat(60));

        for (Alumno alumno : alumnos) {
            int asistencias = alumno.getAsistencia().getAsists();
            int totalDias = asistencias + alumno.getAsistencia().getFaltas();

            if (totalDias > 0) {
                double porcentajeAsistencia = (asistencias / (double) totalDias) * 100;
                if (porcentajeAsistencia < 70) {
                    hayAlumnosEnRiesgo = true;
                    System.out.println("Nombre: " + alumno.getNombre());
                    System.out.println("RUT: " + alumno.getRut());
                    System.out.println("Porcentaje de Asistencia: " + String.format("%.2f", porcentajeAsistencia) + "%");
                    System.out.println("-".repeat(60));
                }
            }
    }
    
        if (!hayAlumnosEnRiesgo) {
            System.out.println("No hay alumnos en situación de riesgo en este curso.");
        }
}

    
    
    //Para pasar lista normalmente
    public void modAsistencia()throws IOException{
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        Alumno alumno;
        System.out.print("Ingrese la fecha actual (dd/mm/aaaa): ");
        String fecha = lector.readLine();
        for (int i = 0 ; i < alumnos.size() ; i++){
            alumno = alumnos.get(i);
            alumno.registrar(fecha);
        }
    }
    
    //Para modificar la asistencia ya registrada
    public void modAsistencia(String rut) throws IOException{
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        Alumno alumno = estaAlumno(rut);
  
        if (alumno != null){
            String fecha;
            String estado;
            
            System.out.print("Ingrese la fecha que quiere modificar (dd/mm/aaaa): ");
            fecha = lector.readLine();
            
            System.out.print("Ingrese el nuevo estado (Presente/Ausente/Atraso/Retiro): ");
            estado = lector.readLine();
            
            alumno.registrar(fecha, estado);
        }
        else{
            System.out.println("No se encontro el alumno");
        }
    }
}

