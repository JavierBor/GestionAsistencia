package com.mycompany.gestionasistencia;

//Excepción para manejar los alumnos que no son encontrado, en caso de un RUT mal ingresado
public class AlumnoNoEncontradoException extends Exception{
    public AlumnoNoEncontradoException(String mensaje){
        super(mensaje);
    }
}
