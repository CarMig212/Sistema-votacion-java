import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class SistemaVotacion {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Map<Integer, Integer> votos = new HashMap<>();
        int totalVotos = 0;
        int candidato;

        System.out.println("Ingrese el número del candidato (o 0 para terminar):");

        while (true) {
            candidato = teclado.nextInt();
            
            if (candidato == 0) break;
            votos.put(candidato, votos.getOrDefault(candidato, 0) + 1);
            totalVotos++;
        }

        System.out.println("\n--- Resultados ---");
        if (totalVotos == 0) {
            System.out.println("No se registraron votos.");
        } else {
            for (Map.Entry<Integer, Integer> entry : votos.entrySet()) {
                double porcentaje = (entry.getValue() * 100.0) / totalVotos;
                System.out.printf("Candidato %d: %d votos (%.2f%%)%n", 
                                  entry.getKey(), entry.getValue(), porcentaje);
            }
        }
        teclado.close();
    }
}