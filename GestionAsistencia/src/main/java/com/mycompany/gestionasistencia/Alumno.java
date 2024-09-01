package com.mycompany.gestionasistencia;
import java.util.*;

public class Alumno {
    private String nombre;
    private String rut;
    private Asistencia asistencia;
    
    public Alumno(String nombre, String rut){
        this.nombre = nombre;
        this.rut = rut;
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
