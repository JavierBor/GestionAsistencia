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
    
    public void mostrarRegistro(String rut){
        Alumno alumno = estaAlumno(rut);
        if (alumno != null){
            System.out.println("-".repeat(60));
            alumno.mostrarInformacion();
            System.out.println("-".repeat(60));
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

