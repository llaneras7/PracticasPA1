import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

import sociedad.Sociedad;
import sociedad.Socio;

public class TestSociedad {

    public static void printClub(Sociedad cl) {
        Set<String> activitiesInClub = Set.of("Escalada", "Kayak", "Buceo",
                "Senderismo", "Monopatin", "BMX", "Fotografia", "Rafting");
        // Print members not enrolled in activities
        System.out.println("SOCIOS NO INSCRITOS EN ACTIVIDADES");
        System.out.println("==================================");
        cl.guardarSocios(new PrintWriter(System.out, true));

        System.out.println("\nSOCIOS INSCRITOS EN ACTIVIDADES");
        System.out.println("==============================");
        for (String activity : activitiesInClub) {
            System.out.println(activity + ": " + cl.inscritos(activity));
        }
    }

    public static void main(String[] args) throws IOException {
        Sociedad outdoorClub = new Sociedad();
        String filePath = "./datos.txt";
        outdoorClub.leerFichero(filePath);

        System.out.println("Estado del club despues de leer el fichero \"" + filePath + "\"");

        printClub(outdoorClub);

        outdoorClub.inscribir("Junko Tabei", 327, "ESCalada");
        outdoorClub.inscribir("Junko Tabei", 327, "buceo");
        outdoorClub.inscribir("Tony Hawk", 123, "Monopatin");
        outdoorClub.inscribir("Tony Hawk", 127, "monopatin");
        outdoorClub.inscribir("Leticia Bufoni", 227, "MONOPATIN");
        outdoorClub.inscribir("Jack Bones", 145, "Buceo");

        outdoorClub.nuevoSocio(new Socio("Cynthia Veil", Set.of("MONOPATIN"), 156));

        System.out.println("\n\nEstado del club despues de inscribir a \"Junko Tabei\", \"Tony Hawk\", \"Leticia Bufoni\" and \"Jack Bones\"\n y dar de alta a nueva socia \"Cynthia Veil\"");
        printClub(outdoorClub);

        outdoorClub.inscribir("Cynthia Veil", 156, "monopatin");

        System.out.println("\n\nEstado del club despues de inscribir \"Cynthia Veil\"");
        printClub(outdoorClub);


    }

}