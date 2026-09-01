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

        float promedio = calcularPromedio(calificaciones, calificaciones.length);
        int aprobado = estaAprobado(promedio);

        mostrarResultado(nombre, promedio, aprobado);
        
        scanner.close();
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

    /*Originalmente lo pensamos como double, pero la función que se exigía en la práctica
    nos pedía float. Por ende, nuestra elección de float */

    public static float calcularPromedio(float[] calificaciones, int cantidad) {
        float suma = 0;
        for (int i = 0; i < cantidad; i++) {
            suma += calificaciones[i];
        }
        return suma / cantidad;
    }

    /* Este es un punto extraño. Como tal, las funciones que estaban en la práctica estaban 
    exclusivamente enfocadas a que fuera en C. En Java tenemos la opción de utilizar boolean.
    Como nos dio pena mandar comentario, dejamos este método como int para apegarnos medianamente 
    a los requisitos originales */
    public static int estaAprobado(float promedio) {
        if (promedio >= 6.0f) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void mostrarResultado(String nombre, float promedio, int aprobado) {
        System.out.println("\n--- Resumen Académico ---");
        System.out.println("Nombre:   " + nombre);
        System.out.printf("Promedio: %.2f\n", promedio);
        
        String estado = (aprobado == 1) ? "APROBADO" : "REPROBADO";
        System.out.println("Estado:   " + estado);
    }
    
}