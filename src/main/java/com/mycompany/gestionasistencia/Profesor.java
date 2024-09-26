package com.mycompany.gestionasistencia;
import java.io.*;

public class Profesor extends MiembroEstablecimiento{
    private String especialidad;
    
    public Profesor(String nombre, String correo, String rut, int codigo, String especialidad) {
        super(nombre, correo, rut, codigo);
        this.especialidad = especialidad;
    }
    
    //GETTERS
    public String getEspecialidad(){
        return especialidad;
    }
    
    //SETTERS
    public void setEspecialidad(String especialidad){
        this.especialidad = especialidad;
    }
    
    //MÉTODOS PROPIOS
    
}
