package com.mycompany.gestionasistencia;
import java.util.*;
import java.io.*;

public class Asistencia {
    private Map<String, String> asistencia;
    private int nAsistencia;
    private int nFaltas;
    private int nAtrasos;
    private int nRetiros;
    
    public Asistencia(){
        nAsistencia = 0;
        nFaltas = 0;
        nAtrasos = 0;
        nRetiros = 0;
        asistencia = new HashMap<>();
    }
    
    //GETTERS
    public int getNAsistencia(){
        return nAsistencia;
    }
    
    public int getNFaltas(){
        return nFaltas;
    }
    
    public int getNAtrasos(){
        return nAtrasos;
    }
    
    public int getNRetiros(){
        return nRetiros;
    }
    
    //SETTERS
    public void setNAsistencia(int nAsistencia){
        this.nAsistencia = nAsistencia;
    }
    
    public void setNFaltas(int nFaltas){
        this.nFaltas = nFaltas;
    }
    
    public void setNAtrasos(int nAtrasos){
        this.nAtrasos = nAtrasos;
    }
    
    public void setNRetiros(int nRetiros){
        this.nRetiros = nRetiros;
    }
    
    
    //MÉTODOS PROPIOS
    //Método para ver si la asistencia en tal fecha ya está registrada
    public boolean yaRegistrada(String fecha){ 
        return asistencia.get(fecha) != null;
    }
    
    //Método para elegir la asistencia del alumno (Presente / Ausente)
    public void modificar(String fecha, int opcion) throws IOException{
        String estado = "";
        if (opcion == 1){
            this.nAsistencia++; //Se aumenta Presente
            estado = "Presente";
        }
        else if (opcion == 2){
            this.nFaltas++;     //Se aumenta Ausente
            estado = "Ausente"; 
        }
        asistencia.put(fecha, estado);
    }
    
    //Método para modificar la asistencia del alumno en una fecha ya registrada
    public void modificar(String fecha, String nuevoEstado){ 
        String estadoAnterior = asistencia.get(fecha);
        if (estadoAnterior != null) {
            if (estadoAnterior.equalsIgnoreCase("Presente")) {
                this.nAsistencia--;
            } else if (estadoAnterior.equalsIgnoreCase("Ausente")) {
                this.nFaltas--;
            }
        }

        //En caso de cumplir los estándares
        if (nuevoEstado.equalsIgnoreCase("Atrasado") || 
            nuevoEstado.equalsIgnoreCase("Retirado") || 
            nuevoEstado.equalsIgnoreCase("Presente") || 
            nuevoEstado.equalsIgnoreCase("Ausente")) {

            //Se aumentará la estadística respectiva
            if (nuevoEstado.equalsIgnoreCase("Atrasado")) {
                this.nAtrasos++;
            } else if (nuevoEstado.equalsIgnoreCase("Retirado")) {
                this.nRetiros++;
            } else if (nuevoEstado.equalsIgnoreCase("Presente")) {
                this.nAsistencia++;
            } else if (nuevoEstado.equalsIgnoreCase("Ausente")) {
                this.nFaltas++;
            }

            //Se hará el cambio a nivel sistemático
            asistencia.remove(fecha, estadoAnterior);
            asistencia.put(fecha, nuevoEstado);
        }
    }
}