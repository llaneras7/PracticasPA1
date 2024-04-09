package elecciones;

public class Candidata {
    private String nombre;
    private String DNI;
    private String partido;
    public static enum Sexo {F,M};
    private Sexo sexo;

    public Candidata(String nombre, String partido, Sexo sexo, String DNI ){
        this.nombre = nombre;
        this.partido = partido;
        this.sexo = sexo;
        this.DNI = DNI;
    }
    public Candidata(String nombre, Sexo sexo, String DNI){
        this.nombre = nombre;
        this.sexo = sexo;
        this.DNI = DNI;
    }
    public String getNombre(){
        return nombre;
    }
    public String getDNI(){
        return DNI;
    }
    public Sexo getSexo(){
        return sexo;
    }
    public String getPartido(){
        return partido;
    }
    public boolean esIndependiente(){
        if(partido == null){
            return true;
        }
        return false;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setPartido(String partido){
        this.partido = partido;
    }
    public void cambiarSexo(){
        if (sexo==F){
            sexo = {M};
        } else if (sexo == {M}) {
            sexo = {F};
        }
    }
    public String toString(){
        private String indepe;
        if(partido==null){
            indepe = "independiente";
            return nombre+"("+indepe+")";
        }
        return nombre;
    }
}