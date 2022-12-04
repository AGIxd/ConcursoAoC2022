import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Mainb {
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
         The second column: X for Loss, Y for Draw, and Z for Win.

         The score for a single round is the score for the shape you selected
         1 for Rock
         2 for Paper
         3 for Scissors

         The score for the outcome of the round:
         0 if you lost
         3 if the round was a draw
         6 if you won.

         */
        if(line.charAt(2) == 'X'){ //Loss
            if(line.charAt(0) == 'A') { //Rock
                roundTotal += 3; //Scissors
            }
            else if(line.charAt(0) == 'B') { //Paper
                roundTotal += 1; //Rock
            }
            else if(line.charAt(0) == 'C'){ //Scissors
                roundTotal += 2; //Paper
            }
            //roundTotal += 0;
        }
        if(line.charAt(2) == 'Y'){ //Draw
            if(line.charAt(0) == 'A') { //Rock
                roundTotal += 1; //Rock
            }
            else if(line.charAt(0) == 'B') { //Paper
                roundTotal += 2; //Paper
            }
            else if(line.charAt(0) == 'C'){ //Scissors
                roundTotal += 3; //Scissors
            }
            roundTotal += 3;
        }
        if(line.charAt(2) == 'Z'){ //Win
            if(line.charAt(0) == 'A') { //Rock
                roundTotal += 2; //Paper
            }
            else if(line.charAt(0) == 'B') { //Paper
                roundTotal += 3; //Scissors
            }
            else if(line.charAt(0) == 'C'){ //Scissors
                roundTotal += 1; //Rock
            }
            roundTotal += 6;
        }
        return roundTotal;

    }

}