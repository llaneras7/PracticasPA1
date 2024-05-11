package Notas;

import java.util.ArrayList;
import java.util.List;

public class Asignatura {
    private String nombre;
    private List<Estudiante> estudiantes;
    private List<String> errores;

    public Asignatura(String nombre, String[] ests){
        this.nombre = nombre;
        estudiantes = new ArrayList<>();
        errores = new ArrayList<>();
        procesarEstudiantes(ests);
    }

    public double getCalificacion(Estudiante est) throws EstudianteException {
        if (estudiantes.contains(est)) {
            return est.getNota();
        } else {
            throw new EstudianteException("Estudiante" + est.getNombre() + " " + est.getDni() + " no se encuentra.");
        }
    }
    public double getMedia() throws EstudianteException{
        double media = 0;
        if (estudiantes.isEmpty()) {
            throw new EstudianteException("No hay estudiantes en la asignatura.");
        }
        for(Estudiante est : estudiantes){
            media += est.getNota();
        }
        return media/estudiantes.size();
    }
    public String getNombre(){
        return nombre;
    }
    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }
    public List<String> getErrores() {
        return errores;
    }
    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append(getNombre()).append(": { [");
        for(Estudiante est : estudiantes){
            str.append(est.toString()).append(", ");
        }
        str.append("],[");
        for(String error : errores){
            str.append(error).append(", ");
        }
        str.append("] }");
    }
    public int buscarEstudiante(Estudiante est){
        for(int i : estudiantes){
            if(estudiantes.get(i).equals(est)){
                return i;
            }
        }
        return -1;
    }
    public void procesarEstudiantes(String[] est){
     for(String datos : est){
         String[] partes = datos.split(";");
         if(partes.length == 3) {
             String dni = partes[0];
             String nameEst = partes[1];
             String cal = partes[2];
             try {
                 double calificacion = Double.parseDouble(cal);
                 this.estudiantes.add(new Estudiante(dni, nameEst, calificacion));
             }catch (NumberFormatException e){
                 errores.add("ERROR. Calificación no numérica:" + datos)
             }catch(EstudianteException e){
                 errores.add("ERROR. "+e.getMessage() + ": " + datos);
             }
         }else{
             errores.add("Error: Faltan datos: "+datos);
         }
     }
    }

}

