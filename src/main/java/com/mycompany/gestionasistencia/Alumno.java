package com.mycompany.gestionasistencia;
import java.io.*;


public class Alumno {
    private String nombre;
    private String rut;
    private Asistencia asistencia;
    private int codigo;
    
    public Alumno(String nombre, String rut, int codigo){
        this.nombre = nombre;
        this.rut = rut;
        this.codigo = codigo;
        asistencia = new Asistencia();
    }
    
    public String getNombre(){
        return nombre;
    }
     
    public String getRut(){
        return rut;
    }
    
    public int getCodigo(){
        return codigo;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setRut(String rut){
        this.rut = rut;
    }
    
    public void setRut(int codigo){
        this.codigo = codigo;
    }
    
    // Presente o ausente
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
