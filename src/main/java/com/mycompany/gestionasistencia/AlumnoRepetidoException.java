package com.mycompany.gestionasistencia;

//Excepción para manejar a los alumnos repetidos
public class AlumnoRepetidoException extends Exception{
     public AlumnoRepetidoException(String mensaje) {
        super(mensaje);
    }
}
