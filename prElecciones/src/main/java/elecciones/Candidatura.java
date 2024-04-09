package elecciones;

import java.util.ArrayList;
import java.util.List;

public class Candidatura {
    private String partido;
    private String circunscripcion;
    private List<Candidata> candidatura;
    public Candidatura(String partido, String circunscripcion){
        this.partido = partido;
        this.circunscripcion = circunscripcion;
        candidatura = new ArrayList<>();
    }

    public String getPartido() {
        return partido;
    }

    public String getCircunscripcion() {
        return circunscripcion;
    }
    public void agregarMiembro(Candidata cand){
        for(int i = 0; i<=candidatura.size(); i++){
            private Candidata candi = candidatura.get(i)
            if (cand.getDNI().equalsIgnoreCase(candi.getDNI())){
                candi = cand;
            }
        }
        candidatura.add(cand);
    }
    public void eliminarMiembro(Candidata cand){
        private int flag = 0;
        for(int i = 0; i<=candidatura.size(); i++){
            private Candidata candi = candidatura.get(i);
            if (cand.getDNI().equalsIgnoreCase(candi.getDNI())){
                flag = 1;
                candidatura.remove(i);
            }
        }
        if(flag==1){
            throw new RuntimeException("Candidata no encontrada.");
        }
    }
    private int buscarDNI(String dni){
        private int indice = -1;
        for(int i = 0; i<=candidatura.size(); i++){
            private Candidata cand = candidatura.get(i);
            if (cand.getDNI().equalsIgnoreCase(dni){
               indice = i;
            }
        }
        return indice;
    }
    public void agregarCabezaLista(Candidata cand){
        candidatura.addFirst() = cand;
    }
    public Candidata cabezaLista(){
        if(candidatura.getFirst() == null){
            throw new RuntimeException("No se encuentra una cabeza de lista.");
        }else{
            return candidatura.getFirst();
        }
    }
    public int numeroIndependientes(){
        private int cont = 0 ;
        for(int i = 0; i<=candidatura.size(); i++){
            private Candidata cand = candidatura.get(i);
            if (cand.getPartido()==null){
                cont++;
            }
        }
        return cont;
    }
    public boolean esCremallera(){

    }
    public String toString()´{

    }


}
