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
    
    //Para pasar lista normalmente
    public void registrar(String fecha) throws IOException {
        //Mostraremos los datos del alumno en un mensajito
        String mensaje = "RUT: " + this.rut + "\n" +
                         "Alumno: " + this.nombre + "\n";

        //Las opciones para que el usuario elija
        String[] opciones = {"Presente", "Ausente"};
        int opcion;

        //Mantendremos la ventana abierta hasta que se seleccione una opción
        //Se hará para evitar NO registrar a un alumno correctamente
        do{
            //Mostraremos las opciones validas
            opcion = JOptionPane.showOptionDialog(null, mensaje, 
                     "Registrar Asistencia", JOptionPane.DEFAULT_OPTION, 
                     JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

            //Verificamos si el usuario presionó la 'X' para cerrar
            if (opcion == JOptionPane.CLOSED_OPTION){
                JOptionPane.showMessageDialog(null, "Debe seleccionar una opción para continuar.", "Advertencia!", JOptionPane.WARNING_MESSAGE);
            }
        } while (opcion == JOptionPane.CLOSED_OPTION);

        
        //Asignar la opción de presente (1) o ausente (2)
        int registroOpcion = opcion + 1; //Convertir de 0-1 a 1-2

        //Mensaje de confirmación
        JOptionPane.showMessageDialog(null, "Registrado correctamente!");

        //Llamar al método modificar en el objeto asistencia
        asistencia.modificar(fecha, registroOpcion);
    }
    
    //Modificar a estado especifico (Presente, Ausente, Atraso o Retiro)
    public void registrar(String fecha, String estado){ 
        asistencia.modificar(fecha, estado);
    }
    

    // Muestra datos de la asistencia del alumno
    @Override
    public void agregarInformacion(DefaultTableModel modelo){
        modelo.addRow(new Object[]{nombre, rut, correo, numTutor, 
                      asistencia.getNAsistencia(), asistencia.getNFaltas(), asistencia.getNAtrasos(), asistencia.getNRetiros()});
    }
}
