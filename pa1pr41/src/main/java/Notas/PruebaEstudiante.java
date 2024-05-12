package Notas;

public class PruebaEstudiante {
    public static void main(String[] args) {
        try{
            Estudiante est1 = new Estudiante("22456784F", "Gonzalez Perez, Juan", 5.5);
            Estudiante est2 = new Estudiante("33456777S", "Gonzalez Perez, Juan", -3.4);

            System.out.println(est1.getNombre());
            System.out.println(est1.getNota());
            System.out.println(est2.getNombre());
            System.out.println(est2.getNota());

            if(est1.equals(est2)) {
                System.out.println("Son iguales");
            }else{
                System.out.println("No son iguales");
            }
        }catch(EstudianteException ee){
            System.err.println(ee.getMessage());
        }
    }



}
