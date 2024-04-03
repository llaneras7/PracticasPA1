package libreria;
public class PruebaLibreria {
    public static void main(String[] args) {
        // Crear una instancia de Libreria
        Libreria libreria = new Libreria();

        // Añadir libros a la librería
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

        // Mostrar representación textual de la librería
        System.out.println("Librería con todos los libros:");
        System.out.println(libreria);

        // Eliminar libros de la librería
        libreria.remLibro("George Orwell", "1984");
        libreria.remLibro("Aldous Huxley", "Un Mundo Feliz");
        libreria.remLibro("Isaac Newton", "Arithmetica Universalis");

        // Mostrar representación textual de la librería después de eliminar libros
        System.out.println("\nLibrería después de eliminar algunos libros:");
        System.out.println(libreria);

        // Mostrar precio final de algunos libros
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

