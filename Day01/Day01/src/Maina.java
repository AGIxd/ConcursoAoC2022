import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Maina {
    /* Proceso de desestructurar el problema:
     * Leer el archivo línea por línea
                Esto conlleva lo siguiente:
                * Sumar todos los números hasta encontrar un salto de línea
                * En cuyo caso comparamos con max
     * Crear una variable llamada max
     * Bucle for:
            * Si la siguiente pposición es mayor que max, ahora max se convierte en esa posición
            * Hacer eso hasta array.length-1
     * Devolver max
     * :)
     */
    public static void main(String[] args) {
        int caloriesMax = 0, calories = 0;
        try {
            List<String> allLines = Files.readAllLines(Paths.get("input.txt"));
            for (String line : allLines) {
                if(line.length() == 0){
                    if(calories >= caloriesMax){
                        caloriesMax = calories;
                    }
                    calories = 0;

                }
                else{
                    calories += Integer.parseInt(line);
                }
            }
            System.out.print("max calories: " +caloriesMax);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

}