package Notas;

public class PruebaAsignatura {
    public static void main(String[] args) {
        try {
            Asignatura asignatura = new Asignatura("PA1", "12455666F;Lopez Perez, Pedro;6.7 , 33678999D; Merlo Gomez, Isabel;5.8, 23555875G; Martinez Herrera, Lucia; 9.1");
            System.out.println("Media: " + asignatura.getMedia());
            asignatura.getEstudiantes()
}
