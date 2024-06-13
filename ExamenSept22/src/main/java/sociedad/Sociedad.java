package sociedad;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.*;

public class Sociedad {
    private Set<Socio> membersNotInActivities;
    private Map<String, Set<Socio>> membersInActivities;

     public Sociedad() {
        this.membersNotInActivities = new HashSet<>();
        this.membersInActivities = new HashMap<>();
    }
    public void leerFichero(String fich){
        Path path = Path.of(fich);
        try(Scanner sc = new Scanner(path)){
            while(sc.hasNextLine()){
                String linea = sc.nextLine();
                procesarLinea(linea);
            }
        }catch(SociedadException e){

        }

    }
    public void procesarLinea(String linea){
        try {
            String[] lineaSeparada = linea.split("%");
            if (lineaSeparada.length == 3) {
                String[] intereses = lineaSeparada[1].split(",");
                Set<String> interesesSet = new HashSet<>();
                Collections.addAll(interesesSet, intereses); //Con collections añadimos un vector entero a un Set
                String name = intereses[0];
                int id = Integer.parseInt(intereses[2]);
                Socio socio = new Socio(name, interesesSet, id);
                nuevoSocio(socio);
            }
        }catch(SociedadException e){

        }
    }
    public void nuevoSocio(Socio m){
        Set<String> activities = membersInActivities.keySet(); //cojo las keys que son las actividades
        Iterator<String> iter = activities.iterator();
        boolean found = false;
        while(!found && iter.hasNext()){
            found = membersInActivities.get(iter.next()).contains(m); //Coje la primera key y busca si contiene el socio como value
        }
        if(!found && !membersNotInActivities.contains(m)){
            membersNotInActivities.add(m);
        }
    }
    public Set<Socio> inscritos(String actividad){
        return membersInActivities.getOrDefault(actividad, null); //Devuelvo el conjunto de socios que tienen la actividad dada o en su defecto devuelvo null
    }
    protected Socio buscarSocioEnConjunto(Socio s, Set<Socio> ss){
        Socio aux = null; //Creo una variable del mismo tipo de lo que estoy buscando para ir comparando con lo que busco
        boolean found = false; //Flag si lo encuentro
        if(ss!=null){
            Iterator iter = ss.iterator(); //Iterator para recorrer el Conjunto Set
            while(!found && iter.hasNext()){
                aux = iter.next();
                if(aux.equals(s)){
                    found = true;
                }
            }
        }
        return aux;
    }
    public void inscribir(String nombre, int identificador, String actividad){
        Socio socio = new Socio(nombre, new HashSet<>(), identificador);
        if(membersNotInActivities.contains(socio)){ //Si el conjunto tiene ese socio
            Socio socioEnConjunto = buscarSocioEnConjunto(socio, membersNotInActivities); //Busco el socio dado en el conjunto
            membersNotInActivities.remove(socioEnConjunto); //Lo elimino del conjunto
            Set<Socio> aux = membersInActivities.getOrDefault(actividad, new HashSet<>()); //Cojo el conjunto de socios de la actividad dada
            aux.add(socio); //Añado el socio al conjunto de los socios de la actividad dada
            membersInActivities.put(actividad, aux); //Con put meto el conjunto modificado en su key (K,V)
        }
    }

    public void guardarSocios(String fichero) throws IOException{
        try(PrintWriter pw = new PrintWriter(fichero)){
            guardarSocios(pw);
        }
    }
    public void guardarSocios(PrintWriter pw){
        for(Socio m : membersNotInActivities){
            pw.println(m.toString());
        }
    }
}
