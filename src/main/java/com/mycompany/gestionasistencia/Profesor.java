package com.mycompany.gestionasistencia;

import javax.swing.table.DefaultTableModel;

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
    public void agregarInformacion(DefaultTableModel modelo){
        modelo.addRow(new Object[]{nombre, rut, correo, especialidad}); 
    }
}
