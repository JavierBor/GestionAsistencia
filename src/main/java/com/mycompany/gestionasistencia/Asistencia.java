package com.mycompany.gestionasistencia;
import java.util.*;

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
    
    //Terminar Métodos
    
}
