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
    
    public void modificar(String fecha) throws IOException{
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ingrese Presente o Ausente");
        String estado = lector.readLine();
        if (estado.equals("Presente")){
            this.nAsistencia++;
        }
        else if (estado.equals("Ausente")){
            this.nFaltas++;
        }
        asistencia.put(fecha, estado);
    }
    
    public void modificar(String fecha, String nuevoEstado){
        String estadoAnterior = asistencia.get(fecha);
        if (estadoAnterior.equals("Presente")){
            this.nAsistencia--;
        }
        else if (estadoAnterior.equals("Ausente")){
            this.nFaltas--;
        }
        
        if (nuevoEstado.equals("Atrasado")){
            this.nAtrasos++;
        }
        else if (nuevoEstado.equals("Retirado")){
            this.nRetiros++;
        }
        asistencia.remove(fecha, estadoAnterior);
        asistencia.put(fecha, nuevoEstado);
    }
    
    public String obtenerInfo(String fecha){
        return asistencia.get(fecha);
    }
    
    public void mostrarRegistros(){
        System.out.println("Presente:" + this.nAsistencia);
        System.out.println("Ausente:" + this.nFaltas);
        System.out.println("Atrasos:" + this.nAtrasos);
        System.out.println("Retiros:" + this.nRetiros);
    }
}
