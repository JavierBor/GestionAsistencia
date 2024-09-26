package com.mycompany.gestionasistencia;

public class MiembroEstablecimiento{
    protected String nombre;
    protected String correo;
    protected String rut;
    protected int codigo;
    
    public MiembroEstablecimiento(String nombre, String correo, String rut, int codigo){
        this.nombre = nombre;
        this.correo = correo;
        this.rut = rut;
        this.codigo = codigo;
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
    
    public int getCodigo(){
        return codigo;
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
    
    public void setCodigo(int codigo){
        this.codigo = codigo;
    }
    
    //ESCOGER METODOS A SOBRESCRIBIR, ESTE ES SOLO UN EJEMPLO!
    // Método a sobrescribir en subclases
    public void mostrarResponsabilidades(){
        System.out.println("Responsabilidades generales dentro del establecimiento.");
    }
}

