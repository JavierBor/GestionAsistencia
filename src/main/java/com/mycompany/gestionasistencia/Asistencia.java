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
    
    //getters
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
    
    // setters
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
    
    
    // metodos
    public boolean yaRegistrada(String fecha){ // metodo para saber si ya se paso la asistencia en algun dua en especifico
        return asistencia.get(fecha) != null;
    }
    
    public void modificar(String fecha, int opcion) throws IOException{ //marcar presente o ausente al pasar lista
        String estado = "";
        if (opcion == 1){
            this.nAsistencia++;
            estado = "Presente";
        }
        else if (opcion == 2){
            this.nFaltas++;
            estado = "Ausente";
        }
        asistencia.put(fecha, estado);
    }
    
    public void modificar(String fecha, String nuevoEstado) { //modificar la asistencia de un dia ya registrado
  
        String estadoAnterior = asistencia.get(fecha);
        if (estadoAnterior != null) {
            if (estadoAnterior.equalsIgnoreCase("Presente")) {
                this.nAsistencia--;
            } else if (estadoAnterior.equalsIgnoreCase("Ausente")) {
                this.nFaltas--;
            }
        }

        if (nuevoEstado.equalsIgnoreCase("Atrasado") || 
            nuevoEstado.equalsIgnoreCase("Retirado") || 
            nuevoEstado.equalsIgnoreCase("Presente") || 
            nuevoEstado.equalsIgnoreCase("Ausente")) {

           
            if (nuevoEstado.equalsIgnoreCase("Atrasado")) {
                this.nAtrasos++;
            } else if (nuevoEstado.equalsIgnoreCase("Retirado")) {
                this.nRetiros++;
            } else if (nuevoEstado.equalsIgnoreCase("Presente")) {
                this.nAsistencia++;
            } else if (nuevoEstado.equalsIgnoreCase("Ausente")) {
                this.nFaltas++;
            }

 
            asistencia.remove(fecha, estadoAnterior);
            asistencia.put(fecha, nuevoEstado);

        } else {

            //System.out.println("Estado no válido. Solo se permite: Presente, Ausente, Atrasado o Retirado.");
        }
    }

    public String obtenerInfo(String fecha){ //Saber el estado de un alumno en un dia específico
        return asistencia.get(fecha);
    }
}