import java.util.Scanner;

public class KarlaCalificaYReprueba{
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Karla te dará tu promedio ---");
        
        String nombre = leerNombre(scanner);

        float[] calificaciones = new float[3];
        calificaciones[0] = leerCalificacion(scanner, "primer parcial");
        calificaciones[1] = leerCalificacion(scanner, "segundo parcial");
        calificaciones[2] = leerCalificacion(scanner, "tercer parcial");
    }

    private static String leerNombre(Scanner scanner) {
        String nombre = "";
        while (true) {
            try {
                System.out.print("Ingrese su nombre cienciólogo: ");
                nombre = scanner.nextLine().trim();

                if (nombre.isEmpty()) { //nombre vacío 
                    throw new IllegalArgumentException("No se llama: ");
                }

                if (!nombre.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
                    throw new IllegalArgumentException("Solo se aceptan las letras del alfabeto latino.");
                }
                
                break; 
                
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage() + " Escriba su nombre real.\n");
            }
        }
        return nombre;
    }

    private static float leerCalificacion(Scanner scanner, String orden) {
        float calificacion = 0.0f;
        while (true) {
            try {
                System.out.print("Ingresa la calificación del " + orden + " (0 - 10): ");
                String input = scanner.nextLine();
                
                calificacion = Float.parseFloat(input);

                if (calificacion < 0.0f || calificacion > 10.0f) {
                    throw new IllegalArgumentException("La calificación debe estar entre 0 y 10. Karla no da puntos extra (que yo sepa :p).");
                }

                break; 
                
            } catch (NumberFormatException e) {
                System.out.println("Error: Aquí no ponga su N/P. Solo se permiten números. Decimales denotados con punto (ej. 0.98), no con comas.\n");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage() + " Inténtelo de nuevo.\n");
            }
        }
        return calificacion;
    }

}