package jarras;

public class Mesa {

    private final Jarra jarraIzq;
    private final Jarra jarraDer;


    public enum Posicion{
        Izquierda,Derecha
    }
    public Mesa(Jarra Izq,Jarra Der){
        if(Izq == Der){
            throw new RuntimeException("Las dos jarras no pueden ser iguales");
        }
        else {
            jarraIzq = Izq;
            jarraDer = Der;

        }
    }
    public Mesa(int capIzq,int capDer){
        jarraIzq = new Jarra(capIzq);
        jarraDer = new Jarra(capDer);
    }

    public int capacidad(Posicion pos){
        if (pos == Posicion.Izquierda){
            return jarraIzq.capacidad();
        }
        else{
            return jarraDer.capacidad();
        }
    }
    public int contenido(Posicion pos){
        if (pos == Posicion.Izquierda){
            return jarraIzq.contenido();
        }
        else{
            return jarraDer.contenido();
        }
    }
    public void llena(Posicion pos){
        if (pos == Posicion.Izquierda){
             jarraIzq.llena();
        }
        else{
             jarraDer.llena();
        }
    }
    public void vacia(Posicion pos){
        if (pos == Posicion.Izquierda){
            jarraIzq.vacia();
        }
        else{
            jarraDer.vacia();
        }
    }
    public void llenaDesde(Posicion pos){
        if (pos == Posicion.Izquierda){
            jarraIzq.llenaDesde(jarraDer);
        }
        else{
            jarraDer.llenaDesde(jarraIzq);
        }
    }
    @Override
    public String toString(){
        return "M(J(" + jarraIzq.capacidad() + "," + jarraIzq.contenido() + "),J("
                + jarraDer.capacidad() + "," + jarraDer.contenido() + "))";
    }



}



