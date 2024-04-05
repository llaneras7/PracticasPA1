package libreria;
public class PruebaLibreriaOferta {

    public static void main(String[] args) {
        //Creamos la libreria con un descuento del 20% para los autores George Orwell e Isaac Asimov
        LibreriaOferta libreria = new LibreriaOferta(20, new String[]{"George Orwell", "Isaac Asimov"});

        //Añadimos libros a la libreria
        libreria.addLibro("george orwell", "1984", 8.20);
        libreria.addLibro("Philip K. Dick", "¿Sueñan los androides con ovejas eléctricas?", 3.50);
        libreria.addLibro("Isaac Asimov", "Fundación e Imperio", 9.40);
        libreria.addLibro("Ray Bradbury", "Fahrenheit 451", 7.40);
        libreria.addLibro("Aldous Huxley", "Un Mundo Feliz", 6.50);
        libreria.addLibro("Isaac Asimov", "La Fundación", 7.30);
        libreria.addLibro("William Gibson", "Neuromante", 8.30);
        libreria.addLibro("Isaac Asimov", "Segunda Fundación", 8.10);
        libreria.addLibro("Isaac Newton", "arithmetica universalis", 7.50);
        libreria.addLibro("George Orwell", "1984", 6.20);
        libreria.addLibro("Isaac Newton", "Arithmetica Universalis", 10.50);

        System.out.println(libreria.toString());

        //Eliminamos ciertos libros
        System.out.println("\n Libreria después de haber eliminado ciertos libros: \n");
        libreria.remLibro("George Orwell", "1984");
        libreria.remLibro("Aldous Huxley", "Un mundo feliz");
        libreria.remLibro("Isaac Newton", "Arithmetica Universalis");

        System.out.println(libreria.toString());

        try {
            System.out.println("\nPrecioFinal(Philip K. Dick, ¿Sueñan los androides con ovejas eléctricas?): " +
                    libreria.getPrecioFinal("Philip K. Dick", "¿Sueñan los androides con ovejas eléctricas?"));
            System.out.println("PrecioFinal(isaac asimov, fundación e imperio): " +
                    libreria.getPrecioFinal("isaac asimov", "fundación e imperio"));
            System.out.println("PrecioFinal(Ray Bradbury, Fahrenheit 451): " +
                    libreria.getPrecioFinal("Ray Bradbury", "Fahrenheit 451"));
            System.out.println("PrecioFinal(Isaac Asimov, La Fundación): " +
                    libreria.getPrecioFinal("Isaac Asimov", "La Fundación"));
            System.out.println("PrecioFinal(william gibson, neuromante): " +
                    libreria.getPrecioFinal("william gibson", "neuromante"));
            System.out.println("PrecioFinal(Isaac Asimov, Segunda Fundación): " +
                    libreria.getPrecioFinal("Isaac Asimov", "Segunda Fundación"));
            // Este lanzará una excepción
            System.out.println("PrecioFinal(Isaac Newton, Arithmetica Universalis): " +
                    libreria.getPrecioFinal("Isaac Newton", "Arithmetica Universalis"));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }


    }
}
