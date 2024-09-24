package com.mycompany.gestionasistencia;
import java.util.*;

public class Alumno {
    private String nombre;
    private String rut;
    private int codigo;
    
    private Asistencia asistencia;
    
    public Alumno(String nombre, String rut, int codigo){
        this.nombre = nombre;
        this.rut = rut;
        this.codigo = codigo;
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
    
    //Métodos (Incluír sobrecarga)
    
    public void setCodigo(int codigo){
        this.codigo = codigo;
    } 
    
}
