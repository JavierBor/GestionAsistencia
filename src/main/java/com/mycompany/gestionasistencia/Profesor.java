package com.mycompany.gestionasistencia;

public class Profesor extends MiembroEstablecimiento{
    private String especialidad;
    
    public Profesor(String nombre, String correo, String rut, String especialidad) {
        super(nombre, correo, rut);
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
    @Override
    public void mostrarInformacion(){
        System.out.println("RUT: "+rut);
        System.out.println("Nombre Profesor: "+nombre);
        System.out.println("Especialidad: "+especialidad);
        System.out.println("Correo Institucional: "+correo);
    }
}
