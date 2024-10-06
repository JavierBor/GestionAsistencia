package com.mycompany.gestionasistencia;

import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class Curso {
    private String nombreCurso;
    private List<Alumno> alumnos;
    private Profesor profesorJefe;
    
    public Curso(String curso){
        this.nombreCurso = curso;
        alumnos = new ArrayList<Alumno>();
        profesorJefe = null;
    }
    
    //Obtener el nombre del curso
    public String getNombreCurso(){
        return nombreCurso;
    }
    
    //Obtener el profesor encargado
    public Profesor getProfesor(){
        return profesorJefe;
    }
    
    //Obtener un alumno en base a su rut
    public Alumno getAlumno(String rut){
        for (int i = 0 ; i < alumnos.size() ; i++){
            Alumno alum = alumnos.get(i);
            if (alum.getRut().equals(rut)){
                return alum;
            }
        }
        return null;
    }
    
    //Asignar nombre al curso
    public void setNombreCurso(String nombreCurso){
        this.nombreCurso = nombreCurso;
    }
    
    //Asignar un profesor jefe
    public void setProfesor(Profesor profe){
        this.profesorJefe = profe;
    }
    
    //Agregar a un alumno nuevo
    public void agregarAlumno(String nombre, String correo, String rut, int numTutor) throws AlumnoRepetidoException{
        Alumno nuevoAlumno = getAlumno(rut);
        if (nuevoAlumno == null){
            nuevoAlumno = new Alumno(nombre, correo, rut, numTutor);
            alumnos.add(nuevoAlumno);
        }
        else{
            throw new AlumnoRepetidoException("El alumno ya fue registrado anteriormente");
        }
    }
    
    //Para pasar lista normalmente
    public void modAsistencia() throws IOException {
        Alumno alumno;
        int fechaVista = 0; //Servirá para condicionales
        String fecha = JOptionPane.showInputDialog("Ingrese la fecha actual (dd/mm/aaaa):");

        if (fecha != null && !fecha.isEmpty()) {
            for (int i = 0; i < alumnos.size(); i++) {
                alumno = alumnos.get(i);
                if (alumno.getAsistencia().yaRegistrada(fecha)){
                    JOptionPane.showMessageDialog(null, "Fecha ya registrada.", "Error!", JOptionPane.ERROR_MESSAGE);  
                    fechaVista = 1;
                    break;
                }         
                alumno.registrar(fecha);
            }

            if (fechaVista == 0){
                JOptionPane.showMessageDialog(null, "Asistencia registrada para todos los alumnos.");
            }
        } else {
            // Manejar el caso en que no se ingresa una fecha válida
            JOptionPane.showMessageDialog(null, "Fecha no válida. Por favor, intente de nuevo.");
        }
    }   
    
    //Mostrará los datos de cada uno de los alumnos del curso
    public JTable mostrarRegistroAlumno(JTable listado){
        DefaultTableModel modelo = (DefaultTableModel)listado.getModel();
        for (int i = 0 ; i < alumnos.size() ; i++){
            Alumno alum = (Alumno) alumnos.get(i);
            alum.agregarInformacion(modelo);
        }    
        return listado;
    }
    
    //Mostrará datos del alumno individualmente a través de su rut
    public void mostrarRegistroAlumno(String rutAlumno){
        Alumno alumno = (Alumno) this.getAlumno(rutAlumno);                           
        if (alumno != null){                               
            Asistencia asist = alumno.getAsistencia();
            String mensaje = "Nombre: "+alumno.getNombre() + "\n" +
                             "RUT: "+alumno.getRut() + "\n" +
                             "Correo: "+alumno.getCorreo() + "\n" +
                             "Cel. Apoderado: "+alumno.getNumTutor()+ "\n" +
                             "Asistencias: "+asist.getAsists()+ "\n" +
                             "Faltas: "+asist.getFaltas()+ "\n" +
                             "Atrasos: "+asist.getAtrasos()+ "\n" +
                             "Retiros: "+asist.getRetiros()+ "\n";
            JOptionPane.showMessageDialog(null, mensaje, "Información del Alumno", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, "RUT no existe!", "Error!", JOptionPane.ERROR_MESSAGE);
        } 
    }
    
    //Mostrará los datos del profesor en los registros del curso
    public JTable mostrarDatosProfe(JTable profe, JLabel label){
        DefaultTableModel modelo = (DefaultTableModel)profe.getModel(); //Conseguimos el modelo de los datos de JTable
        if (profesorJefe != null){
            profesorJefe.agregarInformacion(modelo); //Con esto podríamos mostrar su información
        }
        else{
            label.setText("Profesor a cargo (No asignado)"); //En caso de no habre un profesor, ponemos este mensajito
        }
        return profe; //Retornamos la tabla, ya esté llena o simplemente se mantiene vacía
    }
    
    //Mostrará los alumnos que no cumplan el requisito mínimo de asistencia <70%
    public JTable mostrarAlumnosEnRiesgo(JTable listadoRiesgo) {
        DefaultTableModel modelo = (DefaultTableModel)listadoRiesgo.getModel();
        boolean hayAlumnosEnRiesgo = false;
        for (Alumno alumno : alumnos) {
            int asistencias = alumno.getAsistencia().getAsists();
            int totalDias = asistencias + alumno.getAsistencia().getFaltas();

            if (totalDias > 0) {
                double porcentajeAsistencia = (asistencias / (double) totalDias) * 100;
                if (porcentajeAsistencia < 70) {
                    hayAlumnosEnRiesgo = true;
                    modelo.addRow(new Object[]{alumno.getNombre(), alumno.getRut(), alumno.getCorreo(), alumno.getNumTutor(), (int)porcentajeAsistencia+"%"});
                }
            }
        }
        
        //En caso de no haber alumnos, mostraremos el siguiente mensaje:
        if (!hayAlumnosEnRiesgo){
            String mensaje = "No hay alumnos en riesgo registrados!";
            JOptionPane.showMessageDialog(null, mensaje, "", JOptionPane.INFORMATION_MESSAGE);
        }
        
        return listadoRiesgo;
    }
    
    
    
    //DE AQUÍ EN ADELANTE SE DEBEN CAMBIAR ESTAS FUNCIONES Y ADAPTARLAS A VENTANAS
    
    public void modAsistencia(String rut) throws IOException{
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        Alumno alumno = getAlumno(rut);
  
        if (alumno != null){
            String fecha;
            String estado;
            
            System.out.print("Ingrese la fecha que quiere modificar (dd/mm/aaaa): ");
            fecha = lector.readLine();
            
            System.out.print("Ingrese el nuevo estado (Presente/Ausente/Atrasado/Retirado): ");
            estado = lector.readLine();
            alumno.registrar(fecha, estado);
        }
        else{
            System.out.println("No se encontro el alumno");
        }
    }
    
    public void modificar() throws IOException{
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        int opcion = 0;
        String rutAlum;
        boolean estaAlumno;
        
        do {
            switch(opcion){
                case 1:
                    if (this.profesorJefe == null){
                        System.out.print("Ingrese el nombre del profesor: ");
                        String nombreProfe = lector.readLine();
                        System.out.print("Ingrese el correo del profesor: ");
                        String correoProfe = lector.readLine();
                        System.out.print("Ingrese el RUT del profesor: ");
                        String rutProfe = lector.readLine();
                        System.out.print("Ingrese la especialidad del profesor: ");
                        String especialidadProfe = lector.readLine();
                        Profesor profe = new Profesor(nombreProfe, correoProfe, rutProfe, especialidadProfe);
                        this.setProfesor(profe);
                    }
                    else{
                        System.out.println("-".repeat(50));
                        System.out.println("Ya hay un profesor asignado en este curso!");
                        System.out.println("-".repeat(50));
                    }
                    break;
                    
                case 2:
                    if (this.profesorJefe != null){
                        this.profesorJefe = null;
                        System.out.println("-".repeat(50));
                        System.out.println("Profesor eliminado correctamente.");
                        System.out.println("-".repeat(50));
                    }
                    else{
                        System.out.println("-".repeat(50));
                        System.out.println("No hay un profesor asignado.");
                        System.out.println("-".repeat(50));
                    }
                    break;
                    
                case 3:
                    System.out.print("Ingrese el RUT del alumno a modificar: ");
                    rutAlum = lector.readLine();
                    int opcionAlum = 0;
                    estaAlumno = false;
                    for (int i = 0 ; i < this.alumnos.size() ; i++){
                        Alumno alum = this.alumnos.get(i);
                        if (rutAlum.equals(alum.getRut())){
                            estaAlumno = true;
                            do {
                                boolean validInput = false;
                                System.out.println("1. Modificar nombre.");
                                System.out.println("2. Modificar RUT.");
                                System.out.println("3. Modificar correo.");
                                System.out.println("4. Modificar teléfono de apoderado.");
                                System.out.println("5. Volver.");
  
                                while (!validInput) {
                                    try {
                                        //El usuario ingresa la opcion que requiera
                                        System.out.print("Ingrese su opción: ");
                                        opcionAlum = Integer.parseInt(lector.readLine());
                                        
                                        // Se comprueba que sea una opcion valida
                                        if (opcionAlum < 1 || opcionAlum > 5) {
                                            System.out.println("Opción no válida. Por favor, ingrese un número entre 1 y 5.");
                                        } else {
                                            validInput = true;  
                                        }
                                    } catch (NumberFormatException e) {
                                        System.out.println("Entrada no válida. Por favor, ingrese un número entero.");
                                    }
                                }
                                
                                switch(opcionAlum){
                                    case 1:
                                        System.out.print("Ingrese el nuevo nombre: ");
                                        String nuevoNombre = lector.readLine();
                                        alum.setNombre(nuevoNombre);
                                        System.out.println("-".repeat(50));
                                        System.out.println("Nombre modificado correctamente!");
                                        System.out.println("-".repeat(50));
                                        System.out.println("");
                                        break;
                                    
                                    case 2:
                                        System.out.print("Ingrese el nuevo RUT: ");
                                        String nuevoRut = lector.readLine();
                                        alum.setRut(nuevoRut);
                                        System.out.println("-".repeat(50));
                                        System.out.println("Rut modificado correctamente!");
                                        System.out.println("-".repeat(50));
                                        System.out.println("");
                                        break;
                                        
                                    case 3:
                                        System.out.print("Ingrese el nuevo correo: ");
                                        String nuevoCorreo = lector.readLine();
                                        alum.setCorreo(nuevoCorreo);
                                        System.out.println("-".repeat(50));
                                        System.out.println("Correo modificado correctamente!");
                                        System.out.println("-".repeat(50));
                                        System.out.println("");
                                        break;
                                        
                                    case 4:
                                        System.out.print("Ingrese el nuevo teléfono: ");
                                        int nuevoTelefono = Integer.parseInt(lector.readLine());
                                        alum.setNumTutor(nuevoTelefono);
                                        System.out.println("-".repeat(50));
                                        System.out.println("Teléfono de apoderado modificado correctamente!");
                                        System.out.println("-".repeat(50));
                                        System.out.println("");
                                        break;
                                }
                            } while (opcionAlum != 5);
                            System.out.println("-".repeat(50));
                            System.out.println("Volviendo a menú de curso...");
                            System.out.println("-".repeat(50));
                            System.out.println("");
                            break;
                        }
                    }
                    
                    if (!estaAlumno){
                        System.out.println("-".repeat(50));
                        System.out.println("El RUT ingresado no existe.");
                        System.out.println("-".repeat(50));
                        System.out.println("");
                    }
                    break;
 
                case 4:
                    System.out.print("Ingrese el RUT del alumno a ELIMINAR: ");
                    rutAlum = lector.readLine();
                    estaAlumno = false;
                    for (int i = 0 ; i < this.alumnos.size() ; i++){
                        Alumno alum = this.alumnos.get(i);
                        if (rutAlum.equals(alum.getRut())){
                            estaAlumno = true;
                            this.alumnos.remove(i);
                            System.out.println("-".repeat(50));
                            System.out.println("Alumno eliminado correctamente!");
                            System.out.println("-".repeat(50));
                            System.out.println("");
                        }
                    }
                    
                    if (!estaAlumno){
                        System.out.println("-".repeat(50));
                        System.out.println("El RUT ingresado no existe.");
                        System.out.println("-".repeat(50));
                        System.out.println("");
                    }   
                    break;
                    
            }
            
        } while (opcion != 5);
        System.out.println("-".repeat(50));
        System.out.println("Saliendo al menú principal...");
        System.out.println("-".repeat(50));
        System.out.println("");      
        }


    public void escribirArchivoAlumnos() {
        String filePath = "src\\main\\java\\com\\mycompany\\gestionasistencia\\listaAlumnos.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("-".repeat(60));
            writer.newLine();
            writer.write("LISTA DE ALUMNOS" );
            writer.newLine();
            writer.write("-".repeat(60));
            writer.newLine();
            for (Alumno alumno : this.alumnos) {
                writer.write("Nombre: " + alumno.getNombre());
                writer.newLine();
                writer.write("RUT: " + alumno.getRut());
                writer.newLine();
                writer.write("Correo: " + alumno.getCorreo());
                writer.newLine();
                writer.write("Teléfono Apoderado: " + alumno.getNumTutor());
                writer.newLine();
                writer.write("-".repeat(60));
                writer.newLine();
            }
            System.out.println("Lista de alumnos escrita exitosamente en el archivo.");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al escribir en el archivo.");
            e.printStackTrace();
        }
    }

    public void abrirArchivo(BufferedReader lector) throws IOException {
        String filePath = "src\\main\\java\\com\\mycompany\\gestionasistencia\\listaAlumnos.txt";
        boolean dentroArchivo = true;
        while (dentroArchivo) {
            System.out.println("\nArchivo abierto para el curso: " + this.nombreCurso);
            System.out.println("1. Volver al menú principal y eliminar archivo");
            System.out.print("Elija una opción: ");

            int opcion = Integer.parseInt(lector.readLine());

            if (opcion == 1) {
                this.eliminarArchivo(filePath); // Llamada al método eliminar
                dentroArchivo = false;
            } else {
                System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }
    }
    String filePath = "src\\main\\java\\com\\mycompany\\gestionasistencia\\listaAlumnos.txt";

    public void eliminarArchivo(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("Archivo eliminado exitosamente.");
            } else {
                System.out.println("No se pudo eliminar el archivo.");
            }
        } else {
            System.out.println("El archivo no existe.");
        }
    }

    
}

