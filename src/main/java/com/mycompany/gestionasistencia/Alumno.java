package com.mycompany.gestionasistencia;
import java.io.*;

public class Alumno extends MiembroEstablecimiento{
    private int numTutor;
    private Asistencia asistencia;
    
    public Alumno(String nombre, String correo, String rut, int numTutor){
        super(nombre, correo, rut);
        this.numTutor = numTutor;
        asistencia = new Asistencia();
    }
    
    //GETTERS
    public int getNumTutor(){
        return numTutor;
    }
    
    //SETTERS
    public void setNumTutor(int numTutor){
        this.numTutor = numTutor;
    }
    
    //MÉTODOS
    // (1) Presente (2) Ausente
    public void registrar(String fecha) throws IOException{
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        int opcion;
        do {
            System.out.println("-".repeat(60));
            System.out.println("RUT: "+this.rut);
            System.out.println("Alumno: "+this.nombre);
            System.out.println("1. Presente");
            System.out.println("2. Ausente");
            System.out.print("Ingrese su opción: ");
            opcion = Integer.parseInt(lector.readLine());
            System.out.println("-".repeat(60));
            
            
            if (opcion != 1 && opcion != 2){
                System.out.println("Solo puede ingresar Presente (1) o Ausente (2). Intente denuevo...");
            }
            else{
                System.out.println("Registrado correctamente!");
            }
        } while (opcion != 1 && opcion != 2);
        asistencia.modificar(fecha, opcion);
    }
    
    // Especificar estado (Presente, Ausente, Atraso o Retiro)
    public void registrar(String fecha, String estado){
        asistencia.modificar(fecha, estado);
    }
    
    //Muestra datos de la asistencia del alumno
    @Override
    public void mostrarInformacion(){
        System.out.println("RUT: "+rut);
        System.out.println("Nombre Alumno: "+nombre);
        System.out.println("Telefono Apoderado: "+numTutor);
        System.out.println("Correo Institucional: "+correo);
        System.out.println("");
        asistencia.mostrarRegistros();
    }
}
