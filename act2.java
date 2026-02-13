import java.util.Scanner;

public class act2 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Ingresa un número entero: ");
        
        try {
            int numero = teclado.nextInt();
            verificarPar(numero);
            System.out.println("El número " + numero + " es par! Todo bien.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            teclado.close();
        }
    }
    public static void verificarPar(int n) throws Exception {
        if (n % 2 != 0) {
            throw new Exception("El número ingresado es impar. Se produjo una excepción.");
        }
    }
}