package clases;

import java.io.Serializable;

/**
 * Clase abstracta que contiene las variables de persona 
 * @author Jhon
 */
public abstract class Persona implements Serializable{

    protected String nombre;
    protected String apellidos;
    protected String cedula;
    protected String telefono;
    protected Direccion direccion;        
}
