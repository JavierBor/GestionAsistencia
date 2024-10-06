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
                             "Asistencias: "+asist.getNAsistencia()+ "\n" +
                             "Faltas: "+asist.getNFaltas()+ "\n" +
                             "Atrasos: "+asist.getNAtrasos()+ "\n" +
                             "Retiros: "+asist.getNRetiros()+ "\n";
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
            int asistencias = alumno.getAsistencia().getNAsistencia();
            int totalDias = asistencias + alumno.getAsistencia().getNFaltas();

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
    
    public Alumno estaAlumno(String rut){
        Alumno alumnoActual;
        for (int i = 0 ; i < alumnos.size() ; i++) {
            alumnoActual = alumnos.get(i);
            if (rut.equalsIgnoreCase(alumnoActual.getRut())) {
                return alumnoActual;  // El alumno fue encontrado
            }
        }
        return null;
    }
    
    
    public void modAsistencia(String rut) throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        Alumno alumno = estaAlumno(rut); // Verifica si el alumno existe en el curso

        if (alumno != null) {
            String fecha = JOptionPane.showInputDialog("Ingrese la fecha actual (dd/mm/aaaa):");

            if (fecha != null) {
                // Verifica si la fecha ya está registrada
                if (!(alumno.getAsistencia().yaRegistrada(fecha))) {
                    JOptionPane.showMessageDialog(null, "La fecha ya está registrada. No se puede modificar la asistencia.", "Error!", JOptionPane.ERROR_MESSAGE);
                    return; // Salimos del método si la fecha ya está registrada
                }

                // Solicita el nuevo estado de asistencia
                String estado = JOptionPane.showInputDialog("Ingrese el nuevo estado (Presente/Ausente/Atrasado/Retirado)");

                if (estado != null && (estado.equalsIgnoreCase("Presente") ||
                        estado.equalsIgnoreCase("Ausente") ||
                        estado.equalsIgnoreCase("Atrasado") ||
                        estado.equalsIgnoreCase("Retirado"))) {

                    // Registra el nuevo estado
                    alumno.registrar(fecha, estado);
                    JOptionPane.showMessageDialog(null, "Asistencia modificada exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "Estado no válido. Solo se permite: Presente, Ausente, Atrasado o Retirado.", "Error!", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "La fecha no puede ser nula.", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró el alumno con RUT: " + rut, "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void modificar(int opcion){
        String rutAlum;
        boolean estaAlumno;

        switch(opcion){
            case 1:
                if (this.profesorJefe == null){
                    System.out.print("Ingrese el nombre del profesor: ");
                    String nombreProfe = JOptionPane.showInputDialog("Ingrese el nombre del profesor:");

                    System.out.print("Ingrese el correo del profesor: ");
                    String correoProfe = JOptionPane.showInputDialog("Ingrese el correo del profesor");
                    System.out.print("Ingrese el RUT del profesor: ");
                    String rutProfe = JOptionPane.showInputDialog("Ingrese el rut del profesor");
                    System.out.print("Ingrese la especialidad del profesor: ");
                    String especialidadProfe = JOptionPane.showInputDialog("Ingrese la especialidad del profesor");
                    Profesor profe = new Profesor(nombreProfe, correoProfe, rutProfe, especialidadProfe);
                    this.profesorJefe = profe;
                    JOptionPane.showMessageDialog(null, "El profesor fue asignado correctamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null, "El curso ya tiene asignado un profesor", "ERROR", JOptionPane.WARNING_MESSAGE);
                }
                break;

            case 2:
                if (this.profesorJefe != null){
                    this.profesorJefe = null;
                    
                    JOptionPane.showMessageDialog(null, "El profesor fue eliminado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    
                }
                else{
                    
                    JOptionPane.showMessageDialog(null, "El curso no tiene asignado un profesor", "ERROR", JOptionPane.WARNING_MESSAGE);
                    
                }
                break;

            case 3:
                System.out.print("Ingrese el RUT del alumno a ELIMINAR: ");
                rutAlum = JOptionPane.showInputDialog("Ingrese el rut del alumno");
                estaAlumno = false;
                for (int i = 0 ; i < this.alumnos.size() ; i++){
                    Alumno alum = this.alumnos.get(i);
                    if (rutAlum.equals(alum.getRut())){
                        estaAlumno = true;
                        this.alumnos.remove(i);
                        JOptionPane.showMessageDialog(null, "Se elimino correctamente el alumno", "Aviso", JOptionPane.WARNING_MESSAGE);
                    }
                }

                if (!estaAlumno){
                    System.out.println("-".repeat(50));
                    JOptionPane.showMessageDialog(null, "El alumno ingresado no existe en el curso", "Aviso", JOptionPane.WARNING_MESSAGE);
                    System.out.println("-".repeat(50));
                    System.out.println("");
                }   
                break;

        }


        System.out.println("-".repeat(50));
        System.out.println("Saliendo al menú principal...");
        System.out.println("-".repeat(50));
        System.out.println("");
    }
    
    
    public void modificarAlumno(int opcionAlum) throws AlumnoNoEncontradoException{
        String rutAlum;
        String nombreNuevo;
        String correoNuevo;
        int numTutorNuevo;
        
        System.out.print("Ingrese el RUT del alumno a modificar: ");
        rutAlum = JOptionPane.showInputDialog("Ingrese el rut del alumno a modificar");
        Alumno alumnoMod = estaAlumno(rutAlum);
        if (alumnoMod == null){ //Si el alumno no esta finaliza el metodo y muestra mensaje
            throw new AlumnoNoEncontradoException("El alumno que ingreso no se encuentra entre los registros");
        }
        switch(opcionAlum){
            case 1: //modificar nombre del alumno
                nombreNuevo = JOptionPane.showInputDialog("Ingrese nuevo nombre:");
                alumnoMod.setNombre(nombreNuevo);
                break;
            case 2: //modificar correo del alumno
                correoNuevo = JOptionPane.showInputDialog("Ingrese nuevo correo:");
                alumnoMod.setCorreo(correoNuevo);
                break;
            case 3: //modificar numero de telefono del tutor
                numTutorNuevo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese nuevo numero de telefono del tutor:"));
                alumnoMod.setNumTutor(numTutorNuevo);
                break;
                
                
        }
    }


        public void escribirArchivoAlumnos() {
        String filePath = "src\\main\\java\\com\\mycompany\\gestionasistencia\\listaAlumnos.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("-".repeat(60));
            writer.newLine();
            writer.write("LISTA DE ALUMNOS");
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
            // Mensaje de éxito utilizando JOptionPane
            JOptionPane.showMessageDialog(null, "Lista de alumnos escrita exitosamente en el archivo.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            // Mensaje de error utilizando JOptionPane
            JOptionPane.showMessageDialog(null, "Ocurrió un error al escribir en el archivo.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace(); // Puedes mantener esto si deseas registrar el error en la consola
        }
    }

    public void abrirArchivo() throws IOException {
        String filePath = "src\\main\\java\\com\\mycompany\\gestionasistencia\\listaAlumnos.txt";

        // Leer y mostrar contenido del archivo
        StringBuilder contenidoArchivo = new StringBuilder();
        String linea;
        try (BufferedReader archivo = new BufferedReader(new FileReader(filePath))) {
            while ((linea = archivo.readLine()) != null) {
                contenidoArchivo.append(linea).append("\n");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al leer el archivo.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Salimos del método si hay un error
        }

        // Mostrar contenido del archivo en un cuadro de diálogo
        JOptionPane.showMessageDialog(null, contenidoArchivo.toString(), "Contenido del Archivo", JOptionPane.INFORMATION_MESSAGE);

        // No eliminamos el archivo aquí. Solo mostramos el contenido.
    }


    public void eliminarArchivo(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            if (file.delete()) {
                JOptionPane.showMessageDialog(null,"Volviendo al menu principal", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar el archivo.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "El archivo no existe.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    
}

