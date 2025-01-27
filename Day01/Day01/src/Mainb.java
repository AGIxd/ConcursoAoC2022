import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
public class Mainb {
    /* Proceso de desestructurar el problema:
     * Leer el archivo línea por línea
                Esto conlleva lo siguiente:
                * Sumar todos los números hasta encontrar un salto de línea
                * Comparamos con las variables max1, max2 y max3.
     * Crear tres variables llamadas max1, max2 y max3.
     * Bucle for:
            * Si la siguiente posición es mayor que max1, max2 y/o max3, reordenador max1, max2, max3 a sus respectivas nuevas posiciones
     * Devolver max1+max2+max3
     * :)
     */

    public static void main(String[] args) {
        int caloriesMax1 = 0, caloriesMax2 = 0, caloriesMax3 = 0, calories = 0;
        try {
            List<String> allLines = Files.readAllLines(Paths.get("input.txt"));
            for (String line : allLines) {
                if(line.length() == 0){
                    if(calories >= caloriesMax1 ){
                        caloriesMax3 = caloriesMax2;
                        caloriesMax2 = caloriesMax1;
                        caloriesMax1 = calories;
                    }
                    else if(calories >= caloriesMax2 ){
                        caloriesMax3 = caloriesMax2;
                        caloriesMax2 = calories;
                    }
                    else if(calories >= caloriesMax3 ){
                        caloriesMax3 = calories;
                    }
                    calories = 0;

                }
                else{
                    calories += Integer.parseInt(line);
                }
            }
            System.out.print("Max calories: " +(caloriesMax1 + caloriesMax2 + caloriesMax3));
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    /*
    public static void main(String[] args) {

        try {
            List<String> allLines = Files.readAllLines(Paths.get("input.txt"));
            int sum = 0;
            int max = 0;
            for (String line : allLines) {
                if (line.length() == 0) {
                    if (sum > max) {
                        max = sum;
                    }
                    sum = 0;
                }else {
                    int number = Integer.parseInt(line);
                    sum = sum + number;
                }
            }
            if (sum > max) {
                max = sum;
            }
            int max1 = max;
            sum = 0;
            max = 0;
            for (String line : allLines) {
                if (line.length() == 0) {
                    if (sum > max) {
                        if (sum != max1) {
                            max = sum;
                        }
                    }
                    sum = 0;
                }else {
                    int number = Integer.parseInt(line);
                    sum = sum + number;
                }
            }
            if (sum > max) {
                max = sum;
            }
            int max2 = max;
            sum = 0;
            max = 0;
            for (String line : allLines) {
                if (line.length() == 0) {
                    if (sum > max) {
                        if (sum != max1 && sum != max2) {
                            max = sum;
                        }
                    }
                    sum = 0;
                }else {
                    int number = Integer.parseInt(line);
                    sum = sum + number;
                }
            }
            if (sum > max) {
                max = sum;
            }
            int max3 = max;
            int total = max1 + max2 + max3;
            System.out.println("The result is " + total + " calories! ");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     */

}