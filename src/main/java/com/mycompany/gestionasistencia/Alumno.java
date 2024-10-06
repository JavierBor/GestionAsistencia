package com.mycompany.gestionasistencia;
import java.io.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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
    
    public Asistencia getAsistencia(){
        return asistencia;
    }
    
    //SETTERS
    public void setNumTutor(int numTutor){
        this.numTutor = numTutor;
    }
    
    public void registrar(String fecha) throws IOException {
        // Usar JOptionPane para mostrar información del alumno
        String mensaje = "RUT: " + this.rut + "\n" +
                         "Alumno: " + this.nombre + "\n";

        // Usar un cuadro de diálogo para que el usuario seleccione la asistencia
        String[] opciones = {"Presente", "Ausente"};
        int opcion = JOptionPane.showOptionDialog(null, mensaje, 
            "Registrar Asistencia", JOptionPane.DEFAULT_OPTION, 
            JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

        // Verificar si se canceló la acción
        if (opcion == JOptionPane.CLOSED_OPTION) {
            return; // Si el usuario cierra el cuadro, no se hace nada
        }

        // Asignar la opción de presente (1) o ausente (2)
        int registroOpcion = opcion + 1; // Convertir de 0-1 a 1-2

        // Mensaje de confirmación
        JOptionPane.showMessageDialog(null, "Registrado correctamente!");

        // Llamar al método modificar en el objeto asistencia
        asistencia.modificar(fecha, registroOpcion); 
    }
    
    // Especificar estado (Presente, Ausente, Atraso o Retiro)
    public void registrar(String fecha, String estado){ 
        asistencia.modificar(fecha, estado);
    }
    

    // Muestra datos de la asistencia del alumno
    @Override
    public void agregarInformacion(DefaultTableModel modelo){
        modelo.addRow(new Object[]{nombre, rut, correo, numTutor, 
                      asistencia.getAsists(), asistencia.getFaltas(), asistencia.getAtrasos(), asistencia.getRetiros()});
    }
}
