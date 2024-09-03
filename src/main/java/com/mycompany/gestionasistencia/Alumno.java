package com.mycompany.gestionasistencia;

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
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setRut(String rut){
        this.rut = rut;
    }
    //Métodos (Incluír sobrecarga)
    
    
    
}
