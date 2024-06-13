package sociedad;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Socio {
    private String name;
    private Set<String> interests;
    private int ident;

    public Socio(String name, Set<String> i, int ident) {
        if(name == null || name.equals("") || ident == 0){
            throw new SociedadException("Valores introducidos erroneos.");
        }
        this.name = name;
        this.ident = ident;
        this.interests = new HashSet<>(interests);
        interests = i;
    }
    public String getName(){
        return name;
    }
    public Set<String> getInterests(){
        return interests;
    }
    public int getIdent(){
        return Objects.hash();
    }
    @Override
    public String toString(){
        return "["+name+", "+interests.toString()+", "+ident+"]";
    }
    @Override
    public int hashCode() { //Cuando en el equals no distingue de mayus o minus hay que pasar la variable a tolower o toUpperCase en el hashCode
        return Objects.hash(name.toLowerCase(), ident);
    }
    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Socio s) && s.name.equalsIgnoreCase(this.name) && s.ident == this.ident;
    }
    public int compareTo(Socio socio) {
        int resultado = this.name.compareToIgnoreCase(socio.name);
        if (resultado == 0) {
            resultado = Integer.compare(this.ident, socio.ident);
        }
        return resultado;
    }
}
