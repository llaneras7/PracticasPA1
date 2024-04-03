package jarras;

public class EjemploUsoMesa1 {
    public static void main(String[] args) {
        Jarra Izq = new Jarra(7);
        Jarra Der = new Jarra(5);
        Mesa M = new Mesa(Izq, Der);

       M.llena(Mesa.Posicion.Derecha);
       System.out.println(M);
       M.llenaDesde(Mesa.Posicion.Izquierda);
       System.out.println(M);
       M.llena(Mesa.Posicion.Derecha);
       System.out.println(M);
       M.llenaDesde(Mesa.Posicion.Izquierda);
       System.out.println(M);
       M.vacia(Mesa.Posicion.Izquierda);
       System.out.println(M);
       M.llenaDesde(Mesa.Posicion.Izquierda);
       System.out.println(M);
       M.llena(Mesa.Posicion.Derecha);
       System.out.println(M);
       M.llenaDesde(Mesa.Posicion.Izquierda);
       System.out.println(M);
    }
}
