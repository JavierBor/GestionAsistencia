package com.mycompany.gestionasistencia;

import java.io.*;
import java.util.*;

public class Curso {
    private String nombreCurso;
    private List<Alumno> alumnos;
    private Profesor profesorJefe; //Pendiente (clapi)
    
    public Curso(String curso){
        this.nombreCurso = curso;
        alumnos = new ArrayList<Alumno>();
        profesorJefe = null;
    }
    
    public String getNombreCurso(){
        return nombreCurso;
    }
    public void setNombreCurso(String nombreCurso){
        this.nombreCurso = nombreCurso;
    }
    
    public void agregarAlumno(String nombre, String correo, String rut, int codigo, int numTutor) throws AlumnoRepetidoException{
        Alumno nuevoAlumno = estaAlumno(rut);
        if (nuevoAlumno == null){
            nuevoAlumno = new Alumno(nombre, correo, rut, numTutor);
            alumnos.add(nuevoAlumno);
        }
        else{
            throw new AlumnoRepetidoException("El alumno ya fue registrado anteriormente");
        }
    }
    
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

    public void mostrarRegistro(){
        Alumno alumno;
        if (alumnos != null) {
            System.out.println("-".repeat(60));
            for (int i = 0 ; i < alumnos.size() ; i++) {
                alumno = alumnos.get(i);
                alumno.mostrarInformacion();
                System.out.println("-".repeat(60));
                //System.out.println("");
            }
        }
    }
    
    public void mostrarRegistro(String rut) throws AlumnoNoEncontradoException{
        Alumno alumno = estaAlumno(rut);
        if (alumno != null){
            System.out.println("-".repeat(60));
            alumno.mostrarInformacion();
            System.out.println("-".repeat(60));
        }
        else{
            throw new AlumnoNoEncontradoException("El RUT ingresado no existe.");
        }
    }
    // metodo para mostrar los alumnos en riesgo
    public void mostrarAlumnosEnRiesgo() {
        boolean hayAlumnosEnRiesgo = false;
        System.out.println("Alumnos en Situación de Riesgo (Asistencia < 70%):");
        System.out.println("-".repeat(60));

        for (Alumno alumno : alumnos) {
            int asistencias = alumno.getAsistencia().getAsists();
            int totalDias = asistencias + alumno.getAsistencia().getFaltas();

            if (totalDias > 0) {
                double porcentajeAsistencia = (asistencias / (double) totalDias) * 100;
                if (porcentajeAsistencia < 70) {
                    hayAlumnosEnRiesgo = true;
                    System.out.println("Nombre: " + alumno.getNombre());
                    System.out.println("RUT: " + alumno.getRut());
                    System.out.println("Porcentaje de Asistencia: " + String.format("%.2f", porcentajeAsistencia) + "%");
                    System.out.println("-".repeat(60));
                }
            }
        }
    
        if (!hayAlumnosEnRiesgo) {
            System.out.println("No hay alumnos en situación de riesgo en este curso.");
        }
    }
    
    //Para pasar lista normalmente
    public void modAsistencia()throws IOException{
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        Alumno alumno;
        System.out.print("Ingrese la fecha actual (dd/mm/aaaa): ");
        String fecha = lector.readLine();
        for (int i = 0 ; i < alumnos.size() ; i++){
            alumno = alumnos.get(i);
            alumno.registrar(fecha);
        }
    }
    
    //Para modificar la asistencia ya registrada
    public void modAsistencia(String rut) throws IOException{
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        Alumno alumno = estaAlumno(rut);
  
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
        int opcion;
        String rutAlum;
        boolean estaAlumno;
        
        do {
            System.out.println("-".repeat(50));
            System.out.println(" ".repeat(13)+"Modificando "+nombreCurso);
            System.out.println("-".repeat(50));
            System.out.println("1. Asignar profesor jefe.");
            System.out.println("2. Eliminar profesor jefe.");
            System.out.println("3. Modificar datos alumno.");
            System.out.println("4. Eliminar datos alumno.");
            System.out.println("5. Salir al menú principal.");
            System.out.print("Ingrese su opción: ");
            opcion = Integer.parseInt(lector.readLine());
            
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
                        this.profesorJefe = profe;
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
    }

