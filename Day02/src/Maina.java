import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Maina {
    /* Proceso de desestructurar el problema:
     * Leer el archivo línea por línea
                Esto conlleva lo siguiente:
                * Leer el primer caracter
                * Y evaluar qué ocurre con el tercer caracter, sumnaod los puntos convenientes
     * Crear una variable llamada max
     * Bucle for:
            * Si la siguiente posición es mayor que max, ahora max se convierte en esa posición
     * Devolver max
     * :)
     */
    public static void main(String[] args) {
        int total = 0, puntos = 0;
        try {
            List<String> allLines = Files.readAllLines(Paths.get("input.txt"));
            for (String line : allLines) {
               puntos  = roundPoints(line);
               total+= puntos;
            }
            System.out.print("Total points = " +total);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static int roundPoints(String line){
        int roundTotal = 0;
        /*
         The first column : A for Rock, B for Paper, and C for Scissors.
         The second column: X for Rock, Y for Paper, and Z for Scissors.

         The score for a single round is the score for the shape you selected
         1 for Rock
         2 for Paper
         3 for Scissors

         The score for the outcome of the round:
         0 if you lost
         3 if the round was a draw
         6 if you won.

         */
        if(line.charAt(2) == 'X'){
            if(line.charAt(0) == 'A') { //Draw
                roundTotal += 3;
            }
            else if(line.charAt(0) == 'C'){ //Win
                roundTotal += 6;
            }
            roundTotal += 1;
        }
        if(line.charAt(2) == 'Y'){
            if(line.charAt(0) == 'A') { //Win
                roundTotal += 6;
            }
            else if(line.charAt(0) == 'B'){ //Draw
                roundTotal += 3;
            }
            roundTotal += 2;
        }
        if(line.charAt(2) == 'Z'){
            if(line.charAt(0) == 'B') { //Win
                roundTotal += 6;
            }
            else if(line.charAt(0) == 'C'){ //Draw
                roundTotal += 3;
            }
            roundTotal += 3;
        }
        return roundTotal;

    }

}