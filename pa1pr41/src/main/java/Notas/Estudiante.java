package Notas;

import java.util.Objects;

public class Estudiante {
    private String dni;
    private String nombre;
    private double nota;

    public Estudiante(String dni, String nombre){
        this.dni = dni;
        this.nombre = nombre;
        this.nota = 0;
    }
    public Estudiante(String dni, String nombre, double nota){
        this.dni = dni;
        this.nombre = nombre;
        if(nota < 0) {
            throw new EstudianteException("Calificación negativa");
        }else{
            this.nota = nota;
        }
    }
    public String getNombre(){
        return this.nombre;
    }
    public String getDni(){
        return this.dni;
    }
    public double getNota(){
        return this.nota;
    }
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Estudiante){
            Estudiante est = (Estudiante) obj;
            return this.dni.equalsIgnoreCase(est.dni)&&this.nombre.equals(est.nombre);
        }
        return false;
        /*
        return (obj instanceof Estudiante) && this.dni.equals(((Estudiante)obj).dni) && this.nombre.equals(((Estudiante)obj).nombre);
         */
    }
    @Override
    public int hashCode(){
        return Objects.hash(dni.toLowerCase(), nombre);
    }
    @Override
    public String toString(){
        return nombre+" "+dni;
    }
}
