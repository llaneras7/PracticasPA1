package ex2305;

import java.util.Objects;

public class Solicitud {
    private String asignatura;
    private int diaSem;
    private int franja;
    private int lab;

    public Solicitud(String asignatura, int diaSem, int franja) {
       if(diaSem >= 1 && diaSem <= 7 && franja >= 1 && franja <= 3){
           this.asignatura = asignatura;
           this.diaSem = diaSem;
           this.franja = franja;
           this.lab = -1;
       }else{
           throw new LabException("Argumentos erroneos.");
       }
    }
    public String getAsignatura() {
        return asignatura;
    }
    public int getDiaSem() {
        return diaSem;
    }
    public int getFranja() {
        return franja;
    }
    public int getLab() {
        return lab;
    }
    public void setDiaSem(int diaSem) {
        if(diaSem >= 1 && diaSem <= 7){
            this.diaSem = diaSem;
        }else{
            throw new LabException("Argumentos erroneos.");
        }
    }
    public void setFranja(int franja) {
        if(franja >= 1 && franja <= 3){
            this.franja = franja;
        }else{
            throw new LabException("Argumentos erroneos.");
        }
    }
    public void setLab(int lab) {
        this.lab = lab;
    }
    @Override
    public String toString() {
        return "("+asignatura+", "+diaSem+", "+franja+", "+lab+")";
    }
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Solicitud){
            Solicitud solicitud = (Solicitud) obj;
            if(this.asignatura.equalsIgnoreCase(solicitud.getAsignatura()) && this.diaSem == solicitud.getDiaSem() && this.franja == solicitud.getFranja()){
                return true;
            }
        }
        return false;
    }
    @Override
    public int hashCode() {
        return Objects.hash(this.asignatura.toLowerCase(), this.diaSem, this.franja);
    }

    public int compareTo(Solicitud s){
        int resultado = Integer.compare(this.diaSem, s.getDiaSem());
        if(resultado == 0){
            resultado = Integer.compare(this.franja, s.getFranja());
        }else if(resultado == 0){
            resultado = this.asignatura.compareToIgnoreCase(s.getAsignatura());
        }
        return resultado;
    }


}
