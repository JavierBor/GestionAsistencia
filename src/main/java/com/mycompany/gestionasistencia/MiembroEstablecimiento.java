package com.mycompany.gestionasistencia;

import javax.swing.table.DefaultTableModel;

public class MiembroEstablecimiento{
    protected String nombre;
    protected String correo;
    protected String rut;
    
    public MiembroEstablecimiento(String nombre, String correo, String rut){
        this.nombre = nombre;
        this.correo = correo;
        this.rut = rut;
    }

    //GETTERS
    public String getNombre(){
        return nombre;
    }

    public String getCorreo(){
        return correo;
    }
    
    public String getRut(){
        return rut;
    }

    //SETTERS
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setCorreo(String correo){
        this.correo = correo;
    }
    
    public void setRut(String rut){
        this.rut = rut;
    }
    
    // Métodos a sobrescribir en subclases
    public void agregarInformacion(DefaultTableModel modelo){
        modelo.addRow(new Object[]{nombre, rut, correo});
    }
}

