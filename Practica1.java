/**
 * Solución completa a la práctica de Manejo de Excepciones.
 * Incluye los Ejercicios del 1 al 6.
 */

public class Practica1 {

    // Ejercicio 3: Crear una nueva clase de excepción
    static class ErrorDeProceso extends Exception {
        
        // el constructorr que acepta un mensaje de error como cadena.
        public ErrorDeProceso(String mensaje) {
            super(mensaje);
        }
    }

    // Método principal que junta todos los ejercicios
    public static void main(String[] args) {
        System.out.println("====== Inicio de practica de excepciones ======\n");

        System.out.println(">>> Ejercicios 1 y 2: Try-Catch-Finally y Stack Trace");
        ejecutarEjercicios1y2();
        
        System.out.println("\n--------------------------------------------------\n");

        System.out.println(">>> Ejercicio 4: Lanzar y atrapar Excepción Personalizada");
        ejecutarEjercicio4();

        System.out.println("\n--------------------------------------------------\n");

        System.out.println(">>> Ejercicio 5: Excepción con Objeto Null");
        ejecutarEjercicio5();

        System.out.println("\n--------------------------------------------------\n");

        System.out.println(">>> Ejercicio 6: Encadenamiento de Excepciones (Métodos A y B)");
        ejecutarEjercicio6();
        
        System.out.println("\n====== Fin del programa ======");
    }

    // Lógica de ejercicios 1 Y 2
    public static void ejecutarEjercicios1y2() {
        try {
            System.out.println("   [Try] Intentando ejecutar código...");
            throw new Exception("Error simulado para el Ejercicio 1");
            
        } catch (Exception e) {
            System.out.println("   [Catch] Excepción capturada: " + e.getMessage());
            
            //imprimir el stack trace
            System.out.println("   [Catch] Imprimiendo Stack Trace:");
            e.printStackTrace(System.out);
            
        } finally {
            System.out.println("   [Finally] Este bloque se ejecuta siempre.");
        }
    }

    // Lógica del ejercicio 4
    // Método auxiliar que lanza la excepción personalizada
    public void metodoQueFalla() throws ErrorDeProceso {
        throw new ErrorDeProceso("Fallo crítico generado en el método de prueba.");
    }

    public static void ejecutarEjercicio4() {
        // 4.a. Crea una instancia del objeto
        PracticaExcepciones instancia = new PracticaExcepciones();

        try {
            // 4.b. Invoca el método que genera la excepción
            System.out.println("   Invocando metodoQueFalla()...");
            instancia.metodoQueFalla();
            
        } catch (ErrorDeProceso e) {
            // 4.c. Controla la excepción imprimiendo el mensaje
            System.out.println("   [Catch] ¡Alerta! Error personalizado detectado: " + e.getMessage());
        }
    }

    // Lógica del ejercici 5
    public static void ejecutarEjercicio5() {
        // 5.a. No crea una instancia (asigna null)
        PracticaExcepciones instanciaNula = null;

        try {
            System.out.println("   Intentando invocar método sobre variable null...");
            instanciaNula.metodoQueFalla();
            
        } catch (Exception e) {
            // 5.b. Atrapa la excepción (general)
            // 5.c. Identificar lo que sucede
            System.out.println("   [Catch] Se atrapó una excepción inesperada: " + e.getClass().getSimpleName());
            System.out.println("   [Mensaje] " + e.getMessage());
            System.out.println("   [Análisis] Esto ocurre porque intentamos acceder a un método de un objeto que no existe en memoria.");
        }
    }


    // Lógica ejercicio 6
    // 6.a. Implemente el método A para que produzca una excepción propia
    public void metodoA() throws ErrorDeProceso {
        throw new ErrorDeProceso("El error original ocurrió en el Método A");
    }

    // 6.b. Implemente el método B para que llame a A, detecte su excepción y lance una suya
    public void metodoB() throws Exception {
        try {
            metodoA();
        } catch (ErrorDeProceso e) {
            System.out.println("   [Método B] Capturó error de A. Lanzando nueva excepción...");
            throw new Exception("Error reportado por el Método B", e);
        }
    }

    public static void ejecutarEjercicio6() {
        PracticaExcepciones instancia = new PracticaExcepciones();
        
        try {
            // 6.c. Agregue un método principal que invoque B e imprima el stack trace
            instancia.metodoB();
            
        } catch (Exception e) {
            System.out.println("   [Main] Excepción final recibida.");
            System.out.println("   [Main] Stack Trace Completo (observa el 'Caused by'):");
            e.printStackTrace(System.out);
        }
    }

}
