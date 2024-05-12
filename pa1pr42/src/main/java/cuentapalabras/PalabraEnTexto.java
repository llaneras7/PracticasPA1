package cuentapalabras;

import java.util.Objects;

public class PalabraEnTexto {
    private String palabra;
    private int veces;

    public PalabraEnTexto(String p){
        this.palabra = p.toUpperCase();
        this.veces = 1;
    }
    public void incrementa(){
        this.veces++;
    }
    public boolean equals(Object o){
        if(o instanceof PalabraEnTexto){
            PalabraEnTexto p = (PalabraEnTexto) o;
            return this.palabra.equals(p.palabra);
        }
        return false;
    }
    @Override
    public String toString(){
        return palabra+": "+veces;
    }
    @Override
    public int hashCode(){
        return Objects.hash(palabra, veces);
    }
}
