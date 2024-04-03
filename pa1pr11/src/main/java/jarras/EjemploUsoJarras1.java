package jarras;

public class EjemploUsoJarras1 {
    public static void main(String[] args) {
        Jarra A = new Jarra(7);
        Jarra B = new Jarra(4);
        A.llena();
        System.out.println(A + "," + B );
        B.llenaDesde(A);
        System.out.println(A + "," + B );
        B.vacia();
        System.out.println(A + "," + B );
        B.llenaDesde(A);
        System.out.println(A + "," + B );


    }


}