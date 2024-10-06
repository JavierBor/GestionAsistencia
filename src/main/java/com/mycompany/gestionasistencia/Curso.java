package com.mycompany.gestionasistencia;
import java.awt.Dimension;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Curso {
    //Atributos y constructor
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
        if (nuevoAlumno == null){ //Se creará un Objeto Alumno con sus atributos ingresados
            nuevoAlumno = new Alumno(nombre, correo, rut, numTutor);
            alumnos.add(nuevoAlumno); //Se agregará a la lista del curso
        }
        else{ //En caso de estar repetído, mostraremos este mensaje
            throw new AlumnoRepetidoException("El alumno ya fue registrado anteriormente");
        }
    }
    
    //Para pasar la lista de todo el curso
    public void modAsistencia() throws IOException {
        Alumno alumno;
        int fechaVista = 0; //Servirá para condicionales
        String fecha = JOptionPane.showInputDialog("Ingrese la fecha actual (dd/mm/aaaa):");

        if (fecha != null && !fecha.isEmpty()) {
            for (int i = 0; i < alumnos.size(); i++) {
                alumno = alumnos.get(i); //Conseguiremos los alumnos uno por uno
                if (alumno.getAsistencia().yaRegistrada(fecha)){ //En caso de existir la fecha, mostraremos esto
                    JOptionPane.showMessageDialog(null, "Fecha ya registrada.", "Error!", JOptionPane.ERROR_MESSAGE);  
                    fechaVista = 1;
                    break;
                }         
                alumno.registrar(fecha); //En caso de continuar el ciclo, se registrará su asistencia uno por uno
            }

            if (fechaVista == 0){ //Mostraremos el mensaje de éxito
                JOptionPane.showMessageDialog(null, "Asistencia registrada para todos los alumnos.");
            }
        } else { //Mensaje para cuando la fecha no es valida o ya existe
            JOptionPane.showMessageDialog(null, "Fecha no válida. Por favor, intente de nuevo.");
        }
    }   
    
    //Mostrará los datos de cada uno de los alumnos del curso
    public JTable mostrarRegistroAlumno(JTable listado){
        DefaultTableModel modelo = (DefaultTableModel)listado.getModel();
        for (int i = 0 ; i < alumnos.size() ; i++){ //Se agregarán todos los alumnos del curso
            Alumno alum = (Alumno) alumnos.get(i);
            alum.agregarInformacion(modelo); //Método Override de clase padre
        }    
        return listado;
    }
    
    //Mostrará datos del alumno individualmente a través de su rut
    public void mostrarRegistroAlumno(String rutAlumno){
        Alumno alumno = (Alumno) this.getAlumno(rutAlumno);                           
        if (alumno != null){ //Se agregarán los atributos del alumno y sus estadísticas              
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
        else{ //En caso de no existir, mostraremos el siguiente mensaje
            JOptionPane.showMessageDialog(null, "RUT no encontrado o invalido.", "Error!", JOptionPane.ERROR_MESSAGE);
        } 
    }
    
    //Mostrará los datos del profesor en los registros del curso
    public JTable mostrarDatosProfe(JTable profe, JLabel label){
        DefaultTableModel modelo = (DefaultTableModel)profe.getModel(); //Conseguimos el modelo de los datos de JTable
        if (profesorJefe != null){
            profesorJefe.agregarInformacion(modelo); //Método Override de clase padre
        }
        else{
            label.setText("Profesor a cargo (No asignado)"); //En caso de no habre un profesor, ponemos este mensajito
        }
        return profe; //Retornamos la tabla, ya esté llena o simplemente se mantiene vacía
    }
    
    //Mostrará los alumnos que no cumplan el requisito mínimo de asistencia <70%
    public JTable mostrarAlumnosEnRiesgo(JTable listadoRiesgo, JLabel tituloCurso) {
        DefaultTableModel modelo = (DefaultTableModel)listadoRiesgo.getModel();
        boolean hayAlumnosEnRiesgo = false;
        for (Alumno alumno : alumnos){ //Se recorrerá la lista de alumnos y se sacará su porcentaje
            int asistencias = alumno.getAsistencia().getNAsistencia();
            int totalDias = asistencias + alumno.getAsistencia().getNFaltas();

            if (totalDias > 0){ //Solo valido para 1 o más días de asistencia
                double porcentajeAsistencia = (asistencias / (double) totalDias) * 100;
                tituloCurso.setText("Alumnos en riesgo (Días impartidos: "+totalDias+")");
                if (porcentajeAsistencia < 70){
                    hayAlumnosEnRiesgo = true;
                    modelo.addRow(new Object[]{alumno.getNombre(), alumno.getRut(), alumno.getCorreo(), alumno.getNumTutor(), (int)porcentajeAsistencia+"%"});
                }
            }
        }
        
        //En caso de no haber alumnos en riesgo, mostraremos el siguiente mensaje
        if (!hayAlumnosEnRiesgo){
            String mensaje = "No hay alumnos en riesgo registrados.";
            JOptionPane.showMessageDialog(null, mensaje, "", JOptionPane.INFORMATION_MESSAGE);
        }
        
        return listadoRiesgo;
    }

    //Función para modificar caracteristicas de un curso
    public void modificarCurso(int opcion){
        String rutAlum;
        boolean estaAlumno;

        switch(opcion){
            case 1: //Asignar un profesor jefe al curso (Preguntando por sus atributos)
                if (this.profesorJefe == null){
                    String nombreProfe = JOptionPane.showInputDialog("Ingrese el nombre del profesor:");
                    if (nombreProfe == null) return;
                    if (!nombreProfe.isEmpty()){
                        String correoProfe = JOptionPane.showInputDialog("Ingrese el correo del profesor");
                        if (correoProfe == null) return;
                        if (!correoProfe.isEmpty()){
                            String rutProfe = JOptionPane.showInputDialog("Ingrese el rut del profesor");
                            if (rutProfe == null) return;
                            if (!rutProfe.isEmpty()){
                                String especialidadProfe = JOptionPane.showInputDialog("Ingrese la especialidad del profesor");
                                if (especialidadProfe == null) return;
                                if (!especialidadProfe.isEmpty()){
                                    Profesor profe = new Profesor(nombreProfe, correoProfe, rutProfe, especialidadProfe);
                                    this.profesorJefe = profe;
                                    JOptionPane.showMessageDialog(null, "El profesor fue asignado correctamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
                                }
                                else{
                                    JOptionPane.showMessageDialog(null, "Ingrese una especialidad valida.", "ERROR", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "Ingrese un RUT valido.", "ERROR", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Ingrese un correo valido.", "ERROR", JOptionPane.ERROR_MESSAGE);
                        }  
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Ingrese un nombre valido.", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "El curso ya tiene asignado un profesor", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
                break;

            case 2: //Eliminar profesor del curso
                if (this.profesorJefe != null){
                    this.profesorJefe = null; //En caso de haber un profesor, se igualará a null
                    JOptionPane.showMessageDialog(null, "El profesor fue eliminado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);     
                }
                else{
                    JOptionPane.showMessageDialog(null, "El curso no tiene asignado un profesor.", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
                break;

            case 3: //Eliminar alumno del curso a través del RUT
                rutAlum = JOptionPane.showInputDialog("Ingrese el rut del alumno");
                if (rutAlum == null) return;
                estaAlumno = false;
                for (int i = 0 ; i < this.alumnos.size() ; i++){ //Se recorrerá para encontrar al alumno
                    Alumno alum = this.alumnos.get(i);
                    if (rutAlum.equals(alum.getRut())){
                        estaAlumno = true;
                        this.alumnos.remove(i); //Se eliminará por completo el alumno
                        JOptionPane.showMessageDialog(null, "Se elimino correctamente el alumno", "Aviso", JOptionPane.WARNING_MESSAGE);
                    }
                }

                if (!estaAlumno){ //En caso de que no exista, mostraremos un mensaje
                    JOptionPane.showMessageDialog(null, "El alumno ingresado no existe en el curso", "Aviso", JOptionPane.WARNING_MESSAGE);
                }   
                break;

            case 4: //Agregar un alumno nuevo (Preguntando sus atributos)
                try{
                    String nombre = JOptionPane.showInputDialog("Ingrese el nombre del alumno:").trim();
                    if (nombre == null) return;
                    if (!nombre.isEmpty()){
                        String correo = JOptionPane.showInputDialog("Ingrese el correo del alumno:").trim();
                        if (correo == null) return;
                        if (!correo.isEmpty()){
                            String rut = JOptionPane.showInputDialog("Ingrese el RUT del alumno:").trim();
                            if (rut == null) return;
                            if (!rut.isEmpty()){
                                String numTutorString = JOptionPane.showInputDialog("Ingrese el teléfono del apoderado:").trim();
                                numTutorString = numTutorString.replaceAll("\\s+", "");
                                if (numTutorString == null) return;
                                if (numTutorString.length() == 9){
                                    try {
                                        int numTutor = Integer.parseInt(numTutorString);
                                        this.agregarAlumno(nombre, correo, rut, numTutor); // Se agrega el alumno
                                        JOptionPane.showMessageDialog(null, "Alumno agregado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                                    } catch (NumberFormatException e) {
                                        JOptionPane.showMessageDialog(null, "Número no válido.", "ERROR", JOptionPane.ERROR_MESSAGE);
                                    }
                                }
                                else{
                                    JOptionPane.showMessageDialog(null, "El número debe tener 9 dígitos.", "ERROR", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "RUT no valido.", "ERROR", JOptionPane.ERROR_MESSAGE);
                            }                 
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Correo no valido.", "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Nombre no valido.", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } 
                //Si el alumno a ingresar tiene el mismo rut que alguno del curso salta un mensaje y no se ingresa
                catch (AlumnoRepetidoException e){ 
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;
        }
    }
    
    //MÉTODOS PARA EL MANEJO CORRECTO DEL ARCHIVO
    //Encargado de escribir el archivo con los alumnos del curso
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
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al escribir en el archivo.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    //Encargado de crear la ventana para mostrar el archivo
    public void abrirArchivo() throws IOException {
        String filePath = "src\\main\\java\\com\\mycompany\\gestionasistencia\\listaAlumnos.txt";

        //Leer y mostrar contenido del archivo
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

        //Crear un JTextArea con el contenido del archivo
        JTextArea textArea = new JTextArea(contenidoArchivo.toString());
        textArea.setEditable(false);     //Evitar edición del texto
        textArea.setLineWrap(true);      // Ajustar líneas largas
        textArea.setWrapStyleWord(true); // Ajustar por palabras completas

        //Crear un JScrollPane para hacer el JTextArea desplazable
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(500, 400)); // Definir el tamaño de la ventana

        // Mostrar el JScrollPane en un JOptionPane
        JOptionPane.showMessageDialog(null, scrollPane, "Contenido del Archivo", JOptionPane.INFORMATION_MESSAGE);
    }

    //Encargado de eliminar el archivo una vez usado
    public void eliminarArchivo(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            if (file.delete()) {
                JOptionPane.showMessageDialog(null,"Volviendo al menu principal.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar el archivo.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "El archivo no existe.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    
}

