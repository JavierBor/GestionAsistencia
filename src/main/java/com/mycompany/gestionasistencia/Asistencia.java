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
    
    public int getAsists(){
        return nAsistencia;
    }
    
    public int getFaltas(){
        return nFaltas;
    }
    
    public int getAtrasos(){
        return nAtrasos;
    }
    
    public int getRetiros(){
        return nRetiros;
    }
    
    public String getAsistencia(String fecha){
        if (asistencia.get(fecha) == null){
            asistencia.put(fecha, "No registrada.");
        }
        return asistencia.get(fecha);
    }
    
    public void modificar(String fecha, int opcion) throws IOException{
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
    
    public void modificar(String fecha, String nuevoEstado) {
  
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

            System.out.println("Estado no válido. Solo se permite: Presente, Ausente, Atrasado o Retirado.");
        }
    }

    public String obtenerInfo(String fecha){
        return asistencia.get(fecha);
    }
    
    public void mostrarRegistros(){
        System.out.println("Estadísticas de Asistencia:");
        System.out.println("Presente:" + this.nAsistencia);
        System.out.println("Ausente:" + this.nFaltas);
        System.out.println("Atrasos:" + this.nAtrasos);
        System.out.println("Retiros:" + this.nRetiros);
    }
}