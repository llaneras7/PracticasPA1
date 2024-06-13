package ex2305;

import java.util.*;

import static java.lang.Integer.parseInt;

public class Laboratorios {
    private int maxLabs;
    private List<Solicitud> solicitudes;
    private SortedSet<Solicitud> erroresDeAsignacion;
    private SortedMap<Integer, SortedMap<Integer, List<Solicitud>>> asignaciones;

    public Laboratorios(int maxLabs){
        if(maxLabs < 1){
            throw new LabException("Argumentos erroneos");
        }else{
            this.maxLabs = maxLabs;
            this.solicitudes = new LinkedList<>();
            this.erroresDeAsignacion = new TreeSet<>(); //TreeSet para SortedSet
            this.asignaciones = new TreeMap<>(); //TreeMap para SortedMap
        }
    }
    protected SortedSet<Solicitud> getErroresDeAsignacion() {
        return erroresDeAsignacion;
    }

    protected void addSolicitud(Solicitud solicitud){
        if(!solicitudes.contains(solicitud)){
            solicitudes.add(solicitud);
        }
    }
    public void addSolicitud(String datosSolicitud){
        try{
            String[] partes = datosSolicitud.split("\\s*[;]\\s*");
            if(partes.length == 3 ){
                String asignatura = partes[0];
                int diaSem = parseInt(partes[1]);
                int franja = parseInt(partes[2]);
                Solicitud solicitud = new Solicitud(asignatura, diaSem, franja);
                addSolicitud(solicitud);
            }else{
                throw new LabException("Argumentos erroneos");
            }
        }catch(IndexOutOfBoundsException | NumberFormatException e){
            throw new LabException("Argumentos erroneos");
        }
    }
    public SortedSet<Solicitud> getSolicitudesOrdenadas(){
        SortedSet<Solicitud> satelite = new TreeSet<>(new OrdenNombre());
    }


}
