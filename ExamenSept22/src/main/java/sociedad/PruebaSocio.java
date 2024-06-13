package sociedad;

import java.util.HashSet;
import java.util.Set;

public class PruebaSocio {
    public static void main(String[] args) {

        Set<String> interests1 = new HashSet<>();
        interests1.add("Senderismo");
        interests1.add("Escalada");
        Socio socio1 = new Socio("Layton Kor", interests1, 24);

        Set<String> interests2 = new HashSet<>();
        Socio socio2 = new Socio("layton kor", interests2, 24);

        System.out.println(socio1.toString());
        System.out.println(socio2.toString());

        if (socio1.equals(socio2)) {
            System.out.println("Son el mismo socio.");
        }else{
            System.out.println("Son socios distintos.");
        }
    }
}
