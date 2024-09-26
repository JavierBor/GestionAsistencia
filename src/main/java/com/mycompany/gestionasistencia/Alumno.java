package com.mycompany.gestionasistencia;
import java.io.*;

public class Alumno extends MiembroEstablecimiento{
    private int numTutor;
    private Asistencia asistencia;
    
    public Alumno(String nombre, String correo, String rut, int codigo, int numTutor){
        super(nombre, correo, rut, codigo);
        this.numTutor = numTutor;
        asistencia = new Asistencia();
    }
    
    //GETTERS
    public int getNumTutor(){
        return numTutor;
    }
    
    //SETTERS
    public void setNumTutor(){
        this.numTutor = numTutor;
    }
    
    //MÉTODOS
    //Presente o ausente
    public void registrar(String fecha) throws IOException{
        System.out.print(this.nombre + ": ");
        asistencia.modificar(fecha);
    }
    
    // Atraso o retiro
    public void registrar(String fecha, String estado){
        asistencia.modificar(fecha, estado);
    }
    
    //Muestra datos de la asistencia del alumno
    public void mostrarInfo(){
        asistencia.mostrarRegistros();
    }
}
